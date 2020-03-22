/*    */ package com.kingdee.bos.webservice;
/*    */ 
/*    */ import java.util.Iterator;

import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;

import org.apache.axis.AxisFault;
import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeaderElement;
import org.apache.log4j.Logger;

import com.kingdee.bos.framework.session.ISessionManager;
import com.kingdee.bos.framework.session.SessionInfo;
import com.kingdee.bos.framework.session.SessionManager;
/*    */ 
/*    */ public class LoginHandler extends BasicHandler
/*    */ {
/*    */   private static final long serialVersionUID = 4342342608545951914L;
/*    */   Logger logger;
/*    */ 
/*    */   public LoginHandler()
/*    */   {
/* 22 */     this.logger = Logger.getLogger(LoginHandler.class);
/*    */   }
/*    */ 
/*    */   public void invoke(MessageContext msgContext) throws AxisFault {
/*    */     try {
/* 27 */       String serviceName = msgContext.getService().getName();
/* 28 */       if ((serviceName == null) || (serviceName.equals("EASLogin")))
/*    */       {
/* 30 */         return;
/*    */       }
/* 32 */       String isRomoteLocate = WSConfig.getRomoteLocate();
/* 33 */       String isRomoteUserCheck = WSConfig.getRomoteUserCheck();
/* 34 */       if ((((isRomoteLocate == null) || (isRomoteLocate.equals("true")))) && (((isRomoteUserCheck == null) || (isRomoteUserCheck.equals("false")))))
/*    */       {
/* 37 */         return;
/*    */       }
/* 39 */       Message message = msgContext.getRequestMessage();
/* 40 */       SOAPEnvelope soap = message.getSOAPEnvelope();
			
//				soap.getChildElements();
				logger.info("webservice Header：" + soap.toString());
				System.out.println(soap.toString());
				
				
				
/* 41 */       SOAPHeaderElement headerElement = soap.getHeaderByName("http://login.webservice.bos.kingdee.com", "SessionId");


				if(headerElement == null){
					javax.xml.soap.SOAPHeader header = soap.getHeader();
					System.out.println("------------------");
					;
					System.out.println("SOAPHeader=" +header.getValue());
					System.out.println("SOAPHeader name =" + header.getElementName());
					Iterator ite =  header.getChildElements();
					while(ite.hasNext()){
						SOAPElement element = (SOAPElement)ite.next();
						System.out.println("------------------");
						
						System.out.println("SOAPchild1=" +element.getValue());
						System.out.println("SOAPchild1 name =" + element.getElementName());
						System.out.println("SOAPchild1=" + element.toString());
						Iterator childIte =  element.getChildElements();
						while(childIte.hasNext()){
							SOAPElement elementc = (SOAPElement)childIte.next();
							System.out.println("------------------");
							System.out.println("SOAPchild2=" +elementc.getValue());
							System.out.println("SOAPchild2 name =" +elementc.getElementName());
							
							Name name =elementc.getElementName();
							System.out.println("SOAPchild2 local name =" +name.getLocalName());
							String sessionID = name.getLocalName();
							if("SessionId".equals(sessionID)){
								System.out.println("找到sessionid=" +elementc.getValue());
								headerElement = new SOAPHeaderElement("http://login.webservice.bos.kingdee.com","SessionId"); 
								headerElement.setValue(elementc.getValue());
								headerElement.setParentElement(soap);
								System.out.println("new headerValue  =" +headerElement.toString());
								break;
							}
							
						}
						if(headerElement != null){
							break;
						}
						element.getValue();
						
						
					}
				}
				
/* 42 */       if (headerElement == null) {
/* 43 */         AxisFault af = new AxisFault();
/* 44 */         af.setFaultCodeAsString("com.kingdee.bos.webservice.LoginHandler.invoke");
/* 45 */         af.setFaultActor("EAS Server LoginHanler");
/* 46 */         af.setFaultString("在请求的SOAP报文中未找到<ns1:SessionId xmlns:ns1=\"http://login.webservice.bos.kingdee.com\"> 标签，因为在profiles/server1/config/webservice.properties文件中，设置了isRomoteLocate=false isRomoteUserCheck=true 启动了EAS webservice的安全性， webservice 将从消息头中获取相应的sessionId");
/*    */ 
/* 49 */         af.setFaultDetailString("请求报文为：\r\n" + soap.toString());
/* 50 */         throw af;
/*    */       }
/*    */ 
/* 53 */       String sessionID = headerElement.getValue();
/* 54 */       if (sessionID == null)
/*    */       {
/* 56 */         AxisFault af = new AxisFault();
/* 57 */         af.setFaultActor("EAS Server LoginHanler");
/* 58 */         af.setFaultString("从请求的<ns1:SessionId xmlns:ns1=\"http://login.webservice.bos.kingdee.com\"> 标签中获得的 SessionId 为 null");
/*    */ 
/* 60 */         af.setFaultDetailString("请求报文为：\r\n" + soap.toString());
/* 61 */         throw af;
/*    */       }
/*    */ 
/* 65 */       ISessionManager sessionManager = SessionManager.getInstance();
/* 66 */       SessionInfo info = sessionManager.getSession(sessionID);
/* 67 */       if (info == null)
/*    */       {
/* 69 */         AxisFault af = new AxisFault();
/* 70 */         af.setFaultActor("EAS Server LoginHanler");
/* 71 */         af.setFaultString("请求的SessionId=" + sessionID + " 无效，未能在服务器端找到该sessionID 或 该 sessionID 已经失效");
/* 72 */         af.setFaultDetailString("请求报文为：\r\n" + soap.toString());
/* 73 */         throw af;
/*    */       }
/*    */     } catch (AxisFault af) {
/* 76 */       throw af;
/*    */     } catch (Throwable t) {
/* 78 */       throw new AxisFault("current user is not login or login error！", t);
/*    */     }
/*    */   }
/*    */ }

/* Location:           D:\Kingdee\ws\eas235\lib\server\bos\boswebservice.jar
 * Qualified Name:     com.kingdee.bos.webservice.LoginHandler
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.5.3
 */