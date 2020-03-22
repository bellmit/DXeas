package com.kingdee.eas.custom.eas2temp;

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
import com.kingdee.eas.custom.eas2temp.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BillDeafultSettingTree extends TreeBase implements IBillDeafultSettingTree
{
    public BillDeafultSettingTree()
    {
        super();
        registerInterface(IBillDeafultSettingTree.class, this);
    }
    public BillDeafultSettingTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBillDeafultSettingTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("34CFA232");
    }
    private BillDeafultSettingTreeController getController() throws BOSException
    {
        return (BillDeafultSettingTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBillDeafultSettingTreeInfo(getContext(), pk);
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
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBillDeafultSettingTreeInfo(getContext(), pk, selector);
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
    public BillDeafultSettingTreeInfo getBillDeafultSettingTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBillDeafultSettingTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection() throws BOSException
    {
        try {
            return getController().getBillDeafultSettingTreeCollection(getContext());
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
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBillDeafultSettingTreeCollection(getContext(), view);
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
    public BillDeafultSettingTreeCollection getBillDeafultSettingTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBillDeafultSettingTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}