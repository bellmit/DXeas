package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class CKCostCalFacade extends AbstractBizCtrl implements ICKCostCalFacade
{
    public CKCostCalFacade()
    {
        super();
        registerInterface(ICKCostCalFacade.class, this);
    }
    public CKCostCalFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICKCostCalFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("65460B16");
    }
    private CKCostCalFacadeController getController() throws BOSException
    {
        return (CKCostCalFacadeController)getBizController();
    }
    /**
     *成本计算-User defined method
     *@param companyID 公司ID
     *@param periodID 期间ID
     */
    public void calCost(String companyID, String periodID) throws BOSException, EASBizException
    {
        try {
            getController().calCost(getContext(), companyID, periodID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}