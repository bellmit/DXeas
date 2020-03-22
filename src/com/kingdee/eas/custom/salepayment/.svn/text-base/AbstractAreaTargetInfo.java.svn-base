package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAreaTargetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractAreaTargetInfo()
    {
        this("id");
    }
    protected AbstractAreaTargetInfo(String pkField)
    {
        super(pkField);
        put("SalerEntry", new com.kingdee.eas.custom.salepayment.AreaTargetSalerEntryCollection());
    }
    /**
     * Object: 大区指标 's 组别 property 
     */
    public com.kingdee.eas.custom.salepayment.AreaTargetTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salepayment.AreaTargetTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salepayment.AreaTargetTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 大区指标 's 公司 property 
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
     * Object: 大区指标 's 销售员指标 property 
     */
    public com.kingdee.eas.custom.salepayment.AreaTargetSalerEntryCollection getSalerEntry()
    {
        return (com.kingdee.eas.custom.salepayment.AreaTargetSalerEntryCollection)get("SalerEntry");
    }
    /**
     * Object:大区指标's 指标类型property 
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
     * Object:大区指标's 损益指标（元）property 
     */
    public int getAreaProfitTarget()
    {
        return getInt("areaProfitTarget");
    }
    public void setAreaProfitTarget(int item)
    {
        setInt("areaProfitTarget", item);
    }
    /**
     * Object:大区指标's 业务经理指标合计property 
     */
    public int getSalerProfitSum()
    {
        return getInt("salerProfitSum");
    }
    public void setSalerProfitSum(int item)
    {
        setInt("salerProfitSum", item);
    }
    /**
     * Object:大区指标's 状态property 
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
     * Object:大区指标's 年property 
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
     * Object:大区指标's 季度property 
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
     * Object: 大区指标 's 审核人 property 
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
     * Object:大区指标's 审核时间property 
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
     * Object: 大区指标 's 大区 property 
     */
    public com.kingdee.eas.custom.salepayment.AreaSetInfo getArea()
    {
        return (com.kingdee.eas.custom.salepayment.AreaSetInfo)get("area");
    }
    public void setArea(com.kingdee.eas.custom.salepayment.AreaSetInfo item)
    {
        put("area", item);
    }
    /**
     * Object: 大区指标 's 公司指标 property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyTargetInfo getCompanyTargetInfo()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyTargetInfo)get("companyTargetInfo");
    }
    public void setCompanyTargetInfo(com.kingdee.eas.custom.salepayment.CompanyTargetInfo item)
    {
        put("companyTargetInfo", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2EE2FE72");
    }
}