package com.kingdee.eas.custom.commld.fileUtils.Picture;

import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import com.kingdee.bos.ctrl.swing.KDFrame;
public class PictureViewer implements ActionListener{
	private KDFrame frame;
	private MyCanvas mc ;
	private String fpath;
	private String fname;
	private File[] files;
	private int findex ;
	private FileDialog fd_load; 
	private MyFilter filter;
	private JButton previous ;
	private Button next ;
	private Button select;
	public static void main( String args[]) throws Exception {
		new PictureViewer().init();
	}
	public void init(){
		frame = new KDFrame("WLHLPictureViewer");
		Panel pb = new Panel();
		select = new Button("选择图片");
		previous = new JButton("上一张");
		next = new Button("下一张");
		select.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);
		pb.add(select);
		pb.add(previous);
		pb.add(next); 
		mc = new MyCanvas();
		mc.setBackground(new Color(200,210,230));
		mc.addComponentListener(mc);
		frame.add(pb,"North");
		frame.add(mc,"Center");
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		frame.setSize(600,450);
		frame.setLocation((width-600)/2,(height-450)/2);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				beforeDispose();
				frame.dispose();
			}  
		}); 
		frame.setVisible(true); 
		this.validateButton();
		filter = new MyFilter();
		fd_load = new FileDialog(frame,"打开文件",FileDialog.LOAD);
		fd_load.setFilenameFilter(filter);
	}

	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if(command.equals("选择图片")){
			fd_load.setVisible(true);
			fpath = fd_load.getDirectory();
			fname = fd_load.getFile();
			if((fpath != null) && (fname != null)){
				this.display(new File(fpath + fname)); 
				files = new File(fpath).listFiles(filter);
				this.setIndex();
			}
		}else if(command.equals("上一张")){
			findex--;
			if(findex<0)
				findex = 0;
			this.display(files[findex]);
		}else if(command.equals("下一张")){
			findex++;
			if(findex >= files.length)
				findex = files.length-1;
			this.display(files[findex]);
		}
		this.validateButton();
	}  
	public boolean display(File f){
		try{
			BufferedImage bi = ImageIO.read(f);
			mc.setImage(bi);
			frame.setTitle("PictureViewer - [" + f.getName() + "]");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		mc.repaint();
		return true;
	}
	public void setIndex(){
		File current = new File(fpath + fname); 
		if(files != null){
			for(int i=0;i<files.length;i++){
				if(current.equals(files[i])){
					findex = i; 
				}
			}
		}
	}
	public void validateButton(){
		previous.setEnabled((files!=null) && (findex > 0));
		next.setEnabled((files!=null) && (findex<(files.length-1))); 
	}
	
	// 设置初始图片文件
	public void setFiles(File [] files){
		this.files = files;
	}
	 // 获取初始图片文件
	public File[] getFiles(){
		return this.files;
	}
	
	// 设置图片所在数组位置坐标
	public void setFilesIndex(int  index){
		this.findex = index;
	}
	public int getFilesIndex(){
		return this.findex;
	}
	
	// 设置
	public void setSelectButtonVisible(boolean bool){
		select.setVisible(bool);
	}
	public void beforeDispose() {
		// TODO Auto-generated method stub
		
	}
}
