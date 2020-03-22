package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKFreightBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCKFreightBillInfo()
    {
        this("id");
    }
    protected AbstractCKFreightBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:ë���˷ѵ�'s �Ƿ�����ƾ֤property 
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
     * Object: ë���˷ѵ� 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:ë���˷ѵ�'s ����״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: ë���˷ѵ� 's ���� property 
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
     * Object: ë���˷ѵ� 's ˾�� property 
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
     * Object: ë���˷ѵ� 's Ʒ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object: ë���˷ѵ� 's ��ֳ�� property 
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
     * Object: ë���˷ѵ� 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object:ë���˷ѵ�'s ��������property 
     */
    public java.util.Date getRecDate()
    {
        return getDate("recDate");
    }
    public void setRecDate(java.util.Date item)
    {
        setDate("recDate", item);
    }
    /**
     * Object:ë���˷ѵ�'s �������property 
     */
    public java.math.BigDecimal getDistance()
    {
        return getBigDecimal("distance");
    }
    public void setDistance(java.math.BigDecimal item)
    {
        setBigDecimal("distance", item);
    }
    /**
     * Object:ë���˷ѵ�'s ���վ���property 
     */
    public java.math.BigDecimal getRecSuttle()
    {
        return getBigDecimal("recSuttle");
    }
    public void setRecSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("recSuttle", item);
    }
    /**
     * Object:ë���˷ѵ�'s ��������property 
     */
    public java.math.BigDecimal getCarcassWgt()
    {
        return getBigDecimal("carcassWgt");
    }
    public void setCarcassWgt(java.math.BigDecimal item)
    {
        setBigDecimal("carcassWgt", item);
    }
    /**
     * Object:ë���˷ѵ�'s �м�ֻ��property 
     */
    public int getInCompleteQty()
    {
        return getInt("inCompleteQty");
    }
    public void setInCompleteQty(int item)
    {
        setInt("inCompleteQty", item);
    }
    /**
     * Object:ë���˷ѵ�'s �м�����property 
     */
    public java.math.BigDecimal getInCompleteWgt()
    {
        return getBigDecimal("inCompleteWgt");
    }
    public void setInCompleteWgt(java.math.BigDecimal item)
    {
        setBigDecimal("inCompleteWgt", item);
    }
    /**
     * Object:ë���˷ѵ�'s �г���property 
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
     * Object:ë���˷ѵ�'s �������ճ�����(%)property 
     */
    public java.math.BigDecimal getDateFmRate()
    {
        return getBigDecimal("dateFmRate");
    }
    public void setDateFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("dateFmRate", item);
    }
    /**
     * Object:ë���˷ѵ�'s ��ë���˷�property 
     */
    public java.math.BigDecimal getDateCKFreight()
    {
        return getBigDecimal("dateCKFreight");
    }
    public void setDateCKFreight(java.math.BigDecimal item)
    {
        setBigDecimal("dateCKFreight", item);
    }
    /**
     * Object:ë���˷ѵ�'s �����ʵ���ϵ��(%)property 
     */
    public java.math.BigDecimal getDressingPercent()
    {
        return getBigDecimal("dressingPercent");
    }
    public void setDressingPercent(java.math.BigDecimal item)
    {
        setBigDecimal("dressingPercent", item);
    }
    /**
     * Object:ë���˷ѵ�'s ʵ��ë���˷�property 
     */
    public java.math.BigDecimal getActualCKFreight()
    {
        return getBigDecimal("actualCKFreight");
    }
    public void setActualCKFreight(java.math.BigDecimal item)
    {
        setBigDecimal("actualCKFreight", item);
    }
    /**
     * Object:ë���˷ѵ�'s ����Ѫ����(%)property 
     */
    public java.math.BigDecimal getCyxRate()
    {
        return getBigDecimal("cyxRate");
    }
    public void setCyxRate(java.math.BigDecimal item)
    {
        setBigDecimal("cyxRate", item);
    }
    /**
     * Object:ë���˷ѵ�'s ����Ѫ�۲�property 
     */
    public java.math.BigDecimal getCyxKbAmt()
    {
        return getBigDecimal("cyxKbAmt");
    }
    public void setCyxKbAmt(java.math.BigDecimal item)
    {
        setBigDecimal("cyxKbAmt", item);
    }
    /**
     * Object:ë���˷ѵ�'s �����۲���property 
     */
    public java.math.BigDecimal getOtherKbAmt()
    {
        return getBigDecimal("otherKbAmt");
    }
    public void setOtherKbAmt(java.math.BigDecimal item)
    {
        setBigDecimal("otherKbAmt", item);
    }
    /**
     * Object:ë���˷ѵ�'s ���������property 
     */
    public java.math.BigDecimal getAllFreight()
    {
        return getBigDecimal("allFreight");
    }
    public void setAllFreight(java.math.BigDecimal item)
    {
        setBigDecimal("allFreight", item);
    }
    /**
     * Object:ë���˷ѵ�'s �������property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: ë���˷ѵ� 's �ͻ� property 
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
     * Object: ë���˷ѵ� 's ��ֳ�� property 
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
     * Object: ë���˷ѵ� 's �˷Ѽ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo getCalUnit()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo)get("calUnit");
    }
    public void setCalUnit(com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo item)
    {
        put("calUnit", item);
    }
    /**
     * Object:ë���˷ѵ�'s ë������property 
     */
    public java.math.BigDecimal getAverageWgt()
    {
        return getBigDecimal("averageWgt");
    }
    public void setAverageWgt(java.math.BigDecimal item)
    {
        setBigDecimal("averageWgt", item);
    }
    /**
     * Object:ë���˷ѵ�'s ʵ�ʳ�����(%)property 
     */
    public java.math.BigDecimal getActualFmRate()
    {
        return getBigDecimal("actualFmRate");
    }
    public void setActualFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("actualFmRate", item);
    }
    /**
     * Object:ë���˷ѵ�'s ��ƽ��������(%)property 
     */
    public java.math.BigDecimal getMonthAveFmRate()
    {
        return getBigDecimal("monthAveFmRate");
    }
    public void setMonthAveFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("monthAveFmRate", item);
    }
    /**
     * Object:ë���˷ѵ�'s �ɳ�����������ֻ��property 
     */
    public int getPldiffQty()
    {
        return getInt("pldiffQty");
    }
    public void setPldiffQty(int item)
    {
        setInt("pldiffQty", item);
    }
    /**
     * Object:ë���˷ѵ�'s ���ٷ�property 
     */
    public java.math.BigDecimal getHighWayFee()
    {
        return getBigDecimal("highWayFee");
    }
    public void setHighWayFee(java.math.BigDecimal item)
    {
        setBigDecimal("highWayFee", item);
    }
    /**
     * Object:ë���˷ѵ�'s �ɳ�����������۲�property 
     */
    public java.math.BigDecimal getPldiffAmount()
    {
        return getBigDecimal("pldiffAmount");
    }
    public void setPldiffAmount(java.math.BigDecimal item)
    {
        setBigDecimal("pldiffAmount", item);
    }
    /**
     * Object:ë���˷ѵ�'s ����ֻ��property 
     */
    public int getRecQty()
    {
        return getInt("recQty");
    }
    public void setRecQty(int item)
    {
        setInt("recQty", item);
    }
    /**
     * Object:ë���˷ѵ�'s �����˷�property 
     */
    public java.math.BigDecimal getGrowthFreight()
    {
        return getBigDecimal("growthFreight");
    }
    public void setGrowthFreight(java.math.BigDecimal item)
    {
        setBigDecimal("growthFreight", item);
    }
    /**
     * Object:ë���˷ѵ�'s ��߳�����(%)property 
     */
    public java.math.BigDecimal getMaxFmRate()
    {
        return getBigDecimal("maxFmRate");
    }
    public void setMaxFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("maxFmRate", item);
    }
    /**
     * Object:ë���˷ѵ�'s ��׼������(%)property 
     */
    public java.math.BigDecimal getFmRateStd()
    {
        return getBigDecimal("fmRateStd");
    }
    public void setFmRateStd(java.math.BigDecimal item)
    {
        setBigDecimal("fmRateStd", item);
    }
    /**
     * Object:ë���˷ѵ�'s ����ֻ��property 
     */
    public int getCarcassQty()
    {
        return getInt("carcassQty");
    }
    public void setCarcassQty(int item)
    {
        setInt("carcassQty", item);
    }
    /**
     * Object:ë���˷ѵ�'s �¼����ó�����property 
     */
    public java.math.BigDecimal getMonthCalFmRate()
    {
        return getBigDecimal("monthCalFmRate");
    }
    public void setMonthCalFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("monthCalFmRate", item);
    }
    /**
     * Object:ë���˷ѵ�'s ������ϵ��property 
     */
    public java.math.BigDecimal getFmRateCoe()
    {
        return getBigDecimal("fmRateCoe");
    }
    public void setFmRateCoe(java.math.BigDecimal item)
    {
        setBigDecimal("fmRateCoe", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A9165033");
    }
}