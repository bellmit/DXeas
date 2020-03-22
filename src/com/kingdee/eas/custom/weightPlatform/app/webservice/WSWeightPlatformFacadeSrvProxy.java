package com.kingdee.eas.custom.weightPlatform.app.webservice;

import org.apache.axis.Message;
import org.apache.axis.MessageContext;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.axis.message.SOAPHeaderElement;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.Context;
import com.kingdee.bos.orm.core.ORMEngine;
import com.kingdee.bos.webservice.BeanConvertHelper;
import com.kingdee.bos.webservice.WSConfig;
import com.kingdee.bos.webservice.WSInvokeException;
import com.kingdee.eas.common.EASBizException;

public class WSWeightPlatformFacadeSrvProxy { 

    public String getWeightInfo( String jsonStr ) throws WSInvokeException {
        try {
            return getController().getWeightInfo(
            jsonStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }
    
    public  String insertOrUpdateWeightInfo(String jsonStr)throws WSInvokeException
    {
    	try {
            return getController().insertOrUpdateWeightInfo(jsonStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.weightPlatform.WeightPlatformFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.weightPlatform.WeightPlatformFacade" , com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.weightPlatform.WeightPlatformFacade" , com.kingdee.eas.custom.weightPlatform.IWeightPlatformFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}