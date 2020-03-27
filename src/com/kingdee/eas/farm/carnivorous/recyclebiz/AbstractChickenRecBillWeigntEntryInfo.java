package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenRecBillWeigntEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractChickenRecBillWeigntEntryInfo()
    {
        this("id");
    }
    protected AbstractChickenRecBillWeigntEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 棚前过磅 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 棚前过磅 's 司机 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:棚前过磅's 司机联系方式property 
     */
    public String getTelephone()
    {
        return getString("telephone");
    }
    public void setTelephone(String item)
    {
        setString("telephone", item);
    }
    /**
     * Object:棚前过磅's 棚前只数property 
     */
    public java.math.BigDecimal getChickenQty()
    {
        return getBigDecimal("chickenQty");
    }
    public void setChickenQty(java.math.BigDecimal item)
    {
        setBigDecimal("chickenQty", item);
    }
    /**
     * Object:棚前过磅's 棚前毛重(斤)property 
     */
    public java.math.BigDecimal getHouseWeight()
    {
        return getBigDecimal("houseWeight");
    }
    public void setHouseWeight(java.math.BigDecimal item)
    {
        setBigDecimal("houseWeight", item);
    }
    /**
     * Object:棚前过磅's 棚前皮重(斤)property 
     */
    public java.math.BigDecimal getHouseSkinWeight()
    {
        return getBigDecimal("houseSkinWeight");
    }
    public void setHouseSkinWeight(java.math.BigDecimal item)
    {
        setBigDecimal("houseSkinWeight", item);
    }
    /**
     * Object:棚前过磅's 棚前净重(斤)property 
     */
    public String getHouseNetWeight()
    {
        return getString("houseNetWeight");
    }
    public void setHouseNetWeight(String item)
    {
        setString("houseNetWeight", item);
    }
    /**
     * Object: 棚前过磅 's 销售客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:棚前过磅's 销售毛鸡价格(元/斤)property 
     */
    public java.math.BigDecimal getSaleChicPrice()
    {
        return getBigDecimal("saleChicPrice");
    }
    public void setSaleChicPrice(java.math.BigDecimal item)
    {
        setBigDecimal("saleChicPrice", item);
    }
    /**
     * Object:棚前过磅's 销售数量(斤)property 
     */
    public java.math.BigDecimal getSaleQty()
    {
        return getBigDecimal("saleQty");
    }
    public void setSaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("saleQty", item);
    }
    /**
     * Object:棚前过磅's 销售金额property 
     */
    public java.math.BigDecimal getSaleAmount()
    {
        return getBigDecimal("saleAmount");
    }
    public void setSaleAmount(java.math.BigDecimal item)
    {
        setBigDecimal("saleAmount", item);
    }
    /**
     * Object: 棚前过磅 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCarcar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("carcar");
    }
    public void setCarcar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("carcar", item);
    }
    /**
     * Object:棚前过磅's 车辆property 
     */
    public String getCarText()
    {
        return getString("carText");
    }
    public void setCarText(String item)
    {
        setString("carText", item);
    }
    /**
     * Object:棚前过磅's 司机property 
     */
    public String getDriverText()
    {
        return getString("driverText");
    }
    public void setDriverText(String item)
    {
        setString("driverText", item);
    }
    /**
     * Object:棚前过磅's 司机联系方式property 
     */
    public String getDriverTel()
    {
        return getString("driverTel");
    }
    public void setDriverTel(String item)
    {
        setString("driverTel", item);
    }
    /**
     * Object:棚前过磅's 结算类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.settlementItem getSettlementItem()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.settlementItem.getEnum(getString("settlementItem"));
    }
    public void setSettlementItem(com.kingdee.eas.farm.carnivorous.basedata.settlementItem item)
    {
		if (item != null) {
        setString("settlementItem", item.getValue());
		}
    }
    /**
     * Object:棚前过磅's 市场价property 
     */
    public java.math.BigDecimal getMarketPrice()
    {
        return getBigDecimal("marketPrice");
    }
    public void setMarketPrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketPrice", item);
    }
    /**
     * Object:棚前过磅's 胴体折算后毛鸡重量property 
     */
    public java.math.BigDecimal getCarcessReduceWeight()
    {
        return getBigDecimal("carcessReduceWeight");
    }
    public void setCarcessReduceWeight(java.math.BigDecimal item)
    {
        setBigDecimal("carcessReduceWeight", item);
    }
    /**
     * Object:棚前过磅's 胴体property 
     */
    public boolean isCarcass()
    {
        return getBoolean("carcass");
    }
    public void setCarcass(boolean item)
    {
        setBoolean("carcass", item);
    }
    /**
     * Object:棚前过磅's 备注property 
     */
    public String getEntryEemark()
    {
        return getString("entryEemark");
    }
    public void setEntryEemark(String item)
    {
        setString("entryEemark", item);
    }
    /**
     * Object:棚前过磅's 车主property 
     */
    public String getCarleader()
    {
        return getString("carleader");
    }
    public void setCarleader(String item)
    {
        setString("carleader", item);
    }
    /**
     * Object:棚前过磅's 均重property 
     */
    public java.math.BigDecimal getAvgWgt()
    {
        return getBigDecimal("avgWgt");
    }
    public void setAvgWgt(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("92E24BC1");
    }
}