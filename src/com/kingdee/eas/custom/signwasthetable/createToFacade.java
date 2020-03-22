package com.kingdee.eas.custom.signwasthetable;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.fi.ap.PayRequestBillInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.bos.util.*;

public class createToFacade extends AbstractBizCtrl implements IcreateToFacade
{
    public createToFacade()
    {
        super();
        registerInterface(IcreateToFacade.class, this);
    }
    public createToFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IcreateToFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A42E417B");
    }
    private createToFacadeController getController() throws BOSException
    {
        return (createToFacadeController)getBizController();
    }
    /**
     *createTo-User defined method
     *@param model 推式生成
     *@return
     */
    public PayRequestBillInfo createTo(ContractInfo model) throws BOSException
    {
        try {
            return getController().createTo(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
	public PayRequestBillInfo createTo() {
		// TODO Auto-generated method stub
		return null;
	}
}