package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.taihe.workshopmanager.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class LoadingBillFacade extends AbstractBizCtrl implements ILoadingBillFacade
{
    public LoadingBillFacade()
    {
        super();
        registerInterface(ILoadingBillFacade.class, this);
    }
    public LoadingBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ILoadingBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AD3FBBFB");
    }
    private LoadingBillFacadeController getController() throws BOSException
    {
        return (LoadingBillFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]String[%returndesc]-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String downloadData(String jsonStr) throws BOSException
    {
        try {
            return getController().downloadData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *uploadData-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String uploadData(String jsonStr) throws BOSException
    {
        try {
            return getController().uploadData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *queryData-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String queryData(String jsonStr) throws BOSException
    {
        try {
            return getController().queryData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成销售出库单-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String create2SaleIssure(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().create2SaleIssure(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *装车完毕-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String finishLoading(String jsonStr) throws BOSException
    {
        try {
            return getController().finishLoading(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除装货单-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String deleteData(String jsonStr) throws BOSException
    {
        try {
            return getController().deleteData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}