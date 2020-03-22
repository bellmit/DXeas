package com.kingdee.eas.custom.commonld;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.custom.commonld.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class WebServiceFacade extends AbstractBizCtrl implements IWebServiceFacade
{
    public WebServiceFacade()
    {
        super();
        registerInterface(IWebServiceFacade.class, this);
    }
    public WebServiceFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IWebServiceFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DF1B6C7B");
    }
    private WebServiceFacadeController getController() throws BOSException
    {
        return (WebServiceFacadeController)getBizController();
    }
    /**
     *创建一个新的单据-User defined method
     *@param param 参数
     *@return
     */
    public String createNewBill(String param) throws BOSException, EASBizException
    {
        try {
            return getController().createNewBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取列表界面-User defined method
     *@param param 参数
     *@return
     */
    public String getBillList(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getBillList(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取单据详细信息-User defined method
     *@param param 参数
     *@return
     */
    public String getBillDetailInfo(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getBillDetailInfo(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除单据-User defined method
     *@param param 参数
     *@return
     */
    public String deleteBill(String param) throws BOSException, EASBizException
    {
        try {
            return getController().deleteBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取报表数据-User defined method
     *@param param param
     *@return
     */
    public String getRptData(String param) throws BOSException, EASBizException
    {
        try {
            return getController().getRptData(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *上传单据-User defined method
     *@param param 参数
     *@return
     */
    public String uploadBillWithArray(String param) throws BOSException
    {
        try {
            return getController().uploadBillWithArray(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *其他方法-User defined method
     *@param param 参数
     *@return
     */
    public String otherMethord(String param) throws BOSException
    {
        try {
            return getController().otherMethord(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}