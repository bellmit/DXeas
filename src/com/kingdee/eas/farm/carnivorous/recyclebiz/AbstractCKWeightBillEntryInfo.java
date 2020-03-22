package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKWeightBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKWeightBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCKWeightBillEntryInfo(String pkField)
    {
        super(pkField);
        put("Detail", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryDetailCollection());
    }
    /**
     * Object: ������¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo item)
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
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryDetailCollection getDetail()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillEntryDetailCollection)get("Detail");
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
     * Object:������¼'s �۴�Ƥ��property 
     */
    public java.math.BigDecimal getImpurity()
    {
        return getBigDecimal("impurity");
    }
    public void setImpurity(java.math.BigDecimal item)
    {
        setBigDecimal("impurity", item);
    }
    /**
     * Object:������¼'s �ʼ����property 
     */
    public java.math.BigDecimal getImpurity2()
    {
        return getBigDecimal("impurity2");
    }
    public void setImpurity2(java.math.BigDecimal item)
    {
        setBigDecimal("impurity2", item);
    }
    /**
     * Object:������¼'s ����property 
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
     * Object:������¼'s ��Դ����IDproperty 
     */
    public String getSourceBillID()
    {
        return getString("sourceBillID");
    }
    public void setSourceBillID(String item)
    {
        setString("sourceBillID", item);
    }
    /**
     * Object:������¼'s ��Դ���ݷ�¼IDproperty 
     */
    public String getSourceBillEntryID()
    {
        return getString("sourceBillEntryID");
    }
    public void setSourceBillEntryID(String item)
    {
        setString("sourceBillEntryID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8410F4AE");
    }
}