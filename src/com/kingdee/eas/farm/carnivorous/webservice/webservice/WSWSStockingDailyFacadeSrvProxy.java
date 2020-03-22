package com.kingdee.eas.farm.carnivorous.webservice.webservice;

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

public class WSWSStockingDailyFacadeSrvProxy { 

    public String getBillDetailInfo( String param ) throws WSInvokeException {
        try {
            return getController().getBillDetailInfo(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String createNewBill( String param ) throws WSInvokeException {
        try {
            return getController().createNewBill(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBillList( String param ) throws WSInvokeException {
        try {
            return getController().getBillList(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String deleteBill( String param ) throws WSInvokeException {
        try {
            return getController().deleteBill(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.farm.carnivorous.webservice.WSStockingDailyFacade") ; 
        } else {
            return ( com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.farm.carnivorous.webservice.WSStockingDailyFacade" , com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.farm.carnivorous.webservice.WSStockingDailyFacade" , com.kingdee.eas.farm.carnivorous.webservice.IWSStockingDailyFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}