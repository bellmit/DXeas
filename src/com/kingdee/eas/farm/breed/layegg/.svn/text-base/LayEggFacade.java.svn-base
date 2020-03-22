package com.kingdee.eas.farm.breed.layegg;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;

public class LayEggFacade extends AbstractBizCtrl implements ILayEggFacade
{
    public LayEggFacade()
    {
        super();
        registerInterface(ILayEggFacade.class, this);
    }
    public LayEggFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ILayEggFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D392CC8");
    }
    private LayEggFacadeController getController() throws BOSException
    {
        return (LayEggFacadeController)getBizController();
    }
    /**
     *获得指定鸡舍的 产蛋设置-User defined method
     *@param henhouseID 鸡舍id
     *@return
     */
    public Object getHouseLayEggSet(String henhouseID) throws BOSException
    {
        try {
            return getController().getHouseLayEggSet(getContext(), henhouseID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得指定库存组织所有的 传送带信息-User defined method
     *@param stoOrgID 仓库id
     *@return
     */
    public List getConveyors(String stoOrgID) throws BOSException
    {
        try {
            return getController().getConveyors(getContext(), stoOrgID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得 养殖规范中的产蛋规范分录明细-User defined method
     *@param henType 1，白羽鸡2，3，备用
     *@return
     */
    public Map getLayeggStandard(String henType) throws BOSException
    {
        try {
            return getController().getLayeggStandard(getContext(), henType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得饲喂规范-User defined method
     *@param henType 鸡舍类型
     *@return
     */
    public Map getFeedStandard(String henType) throws BOSException
    {
        try {
            return getController().getFeedStandard(getContext(), henType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *判断指定批次到指定日期是否已经定栏-User defined method
     *@param batchID 批次ID
     *@param bizDate 业务日期
     *@return
     */
    public boolean isBatchFixed(String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().isBatchFixed(getContext(), batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取指定业务日期对应养殖场的  在养批次-User defined method
     *@param internalFarmID 内部养殖场ID
     *@param bizDate 业务日期
     *@return
     */
    public ParentBreedBatchInfo getCurrentParentBatch(String internalFarmID, Date bizDate) throws BOSException
    {
        try {
            return getController().getCurrentParentBatch(getContext(), internalFarmID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *校验指定的养殖批次某天是否已经存在日报-User defined method
     *@param breedBatchID breedBatchID
     *@param bizDate bizDate
     *@param batchID batchID
     *@return
     */
    public boolean checkDateDailyState(String breedBatchID, Date bizDate, String batchID) throws BOSException
    {
        try {
            return getController().checkDateDailyState(getContext(), breedBatchID, bizDate, batchID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成放养日报-User defined method
     */
    public void toStockDaily() throws BOSException
    {
        try {
            getController().toStockDaily(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}