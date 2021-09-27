package rrs;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Splash_Panel extends JPanel {
    private PanelChange win;
	/**
	 * Create the panel.
	 */
	public Splash_Panel(PanelChange win,DB db) {
		this.win = win;
		setBackground(new Color(255, 192, 203));
		setLayout(null);
		
		ImageIcon ii = new ImageIcon(PanelChange.class.getResource("../image/logo.png"));
		JLabel il = new JLabel(ii);
		il.setBounds(84,88,190,182);
		add(il);
		
		JLabel lblNewLabel = new JLabel("Restaurant");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel.setBounds(109, 282, 178, 34);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Reservation");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel_1.setBounds(109, 328, 178, 34);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("System");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(109, 374, 130, 27);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("By. Yerim Jin");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(144, 528, 92, 18);
		add(lblNewLabel_3);
		
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				win.change("Login_Panel");
			}
		});
		btnNewButton.setBounds(249, 461, 73, 56);
		add(btnNewButton);

		
		
	}
}
