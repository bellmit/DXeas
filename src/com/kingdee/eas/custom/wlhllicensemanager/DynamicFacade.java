package com.kingdee.eas.custom.wlhllicensemanager;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class DynamicFacade extends AbstractBizCtrl implements IDynamicFacade
{
    public DynamicFacade()
    {
        super();
        registerInterface(IDynamicFacade.class, this);
    }
    public DynamicFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDynamicFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FAA341FB");
    }
    private DynamicFacadeController getController() throws BOSException
    {
        return (DynamicFacadeController)getBizController();
    }
    /**
     *getDataByID-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String getDataByID(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().getDataByID(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *uploadDataByBosType-User defined method
     *@param bosType bosType
     *@param jsonStr jsonStr
     *@return
     */
    public String uploadDataByBosType(String bosType, String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().uploadDataByBosType(getContext(), bosType, jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *downloadBillList-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String downloadBillList(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().downloadBillList(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *deleteAttachment-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String deleteAttachment(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().deleteAttachment(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getEumInfo-User defined method
     *@param enumPathJson enumPathJson
     *@return
     */
    public String getEumInfo(String enumPathJson) throws BOSException, EASBizException
    {
        try {
            return getController().getEumInfo(getContext(), enumPathJson);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}