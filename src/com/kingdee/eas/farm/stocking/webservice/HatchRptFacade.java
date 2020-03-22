package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.webservice.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class HatchRptFacade extends AbstractBizCtrl implements IHatchRptFacade
{
    public HatchRptFacade()
    {
        super();
        registerInterface(IHatchRptFacade.class, this);
    }
    public HatchRptFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchRptFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D5E44E0E");
    }
    private HatchRptFacadeController getController() throws BOSException
    {
        return (HatchRptFacadeController)getBizController();
    }
    /**
     *养殖户获取照蛋记录单的相关数据-User defined method
     *@param param 参数
     *@return
     */
    public String getBEggCandlingBill(String param) throws BOSException
    {
        try {
            return getController().getBEggCandlingBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}