package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class viewwindows {
	public static JFrame jf;
	public static JLabel label_initial_title;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jf= new JFrame("�Ĵ���ѧ����ʶ����������ϵͳ");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icon = Toolkit.getDefaultToolkit().getImage("img/title.png");  // ͼƬ�ľ���λ��
		jf.setIconImage(icon);   //���ô��ڵ�logo

        label_initial_title = new JLabel("   ͼ�����������ϵͳ"); 
        label_initial_title.setFont(new Font("����", Font.BOLD, 50));
        label_initial_title.setForeground(Color.white);
        label_initial_title.setBounds(0, 0, (int) (Toolkit.getDefaultToolkit().getScreenSize().width), (int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.2));
        label_initial_title.setOpaque(true);
        
		InitialView i1=new InitialView(jf,label_initial_title);
	}
}
