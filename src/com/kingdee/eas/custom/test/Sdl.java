package com.kingdee.eas.custom.test;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.custom.test.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Sdl extends CoreBillBase implements ISdl
{
    public Sdl()
    {
        super();
        registerInterface(ISdl.class, this);
    }
    public Sdl(Context ctx)
    {
        super(ctx);
        registerInterface(ISdl.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8151256A");
    }
    private SdlController getController() throws BOSException
    {
        return (SdlController)getBizController();
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public SdlCollection getSdlCollection() throws BOSException
    {
        try {
            return getController().getSdlCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public SdlCollection getSdlCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSdlCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public SdlCollection getSdlCollection(String oql) throws BOSException
    {
        try {
            return getController().getSdlCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public SdlInfo getSdlInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSdlInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public SdlInfo getSdlInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSdlInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public SdlInfo getSdlInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSdlInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}