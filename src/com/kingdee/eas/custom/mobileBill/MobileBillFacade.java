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
     *��ѯ������֯-User defined method
     *@param param "number":"��Ա����"
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
     *��ѯ���۶�����ϸ��Ϣ-User defined method
     *@param param ���������۶���ID{BR}{"billID":"����ID"}
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
     *���۶�����ʷ-User defined method
     *@param param salePersonID������ԱID{BR}saleOrgID��������֯{BR}CustomerID���ͻ�ID{BR}pageSize��ÿҳ��ʾ��¼��{BR}startPage:��ʼҳ
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
     *�����û���ѯ�ͻ�-User defined method
     *@param param ��ԱID{"personID":"����ԱID"}
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
     *���ݿͻ���ѯ����������-User defined method
     *@param param �ͻ�ID{BR}{"id":"�ͻ�ID"}
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
     *�������۶���-User defined method
     *@param orderInfo ������Ϣ
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
     *�޸����۶���-User defined method
     *@param alterInfo �޸���Ϣ
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
     *��ѯҵ������-User defined method
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