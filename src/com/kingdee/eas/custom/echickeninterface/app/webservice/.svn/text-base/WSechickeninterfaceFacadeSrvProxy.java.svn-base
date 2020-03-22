package com.kingdee.eas.custom.echickeninterface.app.webservice;

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

public class WSechickeninterfaceFacadeSrvProxy { 

    public String getBaseData( String queryStr ) throws WSInvokeException {
        try {
            return getController().getBaseData(
            queryStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String importBill( String BosType , String BillJson , int BillStatus ) throws WSInvokeException {
        try {
            return getController().importBill(
            BosType,
            BillJson,
            BillStatus);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.echickeninterface.echickeninterfaceFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.echickeninterface.echickeninterfaceFacade" , com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.echickeninterface.echickeninterfaceFacade" , com.kingdee.eas.custom.echickeninterface.IechickeninterfaceFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}