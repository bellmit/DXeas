package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.workflow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSSignedBillFacade extends AbstractBizCtrl implements IWSSignedBillFacade
{
    public WSSignedBillFacade()
    {
        super();
        registerInterface(IWSSignedBillFacade.class, this);
    }
    public WSSignedBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSSignedBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("15696BBD");
    }
    private WSSignedBillFacadeController getController() throws BOSException
    {
        return (WSSignedBillFacadeController)getBizController();
    }
    /**
     *getBillType-User defined method
     *@param userNumber userNumber
     *@return
     */
    public String getBillType(String userNumber) throws BOSException
    {
        try {
            return getController().getBillType(getContext(), userNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *importBillInfo-User defined method
     *@param jsonData jsonData
     *@return
     */
    public String importBillInfo(String jsonData) throws BOSException
    {
        try {
            return getController().importBillInfo(getContext(), jsonData);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBillList-User defined method
     *@param userNumber userNumber
     *@param fnumber fnumber
     *@param dateS dateS
     *@param dateE dateE
     *@return
     */
    public String getBillList(String userNumber, String fnumber, String dateS, String dateE) throws BOSException
    {
        try {
            return getController().getBillList(getContext(), userNumber, fnumber, dateS, dateE);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBillInfoById-User defined method
     *@param fid fid
     *@return
     */
    public String getBillInfoById(String fid) throws BOSException
    {
        try {
            return getController().getBillInfoById(getContext(), fid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getOrgInfoByUser-User defined method
     *@param userNumber userNumber
     *@return
     */
    public String getOrgInfoByUser(String userNumber) throws BOSException
    {
        try {
            return getController().getOrgInfoByUser(getContext(), userNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getOrgListByUser-User defined method
     *@param userNumber userNumber
     *@return
     */
    public String getOrgListByUser(String userNumber) throws BOSException
    {
        try {
            return getController().getOrgListByUser(getContext(), userNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getDeptListByCompany-User defined method
     *@param company company
     *@return
     */
    public String getDeptListByCompany(String company) throws BOSException
    {
        try {
            return getController().getDeptListByCompany(getContext(), company);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *deleteSignBillByFid-User defined method
     *@param fid fid
     *@return
     */
    public String deleteSignBillByFid(String fid) throws BOSException
    {
        try {
            return getController().deleteSignBillByFid(getContext(), fid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getAddressesByName-User defined method
     *@param param param
     *@return
     */
    public String getAddressesByName(String param) throws BOSException
    {
        try {
            return getController().getAddressesByName(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}