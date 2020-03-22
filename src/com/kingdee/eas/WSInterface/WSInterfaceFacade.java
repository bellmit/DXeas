package com.kingdee.eas.WSInterface;

import java.rmi.RemoteException;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.WSInterface.app.WSInterfaceFacadeController;
import com.kingdee.eas.fi.gl.WSVoucherCollection;

public class WSInterfaceFacade extends AbstractBizCtrl implements IWSInterfaceFacade
{
    public WSInterfaceFacade()
    {
        super();
        registerInterface(IWSInterfaceFacade.class, this);
    }
    public WSInterfaceFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSInterfaceFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3E2587C1");
    }
    private WSInterfaceFacadeController getController() throws BOSException
    {
        return (WSInterfaceFacadeController)getBizController();
    }
    /**
     *获取基础资料-User defined method
     *@param queryStr queryStr
     *@return
     */
    public String getBaseData(String queryStr) throws BOSException
    {
        try {
            return getController().getBaseData(getContext(), queryStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *importVoucher-User defined method
     *@param col col
     *@param isVerify isVerify
     *@param isCashflow isCashflow
     *@return
     */
    public String importVoucher(WSVoucherCollection col, int isVerify, int isCashflow) throws BOSException
    {
        try {
            return getController().importVoucher(getContext(), col, isVerify, isCashflow);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *导入单据-User defined method
     *@param BosType BosType
     *@param BillJSON BillJSON
     *@param BillStatus BillStatus
     *@return
     */
    public String importBill(String BosType, String BillJSON, int BillStatus) throws BOSException
    {
        try {
            return getController().importBill(getContext(), BosType, BillJSON, BillStatus);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getVoucher-User defined method
     *@param orgNumber orgNumber
     *@param year year
     *@param period period
     *@param fromRow fromRow
     *@param toRow toRow
     *@return
     */
    public String getVoucher(String orgNumber, String year, String period, int fromRow, int toRow) throws BOSException
    {
        try {
            return getController().getVoucher(getContext(), orgNumber, year, period, fromRow, toRow);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *findVoucher-User defined method
     *@param orgNumber orgNumber
     *@param year year
     *@param period period
     *@return
     */
    public String findVoucher(String orgNumber, int year, int period) throws BOSException
    {
        try {
            return getController().findVoucher(getContext(), orgNumber, year, period);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ImpBaseData-User defined method
     *@param billType billType
     *@param JSON JSON
     *@param billStatus billStatus
     *@return
     */
    public String ImpBaseData(String billType, String JSON, int billStatus) throws BOSException
    {
        try {
            return getController().ImpBaseData(getContext(), billType, JSON, billStatus);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBaseDataByOrgNum-User defined method
     *@param queryStr queryStr
     *@return
     */
    public String getBaseDataByOrgNum(String queryStr) throws BOSException
    {
        try {
            return getController().getBaseDataByOrgNum(getContext(), queryStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getVoucher-User defined method
     *@param OrgUnitID OrgUnitID
     *@param year year
     *@param period period
     *@param numbers numbers
     *@return
     */
    public String getVoucher(String OrgUnitID, String year, String period, String numbers) throws BOSException
    {
        try {
            return getController().getVoucher(getContext(), OrgUnitID, year, period, numbers);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}