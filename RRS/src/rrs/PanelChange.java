package rrs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class PanelChange extends JFrame{
	static String id=null;
	private Reservation_Info ri = new Reservation_Info();
    public Splash_Panel jpanel00 = null;
    public Login_Panel jpanel01 = null;
    public Join_Panel jpanel02 = null;
    public C_Init_Panel jpanel03 = null;
    public C_PickMenu_Panel jpanel04 = null;
    public C_PickWhen_Panel jpanel05 = null;
    public C_PickTime_Panel jpanel06 = null;
    public C_CheckReserv_Panel jpanel07 = null;
    
    public M_Init_Panel jpanel08 = null;
    public M_AddRestaurant_Panel jpanel09 = null;
    
    static PanelChange win = new PanelChange();
    static DB db = new DB();
    
    void setRI(Reservation_Info ri) {
    	this.ri=ri;
    }
    Reservation_Info getRI() {
    	return ri;
    }
    
    public void change(String panelName){        // 패널 변경 후 재설정
        
        if(panelName.equals("Login_Panel")){
            win.jpanel01 = new Login_Panel(win,db);
            getContentPane().removeAll();
            getContentPane().add(jpanel01);
            revalidate();
            repaint();
        }
        else if(panelName.equals("Join_Panel")) {
            win.jpanel02 = new Join_Panel(win,db);
            getContentPane().removeAll();
            getContentPane().add(jpanel02);
            revalidate();
            repaint();
        }
        else if(panelName.equals("C_Init_Panel")){
            win.jpanel03 = new C_Init_Panel(win,db,id);
            getContentPane().removeAll();
            getContentPane().add(jpanel03);
            revalidate();
            repaint();
        }
        else if(panelName.equals("C_CheckReserv_Panel")){
            win.jpanel07 = new C_CheckReserv_Panel(win,db,id);
            getContentPane().removeAll();
            getContentPane().add(jpanel07);
            revalidate();
            repaint();
        }
        else if(panelName.equals("M_AddRestaurant_Panel")) {
            win.jpanel09 = new M_AddRestaurant_Panel(win,db);
            getContentPane().removeAll();
            getContentPane().add(jpanel09);
            revalidate();
            repaint();
        }
        else if(panelName.equals("M_Init_Panel")) {
            win.jpanel08 = new M_Init_Panel(win,db);
            getContentPane().removeAll();
            getContentPane().add(jpanel08);
            revalidate();
            repaint();
        }
    }
    
    public void change(String panelName, String id) {
    	this.id=id;
        if(panelName.equals("C_Init_Panel")){
            win.jpanel03 = new C_Init_Panel(win,db,id);
            getContentPane().removeAll();
            getContentPane().add(jpanel03);
            revalidate();
            repaint();
        }
    }
    
    public void change(String panelName, Reservation_Info ri) {
    	setRI(ri);
        if(panelName.equals("C_PickMenu_Panel")) {
            win.jpanel04 = new C_PickMenu_Panel(win,db,win.getRI());
            getContentPane().removeAll();
            getContentPane().add(jpanel04);
            revalidate();
            repaint();
        }
        else if(panelName.equals("C_PickWhen_Panel")) {
        	win.jpanel05 = new C_PickWhen_Panel(win,db,win.getRI());
            getContentPane().removeAll();
            getContentPane().add(jpanel05);
            revalidate();
            repaint();
        }
        else if(panelName.equals("C_PickTime_Panel")) {
        	win.jpanel06 = new C_PickTime_Panel(win,db,win.getRI());
            getContentPane().removeAll();
            getContentPane().add(jpanel06);
            revalidate();
            repaint();
        }
    	
    }
    
    public static void main(String[] args) {
        
        win.setTitle("Restaurant Reservation System @_yerim");
        win.jpanel00 = new Splash_Panel(win,db);

        win.add(win.jpanel00);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setSize(370,600);
        win.setLocation(600,200);
        win.setVisible(true);    
    }
}