package com.kingdee.eas.outinterface.base;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.outinterface.base.app.*;
import javax.activation.DataHandler;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class OutAppInterface extends AbstractBizCtrl implements IOutAppInterface
{
    public OutAppInterface()
    {
        super();
        registerInterface(IOutAppInterface.class, this);
    }
    public OutAppInterface(Context ctx)
    {
        super(ctx);
        registerInterface(IOutAppInterface.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("985F78BA");
    }
    private OutAppInterfaceController getController() throws BOSException
    {
        return (OutAppInterfaceController)getBizController();
    }
    /**
     *获取资料-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String getData(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().getData(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *uploadData-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String uploadData(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().uploadData(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getList-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String getList(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().getList(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *uploadAttachment-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String uploadAttachment(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().uploadAttachment(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getAttachment-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String getAttachment(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().getAttachment(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *deleteAttachment-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String deleteAttachment(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().deleteAttachment(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *uploadAttachment-User defined method
     *@param handler handler
     *@param jarrayStr jarrayStr
     *@return
     */
    public String uploadAttachment(DataHandler handler, String jarrayStr) throws BOSException
    {
        try {
            return getController().uploadAttachment(getContext(), handler, jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *密码检查-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String chekPwd(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().chekPwd(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getAttachmentList-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String getAttachmentList(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().getAttachmentList(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *auditData-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String auditData(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().auditData(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *unAuditData-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String unAuditData(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().unAuditData(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *deleteData-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String deleteData(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().deleteData(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getEnumInfo-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String getEnumInfo(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().getEnumInfo(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *exeFunction-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String exeFunction(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().exeFunction(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getDataByNum-User defined method
     *@param jarrayStr jarrayStr
     *@return
     */
    public String getDataByNum(String jarrayStr) throws BOSException, EASBizException
    {
        try {
            return getController().getDataByNum(getContext(), jarrayStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新数据-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public String updateData(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().updateData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}