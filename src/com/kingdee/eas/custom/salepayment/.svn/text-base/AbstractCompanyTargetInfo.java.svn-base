package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyTargetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCompanyTargetInfo()
    {
        this("id");
    }
    protected AbstractCompanyTargetInfo(String pkField)
    {
        super(pkField);
        put("AreaEntry", new com.kingdee.eas.custom.salepayment.CompanyTargetAreaEntryCollection());
    }
    /**
     * Object: 公司指标 's 组别 property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyTargetTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyTargetTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.salepayment.CompanyTargetTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 公司指标 's 大区指标 property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyTargetAreaEntryCollection getAreaEntry()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyTargetAreaEntryCollection)get("AreaEntry");
    }
    /**
     * Object:公司指标's 指标类型property 
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
     * Object:公司指标's 损益指标（元）property 
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
     * Object: 公司指标 's 公司 property 
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
     * Object:公司指标's 大区指标合计property 
     */
    public int getAreaProfitSum()
    {
        return getInt("areaProfitSum");
    }
    public void setAreaProfitSum(int item)
    {
        setInt("areaProfitSum", item);
    }
    /**
     * Object:公司指标's 状态property 
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
     * Object:公司指标's 年property 
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
     * Object:公司指标's 季度property 
     */
    public com.kingdee.eas.custom.salepayment.Quarter getQuater()
    {
        return com.kingdee.eas.custom.salepayment.Quarter.getEnum(getString("quater"));
    }
    public void setQuater(com.kingdee.eas.custom.salepayment.Quarter item)
    {
		if (item != null) {
        setString("quater", item.getValue());
		}
    }
    /**
     * Object: 公司指标 's 审核人 property 
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
     * Object:公司指标's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1E7D25FA");
    }
}