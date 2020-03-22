package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.signwasthetable.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class transformBotp extends AbstractBizCtrl implements ItransformBotp
{
    public transformBotp()
    {
        super();
        registerInterface(ItransformBotp.class, this);
    }
    public transformBotp(Context ctx)
    {
        super(ctx);
        registerInterface(ItransformBotp.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("686E9CF8");
    }
    private transformBotpController getController() throws BOSException
    {
        return (transformBotpController)getBizController();
    }
    /**
     *transformForBotp-User defined method
     */
    public void transformForBotp() throws BOSException
    {
        try {
            getController().transformForBotp(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}