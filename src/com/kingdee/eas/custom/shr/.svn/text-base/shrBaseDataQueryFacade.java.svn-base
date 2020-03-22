package com.kingdee.eas.custom.shr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.shr.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class shrBaseDataQueryFacade extends AbstractBizCtrl implements IshrBaseDataQueryFacade
{
    public shrBaseDataQueryFacade()
    {
        super();
        registerInterface(IshrBaseDataQueryFacade.class, this);
    }
    public shrBaseDataQueryFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IshrBaseDataQueryFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("31F946A0");
    }
    private shrBaseDataQueryFacadeController getController() throws BOSException
    {
        return (shrBaseDataQueryFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]返回的是车次或者是站点的基础资料（名称）[%returndesc]-User defined method
     *@param queryStr 查询的字符串
     *@return
     */
    public ArrayList queryForBusList(String queryStr) throws BOSException
    {
        try {
            return getController().queryForBusList(getContext(), queryStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查询所有的站点-User defined method
     *@param sqlStopList 查询站点信息的sql
     *@return
     */
    public ArrayList queryForStopList(String sqlStopList) throws BOSException
    {
        try {
            return getController().queryForStopList(getContext(), sqlStopList);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]执行update，不需要返回值[%returndesc]-User defined method
     *@param excuteStr    
     */
    public void excuteBusAndStop(String excuteStr) throws BOSException
    {
        try {
            getController().excuteBusAndStop(getContext(), excuteStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查询员工的信息-User defined method
     *@param sqlPerson 查询符合条件的人员
     *@return
     */
    public ArrayList queryForEmpInfo(String sqlPerson) throws BOSException
    {
        try {
            return getController().queryForEmpInfo(getContext(), sqlPerson);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查询通勤信息不全的员工-User defined method
     *@param updateDate 车次更改日期
     *@return
     */
    public String queryForOtherPerson(String updateDate) throws BOSException
    {
        try {
            return getController().queryForOtherPerson(getContext(), updateDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}