package com.kingdee.eas.custom.szcount;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MaterialConversionTree extends TreeBase implements IMaterialConversionTree
{
    public MaterialConversionTree()
    {
        super();
        registerInterface(IMaterialConversionTree.class, this);
    }
    public MaterialConversionTree(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialConversionTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("15DF7606");
    }
    private MaterialConversionTreeController getController() throws BOSException
    {
        return (MaterialConversionTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MaterialConversionTreeInfo getMaterialConversionTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialConversionTreeInfo(getContext(), pk);
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
    public MaterialConversionTreeInfo getMaterialConversionTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialConversionTreeInfo(getContext(), pk, selector);
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
    public MaterialConversionTreeInfo getMaterialConversionTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMaterialConversionTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MaterialConversionTreeCollection getMaterialConversionTreeCollection() throws BOSException
    {
        try {
            return getController().getMaterialConversionTreeCollection(getContext());
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
    public MaterialConversionTreeCollection getMaterialConversionTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMaterialConversionTreeCollection(getContext(), view);
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
    public MaterialConversionTreeCollection getMaterialConversionTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getMaterialConversionTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}