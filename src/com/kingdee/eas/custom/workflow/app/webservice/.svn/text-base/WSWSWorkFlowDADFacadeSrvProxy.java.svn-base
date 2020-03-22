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

public class WSWSWorkFlowDADFacadeSrvProxy { 

    public String getSelectPolicy( String param ) throws WSInvokeException {
        try {
            return getController().getSelectPolicy(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String submitApprove( String param ) throws WSInvokeException {
        try {
            return getController().submitApprove(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String addAttachment( String param ) throws WSInvokeException {
        try {
            return getController().addAttachment(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String executeQueryForPassAssign( String param ) throws WSInvokeException {
        try {
            return getController().executeQueryForPassAssign(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getAttachmentAsBytes( String param ) throws WSInvokeException {
        try {
            return getController().getAttachmentAsBytes(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getAttachmentBillByBillID( String parma ) throws WSInvokeException {
        try {
            return getController().getAttachmentBillByBillID(
            parma);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String deleteAttachment( String param ) throws WSInvokeException {
        try {
            return getController().deleteAttachment(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String passAssign( String param ) throws WSInvokeException {
        try {
            return getController().passAssign(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBillDigest( String param ) throws WSInvokeException {
        try {
            return getController().getBillDigest(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.workflow.WSWorkFlowDADFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSWorkFlowDADFacade" , com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSWorkFlowDADFacade" , com.kingdee.eas.custom.workflow.IWSWorkFlowDADFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}