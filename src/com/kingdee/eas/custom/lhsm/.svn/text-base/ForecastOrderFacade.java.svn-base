package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.lhsm.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class ForecastOrderFacade extends AbstractBizCtrl implements IForecastOrderFacade
{
    public ForecastOrderFacade()
    {
        super();
        registerInterface(IForecastOrderFacade.class, this);
    }
    public ForecastOrderFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IForecastOrderFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C1925C00");
    }
    private ForecastOrderFacadeController getController() throws BOSException
    {
        return (ForecastOrderFacadeController)getBizController();
    }
    /**
     *getSqlData-User defined method
     *@param sql sql
     *@return
     */
    public IRowSet getSqlData(String sql) throws BOSException, EASBizException
    {
        try {
            return getController().getSqlData(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *transToOrder-User defined method
     *@param forecastId forecastId
     *@param storageOrgId storageOrgId
     *@param currOrgUnitId currOrgUnit
     *@return
     */
    public String[] transToOrder(String forecastId, String storageOrgId, String currOrgUnitId) throws BOSException, EASBizException
    {
        try {
            return getController().transToOrder(getContext(), forecastId, storageOrgId, currOrgUnitId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *rejectForecast-User defined method
     *@param forecasId forecasId
     *@return
     */
    public String[] rejectForecast(String forecasId) throws BOSException, EASBizException
    {
        try {
            return getController().rejectForecast(getContext(), forecasId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行Update，delete语句-User defined method
     *@param sql sql
     *@return
     */
    public boolean execSql(String sql) throws BOSException
    {
        try {
            return getController().execSql(getContext(), sql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *saleorder-User defined method
     *@param id id
     */
    public void saleorder(String id) throws BOSException
    {
        try {
            getController().saleorder(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *companyInv-User defined method
     *@param cuid cuid
     *@param materialid materialid
     */
    public void companyInv(String cuid, String materialid) throws BOSException
    {
        try {
            getController().companyInv(getContext(), cuid, materialid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *addSaleForecast-User defined method
     */
    public void addSaleForecast() throws BOSException
    {
        try {
            getController().addSaleForecast(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *updateSaleForecast-User defined method
     *@param id id
     */
    public void updateSaleForecast(String id) throws BOSException
    {
        try {
            getController().updateSaleForecast(getContext(), id);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *exportData-User defined method
     *@param cuid cuid
     *@param type type
     *@param fid fid
     *@param fstatus fstatus
     */
    public void exportData(String cuid, int type, String fid, String fstatus) throws BOSException
    {
        try {
            getController().exportData(getContext(), cuid, type, fid, fstatus);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *移动端下载单据-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String downloadBillData(String jsonStr) throws BOSException
    {
        try {
            return getController().downloadBillData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *移动端上传单据-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String uploadBillData(String jsonStr) throws BOSException
    {
        try {
            return getController().uploadBillData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *移动端下载单据列表-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String downloadBillList(String jsonStr) throws BOSException
    {
        try {
            return getController().downloadBillList(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取用户组织范围内的销售组织-User defined method
     *@param parma 参数
     *@return
     */
    public String getOrgUnitRangeByUserNum(String parma) throws BOSException
    {
        try {
            return getController().getOrgUnitRangeByUserNum(getContext(), parma);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据销售组织获取物料-User defined method
     *@param jsonStr 参数
     *@return
     */
    public String getMaterialByOrg(String jsonStr) throws BOSException
    {
        try {
            return getController().getMaterialByOrg(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成销售预报单-User defined method
     *@param param 参数
     *@return
     */
    public String createNewForecastOrder(String param) throws BOSException
    {
        try {
            return getController().createNewForecastOrder(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取付款方式-User defined method
     *@param param 参数
     *@return
     */
    public String getPaymentType(String param) throws BOSException
    {
        try {
            return getController().getPaymentType(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据销售组织获取客户-User defined method
     *@param param 参数
     *@return
     */
    public String getCustomerBySaleOrg(String param) throws BOSException
    {
        try {
            return getController().getCustomerBySaleOrg(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据销售组织获取销售组-User defined method
     *@param param 参数
     *@return
     */
    public String getSaleGroupBySaleOrg(String param) throws BOSException
    {
        try {
            return getController().getSaleGroupBySaleOrg(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取销售员-User defined method
     *@param param 参数
     *@return
     */
    public String getSalePerson(String param) throws BOSException
    {
        try {
            return getController().getSalePerson(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取销售预报单详细信息-User defined method
     *@param param 参数
     *@return
     */
    public String getForecastDetailInfo(String param) throws BOSException
    {
        try {
            return getController().getForecastDetailInfo(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getMaterialPrice-User defined method
     *@param param 参数
     *@return
     */
    public String getMaterialPrice(String param) throws BOSException
    {
        try {
            return getController().getMaterialPrice(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据公司获取仓库-User defined method
     *@param param 参数
     *@return
     */
    public String getWareHouseList(String param) throws BOSException
    {
        try {
            return getController().getWareHouseList(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取当前员工组织范围-User defined method
     *@param param 参数
     *@return
     */
    public String getSalePersonOrgUnitRange(String param) throws BOSException
    {
        try {
            return getController().getSalePersonOrgUnitRange(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取销售预报单进度-User defined method
     *@param param 参数
     *@return
     */
    public String getSaleForecastBillPro(String param) throws BOSException
    {
        try {
            return getController().getSaleForecastBillPro(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}