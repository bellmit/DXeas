package com.kingdee.eas.custom.wlhllicensemanager.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import net.sf.json.JSONObject;
import sun.misc.BASE64Decoder;

import com.kingdee.bos.Context;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.base.license.LicenseException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.client.EditUI;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * 
 * ��˵����wlhl��ɹ�����
 * @author dai_andong
 * 2017-7-10
 */
public class WlhlLicenseUtil {
	private static HashMap<String,Integer> licenseOnLineMap=null;
	private static HashMap<String,String> modulesMap=null;
	
	/**
	 * ��ȡ���к�
	 * @throws LicenseException 
	 * @throws EASBizException 
	 */
	public static void setLicenseMap(Context ctx) throws  EASBizException {
		if(licenseOnLineMap!=null) {
//			return;
		}
		String eas_home=System.getProperty("EAS_HOME");
		//��ǰclass·��
        String jarPath = WlhlLicenseUtil.class.getResource("").getFile();
        System.out.println("jar/class·����"+jarPath);
        jarPath=jarPath.substring(1, jarPath.length())+"WlhlLicenseUtil.jar";
		String split=File.separator;
		String licensePath=eas_home+split+"server"+split+"properties"+split+"wlhlLicense.dat";
		try {
			File file=new File(licensePath);
			if(!file.exists()) {
				throw new EASBizException(new NumericExceptionSubItem("","License�ļ������ڣ�"));
			}

			String cpuID=getCPUID();
			
			FileInputStream in=new FileInputStream(file);
			byte[] b=new byte[1000];
			in.read(b);
			in.close();
			
			String snStr=new String(b).trim();
			String dd="";//MD5Util.getMD5String(getCPUID());
				
			snStr=AESDecode(dd, snStr);
			JSONObject snJo=JSONObject.fromObject(snStr);
			if(!snJo.containsKey("SNKEY")||!snJo.containsKey("JARMD5")) {
				throw new EASBizException(new NumericExceptionSubItem("","License��ʽ����ȷ"));
			}
			if(!snJo.getString("SNKEY").equals(cpuID)) {
				throw new EASBizException(new NumericExceptionSubItem("","License��Ч(001)"));
			}
			cpuID="";//MD5Util.getFileMD5String(new File(jarPath));
			if(!snJo.getString("JARMD5").equals(cpuID)) {
				throw new EASBizException(new NumericExceptionSubItem("","License��Ч(002)"));
			}
			/*if(!snJo.containsKey("MODULES")) {
				throw new EASBizException(new NumericExceptionSubItem("","License��Ч(003)"));
			}
			modulesMap=new HashMap<String, String>();
			JSONArray moduleJA=snJo.getJSONArray("MODULES");
			for(int i=0;i<moduleJA.size();i++) {
				
			}*/
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("",e.getMessage()));
		}
		licenseOnLineMap=new HashMap<String, Integer>();
	}
	
	/**
	 * Ȩ��У��
	 * @throws EASBizException 
	 */
	public static void checkLicense(Context ctx,BOSObjectType bosType) throws EASBizException {
		setLicenseMap(ctx);
		/*String key=bosType.toString();
		if(!licenseOnLineMap.containsKey(key)) {//||licenseOnLineMap.get(key)<=0
			throw new EASBizException(new NumericExceptionSubItem("","ģ��������Ŀ�Ѿ���������ϣ�"));
		}
		licenseOnLineMap.put(key,licenseOnLineMap.get(key)+1);*/
	}
	
	/**
	 * �ͷ����
	 * @param ctx
	 * @param billName
	 * @param fuctionName
	 */
	public static void releaseLicense(Context ctx,BOSObjectType bosType) {
		String key=bosType.toString();
		licenseOnLineMap.put(key,licenseOnLineMap.get(key)-1);
	}
	/**
	 * ����
	 * @param encodeRules
	 * @param content
	 * @return
	 */
	 private static String AESDecode(String encodeRules,String content){
        try {
            //1.������Կ��������ָ��ΪAES�㷨,�����ִ�Сд
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            //2.����ecnodeRules�����ʼ����Կ������
            //����һ��128λ�����Դ,���ݴ�����ֽ�����
            keygen.init(128, new SecureRandom(encodeRules.getBytes()));
              //3.����ԭʼ�Գ���Կ
            SecretKey original_key=keygen.generateKey();
              //4.���ԭʼ�Գ���Կ���ֽ�����
            byte [] raw=original_key.getEncoded();
            //5.�����ֽ���������AES��Կ
            SecretKey key=new SecretKeySpec(raw, "AES");
              //6.����ָ���㷨AES�Գ�������
            Cipher cipher=Cipher.getInstance("AES");
              //7.��ʼ������������һ������Ϊ����(Encrypt_mode)���߽���(Decrypt_mode)�������ڶ�������Ϊʹ�õ�KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.�����ܲ����������ݽ�����ֽ�����
            byte [] byte_content= new BASE64Decoder().decodeBuffer(content);
            /*
             * ����
             */
            byte [] byte_decode=cipher.doFinal(byte_content);
            String AES_decode=new String(byte_decode,"utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        
        //����д�ͷ���nulll
        return null;         
	 }
	 /**
	  * ��ȡcpu���к�
	  * @throws IOException
	  */
	 private static String getCPUID() throws IOException {
		 Process process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
		 process.getOutputStream().close();
		 Scanner sc = new Scanner(process.getInputStream());
		 String property = sc.next();
		 String serial = sc.next();
		 process.getInputStream().close();
//		 System.out.println(property + ": " + serial);
		 return serial;
	 }
	 /**
	 * ͨ�^���CIP�@ȡ���CMAC��ַ
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	private static String getLocalMac() throws SocketException, UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost();
		// TODO Auto-generated method stub
		//��ȡ��������ȡ��ַ
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
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
				sb.append("0");		
			}else {
				sb.append(str);
			}
		}
		//System.out.println("����MAC��ַ:"+sb.toString().toUpperCase());
		return sb.toString().toUpperCase();
	}
}
