package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.erp2tax.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class ERP2TaxFacade extends AbstractBizCtrl implements IERP2TaxFacade
{
    public ERP2TaxFacade()
    {
        super();
        registerInterface(IERP2TaxFacade.class, this);
    }
    public ERP2TaxFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IERP2TaxFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9BA5303F");
    }
    private ERP2TaxFacadeController getController() throws BOSException
    {
        return (ERP2TaxFacadeController)getBizController();
    }
    /**
     *execute-User defined method
     *@param sqlStr sqlStr
     */
    public void execute(String sqlStr) throws BOSException
    {
        try {
            getController().execute(getContext(), sqlStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行导出发票-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String exeExport2Tax(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().exeExport2Tax(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *同步结果-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String exeSynResult(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().exeSynResult(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ExportWriteBack2Tax-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String ExportWriteBack2Tax(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().ExportWriteBack2Tax(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}