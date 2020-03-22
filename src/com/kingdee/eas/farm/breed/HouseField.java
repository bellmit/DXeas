package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HouseField extends DataBase implements IHouseField
{
    public HouseField()
    {
        super();
        registerInterface(IHouseField.class, this);
    }
    public HouseField(Context ctx)
    {
        super(ctx);
        registerInterface(IHouseField.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("64EAEE94");
    }
    private HouseFieldController getController() throws BOSException
    {
        return (HouseFieldController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public HouseFieldInfo getHouseFieldInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getHouseFieldInfo(getContext(), pk);
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
    public HouseFieldInfo getHouseFieldInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getHouseFieldInfo(getContext(), pk, selector);
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
    public HouseFieldInfo getHouseFieldInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getHouseFieldInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public HouseFieldCollection getHouseFieldCollection() throws BOSException
    {
        try {
            return getController().getHouseFieldCollection(getContext());
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
    public HouseFieldCollection getHouseFieldCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getHouseFieldCollection(getContext(), view);
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
    public HouseFieldCollection getHouseFieldCollection(String oql) throws BOSException
    {
        try {
            return getController().getHouseFieldCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}