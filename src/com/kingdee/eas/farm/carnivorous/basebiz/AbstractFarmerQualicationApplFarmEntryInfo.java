package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerQualicationApplFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmerQualicationApplFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmerQualicationApplFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场信息 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:养殖场信息's 名称property 
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
     * Object:养殖场信息's 地址property 
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
     * Object:养殖场信息's 养殖面积property 
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
     * Object:养殖场信息's 棚舍数量property 
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
     * Object:养殖场信息's 建筑面积property 
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
     * Object: 养殖场信息 's 养殖场编码 property 
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
     * Object: 养殖场信息 's 养殖场组别(已废弃) property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo getFarmGroup()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo)get("farmGroup");
    }
    public void setFarmGroup(com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo item)
    {
        put("farmGroup", item);
    }
    /**
     * Object:养殖场信息's 饲料运输距离(km)property 
     */
    public java.math.BigDecimal getMileStd()
    {
        return getBigDecimal("mileStd");
    }
    public void setMileStd(java.math.BigDecimal item)
    {
        setBigDecimal("mileStd", item);
    }
    /**
     * Object:养殖场信息's 毛鸡回收距离(km)property 
     */
    public java.math.BigDecimal getRecyMiles()
    {
        return getBigDecimal("recyMiles");
    }
    public void setRecyMiles(java.math.BigDecimal item)
    {
        setBigDecimal("recyMiles", item);
    }
    /**
     * Object: 养殖场信息 's 养殖场组别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo getFarmGrop()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo)get("farmGrop");
    }
    public void setFarmGrop(com.kingdee.eas.farm.carnivorous.basedata.FarmTreeInfo item)
    {
        put("farmGrop", item);
    }
    /**
     * Object:养殖场信息's 栋舍号property 
     */
    public String getMnemonicCode()
    {
        return getString("mnemonicCode");
    }
    public void setMnemonicCode(String item)
    {
        setString("mnemonicCode", item);
    }
    /**
     * Object:养殖场信息's 养殖规模property 
     */
    public java.math.BigDecimal getFarmQty()
    {
        return getBigDecimal("farmQty");
    }
    public void setFarmQty(java.math.BigDecimal item)
    {
        setBigDecimal("farmQty", item);
    }
    /**
     * Object:养殖场信息's 养殖模式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmsType getFarmTypea()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmsType.getEnum(getString("farmTypea"));
    }
    public void setFarmTypea(com.kingdee.eas.farm.stocking.basedata.FarmsType item)
    {
		if (item != null) {
        setString("farmTypea", item.getValue());
		}
    }
    /**
     * Object: 养殖场信息 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object:养殖场信息's 运费单价property 
     */
    public java.math.BigDecimal getTransPrice()
    {
        return getBigDecimal("transPrice");
    }
    public void setTransPrice(java.math.BigDecimal item)
    {
        setBigDecimal("transPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("63DC19FF");
    }
}