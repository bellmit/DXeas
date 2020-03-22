package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.taihe.contract.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AssureAmtPolicyTree extends TreeBase implements IAssureAmtPolicyTree
{
    public AssureAmtPolicyTree()
    {
        super();
        registerInterface(IAssureAmtPolicyTree.class, this);
    }
    public AssureAmtPolicyTree(Context ctx)
    {
        super(ctx);
        registerInterface(IAssureAmtPolicyTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B5875735");
    }
    private AssureAmtPolicyTreeController getController() throws BOSException
    {
        return (AssureAmtPolicyTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AssureAmtPolicyTreeInfo getAssureAmtPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAssureAmtPolicyTreeInfo(getContext(), pk);
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
    public AssureAmtPolicyTreeInfo getAssureAmtPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAssureAmtPolicyTreeInfo(getContext(), pk, selector);
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
    public AssureAmtPolicyTreeInfo getAssureAmtPolicyTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAssureAmtPolicyTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AssureAmtPolicyTreeCollection getAssureAmtPolicyTreeCollection() throws BOSException
    {
        try {
            return getController().getAssureAmtPolicyTreeCollection(getContext());
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
    public AssureAmtPolicyTreeCollection getAssureAmtPolicyTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAssureAmtPolicyTreeCollection(getContext(), view);
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
    public AssureAmtPolicyTreeCollection getAssureAmtPolicyTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getAssureAmtPolicyTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}