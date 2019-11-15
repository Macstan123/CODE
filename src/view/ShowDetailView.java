package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import infordb.BookDBUtil;


public class ShowDetailView {
	public ImageIcon icon_show_continue_borrow,icon_show_return_main;
	public JLabel label_show_book_information,label_icon_show_continue_borrow,label_icon_show_return_main;
	public Color c3,c2,c1;
	public Border border2;
	public JTextField jta_show_book_name,jta_show_already_borrowed;
	public JScrollPane pane_jta_show_book_name,pane_jta_show_already_borrowed;
	public Border border_white;
	public String books_id[]=new String[3],names[]=new String[3],txtnames;
	public ShowDetailView(JFrame jf,JLabel label3,String user_id) {
		c1 = new Color(10, 200, 255);
        c3=new Color(150,50,50);
		c2 = new Color(255, 120, 120);

	    Border border_white=BorderFactory.createLineBorder(Color.white,1,true);
		jta_show_book_name=new JTextField();
        jta_show_book_name.setOpaque(true);
        jta_show_book_name.setEditable(false);
        jta_show_book_name.setBackground(Color.white);
        jta_show_book_name.setBorder(border_white);
        jta_show_book_name.setFont(new Font("黑体",Font.BOLD,20));
        jta_show_book_name.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*5)+250,(int)(0.06*Toolkit.getDefaultToolkit().getScreenSize().height));
        pane_jta_show_book_name=new JScrollPane(jta_show_book_name);
        //jta4.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)+jta3.getHeight(),(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_show_book_name.add(jta_show_book_name);
        pane_jta_show_book_name.setBounds((int)(0.2*Toolkit.getDefaultToolkit().getScreenSize().width),(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height),jta_show_book_name.getWidth(),jta_show_book_name.getHeight());

        jta_show_already_borrowed=new JTextField("√ 已借阅");
        jta_show_already_borrowed.setOpaque(true);
        jta_show_already_borrowed.setEditable(false);
        jta_show_already_borrowed.setBorder(border_white);
        jta_show_already_borrowed.setBackground(Color.white);
        jta_show_already_borrowed.setFont(new Font("黑体",Font.BOLD,33));
        jta_show_already_borrowed.setForeground(c3);
        jta_show_already_borrowed.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*1.5),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.4));
        pane_jta_show_already_borrowed=new JScrollPane(jta_show_already_borrowed);
        pane_jta_show_already_borrowed.add(jta_show_already_borrowed);
        pane_jta_show_already_borrowed.setBounds((int)(0.2*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+pane_jta_show_book_name.getWidth()*2-jta_show_already_borrowed.getWidth()-450,
        		(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)+10,
        		jta_show_already_borrowed.getWidth()-10,
        		jta_show_already_borrowed.getHeight());

        label_show_book_information=new JLabel();
        label_show_book_information.setBounds((int)(0.2*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)-2,
        		(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)-2,
        		pane_jta_show_book_name.getWidth()+pane_jta_show_already_borrowed.getWidth()+260,
        		pane_jta_show_book_name.getHeight()+5);
        //Border border3=BorderFactory.createLineBorder(Color.black,1,true);
        border2=BorderFactory.createLineBorder(c2,2,true);
        label_show_book_information.setBorder(border2);
        label_show_book_information.setOpaque(true);
        label_show_book_information.setBackground(Color.white);
        
        
        BookDBUtil uti=new BookDBUtil();
        books_id=uti.getBookInfoByid(user_id);
        txtnames="书本名:  ";
        int i;
        for(i = 0;i<books_id.length;++i) {
			if(books_id[i].equals("0"))break;
			names[i]=uti.getBookNmByIsbn(books_id[i]);
			txtnames=txtnames+"   "+names[i];
		}
        jta_show_book_name.setText(txtnames);       
        

        icon_show_continue_borrow = new ImageIcon("img/继续借阅.png");
        label_icon_show_continue_borrow = new JLabel(icon_show_continue_borrow);
        icon_show_continue_borrow.setImage(icon_show_continue_borrow.getImage().getScaledInstance((int) (icon_show_continue_borrow.getIconWidth()), (int) (icon_show_continue_borrow.getIconHeight()), Image.SCALE_DEFAULT));
        label_icon_show_continue_borrow.setBounds((int) (0.2 * Toolkit.getDefaultToolkit().getScreenSize().width)+100, (int) (0.45* Toolkit.getDefaultToolkit().getScreenSize().height), (int) (icon_show_continue_borrow.getIconWidth()), (int) (icon_show_continue_borrow.getIconHeight()));
        int w17=icon_show_continue_borrow.getIconWidth();
        int h17=icon_show_continue_borrow.getIconHeight();
        label_icon_show_continue_borrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                icon_show_continue_borrow.setImage(icon_show_continue_borrow.getImage().getScaledInstance((int)(1.02*w17),(int)(1.02*h17), Image.SCALE_DEFAULT));
                jf.repaint();
            }
            public void mouseExited(MouseEvent e) {
                icon_show_continue_borrow.setImage(icon_show_continue_borrow.getImage().getScaledInstance(w17,h17, Image.SCALE_DEFAULT));
                jf.repaint();
            }
        });



        icon_show_return_main = new ImageIcon("img/返回主界面.png");
        label_icon_show_return_main = new JLabel(icon_show_return_main);
        icon_show_return_main.setImage(icon_show_return_main.getImage().getScaledInstance((int) (icon_show_return_main.getIconWidth()), (int) (icon_show_return_main.getIconHeight()), Image.SCALE_DEFAULT));
        label_icon_show_return_main.setBounds((int) (0.55 * Toolkit.getDefaultToolkit().getScreenSize().width)+100, (int) (0.45 * Toolkit.getDefaultToolkit().getScreenSize().height), (int) (icon_show_return_main.getIconWidth()), (int) (icon_show_return_main.getIconHeight()));
        int w18=icon_show_return_main.getIconWidth();
        int h18=icon_show_return_main.getIconHeight();
        label_icon_show_return_main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                icon_show_return_main.setImage(icon_show_return_main.getImage().getScaledInstance((int)(1.02*w18),(int)(1.02*h18), Image.SCALE_DEFAULT));
                jf.repaint();
            }
            public void mouseExited(MouseEvent e) {
                icon_show_return_main.setImage(icon_show_return_main.getImage().getScaledInstance(w18,h18, Image.SCALE_DEFAULT));
                jf.repaint();
            }
        });
        
        label_icon_show_continue_borrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ScanView sc=new ScanView(jf,label3,user_id);
                jf.remove(pane_jta_show_book_name);
                jf.remove(pane_jta_show_already_borrowed);
                jf.remove(label_show_book_information);
                jf.remove(label_icon_show_continue_borrow);
                jf.remove(label_icon_show_return_main);
                label3.setBackground(c1);
                jf.add(sc.label_icon_scan_book);
                jf.add(sc.label_scan_tip_scam);
                jf.add(sc.label_icon_scan_button_confirm);
                jf.add(sc.pane_jta_scan_book_name1);
                jf.add(sc.pane_jta_scan_book_author1);
               
                jf.add(sc.pane_jta_scan_already_borrowed1);
                jf.add(sc.label_scan_book_information1);
                jf.add(sc.pane_jta_scan_book_name2);
                jf.add(sc.pane_jta_scan_book_author2);
                jf.add(sc.pane_jta_scan_already_borrowed2);
                jf.add(sc.label_scan_book_information2);
                jf.add(sc.pane_jta_scan_book_name3);
                jf.add(sc.pane_jta_scan_book_author3);
                jf.add(sc.pane_jta_scan_already_borrowed3);
                jf.add(sc.label_scan_book_information3);
                jf.add(sc.label_scan_code);
                jf.add(sc.jta_scan_code);
                jf.add(sc.button_scan_borrow);
             
                
                jf.repaint();
            }
        });
        label_icon_show_return_main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                InitialView i2=new InitialView(jf,label3);
                jf.remove(pane_jta_show_book_name);
                jf.remove(pane_jta_show_already_borrowed);
                jf.remove(label_show_book_information);
                jf.remove(label_icon_show_continue_borrow);
                jf.remove(label_icon_show_return_main);
                jf.add(i2.label_icon_initial_borrow_button);
                jf.add(i2.label_icon_initial_return_button);
                jf.repaint();

            }
        });
	}
}
