package com.kingdee.eas.outinterface.base;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.outinterface.base.utils.IDynamicDeal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.outinterface.base.app.*;
import com.kingdee.eas.common.EASBizException;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.util.*;

public class OutInterfaceDynamicBillFacade extends AbstractBizCtrl implements IOutInterfaceDynamicBillFacade
{
    public OutInterfaceDynamicBillFacade()
    {
        super();
        registerInterface(IOutInterfaceDynamicBillFacade.class, this);
    }
    public OutInterfaceDynamicBillFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IOutInterfaceDynamicBillFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EA163209");
    }
    private OutInterfaceDynamicBillFacadeController getController() throws BOSException
    {
        return (OutInterfaceDynamicBillFacadeController)getBizController();
    }
    /**
     *getDataByID-User defined method
     *@param jsonStr jsonStr
     *@param ideal ideal
     *@return
     */
    public JSONObject getDataByID(String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException
    {
        try {
            return getController().getDataByID(getContext(), jsonStr, ideal);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *uploadDataByBosType-User defined method
     *@param bosType bosType
     *@param jsonStr jsonStr
     *@param iupload iupload
     *@return
     */
    public JSONObject uploadDataByBosType(String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException
    {
        try {
            return getController().uploadDataByBosType(getContext(), bosType, jsonStr, iupload);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getBillList-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject getBillList(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().getBillList(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取枚举信息-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject getEumInfo(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().getEumInfo(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行功能-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject exeFunciton(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().exeFunciton(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *uploadData-User defined method
     *@param bosType bosType
     *@param jsonStr jsonStr
     *@param iupload iupload
     *@return
     */
    public JSONObject uploadData(String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException
    {
        try {
            return getController().uploadData(getContext(), bosType, jsonStr, iupload);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *deleteData-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject deleteData(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().deleteData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *上传附件-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject uploadAttachment(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().uploadAttachment(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *下载附件List-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject getAttachmentList(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().getAttachmentList(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取附件详情-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject getAttachmentData(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().getAttachmentData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除附件-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject deleteAttachment(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().deleteAttachment(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取报表数据-User defined method
     *@param jsonStr jsonStr
     *@return
     */
    public JSONObject getRptData(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().getRptData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getDataByNumber-User defined method
     *@param jsonStr jsonStr
     *@param ideal ideal
     *@return
     */
    public JSONObject getDataByNumber(String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException
    {
        try {
            return getController().getDataByNumber(getContext(), jsonStr, ideal);
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
    public JSONObject updateData(String jsonStr) throws BOSException, EASBizException
    {
        try {
            return getController().updateData(getContext(), jsonStr);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}