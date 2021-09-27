package rrs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_CheckReserv_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public C_CheckReserv_Panel(PanelChange win,DB db,String id) {
		Alarm_Dialog ad = new Alarm_Dialog();
		Calendar cal = Calendar.getInstance();
		setBackground(new Color(255, 228, 225));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(0, 0, 370, 53);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("My Reservation");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 27));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC774\uC804");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				win.change("C_Init_Panel");
			}
		});
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		btnNewButton.setBounds(28, 467, 102, 51);
		add(btnNewButton);
		
		ArrayList<Reservation_Info> arr = new ArrayList<>();
		int n = db.searchMyReservation(id).size();
		JLabel l[] = new JLabel[n];
		JButton b[] = new JButton[n];
		for(int i=0;i<n;i++) {
			arr.add(db.searchMyReservation(id).get(i));
			String s = "<html>"+arr.get(i).getReservationNumber()+"<br>"+arr.get(i).getRestaurantName()+" À½½ÄÁ¡<br>(";
			if(arr.get(i).getNowOrLater()==1) s+="NOW)</hrml>";
			else {
				int month = cal.get(Calendar.MONTH)+1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				if(arr.get(i).getDay()==1) s+=month+"/"+day;
				else s+=month+"/"+(day+1);
				s+=", "+arr.get(i).getTime()+":00)</html>";
			}
			l[i]=new JLabel(s);
			l[i].setOpaque(true);
			l[i].setBackground(Color.WHITE);
			l[i].setBounds(30,100+80*i,200,50);
			add(l[i]);
			b[i]=new JButton("Ãë¼Ò");
			b[i].setOpaque(true);
			b[i].setBackground(Color.PINK);
			b[i].setBounds(230, 100+80*i, 70, 50);
			b[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					int index=-1;
					for(int i=0; i<n;i++) {
						if(b.getLocation().getY()==100+80*i) {index=i; break;}
					}
					if(arr.get(index).getNowOrLater()==1) ad.impossibleCancel();
					else {
						int x = ad.askCancel();
						if(x==0) {
							db.deleteReservation(arr.get(index).getReservationNumber());
						}
						repaint();
						win.change("C_CheckReserv_Panel");
					}

				}
			});
			add(b[i]);
		}
	}
}
