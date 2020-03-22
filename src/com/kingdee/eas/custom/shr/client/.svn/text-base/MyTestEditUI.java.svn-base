/**
 * output package name
 */
package com.kingdee.eas.custom.shr.client;

import java.awt.AWTEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.*;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.bi.model.commonui.propsheet.beans.value.StringValue;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.semantic.model.trans.checkin.BosCheckinModel.Response;
import com.kingdee.bos.ctrl.swing.KDButton;

import java.util.*;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.*;
import javax.swing.plaf.TableHeaderUI;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.table.*;

/**
 * output class name
 */
public class MyTestEditUI extends AbstractMyTestEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MyTestEditUI.class);

	/**
	 * output class constructor
	 */
	public MyTestEditUI() throws Exception
	{
		super();
	}



	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.shr.MyTestFactory.getRemoteInstance();
	}
	class BtnActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object obj=e.getSource();
			if(obj==btnTest)
			{
				MsgBox.showInfo("Test Succeed");
			}
		}
	}

	class MitiSay extends Thread {
		public MitiSay(String threadName) {
			super(threadName);
		}

		public void run() {
			MsgBox.showInfo(getName() + " 线程运行开始!");
			for (int i = 0; i < 10; i++) {
				MsgBox.showInfo(i + " " + getName());
				try {
					sleep((int) Math.random() * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			MsgBox.showInfo(getName() + " 线程运行结束!");
		}
	}






	class Thread1 extends Thread
	{
		public Thread1(String threadName)
		{	
			super(threadName);
		}

		public void run()
		{
			MsgBox.showInfo(getName() + "is running");
			try
			{
				sleep(2000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	class Thread2 extends Thread
	{
		private Thread1 thread1;

		public Thread2(String threadName, Thread1 thread1)
		{
			super(threadName);
			this.thread1 = thread1;		
		}

		public void run()
		{
			MsgBox.showInfo(getName() +"is running");
			try
			{
				thread1.start();
				thread1.join();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			MsgBox.showInfo("thread2 is over");	
		}
	}
	public void ss(){

	}


@Override
public void onLoad() throws Exception {
	// TODO Auto-generated method stub
	super.onLoad();


	Thread1 thread1 = new Thread1("Thread1");
	Thread2 thread2 = new Thread2("Thread2",thread1);
	thread2.start();
	//		MsgBox.showInfo(Thread.currentThread().getName() + " 线程运行开始!");
	//        new MitiSay("A").start();
	//        new MitiSay("B").start();
	//        MsgBox.showInfo(Thread.currentThread().getName() + " 线程运行结束!");
	//		




	menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
	btnTest.registerKeyboardAction(new BtnActionListener(),KeyStroke.getKeyStroke(KeyEvent.VK_F5,0),JComponent.WHEN_IN_FOCUSED_WINDOW);


	//		Timer timer = new Timer(true);
	//		timer.schedule(new TimerTask(){    
	//			public void run()
	//			{
	//				if(i<10)
	//					refreshCur();
	//			}
	//		},0,1*500);
	//		if(i==10)
	//			timer.cancel();


	//		CloseWindowIn5 clos = new CloseWindowIn5();
	//		new Thread(clos).start();
	//		clos.showWindow();






}



//	public class CloseWindowIn5 extends Frame implements Runnable{
//
//		public void showWindow(){
//		this.setSize(300, 400);
//		this.setLocation(100, 100);
//		this.setBackground(Color.gray);
//		this.setVisible(true);
//
//		}
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//				try {
//					Thread.sleep(5000);
//					setVisible(false);  //关闭窗口
//					System.exit(0);
//					} catch (InterruptedException e) {
//					e.printStackTrace();
//					}
//			
//		}
//	
//	}
//		
//	int i=0;
//	private void refreshCur() {
//		// TODO Auto-generated method stub
//		MsgBox.showWarning(String.valueOf(i++));
//	}
@Override
public void actionSave_actionPerformed(ActionEvent e) throws Exception {
	// TODO Auto-generated method stub
	String destBillEditUIClassName ="com.kingdee.eas.custom.signwasthetable.client.ContractChangeView";
	Map map = new UIContext(this);
	map.put(UIContext.OWNER, this);
	IUIWindow uiWindow = null ;
	uiWindow = UIFactory.createUIFactory(UIFactoryName.EDITWIN).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
	//开始展现 UI
	uiWindow.show();
	//		super.actionSave_actionPerformed(e);
}
/**
 * output createNewDetailData method
 */
protected IObjectValue createNewDetailData(KDTable table)
{

	return null;
}

/**
 * output createNewData method
 */
protected com.kingdee.bos.dao.IObjectValue createNewData()
{
	com.kingdee.eas.custom.shr.MyTestInfo objectValue = new com.kingdee.eas.custom.shr.MyTestInfo();
	objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

	return objectValue;
}

}