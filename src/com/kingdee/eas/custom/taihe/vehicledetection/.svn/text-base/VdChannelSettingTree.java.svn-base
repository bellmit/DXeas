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

public class VdChannelSettingTree extends TreeBase implements IVdChannelSettingTree
{
    public VdChannelSettingTree()
    {
        super();
        registerInterface(IVdChannelSettingTree.class, this);
    }
    public VdChannelSettingTree(Context ctx)
    {
        super(ctx);
        registerInterface(IVdChannelSettingTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8BD9248E");
    }
    private VdChannelSettingTreeController getController() throws BOSException
    {
        return (VdChannelSettingTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public VdChannelSettingTreeInfo getVdChannelSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getVdChannelSettingTreeInfo(getContext(), pk);
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
    public VdChannelSettingTreeInfo getVdChannelSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getVdChannelSettingTreeInfo(getContext(), pk, selector);
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
    public VdChannelSettingTreeInfo getVdChannelSettingTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getVdChannelSettingTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public VdChannelSettingTreeCollection getVdChannelSettingTreeCollection() throws BOSException
    {
        try {
            return getController().getVdChannelSettingTreeCollection(getContext());
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
    public VdChannelSettingTreeCollection getVdChannelSettingTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getVdChannelSettingTreeCollection(getContext(), view);
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
    public VdChannelSettingTreeCollection getVdChannelSettingTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getVdChannelSettingTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}