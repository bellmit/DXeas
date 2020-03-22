package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillQCEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKSettleBillQCEntryInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillQCEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 品质扣款 's null property 
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
     * Object: 品质扣款 's 质检项目 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo getQCItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo)get("QCItem");
    }
    public void setQCItem(com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo item)
    {
        put("QCItem", item);
    }
    /**
     * Object:品质扣款's 奖惩类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.PunishType getRandPType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.PunishType.getEnum(getString("randPType"));
    }
    public void setRandPType(com.kingdee.eas.farm.carnivorous.basedata.PunishType item)
    {
		if (item != null) {
        setString("randPType", item.getValue());
		}
    }
    /**
     * Object:品质扣款's 实际比例(%)property 
     */
    public java.math.BigDecimal getActualRate()
    {
        return getBigDecimal("actualRate");
    }
    public void setActualRate(java.math.BigDecimal item)
    {
        setBigDecimal("actualRate", item);
    }
    /**
     * Object:品质扣款's 扣罚金额property 
     */
    public java.math.BigDecimal getPunishAmt()
    {
        return getBigDecimal("punishAmt");
    }
    public void setPunishAmt(java.math.BigDecimal item)
    {
        setBigDecimal("punishAmt", item);
    }
    /**
     * Object:品质扣款's 实际重量property 
     */
    public java.math.BigDecimal getActualWgt()
    {
        return getBigDecimal("actualWgt");
    }
    public void setActualWgt(java.math.BigDecimal item)
    {
        setBigDecimal("actualWgt", item);
    }
    /**
     * Object:品质扣款's 扣罚重量(kg)property 
     */
    public java.math.BigDecimal getPunishWgt()
    {
        return getBigDecimal("punishWgt");
    }
    public void setPunishWgt(java.math.BigDecimal item)
    {
        setBigDecimal("punishWgt", item);
    }
    /**
     * Object:品质扣款's 屠宰单单号property 
     */
    public String getBillNumber()
    {
        return getString("billNumber");
    }
    public void setBillNumber(String item)
    {
        setString("billNumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4B257E29");
    }
}