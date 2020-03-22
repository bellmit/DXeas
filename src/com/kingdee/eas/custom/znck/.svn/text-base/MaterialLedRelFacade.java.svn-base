package com.kingdee.eas.custom.znck;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import com.kingdee.eas.custom.znck.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class MaterialLedRelFacade extends AbstractBizCtrl implements IMaterialLedRelFacade
{
    public MaterialLedRelFacade()
    {
        super();
        registerInterface(IMaterialLedRelFacade.class, this);
    }
    public MaterialLedRelFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialLedRelFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CCF96F76");
    }
    private MaterialLedRelFacadeController getController() throws BOSException
    {
        return (MaterialLedRelFacadeController)getBizController();
    }
    /**
     *getMaterialRelLEDNumbers-User defined method
     *@param materials materials
     *@return
     */
    public List getMaterialRelLEDNumbers(List materials) throws BOSException
    {
        try {
            return getController().getMaterialRelLEDNumbers(getContext(), materials);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}