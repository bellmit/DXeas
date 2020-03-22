package com.kingdee.eas.custom.purchasebudget;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.purchasebudget.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;
import com.kingdee.eas.tools.datatask.DIETemplateInfo;
import com.kingdee.bos.util.*;

public class purBudgetFacade extends AbstractBizCtrl implements IpurBudgetFacade
{
    public purBudgetFacade()
    {
        super();
        registerInterface(IpurBudgetFacade.class, this);
    }
    public purBudgetFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IpurBudgetFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("93B695AF");
    }
    private purBudgetFacadeController getController() throws BOSException
    {
        return (purBudgetFacadeController)getBizController();
    }
    /**
     *生成采购预算单据-User defined method
     *@param DIETemplateInfo 模板info
     *@param queryResult excel的值
     *@return
     */
    public String createPurBudgetInfo(DIETemplateInfo DIETemplateInfo, HashMap queryResult) throws BOSException, EASBizException
    {
        try {
            return getController().createPurBudgetInfo(getContext(), DIETemplateInfo, queryResult);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}