package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SalerStimulateSetTree extends TreeBase implements ISalerStimulateSetTree
{
    public SalerStimulateSetTree()
    {
        super();
        registerInterface(ISalerStimulateSetTree.class, this);
    }
    public SalerStimulateSetTree(Context ctx)
    {
        super(ctx);
        registerInterface(ISalerStimulateSetTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("67DBC681");
    }
    private SalerStimulateSetTreeController getController() throws BOSException
    {
        return (SalerStimulateSetTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SalerStimulateSetTreeInfo getSalerStimulateSetTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSalerStimulateSetTreeInfo(getContext(), pk);
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
    public SalerStimulateSetTreeInfo getSalerStimulateSetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSalerStimulateSetTreeInfo(getContext(), pk, selector);
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
    public SalerStimulateSetTreeInfo getSalerStimulateSetTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSalerStimulateSetTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SalerStimulateSetTreeCollection getSalerStimulateSetTreeCollection() throws BOSException
    {
        try {
            return getController().getSalerStimulateSetTreeCollection(getContext());
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
    public SalerStimulateSetTreeCollection getSalerStimulateSetTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSalerStimulateSetTreeCollection(getContext(), view);
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
    public SalerStimulateSetTreeCollection getSalerStimulateSetTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSalerStimulateSetTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}