package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.farm.dayratecost.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class DayrateCalFacade extends AbstractBizCtrl implements IDayrateCalFacade
{
    public DayrateCalFacade()
    {
        super();
        registerInterface(IDayrateCalFacade.class, this);
    }
    public DayrateCalFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDayrateCalFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("95361A51");
    }
    private DayrateCalFacadeController getController() throws BOSException
    {
        return (DayrateCalFacadeController)getBizController();
    }
    /**
     *日成本计算-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public Object exeCalDayrate(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().exeCalDayrate(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行结账-User defined method
     *@param companyID companyID
     *@param periodID periodID
     */
    public void exeClose(String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            getController().exeClose(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行反结账-User defined method
     *@param companyID companyID
     *@param periodID periodID
     */
    public void exeUnClose(String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            getController().exeUnClose(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}