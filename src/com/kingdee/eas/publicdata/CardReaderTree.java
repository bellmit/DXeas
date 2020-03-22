package com.kingdee.eas.publicdata;

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
import com.kingdee.eas.publicdata.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CardReaderTree extends TreeBase implements ICardReaderTree
{
    public CardReaderTree()
    {
        super();
        registerInterface(ICardReaderTree.class, this);
    }
    public CardReaderTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICardReaderTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("37C080D4");
    }
    private CardReaderTreeController getController() throws BOSException
    {
        return (CardReaderTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CardReaderTreeInfo getCardReaderTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCardReaderTreeInfo(getContext(), pk);
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
    public CardReaderTreeInfo getCardReaderTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCardReaderTreeInfo(getContext(), pk, selector);
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
    public CardReaderTreeInfo getCardReaderTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCardReaderTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CardReaderTreeCollection getCardReaderTreeCollection() throws BOSException
    {
        try {
            return getController().getCardReaderTreeCollection(getContext());
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
    public CardReaderTreeCollection getCardReaderTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCardReaderTreeCollection(getContext(), view);
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
    public CardReaderTreeCollection getCardReaderTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCardReaderTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}