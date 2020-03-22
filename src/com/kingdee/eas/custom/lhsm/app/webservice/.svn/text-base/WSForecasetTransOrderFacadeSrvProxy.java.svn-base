package com.kingdee.eas.custom.lhsm.app.webservice;

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

public class WSForecasetTransOrderFacadeSrvProxy { 

    public String excuteInsertSql( String param ) throws WSInvokeException {
        try {
            return getController().excuteInsertSql(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String excuteQuerySql( String param ) throws WSInvokeException {
        try {
            return getController().excuteQuerySql(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getSingleForecastData( String param ) throws WSInvokeException {
        try {
            return getController().getSingleForecastData(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String addSaleOrderBill( String param ) throws WSInvokeException {
        try {
            return getController().addSaleOrderBill(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getMaterialInventory( String param ) throws WSInvokeException {
        try {
            return getController().getMaterialInventory(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getAllData( String param ) throws WSInvokeException {
        try {
            return getController().getAllData(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.lhsm.ForecasetTransOrderFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.lhsm.ForecasetTransOrderFacade" , com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.lhsm.ForecasetTransOrderFacade" , com.kingdee.eas.custom.lhsm.IForecasetTransOrderFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}