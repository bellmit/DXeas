package com.kingdee.eas.wlhlcomm.client;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JComponent;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.weighbridge.PortNum;

public class BaseComReaderUtils extends Timer implements SerialPortEventListener,Runnable  {
	private static final Logger logger = CoreUIObject.getLogger(BaseComReaderUtils.class);
	private String portName = "COM1"; // 端口名称
	private int baudRate = 2400; // 波特率
	private int dataBit = 8; // 数据位
	private int stopBit = 1; // 停止位
	private int parityBit = 0; // 奇偶校验位
	private CommPortIdentifier portID = null; // 端口ID
	private SerialPort serialPort = null; // comm端口
	private OutputStream outputStream = null; // 端口输出流
	private InputStream inputStream = null; // 端口输入流
	private Boolean isOpened=false;//是否打開
	private String beginChar=null;//开始字符
	private String endChar=null;//结束字符
	private String jsScriptStr=null;
	private String returnValue;
	private Boolean isReadFinish=false;//是否读取完成
	private JComponent jc;//控件
	

	public BaseComReaderUtils(IObjectValue objectValue) throws Exception {
		setCommPortParams(objectValue);
	}
	public BaseComReaderUtils(IObjectValue objectValue,JComponent jc) throws Exception {
		this.jc=jc;
		setCommPortParams(objectValue);
	}
	public static void main(String[] args) {
		try {
			BaseComReaderUtils c=new BaseComReaderUtils(null);
			/*c.openPort();
			String ss=c.getPortData();
			System.out.println(ss);
			c.closePort();*/
			c.openPortAutoRead();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 端口参数设置
	private void setCommPortParams(IObjectValue objectValue) throws Exception {
		if(objectValue==null)
			return;
		portName =objectValue.get("Port").toString();
		portName=PortNum.getEnum(portName).getName();
		baudRate =objectValue.getInt("BaudRate");// 波特率
		dataBit = objectValue.getInt("DataBits");// 数据位
		stopBit = objectValue.getInt("StopBits");// 停止位
		parityBit = objectValue.getInt("Parity");// 奇偶校验位
		beginChar=objectValue.getString("beginChar");
		endChar=objectValue.getString("endChar");
		jsScriptStr=objectValue.getString("txtJSScript");
	}
	
	/**
	 * 打开串口
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void openPort() throws Exception {
		try {
			portID = CommPortIdentifier.getPortIdentifier(portName);
			serialPort = (SerialPort) portID.open("PORT_SERIAL", 1000);
			setIsOpened(true);
			System.out.println("##############端口已经打开############");
			initComPort();
		} catch (NoSuchPortException e) {
			throw new Exception("端口" + portName + "不存在！");
		} catch (PortInUseException e) {
			throw new Exception("端口" + portName + "已被占用！");
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
			setIsOpened(true);
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
		}catch (UnsupportedCommOperationException e) {
			throw new Exception(e);
			/*
			 * MsgBox.showInfo("端口参数设置失败......"); SysUtil.abort(); return false;
			 */
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
			/*
			 * MsgBox.showInfo("端口输入、输出流初始化失败......"); SysUtil.abort();
			 */
		}catch (UnsupportedCommOperationException e) {
			throw new Exception(e);
			/*
			 * MsgBox.showInfo("端口参数设置失败......"); SysUtil.abort(); return false;
			 */
		}
		serialPort.addEventListener(this);//添加监听器
		serialPort.notifyOnDataAvailable(true);
	}
	/**
	 * 读取COM数据
	 * 
	 * @throws Exception
	 */
	public String getPortData() throws Exception {
		if (serialPort == null) {
			throw new Exception("端口尚未打开!");
		}
		return this.read();
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
				isOpened=false;
				serialPort.close();
				serialPort = null;
			}
			System.out.println("***************端口已经关闭************8");
		} catch (IOException e) {
			e.printStackTrace();
			//throw new Exception(e);
			/*
			 * e.printStackTrace(); MsgBox.showInfo("端口关闭失败......");
			 * SysUtil.abort();
			 */
		}
}
	/**
	 * 獲取 端口 輸入字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	protected String read() throws Exception {
		String retValue = "0";
		try {
			byte[] readBuffer = new byte[200];
			while(true) {
				inputStream = serialPort.getInputStream();
				if (inputStream.available() > 0) {
					inputStream.read(readBuffer);
					String receivedMsg = new String(readBuffer).trim();
					retValue = receivedMsg;
					if (StringUtils.isNotBlank(beginChar) && StringUtils.isNotBlank(endChar)) {
						if (receivedMsg.length() < (beginChar.length() + endChar.length())) {
							return "";
						}
						int beginIndex = receivedMsg.indexOf(beginChar);
						int endIndex = receivedMsg.indexOf(endChar, beginIndex + beginChar.length());
						retValue = receivedMsg.substring(beginIndex + beginChar.length(), endIndex).trim();
					}
					if (inputStream != null)
						inputStream.close();
					try {
						System.out.println("script :" + jsScriptStr);
						if (StringUtils.isNotBlank(jsScriptStr)) {
							retValue = getValueByJSScript(this.jsScriptStr, retValue);// 通过JS脚本解析数据
						}
						if (StringUtils.isNotBlank(retValue)) {
							retValue = StringUtils.trim(retValue);
						}
					} catch (Exception ee) {
						retValue = "Read error!";
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.returnValue = retValue;
		return retValue;
	}
	/**
	 * 通过JS脚本来取数
	 * @param jsString
	 * @return
	 * @throws BOSException 
	 */
	public static String getValueByJSScript(String jsString,String valueString) throws BOSException {
		try{
			ScriptEngineManager mgr = new ScriptEngineManager();    
			ScriptEngine engine = mgr.getEngineByMimeType("application/javascript");
			 engine.eval(jsString);   
		    Invocable inv = (Invocable) engine;   
		    String res = (String) inv.invokeFunction("getValue", valueString);   
		    return res;
		}catch(Exception e) {
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
			byte[] readBuffer = new byte[20];
			try {
				while (inputStream.available() > 0) {
					inputStream.read(readBuffer);
					String receivedMsg = new String(readBuffer).trim();
					if (StringUtils.isNotBlank(beginChar) && StringUtils.isNotBlank(endChar)) {
						if (receivedMsg.length() < (beginChar.length() + endChar.length())) {
							receivedMsg = "";
						}
						int beginIndex = receivedMsg.indexOf(beginChar);
						int endIndex = receivedMsg.indexOf(endChar, beginIndex + beginChar.length());
						receivedMsg = receivedMsg.substring(beginIndex + beginChar.length(), endIndex).trim();
					}
					this.setReturnValue(receivedMsg);
					this.setIsReadFinish(true);
				}
			} catch (IOException e) {
				logger.error(e);
			}
			break;
		}
	}
	/*
	* 16进制数字字符集
	*/
	private static String hexString = "0123456789ABCDEF";
	/*
	* 将字符串编码成16进制数字,适用于所有字符（包括中文）
	*/
	public static String encode(String str) {
	   // 根据默认编码获取字节数组
	   byte[] bytes = str.getBytes();
	   StringBuilder sb = new StringBuilder(bytes.length * 2);
	   // 将字节数组中每个字节拆解成2位16进制整数
	   for (int i = 0; i < bytes.length; i++) {
	    sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
	    sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
	   }
	   return sb.toString();
	}
	/*
	* 将16进制数字解码成字符串,适用于所有字符（包括中文）
	*/
	public static String decode(String bytes) {
	   ByteArrayOutputStream baos = new ByteArrayOutputStream(
	     bytes.length() / 2);
	   // 将每2位16进制整数组装成一个字节
	   for (int i = 0; i < bytes.length(); i += 2)
	    baos.write((hexString.indexOf(bytes.charAt(i)) << 4 | hexString
	      .indexOf(bytes.charAt(i + 1))));
	   return new String(baos.toByteArray());
	}

	public void addtxt(String s) throws IOException {
		String s1 = "";
		String s2 = "";
		File f = new File("d:\\123.txt");
		if (f.exists()) {
			System.out.print("文件存在");
		} else {
			System.out.print("文件不存在");
			f.createNewFile();// 不存在则创建
		}
		BufferedReader input = new BufferedReader(new FileReader(f));
		while ((s2 = input.readLine()) != null) {
			s1 += s2 + "\r\n";
		}
		System.out.println(s);
		input.close();

		s1 += s + "\r\n";

		BufferedWriter output = new BufferedWriter(new FileWriter(f));
		output.write(s1);
		output.flush();
		output.close();
	}

	public void run() {
		if(!this.getIsOpened()) {
			try {
				this.openPortAutoRead();//打开自动模式
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while(true) {
			if(this.getIsReadFinish()) {//已经完成读数，退出循环
				break;
			}
		}
	}

	public Boolean getIsOpened() {
		return isOpened;
	}

	public void setIsOpened(Boolean isOpened) {
		this.isOpened = isOpened;
	}

	public Boolean getIsReadFinish() {
		return isReadFinish;
	}

	public void setIsReadFinish(Boolean isReadFinish) {
		this.isReadFinish = isReadFinish;
	}

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}
	public JComponent getJc() {
		return jc;
	}
	public void setJc(JComponent jc) {
		this.jc = jc;
	}
	
}
