package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InitialView {
	public ImageIcon icon_initial_logo,icon_initial_borrow_button,icon_initial_return_button;
	public JLabel label_icon_initial_logo,label_icon_initial_borrow_button,label_icon_initial_return_button,label_initial_2019;
	public Color c1,c2,c3,c4;
	public InitialView(JFrame jf,JLabel label_initial_title) {
		c1 = new Color(10, 200, 255);
		c2 = new Color(255, 120, 120);
        c3=new Color(150,50,50);
        c4  = new Color(104,103,103);

        icon_initial_logo = new ImageIcon("img/logo.png");
        label_icon_initial_logo = new JLabel(icon_initial_logo);
        icon_initial_logo.setImage(icon_initial_logo.getImage().getScaledInstance((int) (0.8 * icon_initial_logo.getIconWidth()), (int) (0.8 * icon_initial_logo.getIconHeight()), Image.SCALE_DEFAULT));
        label_icon_initial_logo.setBounds((int) (0.8 * Toolkit.getDefaultToolkit().getScreenSize().width), (int) (0.07 * Toolkit.getDefaultToolkit().getScreenSize().height), icon_initial_logo.getIconWidth(), icon_initial_logo.getIconHeight());
        jf.add(label_icon_initial_logo);

       
        icon_initial_borrow_button = new ImageIcon("img/borrow_button.png");
        label_icon_initial_borrow_button = new JLabel(icon_initial_borrow_button);
        icon_initial_borrow_button.setImage(icon_initial_borrow_button.getImage().getScaledInstance((int) (0.9* icon_initial_borrow_button.getIconWidth()), 
        		(int) (0.9*icon_initial_borrow_button.getIconHeight()), 
        		Image.SCALE_DEFAULT));
        int width_icon_borrow_button=(int)(icon_initial_borrow_button.getIconWidth());
        int height_icon_borrow_button= (int) ( icon_initial_borrow_button.getIconHeight());
       
        label_icon_initial_borrow_button.setBounds((int) (0.22 * Toolkit.getDefaultToolkit().getScreenSize().width), 
        		(int) (0.11574074 * Toolkit.getDefaultToolkit().getScreenSize().height * 2.7),
        		icon_initial_borrow_button.getIconWidth(),
        		icon_initial_borrow_button.getIconHeight());        label_icon_initial_borrow_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                icon_initial_borrow_button.setImage(icon_initial_borrow_button.getImage().getScaledInstance((int)(1.02*width_icon_borrow_button),(int)(1.02*height_icon_borrow_button), Image.SCALE_DEFAULT));
                jf.repaint();
            }
            public void mouseExited(MouseEvent e) {
                icon_initial_borrow_button.setImage(icon_initial_borrow_button.getImage().getScaledInstance(width_icon_borrow_button,height_icon_borrow_button, Image.SCALE_DEFAULT));
                jf.repaint();
            }
        });
        jf.add(label_icon_initial_borrow_button);

       
        
        
        c1 = new Color(10, 200, 255);
        label_initial_title.setBackground(c1);
        jf.add(label_initial_title);

        icon_initial_return_button = new ImageIcon("img/return_button.png");
        label_icon_initial_return_button = new JLabel(icon_initial_return_button);
        icon_initial_return_button.setImage(icon_initial_return_button.getImage().getScaledInstance((int) (0.9*icon_initial_return_button.getIconWidth()),
        		(int) (0.9*icon_initial_return_button.getIconHeight()), 
        		Image.SCALE_DEFAULT));       
        label_icon_initial_return_button.setBounds((int) (0.58 * Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int) (0.115 * Toolkit.getDefaultToolkit().getScreenSize().height * 2.7),
        		icon_initial_return_button.getIconWidth(), 
        		icon_initial_return_button.getIconHeight());       
        
        jf.add(label_icon_initial_return_button);

        
        
        int width_icon_initial_button=icon_initial_return_button.getIconWidth();
        int height_icon_initial_button=icon_initial_return_button.getIconHeight();
        label_icon_initial_return_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                icon_initial_return_button.setImage(icon_initial_return_button.getImage().getScaledInstance((int)(1.02*width_icon_borrow_button),(int)(1.02*height_icon_borrow_button), Image.SCALE_DEFAULT));
                jf.repaint();
            }
            public void mouseExited(MouseEvent e) {
                icon_initial_return_button.setImage(icon_initial_return_button.getImage().getScaledInstance(width_icon_initial_button,height_icon_initial_button, Image.SCALE_DEFAULT));
                jf.repaint();
            }
        });

        label_initial_2019 = new JLabel("@2019,四川大学图书馆");
        label_initial_2019.setFont(new Font("黑体", Font.BOLD, 30));
        label_initial_2019.setForeground(c4);
        label_initial_2019.setBounds((int) (0.4 * Toolkit.getDefaultToolkit().getScreenSize().width), 
        		(int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.80), 
        		(int) (0.3 * Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.1));
                jf.add(label_initial_2019);

        label_icon_initial_borrow_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                LoginView l1=new LoginView(jf,label_initial_title);
                label_initial_title.setBackground(c2);
                jf.remove(label_icon_initial_borrow_button);
                jf.remove(label_icon_initial_return_button);
                jf.add(l1.panel_login_webcam_pane);
                jf.add(l1.pane_1);
                jf.add(l1.label7);
                jf.add(l1.label_login_studentNumber);
                jf.add(l1.pane2);
                jf.add(l1.label_login_password);
                jf.add(l1.label_login_name);
                jf.add(l1.jpw_login_password);
                jf.add(l1.button_login_picture);

                jf.repaint();
            }
        });
	}
	
}
