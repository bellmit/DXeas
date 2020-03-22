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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class WSWorkFlowFacade extends AbstractBizCtrl implements IWSWorkFlowFacade
{
    public WSWorkFlowFacade()
    {
        super();
        registerInterface(IWSWorkFlowFacade.class, this);
    }
    public WSWorkFlowFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSWorkFlowFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("58F23959");
    }
    private WSWorkFlowFacadeController getController() throws BOSException
    {
        return (WSWorkFlowFacadeController)getBizController();
    }
    /**
     *getMessageList-User defined method
     *@param userNumber userNumber
     *@return
     */
    public String getMessageList(String userNumber) throws BOSException
    {
        try {
            return getController().getMessageList(getContext(), userNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *quickApprove-User defined method
     *@param assignIds assignIds
     *@param ifpass ifpass
     *@param opinion opinion
     *@param policy policy
     *@param userNumber userNumber
     *@return
     */
    public String quickApprove(String assignIds, String ifpass, String opinion, String policy, String userNumber) throws BOSException
    {
        try {
            return getController().quickApprove(getContext(), assignIds, ifpass, opinion, policy, userNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getApproveHistory-User defined method
     *@param billId billId
     *@return
     */
    public String getApproveHistory(String billId) throws BOSException
    {
        try {
            return getController().getApproveHistory(getContext(), billId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getMessageDetailList-User defined method
     *@param userNumber userNumber
     *@return
     */
    public String getMessageDetailList(String userNumber) throws BOSException
    {
        try {
            return getController().getMessageDetailList(getContext(), userNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *updateMesStatusById-User defined method
     *@param messageId messageId
     */
    public void updateMesStatusById(String messageId) throws BOSException
    {
        try {
            getController().updateMesStatusById(getContext(), messageId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据xtid获取用户信息-User defined method
     *@param xtId xtId
     *@return
     */
    public String getUserInfoByXtId(String xtId) throws BOSException
    {
        try {
            return getController().getUserInfoByXtId(getContext(), xtId);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getFNumberByPhone-User defined method
     *@param phone 手机号
     *@return
     */
    public String getFNumberByPhone(String phone) throws BOSException, EASBizException
    {
        try {
            return getController().getFNumberByPhone(getContext(), phone);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *submitApprove-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String submitApprove(String jsonStr) throws BOSException
    {
        try {
            return getController().submitApprove(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}