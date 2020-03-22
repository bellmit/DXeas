package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.tocloud.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class DeleteCloudBill extends AbstractBizCtrl implements IDeleteCloudBill
{
    public DeleteCloudBill()
    {
        super();
        registerInterface(IDeleteCloudBill.class, this);
    }
    public DeleteCloudBill(Context ctx)
    {
        super(ctx);
        registerInterface(IDeleteCloudBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("45766238");
    }
    private DeleteCloudBillController getController() throws BOSException
    {
        return (DeleteCloudBillController)getBizController();
    }
    /**
     *ɾ��Cloud����-User defined method
     *@param param ����ֵ
     *@return
     */
    public String deleteCloudBill(String param) throws BOSException, EASBizException
    {
        try {
            return getController().deleteCloudBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡCloud�ܳɱ�-User defined method
     *@param param json�ַ���
     *@return
     */
    public String getCostValue(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getCostValue(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *����cloud����-User defined method
     *@param param �ַ���
     *@return
     */
    public String saveBill(String param) throws BOSException
    {
        try {
            return getController().saveBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ύ����-User defined method
     *@param param json�ַ���
     *@return
     */
    public String submitBill(String param) throws BOSException
    {
        try {
            return getController().submitBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��˵���-User defined method
     *@param param json�ַ���
     *@return
     */
    public String auditBill(String param) throws BOSException
    {
        try {
            return getController().auditBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}