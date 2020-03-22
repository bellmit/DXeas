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

public class WSWSWorkFlowFacadeSrvProxy { 

    public String submitApprove( String jsonStr ) throws WSInvokeException {
        try {
            return getController().submitApprove(
            jsonStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public void updateMesStatusById( String messageId ) throws WSInvokeException {
        try {
            getController().updateMesStatusById(
            messageId
            );
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getMessageDetailList( String userNumber ) throws WSInvokeException {
        try {
            return getController().getMessageDetailList(
            userNumber);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String quickApprove( String assignIds , String ifpass , String opinion , String policy , String userNumber ) throws WSInvokeException {
        try {
            return getController().quickApprove(
            assignIds,
            ifpass,
            opinion,
            policy,
            userNumber);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getFNumberByPhone( String phone ) throws WSInvokeException {
        try {
            return getController().getFNumberByPhone(
            phone);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getApproveHistory( String billId ) throws WSInvokeException {
        try {
            return getController().getApproveHistory(
            billId);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getMessageList( String userNumber ) throws WSInvokeException {
        try {
            return getController().getMessageList(
            userNumber);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getUserInfoByXtId( String xtId ) throws WSInvokeException {
        try {
            return getController().getUserInfoByXtId(
            xtId);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.workflow.IWSWorkFlowFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.workflow.IWSWorkFlowFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.workflow.WSWorkFlowFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.workflow.IWSWorkFlowFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSWorkFlowFacade" , com.kingdee.eas.custom.workflow.IWSWorkFlowFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.workflow.IWSWorkFlowFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSWorkFlowFacade" , com.kingdee.eas.custom.workflow.IWSWorkFlowFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}