package com.kingdee.eas.custom.tocloud.utils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.kingdee.bos.ui.face.UIRuleUtil;

public class K3CloudUtil {
	
	private static String POST_K3CloudURL = null;//"http://60.212.47.112:88/K3Cloud/";
	private static String dbId = "5c01dbdaf91e8d";//��ʽ
//	private static String dbId = "5c1c5501b116cb";//����  5c01dbdaf91e8d
	
	private static String user = "��Դ";//��ʽ
	private static String pwd = "852963";   //��ʽ��Դ
//	private static String pwd = "456789ty";   //����
	private static int lang = 2052;
	
	private static String sessionkey = "kdservice-sessionid";
    private static String aspnetsessionkey = "ASP.NET_SessionId";
    private static String sessionValue = "";
    private static String aspnetsessionValue = "";
	
    private static Map map = new HashMap();
	static {
		map.put("Save",
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Save.common.kdsvc");
		map.put("View",
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.View.common.kdsvc");
		map.put("Submit",
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Submit.common.kdsvc");
		map.put("Audit",
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Audit.common.kdsvc");
		map.put("UnAudit",
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.UnAudit.common.kdsvc");
		map.put("StatusConvert",
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.StatusConvert.common.kdsvc");
		map.put("Login", 
				"Kingdee.BOS.WebApi.ServicesStub.AuthService.ValidateUser.common.kdsvc");
		map.put("Draft", 
		        "Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Draft.common.kdsvc");
		map.put("ExecuteBillQuery", 
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.ExecuteBillQuery.common.kdsvc");
		map.put("Delete", 
				"Kingdee.BOS.WebApi.ServicesStub.DynamicFormService.Delete.common.kdsvc");
	}
    
	//�ݴ�
	public static String Draft(String jsonParam) throws Exception {
		return Invoke("Draft", jsonParam);
	}
	
	// Save
	public static String Save(String jsonParam) throws Exception {
		return Invoke("Save", jsonParam);
	}

	// View
	public static String View(String jsonParam) throws Exception {
		return Invoke("View", jsonParam);
	}

	// Submit
	public static String Submit(String jsonParam) throws Exception {
		return Invoke("Submit", jsonParam);
	}

	// Audit
	public static String Audit(String jsonParam) throws Exception {
		return Invoke("Audit", jsonParam);
	}

	// UnAudit
	public static String UnAudit(String jsonParam) throws Exception {
		return Invoke("UnAudit", jsonParam);
	}

	// StatusConvert
	public static String StatusConvert(String jsonParam)
			throws Exception {
		return Invoke("StatusConvert", jsonParam);
	}
	
	//ExecuteBillQuery --��ѯ��ʱ���
	public static String ExecuteBillQuery(String jsonParam) 
			throws Exception {
		return Invoke("ExecuteBillQuery", jsonParam);
	}
	
	//Delete--ɾ��
	public static String Delete(String jsonParam) 
			throws Exception {
		return Invoke("Delete", jsonParam);
	}
	
	//�Ƿ����ӳɹ�
	/**
	 * ��½��k3Cloud
	 * @return
	 */
	public static boolean loginToK3Cloud() {
		// ����httpClient��ʵ��
		HttpClient httpclient = new DefaultHttpClient();
		JSONObject jsonResult = null;

		/********** �û���¼Begin ************************/
		try {
			//��¼��У���û���API�ӵ�ַ
			String sUrl = map.get("Login").toString();
			//ƴ��֮����ַ���
			URI uri = new URI(POST_K3CloudURL.concat(sUrl));
			//����POST����,����HttpPost����
			HttpPost method = new HttpPost(uri);
			// ��¼�������
			JSONObject jsonParam = new JSONObject();
			jsonParam.put("acctID", dbId);
			jsonParam.put("userName", user);
			jsonParam.put("password", pwd);
			jsonParam.put("lcid", lang);
			//���ﴫ������û���½����Ϣ
			StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8"); 
			entity.setContentEncoding("UTF-8");
			entity.setContentType("application/json");
			method.setEntity(entity);          
			// ����HttpClient�����execute(HttpUriRequest request)�������󣬸÷�������һ��HttpResponse
			HttpResponse result = httpclient.execute(method);
			// �����ͳɹ������õ���Ӧ
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				// ��ȡ���������ع�����json�ַ�������
				str = EntityUtils.toString(result.getEntity());
				// ��json�ַ���ת����json����
				jsonResult = JSONObject.fromObject(str);
				// �жϵ�¼�Ƿ�ɹ�
				if (jsonResult.getInt("LoginResultType") == 1) {
					System.out.println("��¼�ɹ���");
					// ��ȡ��ͷ�е�Cookie
					Header[] headers = result.getHeaders("Set-Cookie");
					for (int i = 1; i < headers.length; i++) {
						Header header = headers[i];
						String headerValue = header.getValue();
						// ��¼�ɹ����صĵ�¼session��Ϣ�����������������ٵ��ýӿڵ�ʱ�򴫸������
						if (headerValue.trim().startsWith(sessionkey)) {
							int endIndex = headerValue.indexOf(';');
							sessionValue = headerValue.substring(20, endIndex);
						} else if (headerValue.trim().startsWith(
								aspnetsessionkey)) {
							int endIndex = headerValue.indexOf(';');
							aspnetsessionValue = headerValue.substring(18,
									endIndex);
						}
						
					}
					
					return true;
				}
				// ��¼ʧ�ܣ�������
				else {
					System.out.println("��¼ʧ�ܣ�"+jsonResult.getInt("LoginResultType"));
					return false;
				}
			} else {
				System.out.println("��¼�쳣��"+result.getStatusLine().getStatusCode());
				return false;
				
			}
		} catch (Exception e) {
			System.out.println("post�����ύʧ��:" + e);
		}
		return false;
	}
	
	/**
	 * 
	 * @param method
	 * @param param
	 * @return
	 */
	private static String Invoke(String method, String jsonParam){
		
		
		// ����httpClient��ʵ��
		HttpClient httpclient = new DefaultHttpClient();
		try {
			String sUrl = map.get(method).toString();
			//������Ϊ�գ����ҵ�½�ɹ�
//			if(StringUtils.isNotBlank(sUrl) && loginToK3Cloud()){
			if(UIRuleUtil.isNotNull(sUrl) && loginToK3Cloud()){
				//������Ҫ���ӵĽӿڵĵ�ַ
				URI uri = new URI(POST_K3CloudURL.concat(sUrl));
				
				//����HttpPost���󣬴�������
				HttpPost httpPost = new HttpPost(uri);
				//��Ӳ���
				StringEntity entity = new StringEntity(jsonParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                
                //�ѳɹ���¼��Session��Ϣ����ȥ����ȡ������Ϣ
                httpPost.setHeader(sessionkey, sessionValue);
                httpPost.setHeader(aspnetsessionkey, aspnetsessionValue);
                
                //���ò���
                httpPost.setEntity(entity);
                
                //����HttpClient�����execute(HttpUriRequest request)�������󣬸÷�������һ��HttpResponse
                HttpResponse result = httpclient.execute(httpPost);
                // �����ͳɹ������õ���Ӧ
                if (result.getStatusLine().getStatusCode() == 200) {
                        System.out.println("����ɹ�");
//                        String str = "";
                        // ��ȡ���������ع�����json�ַ�������
                        //result.getEntity()--��ȡHttpEntity���󣬸ö����װ�˷���������Ӧ����
                        String str = EntityUtils.toString(result.getEntity());
                        System.out.println(str);
                        return str;
                }
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
}
