package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCommecialChikenApplyFodderImmuneEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCommecialChikenApplyFodderImmuneEntryInfo()
    {
        this("id");
    }
    protected AbstractCommecialChikenApplyFodderImmuneEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ������Ϣ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getVaccineMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("vaccineMaterial");
    }
    public void setVaccineMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("vaccineMaterial", item);
    }
    /**
     * Object:������Ϣ's ������property 
     */
    public java.math.BigDecimal getVaccineGetQty()
    {
        return getBigDecimal("vaccineGetQty");
    }
    public void setVaccineGetQty(java.math.BigDecimal item)
    {
        setBigDecimal("vaccineGetQty", item);
    }
    /**
     * Object:������Ϣ's ʹ����property 
     */
    public java.math.BigDecimal getVaccineUsedQty()
    {
        return getBigDecimal("vaccineUsedQty");
    }
    public void setVaccineUsedQty(java.math.BigDecimal item)
    {
        setBigDecimal("vaccineUsedQty", item);
    }
    /**
     * Object: ������Ϣ 's ���� property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object:������Ϣ's ��������property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:������Ϣ's ����property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:������Ϣ's ������λproperty 
     */
    public String getVaccineUnit()
    {
        return getString("vaccineUnit");
    }
    public void setVaccineUnit(String item)
    {
        setString("vaccineUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3C1893D7");
    }
}