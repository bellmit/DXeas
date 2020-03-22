package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillSlaughterEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillSlaughterEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillSlaughterEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 屠宰单 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:屠宰单's 业务日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object:屠宰单's 单据编号property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    /**
     * Object:屠宰单's B鸡重量property 
     */
    public java.math.BigDecimal getPreHouseSuttle()
    {
        return getBigDecimal("preHouseSuttle");
    }
    public void setPreHouseSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseSuttle", item);
    }
    /**
     * Object:屠宰单's 回收只数property 
     */
    public int getRecQty()
    {
        return getInt("recQty");
    }
    public void setRecQty(int item)
    {
        setInt("recQty", item);
    }
    /**
     * Object:屠宰单's A鸡只数property 
     */
    public int getCarcassQty()
    {
        return getInt("carcassQty");
    }
    public void setCarcassQty(int item)
    {
        setInt("carcassQty", item);
    }
    /**
     * Object:屠宰单's B鸡只数property 
     */
    public java.math.BigDecimal getCarcassWgt()
    {
        return getBigDecimal("carcassWgt");
    }
    public void setCarcassWgt(java.math.BigDecimal item)
    {
        setBigDecimal("carcassWgt", item);
    }
    /**
     * Object:屠宰单's 残鸡只数property 
     */
    public int getInCompleteQty()
    {
        return getInt("inCompleteQty");
    }
    public void setInCompleteQty(int item)
    {
        setInt("inCompleteQty", item);
    }
    /**
     * Object:屠宰单's 返死鸡重量property 
     */
    public java.math.BigDecimal getInCompleteWgt()
    {
        return getBigDecimal("inCompleteWgt");
    }
    public void setInCompleteWgt(java.math.BigDecimal item)
    {
        setBigDecimal("inCompleteWgt", item);
    }
    /**
     * Object:屠宰单's 单据状态property 
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
     * Object:屠宰单's A鸡重量property 
     */
    public java.math.BigDecimal getAWeight()
    {
        return getBigDecimal("AWeight");
    }
    public void setAWeight(java.math.BigDecimal item)
    {
        setBigDecimal("AWeight", item);
    }
    /**
     * Object:屠宰单's 扣罚总重量property 
     */
    public java.math.BigDecimal getPunishAllWeight()
    {
        return getBigDecimal("punishAllWeight");
    }
    public void setPunishAllWeight(java.math.BigDecimal item)
    {
        setBigDecimal("punishAllWeight", item);
    }
    /**
     * Object:屠宰单's 结算重量property 
     */
    public java.math.BigDecimal getSettlementAllWig()
    {
        return getBigDecimal("settlementAllWig");
    }
    public void setSettlementAllWig(java.math.BigDecimal item)
    {
        setBigDecimal("settlementAllWig", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("94588416");
    }
}