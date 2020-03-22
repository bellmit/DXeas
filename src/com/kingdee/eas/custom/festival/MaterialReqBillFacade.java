package com.kingdee.eas.custom.festival;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.festival.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class MaterialReqBillFacade extends AbstractBizCtrl implements IMaterialReqBillFacade
{
    public MaterialReqBillFacade()
    {
        super();
        registerInterface(IMaterialReqBillFacade.class, this);
    }
    public MaterialReqBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IMaterialReqBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5B3CC9AD");
    }
    private MaterialReqBillFacadeController getController() throws BOSException
    {
        return (MaterialReqBillFacadeController)getBizController();
    }
    /**
     *导入数据接口-User defined method
     *@param xmlData xmlData
     *@return
     */
    public String[] importData(String xmlData) throws BOSException
    {
        try {
            return getController().importData(getContext(), xmlData);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}