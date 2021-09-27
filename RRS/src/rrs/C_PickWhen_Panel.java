package rrs;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class C_PickWhen_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public C_PickWhen_Panel(PanelChange win, DB db, Reservation_Info ri) {
		Alarm_Dialog ad = new Alarm_Dialog();
		
		setBackground(new Color(255, 228, 225));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 370, 53);
		add(panel);
		
		JLabel lblNewLabel = new JLabel(ri.getRestaurantName());
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("NOW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ri.setNow_or_later(1);
				ri.setReservationNumber((int)(Math.random()*1000000));
				db.addReservation(ri);
				ad.completeReservation();
				win.change("C_Init_Panel");
			}
		});
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		btnNewButton.setBounds(115, 143, 143, 100);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LATER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ri.setNow_or_later(2);
				ri.setReservationNumber((int)(Math.random()*1000000));
				win.change("C_PickTime_Panel",ri);
			}
		});
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(115, 291, 143, 100);
		add(btnNewButton_1);

	}
}
