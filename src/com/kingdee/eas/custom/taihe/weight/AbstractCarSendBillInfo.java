package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarSendBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractCarSendBillInfo()
    {
        this("id");
    }
    protected AbstractCarSendBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:派车单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:派车单's 回收日期property 
     */
    public java.util.Date getRecycleDate()
    {
        return getDate("recycleDate");
    }
    public void setRecycleDate(java.util.Date item)
    {
        setDate("recycleDate", item);
    }
    /**
     * Object:派车单's 收购类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.PurchaseType getPurchaseType()
    {
        return com.kingdee.eas.custom.taihe.weight.PurchaseType.getEnum(getString("purchaseType"));
    }
    public void setPurchaseType(com.kingdee.eas.custom.taihe.weight.PurchaseType item)
    {
		if (item != null) {
        setString("purchaseType", item.getValue());
		}
    }
    /**
     * Object:派车单's 收购方式property 
     */
    public com.kingdee.eas.custom.taihe.weight.PurchaseMethod getPurchaseMethod()
    {
        return com.kingdee.eas.custom.taihe.weight.PurchaseMethod.getEnum(getString("purchaseMethod"));
    }
    public void setPurchaseMethod(com.kingdee.eas.custom.taihe.weight.PurchaseMethod item)
    {
		if (item != null) {
        setString("purchaseMethod", item.getValue());
		}
    }
    /**
     * Object:派车单's 预计回收只数property 
     */
    public java.math.BigDecimal getEstRecycleQty()
    {
        return getBigDecimal("estRecycleQty");
    }
    public void setEstRecycleQty(java.math.BigDecimal item)
    {
        setBigDecimal("estRecycleQty", item);
    }
    /**
     * Object:派车单's 预计回收重量property 
     */
    public java.math.BigDecimal getEstRecycleWgt()
    {
        return getBigDecimal("estRecycleWgt");
    }
    public void setEstRecycleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("estRecycleWgt", item);
    }
    /**
     * Object: 派车单 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object: 派车单 's 司机 property 
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
     * Object:派车单's 司机联系方式property 
     */
    public String getDriverCell()
    {
        return getString("driverCell");
    }
    public void setDriverCell(String item)
    {
        setString("driverCell", item);
    }
    /**
     * Object:派车单's 要求到厂日期property 
     */
    public java.util.Date getReachFactoryDate()
    {
        return getDate("reachFactoryDate");
    }
    public void setReachFactoryDate(java.util.Date item)
    {
        setDate("reachFactoryDate", item);
    }
    /**
     * Object:派车单's 实际到厂日期property 
     */
    public java.util.Date getActualReachDate()
    {
        return getDate("actualReachDate");
    }
    public void setActualReachDate(java.util.Date item)
    {
        setDate("actualReachDate", item);
    }
    /**
     * Object:派车单's 过磅码property 
     */
    public String getWeightNum()
    {
        return getString("weightNum");
    }
    public void setWeightNum(String item)
    {
        setString("weightNum", item);
    }
    /**
     * Object:派车单's 第一次过磅时间property 
     */
    public java.util.Date getTareFirstTime()
    {
        return getDate("tareFirstTime");
    }
    public void setTareFirstTime(java.util.Date item)
    {
        setDate("tareFirstTime", item);
    }
    /**
     * Object:派车单's 第二次过磅时间property 
     */
    public java.util.Date getTareSecondTime()
    {
        return getDate("tareSecondTime");
    }
    public void setTareSecondTime(java.util.Date item)
    {
        setDate("tareSecondTime", item);
    }
    /**
     * Object:派车单's 第一次过磅重量property 
     */
    public java.math.BigDecimal getTareFirstQty()
    {
        return getBigDecimal("tareFirstQty");
    }
    public void setTareFirstQty(java.math.BigDecimal item)
    {
        setBigDecimal("tareFirstQty", item);
    }
    /**
     * Object:派车单's 第二次过磅重量property 
     */
    public java.math.BigDecimal getTareSecondQty()
    {
        return getBigDecimal("tareSecondQty");
    }
    public void setTareSecondQty(java.math.BigDecimal item)
    {
        setBigDecimal("tareSecondQty", item);
    }
    /**
     * Object: 派车单 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:派车单's 标准里程数property 
     */
    public java.math.BigDecimal getStandardMileage()
    {
        return getBigDecimal("standardMileage");
    }
    public void setStandardMileage(java.math.BigDecimal item)
    {
        setBigDecimal("standardMileage", item);
    }
    /**
     * Object:派车单's 养殖场场长property 
     */
    public String getFarmer()
    {
        return getString("farmer");
    }
    public void setFarmer(String item)
    {
        setString("farmer", item);
    }
    /**
     * Object:派车单's 场长联系方式property 
     */
    public String getFarmerCell()
    {
        return getString("farmerCell");
    }
    public void setFarmerCell(String item)
    {
        setString("farmerCell", item);
    }
    /**
     * Object:派车单's 是否棚前property 
     */
    public boolean isHouseBefore()
    {
        return getBoolean("houseBefore");
    }
    public void setHouseBefore(boolean item)
    {
        setBoolean("houseBefore", item);
    }
    /**
     * Object:派车单's 回收筐数property 
     */
    public java.math.BigDecimal getBasketQty()
    {
        return getBigDecimal("basketQty");
    }
    public void setBasketQty(java.math.BigDecimal item)
    {
        setBigDecimal("basketQty", item);
    }
    /**
     * Object: 派车单 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object:派车单's 回收地址property 
     */
    public String getFarmAddress()
    {
        return getString("farmAddress");
    }
    public void setFarmAddress(String item)
    {
        setString("farmAddress", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1068EFAD");
    }
}