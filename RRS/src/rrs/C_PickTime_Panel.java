package rrs;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class C_PickTime_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public C_PickTime_Panel(PanelChange win, DB db, Reservation_Info ri) {
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
		
		ButtonGroup g = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\uC624\uB298");
		rdbtnNewRadioButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton.setBounds(98, 155, 83, 27);

		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uB0B4\uC77C");
		rdbtnNewRadioButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		rdbtnNewRadioButton_1.setBackground(new Color(255, 228, 225));
		rdbtnNewRadioButton_1.setBounds(201, 155, 83, 27);

		
		g.add(rdbtnNewRadioButton);
		g.add(rdbtnNewRadioButton_1);
		add(rdbtnNewRadioButton);
		add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uC2DC\uAC04");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_1.setBounds(98, 232, 56, 27);
		add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setOpaque(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00"}));
		comboBox.setBounds(161, 237, 110, 24);
		add(comboBox);
		
		JButton btnNewButton = new JButton("\uC608\uC57D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()==true) {
					Calendar cal = Calendar.getInstance();
					int h = cal.get(Calendar.HOUR);
					if(comboBox.getSelectedIndex()+12<=h+12) {
						ad.checkTime();
					}
					else {
						ri.setDay(1);
						ri.setTime(comboBox.getSelectedIndex()+12);
						db.addReservation(ri);
						ad.completeReservation();
						win.change("C_Init_Panel");
					}
				}
				else {
					ri.setDay(2);
					ri.setTime(comboBox.getSelectedIndex()+12);
					db.addReservation(ri);
					ad.completeReservation();
					win.change("C_Init_Panel");
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 25));
		btnNewButton.setBounds(126, 430, 105, 60);
		add(btnNewButton);
		
	}
}
