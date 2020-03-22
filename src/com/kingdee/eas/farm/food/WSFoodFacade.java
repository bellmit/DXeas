package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSFoodFacade extends AbstractBizCtrl implements IWSFoodFacade
{
    public WSFoodFacade()
    {
        super();
        registerInterface(IWSFoodFacade.class, this);
    }
    public WSFoodFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSFoodFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DD61C81E");
    }
    private WSFoodFacadeController getController() throws BOSException
    {
        return (WSFoodFacadeController)getBizController();
    }
    /**
     *上传单据-User defined method
     *@param jsonString jsonString
     *@return
     */
    public String uploadBill(String jsonString) throws BOSException
    {
        try {
            return getController().uploadBill(getContext(), jsonString);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取基础资料信息-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String getBaseData(String jsonStr) throws BOSException
    {
        try {
            return getController().getBaseData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBillList-User defined method
     *@param jsonString jsonString
     *@return
     */
    public String getBillList(String jsonString) throws BOSException
    {
        try {
            return getController().getBillList(getContext(), jsonString);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBillInfo-User defined method
     *@param jsonString jsonString
     *@return
     */
    public String getBillInfo(String jsonString) throws BOSException
    {
        try {
            return getController().getBillInfo(getContext(), jsonString);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}