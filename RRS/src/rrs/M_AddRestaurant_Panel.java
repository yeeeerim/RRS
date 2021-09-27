package rrs;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class M_AddRestaurant_Panel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public M_AddRestaurant_Panel(PanelChange win, DB db) {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 160, 221));
		panel.setBounds(0, 0, 370, 53);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("ADD");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC74C\uC2DD\uC810 \uC774\uB984");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel_1.setBounds(124, 201, 124, 27);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(104, 245, 156, 24);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uCD94\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0) new Alarm_Dialog().empty();
				else {
					db.addRestaurant(new Restaurant(textField.getText()));
					win.change("M_Init_Panel");
				}
			}
		});
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setBounds(143, 435, 80, 69);
		add(btnNewButton);
		
	}
}
