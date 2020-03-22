package com.kingdee.eas.custom.mobileBill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.mobileBill.*;
import com.kingdee.bos.util.*;

public class MobileBillFacade extends AbstractBizCtrl implements IMobileBillFacade
{
    public MobileBillFacade()
    {
        super();
        registerInterface(IMobileBillFacade.class, this);
    }
    public MobileBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IMobileBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C4483270");
    }
    private MobileBillFacadeController getController() throws BOSException
    {
        return (MobileBillFacadeController)getBizController();
    }
    /**
     *查询销售组织-User defined method
     *@param param "number":"人员编码"
     *@return
     */
    public String selectSaleOrg(String param) throws BOSException
    {
        try {
            return getController().selectSaleOrg(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查询销售订单详细信息-User defined method
     *@param param 参数：销售订单ID{BR}{"billID":"订单ID"}
     *@return
     */
    public String saleOrderDetial(String param) throws BOSException
    {
        try {
            return getController().saleOrderDetial(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *销售订单历史-User defined method
     *@param param salePersonID：销售员ID{BR}saleOrgID：销售组织{BR}CustomerID：客户ID{BR}pageSize：每页显示记录数{BR}startPage:起始页
     *@return
     */
    public String saleOrderHistory(String param) throws BOSException, EASBizException
    {
        try {
            return getController().saleOrderHistory(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据用户查询客户-User defined method
     *@param param 人员ID{"personID":"销售员ID"}
     *@return
     */
    public String queryCustomerByUser(String param) throws BOSException, EASBizException
    {
        try {
            return getController().queryCustomerByUser(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据客户查询可销售物料-User defined method
     *@param param 客户ID{BR}{"id":"客户ID"}
     *@return
     */
    public String queryMaterialByCustomer(String param) throws BOSException, EASBizException
    {
        try {
            return getController().queryMaterialByCustomer(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *新增销售订单-User defined method
     *@param orderInfo 订单信息
     *@return
     */
    public String addNewSaleOrder(String orderInfo) throws BOSException, EASBizException
    {
        try {
            return getController().addNewSaleOrder(getContext(), orderInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *修改销售订单-User defined method
     *@param alterInfo 修改信息
     *@return
     */
    public String alterOrder(String alterInfo) throws BOSException, EASBizException
    {
        try {
            return getController().alterOrder(getContext(), alterInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查询业务类型-User defined method
     *@return
     */
    public String queryBizType() throws BOSException, EASBizException
    {
        try {
            return getController().queryBizType(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}