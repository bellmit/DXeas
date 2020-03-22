package com.kingdee.eas.custom.dx.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSettleBillInfo()
    {
        this("id");
    }
    protected AbstractSettleBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:毛鸡结算单's 是否生成凭证property 
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
     * Object:毛鸡结算单's 车牌property 
     */
    public String getCarNum()
    {
        return getString("carNum");
    }
    public void setCarNum(String item)
    {
        setString("carNum", item);
    }
    /**
     * Object: 毛鸡结算单 's 公司 property 
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
     * Object: 毛鸡结算单 's 派车单 property 
     */
    public com.kingdee.eas.custom.dx.weight.CarSendBillInfo getCarSend()
    {
        return (com.kingdee.eas.custom.dx.weight.CarSendBillInfo)get("CarSend");
    }
    public void setCarSend(com.kingdee.eas.custom.dx.weight.CarSendBillInfo item)
    {
        put("CarSend", item);
    }
    /**
     * Object:毛鸡结算单's 毛鸡数量property 
     */
    public java.math.BigDecimal getGrossQty()
    {
        return getBigDecimal("GrossQty");
    }
    public void setGrossQty(java.math.BigDecimal item)
    {
        setBigDecimal("GrossQty", item);
    }
    /**
     * Object:毛鸡结算单's 毛鸡重量property 
     */
    public java.math.BigDecimal getGrossWgt()
    {
        return getBigDecimal("GrossWgt");
    }
    public void setGrossWgt(java.math.BigDecimal item)
    {
        setBigDecimal("GrossWgt", item);
    }
    /**
     * Object:毛鸡结算单's 小鸡数量property 
     */
    public java.math.BigDecimal getSmChickenQty()
    {
        return getBigDecimal("SmChickenQty");
    }
    public void setSmChickenQty(java.math.BigDecimal item)
    {
        setBigDecimal("SmChickenQty", item);
    }
    /**
     * Object:毛鸡结算单's 小鸡重量property 
     */
    public java.math.BigDecimal getSmChickenWgt()
    {
        return getBigDecimal("SmChickenWgt");
    }
    public void setSmChickenWgt(java.math.BigDecimal item)
    {
        setBigDecimal("SmChickenWgt", item);
    }
    /**
     * Object:毛鸡结算单's 残鸡数量property 
     */
    public java.math.BigDecimal getCriChickenQty()
    {
        return getBigDecimal("CriChickenQty");
    }
    public void setCriChickenQty(java.math.BigDecimal item)
    {
        setBigDecimal("CriChickenQty", item);
    }
    /**
     * Object:毛鸡结算单's 残鸡重量property 
     */
    public java.math.BigDecimal getCriChickenWgt()
    {
        return getBigDecimal("CriChickenWgt");
    }
    public void setCriChickenWgt(java.math.BigDecimal item)
    {
        setBigDecimal("CriChickenWgt", item);
    }
    /**
     * Object:毛鸡结算单's 嗉子扣款property 
     */
    public java.math.BigDecimal getDeductionSZ()
    {
        return getBigDecimal("DeductionSZ");
    }
    public void setDeductionSZ(java.math.BigDecimal item)
    {
        setBigDecimal("DeductionSZ", item);
    }
    /**
     * Object:毛鸡结算单's 爪炎扣款property 
     */
    public java.math.BigDecimal getDeductionZY()
    {
        return getBigDecimal("DeductionZY");
    }
    public void setDeductionZY(java.math.BigDecimal item)
    {
        setBigDecimal("DeductionZY", item);
    }
    /**
     * Object:毛鸡结算单's 皮炎扣款property 
     */
    public java.math.BigDecimal getDeductionPY()
    {
        return getBigDecimal("DeductionPY");
    }
    public void setDeductionPY(java.math.BigDecimal item)
    {
        setBigDecimal("DeductionPY", item);
    }
    /**
     * Object:毛鸡结算单's 扣粪重量property 
     */
    public java.math.BigDecimal getDeductionKF()
    {
        return getBigDecimal("DeductionKF");
    }
    public void setDeductionKF(java.math.BigDecimal item)
    {
        setBigDecimal("DeductionKF", item);
    }
    /**
     * Object:毛鸡结算单's 单据状态property 
     */
    public com.kingdee.eas.custom.settlebill.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.settlebill.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.settlebill.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:毛鸡结算单's 养殖户结算金额property 
     */
    public java.math.BigDecimal getFarmAmount()
    {
        return getBigDecimal("farmAmount");
    }
    public void setFarmAmount(java.math.BigDecimal item)
    {
        setBigDecimal("farmAmount", item);
    }
    /**
     * Object:毛鸡结算单's 结算金额property 
     */
    public java.math.BigDecimal getSettleAmount()
    {
        return getBigDecimal("SettleAmount");
    }
    public void setSettleAmount(java.math.BigDecimal item)
    {
        setBigDecimal("SettleAmount", item);
    }
    /**
     * Object:毛鸡结算单's 运费property 
     */
    public java.math.BigDecimal getFrightAmount()
    {
        return getBigDecimal("FrightAmount");
    }
    public void setFrightAmount(java.math.BigDecimal item)
    {
        setBigDecimal("FrightAmount", item);
    }
    /**
     * Object: 毛鸡结算单 's 供应商 property 
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
     * Object:毛鸡结算单's 结算金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("Amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("Amount", item);
    }
    /**
     * Object:毛鸡结算单's 最终结算金额property 
     */
    public java.math.BigDecimal getFinlAmount()
    {
        return getBigDecimal("finlAmount");
    }
    public void setFinlAmount(java.math.BigDecimal item)
    {
        setBigDecimal("finlAmount", item);
    }
    /**
     * Object:毛鸡结算单's 运费2property 
     */
    public java.math.BigDecimal getFirghttwo()
    {
        return getBigDecimal("firghttwo");
    }
    public void setFirghttwo(java.math.BigDecimal item)
    {
        setBigDecimal("firghttwo", item);
    }
    /**
     * Object:毛鸡结算单's 付牧业结算金额property 
     */
    public java.math.BigDecimal getPyFarmAmount()
    {
        return getBigDecimal("PyFarmAmount");
    }
    public void setPyFarmAmount(java.math.BigDecimal item)
    {
        setBigDecimal("PyFarmAmount", item);
    }
    /**
     * Object:毛鸡结算单's 运费单价property 
     */
    public java.math.BigDecimal getFirghtprice()
    {
        return getBigDecimal("firghtprice");
    }
    public void setFirghtprice(java.math.BigDecimal item)
    {
        setBigDecimal("firghtprice", item);
    }
    /**
     * Object:毛鸡结算单's 其他扣罚property 
     */
    public java.math.BigDecimal getOtherAmount()
    {
        return getBigDecimal("OtherAmount");
    }
    public void setOtherAmount(java.math.BigDecimal item)
    {
        setBigDecimal("OtherAmount", item);
    }
    /**
     * Object:毛鸡结算单's 毛鸡价格property 
     */
    public java.math.BigDecimal getGrossPrice()
    {
        return getBigDecimal("GrossPrice");
    }
    public void setGrossPrice(java.math.BigDecimal item)
    {
        setBigDecimal("GrossPrice", item);
    }
    /**
     * Object:毛鸡结算单's 毛鸡均重property 
     */
    public java.math.BigDecimal getChickavwgt()
    {
        return getBigDecimal("chickavwgt");
    }
    public void setChickavwgt(java.math.BigDecimal item)
    {
        setBigDecimal("chickavwgt", item);
    }
    /**
     * Object:毛鸡结算单's 结算金额property 
     */
    public java.math.BigDecimal getReAmount()
    {
        return getBigDecimal("reAmount");
    }
    public void setReAmount(java.math.BigDecimal item)
    {
        setBigDecimal("reAmount", item);
    }
    /**
     * Object: 毛鸡结算单 's 司机 property 
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
     * Object:毛鸡结算单's 车主property 
     */
    public String getCarMaster()
    {
        return getString("carMaster");
    }
    public void setCarMaster(String item)
    {
        setString("carMaster", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("89940253");
    }
}