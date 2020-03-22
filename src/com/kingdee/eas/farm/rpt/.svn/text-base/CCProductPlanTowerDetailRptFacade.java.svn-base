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

public class CCProductPlanTowerDetailRptFacade extends AbstractBizCtrl implements ICCProductPlanTowerDetailRptFacade
{
    public CCProductPlanTowerDetailRptFacade()
    {
        super();
        registerInterface(ICCProductPlanTowerDetailRptFacade.class, this);
    }
    public CCProductPlanTowerDetailRptFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICCProductPlanTowerDetailRptFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5DD36736");
    }
    private CCProductPlanTowerDetailRptFacadeController getController() throws BOSException
    {
        return (CCProductPlanTowerDetailRptFacadeController)getBizController();
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