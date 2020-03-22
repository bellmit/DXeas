/**
 * output package name
 */
package com.kingdee.eas.weighbridge.comm;

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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.weighbridge.WeighBridgeInfo;

/**
 * com 口读取通用接口
 * 
 * @author Simple_Dai
 * 
 */
public class ComReaderUtils implements SerialPortEventListener,Runnable {
	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}
	private static final Logger logger = CoreUIObject.getLogger(ComReaderUtils.class);
	private String portName = "COM1"; // 端口名称
	private int baudRate = 2400; // 波特率
	private int dataBit = 8; // 数据位
	private int stopBit = 1; // 停止位
	private int parityBit = 0; // 奇偶校验位
	private CommPortIdentifier portID = null; // 端口ID
	private SerialPort serialPort = null; // comm端口
	private OutputStream outputStream = null; // 端口输出流
	private InputStream inputStream = null; // 端口输入流
	private String portValueString=null;//當前端口數據
	private Boolean isOpened=false;//是否打開
	private String beginChar=null;//开始字符
	private String endChar=null;//结束字符
	private String jsScriptStr=null;
	public String returnValue;
	private int readCount=0;
	private int maxCount;

	public ComReaderUtils(WeighBridgeInfo info,int maxCount) throws Exception {
		setCommPortParams(info,maxCount);
	}
	
	public ComReaderUtils(WeighBridgeInfo info,String portName,int maxCount) throws Exception {
		setCommPortParams(info,portName,maxCount);
	}
	
	// 端口参数设置
	private void setCommPortParams(WeighBridgeInfo info,String port,int maxCount) throws Exception {
		if(info==null)
			return;
		if(maxCount<=0) {
			maxCount=1;
		}
		this.maxCount=maxCount;
		if(port==null) {
			this.portName = info.getPort().getName();
		}else {
			this.portName=port;
		}
		baudRate = info.getBaudRate();// 波特率
		dataBit = Integer.parseInt(info.getDataBits().getValue());// 数据位
		stopBit = Integer.parseInt(info.getStopBits().getValue());// 停止位
		parityBit = Integer.parseInt(info.getParity().getValue());// 奇偶校验位
		beginChar=info.getBeginChar();
		endChar=info.getEndChar();
		jsScriptStr=info.getTxtJSScript();
	}
	
	public static void main(String[] args) {
		try {
			ComReaderUtils c=new ComReaderUtils(null,0);
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
	private void setCommPortParams(WeighBridgeInfo info,int maxCount) throws Exception {
		if(info==null)
			return;
		if(maxCount<=0) {
			maxCount=1;
		}
		this.maxCount=maxCount;
		
		portName = info.getPort().getName();
		baudRate = info.getBaudRate();// 波特率
		dataBit = Integer.parseInt(info.getDataBits().getValue());// 数据位
		stopBit = Integer.parseInt(info.getStopBits().getValue());// 停止位
		parityBit = Integer.parseInt(info.getParity().getValue());// 奇偶校验位
		beginChar=info.getBeginChar();
		endChar=info.getEndChar();
		jsScriptStr=info.getTxtJSScript();
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
			isOpened=true;
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
			isOpened=true;
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
		String tempPortValueStr="";
		readCount=1;
		while(true) {
			if(readCount>maxCount) {
				break;
			}
			tempPortValueStr=this.read(tempPortValueStr);
			Thread.sleep(50);
		}
		return tempPortValueStr;
	}

	/**
	 * 读取COM数据
	 * 
	 * @throws Exception
	 */
	public String getPortDataNew() throws Exception {
		if (serialPort == null) {
			throw new Exception("端口尚未打开!");
		}
		return this.readNew();
	}
	
	/**
	 * 獲取 端口 輸入字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	private String readNew() throws Exception {
		String retValue = "0";
		try {
//			Thread.sleep(2000);
			byte[] readBuffer = new byte[200];
			//int i=0;
			//while (true) {
				inputStream = serialPort.getInputStream();
				if(inputStream.available() > 0) {
					inputStream.read(readBuffer);
					String receivedMsg = new String(readBuffer).trim();
					logger.debug("磅秤原始数据 ："+retValue);
					retValue = receivedMsg;
					int beginIndex = receivedMsg.indexOf(beginChar);
					if(StringUtils.isNotBlank(beginChar)&&StringUtils.isNotBlank(endChar)) {
						if(receivedMsg.length()<(beginChar.length()+endChar.length())) {
							return "0.00";
						}
						 int endIndex = receivedMsg.indexOf(endChar, beginIndex +beginChar.length());
//						 System.out.println("测试1"+receivedMsg+"|"+(beginIndex+beginChar.length())+"|"+endIndex);
						 if(endIndex>0) {
							 retValue=receivedMsg.substring(beginIndex+beginChar.length(), endIndex).trim();
						 }else {
							 retValue=receivedMsg.substring(beginIndex+beginChar.length()).trim();
						 }
					}else  {
						 retValue=receivedMsg.substring(beginIndex+beginChar.length()).trim();
					}
					if(inputStream!=null) {
						inputStream.close();
					}
					//if (StringUtils.isNotBlank(retValue)) {
						//break;
					//}
				//}
				//Thread.sleep(200);
				try{
					System.out.println("磅秤 数据 ："+retValue);
					logger.debug("磅秤截取后数据 ："+retValue);
					
					//System.out.println("script :" + jsScriptStr);
//					MsgBox.showInfo("脚本前："+retValue);
					if(StringUtils.isNotBlank(jsScriptStr)) {
						retValue=getValueByJSScript(this.jsScriptStr,retValue);//通过JS脚本解析数据
					}
					if(StringUtils.isNotBlank(retValue)){
						retValue = StringUtils.trim(retValue);
					}
//					MsgBox.showInfo("脚本后："+retValue);
//					System.out.println("脚本返回值："+retValue);
					logger.debug("脚本返回值："+retValue);
					
					BigDecimal retBigDecimalValue = new BigDecimal(retValue);
					if(retBigDecimalValue != null){
						retValue = (retBigDecimalValue.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP)).toPlainString();
					}else{
						retValue = "0";
					}
//					retValue=retBigDecimalValue.setScale(2,BigDecimal.ROUND_HALF_UP).toString();//保留两位小数
				}catch(Exception ee) {
					retValue="Read error!";
//					ee.printStackTrace();
					logger.debug(ee.getMessage());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			//throw new Exception(e);
		}
		//System.out.println("得到结果："+retValue);
		this.returnValue=retValue;
		return retValue;
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
  * @return
  * @throws Exception
  */
	private String readOld() throws Exception {
		String retValue = "0";
		try {
			byte[] readBuffer = new byte[50];
			while (inputStream.available() > 0) {
					inputStream.read(readBuffer);
					String receivedMsg=new String(readBuffer).trim();
					
					int beginIndex = receivedMsg.indexOf("8D");
					int endIndex = receivedMsg.indexOf("8D", beginIndex + 3);
					//receivedMsg=receivedMsg.substring(beginIndex, endIndex);
					System.out.println(receivedMsg);
					retValue=receivedMsg;
					if(true) {
						break;
					}
			}
		} catch (IOException e) {
			throw new Exception(e);
		}
		return retValue;
	}
	/**
	 * 獲取 端口 輸入字符串
	 * 
	 * @return
	 * @throws Exception
	 */
	private String read(String tempStr) throws Exception {
		String retValue = "0";
		try {
//			Thread.sleep(500);
			byte[] readBuffer = new byte[800];
			//int i=0;
			//while (true) {
				inputStream = serialPort.getInputStream();
				if(inputStream.available() > 0) {
					String receivedMsg ="";
					receivedMsg += new String(readBuffer).trim();
					for(int i=0;i<2;i++) {
						if(inputStream.available() > 0) {
							inputStream = serialPort.getInputStream();
							inputStream.read(readBuffer);
							receivedMsg += new String(readBuffer).trim();
						}
					}
					receivedMsg=receivedMsg.replace("\r", "");
					receivedMsg=receivedMsg.replace("\n", "");
					receivedMsg=receivedMsg.replace("\t", "");
					
					System.out.println("磅秤 原始数据 ："+receivedMsg);
					//截取有效字符
					if(StringUtils.isNotBlank(beginChar)) {
//						receivedMsg=receivedMsg.substring(receivedMsg.indexOf(beginChar));
//						System.out.println("磅秤 截取后数据 ："+receivedMsg);
					}
					// 如果位数不够，则递归取数
					if(receivedMsg == null || receivedMsg.length() < 8){
//						System.out.println("数据无效，重新读取");
//						return read(tempStr,isNeedResult);
					}
					retValue = receivedMsg;
					
					if(StringUtils.isNotBlank(beginChar)&&StringUtils.isNotBlank(endChar)) {
						if(receivedMsg.length()<(beginChar.length()+endChar.length())) {
							return "0.00";
						}
						 int beginIndex = receivedMsg.indexOf(beginChar);
						 int endIndex = receivedMsg.indexOf(endChar, beginIndex +beginChar.length());
						 retValue=receivedMsg.substring(beginIndex+beginChar.length(), endIndex).trim();
					}else if(StringUtils.isNotBlank(beginChar)&&StringUtils.isBlank(endChar)) {
						
						 retValue=receivedMsg.trim();
					}
					if(inputStream!=null) {
						inputStream.close();
					}
				tempStr+=retValue;
				readCount++;
				System.out.println("累加后数据:"+tempStr+":第"+(readCount-1)+"次");
			}else {
				//System.out.println("无有效数据:"+tempStr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		retValue=tempStr;
		//读取次数为3次
		if(readCount>maxCount) {
			try{
				System.out.println("返回最后数据,磅秤 截取 数据（执行脚本前） ："+retValue);
				
				System.out.println("script :" + jsScriptStr);
	//			MsgBox.showInfo("脚本前："+retValue);
				if(StringUtils.isNotBlank(jsScriptStr)) {
					retValue=getValueByJSScript(this.jsScriptStr,retValue);//通过JS脚本解析数据
				}
				if(StringUtils.isNotBlank(retValue)){
					retValue = StringUtils.trim(retValue);
				}
	//			MsgBox.showInfo("脚本后："+retValue);
				System.out.println("脚本返回值："+retValue);
				
				BigDecimal retBigDecimalValue = new BigDecimal(retValue);
				if(retBigDecimalValue != null){
					retValue = (retBigDecimalValue.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP)).toPlainString();
				}else{
					retValue = "0";
				}
	//			retValue=retBigDecimalValue.setScale(2,BigDecimal.ROUND_HALF_UP).toString();//保留两位小数
			}catch(Exception ee) {
				retValue="Read error!";
				retValue = "";
				ee.printStackTrace();
			}
		}
		//System.out.println("得到结果："+retValue);
		this.returnValue=retValue;
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
					String receivedMsg=new String(readBuffer).trim();
					if(StringUtils.isNotBlank(beginChar)&&StringUtils.isNotBlank(endChar)) {
						 int beginIndex = receivedMsg.indexOf(beginChar);
						 int endIndex = receivedMsg.indexOf(endChar, beginIndex + 3);
						 receivedMsg=receivedMsg.substring(beginIndex, endIndex);
					}
					portValueString=receivedMsg;
				}
			} catch (IOException e) {
				logger.error(e);
				//throw new Exception(e);
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
	/**
	 * 獲取端口數據
	 * @return
	 */
	public String getPortValueString() {
		return portValueString;
	}

	public Boolean isOpened() {
		return isOpened;
	}
	/**
	 * 通過本機IP獲取本機MAC地址
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String getLocalMac() throws SocketException, UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		// TODO Auto-generated method stub
		//获取网卡，获取地址
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		//String s=new String(mac);
		//System.out.println("mac数组长度："+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//字节转换为整数
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			//System.out.println("每8位:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
		return sb.toString().toUpperCase();
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}