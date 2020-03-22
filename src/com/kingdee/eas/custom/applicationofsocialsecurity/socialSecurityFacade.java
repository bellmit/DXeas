package com.kingdee.eas.custom.applicationofsocialsecurity;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import java.util.ArrayList;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.applicationofsocialsecurity.app.*;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public class socialSecurityFacade extends AbstractBizCtrl implements IsocialSecurityFacade
{
    public socialSecurityFacade()
    {
        super();
        registerInterface(IsocialSecurityFacade.class, this);
    }
    public socialSecurityFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IsocialSecurityFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D72C1686");
    }
    private socialSecurityFacadeController getController() throws BOSException
    {
        return (socialSecurityFacadeController)getBizController();
    }
    /**
     *根据shr员工的编码查询shr的人员相关信息-User defined method
     *@param personNum 员工编码
     *@param personName 员工姓名
     *@param dataBaseConnectionIngfo 数据库连接设置
     *@return
     */
    public HashMap getInfoOfPersonBaseOnNumberOrName(String personNum, String personName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getInfoOfPersonBaseOnNumberOrName(getContext(), personNum, personName, dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得sHR系统的几种社保状态-User defined method
     *@param dataBaseConnectionIngfo 数据库连接设置Info
     *@return
     */
    public ArrayList getSHRSIStatus(DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getSHRSIStatus(getContext(), dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据社保状态的名称获取ID-User defined method
     *@param SIStatusName 社保状态名称
     *@param dataBaseConnectionIngfo 数据库连接设置
     *@return
     */
    public String getSIStatusIDBaseOnHisName(String SIStatusName, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getSIStatusIDBaseOnHisName(getContext(), SIStatusName, dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据员工编码和目标社保状态的ID更新员工的社保状态-User defined method
     *@param SIStatusID 社保状态
     *@param personNum 员工编码
     *@param dataBaseConnectionIngfo 数据库连接设置
     *@return
     */
    public String updateSIStatusBaseOnPersonNumAndSIStatusID(String SIStatusID, String personNum, DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().updateSIStatusBaseOnPersonNumAndSIStatusID(getContext(), SIStatusID, personNum, dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *从shr系统中获取公司-User defined method
     *@param dataBaseConnectionIngfo 数据库连接配置
     *@return
     */
    public ArrayList getCompanyNameFromSHR(DataBaseConnectionInfo dataBaseConnectionIngfo) throws BOSException, EASBizException
    {
        try {
            return getController().getCompanyNameFromSHR(getContext(), dataBaseConnectionIngfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据过滤条件获得sHR人员的相关信息-User defined method
     *@param dateBegin 入职日期从
     *@param dateEnd 入职日期到
     *@param dataBaseConnectionInfo 数据库连接配置
     *@param isIn 是否在职
     *@param company 公司
     *@param SIStatus 社保状态
     *@param personName 人员姓名
     *@param personNum 人员编码
     *@return
     */
    public ArrayList getPersonInfoByFilterItem(Date dateBegin, Date dateEnd, DataBaseConnectionInfo dataBaseConnectionInfo, boolean isIn, String company, String SIStatus, String personName, String personNum) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonInfoByFilterItem(getContext(), dateBegin, dateEnd, dataBaseConnectionInfo, isIn, company, SIStatus, personName, personNum);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}