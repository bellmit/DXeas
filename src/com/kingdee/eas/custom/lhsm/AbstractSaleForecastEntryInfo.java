package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleForecastEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSaleForecastEntryInfo()
    {
        this("id");
    }
    protected AbstractSaleForecastEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.lhsm.SaleForecastInfo getParent()
    {
        return (com.kingdee.eas.custom.lhsm.SaleForecastInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.lhsm.SaleForecastInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ���ϱ��� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterialNumber()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("materialNumber");
    }
    public void setMaterialNumber(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("materialNumber", item);
    }
    /**
     * Object:��¼'s ��������property 
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
     * Object: ��¼ 's ������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getMeasureUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("measureUnit");
    }
    public void setMeasureUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("measureUnit", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getBaseQty()
    {
        return getBigDecimal("baseQty");
    }
    public void setBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseQty", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:��¼'s �ѷ�������property 
     */
    public java.math.BigDecimal getQtya()
    {
        return getBigDecimal("qtya");
    }
    public void setQtya(java.math.BigDecimal item)
    {
        setBigDecimal("qtya", item);
    }
    /**
     * Object:��¼'s δ��������property 
     */
    public java.math.BigDecimal getQtyb()
    {
        return getBigDecimal("qtyb");
    }
    public void setQtyb(java.math.BigDecimal item)
    {
        setBigDecimal("qtyb", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:��¼'s ���property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object: ��¼ 's ������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getBaseUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("baseUnit");
    }
    public void setBaseUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("baseUnit", item);
    }
    /**
     * Object: ��¼ 's ����˾ property 
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
     * Object:��¼'s ��ԴIdproperty 
     */
    public String getSourceEntryId()
    {
        return getString("sourceEntryId");
    }
    public void setSourceEntryId(String item)
    {
        setString("sourceEntryId", item);
    }
    /**
     * Object:��¼'s ���property 
     */
    public java.math.BigDecimal getPremium()
    {
        return getBigDecimal("premium");
    }
    public void setPremium(java.math.BigDecimal item)
    {
        setBigDecimal("premium", item);
    }
    /**
     * Object:��¼'s ���property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object: ��¼ 's ����������λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getAssistUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("assistUnit");
    }
    public void setAssistUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("assistUnit", item);
    }
    /**
     * Object:��¼'s ����������λ����property 
     */
    public java.math.BigDecimal getAssistUnitQty()
    {
        return getBigDecimal("assistUnitQty");
    }
    public void setAssistUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("assistUnitQty", item);
    }
    /**
     * Object:��¼'s ���ڷ���property 
     */
    public java.math.BigDecimal getInternalCost()
    {
        return getBigDecimal("internalCost");
    }
    public void setInternalCost(java.math.BigDecimal item)
    {
        setBigDecimal("internalCost", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.math.BigDecimal getSuttlePrice()
    {
        return getBigDecimal("suttlePrice");
    }
    public void setSuttlePrice(java.math.BigDecimal item)
    {
        setBigDecimal("suttlePrice", item);
    }
    /**
     * Object: ��¼ 's �ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWareHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("wareHouse");
    }
    public void setWareHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("wareHouse", item);
    }
    /**
     * Object: ��¼ 's ������ property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroup()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroup");
    }
    public void setMaterialGroup(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroup", item);
    }
    /**
     * Object: ��¼ 's ���ϼ�ֵ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialGroupInfo getMaterialGroupB()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialGroupInfo)get("materialGroupB");
    }
    public void setMaterialGroupB(com.kingdee.eas.basedata.master.material.MaterialGroupInfo item)
    {
        put("materialGroupB", item);
    }
    /**
     * Object:��¼'s ���ߵ���property 
     */
    public java.math.BigDecimal getSrcPrice()
    {
        return getBigDecimal("srcPrice");
    }
    public void setSrcPrice(java.math.BigDecimal item)
    {
        setBigDecimal("srcPrice", item);
    }
    /**
     * Object:��¼'s ��۽��property 
     */
    public java.math.BigDecimal getPremiumAmount()
    {
        return getBigDecimal("premiumAmount");
    }
    public void setPremiumAmount(java.math.BigDecimal item)
    {
        setBigDecimal("premiumAmount", item);
    }
    /**
     * Object:��¼'s ��עproperty 
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
        return new BOSObjectType("B5CFF663");
    }
}