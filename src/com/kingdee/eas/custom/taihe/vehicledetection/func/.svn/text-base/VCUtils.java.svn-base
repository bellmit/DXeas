package com.kingdee.eas.custom.taihe.vehicledetection.func;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VCUtils {
	//保存图片
	public static void savePic(String strIP, String strNumber, byte[] data, int type, long lTime)
	{
		String strPath = "D:/抓拍_java/";
		Date now = null;
		
		if(lTime == 0)
			now = new Date();
		else
			now = new Date(lTime);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String dateNow = dateFormat.format(now);
		String dateNow2 = dateFormat2.format(now);
		
		strPath += strIP + "/" + dateNow;
		File file = new File(strPath);
		if(!file.exists())
		{
			file.mkdirs();
		}
		String filename = strPath + "/" + dateNow2 + "_" + strNumber;
		filename = filename.trim();
		
		if(1 == type)//车牌图
		{
			filename += "_plate";
		}
		else if(2 == type)//手动抓拍图
		{
			filename += "_Capture";
		}
		else if(3 == type)//软触发图
		{
			filename += "_trigger";
		}
		filename += ".jpg";
		
		
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
			out.write(data);
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
//		FileImageOutputStream imgOut;
//		try {
//			imgOut = new FileImageOutputStream(new File(filename));
//			imgOut.write(data, off, len);
//			imgOut.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
