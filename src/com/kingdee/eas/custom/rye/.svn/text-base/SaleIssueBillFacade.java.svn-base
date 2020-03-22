package com.kingdee.eas.custom.rye;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.rye.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class SaleIssueBillFacade extends AbstractBizCtrl implements ISaleIssueBillFacade
{
    public SaleIssueBillFacade()
    {
        super();
        registerInterface(ISaleIssueBillFacade.class, this);
    }
    public SaleIssueBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleIssueBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4CCAE09E");
    }
    private SaleIssueBillFacadeController getController() throws BOSException
    {
        return (SaleIssueBillFacadeController)getBizController();
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