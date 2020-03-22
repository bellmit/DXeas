package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCSlaughterBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCSlaughterBillInfo()
    {
        this("id");
    }
    protected AbstractCSlaughterBillInfo(String pkField)
    {
        super(pkField);
        put("QCEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryCollection());
    }
    /**
     * Object:���׵�'s �Ƿ�����ƾ֤property 
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
     * Object: ���׵� 's ������֯ property 
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
     * Object:���׵�'s ���ʱ��property 
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
     * Object: ���׵� 's ��ֳ�� property 
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
     * Object: ���׵� 's ��ֳ�� property 
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
     * Object: ���׵� 's ���κ�ͬ property 
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
     * Object: ���׵� 's ��ֳ���� property 
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
     * Object:���׵�'s ����״̬property 
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
     * Object: ���׵� 's �������� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object:���׵�'s ��������property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:���׵�'s ��������property 
     */
    public java.math.BigDecimal getBatchQty()
    {
        return getBigDecimal("batchQty");
    }
    public void setBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("batchQty", item);
    }
    /**
     * Object: ���׵� 's ҵ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:���׵�'s ��ֳ����ַproperty 
     */
    public String getFarmAddress()
    {
        return getString("farmAddress");
    }
    public void setFarmAddress(String item)
    {
        setString("farmAddress", item);
    }
    /**
     * Object:���׵�'s ��ֳģʽproperty 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmsType getFarmType()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmsType.getEnum(getString("farmType"));
    }
    public void setFarmType(com.kingdee.eas.farm.stocking.basedata.FarmsType item)
    {
		if (item != null) {
        setString("farmType", item.getValue());
		}
    }
    /**
     * Object:���׵�'s ��������property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType getSaleType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType.getEnum(getString("saleType"));
    }
    public void setSaleType(com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType item)
    {
		if (item != null) {
        setString("saleType", item.getValue());
		}
    }
    /**
     * Object: ���׵� 's �ͻ� property 
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
     * Object:���׵�'s ��ֳ����ϵ��ʽproperty 
     */
    public String getFarmerPhone()
    {
        return getString("farmerPhone");
    }
    public void setFarmerPhone(String item)
    {
        setString("farmerPhone", item);
    }
    /**
     * Object: ���׵� 's Ʒ�� property 
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
     * Object:���׵�'s �����۸�property 
     */
    public java.math.BigDecimal getOutSalePrice()
    {
        return getBigDecimal("outSalePrice");
    }
    public void setOutSalePrice(java.math.BigDecimal item)
    {
        setBigDecimal("outSalePrice", item);
    }
    /**
     * Object: ���׵� 's ���� property 
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
     * Object: ���׵� 's ˾�� property 
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
     * Object:���׵�'s ˾����ϵ��ʽproperty 
     */
    public String getDriverPhone()
    {
        return getString("driverPhone");
    }
    public void setDriverPhone(String item)
    {
        setString("driverPhone", item);
    }
    /**
     * Object:���׵�'s ��ǰֻ��property 
     */
    public int getPreHouseQty()
    {
        return getInt("preHouseQty");
    }
    public void setPreHouseQty(int item)
    {
        setInt("preHouseQty", item);
    }
    /**
     * Object:���׵�'s ����ֻ��property 
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
     * Object:���׵�'s ��������property 
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
     * Object:���׵�'s �м�ֻ��property 
     */
    public int getIncompleteQty()
    {
        return getInt("incompleteQty");
    }
    public void setIncompleteQty(int item)
    {
        setInt("incompleteQty", item);
    }
    /**
     * Object:���׵�'s �м�����property 
     */
    public java.math.BigDecimal getIncompleteWgt()
    {
        return getBigDecimal("incompleteWgt");
    }
    public void setIncompleteWgt(java.math.BigDecimal item)
    {
        setBigDecimal("incompleteWgt", item);
    }
    /**
     * Object:���׵�'s ë������property 
     */
    public java.math.BigDecimal getCAverageWgt()
    {
        return getBigDecimal("cAverageWgt");
    }
    public void setCAverageWgt(java.math.BigDecimal item)
    {
        setBigDecimal("cAverageWgt", item);
    }
    /**
     * Object:���׵�'s �м���(%)property 
     */
    public java.math.BigDecimal getIncompleteRate()
    {
        return getBigDecimal("incompleteRate");
    }
    public void setIncompleteRate(java.math.BigDecimal item)
    {
        setBigDecimal("incompleteRate", item);
    }
    /**
     * Object:���׵�'s ����ֻ��property 
     */
    public int getDiffQty()
    {
        return getInt("diffQty");
    }
    public void setDiffQty(int item)
    {
        setInt("diffQty", item);
    }
    /**
     * Object:���׵�'s ��ǰ����property 
     */
    public java.math.BigDecimal getPreHouseSuttle()
    {
        return getBigDecimal("preHouseSuttle");
    }
    public void setPreHouseSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseSuttle", item);
    }
    /**
     * Object:���׵�'s ������(%)property 
     */
    public java.math.BigDecimal getMeatRate()
    {
        return getBigDecimal("meatRate");
    }
    public void setMeatRate(java.math.BigDecimal item)
    {
        setBigDecimal("meatRate", item);
    }
    /**
     * Object:���׵�'s ����ֻ��property 
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
     * Object: ���׵� 's �ʼ�۷���¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryCollection getQCEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryCollection)get("QCEntrys");
    }
    /**
     * Object:���׵�'s �۷��ܽ��property 
     */
    public java.math.BigDecimal getPunishAmt()
    {
        return getBigDecimal("punishAmt");
    }
    public void setPunishAmt(java.math.BigDecimal item)
    {
        setBigDecimal("punishAmt", item);
    }
    /**
     * Object:���׵�'s �۷�������(kg)property 
     */
    public java.math.BigDecimal getPunishWgt()
    {
        return getBigDecimal("punishWgt");
    }
    public void setPunishWgt(java.math.BigDecimal item)
    {
        setBigDecimal("punishWgt", item);
    }
    /**
     * Object:���׵�'s ��������property 
     */
    public java.math.BigDecimal getSettleWgt()
    {
        return getBigDecimal("settleWgt");
    }
    public void setSettleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("settleWgt", item);
    }
    /**
     * Object:���׵�'s ��ǰë��property 
     */
    public java.math.BigDecimal getPreHouseGross()
    {
        return getBigDecimal("preHouseGross");
    }
    public void setPreHouseGross(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseGross", item);
    }
    /**
     * Object:���׵�'s ��ǰƤ��property 
     */
    public java.math.BigDecimal getPreHouseTare()
    {
        return getBigDecimal("preHouseTare");
    }
    public void setPreHouseTare(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseTare", item);
    }
    /**
     * Object:���׵�'s �Ƿ������������property 
     */
    public boolean isIsHasShengChanRK()
    {
        return getBoolean("isHasShengChanRK");
    }
    public void setIsHasShengChanRK(boolean item)
    {
        setBoolean("isHasShengChanRK", item);
    }
    /**
     * Object:���׵�'s �Ƿ��������۳���property 
     */
    public boolean isIsHasSaleIssue()
    {
        return getBoolean("isHasSaleIssue");
    }
    public void setIsHasSaleIssue(boolean item)
    {
        setBoolean("isHasSaleIssue", item);
    }
    /**
     * Object:���׵�'s ��ë����property 
     */
    public int getDiffChickenQty()
    {
        return getInt("diffChickenQty");
    }
    public void setDiffChickenQty(int item)
    {
        setInt("diffChickenQty", item);
    }
    /**
     * Object:���׵�'s ������ϵ��property 
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
     * Object:���׵�'s ��˾����ë��property 
     */
    public java.math.BigDecimal getCompanyGross()
    {
        return getBigDecimal("companyGross");
    }
    public void setCompanyGross(java.math.BigDecimal item)
    {
        setBigDecimal("companyGross", item);
    }
    /**
     * Object:���׵�'s ��˾����Ƥ��property 
     */
    public java.math.BigDecimal getCompanyTare()
    {
        return getBigDecimal("companyTare");
    }
    public void setCompanyTare(java.math.BigDecimal item)
    {
        setBigDecimal("companyTare", item);
    }
    /**
     * Object:���׵�'s ��˾��������property 
     */
    public java.math.BigDecimal getCompanySuttle()
    {
        return getBigDecimal("companySuttle");
    }
    public void setCompanySuttle(java.math.BigDecimal item)
    {
        setBigDecimal("companySuttle", item);
    }
    /**
     * Object: ���׵� 's �˷Ѽ���� property 
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
     * Object:���׵�'s �Ƿ�����ë���˷ѵ�property 
     */
    public boolean isHasFreightBill()
    {
        return getBoolean("hasFreightBill");
    }
    public void setHasFreightBill(boolean item)
    {
        setBoolean("hasFreightBill", item);
    }
    /**
     * Object: ���׵� 's ץ���� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.CatchCKTeamInfo getCatchCKTeam()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.CatchCKTeamInfo)get("catchCKTeam");
    }
    public void setCatchCKTeam(com.kingdee.eas.farm.carnivorous.basedata.CatchCKTeamInfo item)
    {
        put("catchCKTeam", item);
    }
    /**
     * Object:���׵�'s �Ƿ��Զ�����property 
     */
    public boolean isWeighed()
    {
        return getBoolean("weighed");
    }
    public void setWeighed(boolean item)
    {
        setBoolean("weighed", item);
    }
    /**
     * Object:���׵�'s ��������property 
     */
    public String getWeighBillNum()
    {
        return getString("weighBillNum");
    }
    public void setWeighBillNum(String item)
    {
        setString("weighBillNum", item);
    }
    /**
     * Object:���׵�'s �Ƿ��������ϳ���property 
     */
    public boolean isHasLLCK()
    {
        return getBoolean("hasLLCK");
    }
    public void setHasLLCK(boolean item)
    {
        setBoolean("hasLLCK", item);
    }
    /**
     * Object:���׵�'s �Ƿ�������������property 
     */
    public boolean isHasQTCK()
    {
        return getBoolean("hasQTCK");
    }
    public void setHasQTCK(boolean item)
    {
        setBoolean("hasQTCK", item);
    }
    /**
     * Object:���׵�'s ����ֻ��property 
     */
    public java.math.BigDecimal getReceQty()
    {
        return getBigDecimal("receQty");
    }
    public void setReceQty(java.math.BigDecimal item)
    {
        setBigDecimal("receQty", item);
    }
    /**
     * Object:���׵�'s A��ֻ��property 
     */
    public java.math.BigDecimal getAQty()
    {
        return getBigDecimal("AQty");
    }
    public void setAQty(java.math.BigDecimal item)
    {
        setBigDecimal("AQty", item);
    }
    /**
     * Object:���׵�'s B��ֻ��property 
     */
    public java.math.BigDecimal getBQty()
    {
        return getBigDecimal("BQty");
    }
    public void setBQty(java.math.BigDecimal item)
    {
        setBigDecimal("BQty", item);
    }
    /**
     * Object:���׵�'s B������property 
     */
    public java.math.BigDecimal getBWeight()
    {
        return getBigDecimal("BWeight");
    }
    public void setBWeight(java.math.BigDecimal item)
    {
        setBigDecimal("BWeight", item);
    }
    /**
     * Object:���׵�'s ����������(kg)property 
     */
    public java.math.BigDecimal getReturnWeight()
    {
        return getBigDecimal("returnWeight");
    }
    public void setReturnWeight(java.math.BigDecimal item)
    {
        setBigDecimal("returnWeight", item);
    }
    /**
     * Object:���׵�'s A������property 
     */
    public java.math.BigDecimal getAWeight()
    {
        return getBigDecimal("AWeight");
    }
    public void setAWeight(java.math.BigDecimal item)
    {
        setBigDecimal("AWeight", item);
    }
    /**
     * Object:���׵�'s �Ƿ񱸰���property 
     */
    public boolean isIsPrepare()
    {
        return getBoolean("isPrepare");
    }
    public void setIsPrepare(boolean item)
    {
        setBoolean("isPrepare", item);
    }
    /**
     * Object: ���׵� 's ë�������� property 
     */
    public com.kingdee.eas.weighbridge.InStorageBillInfo getChicWeighr()
    {
        return (com.kingdee.eas.weighbridge.InStorageBillInfo)get("chicWeighr");
    }
    public void setChicWeighr(com.kingdee.eas.weighbridge.InStorageBillInfo item)
    {
        put("chicWeighr", item);
    }
    /**
     * Object:���׵�'s ë������������property 
     */
    public String getF7Number()
    {
        return getString("F7Number");
    }
    public void setF7Number(String item)
    {
        setString("F7Number", item);
    }
    /**
     * Object:���׵�'s ë��������idproperty 
     */
    public String getF7id()
    {
        return getString("F7id");
    }
    public void setF7id(String item)
    {
        setString("F7id", item);
    }
    /**
     * Object:���׵�'s ��������property 
     */
    public java.math.BigDecimal getSettleWeight()
    {
        return getBigDecimal("settleWeight");
    }
    public void setSettleWeight(java.math.BigDecimal item)
    {
        setBigDecimal("settleWeight", item);
    }
    /**
     * Object:���׵�'s �Ƿ�����������property 
     */
    public boolean isIsManRec()
    {
        return getBoolean("isManRec");
    }
    public void setIsManRec(boolean item)
    {
        setBoolean("isManRec", item);
    }
    /**
     * Object:���׵�'s �Ƿ��������۳�property 
     */
    public boolean isIsSaleOut()
    {
        return getBoolean("isSaleOut");
    }
    public void setIsSaleOut(boolean item)
    {
        setBoolean("isSaleOut", item);
    }
    /**
     * Object:���׵�'s ƽ��ֻ��property 
     */
    public java.math.BigDecimal getAvgWeight()
    {
        return getBigDecimal("avgWeight");
    }
    public void setAvgWeight(java.math.BigDecimal item)
    {
        setBigDecimal("avgWeight", item);
    }
    /**
     * Object: ���׵� 's �ɱ����� property 
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
     * Object:���׵�'s ����ֻ��property 
     */
    public java.math.BigDecimal getDeathQty()
    {
        return getBigDecimal("deathQty");
    }
    public void setDeathQty(java.math.BigDecimal item)
    {
        setBigDecimal("deathQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5A968454");
    }
}