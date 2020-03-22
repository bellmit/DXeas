package com.kingdee.eas.custom.echickeninterface;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.echickeninterface.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class echickeninterfaceFacade extends AbstractBizCtrl implements IechickeninterfaceFacade
{
    public echickeninterfaceFacade()
    {
        super();
        registerInterface(IechickeninterfaceFacade.class, this);
    }
    public echickeninterfaceFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IechickeninterfaceFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6A232ED9");
    }
    private echickeninterfaceFacadeController getController() throws BOSException
    {
        return (echickeninterfaceFacadeController)getBizController();
    }
    /**
     *导入单据-User defined method
     *@param BosType BosType
     *@param BillJson BillJson
     *@param BillStatus BillStatus
     *@return
     */
    public String importBill(String BosType, String BillJson, int BillStatus) throws BOSException
    {
        try {
            return getController().importBill(getContext(), BosType, BillJson, BillStatus);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBaseData-User defined method
     *@param queryStr queryStr
     *@return
     */
    public String getBaseData(String queryStr) throws BOSException
    {
        try {
            return getController().getBaseData(getContext(), queryStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}