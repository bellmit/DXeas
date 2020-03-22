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
     * Object: Ʒ�ʿۿ� 's null property 
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
     * Object: Ʒ�ʿۿ� 's �ʼ���Ŀ property 
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
     * Object:Ʒ�ʿۿ�'s ��������property 
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
     * Object:Ʒ�ʿۿ�'s ʵ�ʱ���(%)property 
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
     * Object:Ʒ�ʿۿ�'s �۷����property 
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
     * Object:Ʒ�ʿۿ�'s ʵ������property 
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
     * Object:Ʒ�ʿۿ�'s �۷�����(kg)property 
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
     * Object:Ʒ�ʿۿ�'s ���׵�����property 
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