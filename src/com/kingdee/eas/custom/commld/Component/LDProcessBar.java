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
		frame = new KDFrame("查询中...");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container content = frame.getContentPane();
		label = new KDLabel(" ", JLabel.CENTER);
		progressbar = new KDProgressBar();// 创建一个进度条
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
		btn = new JButton("安装");
		btn.setForeground(Color.blue);// 添加事件监听
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
	 * 设置表头的文本
	 * @param title
	 */
	public  void setTitle (String title){
		frame.setTitle(title);
	}
	/**
	 * 获取表头的文本
	 * @param title
	 */
	public  String getTitle (){
		return frame.getTitle();
	}

	/**
	 * 设置按钮标题
	 * @param text
	 */
	public  void setButtonText(String text){
		btn.setText(text);
	}
	/**
	 * 设置按钮标题
	 * @param text
	 */
	public  void setButtonEnable(boolean bool){
		btn.setEnabled(bool);
	}
	/**
	 * 获取按钮标题
	 * @param text
	 */
	public  String getButtonText(String text){
		return btn.getText();
	}

	/**
	 * 设置按钮可见性
	 * @param text
	 */
	public  void setButtonVisible(boolean bool){
		btn.setVisible(bool);
	}

	/**
	 * 设置位置
	 * @param text
	 */
	public  void setlocation(Point point){
		frame.setLocation(point);
	}
	/**
	 * 关闭
	 * @param text
	 */
	public  void dispose(){
		if(timer.isRunning())
			timer.stop();
		frame.dispose();
	}

	/**
	 * 设置位置
	 * @param text
	 */
	public  void setlocation(int x,int y){
		frame.setLocation(x,y);
	}

	/**
	 * 获取高度
	 * @param text
	 * @return 
	 */
	public  int getHeight(){
		return frame.getHeight();
	}

	/**
	 * 获取宽
	 * @param text
	 * @return 
	 */
	public  int getWidth(){
		return frame.getWidth();
	}

	// 实现事件监听的方法
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
				label.setText("目前已完成进度:" + Integer.toString(fenZi) + "/"+Integer.toString(fenMu));
			}
			else
				label.setText("目前已完成进度:" + Integer.toString(value) + "%");
			label.setForeground(Color.blue);
		}
	}
	/**
	 * 失效原因未知
	 * @param bool
	 */
	public void setVisible(Boolean bool){
		frame.setVisible(bool);
	}
	/**
	 * 设置进度条内容 int
	 * @param value
	 */
	public void setIntValue(int value){
		progressbar.setValue(value);
	}
	/**
	 * 获取进度条内容 int
	 * @return
	 */
	public int getIntValue(){
		return progressbar.getValue();
	}
	
	/**
	 * 设置进度条内容 String
	 * @param value
	 */
	public void setStringValue(String value){
		progressbar.setString(value);
	}
	/**
	 * 获取进度条内容 String
	 * @return
	 */
	public String getStringValue(){
		return progressbar.getString();
	}
	
	/**
	 * 设置label显示内容
	 * @param text
	 */
	public void setLabelText(String text){
		label.setText(text);
	}
	
	/**
	 * 获取label显示内容
	 * @param text
	 */
	public String getLabelText(){
		return label.getText();
	}
}
