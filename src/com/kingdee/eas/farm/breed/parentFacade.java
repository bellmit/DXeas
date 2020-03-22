package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchDetailInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class parentFacade extends AbstractBizCtrl implements IparentFacade
{
    public parentFacade()
    {
        super();
        registerInterface(IparentFacade.class, this);
    }
    public parentFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IparentFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D8E26C1E");
    }
    private parentFacadeController getController() throws BOSException
    {
        return (parentFacadeController)getBizController();
    }
    /**
     *获得指定库存组织-User defined method
     *@param stoOrgID 库存组织ID
     *@return
     */
    public BreedStoorgSetInfo getFarmByStoOrgID(String stoOrgID) throws BOSException
    {
        try {
            return getController().getFarmByStoOrgID(getContext(), stoOrgID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得 养殖批次明细信息-User defined method
     *@param parentBatchID parentBatchID
     *@param bizDate 业务日期
     *@return
     */
    public ParentBreedBatchDetailInfo getBreedBatchDetailInfos(String parentBatchID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBreedBatchDetailInfos(getContext(), parentBatchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBreedModel-User defined method
     *@param henhouseType 禽舍类型
     *@param companyID 公司ID
     *@param isMoulting 是否换羽
     *@return
     */
    public BreedModelInfo getBreedModel(String henhouseType, String companyID, boolean isMoulting) throws BOSException
    {
        try {
            return getController().getBreedModel(getContext(), henhouseType, companyID, isMoulting);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取批次到当前日期的周龄和日龄-User defined method
     *@param parentBatchID 批次ID
     *@param bizDate 业务日期
     *@return
     */
    public HashMap getBatchWeekages(String parentBatchID, Date bizDate) throws BOSException
    {
        try {
            return getController().getBatchWeekages(getContext(), parentBatchID, bizDate);
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
     *判断指定批次到指定日期是否已经转育成-User defined method
     *@param batchID batchID
     *@param bizDate bizDate
     *@return
     */
    public boolean isBatchBroodFixed(String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().isBatchBroodFixed(getContext(), batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}