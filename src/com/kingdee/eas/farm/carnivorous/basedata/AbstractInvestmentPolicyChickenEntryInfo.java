package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInvestmentPolicyChickenEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractInvestmentPolicyChickenEntryInfo()
    {
        this("id");
    }
    protected AbstractInvestmentPolicyChickenEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ҩƷ�ɱ����Ϸ�¼ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s �ɱ�property 
     */
    public java.math.BigDecimal getCost()
    {
        return getBigDecimal("cost");
    }
    public void setCost(java.math.BigDecimal item)
    {
        setBigDecimal("cost", item);
    }
    /**
     * Object: ҩƷ�ɱ����Ϸ�¼ 's ������Ŀ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo getSettleItem()
    {
        return (com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo)get("settleItem");
    }
    public void setSettleItem(com.kingdee.eas.farm.stocking.basedata.SettlementItemInfo item)
    {
        put("settleItem", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ��Ч����property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ʧЧ����property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s �ɱ��۸�property 
     */
    public java.math.BigDecimal getCostPrice()
    {
        return getBigDecimal("costPrice");
    }
    public void setCostPrice(java.math.BigDecimal item)
    {
        setBigDecimal("costPrice", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ��ͬ����۸�property 
     */
    public java.math.BigDecimal getContractPrice()
    {
        return getBigDecimal("contractPrice");
    }
    public void setContractPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractPrice", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s �г�����۸�property 
     */
    public java.math.BigDecimal getMarketPrice()
    {
        return getBigDecimal("marketPrice");
    }
    public void setMarketPrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketPrice", item);
    }
    /**
     * Object: ҩƷ�ɱ����Ϸ�¼ 's ���ϱ��� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNuo()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNuo");
    }
    public void setMaterialNuo(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNuo", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ��������property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ��������ۿռ�property 
     */
    public java.math.BigDecimal getOutPrice()
    {
        return getBigDecimal("outPrice");
    }
    public void setOutPrice(java.math.BigDecimal item)
    {
        setBigDecimal("outPrice", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ����ͺ�property 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    /**
     * Object:ҩƷ�ɱ����Ϸ�¼'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("26691CE4");
    }
}