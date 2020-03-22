/**
 * output package name
 */
package com.kingdee.eas.custom.weightPlatform.client;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIException;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.weightPlatform.WeightBean;
import com.kingdee.eas.custom.weightPlatform.WeightPlatformFacadeFactory;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.PortNum;
import com.kingdee.eas.weighbridge.WeighBridgeInfo;
import com.kingdee.eas.weighbridge.comm.ComReaderUtils;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class selfhelpWeightPlatformNoDShowUI extends AbstractselfhelpWeightPlatformNoDShowUI implements SerialPortEventListener
{
    private static final Logger logger = CoreUIObject.getLogger(selfhelpWeightPlatformNoDShowUI.class);
	private String portName = "COM99"; // 端口名称
	private int baudRate = 9600; // 波特率
	private int dataBit = 8; // 数据位
	private int stopBit = 1; // 停止位
	private int parityBit = 0; // 奇偶校验位
	private CommPortIdentifier portID = null; // 端口ID
	private SerialPort serialPort = null; // comm端口
	private OutputStream outputStream = null; // 端口输出流
	private InputStream inputStream = null; // 端口输入流
	private String portValueString = "0.00",oldPortValueString="0.00";// 當前端口數據
	private double portValue = 0;// 當前端口數據
	private Boolean isOpened = false;// 是否打開
	private String beginChar = "A";// 开始字符
	private String endChar = "B";// 结束字符
	private String jsScriptStr = null;
	private double[] lastValue;//最近几笔过磅数据
	private boolean isCanWeight=true;
	private WeightBean nowBean=null;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Thread curTherad;//
	private float maxIdleTime=2;//最大闲置时间2分钟
	private float nowIdleTime=0;//当前闲置时间
	private boolean isInit=false;
	long timeLast = System.currentTimeMillis();;
    /**
     * output class constructor
     */
    public selfhelpWeightPlatformNoDShowUI() throws Exception
    {
        super();
        this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocation(0, 0);
        this.getUIToolBar().setVisible(false);
        this.getUIMenuBar().setVisible(false);
        this.getUICustomToolBar().setVisible(false);
        for(int index=0;index<this.getUIMultiToolBar().length;index++) {
        	this.getUIMultiToolBar()[index].setVisible(false);
        }
        this.setUITitle("自助过磅平台");
    }
    /**
	 * output btnQuery_actionPerformed method
	 */
	protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception {
		exeQuery();
		nowIdleTime=0;
	}

	/**
	 * output btnWeight_actionPerformed method
	 */
	protected void btnWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception {
		if(nowBean.getFirstTime()==null) {
			nowBean.setFirstTime(new Date());
			nowBean.setFirstQty(new BigDecimal(lblWeightValue.getText()));
		} else 
		if(nowBean.getSecondTime()==null) {
			nowBean.setSecondTime(new Date());
			nowBean.setSecondQty(new BigDecimal(lblWeightValue.getText()));
			nowBean.setSuttleQty(nowBean.getSecondQty().subtract(nowBean.getFirstQty()).abs());
		}
		
		WeightPlatformFacadeFactory.getRemoteInstance().insertOrUpdateWeightInfo(nowBean);
		MsgBox.showInfo("过磅完成！");
		exeQuery();
		Thread.sleep(10000);
		this.txtWeightNum.setText(null);
		fillControlByWeightBean(null);
		nowIdleTime=0;
	}
	//com.kingdee.bos.dao.query.server.SQLDataAccess.getRowSet
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		this.kDTable1.checkParsed();
		this.kDTable1.getStyleAttributes().setLocked(true);
		this.kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		this.kDTable1.getHeadRow(0).getStyleAttributes().setFontSize(12);
		this.kDTable1.getHeadRow(0).setHeight(35);
//		this.kDTable1.setBackground(Color.PINK);
		
		this.txtWeightNum.setForeground(Color.red);

		kDTable1.getStyleAttributes().setFontSize(12);
		
		int lastCount=6;
		lastValue= new double[lastCount];
		for(int i=0;i<lastCount;i++) {
			lastValue[i]=0;
		}
		addActionListeners();
		this.kDTable1.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
//				tableSelected_changed(e);
			}});
		initComReader();
		curTherad=new Thread(new ControlThread());
		curTherad.start();
	}
	/**
	 *  表格点击事件
	 * @param e
	 */
	private void tableSelected_changed(KDTSelectEvent e) {
		if(e.getSelectBlock().getBeginRow()<0) {
			fillControlByWeightBean(null);
		}else {
			fillControlByWeightBean((WeightBean) kDTable1.getRow(e.getSelectBlock().getBeginRow()).getUserObject());
		}
	}
	
	

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		this.addComponentListener(new ComponentListener(){
			public void componentHidden(ComponentEvent e) {
				
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				System.out.println("123");
			}

			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}});
		if(getUIWindow() instanceof Dialog){
			((Dialog)getUIWindow()).setResizable(false);
			/*GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
            //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了 
            GraphicsDevice gd = ge.getDefaultScreenDevice(); 
            // 全屏设置 
            gd.setFullScreenWindow(((Dialog)getUIWindow())); 
//			((Dialog)getUIWindow()).setUndecorated(true);
*/		}
		
	}
	@Override
	public boolean destroyWindow() {
		//人为退出
		if(isInit){ 
			UIContext uiContext = new UIContext(this);
	    	IUIWindow uiWindow = null ;
	    	// UIFactoryName.MODEL 为弹出模式
	    	try {
				uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.weightPlatform.client.PwdVerifyUI", uiContext, null,OprtState.VIEW);
			} catch (UIException e) {
				e.printStackTrace();
			}
	    	//开始展现UI
	    	uiWindow.show();
	    	if((Boolean)uiWindow.getUIObject().getUIContext().get("isCancel")) {
	    		return false;
	    	}
		}
		closePort();
		closeThread();
		return super.destroyWindow();
	}
	
	@Override
	protected void finalize() throws Throwable {
		closePort();
		closeThread();
		super.finalize();
	}
	
	private void closeThread() {
		if(curTherad!=null&&curTherad.isAlive()) {
			curTherad.suspend();
		}
	}
	
	/**
	 * 执行查询
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private void exeQuery() throws BOSException, SQLException {
		kDTable1.removeRows();
		String weightNum = this.txtWeightNum.getText();
		
//		weightNum="1MGI9LA0";
		
		if (StringUtils.isBlank(weightNum)) {
//			MsgBox.showWarning("过磅码不能为空！");
//			return;
		}
		
		fillControlByWeightBean(null);
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -7);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		//默认只能查询7天的数据
		StringBuffer sql = new StringBuffer();
		sql.append(" /*dialect*/ select tbill.fid,tbill.fnumber,tcar.fnumber cfcarNum,to_char(tbill.FbizDate,'yyyy-MM-dd') FbizDate,tbill.CFEstRecycleWgt cfQty,")
		.append(" 0 CFstatus,tbill.FweightNum,to_char(tbill.FTareFirstTime,'yyyy-MM-dd HH24:mi:ss') FTareFirstTime,to_char(tbill.FTareSecondTime,'yyyy-MM-dd HH24:mi:ss') FTareSecondTime,")
		.append(" tbill.FTareFirstQty,tbill.FTareSecondQty,tbill.CFTareWgt cfsuttltQty")
		.append(" from CT_WEI_CarSendBill tbill")//派车单
		.append(" inner join CT_PUB_Car tcar on tcar.fid=CFCarID")
		.append(" where fWeightNum='").append(weightNum).append("'")
		.append(" or (")
		.append(" tcar.fid in (")
		.append(" select CFCarID from CT_WEI_CarSendBill ")
		.append(" where fWeightNum='").append(weightNum).append("'")
		.append(" )")
		.append(" and CFRecycleDate>=to_date( '").append(sdf.format(cal.getTime())).append("','yyyy-MM-dd HH24:mi:ss')")
		.append(" and CFRecycleDate<=to_date( '").append(sdf.format(new Date())).append("','yyyy-MM-dd HH24:mi:ss')")
		.append(" )")
		.append(" order by Fbizdate desc")
		.append(" ")
		;
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		IRow row;
		WeightBean bean;
		while(rs.next()) {
			row=kDTable1.addRow();
			
			bean=new WeightBean();
			bean.setBillID(rs.getString("fid"));
			bean.setBillNum(rs.getString("Fnumber"));
			bean.setBizDate(rs.getString("FBizDate"));
			bean.setCarNum(rs.getString("cfcarNum"));
			bean.setQty(rs.getBigDecimal("cfQty"));
			bean.setWeightNum(rs.getString("FweightNum"));
			bean.setFirstQty(rs.getBigDecimal("FTareFirstQty"));
			bean.setFirstTime(rs.getTimestamp("FTareFirstTime"));
			bean.setSecondQty(rs.getBigDecimal("FTareSecondQty"));
			bean.setSecondTime(rs.getTimestamp("FTareSecondTime"));
			bean.setSuttleQty(rs.getBigDecimal("cfsuttltQty"));
			row.setUserObject(bean);
			
			row.getCell("id").setValue(bean.getBillID());
			row.getCell("number").setValue(bean.getBillNum());
			row.getCell("carNum").setValue(bean.getCarNum());
			row.getCell("bizDate").setValue(bean.getBizDate());
			row.getCell("qty").setValue(bean.getQty());
			row.getCell("status").setValue(rs.getString("CFstatus"));
			row.getCell("weightNum").setValue(bean.getWeightNum());
			row.getCell("firstTime").setValue(bean.getFirstTime()!=null?sdf.format(bean.getFirstTime()):null);
			row.getCell("secondTime").setValue(bean.getSecondTime()!=null?sdf.format(bean.getSecondTime()):null);
			
			row.setHeight(35);
			row.getStyleAttributes().setFontSize(12);
			
			//过磅码相等
			if(bean.getWeightNum().equals(weightNum)) {
				row.getStyleAttributes().setBackground(new Color(153,217,234));//蓝色
				fillControlByWeightBean(bean);
			}
			//已经过磅完成了
			if(bean.getFirstTime()!=null&&bean.getSecondTime()!=null) {
				row.getStyleAttributes().setBackground(new Color(189,217,118));//绿色
			}
		}
		MsgBox.showInfo("查询完成！");
	}
	/**
	 * 填充界面控件
	 * @param bean
	 */
	private void fillControlByWeightBean(WeightBean bean) {
		nowBean=bean;
		isCanWeight=false;
		nowIdleTime=0;
		btnWeight.setEnabled(false);
		if(bean!=null) {
			txtCarNum.setText(bean.getCarNum());
			txtBillNum.setText(bean.getBillNum());
			txtBillQty.setValue(bean.getQty());
			txtFirstQty.setValue(bean.getFirstQty());
			if(bean.getFirstTime()!=null) {
				txtFirstTime.setText(sdf.format(bean.getFirstTime()));
			}
			if(bean.getSecondTime()!=null) {
				txtSecondTime.setText(sdf.format(bean.getSecondTime()));
			}
			txtSecondQty.setValue(bean.getSecondQty());
			txtSuttleQty.setValue(bean.getSuttleQty());
			
			if(bean.getFirstTime()!=null&&bean.getSecondTime()!=null) {
				isCanWeight=false;
			}else {
				isCanWeight=true;
			}
		}else {
			kDTable1.removeRows();
			txtCarNum.setText(null);
			txtBillNum.setText(null);
			txtBillQty.setValue(null);
			txtFirstQty.setValue(null);
			txtFirstTime.setText(null);
			txtSecondQty.setValue(null);
			txtSecondTime.setText(null);
			txtSuttleQty.setValue(null);
		}
	}

	private void addActionListeners() {
		CActionListener acLs = new CActionListener();
		this.btnA.addActionListener(acLs);
		this.btnB.addActionListener(acLs);
		this.btnC.addActionListener(acLs);
		this.btnD.addActionListener(acLs);
		this.btnE.addActionListener(acLs);
		this.btnF.addActionListener(acLs);
		this.btnG.addActionListener(acLs);
		this.btnH.addActionListener(acLs);
		this.btnJ.addActionListener(acLs);
		this.btnK.addActionListener(acLs);
		this.btnL.addActionListener(acLs);
		this.btnM.addActionListener(acLs);
		this.btnN.addActionListener(acLs);
		this.btnP.addActionListener(acLs);
		this.btnX.addActionListener(acLs);
		this.btn0.addActionListener(acLs);
		this.btn1.addActionListener(acLs);
		this.btn2.addActionListener(acLs);
		this.btn3.addActionListener(acLs);
		this.btn4.addActionListener(acLs);
		this.btn5.addActionListener(acLs);
		this.btn6.addActionListener(acLs);
		this.btn7.addActionListener(acLs);
		this.btn8.addActionListener(acLs);
		this.btn9.addActionListener(acLs);
		this.btnBackspace.addActionListener(acLs);
		this.btnClear.addActionListener(acLs);
	}

	private class CActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nowIdleTime=0;
			String btnName = ((KDWorkButton) e.getSource()).getName();
			String oldNum = txtWeightNum.getText() == null ? "" : txtWeightNum.getText().trim();
			if (btnName.length() == 4 ) {
				txtWeightNum.setText(oldNum + btnName.substring(3));
			} else if (e.getSource().equals(btnBackspace) && oldNum.length() > 0) {
				txtWeightNum.setText(oldNum.substring(0, oldNum.length() - 1));
			} else if (e.getSource().equals(btnClear)) {
				txtWeightNum.setText(null);
				fillControlByWeightBean(null);
			}
		}
	}

	/**
	 * 初始化comm口
	 * 
	 * @throws Exception
	 */
	private void initComReader() throws Exception {
		setCommPortParams(null);
		openPortAutoRead();

	}

	// 端口参数设置
	private void setCommPortParams(WeighBridgeInfo info) throws Exception {
		if (info == null) {
			String cupID = ComReaderUtils.getLocalMac();
			StringBuffer sql=new StringBuffer();
			sql.append(" select ts.FPort FRealPort,tb.*")
			.append(" from CT_WHB_Setting ts")
			.append(" inner join CT_WHB_WeighBridge tb on tb.fid=ts.CFWeighbridgeID")
			.append(" where ts.CFMac='").append(cupID).append("'")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if (rs.next()) {
				portName =PortNum.getEnum(rs.getString("FRealPort")).getName();
				baudRate =rs.getInt("CFBaudRate");// 波特率
				dataBit = rs.getInt("CFDataBits");// 数据位
				stopBit = rs.getInt("CFStopBits");// 停止位
				parityBit = rs.getInt("CFParity");// 奇偶校验位
				beginChar =rs.getString("CFBeginChar");
				endChar = rs.getString("CFEndChar");
				jsScriptStr = rs.getString("CFTxtJSScript");
				isInit=true;
			}else {
				MsgBox.showWarning("请先进行基础设置！");
				SysUtil.abort();
			}
		}
	}

	/**
	 * 打开串口
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void openPortAutoRead() throws Exception {
		try {
			portID = CommPortIdentifier.getPortIdentifier(portName);
			serialPort = (SerialPort) portID.open("PORT_SERIAL", 1000);
			isOpened = true;
			System.out.println("##############端口已经打开############");
			this.initComPortAutoRead();
		} catch (NoSuchPortException e) {
			throw new Exception("端口" + portName + "不存在！");
		} catch (PortInUseException e) {
			throw new Exception("端口" + portName + "已被占用！");
		}
	}

	/**
	 * 初始化端口 参数
	 * 
	 * @throws Exception
	 */
	public void initComPort() throws Exception {
		// 初始化端口的连接参数，参数顺序：波特率、数据位、停止位、奇偶校验位 9600、8、1、0
		try {
			serialPort.setSerialPortParams(baudRate, dataBit, stopBit, parityBit);
			// 初始化端口的输入、输出流
		} catch (UnsupportedCommOperationException e) {
			throw new Exception(e);
		}
	}

	/**
	 * 初始化端口 参数 自動讀取數據
	 * 
	 * @throws Exception
	 */
	private void initComPortAutoRead() throws Exception {
		// 初始化端口的连接参数，参数顺序：波特率、数据位、停止位、奇偶校验位 9600、8、1、0
		try {
			serialPort.setSerialPortParams(baudRate, dataBit, stopBit, parityBit);
			// 初始化端口的输入、输出流
			inputStream = serialPort.getInputStream();
			outputStream = serialPort.getOutputStream();
		} catch (IOException e) {
			throw new Exception(e);
		} catch (UnsupportedCommOperationException e) {
			throw new Exception(e);
		}
		serialPort.addEventListener(this);// 添加监听器
		serialPort.notifyOnDataAvailable(true);
	}

	/**
	 * 关闭端口
	 * 
	 * @throws Exception
	 */
	public void closePort() {
		try {
			if (inputStream != null) {
				inputStream.close();
				inputStream = null;
			}
			if (outputStream != null) {
				outputStream.close();
				inputStream = null;
			}
			if (serialPort != null) {
				isOpened = false;
				serialPort.close();
				serialPort = null;
			}
			System.out.println("***************端口已经关闭************8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过JS脚本来取数
	 * 
	 * @param jsString
	 * @return
	 * @throws BOSException
	 */
	public static String getValueByJSScript(String jsString, String valueString) throws BOSException {
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
			ScriptEngine engine = mgr.getEngineByMimeType("application/javascript");
			engine.eval(jsString);
			Invocable inv = (Invocable) engine;
			String res = (String) inv.invokeFunction("getValue", valueString);
			return res;
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	/**
	 * BI -通讯中断. CD -载波检测. CTS -清除发送. DATA_AVAILABLE -有数据到达. DSR -数据设备准备好. FE
	 * -帧错误. OE -溢位错误. OUTPUT_BUFFER_EMPTY -输出缓冲区已清空. PE -奇偶校验错. RI - 振铃指示.
	 * 一般最常用的就是DATA_AVAILABLE--串口有数据到达事件。
	 */
	public void serialEvent(SerialPortEvent event) {
		System.out.println("(((((beginReceive)))))))");
		
		try {
			Thread.currentThread();
			Thread.sleep(100);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
			break;
		case SerialPortEvent.OE:
			break;
		case SerialPortEvent.FE:
			break;
		case SerialPortEvent.PE:
			break;
		case SerialPortEvent.CD:
			break;
		case SerialPortEvent.CTS:
			break;
		case SerialPortEvent.DSR:
			break;
		case SerialPortEvent.RI:
			break;
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:
			byte[] readBuffer = new byte[100];
			
			try {
			
				while (inputStream.available() > 0) {
					timeLast = System.currentTimeMillis();
					inputStream.read(readBuffer);
					String receivedMsg = new String(readBuffer).trim();
					System.out.println("磅秤 原始数据 ：" + receivedMsg);

					if (StringUtils.isNotBlank(beginChar) && StringUtils.isNotBlank(endChar)) {
						if (receivedMsg.length() < (beginChar.length() + endChar.length())) {
							portValueString = "0.00";
							
						}
						int beginIndex = receivedMsg.indexOf(beginChar);
						int endIndex = receivedMsg.indexOf(endChar, beginIndex + beginChar.length());
						if(endIndex>0) {
							portValueString = receivedMsg.substring(beginIndex + beginChar.length(), endIndex).trim();
						}else{
							portValueString = receivedMsg.substring(beginIndex+1 , receivedMsg.length()).trim();
						}
					}else if(StringUtils.isNotBlank(beginChar) && StringUtils.isBlank(endChar))  {
						int beginIndex = receivedMsg.indexOf(beginChar);
						portValueString = receivedMsg.substring(beginIndex+1 , receivedMsg.length()).trim();
					}
					if (inputStream != null)
						inputStream.close();
					System.out.println("磅秤 截取后 数据 ：" + portValueString);

//					System.out.println("script :" + jsScriptStr);
					// MsgBox.showInfo("脚本前："+retValue);
					if (StringUtils.isNotBlank(jsScriptStr)) {
						portValueString = getValueByJSScript(this.jsScriptStr, portValueString);// 通过JS脚本解析数据
					}else {
//						portValueString=receivedMsg;
					}
					if (StringUtils.isNotBlank(portValueString)) {
						portValueString = StringUtils.trim(portValueString);
					}else {
						portValueString="0.00";
					}
					oldPortValueString=portValueString;
					System.out.println("脚本返回值：" + portValueString);
					/*BigDecimal retBigDecimalValue = new BigDecimal(portValueString);
					if (retBigDecimalValue != null) {
						portValueString = (retBigDecimalValue.divide(new BigDecimal("1"), 2, RoundingMode.HALF_UP)).toPlainString();
					} else {
						portValueString = "0.00";
					}*/
				}
			} catch (Exception e) {
				portValueString=oldPortValueString;
				logger.error(e);
			}
			break;
		}
	}
	/**
	 * 控件线程
	 * @author dai_andong
	 *
	 */
	private class ControlThread implements Runnable {
		public void run() {
			boolean isExistDiff;
			if(portName.equals("COM99")) {
				lblStatus.setText("读数错误");
				lblStatus.setForeground(Color.red);
				return;
			}
			while(true) {
				try {
					if(edg()==false){
									
					}else{
//					System.out.println("界面刷新进程，begin");
					//*****控件显示******
					lblWeightValue.setText(portValueString);
					//*****判断是否稳定******
//					System.out.println("界面刷新数值"+portValueString);
					portValue=Double.valueOf(portValueString);
					
					isExistDiff=false;
//					System.out.println("前："+lastValue.toString());
					for(int i=0;i<lastValue.length;i++) {
						if(!isExistDiff&&lastValue[i]!=portValue) {
							isExistDiff=true;
						}
						if(i==lastValue.length-1) {
							lastValue[i]=portValue;
						}else {
							lastValue[i]=lastValue[i+1];
						}
					}
//					System.out.println("后："+lastValue.toString());
					if(isExistDiff) {
						lblStatus.setText("读数不稳定");
						lblStatus.setForeground(Color.red);
					}else {
						lblStatus.setText("读数稳定");
						lblStatus.setForeground(Color.green);
					}
					//读数值<=0
					if(nowBean==null||isExistDiff||portValue<=0) {
						btnWeight.setEnabled(false);
					}else {
						//稳定后才可以设置为可用
						if(isCanWeight) {
							btnWeight.setEnabled(true);
						}
					}
					//闲置时间>最大闲置时间 清空数据
					if(nowBean!=null){
						if(nowIdleTime>maxIdleTime) {
							txtWeightNum.setText(null);
							fillControlByWeightBean(null);
						}else {
							nowIdleTime+=0.0083;//分钟
						}
					}
					}
					Thread.currentThread();
					//0.5S验证一次
					Thread.sleep(500);
				} catch (InterruptedException e) {
					handleException(e);
				}
			}
		}
	}
		public boolean edg(){
			//10-14号上午
				boolean isCanWeight = true;
	        	long timeNow = System.currentTimeMillis();
				    if(timeNow-timeLast>3000){
				    	lblStatus.setText("数据传输异常");
				    	lblStatus.setForeground(Color.red);
				    	isCanWeight = false;
				    }
					return isCanWeight;
		}
}