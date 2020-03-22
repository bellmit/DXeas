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

public class AreaEmpCRptFacade extends CommRptBase implements IAreaEmpCRptFacade
{
    public AreaEmpCRptFacade()
    {
        super();
        registerInterface(IAreaEmpCRptFacade.class, this);
    }
    public AreaEmpCRptFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IAreaEmpCRptFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FAEDB9D5");
    }
    private AreaEmpCRptFacadeController getController() throws BOSException
    {
        return (AreaEmpCRptFacadeController)getBizController();
    }
}