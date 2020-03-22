package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HatchingBox extends DataBase implements IHatchingBox
{
    public HatchingBox()
    {
        super();
        registerInterface(IHatchingBox.class, this);
    }
    public HatchingBox(Context ctx)
    {
        super(ctx);
        registerInterface(IHatchingBox.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("55207BFB");
    }
    private HatchingBoxController getController() throws BOSException
    {
        return (HatchingBoxController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HatchingBoxInfo getHatchingBoxInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchingBoxInfo(getContext(), pk);
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
    public HatchingBoxInfo getHatchingBoxInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchingBoxInfo(getContext(), pk, selector);
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
    public HatchingBoxInfo getHatchingBoxInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHatchingBoxInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HatchingBoxCollection getHatchingBoxCollection() throws BOSException
    {
        try {
            return getController().getHatchingBoxCollection(getContext());
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
    public HatchingBoxCollection getHatchingBoxCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHatchingBoxCollection(getContext(), view);
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
    public HatchingBoxCollection getHatchingBoxCollection(String oql) throws BOSException
    {
        try {
            return getController().getHatchingBoxCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}