package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractAllotEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchContractAllotEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchContractAllotEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分配记录 's null property 
     */
    public com.kingdee.eas.custom.taihe.contract.BatchContractInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.contract.BatchContractInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.contract.BatchContractInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分配记录 's 分配人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAllotUser()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("allotUser");
    }
    public void setAllotUser(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("allotUser", item);
    }
    /**
     * Object:分配记录's 分配时间property 
     */
    public java.util.Date getAllotTime()
    {
        return getDate("allotTime");
    }
    public void setAllotTime(java.util.Date item)
    {
        setDate("allotTime", item);
    }
    /**
     * Object: 分配记录 's 分配组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getAllotOrg()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("allotOrg");
    }
    public void setAllotOrg(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("allotOrg", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8D18A1BC");
    }
}