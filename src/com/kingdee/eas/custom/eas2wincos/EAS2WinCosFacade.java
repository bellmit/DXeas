package com.kingdee.eas.custom.eas2wincos;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.eas2wincos.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class EAS2WinCosFacade extends AbstractBizCtrl implements IEAS2WinCosFacade
{
    public EAS2WinCosFacade()
    {
        super();
        registerInterface(IEAS2WinCosFacade.class, this);
    }
    public EAS2WinCosFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IEAS2WinCosFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F173CE7D");
    }
    private EAS2WinCosFacadeController getController() throws BOSException
    {
        return (EAS2WinCosFacadeController)getBizController();
    }
    /**
     *导入到eas-User defined method
     *@param companyID companyID
     *@param jsonStr jsonStr
     *@param sourceType sourceType
     *@return
     */
    public String importBill(String companyID, String jsonStr, int sourceType) throws BOSException, EASBizException
    {
        try {
            return getController().importBill(getContext(), companyID, jsonStr, sourceType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *导出到wincos-User defined method
     *@param companyID companyID
     *@param jsonStr jsonStr
     *@param sourceType sourceType
     *@return
     */
    public String exportBill(String companyID, String jsonStr, int sourceType) throws BOSException, EASBizException
    {
        try {
            return getController().exportBill(getContext(), companyID, jsonStr, sourceType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}