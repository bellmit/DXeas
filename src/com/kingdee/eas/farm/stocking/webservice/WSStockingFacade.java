package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.webservice.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSStockingFacade extends AbstractBizCtrl implements IWSStockingFacade
{
    public WSStockingFacade()
    {
        super();
        registerInterface(IWSStockingFacade.class, this);
    }
    public WSStockingFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSStockingFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("30747360");
    }
    private WSStockingFacadeController getController() throws BOSException
    {
        return (WSStockingFacadeController)getBizController();
    }
    /**
     *生成种苗领用单-User defined method
     *@param param 参数
     *@return
     */
    public String createNewBreedSeedRecBill(String param) throws BOSException
    {
        try {
            return getController().createNewBreedSeedRecBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取种苗领用单列表信息-User defined method
     *@param param 参数
     *@return
     */
    public String getBreedSeedRecBillList(String param) throws BOSException
    {
        try {
            return getController().getBreedSeedRecBillList(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取种苗领用单详细信息-User defined method
     *@param param 参数
     *@return
     */
    public String getBreedSeedRecBillDetailInfo(String param) throws BOSException
    {
        try {
            return getController().getBreedSeedRecBillDetailInfo(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据养殖场会养殖户获取批次合同-User defined method
     *@param param 参数
     *@return
     */
    public String getBatchContractByFarmerOrFarm(String param) throws BOSException
    {
        try {
            return getController().getBatchContractByFarmerOrFarm(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取库存组织-User defined method
     *@param param 参数
     *@return
     */
    public String getStorageOrgUnit(String param) throws BOSException
    {
        try {
            return getController().getStorageOrgUnit(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取仓库-User defined method
     *@param param 参数
     *@return
     */
    public String getWareHouse(String param) throws BOSException
    {
        try {
            return getController().getWareHouse(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除饲料领用单-User defined method
     *@param param 参数
     *@return
     */
    public String deleteBreedSeedRecBill(String param) throws BOSException
    {
        try {
            return getController().deleteBreedSeedRecBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getFarmerIDCardByTechManUserNum-User defined method
     *@param param 参数
     *@return
     */
    public String getFarmerIDCardByTechManUserNum(String param) throws BOSException
    {
        try {
            return getController().getFarmerIDCardByTechManUserNum(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取存栏信息-User defined method
     *@param param 参数
     *@return
     */
    public String getCurrentStocking(String param) throws BOSException
    {
        try {
            return getController().getCurrentStocking(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据养殖户获取技术员userNum-User defined method
     *@param param 参数
     *@return
     */
    public String getTechMantelByFarmer(String param) throws BOSException
    {
        try {
            return getController().getTechMantelByFarmer(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据user查询对应的职员-User defined method
     *@param param 参数
     *@return
     */
    public String getPersonInfoByUser(String param) throws BOSException
    {
        try {
            return getController().getPersonInfoByUser(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *养殖户确认-User defined method
     *@param param 参数
     *@return
     */
    public String confirmMethod(String param) throws BOSException
    {
        try {
            return getController().confirmMethod(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}