/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class AttendanceDockingSettingEditUI extends AbstractAttendanceDockingSettingEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AttendanceDockingSettingEditUI.class);
    
    /**
     * output class constructor
     */
    public AttendanceDockingSettingEditUI() throws Exception
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
        return com.kingdee.eas.custom.wages.AttendanceDockingSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.wages.AttendanceDockingSettingInfo objectValue = new com.kingdee.eas.custom.wages.AttendanceDockingSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
	@Override
	protected void btnGet_actionPerformed(ActionEvent e) throws Exception {
		//this.txtcpuId.setText(getCPUID());
		this.txtcpuId.setText(getLocalMac());
	}

	 /**
	  * 获取cpu序列号
	  * @throws IOException
	  */
	 public static String getCPUID() throws IOException {
		 Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
		 process.getOutputStream().close();
		 Scanner sc = new Scanner(process.getInputStream());
		 String property = sc.next();
		 String serial = sc.next();
		 process.getInputStream().close();
		 System.out.println(property + ": " + serial);
		 return serial;
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
}