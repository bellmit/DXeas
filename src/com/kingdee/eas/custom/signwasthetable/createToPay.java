package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.bot.BOTMappingCollection;
import com.kingdee.bos.metadata.bot.BOTMappingInfo;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class createToPay extends AbstractBizCtrl implements IcreateToPay
{
    public createToPay()
    {
        super();
        registerInterface(IcreateToPay.class, this);
    }
    public createToPay(Context ctx)
    {
        super(ctx);
        registerInterface(IcreateToPay.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C686B367");
    }
    private createToPayController getController() throws BOSException
    {
        return (createToPayController)getBizController();
    }
    /**
     *合同签呈生成付款申请-User defined method
     *@param model 合同签呈
     *@return
     */
    public PayRequestBillInfo createPayReq(ContractInfo model) throws BOSException
    {
        try {
            return getController().createPayReq(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *行政签呈生成付款申请-User defined method
     *@param model 签呈表info
     *@param entryList 分录号的list
     *@param botMappingInfo 转换规则名称
     *@return
     */
    public PayRequestBillInfo toPayReqFromSignTable(SignWasTheTableInfo model, ArrayList entryList, BOTMappingInfo botMappingInfo) throws BOSException, EASBizException
    {
        try {
            return getController().toPayReqFromSignTable(getContext(), model, entryList, botMappingInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得可用的botp转换规则-User defined method
     *@param model 单据info
     *@return
     */
    public BOTMappingCollection getCanUsedBotMapping(SignWasTheTableInfo model) throws BOSException, EASBizException
    {
        try {
            return getController().getCanUsedBotMapping(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}