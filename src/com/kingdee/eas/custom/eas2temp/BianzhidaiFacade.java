package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.report.CommRptBase;
import com.kingdee.eas.custom.eas2temp.app.*;

public class BianzhidaiFacade extends CommRptBase implements IBianzhidaiFacade
{
    public BianzhidaiFacade()
    {
        super();
        registerInterface(IBianzhidaiFacade.class, this);
    }
    public BianzhidaiFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IBianzhidaiFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F64A7933");
    }
    private BianzhidaiFacadeController getController() throws BOSException
    {
        return (BianzhidaiFacadeController)getBizController();
    }
}