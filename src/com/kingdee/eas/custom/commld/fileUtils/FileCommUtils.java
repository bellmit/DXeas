package com.kingdee.eas.custom.commld.fileUtils;

import java.io.File;
import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
import com.kingdee.eas.common.EASBizException;

public class FileCommUtils {

	/**
	 * 根据BillID获取附件
	 * @param billId
	 * @return
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws IOException
	 */
	public static String getAttachments(Context ctx,String billId) throws BOSException, EASBizException, IOException{

		AttachmentCollection attachments = null; //附件集合
		IBoAttchAsso iBoAttchAsso = null;
		if(ctx==null)
			iBoAttchAsso = BoAttchAssoFactory.getRemoteInstance(); //附件与业务对象关联接口
		else
			iBoAttchAsso = BoAttchAssoFactory.getLocalInstance(ctx); //附件与业务对象关联接口
		EntityViewInfo view = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("boID", billId));
		view.setFilter(filter);
		BoAttchAssoCollection coll = iBoAttchAsso.getBoAttchAssoCollection(view); //查询所关联附件
		if(coll == null && coll.size() == 0){
			return null;
		}
		attachments = new AttachmentCollection();
		IAttachment iAttachment = null;
		if(ctx==null)
			iAttachment=AttachmentFactory.getRemoteInstance();
		else
			iAttachment=AttachmentFactory.getLocalInstance(ctx);
		JSONArray array=new JSONArray();
		JSONObject json=null;
		for(int i = 0; i < coll.size(); i++){

			BoAttchAssoInfo bo = coll.get(i); //附件关联对象
			AttachmentInfo attachment = bo.getAttachment(); //附件对象
			attachment = iAttachment.getAttachmentInfo(new ObjectUuidPK(attachment.getId()));
			attachments.add(attachment);

			BASE64Encoder encoder = new BASE64Encoder();
			String file = encoder.encode(attachment.getFile());
			json=new JSONObject();
			json.put("content", file);
			json.put("name", attachment.getName());
			json.put("type", attachment.getType());
			json.put("simpleName", attachment.getSimpleName());
			json.put("size", attachment.getSize());
			array.add(json);

			/*   解析成源文件
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
	 * 判断文件及目录是否存在，若不存在则创建文件及目录
	 * @param filepath        文件路径
	 * @return
	 * @throws Exception
	 */
	public static File checkExist(String filepath) throws Exception{
		File file=new File(filepath);

		if (file.exists()) {//判断文件目录的存在
			System.out.println("文件夹存在！");
			if(file.isDirectory()){//判断文件的存在性      
				System.out.println("文件存在！");      
			}else{
				file.createNewFile();//创建文件
				System.out.println("文件不存在，创建文件成功！"   );      
			}
		}else {
			System.out.println("文件夹不存在！");
			File file2=new File(file.getParent());
			file2.mkdirs();
			System.out.println("创建文件夹成功！");
			if(file.isDirectory()){      
				System.out.println("文件存在！");       
			}else{      
				file.createNewFile();//创建文件 
				System.out.println("文件不存在，创建文件成功！"   );      
			}
		}
		return file;
	}



	/**
	 * 判断文件及目录是否存在
	 * @param filepath        文件路径
	 * @return
	 * @throws Exception
	 */
	public static boolean checkIsExist(String filepath) throws Exception{
		File file=new File(filepath);

		boolean result = false;		
		if (file.exists()) {//判断文件目录的存在
			System.out.println("文件夹存在！");
			if(file.isDirectory()){//判断文件的存在性      
				System.out.println("文件存在！");
				return true;
			}else{
//				file.createNewFile();//创建文件
				System.out.println("文件不存在，创建文件成功！"   );  
				return false;
			}
		}else {
			System.out.println("文件夹不存在！");
			result = false;
			File file2=new File(file.getParent());
			file2.mkdirs();
			System.out.println("创建文件夹成功！");
			if(file.isDirectory()){      
				System.out.println("文件存在！");       
			}else{      
//				file.createNewFile();//创建文件 
				System.out.println("文件不存在，创建文件成功！"   );      
			}
		}
		return result;
	}
}
