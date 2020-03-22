package com.kingdee.eas.custom.ccchargeback;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.ccchargeback.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class ccCheckBillFacade extends AbstractBizCtrl implements IccCheckBillFacade
{
    public ccCheckBillFacade()
    {
        super();
        registerInterface(IccCheckBillFacade.class, this);
    }
    public ccCheckBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IccCheckBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E53DE1E1");
    }
    private ccCheckBillFacadeController getController() throws BOSException
    {
        return (ccCheckBillFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]String[%returndesc]-User defined method
     *@param henHouseID º¶…·ID
     *@return
     */
    public String getLairageQtyByHenhouseId(String henHouseID) throws BOSException, EASBizException
    {
        try {
            return getController().getLairageQtyByHenhouseId(getContext(), henHouseID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}