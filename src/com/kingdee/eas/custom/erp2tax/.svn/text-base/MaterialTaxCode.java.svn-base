package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.erp2tax.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaterialTaxCode extends DataBase implements IMaterialTaxCode
{
    public MaterialTaxCode()
    {
        super();
        registerInterface(IMaterialTaxCode.class, this);
    }
    public MaterialTaxCode(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialTaxCode.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E13EE15A");
    }
    private MaterialTaxCodeController getController() throws BOSException
    {
        return (MaterialTaxCodeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialTaxCodeInfo(getContext(), pk);
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
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialTaxCodeInfo(getContext(), pk, selector);
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
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialTaxCodeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection() throws BOSException
    {
        try {
            return getController().getMaterialTaxCodeCollection(getContext());
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
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialTaxCodeCollection(getContext(), view);
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
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialTaxCodeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}