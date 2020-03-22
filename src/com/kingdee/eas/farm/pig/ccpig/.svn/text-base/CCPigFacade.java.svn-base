package com.kingdee.eas.farm.pig.ccpig;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.pig.ccpig.app.*;
import com.kingdee.eas.farm.pig.bean.CCPigBatchNormalInfo;
import com.kingdee.bos.util.*;

public class CCPigFacade extends AbstractBizCtrl implements ICCPigFacade
{
    public CCPigFacade()
    {
        super();
        registerInterface(ICCPigFacade.class, this);
    }
    public CCPigFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICCPigFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3EBC9AA8");
    }
    private CCPigFacadeController getController() throws BOSException
    {
        return (CCPigFacadeController)getBizController();
    }
    /**
     *获取养殖场 批次明细-User defined method
     *@param farmID 养殖场ID
     *@param bizDate 业务日期
     *@return
     */
    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(String farmID, Date bizDate) throws BOSException
    {
        try {
            return getController().getFarmBreedCCPigBatch(getContext(), farmID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取养殖场 批次明细-User defined method
     *@param farmID 养殖场ID
     *@param batchID 批次ID
     *@param bizDate 业务日期
     *@return
     */
    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(String farmID, String batchID, Date bizDate) throws BOSException
    {
        try {
            return getController().getFarmBreedCCPigBatch(getContext(), farmID, batchID, bizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得当前启用的商品猪养殖规范-User defined method
     *@param bizDate 业务日期
     *@param farmID farmID
     *@return
     */
    public CCPigBreedModelInfo getAvailableBreedModel(Date bizDate, String farmID) throws BOSException
    {
        try {
            return getController().getAvailableBreedModel(getContext(), bizDate, farmID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得制定日龄的养殖规范明细-User defined method
     *@param modelInfo modelInfo
     *@param days 日龄
     *@return
     */
    public CCPigBreedModelEntryInfo getModelBreedEntryInfo(CCPigBreedModelInfo modelInfo, int days) throws BOSException
    {
        try {
            return getController().getModelBreedEntryInfo(getContext(), modelInfo, days);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得 养殖规范对应日龄的免疫规范-User defined method
     *@param modelInfo modelInfo
     *@param bizDate 业务日期
     *@param days days
     *@return
     */
    public List getModelImmunePlans(CCPigBreedModelInfo modelInfo, Date bizDate, int days) throws BOSException
    {
        try {
            return getController().getModelImmunePlans(getContext(), modelInfo, bizDate, days);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取批次最近养殖批次-User defined method
     *@param modelInfo modelInfo
     *@param bizDate bizDate
     *@param batchDays 批次日龄
     *@return
     */
    public List getModelRecentImmunePlans(CCPigBreedModelInfo modelInfo, Date bizDate, int batchDays) throws BOSException
    {
        try {
            return getController().getModelRecentImmunePlans(getContext(), modelInfo, bizDate, batchDays);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}