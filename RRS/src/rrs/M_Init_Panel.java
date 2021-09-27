package rrs;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class M_Init_Panel extends JPanel {
	/**
	 * Create the panel.
	 */
	public M_Init_Panel(PanelChange win, DB db) {
		Alarm_Dialog ad = new Alarm_Dialog();
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 368, 53);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("Restaurant");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uCD94\uAC00");
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("M_AddRestaurant_Panel");
			}
		});
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton.setBounds(246, 477, 90, 62);
		add(btnNewButton);
		
		
		ArrayList<Restaurant> rl = new ArrayList<>();
		JButton[] b = new JButton[db.getRestaurantList().size()];
		for(int i=0;i<db.getRestaurantList().size();i++) {
			rl.add(db.getRestaurantList().get(i));
			b[i] = new JButton(rl.get(i).getName());
		}
		

		
		for(int i=0;i<rl.size();i++) {
			b[i].setBounds(30,100+50*i,80,30);
			b[i].setOpaque(true);
			b[i].setBackground(Color.white);
			add(b[i]);
			b[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton d = (JButton)e.getSource();
					int x = ad.askDelete();
					if(x==0) db.deleteRestaurant(d.getText());
					win.change("M_Init_Panel");
				}
			});
		}

	}

}
