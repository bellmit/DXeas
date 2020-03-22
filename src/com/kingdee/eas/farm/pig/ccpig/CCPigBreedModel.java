package com.kingdee.eas.farm.pig.ccpig;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.farm.pig.ccpig.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCPigBreedModel extends DataBase implements ICCPigBreedModel
{
    public CCPigBreedModel()
    {
        super();
        registerInterface(ICCPigBreedModel.class, this);
    }
    public CCPigBreedModel(Context ctx)
    {
        super(ctx);
        registerInterface(ICCPigBreedModel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("ADC1AD23");
    }
    private CCPigBreedModelController getController() throws BOSException
    {
        return (CCPigBreedModelController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CCPigBreedModelInfo getCCPigBreedModelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBreedModelInfo(getContext(), pk);
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
    public CCPigBreedModelInfo getCCPigBreedModelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBreedModelInfo(getContext(), pk, selector);
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
    public CCPigBreedModelInfo getCCPigBreedModelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCCPigBreedModelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CCPigBreedModelCollection getCCPigBreedModelCollection() throws BOSException
    {
        try {
            return getController().getCCPigBreedModelCollection(getContext());
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
    public CCPigBreedModelCollection getCCPigBreedModelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCCPigBreedModelCollection(getContext(), view);
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
    public CCPigBreedModelCollection getCCPigBreedModelCollection(String oql) throws BOSException
    {
        try {
            return getController().getCCPigBreedModelCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}