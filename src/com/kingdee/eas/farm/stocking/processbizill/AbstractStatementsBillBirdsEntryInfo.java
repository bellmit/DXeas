package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsBillBirdsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStatementsBillBirdsEntryInfo()
    {
        this("id");
    }
    protected AbstractStatementsBillBirdsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �ݷ�¼ 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StatementsBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: �ݷ�¼ 's ���ݱ��� property 
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
     * Object:�ݷ�¼'s ��������property 
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
     * Object:�ݷ�¼'s ���property 
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
     * Object: �ݷ�¼ 's ������λ property 
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
     * Object:�ݷ�¼'s ��������property 
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
     * Object:�ݷ�¼'s ���յ���property 
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
     * Object:�ݷ�¼'s ���ս��property 
     */
    public java.math.BigDecimal getAmout()
    {
        return getBigDecimal("amout");
    }
    public void setAmout(java.math.BigDecimal item)
    {
        setBigDecimal("amout", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("54EB4F88");
    }
}