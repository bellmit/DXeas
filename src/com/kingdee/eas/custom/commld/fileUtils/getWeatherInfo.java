package com.kingdee.eas.custom.commld.fileUtils;


import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.FileReader;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.UnsupportedEncodingException;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.net.URLConnection;  
import java.net.URLEncoder;  
import java.nio.charset.Charset;  
import java.util.Date;  
import java.util.HashMap;  
import java.util.Map;  

public class getWeatherInfo {

	
	  
	                //���ݳ��л�ȡ������Ϣ��java����  
	                //cityName ����Ҫȡ��������Ϣ�ĳ��е��������֣��硰�������������ڡ�  
	      public  static String  getWeatherInform(String cityName){  
	          
	            //�ٶ�����API  
	            String baiduUrl = "http://api.map.baidu.com/telematics/v3/weather?location=����&output=json&ak=W69oaDTCfuGwzNwmtVvgWfGH";  
	            StringBuffer strBuf;  
	      
	            try {                              
	                                //ͨ�������ֱ�ӷ���http://api.map.baidu.com/telematics/v3/weather?location=����&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ  
	                                //5slgyqGDENN7Sy7pw29IUvrZ �����Լ������һ��AK(�����)��������ʲ��ˣ������Լ�ȥ����һ���µ�ak  
	                                //�ٶ�ak�����ַ��http://lbsyun.baidu.com/apiconsole/key  
	                                //Ҫ���ʵĵ�ַURL��ͨ��URLEncoder.encode()�����������Ľ���ת��                              
	                baiduUrl = "http://api.map.baidu.com/telematics/v3/weather?location="+URLEncoder.encode(cityName, "utf-8")+"&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ";                    
	            } catch (UnsupportedEncodingException e1) {               
	                e1.printStackTrace();                     
	            }  
	  
	            strBuf = new StringBuffer();  
	                  
	            try{  
	                URL url = new URL(baiduUrl);  
	                URLConnection conn = url.openConnection();  
	                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));//ת�롣  
	                String line = null;  
	                while ((line = reader.readLine()) != null)  
	                    strBuf.append(line + " ");  
	                    reader.close();  
	            }catch(MalformedURLException e) {  
	                e.printStackTrace();   
	            }catch(IOException e){  
	                e.printStackTrace();   
	            }     
	  
	            return strBuf.toString();  
	        }  
}
