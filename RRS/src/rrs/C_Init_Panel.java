package rrs;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class C_Init_Panel extends JPanel {
	private String s=null;
	
	String getS() {
		return s;
	}

	/**
	 * Create the panel.
	 */
	public C_Init_Panel(PanelChange win, DB db,String id) {
		setBackground(new Color(255, 228, 225));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 370, 53);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("RESTAURANT");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC608\uC57D\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("C_CheckReserv_Panel");
			}
		});
		btnNewButton.setBounds(220, 481, 118, 60);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.PINK);
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
			b[i].setBackground(Color.PINK);
			add(b[i]);
			b[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton d = (JButton)e.getSource();
					s = d.getText();
					Reservation_Info ri = new Reservation_Info();
					ri.setCustomerPhoneNumber(id);
					ri.setRestaurantName(s);

					win.change("C_PickMenu_Panel",ri);
				}
			});
		}
	}

}
