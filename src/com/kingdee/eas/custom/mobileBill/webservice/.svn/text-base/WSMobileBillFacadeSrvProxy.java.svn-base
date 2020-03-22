package com.kingdee.eas.custom.mobileBill.webservice;

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

public class WSMobileBillFacadeSrvProxy { 

    public String selectSaleOrg( String param ) throws WSInvokeException {
        try {
            return getController().selectSaleOrg(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String queryMaterialByCustomer( String param ) throws WSInvokeException {
        try {
            return getController().queryMaterialByCustomer(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String addNewSaleOrder( String orderInfo ) throws WSInvokeException {
        try {
            return getController().addNewSaleOrder(
            orderInfo);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String queryCustomerByUser( String param ) throws WSInvokeException {
        try {
            return getController().queryCustomerByUser(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String queryBizType() throws WSInvokeException {
        try {
            return getController().queryBizType();
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String alterOrder( String alterInfo ) throws WSInvokeException {
        try {
            return getController().alterOrder(
            alterInfo);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String saleOrderHistory( String param ) throws WSInvokeException {
        try {
            return getController().saleOrderHistory(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String saleOrderDetial( String param ) throws WSInvokeException {
        try {
            return getController().saleOrderDetial(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.mobileBill.IMobileBillFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.mobileBill.IMobileBillFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.mobileBill.MobileBillFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.mobileBill.IMobileBillFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.mobileBill.MobileBillFacade" , com.kingdee.eas.custom.mobileBill.IMobileBillFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.mobileBill.IMobileBillFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.mobileBill.MobileBillFacade" , com.kingdee.eas.custom.mobileBill.IMobileBillFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}