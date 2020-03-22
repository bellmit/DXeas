package com.kingdee.eas.message.webservices.proxy;

import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeaderElement;

import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.orm.core.ORMEngine;
import com.kingdee.bos.webservice.BeanConvertHelper;
import com.kingdee.bos.webservice.WSConfig;
import com.kingdee.bos.webservice.WSInvokeException;

/**
 * 统一数据接口类
 * @author lenovo
 *
 */
public class DataUniformProxy {
	/**
	 * 通过json条件获取数据
	 * @return
	 */
	 public String getDataFromJsonCondition( String jsonStr ) throws WSInvokeException {
	        try {
	            return getController().getDataFromJsonCondition(jsonStr);
	        }
	        catch( Throwable e ) {
	            //throw new WSInvokeException( e ) ;
	        	return new String("{\"result\":\"Failure\",\"message\":\""+e.getMessage()+"\"}");
	        }
	    }
	 
	 public String getOrderStatusFromJsonCondition( String jsonStr ) throws WSInvokeException {
	        try {
	            return getController().getOrderStatusFromJsonCondition(jsonStr);
	        }
	        catch( Throwable e ) {
//	            throw new WSInvokeException( e ) ;
	        	return new String("{\"result\":\"Failure\",\"message\":\""+e.getMessage()+"\"}");
	        }
	    }
	 
	    private com.kingdee.eas.message.webservices.IDataUniFormFacade getController() {
	        try {
	        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
	            Message message =MessageContext.getCurrentContext().getRequestMessage();
	            SOAPEnvelope soap =message.getSOAPEnvelope();
	            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
	            String SessionId=headerElement.getValue();
	            return ( com.kingdee.eas.message.webservices.IDataUniFormFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.message.webservices.DataUniFormFacade") ; 
	        } else {
	            return ( com.kingdee.eas.message.webservices.IDataUniFormFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.message.webservices.DataUniFormFacade" , com.kingdee.eas.message.webservices.IDataUniFormFacade.class ) ; 
	        }
	        }
	        catch( Throwable e ) {
	            return ( com.kingdee.eas.message.webservices.IDataUniFormFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.message.webservices.DataUniFormFacade" , com.kingdee.eas.message.webservices.IDataUniFormFacade.class ) ; 
	        }
	    }

	    private BeanConvertHelper getBeanConvertor() {
	        return new BeanConvertHelper(); 
	    }

}
