package com.kingdee.eas.message.comm;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.enterprisedt.util.debug.Logger;
import com.kingdee.bos.Context;
import com.kingdee.bos.ContextUtils;
import com.kingdee.eas.base.message.MsgStatus;
import com.kingdee.eas.base.message.webservice.MessageWebServiceDao;
import com.kingdee.eas.base.message.webservice.WSMessage;
import com.kingdee.eas.base.message.webservice.WfrAssignMessage;
import com.kingdee.eas.base.message.webservice.WfrProcMessage;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
/**
 * 自定义消息发送
 * @author lenovo
 *
 */
public class MessageUtils implements MessageWebServiceDao {
	 private static Logger logger =Logger.getLogger("com.kingdee.eas.message.comm.MessageUtils");
	@Override
	public boolean addMessage(WSMessage msgInfo) {
		if(msgInfo==null)
			return false;
		String receiverAddress = "http://58.57.63.54:8089/taihe/Servlet/sendWFMessageListToTaiHe.sv";
		System.out.println("消息推送:"+msgInfo.getBizType().getAlias());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if("工作流".equalsIgnoreCase(msgInfo.getBizType().getAlias())){
			logger.info("向工作台发送工作流消息！"+msgInfo.getTitle());
			JSONObject json = new JSONObject();
			json.put("OPTYPE", "ADD");
			json.put("msgID", msgInfo.getMsgID());
			json.put("orgID", msgInfo.getOrgID());
			json.put("title", msgInfo.getTitle());
			json.put("body", msgInfo.getBody());
			json.put("sender", msgInfo.getSender());
			json.put("receiver", msgInfo.getReceivers());
			json.put("senderNumber", msgInfo.getSenderNumber());
			json.put("receiverNumber", msgInfo.getRecieveNumber());
			json.put("bizType", msgInfo.getBizType().toString());
			json.put("type", msgInfo.getType().toString());
			json.put("receiveTime", sdf.format(msgInfo.getReceiveTime()));
			json.put("sentTime", sdf.format(msgInfo.getSendTime()));
			json.put("priorityAlias", msgInfo.getPriorityAlias());
			
			sendPost(receiverAddress, json.toString());//"http://192.168.1.11:8080/vland/Servlet/MessageServlet.sv"
				
		}
		return true;
	}

	/**
	 * 获取信息接收服务地址
	 * @return
	 */
	private String getReceiverAddress() {
		String receiverAddress=null;
		try {
			Context ctx = ContextUtils.getContextFromSession();
			if(ctx!=null){
				StringBuffer sql=new StringBuffer();
				sql.append(" select * from CT_MES_BaseSetting");
				IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
				if(rs.next()) {
					receiverAddress=rs.getString("CFReceiverAddress");
				}
				rs.close();
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return receiverAddress;
	}
	
	@Override
	public boolean removeMessage(String msgID) {
		if(StringUtils.isBlank(msgID))
			return false;
		String receiverAddress=getReceiverAddress();//信息接收地址
		
		if(StringUtils.isBlank(receiverAddress)) {
			return false;
		}
		JSONObject json = new JSONObject();
		json.put("OPTYPE", "DELETE");
		json.put("msgID", msgID);
		sendPost(receiverAddress, json.toString());
		return true;
	}

	@Override
	public boolean updateMessage(String msgID) {
		if(StringUtils.isBlank(msgID))
			return false;
		String receiverAddress=getReceiverAddress();//信息接收地址
		
		if(StringUtils.isBlank(receiverAddress)) {
			return false;
		}
		JSONObject json = new JSONObject();
		json.put("OPTYPE", "UPDATEMSG");
		json.put("msgID", msgID);
		sendPost(receiverAddress, json.toString());
		return false;
	}

	@Override
	public boolean updateMessages(String msgID, MsgStatus msgStatus) {
		if(StringUtils.isBlank(msgID))
			return false;
		String receiverAddress=getReceiverAddress();//信息接收地址
		
		if(StringUtils.isBlank(receiverAddress)) {
			return false;
		}
		JSONObject json = new JSONObject();
		json.put("OPTYPE", "UPDATEMSGS");
		json.put("msgID", msgID);
		json.put("msgStatus", msgStatus.getName());
		sendPost(receiverAddress, json.toString());
		return false;
	}
	/**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String paramsStr) {
    	String result=null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection httpConn = (HttpURLConnection) realUrl.openConnection();
         // //设置连接属性   
            httpConn.setDoOutput(true);// 使用 URL 连接进行输出   
            httpConn.setDoInput(true);// 使用 URL 连接进行输入   
            httpConn.setUseCaches(false);// 忽略缓存   
            httpConn.setRequestMethod("POST");// 设置URL请求方法   
              
               
            // 设置请求属性   
            // 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致   
            httpConn.setRequestProperty("Content-length", "" + paramsStr.getBytes("UTF-8").length);   
            httpConn.setRequestProperty("Content-Type", "application/octet-stream");   
            httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接   
            httpConn.setRequestProperty("Charset", "UTF-8");   

            OutputStreamWriter osw = new OutputStreamWriter(httpConn.getOutputStream(), "UTF-8");

            osw.write(paramsStr);

            osw.flush();

            osw.close();
            
            
         // 获得响应状态   
            int responseCode = httpConn.getResponseCode();   
              
            if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功   
            	System.out.println("success");
            	logger.info("thrid system message sent Success!");
            }else{
            	System.out.println("failure");
            	logger.warn("thrid system message sent Failure !");
            }
            
            httpConn.disconnect();

        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
        }
        return result;
    }

	@Override
	public boolean addCompletedMessage(WfrAssignMessage arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addInitiatorMessage(WfrProcMessage arg0) {
		// TODO Auto-generated method stub
		return false;
	}   
}
