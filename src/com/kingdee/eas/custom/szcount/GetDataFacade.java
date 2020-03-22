package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.bos.util.*;

public class GetDataFacade extends AbstractBizCtrl implements IGetDataFacade
{
    public GetDataFacade()
    {
        super();
        registerInterface(IGetDataFacade.class, this);
    }
    public GetDataFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IGetDataFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A1DEED4F");
    }
    private GetDataFacadeController getController() throws BOSException
    {
        return (GetDataFacadeController)getBizController();
    }
    /**
     *获取数据-User defined method
     *@param Params 需要的数据
     *@return
     */
    public String GetData(String Params) throws BOSException
    {
        try {
            return getController().GetData(getContext(), Params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得仓库-User defined method
     *@param PersonID 获取人员ID
     *@return
     */
    public String GetWarehouse(String PersonID) throws BOSException
    {
        try {
            return getController().GetWarehouse(getContext(), PersonID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *保存数据-User defined method
     *@param Params 获取保存数据
     *@return
     */
    public String SaveData(String Params) throws BOSException
    {
        try {
            return getController().SaveData(getContext(), Params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取用户计数权限-User defined method
     *@param Params 用户名称
     *@return
     */
    public String GetPersonPost(String Params) throws BOSException
    {
        try {
            return getController().GetPersonPost(getContext(), Params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取日统计信息-User defined method
     *@param params 日期_计数岗位_用户名
     *@return
     */
    public String GetStatisticsData(String params) throws BOSException
    {
        try {
            return getController().GetStatisticsData(getContext(), params);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}