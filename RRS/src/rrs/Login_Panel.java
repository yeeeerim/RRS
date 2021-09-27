package rrs;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;

public class Login_Panel extends JPanel {
	private JTextField textField;
	private JTextField passwordField;
    private PanelChange win;

	/**
	 * Create the panel.
	 */
	public Login_Panel(PanelChange win,DB db) {
		this.win = win;
		setBackground(new Color(255, 228, 225));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel.setBounds(85, 263, 36, 33);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel_1.setBounds(65, 308, 56, 24);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(135, 264, 141, 24);
		add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Welcome!");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		lblNewLabel_2.setForeground(new Color(255, 105, 180));
		lblNewLabel_2.setBounds(110, 188, 152, 41);
		add(lblNewLabel_2);
		
		passwordField = new JTextField();
		passwordField.setBounds(135, 308, 141, 24);
		add(passwordField);

		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String pw = passwordField.getText();
				if(id.length()==0||pw.length()==0) new Alarm_Dialog().empty();
				else if(db.isExist(id,pw)) {
					if(id.equals("manager1")&&pw.equals("manager1")) win.change("M_Init_Panel");
					else win.change("C_Init_Panel",id);
				}
				else new Alarm_Dialog().non_existing();
			}
		});
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton.setBounds(72, 371, 91, 47);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Join");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("Join_Panel");
			}
		});
	    
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(211, 371, 91, 47);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBackground(Color.PINK);
		add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 370, 53);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		panel.add(lblNewLabel_3);
		


	}
}
