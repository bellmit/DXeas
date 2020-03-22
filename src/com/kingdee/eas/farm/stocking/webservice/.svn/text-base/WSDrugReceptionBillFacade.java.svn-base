package com.kingdee.eas.farm.stocking.webservice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.webservice.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.commonld.IWebServiceFacade;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.commonld.WebServiceFacade;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSDrugReceptionBillFacade extends WebServiceFacade implements IWSDrugReceptionBillFacade
{
    public WSDrugReceptionBillFacade()
    {
        super();
        registerInterface(IWSDrugReceptionBillFacade.class, this);
    }
    public WSDrugReceptionBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSDrugReceptionBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2D82D696");
    }
    private WSDrugReceptionBillFacadeController getController() throws BOSException
    {
        return (WSDrugReceptionBillFacadeController)getBizController();
    }
    /**
     *获取药品-User defined method
     *@param param 参数
     *@return
     */
    public String getDrugMaterial(String param) throws BOSException
    {
        try {
            return getController().getDrugMaterial(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取药品价格-User defined method
     *@param parma 参数
     *@return
     */
    public String getDrugMaterialPrice(String parma) throws BOSException
    {
        try {
            return getController().getDrugMaterialPrice(getContext(), parma);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}