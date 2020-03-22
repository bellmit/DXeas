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

public class OtherBillNewFacade extends AbstractBizCtrl implements IOtherBillNewFacade
{
    public OtherBillNewFacade()
    {
        super();
        registerInterface(IOtherBillNewFacade.class, this);
    }
    public OtherBillNewFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IOtherBillNewFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B1F9A42E");
    }
    private OtherBillNewFacadeController getController() throws BOSException
    {
        return (OtherBillNewFacadeController)getBizController();
    }
    /**
     *提交-User defined method
     *@param xmlData 应收单的XML格式表示
     *@return
     */
    public String[] submit(String xmlData) throws BOSException
    {
        try {
            return getController().submit(getContext(), xmlData);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}