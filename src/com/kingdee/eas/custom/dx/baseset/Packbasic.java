package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.dx.baseset.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Packbasic extends WlhlBillBase implements IPackbasic
{
    public Packbasic()
    {
        super();
        registerInterface(IPackbasic.class, this);
    }
    public Packbasic(Context ctx)
    {
        super(ctx);
        registerInterface(IPackbasic.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EAD218E9");
    }
    private PackbasicController getController() throws BOSException
    {
        return (PackbasicController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PackbasicCollection getPackbasicCollection() throws BOSException
    {
        try {
            return getController().getPackbasicCollection(getContext());
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
    public PackbasicCollection getPackbasicCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPackbasicCollection(getContext(), view);
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
    public PackbasicCollection getPackbasicCollection(String oql) throws BOSException
    {
        try {
            return getController().getPackbasicCollection(getContext(), oql);
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
    public PackbasicInfo getPackbasicInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPackbasicInfo(getContext(), pk);
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
    public PackbasicInfo getPackbasicInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPackbasicInfo(getContext(), pk, selector);
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
    public PackbasicInfo getPackbasicInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPackbasicInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取数据-User defined method
     *@param model model
     */
    public void getData(PackbasicInfo model) throws BOSException
    {
        try {
            getController().getData(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}