package com.kingdee.eas.custom.festival;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.festival.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class SaleIssueBillNewFacade extends AbstractBizCtrl implements ISaleIssueBillNewFacade
{
    public SaleIssueBillNewFacade()
    {
        super();
        registerInterface(ISaleIssueBillNewFacade.class, this);
    }
    public SaleIssueBillNewFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleIssueBillNewFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("95C4642C");
    }
    private SaleIssueBillNewFacadeController getController() throws BOSException
    {
        return (SaleIssueBillNewFacadeController)getBizController();
    }
    /**
     *导入数据接口-User defined method
     *@param xmlData 导入的xml数据
     *@return
     */
    public String[] importData(String xmlData) throws BOSException
    {
        try {
            return getController().importData(getContext(), xmlData);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}