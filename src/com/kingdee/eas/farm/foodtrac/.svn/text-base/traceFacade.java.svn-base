package com.kingdee.eas.farm.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.bos.BOSException;
import java.util.List;
import java.lang.String;
import com.kingdee.eas.farm.foodtrac.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class traceFacade extends AbstractBizCtrl implements ItraceFacade
{
    public traceFacade()
    {
        super();
        registerInterface(ItraceFacade.class, this);
    }
    public traceFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ItraceFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("10772615");
    }
    private traceFacadeController getController() throws BOSException
    {
        return (traceFacadeController)getBizController();
    }
    /**
     *获得批次明细信息-User defined method
     *@param batchNumber 批号
     *@return
     */
    public String getBatchDetailInfos(String batchNumber) throws BOSException
    {
        try {
            return getController().getBatchDetailInfos(getContext(), batchNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取批次的出雏信息列表-User defined method
     *@param batchInfo 批次信息
     *@return
     */
    public List getBatchHatchBills(BreedBatchInfo batchInfo) throws BOSException
    {
        try {
            return getController().getBatchHatchBills(getContext(), batchInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}