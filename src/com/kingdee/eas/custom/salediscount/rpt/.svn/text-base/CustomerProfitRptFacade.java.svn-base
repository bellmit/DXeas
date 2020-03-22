package com.kingdee.eas.custom.salediscount.rpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.salediscount.rpt.app.*;
import com.kingdee.eas.framework.report.CommRptBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class CustomerProfitRptFacade extends CommRptBase implements ICustomerProfitRptFacade
{
    public CustomerProfitRptFacade()
    {
        super();
        registerInterface(ICustomerProfitRptFacade.class, this);
    }
    public CustomerProfitRptFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerProfitRptFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("76044C3B");
    }
    private CustomerProfitRptFacadeController getController() throws BOSException
    {
        return (CustomerProfitRptFacadeController)getBizController();
    }
}