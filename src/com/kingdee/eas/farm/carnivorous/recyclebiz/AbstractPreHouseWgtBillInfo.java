package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPreHouseWgtBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPreHouseWgtBillInfo()
    {
        this("id");
    }
    protected AbstractPreHouseWgtBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��ǰ������'s �Ƿ�����ƾ֤property 
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
     * Object: ��ǰ������ 's ������֯ property 
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
     * Object:��ǰ������'s ���ʱ��property 
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
     * Object: ��ǰ������ 's ��ֳ�� property 
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
     * Object: ��ǰ������ 's ��ֳ�� property 
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
     * Object: ��ǰ������ 's ���κ�ͬ property 
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
     * Object: ��ǰ������ 's ��ֳ���� property 
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
     * Object:��ǰ������'s ����״̬property 
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
     * Object: ��ǰ������ 's �������� property 
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
     * Object:��ǰ������'s ��������property 
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
     * Object:��ǰ������'s ��������property 
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
     * Object: ��ǰ������ 's ҵ��Ա property 
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
     * Object:��ǰ������'s ��ֳ����ַproperty 
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
     * Object:��ǰ������'s ��ֳģʽproperty 
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
     * Object:��ǰ������'s ��������property 
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
     * Object: ��ǰ������ 's �ͻ� property 
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
     * Object:��ǰ������'s ��ֳ����ϵ��ʽproperty 
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
     * Object: ��ǰ������ 's Ʒ�� property 
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
     * Object:��ǰ������'s �����۸�property 
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
     * Object: ��ǰ������ 's ���� property 
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
     * Object: ��ǰ������ 's ˾�� property 
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
     * Object:��ǰ������'s ˾����ϵ��ʽproperty 
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
     * Object:��ǰ������'s ��ǰֻ��property 
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
     * Object:��ǰ������'s ��˾����ë��property 
     */
    public java.math.BigDecimal getCompanyWgtGross()
    {
        return getBigDecimal("companyWgtGross");
    }
    public void setCompanyWgtGross(java.math.BigDecimal item)
    {
        setBigDecimal("companyWgtGross", item);
    }
    /**
     * Object:��ǰ������'s ��˾����Ƥ��property 
     */
    public java.math.BigDecimal getCompanyWgtTare()
    {
        return getBigDecimal("companyWgtTare");
    }
    public void setCompanyWgtTare(java.math.BigDecimal item)
    {
        setBigDecimal("companyWgtTare", item);
    }
    /**
     * Object:��ǰ������'s ��˾��������property 
     */
    public java.math.BigDecimal getCompanyWgtSuttle()
    {
        return getBigDecimal("companyWgtSuttle");
    }
    public void setCompanyWgtSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("companyWgtSuttle", item);
    }
    /**
     * Object:��ǰ������'s ��ǰ����property 
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
     * Object:��ǰ������'s ��ǰƤ��property 
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
     * Object:��ǰ������'s ��ǰë��property 
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
     * Object:��ǰ������'s �Ƿ��������׵�property 
     */
    public boolean isIsHasTuZai()
    {
        return getBoolean("isHasTuZai");
    }
    public void setIsHasTuZai(boolean item)
    {
        setBoolean("isHasTuZai", item);
    }
    /**
     * Object:��ǰ������'s �ɳ�˳��property 
     */
    public int getSeq()
    {
        return getInt("seq");
    }
    public void setSeq(int item)
    {
        setInt("seq", item);
    }
    /**
     * Object:��ǰ������'s Ӧ����ʱ��property 
     */
    public java.util.Date getArriveTime()
    {
        return getDate("arriveTime");
    }
    public void setArriveTime(java.util.Date item)
    {
        setDate("arriveTime", item);
    }
    /**
     * Object:��ǰ������'s ʵ�ʵ���ʱ��property 
     */
    public java.util.Date getActualArriveTime()
    {
        return getDate("actualArriveTime");
    }
    public void setActualArriveTime(java.util.Date item)
    {
        setDate("actualArriveTime", item);
    }
    /**
     * Object:��ǰ������'s �������property 
     */
    public java.math.BigDecimal getOutSaleAmt()
    {
        return getBigDecimal("outSaleAmt");
    }
    public void setOutSaleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("outSaleAmt", item);
    }
    /**
     * Object:��ǰ������'s �Ƿ�����������ⵥproperty 
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
     * Object:��ǰ������'s �Ƿ��������۳��ⵥproperty 
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
     * Object:��ǰ������'s ����ֻ��property 
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
     * Object:��ǰ������'s ���㾻��property 
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
     * Object:��ǰ������'s �����ɽ��㵥property 
     */
    public boolean isIsSettled()
    {
        return getBoolean("isSettled");
    }
    public void setIsSettled(boolean item)
    {
        setBoolean("isSettled", item);
    }
    /**
     * Object:��ǰ������'s ���վ���property 
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
     * Object:��ǰ������'s ��Դproperty 
     */
    public String getSeedSource()
    {
        return getString("seedSource");
    }
    public void setSeedSource(String item)
    {
        setString("seedSource", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CF04EA91");
    }
}