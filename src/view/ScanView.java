package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import infordb.BookDBUtil;
import infordb.BorrowDBUtil;


public class ScanView {
	public ImageIcon icon_scan_book,icon_scan_button_confirm;
	public JLabel label_icon_scan_book,label_scan_tip_scam,label_icon_scan_button_confirm,label_scan_book_information1,label_scan_book_information2,label_scan_book_information3,label_scan_code,label_scan_borrow;
	public Color c1,c2,c3,backgroundColor,BordWordColor,LightWordColor,BorroWordColor;;
	public Border border3;
	public JTextField jta_scan_already_borrowed1,jta_scan_book_name1,jta_scan_book_author1,jta_scan_book_name2,jta_scan_book_author2,jta_scan_already_borrowed2,jta_scan_book_name3,jta_scan_book_author3,jta_scan_already_borrowed3,jta_scan_code;
	public JScrollPane pane_jta_scan_book_name1,pane_jta_scan_book_author1,pane_jta_scan_book_name2,pane_jta_scan_book_author2,pane_jta_scan_already_borrowed2,pane_jta_scan_already_borrowed1,pane_jta_scan_book_name3,pane_jta_scan_book_author3,pane_jta_scan_already_borrowed3;
	public JButton button_scan_borrow;
	public String name,author,id,books_id[];
	public int t=1;

	public ScanView(JFrame jf,JLabel label3,String user_id) {
		c1 = new Color(10, 200, 255);
		c2 = new Color(255, 120, 120);
        c3 = new Color(150,50,50);
        backgroundColor = new Color(51,198,252);
        BordWordColor = new Color(83,85,86);
        LightWordColor = new Color(110,109,109);
        BorroWordColor = new Color(150,73,43);
   
		icon_scan_book = new ImageIcon("img/Book图标.png");
        label_icon_scan_book = new JLabel(icon_scan_book);
        icon_scan_book.setImage(icon_scan_book.getImage().getScaledInstance((int) (icon_scan_book.getIconWidth()), 
        		(int) (icon_scan_book.getIconHeight()), 
        		Image.SCALE_DEFAULT));
        label_icon_scan_book.setBounds((int) (0.15 * Toolkit.getDefaultToolkit().getScreenSize().width), 
        		(int) (0.2 * Toolkit.getDefaultToolkit().getScreenSize().height),
        		(int) (icon_scan_book.getIconWidth()), 
        		(int) (icon_scan_book.getIconHeight()));

        label_scan_tip_scam=new JLabel("请 将 书 放 在 扫 描 区");
        label_scan_tip_scam.setForeground(Color.lightGray);
        label_scan_tip_scam.setFont(new Font("黑体",Font.BOLD,30));
        label_scan_tip_scam.setBounds((int)(0.165*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.47*Toolkit.getDefaultToolkit().getScreenSize().height),
        		(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.2*Toolkit.getDefaultToolkit().getScreenSize().height));
        
        label_scan_code=new JLabel("CODE: ");
        label_scan_code.setFont(new Font("黑体",Font.BOLD,30));
        label_scan_code.setForeground(BordWordColor);
        label_scan_code.setBounds((int)(0.1*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.64*Toolkit.getDefaultToolkit().getScreenSize().height),
        		(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));


        jta_scan_code=new JTextField();
        jta_scan_code.setFont(new Font("宋体",Font.BOLD,30));
        jta_scan_code.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.5));
        jta_scan_code.setForeground(BordWordColor);
        //JScrollPane pane2=new JScrollPane();
        //pane2.add(jta2);
        jta_scan_code.setBounds((int)(0.155*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.64*Toolkit.getDefaultToolkit().getScreenSize().height),
        		jta_scan_code.getWidth()-1,
        		jta_scan_code.getHeight());
        
        ImageIcon icon = new ImageIcon("img/borrow.png");
        button_scan_borrow=new JButton(icon);
        button_scan_borrow.setBounds((int)(0.31*Toolkit.getDefaultToolkit().getScreenSize().width),
        		(int)(0.64*Toolkit.getDefaultToolkit().getScreenSize().height),
        		icon.getIconWidth()-4,
        		icon.getIconHeight());
      
        
        icon_scan_button_confirm = new ImageIcon("img/确认.png");
        label_icon_scan_button_confirm = new JLabel(icon_scan_button_confirm);
        icon_scan_button_confirm.setImage(icon_scan_button_confirm.getImage().getScaledInstance((int) (0.75*icon_scan_button_confirm.getIconWidth()), 
        			(int) (0.75*icon_scan_button_confirm.getIconHeight()), Image.SCALE_DEFAULT));
        label_icon_scan_button_confirm.setBounds((int) (0.5 * Toolkit.getDefaultToolkit().getScreenSize().width),
		        		(int) (0.58 * Toolkit.getDefaultToolkit().getScreenSize().height),
		        		icon_scan_button_confirm.getIconWidth(), 
		        		icon_scan_button_confirm.getIconHeight());


        int width_icon_scan_button_confirm=icon_scan_button_confirm.getIconWidth();
        int height_icon_scan_button_confirm=icon_scan_button_confirm.getIconHeight();
    
        /////////////////////////1
        Border border_white=BorderFactory.createLineBorder(Color.white,1,true);
        jta_scan_book_name1=new JTextField("书本名");
        jta_scan_book_name1.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_book_name1.setBorder(border_white);
        jta_scan_book_name1.setSize((int)(0.06610417*Toolkit.getDefaultToolkit().getScreenSize().width*2),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_name1=new JScrollPane(jta_scan_book_name1);
        //jta4.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)+jta3.getHeight(),(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_name1.add(jta_scan_book_name1);
        pane_jta_scan_book_name1.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+8,
        		(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height),
        		jta_scan_book_name1.getWidth(),
        		jta_scan_book_name1.getHeight());

        jta_scan_book_author1=new JTextField("作者名/出版社");
        jta_scan_book_author1.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_book_author1.setForeground(Color.GRAY.brighter());
        jta_scan_book_author1.setBorder(border_white);
        jta_scan_book_author1.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),
        		(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_author1=new JScrollPane(jta_scan_book_author1);
        pane_jta_scan_book_author1.add(jta_scan_book_author1);
        pane_jta_scan_book_author1.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+12,
        		(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)+jta_scan_book_name1.getHeight(),
        		jta_scan_book_author1.getWidth(),
        		jta_scan_book_author1.getHeight());


        jta_scan_already_borrowed1=new JTextField("√ 已借阅");
        jta_scan_already_borrowed1.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_already_borrowed1.setForeground(c3);
        jta_scan_already_borrowed1.setBorder(border_white);
        jta_scan_already_borrowed1.setEnabled(false);
        jta_scan_already_borrowed1.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_already_borrowed1=new JScrollPane(jta_scan_already_borrowed1);
        pane_jta_scan_already_borrowed1.add(jta_scan_already_borrowed1);
        pane_jta_scan_already_borrowed1.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+pane_jta_scan_book_name1.getWidth()*2-jta_scan_already_borrowed1.getWidth()-10,
        		(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)+8,
        		jta_scan_already_borrowed1.getWidth(),
        		jta_scan_already_borrowed1.getHeight());


        label_scan_book_information1=new JLabel();
        label_scan_book_information1.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)-2,
        		(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)-2,
        		pane_jta_scan_book_name1.getWidth()*2,
        		pane_jta_scan_book_name1.getHeight()+pane_jta_scan_book_author1.getHeight()+5);
        border3=BorderFactory.createLineBorder(Color.black,1,true);
        label_scan_book_information1.setBorder(border3);
        label_scan_book_information1.setOpaque(true);
        label_scan_book_information1.setBackground(Color.white);
        
        //////////////////////////////2
        jta_scan_book_name2=new JTextField("书本名");
        jta_scan_book_name2.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_book_name2.setBorder(border_white);
        jta_scan_book_name2.setSize((int)(0.06610417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_name2=new JScrollPane(jta_scan_book_name2);
        //jta4.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)+jta3.getHeight(),(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_name2.add(jta_scan_book_name2);
        pane_jta_scan_book_name2.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+8,
        		(int)(0.4*Toolkit.getDefaultToolkit().getScreenSize().height),
        		jta_scan_book_name1.getWidth(),
        		jta_scan_book_name1.getHeight());

        jta_scan_book_author2=new JTextField("作者名/出版社");
        jta_scan_book_author2.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_book_author2.setBorder(border_white);
        jta_scan_book_author2.setForeground(Color.GRAY.brighter());
        jta_scan_book_author2.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_author2=new JScrollPane(jta_scan_book_author2);
        pane_jta_scan_book_author2.add(jta_scan_book_author2);
        pane_jta_scan_book_author2.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+12,
        		(int)(0.4*Toolkit.getDefaultToolkit().getScreenSize().height)+jta_scan_book_name1.getHeight(),
        		jta_scan_book_author1.getWidth(),
        		jta_scan_book_author1.getHeight());

        jta_scan_already_borrowed2=new JTextField("√ 已借阅");
        jta_scan_already_borrowed2.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_already_borrowed2.setForeground(c3);
        jta_scan_already_borrowed2.setBorder(border_white);
        jta_scan_already_borrowed2.setEnabled(false);
        jta_scan_already_borrowed2.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_already_borrowed2=new JScrollPane(jta_scan_already_borrowed2);
        pane_jta_scan_already_borrowed2.add(jta_scan_already_borrowed2);
        pane_jta_scan_already_borrowed2.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+pane_jta_scan_book_name1.getWidth()*2-jta_scan_already_borrowed1.getWidth()-10,
        		(int)(0.4*Toolkit.getDefaultToolkit().getScreenSize().height)+8,
        		jta_scan_already_borrowed1.getWidth(),
        		jta_scan_already_borrowed1.getHeight());


        label_scan_book_information2=new JLabel();
        label_scan_book_information2.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)-2,
        		(int)(0.4*Toolkit.getDefaultToolkit().getScreenSize().height)-2,
        		pane_jta_scan_book_name1.getWidth()*2,
        		pane_jta_scan_book_name1.getHeight()+pane_jta_scan_book_author1.getHeight()+5);
        //Border border3=BorderFactory.createLineBorder(Color.black,1,true);
        label_scan_book_information2.setBorder(border3);
        label_scan_book_information2.setOpaque(true);
        label_scan_book_information2.setBackground(Color.white);
        
        /////////////////////////////////3
        jta_scan_book_name3=new JTextField("书本名");
        jta_scan_book_name3.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_book_name3.setBorder(border_white);
        jta_scan_book_name3.setSize((int)(0.06610417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_name3=new JScrollPane(jta_scan_book_name3);
   
        //jta4.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*1.07),(int)(0.3*Toolkit.getDefaultToolkit().getScreenSize().height)+jta3.getHeight(),(int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_name3.add(jta_scan_book_name3);
        pane_jta_scan_book_name3.setBorder(border_white);
        pane_jta_scan_book_name3.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+8,(int)(0.5*Toolkit.getDefaultToolkit().getScreenSize().height),jta_scan_book_name1.getWidth(),jta_scan_book_name1.getHeight());

        jta_scan_book_author3=new JTextField("作者名/出版社");
        jta_scan_book_author3.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_book_author3.setForeground(Color.GRAY.brighter());
        jta_scan_book_author3.setBorder(border_white);
        jta_scan_book_author3.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width*2),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_book_author3=new JScrollPane(jta_scan_book_author3);
        pane_jta_scan_book_author3.add(jta_scan_book_author3);
        pane_jta_scan_book_author3.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+12,(int)(0.5*Toolkit.getDefaultToolkit().getScreenSize().height)+jta_scan_book_name1.getHeight(),jta_scan_book_author1.getWidth(),jta_scan_book_author1.getHeight());

        jta_scan_already_borrowed3=new JTextField("√ 已借阅");
        jta_scan_already_borrowed3.setFont(new Font("黑体",Font.BOLD,15));
        jta_scan_already_borrowed3.setForeground(c3);
        jta_scan_already_borrowed3.setEnabled(false);
        jta_scan_already_borrowed3.setBorder(border_white);
        jta_scan_already_borrowed3.setSize((int)(0.06510417*Toolkit.getDefaultToolkit().getScreenSize().width),(int)(0.11574074*Toolkit.getDefaultToolkit().getScreenSize().height*0.25));
        pane_jta_scan_already_borrowed3=new JScrollPane(jta_scan_already_borrowed3);
        pane_jta_scan_already_borrowed3.add(jta_scan_already_borrowed3);
        pane_jta_scan_already_borrowed3.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)+pane_jta_scan_book_name1.getWidth()*2-jta_scan_already_borrowed3.getWidth()-10,(int)(0.5*Toolkit.getDefaultToolkit().getScreenSize().height)+8,jta_scan_already_borrowed1.getWidth(),jta_scan_already_borrowed1.getHeight());

        label_scan_book_information3=new JLabel();
        label_scan_book_information3.setBounds((int)(0.5859375*Toolkit.getDefaultToolkit().getScreenSize().width*0.9)-2,(int)(0.5*Toolkit.getDefaultToolkit().getScreenSize().height)-2,pane_jta_scan_book_name1.getWidth()*2,pane_jta_scan_book_name1.getHeight()+pane_jta_scan_book_author1.getHeight()+5);
        //Border border3=BorderFactory.createLineBorder(Color.black,1,true);
        label_scan_book_information3.setBorder(border3);
        label_scan_book_information3.setOpaque(true);
        label_scan_book_information3.setBackground(Color.white);
         
        ///////////////////////////////
        label_icon_scan_button_confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ShowDetailView show1=new ShowDetailView(jf,label3,user_id);
                label3.setBackground(c2);
                jf.remove(label_icon_scan_book);
                jf.remove(label_scan_tip_scam);
                jf.remove(label_icon_scan_button_confirm);
                jf.remove(pane_jta_scan_book_name1);
                jf.remove(pane_jta_scan_book_author1);
                jf.remove(label_scan_book_information1);
                jf.remove(pane_jta_scan_already_borrowed1);
                jf.remove(pane_jta_scan_book_name2);
                jf.remove(pane_jta_scan_book_author2);
                jf.remove(pane_jta_scan_already_borrowed2);
                jf.remove(label_scan_book_information2);
                jf.remove(pane_jta_scan_book_name3);
                jf.remove(pane_jta_scan_book_author3);
                jf.remove(pane_jta_scan_already_borrowed3);
                jf.remove(label_scan_book_information3);
                jf.remove(button_scan_borrow);
                jf.remove(label_scan_code);
                jf.remove(jta_scan_code);
                jf.add(show1.pane_jta_show_book_name);
                jf.add(show1.pane_jta_show_already_borrowed);
                jf.add(show1.label_show_book_information);
                jf.add(show1.label_icon_show_continue_borrow);
                jf.add(show1.label_icon_show_return_main);
                
                jf.repaint();
            }
        });
        button_scan_borrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){ 
		        BookDBUtil uti=new BookDBUtil();
		        books_id=uti.getBookInfoByid(user_id);
				int i;
		        for(i = 0;i<books_id.length;++i) {
					if(books_id[i].equals("0"))break;
				}   
		        i=i+1;  
		        System.out.println(i);
		        if(i>3) {
					JOptionPane.showConfirmDialog (null, "最多借三本书!","Error",JOptionPane.YES_NO_CANCEL_OPTION);
					id=jta_scan_code.getText();
					button_scan_borrow.setEnabled(true);
		        }
		        else {
					id=jta_scan_code.getText();
					jta_scan_code.setText("");
					BorrowDBUtil bo=new BorrowDBUtil();
					name=uti.getBookNmByIsbn(id);
					author=uti.getBookAuByIsbn(id);
					if(name.equals("404")) {
						JOptionPane.showConfirmDialog (null,"输入图书编号错误!","扫码",JOptionPane.YES_NO_CANCEL_OPTION);
					}
					else {
						int num=0;
						num=uti.getBookSavingByIsbn(id);
						if(num==0) {
							JOptionPane.showConfirmDialog (null,"图书库存不足","Error",JOptionPane.YES_NO_CANCEL_OPTION);
							button_scan_borrow.setEnabled(true);	
						}
						else {
							if(t==1) {
								jta_scan_book_name1.setText("书本名: "+name);
						        jta_scan_already_borrowed1.setEnabled(true);
								jta_scan_book_author1.setText("作者名/出版社: "+author);
								bo.addBorrowInfoByids(user_id,id);
								uti.modifyBookSavingOne(id);
								button_scan_borrow.setEnabled(true);
								
							}
							else if(t==2) {
								jta_scan_book_name2.setText("书本名: "+name);
						        jta_scan_already_borrowed2.setEnabled(true);
								jta_scan_book_author2.setText("作者名/出版社: "+author);
								bo.addBorrowInfoByids(user_id,id);
								uti.modifyBookSavingOne(id);
								button_scan_borrow.setEnabled(true);					
							}
							else if(t==3) {
								jta_scan_book_name3.setText("书本名: "+name);
						        jta_scan_already_borrowed3.setEnabled(true);
								jta_scan_book_author3.setText("作者名/出版社: "+author);
								bo.addBorrowInfoByids(user_id,id);
								uti.modifyBookSavingOne(id);
								button_scan_borrow.setEnabled(true);	
							}
						t++;
						}
					}
		        }
			}
		});	
	}
}
