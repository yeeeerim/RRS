package rrs;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class C_PickMenu_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public C_PickMenu_Panel(PanelChange win, DB db,Reservation_Info ri) {
		Alarm_Dialog ad = new Alarm_Dialog();
		
		String s = ri.getRestaurantName(); // 현재 선택된 음식점 이름 저장
		
		Restaurant r = db.getRestaurant(s); // 현재 선택된 음식점 객체 가져오기
		
		ArrayList<Food> fl = new ArrayList<>();
		fl = r.getFoodList();
		ArrayList<Food> fl2 = new ArrayList<>();
		JComboBox comboBox[] = new JComboBox[fl.size()];
		
		for(int i=0; i<fl.size();i++) {
			comboBox[i] = new JComboBox();
			comboBox[i].setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
			comboBox[i].setMaximumRowCount(6);
			comboBox[i].setBounds(200, 100+50*i, 55, 30);
			comboBox[i].setOpaque(true);
			comboBox[i].setBackground(Color.white);
			add(comboBox[i]);
		}
		
		
		JLabel[] b = new JLabel[fl.size()];
		for(int i=0;i<fl.size();i++) {
			fl2.add(fl.get(i));
			b[i] = new JLabel("  "+fl2.get(i).getName()+" ("+fl2.get(i).getPrice()+" won)");
		}
		
		for(int i=0;i<fl2.size();i++) {
			b[i].setBounds(30,100+50*i,150,30);
			b[i].setOpaque(true);
			b[i].setBackground(Color.WHITE);
			add(b[i]);
		}
		
		
		setBackground(new Color(255, 228, 225));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 370, 53);
		add(panel);
		
		JLabel lblNewLabel = new JLabel(s);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC608\uC0C1\uC870\uB9AC\uC2DC\uAC04");
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum=0;
				for(int i=0; i<fl2.size();i++) {
					if (comboBox[i].getSelectedIndex()<=1)
						sum+=fl2.get(i).getCookTime()*comboBox[i].getSelectedIndex();
					else {
						sum+=fl2.get(i).getCookTime();
						sum+=(fl2.get(i).getCookTime()*(comboBox[i].getSelectedIndex()-1))/2;
					}
				}
				if(sum==0) ad.checkQuantity();
				else ad.cookTime(sum);
			}
		});
		btnNewButton.setBounds(109, 427, 151, 41);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC608\uC57D");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int arr[] = new int[fl2.size()];
				boolean cnt = false;
				for(int i=0; i<fl2.size();i++) {
					arr[i] = comboBox[i].getSelectedIndex();
					if(arr[i]>0) cnt=true;
				}
				if(!cnt) ad.checkQuantity();
				else {
					ri.setFood_cnt(arr);
					win.change("C_PickWhen_Panel", ri);
				}
			}
		});
		btnNewButton_1.setBounds(131, 495, 112, 41);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBackground(Color.PINK);
		add(btnNewButton_1);
		
		
	}
}
