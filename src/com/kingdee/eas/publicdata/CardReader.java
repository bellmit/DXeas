package com.kingdee.eas.publicdata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.publicdata.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CardReader extends DataBase implements ICardReader
{
    public CardReader()
    {
        super();
        registerInterface(ICardReader.class, this);
    }
    public CardReader(Context ctx)
    {
        super(ctx);
        registerInterface(ICardReader.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("56CC9416");
    }
    private CardReaderController getController() throws BOSException
    {
        return (CardReaderController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CardReaderInfo getCardReaderInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCardReaderInfo(getContext(), pk);
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
    public CardReaderInfo getCardReaderInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCardReaderInfo(getContext(), pk, selector);
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
    public CardReaderInfo getCardReaderInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCardReaderInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CardReaderCollection getCardReaderCollection() throws BOSException
    {
        try {
            return getController().getCardReaderCollection(getContext());
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
    public CardReaderCollection getCardReaderCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCardReaderCollection(getContext(), view);
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
    public CardReaderCollection getCardReaderCollection(String oql) throws BOSException
    {
        try {
            return getController().getCardReaderCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}