package com.kingdee.eas.custom.workflow.webservice;

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

public class WSWSSignedBillFacadeSrvProxy { 

    public String getBillType( String userNumber ) throws WSInvokeException {
        try {
            return getController().getBillType(
            userNumber);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBillInfoById( String fid ) throws WSInvokeException {
        try {
            return getController().getBillInfoById(
            fid);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getOrgInfoByUser( String userNumber ) throws WSInvokeException {
        try {
            return getController().getOrgInfoByUser(
            userNumber);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getDeptListByCompany( String company ) throws WSInvokeException {
        try {
            return getController().getDeptListByCompany(
            company);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String importBillInfo( String jsonData ) throws WSInvokeException {
        try {
            return getController().importBillInfo(
            jsonData);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getOrgListByUser( String userNumber ) throws WSInvokeException {
        try {
            return getController().getOrgListByUser(
            userNumber);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBillList( String userNumber , String fnumber , String dateS , String dateE ) throws WSInvokeException {
        try {
            return getController().getBillList(
            userNumber,
            fnumber,
            dateS,
            dateE);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.workflow.IWSSignedBillFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.workflow.IWSSignedBillFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.workflow.WSSignedBillFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.workflow.IWSSignedBillFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSSignedBillFacade" , com.kingdee.eas.custom.workflow.IWSSignedBillFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.workflow.IWSSignedBillFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.workflow.WSSignedBillFacade" , com.kingdee.eas.custom.workflow.IWSSignedBillFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}