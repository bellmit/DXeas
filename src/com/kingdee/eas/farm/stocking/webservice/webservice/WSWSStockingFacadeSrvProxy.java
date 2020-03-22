package com.kingdee.eas.farm.stocking.webservice.webservice;

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

public class WSWSStockingFacadeSrvProxy { 

    public String getPersonInfoByUser( String param ) throws WSInvokeException {
        try {
            return getController().getPersonInfoByUser(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String deleteBreedSeedRecBill( String param ) throws WSInvokeException {
        try {
            return getController().deleteBreedSeedRecBill(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String confirmMethod( String param ) throws WSInvokeException {
        try {
            return getController().confirmMethod(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBreedSeedRecBillList( String param ) throws WSInvokeException {
        try {
            return getController().getBreedSeedRecBillList(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBatchContractByFarmerOrFarm( String param ) throws WSInvokeException {
        try {
            return getController().getBatchContractByFarmerOrFarm(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getTechMantelByFarmer( String param ) throws WSInvokeException {
        try {
            return getController().getTechMantelByFarmer(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getCurrentStocking( String param ) throws WSInvokeException {
        try {
            return getController().getCurrentStocking(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getBreedSeedRecBillDetailInfo( String param ) throws WSInvokeException {
        try {
            return getController().getBreedSeedRecBillDetailInfo(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getFarmerIDCardByTechManUserNum( String param ) throws WSInvokeException {
        try {
            return getController().getFarmerIDCardByTechManUserNum(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getWareHouse( String param ) throws WSInvokeException {
        try {
            return getController().getWareHouse(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String createNewBreedSeedRecBill( String param ) throws WSInvokeException {
        try {
            return getController().createNewBreedSeedRecBill(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getStorageOrgUnit( String param ) throws WSInvokeException {
        try {
            return getController().getStorageOrgUnit(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.farm.stocking.webservice.WSStockingFacade") ; 
        } else {
            return ( com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.farm.stocking.webservice.WSStockingFacade" , com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.farm.stocking.webservice.WSStockingFacade" , com.kingdee.eas.farm.stocking.webservice.IWSStockingFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}