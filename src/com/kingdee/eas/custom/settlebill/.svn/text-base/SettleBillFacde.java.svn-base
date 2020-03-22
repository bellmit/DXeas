package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.eas.custom.settlebill.app.*;
import java.lang.String;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class SettleBillFacde extends AbstractBizCtrl implements ISettleBillFacde
{
    public SettleBillFacde()
    {
        super();
        registerInterface(ISettleBillFacde.class, this);
    }
    public SettleBillFacde(Context ctx)
    {
        super(ctx);
        registerInterface(ISettleBillFacde.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D7814A6");
    }
    private SettleBillFacdeController getController() throws BOSException
    {
        return (SettleBillFacdeController)getBizController();
    }
    /**
     *自定义结算单导入-User defined method
     *@param xml xml
     *@return
     */
    public String[] importData(String xml) throws BOSException
    {
        try {
            return getController().importData(getContext(), xml);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得苗料药的成本金额-User defined method
     *@param company 公司
     *@param lot 批次
     *@param adminOrgUnitInfo 行政组织
     *@return
     */
    public Map getCostAmtOfMLY(CompanyOrgUnitInfo company, String lot, AdminOrgUnitInfo adminOrgUnitInfo) throws BOSException
    {
        try {
            return getController().getCostAmtOfMLY(getContext(), company, lot, adminOrgUnitInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新凭证标志-User defined method
     *@param sqlStr sql字符串
     *@return
     */
    public boolean updateVoucherFlag(String sqlStr) throws BOSException, EASBizException
    {
        try {
            return getController().updateVoucherFlag(getContext(), sqlStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}