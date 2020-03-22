package com.kingdee.eas.custom.salediscount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDiscountRecordBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDiscountRecordBillEntryInfo()
    {
        this("id");
    }
    protected AbstractDiscountRecordBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo getParent()
    {
        return (com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salediscount.DiscountRecordBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:分录's 物料名称property 
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
     * Object:分录's 折让金额property 
     */
    public java.math.BigDecimal getDiscountAmount()
    {
        return getBigDecimal("discountAmount");
    }
    public void setDiscountAmount(java.math.BigDecimal item)
    {
        setBigDecimal("discountAmount", item);
    }
    /**
     * Object: 分录 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:分录's 计算公式property 
     */
    public String getDiscountFomula()
    {
        return getString("discountFomula");
    }
    public void setDiscountFomula(String item)
    {
        setString("discountFomula", item);
    }
    /**
     * Object:分录's 折让前金额property 
     */
    public java.math.BigDecimal getNoDSAmount()
    {
        return getBigDecimal("noDSAmount");
    }
    public void setNoDSAmount(java.math.BigDecimal item)
    {
        setBigDecimal("noDSAmount", item);
    }
    /**
     * Object:分录's 不含实物折扣数量property 
     */
    public java.math.BigDecimal getNoDSQty()
    {
        return getBigDecimal("noDSQty");
    }
    public void setNoDSQty(java.math.BigDecimal item)
    {
        setBigDecimal("noDSQty", item);
    }
    /**
     * Object:分录's 基本价格property 
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
     * Object:分录's 分录IDproperty 
     */
    public String getEntryID()
    {
        return getString("entryID");
    }
    public void setEntryID(String item)
    {
        setString("entryID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("64CAA87E");
    }
}