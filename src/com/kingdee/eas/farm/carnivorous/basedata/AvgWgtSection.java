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

public class AvgWgtSection extends DataBase implements IAvgWgtSection
{
    public AvgWgtSection()
    {
        super();
        registerInterface(IAvgWgtSection.class, this);
    }
    public AvgWgtSection(Context ctx)
    {
        super(ctx);
        registerInterface(IAvgWgtSection.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("99C848B1");
    }
    private AvgWgtSectionController getController() throws BOSException
    {
        return (AvgWgtSectionController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AvgWgtSectionInfo getAvgWgtSectionInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAvgWgtSectionInfo(getContext(), pk);
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
    public AvgWgtSectionInfo getAvgWgtSectionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAvgWgtSectionInfo(getContext(), pk, selector);
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
    public AvgWgtSectionInfo getAvgWgtSectionInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAvgWgtSectionInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AvgWgtSectionCollection getAvgWgtSectionCollection() throws BOSException
    {
        try {
            return getController().getAvgWgtSectionCollection(getContext());
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
    public AvgWgtSectionCollection getAvgWgtSectionCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAvgWgtSectionCollection(getContext(), view);
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
    public AvgWgtSectionCollection getAvgWgtSectionCollection(String oql) throws BOSException
    {
        try {
            return getController().getAvgWgtSectionCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}