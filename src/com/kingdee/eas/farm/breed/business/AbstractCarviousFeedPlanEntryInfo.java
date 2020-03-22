package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarviousFeedPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarviousFeedPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractCarviousFeedPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.breed.business.CarviousFeedPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.business.CarviousFeedPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.business.CarviousFeedPlanInfo item)
    {
        put("parent", item);
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
     * Object: ��¼ 's ���ϱ��� property 
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
     * Object: ��¼ 's ��λ property 
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
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getUnitQty()
    {
        return getBigDecimal("unitQty");
    }
    public void setUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("unitQty", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public int getBagQty()
    {
        return getInt("bagQty");
    }
    public void setBagQty(int item)
    {
        setInt("bagQty", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getHatchDate()
    {
        return getDate("hatchDate");
    }
    public void setHatchDate(java.util.Date item)
    {
        setDate("hatchDate", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public String getWeekAge()
    {
        return getString("weekAge");
    }
    public void setWeekAge(String item)
    {
        setString("weekAge", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public int getCurrentQty()
    {
        return getInt("currentQty");
    }
    public void setCurrentQty(int item)
    {
        setInt("currentQty", item);
    }
    /**
     * Object:��¼'s �պ��ϱ�׼property 
     */
    public java.math.BigDecimal getFeedStdDaily()
    {
        return getBigDecimal("feedStdDaily");
    }
    public void setFeedStdDaily(java.math.BigDecimal item)
    {
        setBigDecimal("feedStdDaily", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.util.Date getSendDate()
    {
        return getDate("sendDate");
    }
    public void setSendDate(java.util.Date item)
    {
        setDate("sendDate", item);
    }
    /**
     * Object: ��¼ 's ���Ϲ�˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getSendCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("sendCompany");
    }
    public void setSendCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("sendCompany", item);
    }
    /**
     * Object: ��¼ 's ������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FeeSendPersonInfo getSendPerson()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FeeSendPersonInfo)get("sendPerson");
    }
    public void setSendPerson(com.kingdee.eas.farm.stocking.basedata.FeeSendPersonInfo item)
    {
        put("sendPerson", item);
    }
    /**
     * Object:��¼'s 1#��property 
     */
    public java.math.BigDecimal getNum1Feed()
    {
        return getBigDecimal("num1Feed");
    }
    public void setNum1Feed(java.math.BigDecimal item)
    {
        setBigDecimal("num1Feed", item);
    }
    /**
     * Object:��¼'s 2#��property 
     */
    public java.math.BigDecimal getNum2Feed()
    {
        return getBigDecimal("num2Feed");
    }
    public void setNum2Feed(java.math.BigDecimal item)
    {
        setBigDecimal("num2Feed", item);
    }
    /**
     * Object:��¼'s 3#��property 
     */
    public java.math.BigDecimal getNum3Feed()
    {
        return getBigDecimal("num3Feed");
    }
    public void setNum3Feed(java.math.BigDecimal item)
    {
        setBigDecimal("num3Feed", item);
    }
    /**
     * Object:��¼'s 4#��property 
     */
    public java.math.BigDecimal getNum4Feed()
    {
        return getBigDecimal("num4Feed");
    }
    public void setNum4Feed(java.math.BigDecimal item)
    {
        setBigDecimal("num4Feed", item);
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
    /**
     * Object:��¼'s ��ĩ���property 
     */
    public java.math.BigDecimal getSpareStocking()
    {
        return getBigDecimal("spareStocking");
    }
    public void setSpareStocking(java.math.BigDecimal item)
    {
        setBigDecimal("spareStocking", item);
    }
    /**
     * Object:��¼'s 5#��property 
     */
    public java.math.BigDecimal getNum5Feed()
    {
        return getBigDecimal("num5Feed");
    }
    public void setNum5Feed(java.math.BigDecimal item)
    {
        setBigDecimal("num5Feed", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: ��¼ 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: ��¼ 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2BE8F577");
    }
}