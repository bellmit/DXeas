package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.webservice.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commonld.IWebServiceFacade;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.commonld.WebServiceFacade;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class PollingRecordFacade extends WebServiceFacade implements IPollingRecordFacade
{
    public PollingRecordFacade()
    {
        super();
        registerInterface(IPollingRecordFacade.class, this);
    }
    public PollingRecordFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IPollingRecordFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4096B630");
    }
    private PollingRecordFacadeController getController() throws BOSException
    {
        return (PollingRecordFacadeController)getBizController();
    }
    /**
     *根据技术员获取当前在养批次-User defined method
     *@param param 参数
     *@return
     */
    public String getBatchInfoByTechMan(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchInfoByTechMan(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取物料-User defined method
     *@param param 参数
     *@return
     */
    public String getMaterial(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterial(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}