package com.kingdee.eas.custom.rpt;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.framework.report.CommRptBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.custom.rpt.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class MaterialApplyFacade extends CommRptBase implements IMaterialApplyFacade
{
    public MaterialApplyFacade()
    {
        super();
        registerInterface(IMaterialApplyFacade.class, this);
    }
    public MaterialApplyFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialApplyFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E7EA37A4");
    }
    private MaterialApplyFacadeController getController() throws BOSException
    {
        return (MaterialApplyFacadeController)getBizController();
    }
}