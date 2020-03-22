package com.kingdee.eas.custom.rye;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.rye.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RyeReadFiles extends CoreBillBase implements IRyeReadFiles
{
    public RyeReadFiles()
    {
        super();
        registerInterface(IRyeReadFiles.class, this);
    }
    public RyeReadFiles(Context ctx)
    {
        super(ctx);
        registerInterface(IRyeReadFiles.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DC7B44D8");
    }
    private RyeReadFilesController getController() throws BOSException
    {
        return (RyeReadFilesController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RyeReadFilesCollection getRyeReadFilesCollection() throws BOSException
    {
        try {
            return getController().getRyeReadFilesCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public RyeReadFilesCollection getRyeReadFilesCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRyeReadFilesCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public RyeReadFilesCollection getRyeReadFilesCollection(String oql) throws BOSException
    {
        try {
            return getController().getRyeReadFilesCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public RyeReadFilesInfo getRyeReadFilesInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRyeReadFilesInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public RyeReadFilesInfo getRyeReadFilesInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRyeReadFilesInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public RyeReadFilesInfo getRyeReadFilesInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRyeReadFilesInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}