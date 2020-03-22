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

public class WSBizAccountBillFacade extends AbstractBizCtrl implements IWSBizAccountBillFacade
{
    public WSBizAccountBillFacade()
    {
        super();
        registerInterface(IWSBizAccountBillFacade.class, this);
    }
    public WSBizAccountBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSBizAccountBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3497D0BB");
    }
    private WSBizAccountBillFacadeController getController() throws BOSException
    {
        return (WSBizAccountBillFacadeController)getBizController();
    }
    /**
     *导入费用报销单-User defined method
     *@param dataXml dataXml
     *@return
     */
    public String importBizAccountBill(String dataXml) throws BOSException
    {
        try {
            return getController().importBizAccountBill(getContext(), dataXml);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据用户获取组织部门职位信息-User defined method
     *@param user user
     *@return
     */
    public String getOrgInfoByUser(String user) throws BOSException
    {
        try {
            return getController().getOrgInfoByUser(getContext(), user);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据用户获取组织列表-User defined method
     *@param userId userId
     *@return
     */
    public String getOrgListByUser(String userId) throws BOSException
    {
        try {
            return getController().getOrgListByUser(getContext(), userId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据组织获取部门列表-User defined method
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
     *getBizType-User defined method
     *@param userId userId
     *@return
     */
    public String getBizType(String userId) throws BOSException
    {
        try {
            return getController().getBizType(getContext(), userId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getExpTypeByBizType-User defined method
     *@param bizType bizType
     *@param userNumber userNumber
     *@return
     */
    public String getExpTypeByBizType(String bizType, String userNumber) throws BOSException
    {
        try {
            return getController().getExpTypeByBizType(getContext(), bizType, userNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBizAccountBillByAssignId-User defined method
     *@param assignId assignId
     *@return
     */
    public String getBizAccountBillByAssignId(String assignId) throws BOSException
    {
        try {
            return getController().getBizAccountBillByAssignId(getContext(), assignId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBizAccountBillList-User defined method
     *@param dataJson dataJson
     *@return
     */
    public String getBizAccountBillList(String dataJson) throws BOSException
    {
        try {
            return getController().getBizAccountBillList(getContext(), dataJson);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}