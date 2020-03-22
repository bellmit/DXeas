package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.taihe.sewagedetection.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class CheckRecordFacade extends AbstractBizCtrl implements ICheckRecordFacade
{
    public CheckRecordFacade()
    {
        super();
        registerInterface(ICheckRecordFacade.class, this);
    }
    public CheckRecordFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckRecordFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6F5F52D6");
    }
    private CheckRecordFacadeController getController() throws BOSException
    {
        return (CheckRecordFacadeController)getBizController();
    }
    /**
     *获得实时数据-User defined method
     *@return
     */
    public String getNowDate() throws BOSException
    {
        try {
            return getController().getNowDate(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得历史明细-User defined method
     *@param date 时间
     *@return
     */
    public String getHistoryDate(String date) throws BOSException
    {
        try {
            return getController().getHistoryDate(getContext(), date);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}