package com.kingdee.eas.custom.taihe.vehicledetection;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.taihe.vehicledetection.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class VcWhiteListTree extends TreeBase implements IVcWhiteListTree
{
    public VcWhiteListTree()
    {
        super();
        registerInterface(IVcWhiteListTree.class, this);
    }
    public VcWhiteListTree(Context ctx)
    {
        super(ctx);
        registerInterface(IVcWhiteListTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("183A05A3");
    }
    private VcWhiteListTreeController getController() throws BOSException
    {
        return (VcWhiteListTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public VcWhiteListTreeInfo getVcWhiteListTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVcWhiteListTreeInfo(getContext(), pk);
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
    public VcWhiteListTreeInfo getVcWhiteListTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVcWhiteListTreeInfo(getContext(), pk, selector);
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
    public VcWhiteListTreeInfo getVcWhiteListTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVcWhiteListTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VcWhiteListTreeCollection getVcWhiteListTreeCollection() throws BOSException
    {
        try {
            return getController().getVcWhiteListTreeCollection(getContext());
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
    public VcWhiteListTreeCollection getVcWhiteListTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVcWhiteListTreeCollection(getContext(), view);
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
    public VcWhiteListTreeCollection getVcWhiteListTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getVcWhiteListTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}