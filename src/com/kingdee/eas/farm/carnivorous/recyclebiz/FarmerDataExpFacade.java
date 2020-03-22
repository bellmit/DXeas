package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.bos.util.*;

public class FarmerDataExpFacade extends AbstractBizCtrl implements IFarmerDataExpFacade
{
    public FarmerDataExpFacade()
    {
        super();
        registerInterface(IFarmerDataExpFacade.class, this);
    }
    public FarmerDataExpFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmerDataExpFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("27FE0E2D");
    }
    private FarmerDataExpFacadeController getController() throws BOSException
    {
        return (FarmerDataExpFacadeController)getBizController();
    }
    /**
     *导出养殖户数据-User defined method
     *@param param 参数
     *@return
     */
    public String expFarmerDataToTxt(String param) throws BOSException
    {
        try {
            return getController().expFarmerDataToTxt(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}