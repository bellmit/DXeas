package com.kingdee.eas.custom.szcount;

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
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SzCountPositionSetTree extends TreeBase implements ISzCountPositionSetTree
{
    public SzCountPositionSetTree()
    {
        super();
        registerInterface(ISzCountPositionSetTree.class, this);
    }
    public SzCountPositionSetTree(Context ctx)
    {
        super(ctx);
        registerInterface(ISzCountPositionSetTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A1D124DA");
    }
    private SzCountPositionSetTreeController getController() throws BOSException
    {
        return (SzCountPositionSetTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSzCountPositionSetTreeInfo(getContext(), pk);
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
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSzCountPositionSetTreeInfo(getContext(), pk, selector);
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
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSzCountPositionSetTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection() throws BOSException
    {
        try {
            return getController().getSzCountPositionSetTreeCollection(getContext());
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
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSzCountPositionSetTreeCollection(getContext(), view);
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
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSzCountPositionSetTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}