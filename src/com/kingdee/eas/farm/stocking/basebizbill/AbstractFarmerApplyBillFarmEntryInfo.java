package com.kingdee.eas.farm.stocking.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerApplyBillFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerApplyBillFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerApplyBillFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ֳ����Ϣ 's null property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��ֳ����Ϣ's ����property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:��ֳ����Ϣ's ��ַproperty 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object:��ֳ����Ϣ's ��ֳ���property 
     */
    public java.math.BigDecimal getArea()
    {
        return getBigDecimal("area");
    }
    public void setArea(java.math.BigDecimal item)
    {
        setBigDecimal("area", item);
    }
    /**
     * Object:��ֳ����Ϣ's ��������property 
     */
    public int getSuccahQty()
    {
        return getInt("succahQty");
    }
    public void setSuccahQty(int item)
    {
        setInt("succahQty", item);
    }
    /**
     * Object: ��ֳ����Ϣ 's ��ֳ������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: ��ֳ����Ϣ 's ��ֳ������ property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo getFarmGroup()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo)get("farmGroup");
    }
    public void setFarmGroup(com.kingdee.eas.farm.stocking.basedata.FarmTreeInfo item)
    {
        put("farmGroup", item);
    }
    /**
     * Object:��ֳ����Ϣ's �������property 
     */
    public java.math.BigDecimal getFloorArea()
    {
        return getBigDecimal("floorArea");
    }
    public void setFloorArea(java.math.BigDecimal item)
    {
        setBigDecimal("floorArea", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3622816B");
    }
}