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

public class MarginBreedPolicy extends DataBase implements IMarginBreedPolicy
{
    public MarginBreedPolicy()
    {
        super();
        registerInterface(IMarginBreedPolicy.class, this);
    }
    public MarginBreedPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(IMarginBreedPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C00593D6");
    }
    private MarginBreedPolicyController getController() throws BOSException
    {
        return (MarginBreedPolicyController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public MarginBreedPolicyInfo getMarginBreedPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBreedPolicyInfo(getContext(), pk);
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
    public MarginBreedPolicyInfo getMarginBreedPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBreedPolicyInfo(getContext(), pk, selector);
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
    public MarginBreedPolicyInfo getMarginBreedPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBreedPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public MarginBreedPolicyCollection getMarginBreedPolicyCollection() throws BOSException
    {
        try {
            return getController().getMarginBreedPolicyCollection(getContext());
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
    public MarginBreedPolicyCollection getMarginBreedPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarginBreedPolicyCollection(getContext(), view);
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
    public MarginBreedPolicyCollection getMarginBreedPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarginBreedPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *���-User defined method
     *@param model model
     */
    public void audtit(MarginBreedPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audtit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�����-User defined method
     *@param model model
     */
    public void unAudit(MarginBreedPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}