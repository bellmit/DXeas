package com.kingdee.eas.custom.szcount;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaterialConversion extends DataBase implements IMaterialConversion
{
    public MaterialConversion()
    {
        super();
        registerInterface(IMaterialConversion.class, this);
    }
    public MaterialConversion(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialConversion.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EC09F248");
    }
    private MaterialConversionController getController() throws BOSException
    {
        return (MaterialConversionController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MaterialConversionInfo getMaterialConversionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialConversionInfo(getContext(), pk);
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
    public MaterialConversionInfo getMaterialConversionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialConversionInfo(getContext(), pk, selector);
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
    public MaterialConversionInfo getMaterialConversionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialConversionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialConversionCollection getMaterialConversionCollection() throws BOSException
    {
        try {
            return getController().getMaterialConversionCollection(getContext());
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
    public MaterialConversionCollection getMaterialConversionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialConversionCollection(getContext(), view);
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
    public MaterialConversionCollection getMaterialConversionCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialConversionCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}