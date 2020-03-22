package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalerStimulateSetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSalerStimulateSetInfo()
    {
        this("id");
    }
    protected AbstractSalerStimulateSetInfo(String pkField)
    {
        super(pkField);
        put("StimulateEntry", new com.kingdee.eas.custom.salepayment.SalerStimulateSetStimulateEntryCollection());
    }
    /**
     * Object: 销售提成设置 's 组别 property 
     */
    public com.kingdee.eas.custom.salepayment.SalerStimulateSetTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salepayment.SalerStimulateSetTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salepayment.SalerStimulateSetTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 销售提成设置 's 销售员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSaler()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("saler");
    }
    public void setSaler(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("saler", item);
    }
    /**
     * Object:销售提成设置's 指标类型property 
     */
    public com.kingdee.eas.custom.salepayment.IndexType getIndexType()
    {
        return com.kingdee.eas.custom.salepayment.IndexType.getEnum(getString("indexType"));
    }
    public void setIndexType(com.kingdee.eas.custom.salepayment.IndexType item)
    {
		if (item != null) {
        setString("indexType", item.getValue());
		}
    }
    /**
     * Object:销售提成设置's 损益指标(元)property 
     */
    public int getProfitTarget()
    {
        return getInt("profitTarget");
    }
    public void setProfitTarget(int item)
    {
        setInt("profitTarget", item);
    }
    /**
     * Object:销售提成设置's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 销售提成设置 's 提成分录 property 
     */
    public com.kingdee.eas.custom.salepayment.SalerStimulateSetStimulateEntryCollection getStimulateEntry()
    {
        return (com.kingdee.eas.custom.salepayment.SalerStimulateSetStimulateEntryCollection)get("StimulateEntry");
    }
    /**
     * Object:销售提成设置's 年property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object:销售提成设置's 季度property 
     */
    public com.kingdee.eas.custom.salepayment.Quarter getQuarter()
    {
        return com.kingdee.eas.custom.salepayment.Quarter.getEnum(getString("quarter"));
    }
    public void setQuarter(com.kingdee.eas.custom.salepayment.Quarter item)
    {
		if (item != null) {
        setString("quarter", item.getValue());
		}
    }
    /**
     * Object: 销售提成设置 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: 销售提成设置 's 审核者 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:销售提成设置's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: 销售提成设置 's 公司指标 property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyTargetInfo getCompanyTargetInfo()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyTargetInfo)get("companyTargetInfo");
    }
    public void setCompanyTargetInfo(com.kingdee.eas.custom.salepayment.CompanyTargetInfo item)
    {
        put("companyTargetInfo", item);
    }
    /**
     * Object: 销售提成设置 's 大区指标 property 
     */
    public com.kingdee.eas.custom.salepayment.AreaTargetInfo getAreaTargetInfo()
    {
        return (com.kingdee.eas.custom.salepayment.AreaTargetInfo)get("areaTargetInfo");
    }
    public void setAreaTargetInfo(com.kingdee.eas.custom.salepayment.AreaTargetInfo item)
    {
        put("areaTargetInfo", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AA9FB843");
    }
}