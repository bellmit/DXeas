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
     * Object:ë�����㵥's �Ƿ�����ƾ֤property 
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
     * Object:ë�����㵥's ����property 
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
     * Object: ë�����㵥 's ��˾ property 
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
     * Object: ë�����㵥 's �ɳ��� property 
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
     * Object:ë�����㵥's ë������property 
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
     * Object:ë�����㵥's ë������property 
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
     * Object:ë�����㵥's С������property 
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
     * Object:ë�����㵥's С������property 
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
     * Object:ë�����㵥's �м�����property 
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
     * Object:ë�����㵥's �м�����property 
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
     * Object:ë�����㵥's ��ӿۿ�property 
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
     * Object:ë�����㵥's צ�׿ۿ�property 
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
     * Object:ë�����㵥's Ƥ�׿ۿ�property 
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
     * Object:ë�����㵥's �۷�����property 
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
     * Object:ë�����㵥's ����״̬property 
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
     * Object:ë�����㵥's ��ֳ��������property 
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
     * Object:ë�����㵥's ������property 
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
     * Object:ë�����㵥's �˷�property 
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
     * Object: ë�����㵥 's ��Ӧ�� property 
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
     * Object:ë�����㵥's ������property 
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
     * Object:ë�����㵥's ���ս�����property 
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
     * Object:ë�����㵥's �˷�2property 
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
     * Object:ë�����㵥's ����ҵ������property 
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
     * Object:ë�����㵥's �˷ѵ���property 
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
     * Object:ë�����㵥's �����۷�property 
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
     * Object:ë�����㵥's ë���۸�property 
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
     * Object:ë�����㵥's ë������property 
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
     * Object:ë�����㵥's ������property 
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
     * Object: ë�����㵥 's ˾�� property 
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
     * Object:ë�����㵥's ����property 
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