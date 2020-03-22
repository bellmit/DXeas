package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.food.app.*;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class SendCarPlanFacade extends AbstractBizCtrl implements ISendCarPlanFacade
{
    public SendCarPlanFacade()
    {
        super();
        registerInterface(ISendCarPlanFacade.class, this);
    }
    public SendCarPlanFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISendCarPlanFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("23E13205");
    }
    private SendCarPlanFacadeController getController() throws BOSException
    {
        return (SendCarPlanFacadeController)getBizController();
    }
    /**
     *getRowSet-User defined method
     *@param hashMap hashMap
     *@return
     */
    public ArrayList getRowSet(HashMap hashMap) throws BOSException, EASBizException
    {
        try {
            return getController().getRowSet(getContext(), hashMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getCCBatchAgeAndQty-User defined method
     *@param bizDate bizDate
     *@param breedDays breedDays
     *@param count count
     *@return
     */
    public ArrayList getCCBatchAgeAndQty(Date bizDate, int breedDays, int count) throws BOSException
    {
        try {
            return getController().getCCBatchAgeAndQty(getContext(), bizDate, breedDays, count);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}