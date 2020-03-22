package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StateOfAcaountImport extends CoreBillBase implements IStateOfAcaountImport
{
    public StateOfAcaountImport()
    {
        super();
        registerInterface(IStateOfAcaountImport.class, this);
    }
    public StateOfAcaountImport(Context ctx)
    {
        super(ctx);
        registerInterface(IStateOfAcaountImport.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EEDDBC2D");
    }
    private StateOfAcaountImportController getController() throws BOSException
    {
        return (StateOfAcaountImportController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StateOfAcaountImportCollection getStateOfAcaountImportCollection() throws BOSException
    {
        try {
            return getController().getStateOfAcaountImportCollection(getContext());
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
    public StateOfAcaountImportCollection getStateOfAcaountImportCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStateOfAcaountImportCollection(getContext(), view);
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
    public StateOfAcaountImportCollection getStateOfAcaountImportCollection(String oql) throws BOSException
    {
        try {
            return getController().getStateOfAcaountImportCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StateOfAcaountImportInfo getStateOfAcaountImportInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStateOfAcaountImportInfo(getContext(), pk);
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
    public StateOfAcaountImportInfo getStateOfAcaountImportInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStateOfAcaountImportInfo(getContext(), pk, selector);
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
    public StateOfAcaountImportInfo getStateOfAcaountImportInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStateOfAcaountImportInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}