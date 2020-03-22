package com.kingdee.eas.farm.rpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.rpt.app.*;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public class CCProductPlanDetailRptFacade extends AbstractBizCtrl implements ICCProductPlanDetailRptFacade
{
    public CCProductPlanDetailRptFacade()
    {
        super();
        registerInterface(ICCProductPlanDetailRptFacade.class, this);
    }
    public CCProductPlanDetailRptFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICCProductPlanDetailRptFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2DE7243F");
    }
    private CCProductPlanDetailRptFacadeController getController() throws BOSException
    {
        return (CCProductPlanDetailRptFacadeController)getBizController();
    }
    /**
     *getRptData-User defined method
     *@param param ²ÎÊý
     *@return
     */
    public IRowSet getRptData(HashMap param) throws BOSException
    {
        try {
            return getController().getRptData(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}