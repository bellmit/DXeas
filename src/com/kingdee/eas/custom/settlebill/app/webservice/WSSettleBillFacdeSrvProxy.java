package com.kingdee.eas.custom.settlebill.app.webservice;

import org.apache.axis.Message;

import org.apache.axis.MessageContext;

import org.apache.axis.message.SOAPEnvelope;

import org.apache.axis.message.SOAPHeaderElement;

import com.kingdee.bos.webservice.WSConfig;

import com.kingdee.bos.webservice.WSInvokeException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ObjectMultiPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.orm.core.ORMEngine;
import com.kingdee.bos.webservice.BeanConvertHelper;
import com.kingdee.bos.webservice.BOSTypeConvertor;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.webservice.WSConfig;
import com.kingdee.bos.webservice.MetaDataHelper;
import com.kingdee.bos.BOSObjectFactory;

public class WSSettleBillFacdeSrvProxy { 

    public String[] importData( String xml ) throws WSInvokeException {
        try {
            return getController().importData(
            xml);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.settlebill.ISettleBillFacde getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.settlebill.ISettleBillFacde )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.settlebill.SettleBillFacde") ; 
        } else {
            return ( com.kingdee.eas.custom.settlebill.ISettleBillFacde )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.settlebill.SettleBillFacde" , com.kingdee.eas.custom.settlebill.ISettleBillFacde.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.settlebill.ISettleBillFacde )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.settlebill.SettleBillFacde" , com.kingdee.eas.custom.settlebill.ISettleBillFacde.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}