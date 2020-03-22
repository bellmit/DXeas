package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salaryvoucher.app.*;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class salaryVoucherFacade extends AbstractBizCtrl implements IsalaryVoucherFacade
{
    public salaryVoucherFacade()
    {
        super();
        registerInterface(IsalaryVoucherFacade.class, this);
    }
    public salaryVoucherFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IsalaryVoucherFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8582D4AF");
    }
    private salaryVoucherFacadeController getController() throws BOSException
    {
        return (salaryVoucherFacadeController)getBizController();
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]返回生成凭证的情况（是否成功）[%returndesc]-User defined method
     *@param periodInfo 会计期间
     *@param salaryVoucher 薪酬凭证对应关系
     *@param conInfo 数据库连接信息
     *@return
     */
    public String[] createSalaryVoucher(PeriodInfo periodInfo, SalaryVoucherInfo salaryVoucher, String[] conInfo) throws BOSException
    {
        try {
            return getController().createSalaryVoucher(getContext(), periodInfo, salaryVoucher, conInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]返回一个字符串数组[%returndesc]-User defined method
     *@param EASNumber EAS人员编码
     *@param conInfo sHR数据库连接信息
     *@return
     */
    public String[] getSHRPerson(String EASNumber, String[] conInfo) throws BOSException
    {
        try {
            return getController().getSHRPerson(getContext(), EASNumber, conInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]根据sHR行政组织编码获取名称[%returndesc]-User defined method
     *@param sHRAdminCode sHR行政组织编码
     *@param conInfo sHR数据库连接信息
     *@return
     */
    public String getSHRAdmin(String sHRAdminCode, String[] conInfo) throws BOSException
    {
        try {
            return getController().getSHRAdmin(getContext(), sHRAdminCode, conInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *[description][%description][invokedemo][%invokedemo][returndesc]是否属于叶子节点[%returndesc]-User defined method
     *@param personNum 人员编码
     *@return
     */
    public boolean getbooleanAdminOrgUnit(String personNum) throws BOSException
    {
        try {
            return getController().getbooleanAdminOrgUnit(getContext(), personNum);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得sHR的薪酬方案-User defined method
     *@param conInfo sHR数据库连接信息
     */
    public void updateSCalScheme(String[] conInfo) throws BOSException
    {
        try {
            getController().updateSCalScheme(getContext(), conInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得sHR的薪酬项目-User defined method
     *@param conInfo 数据库连接信息
     */
    public void updateCmpItem(String[] conInfo) throws BOSException
    {
        try {
            getController().updateCmpItem(getContext(), conInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据数据库连接信息获得Connection-User defined method
     *@param conInfo 连接数据库的基本信息
     *@return
     */
    public boolean getConnection(String[] conInfo) throws BOSException
    {
        try {
            return getController().getConnection(getContext(), conInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}