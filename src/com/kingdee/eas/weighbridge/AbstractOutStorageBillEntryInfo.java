package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOutStorageBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOutStorageBillEntryInfo()
    {
        this("id");
    }
    protected AbstractOutStorageBillEntryInfo(String pkField)
    {
        super(pkField);
        put("Detail", new com.kingdee.eas.weighbridge.OutStorageBillEntryDetailCollection());
    }
    /**
     * Object: ������¼ 's ����ͷ property 
     */
    public com.kingdee.eas.weighbridge.OutStorageBillInfo getParent()
    {
        return (com.kingdee.eas.weighbridge.OutStorageBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.weighbridge.OutStorageBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ������¼ 's ���ϱ��� property 
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
     * Object:������¼'s ��������property 
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
     * Object:������¼'s ����ͺ�property 
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
     * Object: ������¼ 's ������λ property 
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
     * Object: ������¼ 's ����������ϸ property 
     */
    public com.kingdee.eas.weighbridge.OutStorageBillEntryDetailCollection getDetail()
    {
        return (com.kingdee.eas.weighbridge.OutStorageBillEntryDetailCollection)get("Detail");
    }
    /**
     * Object:������¼'s Ƥ�س���ʱ��property 
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
     * Object:������¼'s ����property 
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
     * Object:������¼'s Ƥ��property 
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
     * Object:������¼'s ë��property 
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
     * Object:������¼'s ����property 
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
     * Object:������¼'s ë�س���ʱ��property 
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
     * Object:������¼'s ����Ƥ��property 
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
     * Object:������¼'s ����Ƥ��ʱ��property 
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
     * Object:������¼'s ʵ�ʾ���property 
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
     * Object:������¼'s ��ʱ����property 
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
     * Object:������¼'s ���ز���property 
     */
    public java.math.BigDecimal getSuttleDiff()
    {
        return getBigDecimal("suttleDiff");
    }
    public void setSuttleDiff(java.math.BigDecimal item)
    {
        setBigDecimal("suttleDiff", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7E37CC23");
    }
}