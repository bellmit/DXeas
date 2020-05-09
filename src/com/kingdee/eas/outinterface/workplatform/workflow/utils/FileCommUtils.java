package com.kingdee.eas.outinterface.workplatform.workflow.utils;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.base.attachment.AttachmentCollection;
import com.kingdee.eas.base.attachment.AttachmentFactory;
import com.kingdee.eas.base.attachment.AttachmentInfo;
import com.kingdee.eas.base.attachment.BoAttchAssoCollection;
import com.kingdee.eas.base.attachment.BoAttchAssoFactory;
import com.kingdee.eas.base.attachment.BoAttchAssoInfo;
import com.kingdee.eas.base.attachment.IAttachment;
import com.kingdee.eas.base.attachment.IBoAttchAsso;
import com.kingdee.eas.base.attachment.common.AttachmentManagerFactory;
import com.kingdee.eas.base.attachment.common.AttachmentServerManager;
import com.kingdee.eas.common.EASBizException;

public class FileCommUtils {
	private static Logger logger =
		Logger.getLogger(FileCommUtils.class);

	/**
	 * ����BillID��ȡ����
	 * @param billId
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws IOException
	 */
	public static String getAttachments(Context ctx,String billId) throws BOSException, EASBizException, IOException{

		AttachmentCollection attachments = null; //��������
		IBoAttchAsso iBoAttchAsso = null;
		if(ctx==null) {
			iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance(); //������ҵ���������ӿ�
		} else {
			iBoAttchAsso = BoAttchAssoFactory.getLocalInstance(ctx); //������ҵ���������ӿ�
		}
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("boID", billId));
		view.setFilter(filter);
		BoAttchAssoCollection coll = iBoAttchAsso.getBoAttchAssoCollection(view); //��ѯ����������
		if(coll == null && coll.size() == 0){
			return null;
		}
//		attachments = new AttachmentCollection();
		IAttachment iAttachment = null;
		if(ctx==null){
			iAttachment=AttachmentFactory.getRemoteInstance();
		}else{
			iAttachment=AttachmentFactory.getLocalInstance(ctx);
		}
		JSONArray array=new JSONArray();
		JSONObject json=null;
		for(int i = 0; i < coll.size(); i++){

			BoAttchAssoInfo bo = coll.get(i); //������������
			AttachmentInfo attachment = bo.getAttachment(); //��������
			attachment = iAttachment.getAttachmentInfo(new ObjectUuidPK(attachment.getId()));
//			attachments.add(attachment);
			byte[] fileBytes = attachment.getFile();
			if(fileBytes==null) {
				AttachmentServerManager asm = AttachmentManagerFactory.getServerManager(ctx);
				fileBytes = asm.download(attachment.getId().toString());
			}
			String file = null;
			if(fileBytes!=null) {
				BASE64Encoder encoder = new BASE64Encoder();
				file = encoder.encode(fileBytes);
			}
			json=new JSONObject();
			json.put("attachID", attachment.getString("id"));
//			json.put("content", file);
//			json.put("byteData", fileBytes);
			json.put("name", attachment.getName());
			json.put("type", attachment.getType());
			json.put("simpleName", attachment.getSimpleName());
			json.put("size", attachment.getSize());
			array.add(json);

			/*   ������Դ�ļ�
						BASE64Decoder decoder = new BASE64Decoder();
						byte[] buffer = decoder.decodeBuffer(file);
						FileOutputStream out = new FileOutputStream("D://kd//ppt.xlsx");  
						out.write(buffer);  
						out.close(); 
			 */ 
		}

		JSONObject resultJson=new JSONObject();
		resultJson.put("data", array);
		return resultJson.toString();
	}


	/**
	 * ����BillID��ȡ����
	 * @param billId
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws IOException
	 */
	public static String getAttachmentsDetail(Context ctx,String billId) throws BOSException, EASBizException, IOException{

		AttachmentCollection attachments = null; //��������
		IBoAttchAsso iBoAttchAsso = null;
		if(ctx==null) {
			iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance(); //������ҵ���������ӿ�
		} else {
			iBoAttchAsso = BoAttchAssoFactory.getLocalInstance(ctx); //������ҵ���������ӿ�
		}
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("boID", billId));
		view.setFilter(filter);
		BoAttchAssoCollection coll = iBoAttchAsso.getBoAttchAssoCollection(view); //��ѯ����������
		if(coll == null && coll.size() == 0){
			return null;
		}
//		attachments = new AttachmentCollection();
		IAttachment iAttachment = null;
		if(ctx==null){
			iAttachment=AttachmentFactory.getRemoteInstance();
		}else{
			iAttachment=AttachmentFactory.getLocalInstance(ctx);
		}
		JSONArray array=new JSONArray();
		JSONObject json=null;
		for(int i = 0; i < coll.size(); i++){

			BoAttchAssoInfo bo = coll.get(i); //������������
			AttachmentInfo attachment = bo.getAttachment(); //��������
			attachment = iAttachment.getAttachmentInfo(new ObjectUuidPK(attachment.getId()));
//			attachments.add(attachment);
			byte[] fileBytes = attachment.getFile();
			if(fileBytes==null) {
				AttachmentServerManager asm = AttachmentManagerFactory.getServerManager(ctx);
				fileBytes = asm.download(attachment.getId().toString());
			}
			String file = null;
			if(fileBytes!=null) {
				BASE64Encoder encoder = new BASE64Encoder();
				file = encoder.encode(fileBytes);
			}
			json=new JSONObject();
			json.put("attachID", attachment.getString("id"));
			json.put("content", file);
			json.put("byteData", fileBytes);
			json.put("name", attachment.getName());
			json.put("type", attachment.getType());
			json.put("simpleName", attachment.getSimpleName());
			json.put("size", attachment.getSize());
			array.add(json);

			/*   ������Դ�ļ�
						BASE64Decoder decoder = new BASE64Decoder();
						byte[] buffer = decoder.decodeBuffer(file);
						FileOutputStream out = new FileOutputStream("D://kd//ppt.xlsx");  
						out.write(buffer);  
						out.close(); 
			 */ 
		}

		JSONObject resultJson=new JSONObject();
		resultJson.put("data", array);
		return resultJson.toString();
	}


	
	/**
	 * �ж��ļ���Ŀ¼�Ƿ���ڣ����������򴴽��ļ���Ŀ¼
	 * @param filepath        �ļ�·��
	 * @return
	 * @throws Exception
	 */
	public static File checkExist(String filepath) throws Exception{
		File file=new File(filepath);

		if (file.exists()) {//�ж��ļ�Ŀ¼�Ĵ���
			System.out.println("�ļ��д��ڣ�");
			if(file.isDirectory()){//�ж��ļ��Ĵ�����      
				System.out.println("�ļ����ڣ�");      
			}else{
				file.createNewFile();//�����ļ�
				System.out.println("�ļ������ڣ������ļ��ɹ���"   );      
			}
		}else {
			System.out.println("�ļ��в����ڣ�");
			File file2=new File(file.getParent());
			file2.mkdirs();
			System.out.println("�����ļ��гɹ���");
			if(file.isDirectory()){      
				System.out.println("�ļ����ڣ�");       
			}else{      
				file.createNewFile();//�����ļ� 
				System.out.println("�ļ������ڣ������ļ��ɹ���"   );      
			}
		}
		return file;
	}



	/**
	 * �ж��ļ���Ŀ¼�Ƿ����
	 * @param filepath        �ļ�·��
	 * @return
	 * @throws Exception
	 */
	public static boolean checkIsExist(String filepath) throws Exception{
		File file=new File(filepath);

		boolean result = false;		
		if (file.exists()) {//�ж��ļ�Ŀ¼�Ĵ���
			System.out.println("�ļ��д��ڣ�");
			if(file.isDirectory()){//�ж��ļ��Ĵ�����      
				System.out.println("�ļ����ڣ�");
				return true;
			}else{
//				file.createNewFile();//�����ļ�
				System.out.println("�ļ������ڣ������ļ��ɹ���"   );  
				return false;
			}
		}else {
			System.out.println("�ļ��в����ڣ�");
			result = false;
			File file2=new File(file.getParent());
			file2.mkdirs();
			System.out.println("�����ļ��гɹ���");
			if(file.isDirectory()){      
				System.out.println("�ļ����ڣ�");       
			}else{      
//				file.createNewFile();//�����ļ� 
				System.out.println("�ļ������ڣ������ļ��ɹ���"   );      
			}
		}
		return result;
	}
}