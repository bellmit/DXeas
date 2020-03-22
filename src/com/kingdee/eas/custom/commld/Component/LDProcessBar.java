package com.kingdee.eas.custom.commld.Component;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.kingdee.bos.ctrl.swing.KDFrame;
import com.kingdee.bos.ctrl.swing.KDLabel;
import com.kingdee.bos.ctrl.swing.KDProgressBar;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.master.util.StringUtil;
public class LDProcessBar extends Component implements ActionListener, ChangeListener{

	private static final String DisplayType_FenShu="FenShu";
	private static final String DisplayType_BaiFenShu="BaiFenShu";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	KDFrame frame = null;
	KDProgressBar progressbar;
	KDLabel label;
	Timer timer;
	JButton btn;
	int fenZi;
	int fenMu;
	int baiFenBi;
	String displayType="";
	public  LDProcessBar(){
		frame = new KDFrame("��ѯ��...");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container content = frame.getContentPane();
		label = new KDLabel(" ", JLabel.CENTER);
		progressbar = new KDProgressBar();// ����һ��������
		progressbar.setOrientation(JProgressBar.HORIZONTAL);
		progressbar.setMinimum(0);
		progressbar.setMaximum(100);
		progressbar.setValue(0);
		progressbar.setStringPainted(true);
		progressbar.addChangeListener(this);
		progressbar.setPreferredSize(new Dimension(300, 20));
		progressbar.setBorderPainted(true);
		progressbar.setBackground(Color.pink);
		JPanel panel = new JPanel();
		btn = new JButton("��װ");
		btn.setForeground(Color.blue);// ����¼�����
		btn.addActionListener(this);
		btn.setVisible(true);
		btn.setEnabled(false);
		panel.add(btn);
		timer = new Timer(0,this);
		content.add(panel, BorderLayout.NORTH);
		content.add(progressbar, BorderLayout.CENTER);
		content.add(label, BorderLayout.SOUTH);
		frame.pack();
		double sWidth = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double sHeight = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setBounds(UIRuleUtil.getInt(((sWidth-frame.getWidth())/2)), UIRuleUtil.getInt(((sHeight-frame.getHeight())/2)), frame.getWidth(), frame.getHeight());
		frame.repaint();
		frame.setVisible(true);
	}
	/**
	 * ���ñ�ͷ���ı�
	 * @param title
	 */
	public  void setTitle (String title){
		frame.setTitle(title);
	}
	/**
	 * ��ȡ��ͷ���ı�
	 * @param title
	 */
	public  String getTitle (){
		return frame.getTitle();
	}

	/**
	 * ���ð�ť����
	 * @param text
	 */
	public  void setButtonText(String text){
		btn.setText(text);
	}
	/**
	 * ���ð�ť����
	 * @param text
	 */
	public  void setButtonEnable(boolean bool){
		btn.setEnabled(bool);
	}
	/**
	 * ��ȡ��ť����
	 * @param text
	 */
	public  String getButtonText(String text){
		return btn.getText();
	}

	/**
	 * ���ð�ť�ɼ���
	 * @param text
	 */
	public  void setButtonVisible(boolean bool){
		btn.setVisible(bool);
	}

	/**
	 * ����λ��
	 * @param text
	 */
	public  void setlocation(Point point){
		frame.setLocation(point);
	}
	/**
	 * �ر�
	 * @param text
	 */
	public  void dispose(){
		if(timer.isRunning())
			timer.stop();
		frame.dispose();
	}

	/**
	 * ����λ��
	 * @param text
	 */
	public  void setlocation(int x,int y){
		frame.setLocation(x,y);
	}

	/**
	 * ��ȡ�߶�
	 * @param text
	 * @return 
	 */
	public  int getHeight(){
		return frame.getHeight();
	}

	/**
	 * ��ȡ��
	 * @param text
	 * @return 
	 */
	public  int getWidth(){
		return frame.getWidth();
	}

	// ʵ���¼������ķ���
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn)
			timer.start();
		if (e.getSource() == timer) {
			int value = progressbar.getValue();
			if (value < 100) {
				progressbar.setValue(++value);
			} else {
				timer.stop();
				frame.dispose();
			}
		}
	}
	public void stateChanged(ChangeEvent e1) {
		int value = progressbar.getValue();
		if (e1.getSource() == progressbar) {
			if(displayType.equalsIgnoreCase(DisplayType_FenShu)){
				label.setText("Ŀǰ����ɽ���:" + Integer.toString(fenZi) + "/"+Integer.toString(fenMu));
			}
			else
				label.setText("Ŀǰ����ɽ���:" + Integer.toString(value) + "%");
			label.setForeground(Color.blue);
		}
	}
	/**
	 * ʧЧԭ��δ֪
	 * @param bool
	 */
	public void setVisible(Boolean bool){
		frame.setVisible(bool);
	}
	/**
	 * ���ý��������� int
	 * @param value
	 */
	public void setIntValue(int value){
		progressbar.setValue(value);
	}
	/**
	 * ��ȡ���������� int
	 * @return
	 */
	public int getIntValue(){
		return progressbar.getValue();
	}
	
	/**
	 * ���ý��������� String
	 * @param value
	 */
	public void setStringValue(String value){
		progressbar.setString(value);
	}
	/**
	 * ��ȡ���������� String
	 * @return
	 */
	public String getStringValue(){
		return progressbar.getString();
	}
	
	/**
	 * ����label��ʾ����
	 * @param text
	 */
	public void setLabelText(String text){
		label.setText(text);
	}
	
	/**
	 * ��ȡlabel��ʾ����
	 * @param text
	 */
	public String getLabelText(){
		return label.getText();
	}
}
