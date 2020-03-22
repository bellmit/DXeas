package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.base.permission.UserInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class payReqBillFacade extends AbstractBizCtrl implements IpayReqBillFacade
{
    public payReqBillFacade()
    {
        super();
        registerInterface(IpayReqBillFacade.class, this);
    }
    public payReqBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IpayReqBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DA7FB9E1");
    }
    private payReqBillFacadeController getController() throws BOSException
    {
        return (payReqBillFacadeController)getBizController();
    }
    /**
     *修改付款申请单的关闭状态-User defined method
     *@param payRequestBillID 付款申请单ID
     *@param closeStatus 关闭状态
     *@param closeUser 关闭人
     *@param closeDate 关闭时间
     *@return
     */
    public Date setPayReqBillCloseStatus(String payRequestBillID, boolean closeStatus, UserInfo closeUser, Date closeDate) throws BOSException, EASBizException
    {
        try {
            return getController().setPayReqBillCloseStatus(getContext(), payRequestBillID, closeStatus, closeUser, closeDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}