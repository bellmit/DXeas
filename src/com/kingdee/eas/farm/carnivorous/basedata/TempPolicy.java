package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
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

public class TempPolicy extends DataBase implements ITempPolicy
{
    public TempPolicy()
    {
        super();
        registerInterface(ITempPolicy.class, this);
    }
    public TempPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(ITempPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0A9A9548");
    }
    private TempPolicyController getController() throws BOSException
    {
        return (TempPolicyController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public TempPolicyInfo getTempPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTempPolicyInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public TempPolicyInfo getTempPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTempPolicyInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public TempPolicyInfo getTempPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTempPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public TempPolicyCollection getTempPolicyCollection() throws BOSException
    {
        try {
            return getController().getTempPolicyCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public TempPolicyCollection getTempPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTempPolicyCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public TempPolicyCollection getTempPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getTempPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��׼-User defined method
     *@param model model
     */
    public void audit(TempPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����׼-User defined method
     *@param model model
     */
    public void unAudit(TempPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}