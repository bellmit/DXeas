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

public class MaterialStandardCostTree extends TreeBase implements IMaterialStandardCostTree
{
    public MaterialStandardCostTree()
    {
        super();
        registerInterface(IMaterialStandardCostTree.class, this);
    }
    public MaterialStandardCostTree(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialStandardCostTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("808B8D23");
    }
    private MaterialStandardCostTreeController getController() throws BOSException
    {
        return (MaterialStandardCostTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MaterialStandardCostTreeInfo getMaterialStandardCostTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialStandardCostTreeInfo(getContext(), pk);
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
    public MaterialStandardCostTreeInfo getMaterialStandardCostTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialStandardCostTreeInfo(getContext(), pk, selector);
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
    public MaterialStandardCostTreeInfo getMaterialStandardCostTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialStandardCostTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialStandardCostTreeCollection getMaterialStandardCostTreeCollection() throws BOSException
    {
        try {
            return getController().getMaterialStandardCostTreeCollection(getContext());
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
    public MaterialStandardCostTreeCollection getMaterialStandardCostTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialStandardCostTreeCollection(getContext(), view);
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
    public MaterialStandardCostTreeCollection getMaterialStandardCostTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialStandardCostTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}