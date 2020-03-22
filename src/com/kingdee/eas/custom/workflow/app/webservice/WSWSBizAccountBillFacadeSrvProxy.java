package com.kingdee.eas.custom.workflow.app.webservice;

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

public class WSWSBizAccountBillFacadeSrvProxy { 

    public String getDeptListByCompany( String company ) throws WSInvokeException {
        try {
            return getController().getDeptListByCompany(
            company);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBizAccountBillByAssignId( String assignId ) throws WSInvokeException {
        try {
            return getController().getBizAccountBillByAssignId(
            assignId);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBizType( String userId ) throws WSInvokeException {
        try {
            return getController().getBizType(
            userId);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBizAccountBillList( String dataJson ) throws WSInvokeException {
        try {
            return getController().getBizAccountBillList(
            dataJson);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getExpTypeByBizType( String bizType , String userNumber ) throws WSInvokeException {
        try {
            return getController().getExpTypeByBizType(
            bizType,
            userNumber);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String importBizAccountBill( String dataXml ) throws WSInvokeException {
        try {
            return getController().importBizAccountBill(
            dataXml);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getOrgListByUser( String userId ) throws WSInvokeException {
        try {
            return getController().getOrgListByUser(
            userId);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getOrgInfoByUser( String user ) throws WSInvokeException {
        try {
            return getController().getOrgInfoByUser(
            user);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.workflow.WSBizAccountBillFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSBizAccountBillFacade" , com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSBizAccountBillFacade" , com.kingdee.eas.custom.workflow.IWSBizAccountBillFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}