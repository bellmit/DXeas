package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmHouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmHouseEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ϣ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:������Ϣ's ����property 
     */
    public String getNumber()
    {
        return getString("number");
    }
    public void setNumber(String item)
    {
        setString("number", item);
    }
    /**
     * Object:������Ϣ's ����property 
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
     * Object:������Ϣ's ��ֳ���property 
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
     * Object:������Ϣ's �������property 
     */
    public java.math.BigDecimal getFloorArea()
    {
        return getBigDecimal("floorArea");
    }
    public void setFloorArea(java.math.BigDecimal item)
    {
        setBigDecimal("floorArea", item);
    }
    /**
     * Object: ������Ϣ 's �ɱ����� property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCentor()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCentor");
    }
    public void setCostCentor(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCentor", item);
    }
    /**
     * Object: ������Ϣ 's �ֿ� property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CF39BC2A");
    }
}