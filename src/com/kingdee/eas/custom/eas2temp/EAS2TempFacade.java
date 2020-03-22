package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.eas2temp.app.*;

public class EAS2TempFacade extends AbstractBizCtrl implements IEAS2TempFacade
{
    public EAS2TempFacade()
    {
        super();
        registerInterface(IEAS2TempFacade.class, this);
    }
    public EAS2TempFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IEAS2TempFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AAF6567D");
    }
    private EAS2TempFacadeController getController() throws BOSException
    {
        return (EAS2TempFacadeController)getBizController();
    }
    /**
     *导出到中间库-User defined method
     *@param companyID companyID
     *@param jsonStr jsonStr
     *@param sourceType sourceType
     *@return
     */
    public String exportBill(String companyID, String jsonStr, int sourceType) throws BOSException
    {
        try {
            return getController().exportBill(getContext(), companyID, jsonStr, sourceType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *导入到eas-User defined method
     *@param companyID companyID
     *@param jsonStr jsonStr
     *@param sourceType sourceType
     *@return
     */
    public String importBill(String companyID, String jsonStr, int sourceType) throws BOSException
    {
        try {
            return getController().importBill(getContext(), companyID, jsonStr, sourceType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *test sql connection-User defined method
     *@param companyID companyID
     *@param targetSystem 目标系统类型
     *@return
     */
    public boolean testConn(String companyID, int targetSystem) throws BOSException
    {
        try {
            return getController().testConn(getContext(), companyID, targetSystem);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *exportBillByID-User defined method
     *@param companyID companyID
     *@param billID billID
     *@param sourceType sourceType
     *@return
     */
    public String exportBillByID(String companyID, String billID, int sourceType) throws BOSException
    {
        try {
            return getController().exportBillByID(getContext(), companyID, billID, sourceType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *初始化物料对应关系-User defined method
     *@param easMaterialID easMaterialID
     *@param storageUnitOrgID storageUnitOrgID
     */
    public void initBarEASRel(String easMaterialID, String storageUnitOrgID) throws BOSException
    {
        try {
            getController().initBarEASRel(getContext(), easMaterialID, storageUnitOrgID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除条码牧羊数据-User defined method
     *@param obj obj
     *@return
     */
    public String deleteBarAndMyData(Object obj) throws BOSException
    {
        try {
            return getController().deleteBarAndMyData(getContext(), obj);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *重算船磅信息-User defined method
     *@param PurId 采购订单ID
     */
    public void retryWeight(String PurId) throws BOSException
    {
        try {
            getController().retryWeight(getContext(), PurId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}