package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.taihe.vehicledetection.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class VCFunctionFacade extends AbstractBizCtrl implements IVCFunctionFacade
{
    public VCFunctionFacade()
    {
        super();
        registerInterface(IVCFunctionFacade.class, this);
    }
    public VCFunctionFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IVCFunctionFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("48D63134");
    }
    private VCFunctionFacadeController getController() throws BOSException
    {
        return (VCFunctionFacadeController)getBizController();
    }
    /**
     *checkPermission-User defined method
     *@param param param
     *@return
     */
    public String checkPermission(String param) throws BOSException, EASBizException
    {
        try {
            return getController().checkPermission(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}