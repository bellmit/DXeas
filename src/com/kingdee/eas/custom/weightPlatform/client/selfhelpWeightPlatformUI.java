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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import com.kingdee.bos.ctrl.swing.KDButton;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.custom.weightPlatform.WeightBean;
import com.kingdee.eas.custom.weightPlatform.WeightPlatformFacadeFactory;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.WeighBridgeInfo;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class selfhelpWeightPlatformUI extends AbstractselfhelpWeightPlatformUI implements SerialPortEventListener {
	private static final Logger logger = CoreUIObject.getLogger(selfhelpWeightPlatformUI.class);
	private String portName = "COM1"; // 端口名称
	private int baudRate = 2400; // 波特率
	private int dataBit = 8; // 数据位
	private int stopBit = 1; // 停止位
	private int parityBit = 0; // 奇偶校验位
	private CommPortIdentifier portID = null; // 端口ID
	private SerialPort serialPort = null; // comm端口
	private OutputStream outputStream = null; // 端口输出流
	private InputStream inputStream = null; // 端口输入流
	private String portValueString = null;// 當前端口數據
	private double portValue = 0;// 當前端口數據
	private Boolean isOpened = false;// 是否打開
	private String beginChar = null;// 开始字符
	private String endChar = null;// 结束字符
	private String jsScriptStr = null;
	private double[] lastValue;//最近几笔过磅数据
	private boolean isCanWeight=true;
	private WeightBean nowBean=null;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * output class constructor
	 */
	public selfhelpWeightPlatformUI() throws Exception {
		super();
		this.setUITitle("自助过磅平台");
	}

	/**
	 * output btnQuery_actionPerformed method
	 */
	protected void btnQuery_actionPerformed(java.awt.event.ActionEvent e) throws Exception {
		exeQuery();
	}

	/**
	 * output btnWeight_actionPerformed method
	 */
	protected void btnWeight_actionPerformed(java.awt.event.ActionEvent e) throws Exception {
		if(nowBean.getFirstTime()==null) {
			nowBean.setFirstTime(new Date());
			nowBean.setFirstQty(new BigDecimal(lblWeightValue.getText()));
		}
		if(nowBean.getSecondTime()==null) {
			nowBean.setSecondTime(new Date());
			nowBean.setSecondQty(new BigDecimal(lblWeightValue.getText()));
			nowBean.setSuttleQty(nowBean.getSecondQty().subtract(nowBean.getFirstQty()).abs());
		}
		
		WeightPlatformFacadeFactory.getRemoteInstance().insertOrUpdateWeightInfo(nowBean);
		MsgBox.showInfo("过磅完成！");
	}

	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		this.kDTable1.getStyleAttributes().setLocked(true);
		this.kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
		int lastCount=6;
		lastValue= new double[lastCount];
		for(int i=0;i<lastCount;i++) {
			lastValue[i]=0;
		}
		addActionListeners();
		this.kDTable1.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				tableSelected_changed(e);
			}});
		initComReader();
		new Thread(new controlThread()).start();
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

	/**
	 * 执行查询
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	private void exeQuery() throws BOSException, SQLException {
		String weightNum = this.txtWeightNum.getText();
		if (StringUtils.isBlank(weightNum)) {
			MsgBox.showWarning("过磅码不能为空！");
			return;
		}
		
		fillControlByWeightBean(null);
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select fid,fnumber,cfcarNum,to_char(FbizDate,'yyyy-MM-dd') FbizDate,cfQty,")
		.append(" CFstatus,CFweightNum,to_char(cffirstWeighttime,'yyyy-MM-dd HH:mm:ss') cffirstWeighttime,to_char(cfsecondWeightTime,'yyyy-MM-dd HH:mm:ss') cfsecondWeightTime,")
		.append(" cffirstWeightQty,cfSecondWeightQty,cfsuttltQty")
		.append(" from CT_WEI_CarSendBill")//派车单
		.append(" where cfWeightNum='").append(weightNum).append("'")
		.append(" or cfcarNum in (")
		.append(" select cfcarNum from CT_WEI_CarSendBill where cfWeightNum='").append(weightNum).append("'")
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
			bean.setWeightNum(rs.getString("CFweightNum"));
			bean.setFirstQty(rs.getBigDecimal("cffirstWeightQty"));
			bean.setFirstTime(rs.getDate("cffirstWeighttime"));
			bean.setSecondQty(rs.getBigDecimal("cfSecondWeightQty"));
			bean.setSecondTime(rs.getDate("cfsecondWeightTime"));
			bean.setSuttleQty(rs.getBigDecimal("cfsuttltQty"));
			row.setUserObject(bean);
			
			row.getCell("id").setValue(bean.getBillID());
			row.getCell("carNum").setValue(bean.getCarNum());
			row.getCell("bizDate").setValue(bean.getBizDate());
			row.getCell("qty").setValue(bean.getQty());
			row.getCell("status").setValue(rs.getString("CFstatus"));
			row.getCell("weightNum").setValue(bean.getWeightNum());
			
			//过磅码相等
			if(bean.getWeightNum().equals(weightNum)) {
				row.getStyleAttributes().setBackground(new Color(0,162,232));//蓝色
				fillControlByWeightBean(bean);
			}
			//已经过磅完成了
			if(bean.getFirstTime()!=null&&bean.getSecondTime()!=null) {
				row.getStyleAttributes().setBackground(new Color(107,201,31));//绿色
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
		isCanWeight=true;
		btnWeight.setEnabled(false);
		if(bean!=null) {
			txtCarNum.setText(bean.getCarNum());
			txtBillNum.setText(bean.getBillNum());
			txtBillQty.setValue(bean.getQty());
			txtFirstQty.setValue(bean.getFirstQty());
			txtFirstTime.setText(sdf.format(bean.getFirstTime()));
			txtSecondQty.setValue(bean.getSecondQty());
			txtSecondTime.setText(sdf.format(bean.getSecondTime()));
			txtSuttleQty.setValue(bean.getSuttleQty());
			
			if(bean.getFirstTime()!=null&&bean.getSecondTime()!=null) {
				isCanWeight=true;
			}else {
				btnWeight.setEnabled(true);
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
		this.btnI.addActionListener(acLs);
		this.btnJ.addActionListener(acLs);
		this.btnK.addActionListener(acLs);
		this.btnL.addActionListener(acLs);
		this.btnM.addActionListener(acLs);
		this.btnN.addActionListener(acLs);
		this.btnSub.addActionListener(acLs);
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
			String btnName = ((KDButton) e.getSource()).getName();
			String oldNum = txtWeightNum.getText() == null ? "" : txtWeightNum.getText().trim();
			if (btnName.length() == 4 && !btnName.toLowerCase().contains("sub")) {
				txtWeightNum.setText(oldNum + btnName.substring(3));
			} else if (e.getSource().equals(btnBackspace) && oldNum.length() > 0) {
				txtWeightNum.setText(oldNum.substring(0, oldNum.length() - 1));
			} else if (e.getSource().equals(btnClear)) {
				txtWeightNum.setText(null);
			} else if (e.getSource().equals(btnSub)) {
				txtWeightNum.setText(oldNum + "-");
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
		if (info == null)
			return;
		portName = info.getPort().getName();
		baudRate = info.getBaudRate();// 波特率
		dataBit = Integer.parseInt(info.getDataBits().getValue());// 数据位
		stopBit = Integer.parseInt(info.getStopBits().getValue());// 停止位
		parityBit = Integer.parseInt(info.getParity().getValue());// 奇偶校验位
		beginChar = info.getBeginChar();
		endChar = info.getEndChar();
		jsScriptStr = info.getTxtJSScript();
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
	public void closePort() throws Exception {
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
					inputStream.read(readBuffer);
					String receivedMsg = new String(readBuffer).trim();
					System.out.println("磅秤 原始数据 ：" + receivedMsg);

					if (StringUtils.isNotBlank(beginChar) && StringUtils.isNotBlank(endChar)) {
						if (receivedMsg.length() < (beginChar.length() + endChar.length())) {
							portValueString = "0.00";
						}
						int beginIndex = receivedMsg.indexOf(beginChar);
						int endIndex = receivedMsg.indexOf(endChar, beginIndex + beginChar.length());
						portValueString = receivedMsg.substring(beginIndex + beginChar.length(), endIndex).trim();
					}
					if (inputStream != null)
						inputStream.close();
					System.out.println("磅秤 截取后 数据 ：" + receivedMsg);

					System.out.println("script :" + jsScriptStr);
					// MsgBox.showInfo("脚本前："+retValue);
					if (StringUtils.isNotBlank(jsScriptStr)) {
						portValueString = getValueByJSScript(this.jsScriptStr, portValueString);// 通过JS脚本解析数据
					}
					if (StringUtils.isNotBlank(portValueString)) {
						portValueString = StringUtils.trim(portValueString);
					}
					System.out.println("脚本返回值：" + portValueString);

					BigDecimal retBigDecimalValue = new BigDecimal(portValueString);
					if (retBigDecimalValue != null) {
						portValueString = (retBigDecimalValue.divide(new BigDecimal("1"), 2, RoundingMode.HALF_UP)).toPlainString();
					} else {
						portValueString = "0.00";
					}
				}
			} catch (Exception e) {
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
	private class controlThread implements Runnable {
		public void run() {
			boolean isExistDiff;
			while(true) {
				try {
					//*****控件显示******
					lblWeightValue.setText(portValueString);
					//*****判断是否稳定******
					portValue=Double.valueOf(portValueString);
					
					isExistDiff=false;
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
					if(isExistDiff) {
						lblStatus.setText("读数不稳定");
					}else {
						lblStatus.setText("读数稳定");
					}
					//读数值<=0
					if(nowBean==null||!isExistDiff||portValue<=0) {
						btnWeight.setEnabled(false);
					}else {
						//稳定后才可以设置为可用
						if(isCanWeight) {
							btnWeight.setEnabled(true);
						}
					}
					//0.5S验证一次
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					handleException(e);
				}
			}
		}
	}
}