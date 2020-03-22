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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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