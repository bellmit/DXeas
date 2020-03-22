package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.tocloud.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASAppException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class DataSynPlateformFacade extends AbstractBizCtrl implements IDataSynPlateformFacade
{
    public DataSynPlateformFacade()
    {
        super();
        registerInterface(IDataSynPlateformFacade.class, this);
    }
    public DataSynPlateformFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDataSynPlateformFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("70F321CF");
    }
    private DataSynPlateformFacadeController getController() throws BOSException
    {
        return (DataSynPlateformFacadeController)getBizController();
    }
    /**
     *login-User defined method
     *@return
     */
    public String login() throws BOSException
    {
        try {
            return getController().login(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取列表信息-User defined method
     *@param param 参数
     *@return
     */
    public String getBillList(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getBillList(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取单据头信息-User defined method
     *@param param 参数
     *@return
     */
    public String getBillHeader(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getBillHeader(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *synData-User defined method
     *@param jsonParam json字符串
     *@return
     */
    public String synData(String jsonParam) throws BOSException, EASAppException
    {
        try {
            return getController().synData(getContext(), jsonParam);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}