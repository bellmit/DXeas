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

public class WSForecastOrderFacadeSrvProxy { 

    public String getSaleGroupBySaleOrg( String param ) throws WSInvokeException {
        try {
            return getController().getSaleGroupBySaleOrg(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getCustomerBySaleOrg( String param ) throws WSInvokeException {
        try {
            return getController().getCustomerBySaleOrg(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String[] transToOrder( String forecastId , String storageOrgId , String currOrgUnitId ) throws WSInvokeException {
        try {
            return getController().transToOrder(
            forecastId,
            storageOrgId,
            currOrgUnitId);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getMaterialPrice( String param ) throws WSInvokeException {
        try {
            return getController().getMaterialPrice(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String[] rejectForecast( String forecasId ) throws WSInvokeException {
        try {
            return getController().rejectForecast(
            forecasId);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getMaterialByOrg( String jsonStr ) throws WSInvokeException {
        try {
            return getController().getMaterialByOrg(
            jsonStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String downloadBillData( String jsonStr ) throws WSInvokeException {
        try {
            return getController().downloadBillData(
            jsonStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String downloadBillList( String jsonStr ) throws WSInvokeException {
        try {
            return getController().downloadBillList(
            jsonStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getPaymentType( String param ) throws WSInvokeException {
        try {
            return getController().getPaymentType(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String uploadBillData( String jsonStr ) throws WSInvokeException {
        try {
            return getController().uploadBillData(
            jsonStr);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getOrgUnitRangeByUserNum( String parma ) throws WSInvokeException {
        try {
            return getController().getOrgUnitRangeByUserNum(
            parma);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getWareHouseList( String param ) throws WSInvokeException {
        try {
            return getController().getWareHouseList(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public boolean execSql( String sql ) throws WSInvokeException {
        try {
            return getController().execSql(
            sql);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public void exportData( String cuid , int type , String fid , String fstatus ) throws WSInvokeException {
        try {
            getController().exportData(
            cuid,
            type,
            fid,
            fstatus
            );
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public void saleorder( String id ) throws WSInvokeException {
        try {
            getController().saleorder(
            id
            );
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public void updateSaleForecast( String id ) throws WSInvokeException {
        try {
            getController().updateSaleForecast(
            id
            );
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public void addSaleForecast() throws WSInvokeException {
        try {
            getController().addSaleForecast(
            );
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public void companyInv( String cuid , String materialid ) throws WSInvokeException {
        try {
            getController().companyInv(
            cuid,
            materialid
            );
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getForecastDetailInfo( String param ) throws WSInvokeException {
        try {
            return getController().getForecastDetailInfo(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String getSalePerson( String param ) throws WSInvokeException {
        try {
            return getController().getSalePerson(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    public String createNewForecastOrder( String param ) throws WSInvokeException {
        try {
            return getController().createNewForecastOrder(
            param);
        }
        catch( Throwable e ) {
            throw new WSInvokeException( e ) ;
        }
    }

    private com.kingdee.eas.custom.lhsm.IForecastOrderFacade getController() {
        try {
        if (WSConfig.getRomoteLocate()!=null&&WSConfig.getRomoteLocate().equals("false")){
            Message message =MessageContext.getCurrentContext().getRequestMessage();
            SOAPEnvelope soap =message.getSOAPEnvelope();
            SOAPHeaderElement headerElement=soap.getHeaderByName(WSConfig.loginQName,WSConfig.loginSessionId);
            String SessionId=headerElement.getValue();
            return ( com.kingdee.eas.custom.lhsm.IForecastOrderFacade )BOSObjectFactory.createBOSObject( SessionId , "com.kingdee.eas.custom.lhsm.ForecastOrderFacade") ; 
        } else {
            return ( com.kingdee.eas.custom.lhsm.IForecastOrderFacade )BOSObjectFactory.createRemoteBOSObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.lhsm.ForecastOrderFacade" , com.kingdee.eas.custom.lhsm.IForecastOrderFacade.class ) ; 
        }
        }
        catch( Throwable e ) {
            return ( com.kingdee.eas.custom.lhsm.IForecastOrderFacade )ORMEngine.createRemoteObject( WSConfig.getSrvURL() , "com.kingdee.eas.custom.lhsm.ForecastOrderFacade" , com.kingdee.eas.custom.lhsm.IForecastOrderFacade.class ) ; 
        }
    }

    private BeanConvertHelper getBeanConvertor() {
        return new BeanConvertHelper(); 
    }

}