package com.kingdee.eas.custom.test;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.test.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ExcelImport extends DataBase implements IExcelImport
{
    public ExcelImport()
    {
        super();
        registerInterface(IExcelImport.class, this);
    }
    public ExcelImport(Context ctx)
    {
        super(ctx);
        registerInterface(IExcelImport.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7343576B");
    }
    private ExcelImportController getController() throws BOSException
    {
        return (ExcelImportController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ExcelImportInfo getExcelImportInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExcelImportInfo(getContext(), pk);
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
    public ExcelImportInfo getExcelImportInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExcelImportInfo(getContext(), pk, selector);
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
    public ExcelImportInfo getExcelImportInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExcelImportInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ExcelImportCollection getExcelImportCollection() throws BOSException
    {
        try {
            return getController().getExcelImportCollection(getContext());
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
    public ExcelImportCollection getExcelImportCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExcelImportCollection(getContext(), view);
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
    public ExcelImportCollection getExcelImportCollection(String oql) throws BOSException
    {
        try {
            return getController().getExcelImportCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}