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
 * com �ڶ�ȡͨ�ýӿ�
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
	private String portName = "COM1"; // �˿�����
	private int baudRate = 2400; // ������
	private int dataBit = 8; // ����λ
	private int stopBit = 1; // ֹͣλ
	private int parityBit = 0; // ��żУ��λ
	private CommPortIdentifier portID = null; // �˿�ID
	private SerialPort serialPort = null; // comm�˿�
	private OutputStream outputStream = null; // �˿������
	private InputStream inputStream = null; // �˿�������
	private String portValueString=null;//��ǰ�˿ڔ���
	private Boolean isOpened=false;//�Ƿ���_
	private String beginChar=null;//��ʼ�ַ�
	private String endChar=null;//�����ַ�
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
	
	// �˿ڲ�������
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
		baudRate = info.getBaudRate();// ������
		dataBit = Integer.parseInt(info.getDataBits().getValue());// ����λ
		stopBit = Integer.parseInt(info.getStopBits().getValue());// ֹͣλ
		parityBit = Integer.parseInt(info.getParity().getValue());// ��żУ��λ
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
	

	
	// �˿ڲ�������
	private void setCommPortParams(WeighBridgeInfo info,int maxCount) throws Exception {
		if(info==null)
			return;
		if(maxCount<=0) {
			maxCount=1;
		}
		this.maxCount=maxCount;
		
		portName = info.getPort().getName();
		baudRate = info.getBaudRate();// ������
		dataBit = Integer.parseInt(info.getDataBits().getValue());// ����λ
		stopBit = Integer.parseInt(info.getStopBits().getValue());// ֹͣλ
		parityBit = Integer.parseInt(info.getParity().getValue());// ��żУ��λ
		beginChar=info.getBeginChar();
		endChar=info.getEndChar();
		jsScriptStr=info.getTxtJSScript();
	}

	
	/**
	 * �򿪴���
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void openPort() throws Exception {
		try {
			portID = CommPortIdentifier.getPortIdentifier(portName);
			serialPort = (SerialPort) portID.open("PORT_SERIAL", 1000);
			isOpened=true;
			System.out.println("##############�˿��Ѿ���############");
			initComPort();
		} catch (NoSuchPortException e) {
			throw new Exception("�˿�" + portName + "�����ڣ�");
		} catch (PortInUseException e) {
			throw new Exception("�˿�" + portName + "�ѱ�ռ�ã�");
		}
	}
	
	/**
	 * �򿪴���
	 * 
	 * @param name
	 * @throws Exception
	 */
	public void openPortAutoRead() throws Exception {
		try {
			portID = CommPortIdentifier.getPortIdentifier(portName);
			serialPort = (SerialPort) portID.open("PORT_SERIAL", 1000);
			isOpened=true;
			System.out.println("##############�˿��Ѿ���############");
			this.initComPortAutoRead();
		} catch (NoSuchPortException e) {
			throw new Exception("�˿�" + portName + "�����ڣ�");
		} catch (PortInUseException e) {
			throw new Exception("�˿�" + portName + "�ѱ�ռ�ã�");
		}
	}
	/**
	 * ��ʼ���˿� ����
	 * 
	 * @throws Exception
	 */
	public void initComPort() throws Exception {
		// ��ʼ���˿ڵ����Ӳ���������˳�򣺲����ʡ�����λ��ֹͣλ����żУ��λ 9600��8��1��0
		try {
			serialPort.setSerialPortParams(baudRate, dataBit, stopBit, parityBit);
			// ��ʼ���˿ڵ����롢�����
		}catch (UnsupportedCommOperationException e) {
			throw new Exception(e);
			/*
			 * MsgBox.showInfo("�˿ڲ�������ʧ��......"); SysUtil.abort(); return false;
			 */
		}
	}
	/**
	 * ��ʼ���˿� ���� �Ԅ��xȡ����
	 * 
	 * @throws Exception
	 */
	private void initComPortAutoRead() throws Exception {
		// ��ʼ���˿ڵ����Ӳ���������˳�򣺲����ʡ�����λ��ֹͣλ����żУ��λ 9600��8��1��0
		try {
			serialPort.setSerialPortParams(baudRate, dataBit, stopBit, parityBit);
			// ��ʼ���˿ڵ����롢�����
			inputStream = serialPort.getInputStream();
			outputStream = serialPort.getOutputStream();
		} catch (IOException e) {
			throw new Exception(e);
			/*
			 * MsgBox.showInfo("�˿����롢�������ʼ��ʧ��......"); SysUtil.abort();
			 */
		}catch (UnsupportedCommOperationException e) {
			throw new Exception(e);
			/*
			 * MsgBox.showInfo("�˿ڲ�������ʧ��......"); SysUtil.abort(); return false;
			 */
		}
		serialPort.addEventListener(this);//��Ӽ�����
		serialPort.notifyOnDataAvailable(true);
	}
	/**
	 * ��ȡCOM����
	 * 
	 * @throws Exception
	 */
	public String getPortData() throws Exception {
		if (serialPort == null) {
			throw new Exception("�˿���δ��!");
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
	 * ��ȡCOM����
	 * 
	 * @throws Exception
	 */
	public String getPortDataNew() throws Exception {
		if (serialPort == null) {
			throw new Exception("�˿���δ��!");
		}
		return this.readNew();
	}
	
	/**
	 * �@ȡ �˿� ݔ���ַ���
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
					logger.debug("����ԭʼ���� ��"+retValue);
					retValue = receivedMsg;
					int beginIndex = receivedMsg.indexOf(beginChar);
					if(StringUtils.isNotBlank(beginChar)&&StringUtils.isNotBlank(endChar)) {
						if(receivedMsg.length()<(beginChar.length()+endChar.length())) {
							return "0.00";
						}
						 int endIndex = receivedMsg.indexOf(endChar, beginIndex +beginChar.length());
//						 System.out.println("����1"+receivedMsg+"|"+(beginIndex+beginChar.length())+"|"+endIndex);
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
					System.out.println("���� ���� ��"+retValue);
					logger.debug("���ӽ�ȡ������ ��"+retValue);
					
					//System.out.println("script :" + jsScriptStr);
//					MsgBox.showInfo("�ű�ǰ��"+retValue);
					if(StringUtils.isNotBlank(jsScriptStr)) {
						retValue=getValueByJSScript(this.jsScriptStr,retValue);//ͨ��JS�ű���������
					}
					if(StringUtils.isNotBlank(retValue)){
						retValue = StringUtils.trim(retValue);
					}
//					MsgBox.showInfo("�ű���"+retValue);
//					System.out.println("�ű�����ֵ��"+retValue);
					logger.debug("�ű�����ֵ��"+retValue);
					
					BigDecimal retBigDecimalValue = new BigDecimal(retValue);
					if(retBigDecimalValue != null){
						retValue = (retBigDecimalValue.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP)).toPlainString();
					}else{
						retValue = "0";
					}
//					retValue=retBigDecimalValue.setScale(2,BigDecimal.ROUND_HALF_UP).toString();//������λС��
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
		//System.out.println("�õ������"+retValue);
		this.returnValue=retValue;
		return retValue;
	}
	/**
	 * �رն˿�
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
			System.out.println("***************�˿��Ѿ��ر�************8");
		} catch (IOException e) {
			e.printStackTrace();
			//throw new Exception(e);
			/*
			 * e.printStackTrace(); MsgBox.showInfo("�˿ڹر�ʧ��......");
			 * SysUtil.abort();
			 */
		}
}
 /**
  * �@ȡ �˿� ݔ���ַ���
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
	 * �@ȡ �˿� ݔ���ַ���
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
					
					System.out.println("���� ԭʼ���� ��"+receivedMsg);
					//��ȡ��Ч�ַ�
					if(StringUtils.isNotBlank(beginChar)) {
//						receivedMsg=receivedMsg.substring(receivedMsg.indexOf(beginChar));
//						System.out.println("���� ��ȡ������ ��"+receivedMsg);
					}
					// ���λ����������ݹ�ȡ��
					if(receivedMsg == null || receivedMsg.length() < 8){
//						System.out.println("������Ч�����¶�ȡ");
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
				System.out.println("�ۼӺ�����:"+tempStr+":��"+(readCount-1)+"��");
			}else {
				//System.out.println("����Ч����:"+tempStr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		retValue=tempStr;
		//��ȡ����Ϊ3��
		if(readCount>maxCount) {
			try{
				System.out.println("�����������,���� ��ȡ ���ݣ�ִ�нű�ǰ�� ��"+retValue);
				
				System.out.println("script :" + jsScriptStr);
	//			MsgBox.showInfo("�ű�ǰ��"+retValue);
				if(StringUtils.isNotBlank(jsScriptStr)) {
					retValue=getValueByJSScript(this.jsScriptStr,retValue);//ͨ��JS�ű���������
				}
				if(StringUtils.isNotBlank(retValue)){
					retValue = StringUtils.trim(retValue);
				}
	//			MsgBox.showInfo("�ű���"+retValue);
				System.out.println("�ű�����ֵ��"+retValue);
				
				BigDecimal retBigDecimalValue = new BigDecimal(retValue);
				if(retBigDecimalValue != null){
					retValue = (retBigDecimalValue.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP)).toPlainString();
				}else{
					retValue = "0";
				}
	//			retValue=retBigDecimalValue.setScale(2,BigDecimal.ROUND_HALF_UP).toString();//������λС��
			}catch(Exception ee) {
				retValue="Read error!";
				retValue = "";
				ee.printStackTrace();
			}
		}
		//System.out.println("�õ������"+retValue);
		this.returnValue=retValue;
		return retValue;
	}
	/**
	 * ͨ��JS�ű���ȡ��
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
	 * BI -ͨѶ�ж�. CD -�ز����. CTS -�������. DATA_AVAILABLE -�����ݵ���. DSR -�����豸׼����. FE
	 * -֡����. OE -��λ����. OUTPUT_BUFFER_EMPTY -��������������. PE -��żУ���. RI - ����ָʾ.
	 * һ����õľ���DATA_AVAILABLE--���������ݵ����¼���
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
	* 16���������ַ���
	*/
	private static String hexString = "0123456789ABCDEF";
	/*
	* ���ַ��������16��������,�����������ַ����������ģ�
	*/
	public static String encode(String str) {
	   // ����Ĭ�ϱ����ȡ�ֽ�����
	   byte[] bytes = str.getBytes();
	   StringBuilder sb = new StringBuilder(bytes.length * 2);
	   // ���ֽ�������ÿ���ֽڲ���2λ16��������
	   for (int i = 0; i < bytes.length; i++) {
	    sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
	    sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
	   }
	   return sb.toString();
	}
	/*
	* ��16�������ֽ�����ַ���,�����������ַ����������ģ�
	*/
	public static String decode(String bytes) {
	   ByteArrayOutputStream baos = new ByteArrayOutputStream(
	     bytes.length() / 2);
	   // ��ÿ2λ16����������װ��һ���ֽ�
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
			System.out.print("�ļ�����");
		} else {
			System.out.print("�ļ�������");
			f.createNewFile();// �������򴴽�
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
	 * �@ȡ�˿ڔ���
	 * @return
	 */
	public String getPortValueString() {
		return portValueString;
	}

	public Boolean isOpened() {
		return isOpened;
	}
	/**
	 * ͨ�^���CIP�@ȡ���CMAC��ַ
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String getLocalMac() throws SocketException, UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		// TODO Auto-generated method stub
		//��ȡ��������ȡ��ַ
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
		//String s=new String(mac);
		//System.out.println("mac���鳤�ȣ�"+mac.length);
		StringBuffer sb = new StringBuffer("");
		for(int i=0; i<mac.length; i++) {
			if(i!=0) {
				sb.append("-");
			}
			//�ֽ�ת��Ϊ����
			int temp = mac[i]&0xff;
			String str = Integer.toHexString(temp);
			//System.out.println("ÿ8λ:"+str);
			if(str.length()==1) {
				sb.append("0"+str);
			}else {
				sb.append(str);
			}
		}
		System.out.println("����MAC��ַ:"+sb.toString().toUpperCase());
		return sb.toString().toUpperCase();
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}