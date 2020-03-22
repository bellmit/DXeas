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

public class ExcelOutput extends DataBase implements IExcelOutput
{
    public ExcelOutput()
    {
        super();
        registerInterface(IExcelOutput.class, this);
    }
    public ExcelOutput(Context ctx)
    {
        super(ctx);
        registerInterface(IExcelOutput.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7DF2FCC7");
    }
    private ExcelOutputController getController() throws BOSException
    {
        return (ExcelOutputController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ExcelOutputInfo getExcelOutputInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getExcelOutputInfo(getContext(), pk);
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
    public ExcelOutputInfo getExcelOutputInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getExcelOutputInfo(getContext(), pk, selector);
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
    public ExcelOutputInfo getExcelOutputInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getExcelOutputInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ExcelOutputCollection getExcelOutputCollection() throws BOSException
    {
        try {
            return getController().getExcelOutputCollection(getContext());
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
    public ExcelOutputCollection getExcelOutputCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getExcelOutputCollection(getContext(), view);
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
    public ExcelOutputCollection getExcelOutputCollection(String oql) throws BOSException
    {
        try {
            return getController().getExcelOutputCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}