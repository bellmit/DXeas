package com.kingdee.eas.custom.szcount.app.webservice;

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

public class WSGetDataFacadeSrvProxy { 

    public String GetWarehouse( String PersonID ) throws WSInvokeException {
        try {
            return getController().GetWarehouse(
            PersonID);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String GetData( String Params ) throws WSInvokeException {
        try {
            return getController().GetData(
            Params);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String GetStatisticsData( String params ) throws WSInvokeException {
        try {
            return getController().GetStatisticsData(
            params);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String SaveData( String Params ) throws WSInvokeException {
        try {
            return getController().SaveData(
            Params);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String GetPersonPost( String Params ) throws WSInvokeException {
        try {
            return getController().GetPersonPost(
            Params);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.szcount.IGetDataFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.szcount.IGetDataFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.szcount.GetDataFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.szcount.IGetDataFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.szcount.GetDataFacade" , com.kingdee.eas.custom.szcount.IGetDataFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.szcount.IGetDataFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.szcount.GetDataFacade" , com.kingdee.eas.custom.szcount.IGetDataFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}