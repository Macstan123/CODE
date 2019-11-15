package miscfunction;

import javax.swing.*;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * �������
 */
public class photo {
 
	private static JFrame window;
 
	public static void main(String[] args) throws InterruptedException {
 
		
		final Webcam webcam = Webcam.getDefault();
		Dimension a=new Dimension(WebcamResolution.VGA.getSize());
		webcam.setViewSize(a);
 
		WebcamPanel panel = new WebcamPanel(webcam);
		panel.setFPSDisplayed(true);
		panel.setDisplayDebugInfo(true);
		panel.setImageSizeDisplayed(true);
		panel.setMirrored(true);
 
		JFrame window = new JFrame("Test webcam panel");
		window.add(panel);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
 
 
 
		final JButton button = new JButton("����");
		window.add(panel, BorderLayout.CENTER);
		window.add(button, BorderLayout.SOUTH);
		window.setResizable(true);
		window.pack();
		window.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
 
				button.setEnabled(false);  //���ð�ť���ɵ��
 
 
				//ʵ�����ձ���-------start
				String fileName = "D://" + System.currentTimeMillis();       //����·����ͼƬ���ƣ����üӺ�׺��
				WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
				SwingUtilities.invokeLater(new Runnable() {
 
					@Override
					public void run()
					{
						JOptionPane.showMessageDialog(null, "���ճɹ�");
						button.setEnabled(true);    //���ð�ť�ɵ��
 
					}
				});
				//ʵ�����ձ���-------end

			}
		});
	}




}
