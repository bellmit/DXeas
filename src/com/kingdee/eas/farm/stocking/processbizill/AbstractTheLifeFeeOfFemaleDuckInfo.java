package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTheLifeFeeOfFemaleDuckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTheLifeFeeOfFemaleDuckInfo()
    {
        this("id");
    }
    protected AbstractTheLifeFeeOfFemaleDuckInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckEntryCollection());
    }
    /**
     * Object: 母鸭生活费 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TheLifeFeeOfFemaleDuckEntryCollection)get("entrys");
    }
    /**
     * Object:母鸭生活费's 是否生成凭证property 
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
     * Object: 母鸭生活费 's 公司 property 
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
     * Object: 母鸭生活费 's 会计期间 property 
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
     * Object:母鸭生活费's 审核时间property 
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
     * Object:母鸭生活费's 单据状态property 
     */
    public com.kingdee.eas.farm.breed.layegg.BillStatus getBillStatus()
    {
        return com.kingdee.eas.farm.breed.layegg.BillStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.farm.breed.layegg.BillStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object: 母鸭生活费 's 片区 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getOutAreas()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("outAreas");
    }
    public void setOutAreas(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("outAreas", item);
    }
    /**
     * Object:母鸭生活费's 生活费总金额property 
     */
    public java.math.BigDecimal getTotalAmt()
    {
        return getBigDecimal("totalAmt");
    }
    public void setTotalAmt(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmt", item);
    }
    /**
     * Object:母鸭生活费's 结算总金额property 
     */
    public java.math.BigDecimal getSettleAmt()
    {
        return getBigDecimal("settleAmt");
    }
    public void setSettleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("settleAmt", item);
    }
    /**
     * Object:母鸭生活费's 母鸭总只数property 
     */
    public java.math.BigDecimal getFemaleQty()
    {
        return getBigDecimal("femaleQty");
    }
    public void setFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("56FE1CDA");
    }
}