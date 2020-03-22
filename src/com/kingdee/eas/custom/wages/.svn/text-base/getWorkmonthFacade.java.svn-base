package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class getWorkmonthFacade extends AbstractBizCtrl implements IgetWorkmonthFacade
{
    public getWorkmonthFacade()
    {
        super();
        registerInterface(IgetWorkmonthFacade.class, this);
    }
    public getWorkmonthFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IgetWorkmonthFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("545B333B");
    }
    private getWorkmonthFacadeController getController() throws BOSException
    {
        return (getWorkmonthFacadeController)getBizController();
    }
    /**
     *计算工作月份-User defined method
     *@param date 时间
     *@return
     */
    public int getworkmonth(String date) throws BOSException
    {
        try {
            return getController().getworkmonth(getContext(), date);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取代扣个税-User defined method
     *@param yssd 应税所得
     *@param companyID 公司ID
     *@return
     */
    public String getdkgs(String yssd, String companyID) throws BOSException
    {
        try {
            return getController().getdkgs(getContext(), yssd, companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取两日期相差的天数-User defined method
     *@param begindate 被减日期
     *@param enddate 减日期
     *@return
     */
    public String getDaySub(String begindate, String enddate) throws BOSException
    {
        try {
            return getController().getDaySub(getContext(), begindate, enddate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}