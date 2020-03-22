package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.taihe.contract.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class ContractPrediction extends AbstractBizCtrl implements IContractPrediction
{
    public ContractPrediction()
    {
        super();
        registerInterface(IContractPrediction.class, this);
    }
    public ContractPrediction(Context ctx)
    {
        super(ctx);
        registerInterface(IContractPrediction.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("47221F5D");
    }
    private ContractPredictionController getController() throws BOSException
    {
        return (ContractPredictionController)getBizController();
    }
    /**
     *获取内容-User defined method
     *@param param 参数
     *@return
     */
    public String getData(String param) throws BOSException
    {
        try {
            return getController().getData(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]返回参数[%returndesc]-User defined method
     *@param param 需要存储的数据
     *@return
     */
    public String saveData(String param) throws BOSException
    {
        try {
            return getController().saveData(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}