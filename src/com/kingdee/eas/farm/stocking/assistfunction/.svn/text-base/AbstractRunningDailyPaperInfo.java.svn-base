package com.kingdee.eas.farm.stocking.assistfunction;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRunningDailyPaperInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractRunningDailyPaperInfo()
    {
        this("id");
    }
    protected AbstractRunningDailyPaperInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperEntryCollection());
    }
    /**
     * Object: 经营日报成本 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperEntryCollection)get("entrys");
    }
    /**
     * Object:经营日报成本's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 经营日报成本 's 会计期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object: 经营日报成本 's 公司 property 
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
     * Object:经营日报成本's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object:经营日报成本's 单位费用property 
     */
    public java.math.BigDecimal getUnitFee()
    {
        return getBigDecimal("unitFee");
    }
    public void setUnitFee(java.math.BigDecimal item)
    {
        setBigDecimal("unitFee", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3B34CA67");
    }
}