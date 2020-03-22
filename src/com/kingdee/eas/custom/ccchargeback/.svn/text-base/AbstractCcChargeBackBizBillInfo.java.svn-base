package com.kingdee.eas.custom.ccchargeback;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCcChargeBackBizBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCcChargeBackBizBillInfo()
    {
        this("id");
    }
    protected AbstractCcChargeBackBizBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillEntryCollection());
    }
    /**
     * Object: 商品鸡扣款单 's 分录 property 
     */
    public com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillEntryCollection)get("entrys");
    }
    /**
     * Object:商品鸡扣款单's 状态property 
     */
    public com.kingdee.eas.custom.ccchargeback.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.ccchargeback.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.ccchargeback.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object: 商品鸡扣款单 's 商品鸡场 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrgUnit");
    }
    public void setStoOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrgUnit", item);
    }
    /**
     * Object:商品鸡扣款单's 标准说明property 
     */
    public String getSTDRemark()
    {
        return getString("STDRemark");
    }
    public void setSTDRemark(String item)
    {
        setString("STDRemark", item);
    }
    /**
     * Object:商品鸡扣款单's 小鸡数量property 
     */
    public java.math.BigDecimal getChicksQty()
    {
        return getBigDecimal("chicksQty");
    }
    public void setChicksQty(java.math.BigDecimal item)
    {
        setBigDecimal("chicksQty", item);
    }
    /**
     * Object:商品鸡扣款单's 小鸡重量property 
     */
    public java.math.BigDecimal getChicksWT()
    {
        return getBigDecimal("chicksWT");
    }
    public void setChicksWT(java.math.BigDecimal item)
    {
        setBigDecimal("chicksWT", item);
    }
    /**
     * Object:商品鸡扣款单's 小鸡均重property 
     */
    public java.math.BigDecimal getChicksAvgWT()
    {
        return getBigDecimal("chicksAvgWT");
    }
    public void setChicksAvgWT(java.math.BigDecimal item)
    {
        setBigDecimal("chicksAvgWT", item);
    }
    /**
     * Object:商品鸡扣款单's 推算毛鸡只重property 
     */
    public java.math.BigDecimal getGrossChickenWT()
    {
        return getBigDecimal("grossChickenWT");
    }
    public void setGrossChickenWT(java.math.BigDecimal item)
    {
        setBigDecimal("grossChickenWT", item);
    }
    /**
     * Object:商品鸡扣款单's 推算小毛鸡总重property 
     */
    public java.math.BigDecimal getGrossChickTotalWT()
    {
        return getBigDecimal("grossChickTotalWT");
    }
    public void setGrossChickTotalWT(java.math.BigDecimal item)
    {
        setBigDecimal("grossChickTotalWT", item);
    }
    /**
     * Object:商品鸡扣款单's 审核时间property 
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
     * Object:商品鸡扣款单's 累计扣重property 
     */
    public java.math.BigDecimal getTotalWeight()
    {
        return getBigDecimal("totalWeight");
    }
    public void setTotalWeight(java.math.BigDecimal item)
    {
        setBigDecimal("totalWeight", item);
    }
    /**
     * Object:商品鸡扣款单's 累计扣款property 
     */
    public java.math.BigDecimal getTotalAmt()
    {
        return getBigDecimal("totalAmt");
    }
    public void setTotalAmt(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("42A0B697");
    }
}