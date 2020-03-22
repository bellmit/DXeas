package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeInStorageBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFeInStorageBillEntryInfo()
    {
        this("id");
    }
    protected AbstractFeInStorageBillEntryInfo(String pkField)
    {
        super(pkField);
        put("Detail", new com.kingdee.eas.weighbridge.FeInStorageBillEntryDetailCollection());
    }
    /**
     * Object: 过磅记录 's 单据头 property 
     */
    public com.kingdee.eas.weighbridge.FeInStorageBillInfo getParent()
    {
        return (com.kingdee.eas.weighbridge.FeInStorageBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.weighbridge.FeInStorageBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 过磅记录 's 物料编码 property 
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
     * Object:过磅记录's 物料名称property 
     */
    public String getMateiralName()
    {
        return getString("mateiralName");
    }
    public void setMateiralName(String item)
    {
        setString("mateiralName", item);
    }
    /**
     * Object:过磅记录's 规格型号property 
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
     * Object: 过磅记录 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("Unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("Unit", item);
    }
    /**
     * Object: 过磅记录 's 过磅分配明细 property 
     */
    public com.kingdee.eas.weighbridge.FeInStorageBillEntryDetailCollection getDetail()
    {
        return (com.kingdee.eas.weighbridge.FeInStorageBillEntryDetailCollection)get("Detail");
    }
    /**
     * Object:过磅记录's 皮重称重时间property 
     */
    public java.util.Date getWeighTime()
    {
        return getDate("weighTime");
    }
    public void setWeighTime(java.util.Date item)
    {
        setDate("weighTime", item);
    }
    /**
     * Object:过磅记录's 重量property 
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
     * Object:过磅记录's 皮重property 
     */
    public java.math.BigDecimal getTare()
    {
        return getBigDecimal("tare");
    }
    public void setTare(java.math.BigDecimal item)
    {
        setBigDecimal("tare", item);
    }
    /**
     * Object:过磅记录's 毛重property 
     */
    public java.math.BigDecimal getGross()
    {
        return getBigDecimal("gross");
    }
    public void setGross(java.math.BigDecimal item)
    {
        setBigDecimal("gross", item);
    }
    /**
     * Object:过磅记录's 净重property 
     */
    public java.math.BigDecimal getSuttle()
    {
        return getBigDecimal("suttle");
    }
    public void setSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("suttle", item);
    }
    /**
     * Object:过磅记录's 毛重称重时间property 
     */
    public java.util.Date getWeighTimeGross()
    {
        return getDate("weighTimeGross");
    }
    public void setWeighTimeGross(java.util.Date item)
    {
        setDate("weighTimeGross", item);
    }
    /**
     * Object:过磅记录's 二次皮重property 
     */
    public java.math.BigDecimal getTare2()
    {
        return getBigDecimal("tare2");
    }
    public void setTare2(java.math.BigDecimal item)
    {
        setBigDecimal("tare2", item);
    }
    /**
     * Object:过磅记录's 二次皮重时间property 
     */
    public java.util.Date getWeighTime2()
    {
        return getDate("weighTime2");
    }
    public void setWeighTime2(java.util.Date item)
    {
        setDate("weighTime2", item);
    }
    /**
     * Object:过磅记录's 实际净重property 
     */
    public java.math.BigDecimal getActualSuttle()
    {
        return getBigDecimal("actualSuttle");
    }
    public void setActualSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("actualSuttle", item);
    }
    /**
     * Object:过磅记录's 临时净重property 
     */
    public java.math.BigDecimal getTempSuttle()
    {
        return getBigDecimal("tempSuttle");
    }
    public void setTempSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("tempSuttle", item);
    }
    /**
     * Object:过磅记录's 扣袋皮重property 
     */
    public java.math.BigDecimal getImpurity()
    {
        return getBigDecimal("Impurity");
    }
    public void setImpurity(java.math.BigDecimal item)
    {
        setBigDecimal("Impurity", item);
    }
    /**
     * Object:过磅记录's 杂质扣重property 
     */
    public java.math.BigDecimal getImpurity2()
    {
        return getBigDecimal("Impurity2");
    }
    public void setImpurity2(java.math.BigDecimal item)
    {
        setBigDecimal("Impurity2", item);
    }
    /**
     * Object:过磅记录's 质检扣重property 
     */
    public java.math.BigDecimal getQcWeight()
    {
        return getBigDecimal("QcWeight");
    }
    public void setQcWeight(java.math.BigDecimal item)
    {
        setBigDecimal("QcWeight", item);
    }
    /**
     * Object:过磅记录's 手工扣重property 
     */
    public java.math.BigDecimal getOtherWeight()
    {
        return getBigDecimal("OtherWeight");
    }
    public void setOtherWeight(java.math.BigDecimal item)
    {
        setBigDecimal("OtherWeight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("794C232F");
    }
}