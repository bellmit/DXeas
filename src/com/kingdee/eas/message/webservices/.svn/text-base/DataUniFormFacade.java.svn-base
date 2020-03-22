package com.kingdee.eas.message.webservices;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.message.webservices.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class DataUniFormFacade extends AbstractBizCtrl implements IDataUniFormFacade
{
    public DataUniFormFacade()
    {
        super();
        registerInterface(IDataUniFormFacade.class, this);
    }
    public DataUniFormFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDataUniFormFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C58CEE4F");
    }
    private DataUniFormFacadeController getController() throws BOSException
    {
        return (DataUniFormFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]jsonStr[%returndesc]-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String getDataFromJsonCondition(String jsonStr) throws BOSException
    {
        try {
            return getController().getDataFromJsonCondition(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getOrderStatusFromJsonCondition-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String getOrderStatusFromJsonCondition(String jsonStr) throws BOSException
    {
        try {
            return getController().getOrderStatusFromJsonCondition(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}