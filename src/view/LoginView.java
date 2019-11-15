package view;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;
import com.mysql.cj.xdevapi.JsonArray;

import APIfunction.FaceSearch;
import DBManager.DBhelper;
import facedb.face_db;
import infordb.UserDBUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class LoginView {
	public Color c1,c2,c3,colorWord,backgroundColor;
	public JLabel label_login_studentNumber,label_login_password,label12,label_login_name,label7;
	public Border border1,border2;
	public JTextField pane_1,pane2;
	public JButton button_login_picture,button2 ;
	public WebcamPanel panel_login_webcam_pane;
	public JPasswordField jpw_login_password;
	public String token1,token2,password,person;
	public char[] p;
	public LoginView(JFrame jf,JLabel label3) {
        c1 = new Color(10, 200, 255);
		c2 = new Color(255, 120, 120);
        c3=new Color(150,50,50);
        backgroundColor = new Color(51,198,252);
        colorWord = new Color(91,90,90);

        border1 = BorderFactory.createLineBorder(c2, 7);
        
        final Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(WebcamResolution.VGA.getSize());
 
		panel_login_webcam_pane = new WebcamPanel(webcam);
        panel_login_webcam_pane.setBounds((int) (0.20 * Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int) (0.25 * Toolkit.getDefaultToolkit().getScreenSize().height), 
        		(int) (0.55 * Toolkit.getDefaultToolkit().getScreenSize().height), 
        		(int) (0.42 * Toolkit.getDefaultToolkit().getScreenSize().height));
        panel_login_webcam_pane.setBorder(border1);

        label_login_name=new JLabel("姓名：");
        label_login_name.setFont(new Font("黑体",Font.BOLD,35));
        label_login_name.setBounds((int)(0.55083333*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),
        		(int)(0.12574074*Toolkit.getDefaultToolkit().getScreenSize().height*4.9),
        		(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));
        label_login_name.setForeground(colorWord);

        pane_1=new JTextField();
        pane_1.setFont(new Font("黑体",Font.BOLD,30));
        pane_1.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));
       // JScrollPane pane1=new JScrollPane(jta1);
        border2=BorderFactory.createLineBorder(c2,2,true);
        pane_1.setBorder(border2);
        pane_1.setBounds((int)(0.6159375*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),
        		(int)(0.12574074*Toolkit.getDefaultToolkit().getScreenSize().height*4.9),
        		pane_1.getWidth()-1,
        		pane_1.getHeight()+1);

        label_login_password=new JLabel("密码：");
        label_login_password.setFont(new Font("黑体",Font.BOLD,35));
        label_login_password.setBounds((int)(0.19*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.12574074*Toolkit.getDefaultToolkit().getScreenSize().height*5.7),
        		(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));

        jpw_login_password=new JPasswordField();
        jpw_login_password.setFont(new Font("宋体",Font.BOLD,30));
        jpw_login_password.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),
        					(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));
        // JScrollPane pane1=new JScrollPane(jta1);
       // Border border2=BorderFactory.createLineBorder(c2,2,true);
        jpw_login_password.setBorder(border2);
        //pane1.add(jta1);
        jpw_login_password.setBounds((int)(0.25*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.12574074*Toolkit.getDefaultToolkit().getScreenSize().height*5.7),
        		pane_1.getWidth()-1,
        		pane_1.getHeight()+1);
		
        ImageIcon icon = new ImageIcon("img/photograph.png");
        button_login_picture=new JButton(icon);
        //button1.setFont(new Font("黑体",Font.BOLD,30));
        button_login_picture.setBounds((int)(0.4*Toolkit.getDefaultToolkit().getScreenSize().width+5),
        		(int)(0.12574074*Toolkit.getDefaultToolkit().getScreenSize().height*5.7),
        		icon.getIconWidth()-6,
        		icon.getIconHeight()-6);


        label_login_studentNumber=new JLabel("学号：");
        label_login_studentNumber.setFont(new Font("黑体",Font.BOLD,35));
        label_login_studentNumber.setBounds((int)(0.55083333*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),
        		(int)(0.12574074*Toolkit.getDefaultToolkit().getScreenSize().height*5.7),
        		(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));
        label_login_studentNumber.setForeground(colorWord);
        
        
        pane2=new JTextField();
        pane2.setFont(new Font("宋体",Font.BOLD,35));
        pane2.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));
        pane2.setBorder(border2);
        //JScrollPane pane2=new JScrollPane();
        //pane2.add(jta2);
        pane2.setBounds((int)(0.6159375*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),
        		(int)(0.12574074*Toolkit.getDefaultToolkit().getScreenSize().height*5.7),
        		pane2.getWidth()-1,
        		pane2.getHeight()+1);
    
        label7=new JLabel();
        label7.setBorder(border2);
        label7.setBounds((int)(0.66*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.25*Toolkit.getDefaultToolkit().getScreenSize().height),
        		(int)(0.12*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.25));

        
		button_login_picture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{ 
				button_login_picture.setEnabled(false);  //设置按钮不可点击
 
				
				//实现拍照保存-------start
				String fileName = "picture/" + System.currentTimeMillis();       //保存路径即图片名称（不用加后缀
				WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_JPG);
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run()
					{
						File fp=new File(fileName+".jpg");//亮亮亮
						try {
							FaceSearch fs = new FaceSearch(fp);
							int confi=fs.getcon();
							token1=fs.gettoken();
							if(token1.equals("none")) {
								JOptionPane.showConfirmDialog (null,"请调整坐姿和光照重新拍照","登陆",JOptionPane.YES_NO_CANCEL_OPTION);
								jpw_login_password.setText("");
								button_login_picture.setEnabled(true);
							}
							if(confi>30) {
								DBhelper db=new DBhelper();
								face_db fc=new face_db();
								String id=fc.compare_token(token1);
								p=jpw_login_password.getPassword();
								password=String.valueOf(p);
								UserDBUtil uti=new UserDBUtil();
								token2=uti.getStuIdByPwd(password)+"";
								person=uti.getStuNmByPwd(password);
								if(id.equals(token2)) {
									String url=fc.getStuphById(id);
									System.out.println(url);
									ImageIcon icon = new ImageIcon(url);
									icon.setImage(icon.getImage().getScaledInstance((int)(0.12*Toolkit.getDefaultToolkit().getScreenSize().width),
							        		(int)(Toolkit.getDefaultToolkit().getScreenSize().height*0.25),Image.SCALE_DEFAULT));									label7.setIcon(icon);
									pane2.setText(" "+id);
									pane_1.setText(" "+person);									
									int isDelete =JOptionPane.showConfirmDialog (null,person+ "登录成功","登陆",JOptionPane.YES_NO_CANCEL_OPTION);
									System.out.println(isDelete);
									System.out.println(JOptionPane.YES_OPTION);
									if(isDelete==JOptionPane.YES_OPTION) {
										webcam.close();
										ScanView sc = new ScanView(jf,label3,id);
										label3.setBackground(c1);
										jf.remove(panel_login_webcam_pane);
						                jf.remove(pane_1);
						                jf.remove(label7);
						                jf.remove(label_login_studentNumber);
						                jf.remove(pane2);
						                jf.remove(label_login_password);
						                jf.remove(label_login_name);
						                jf.remove(jpw_login_password);
						                jf.remove(button_login_picture);
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
								}
									else {
										JOptionPane.showConfirmDialog (null, "登录失败","登陆",JOptionPane.YES_NO_CANCEL_OPTION);
										jpw_login_password.setText("");
										button_login_picture.setEnabled(true);
									}
							}

						} catch (Exception t) {
							// TODO Auto-generated catch block
							t.printStackTrace();
						}
					}
				});
				//实现拍照保存-------end
			}
		});
	}
}
