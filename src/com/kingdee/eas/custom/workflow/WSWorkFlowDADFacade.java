package com.kingdee.eas.custom.workflow;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.workflow.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class WSWorkFlowDADFacade extends AbstractBizCtrl implements IWSWorkFlowDADFacade
{
    public WSWorkFlowDADFacade()
    {
        super();
        registerInterface(IWSWorkFlowDADFacade.class, this);
    }
    public WSWorkFlowDADFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWSWorkFlowDADFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("091365E2");
    }
    private WSWorkFlowDADFacadeController getController() throws BOSException
    {
        return (WSWorkFlowDADFacadeController)getBizController();
    }
    /**
     *����-User defined method
     *@param param ����
     *@return
     */
    public String passAssign(String param) throws BOSException
    {
        try {
            return getController().passAssign(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ѯ������Ϣ-User defined method
     *@param param ����
     *@return
     */
    public String executeQueryForPassAssign(String param) throws BOSException
    {
        try {
            return getController().executeQueryForPassAssign(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getAttachmentAsBytes-User defined method
     *@param param ����
     *@return
     */
    public String getAttachmentAsBytes(String param) throws BOSException
    {
        try {
            return getController().getAttachmentAsBytes(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ϴ�����-User defined method
     *@param param ����
     *@return
     */
    public String addAttachment(String param) throws BOSException
    {
        try {
            return getController().addAttachment(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ɾ������-User defined method
     *@param param ����
     *@return
     */
    public String deleteAttachment(String param) throws BOSException
    {
        try {
            return getController().deleteAttachment(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *�ύ����-User defined method
     *@param param ����
     *@return
     */
    public String submitApprove(String param) throws BOSException
    {
        try {
            return getController().submitApprove(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��þ���ֵ-User defined method
     *@param param ����
     *@return
     */
    public String getSelectPolicy(String param) throws BOSException
    {
        try {
            return getController().getSelectPolicy(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *��ȡ����ժҪ-User defined method
     *@param param ����
     *@return
     */
    public String getBillDigest(String param) throws BOSException
    {
        try {
            return getController().getBillDigest(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getAttachmentBillByBillID-User defined method
     *@param parma parma
     *@return
     */
    public String getAttachmentBillByBillID(String parma) throws BOSException
    {
        try {
            return getController().getAttachmentBillByBillID(getContext(), parma);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}