package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.bos.util.*;

public class createToForContract extends AbstractBizCtrl implements IcreateToForContract
{
    public createToForContract()
    {
        super();
        registerInterface(IcreateToForContract.class, this);
    }
    public createToForContract(Context ctx)
    {
        super(ctx);
        registerInterface(IcreateToForContract.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C0F1FCBA");
    }
    private createToForContractController getController() throws BOSException
    {
        return (createToForContractController)getBizController();
    }
    /**
     *createTo-User defined method
     *@param ContractInfo ºÏÍ¬
     *@return
     */
    public IObjectValue createTo(ContractInfo ContractInfo) throws BOSException
    {
        try {
            return getController().createTo(getContext(), ContractInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}