package rrs;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Join_Panel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
    private PanelChange win;
    Alarm_Dialog ad = new Alarm_Dialog();

	int flag = 0;

	/**
	 * Create the panel.
	 */
	public Join_Panel(PanelChange win,DB db) {
		this.win = win;
		setBackground(new Color(255, 228, 225));
		setLayout(null);
		
		ImageIcon ii = 	new ImageIcon(Join_Panel.class.getResource("../image/join.png"));
		JLabel il = new JLabel(ii);
		il.setBounds(124,129,109,101);
		add(il);
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		lblNewLabel.setBounds(83, 258, 44, 24);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		lblNewLabel_1.setBounds(39, 294, 88, 24);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 22));
		lblNewLabel_2.setBounds(39, 330, 95, 24);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(144, 258, 116, 24);
		add(textField);
		textField.setColumns(10);

		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 294, 116, 24);
		add(textField_1);
		textField_1.setColumns(10);

		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 330, 116, 24);
		add(textField_2);
		textField_2.setColumns(10);

		
		JLabel lblNewLabel_3 = new JLabel("'-'\uB294 \uC81C\uC678\uD558\uACE0 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		lblNewLabel_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(66, 394, 233, 18);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\uC911\uBCF5\r\n\uD655\uC778");
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pn = textField_2.getText();

				if(db.searchCustomer(pn)) { //¸¸¾à DB¿¡ ¾øÀ¸¸é
					ad.successCheck();
					flag=1;
				}
				else {
					ad.failCheck();
					flag=0;
				}
			}
		});
		btnNewButton.setBounds(268, 330, 88, 24);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC644\uB8CC");
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String pw = textField_1.getText();
				String pn = textField_2.getText();
				if(name.length()==0||pw.length()==0||pn.length()==0) ad.empty();
				else if(flag==0) {
					ad.checkDuplication();
				}
				else {
					db.addCustomer(new Customer(pn,pw,name));
					win.change("Login_Panel");
				}
			}
		});
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		btnNewButton_1.setBounds(144, 477, 72, 56);
		add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 370, 53);
		add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("JOIN");
		lblNewLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_4);

	}

}
