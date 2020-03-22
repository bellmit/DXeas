package com.kingdee.eas.custom.taihe.equipment;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.equipment.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EquipmentTree extends TreeBase implements IEquipmentTree
{
    public EquipmentTree()
    {
        super();
        registerInterface(IEquipmentTree.class, this);
    }
    public EquipmentTree(Context ctx)
    {
        super(ctx);
        registerInterface(IEquipmentTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CD947CF2");
    }
    private EquipmentTreeController getController() throws BOSException
    {
        return (EquipmentTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EquipmentTreeInfo getEquipmentTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEquipmentTreeInfo(getContext(), pk);
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
    public EquipmentTreeInfo getEquipmentTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEquipmentTreeInfo(getContext(), pk, selector);
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
    public EquipmentTreeInfo getEquipmentTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEquipmentTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EquipmentTreeCollection getEquipmentTreeCollection() throws BOSException
    {
        try {
            return getController().getEquipmentTreeCollection(getContext());
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
    public EquipmentTreeCollection getEquipmentTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEquipmentTreeCollection(getContext(), view);
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
    public EquipmentTreeCollection getEquipmentTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getEquipmentTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}