package com.kingdee.eas.custom.settlebill;

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
        put("RewardPunish", new com.kingdee.eas.custom.settlebill.SettleBillRewardPunishCollection());
        put("AssEntrys", new com.kingdee.eas.custom.settlebill.SettleBillAssEntryCollection());
        put("entrys", new com.kingdee.eas.custom.settlebill.SettleBillEntryCollection());
        put("OtherEntrys", new com.kingdee.eas.custom.settlebill.SettleBillOtherEntryCollection());
        put("Subsidy", new com.kingdee.eas.custom.settlebill.SettleBillSubsidyCollection());
    }
    /**
     * Object: ���㵥 's �������Ϸ�¼ property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillEntryCollection)get("entrys");
    }
    /**
     * Object:���㵥's �Ƿ�����ƾ֤property 
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
     * Object: ���㵥 's �������Ϸ�¼ property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object: ���㵥 's �������Ϸ�¼ property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillOtherEntryCollection getOtherEntrys()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillOtherEntryCollection)get("OtherEntrys");
    }
    /**
     * Object: ���㵥 's ��Ƶ�λ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getAccountUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("accountUnit");
    }
    public void setAccountUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("accountUnit", item);
    }
    /**
     * Object: ���㵥 's ���� property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getDepartment()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("department");
    }
    public void setDepartment(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("department", item);
    }
    /**
     * Object: ���㵥 's ��ֳ�� property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getFarmer()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:���㵥's ��Լ����property 
     */
    public String getFlot()
    {
        return getString("flot");
    }
    public void setFlot(String item)
    {
        setString("flot", item);
    }
    /**
     * Object:���㵥's ��ֳ����property 
     */
    public String getPolicy()
    {
        return getString("policy");
    }
    public void setPolicy(String item)
    {
        setString("policy", item);
    }
    /**
     * Object: ���㵥 's ҵ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    /**
     * Object:���㵥's ������property 
     */
    public String getAgent()
    {
        return getString("agent");
    }
    public void setAgent(String item)
    {
        setString("agent", item);
    }
    /**
     * Object:���㵥's ���property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:���㵥's ��ɱ��property 
     */
    public String getSlaughterPlace()
    {
        return getString("slaughterPlace");
    }
    public void setSlaughterPlace(String item)
    {
        setString("slaughterPlace", item);
    }
    /**
     * Object:���㵥's ��Ѻ���property 
     */
    public java.math.BigDecimal getDepositAmt()
    {
        return getBigDecimal("depositAmt");
    }
    public void setDepositAmt(java.math.BigDecimal item)
    {
        setBigDecimal("depositAmt", item);
    }
    /**
     * Object: ���㵥 's ������Ŀ property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillRewardPunishCollection getRewardPunish()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillRewardPunishCollection)get("RewardPunish");
    }
    /**
     * Object: ���㵥 's ���� property 
     */
    public com.kingdee.eas.custom.settlebill.SettleBillSubsidyCollection getSubsidy()
    {
        return (com.kingdee.eas.custom.settlebill.SettleBillSubsidyCollection)get("Subsidy");
    }
    /**
     * Object:���㵥's �����property 
     */
    public java.math.BigDecimal getFeedToMeat()
    {
        return getBigDecimal("feedToMeat");
    }
    public void setFeedToMeat(java.math.BigDecimal item)
    {
        setBigDecimal("feedToMeat", item);
    }
    /**
     * Object:���㵥's �ɻ���property 
     */
    public java.math.BigDecimal getSurvivalRate()
    {
        return getBigDecimal("survivalRate");
    }
    public void setSurvivalRate(java.math.BigDecimal item)
    {
        setBigDecimal("survivalRate", item);
    }
    /**
     * Object:���㵥's ֻ��ҩproperty 
     */
    public java.math.BigDecimal getMedicineUsage()
    {
        return getBigDecimal("medicineUsage");
    }
    public void setMedicineUsage(java.math.BigDecimal item)
    {
        setBigDecimal("medicineUsage", item);
    }
    /**
     * Object:���㵥's ���ɱ�׼property 
     */
    public java.math.BigDecimal getDisinfectant()
    {
        return getBigDecimal("disinfectant");
    }
    public void setDisinfectant(java.math.BigDecimal item)
    {
        setBigDecimal("disinfectant", item);
    }
    /**
     * Object:���㵥's ���Ͻ��property 
     */
    public java.math.BigDecimal getFeedingAmt()
    {
        return getBigDecimal("feedingAmt");
    }
    public void setFeedingAmt(java.math.BigDecimal item)
    {
        setBigDecimal("feedingAmt", item);
    }
    /**
     * Object:���㵥's ҩƷ���property 
     */
    public java.math.BigDecimal getMedicineAmt()
    {
        return getBigDecimal("medicineAmt");
    }
    public void setMedicineAmt(java.math.BigDecimal item)
    {
        setBigDecimal("medicineAmt", item);
    }
    /**
     * Object:���㵥's Ӧ�����property 
     */
    public java.math.BigDecimal getOtherAmt()
    {
        return getBigDecimal("otherAmt");
    }
    public void setOtherAmt(java.math.BigDecimal item)
    {
        setBigDecimal("otherAmt", item);
    }
    /**
     * Object:���㵥's ֻ��property 
     */
    public java.math.BigDecimal getUnitWeight()
    {
        return getBigDecimal("unitWeight");
    }
    public void setUnitWeight(java.math.BigDecimal item)
    {
        setBigDecimal("unitWeight", item);
    }
    /**
     * Object:���㵥's ����property 
     */
    public int getDayAge()
    {
        return getInt("dayAge");
    }
    public void setDayAge(int item)
    {
        setInt("dayAge", item);
    }
    /**
     * Object:���㵥's ����ҩ�ܽ��property 
     */
    public java.math.BigDecimal getTotalAmt()
    {
        return getBigDecimal("totalAmt");
    }
    public void setTotalAmt(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmt", item);
    }
    /**
     * Object:���㵥's ����Ӧ�����property 
     */
    public java.math.BigDecimal getUnitAmt()
    {
        return getBigDecimal("unitAmt");
    }
    public void setUnitAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unitAmt", item);
    }
    /**
     * Object:���㵥's ���ճɱ����property 
     */
    public java.math.BigDecimal getRebackCostAmt()
    {
        return getBigDecimal("rebackCostAmt");
    }
    public void setRebackCostAmt(java.math.BigDecimal item)
    {
        setBigDecimal("rebackCostAmt", item);
    }
    /**
     * Object:���㵥's ʵ�ʼ��㵥��property 
     */
    public java.math.BigDecimal getRebackCostPrice()
    {
        return getBigDecimal("rebackCostPrice");
    }
    public void setRebackCostPrice(java.math.BigDecimal item)
    {
        setBigDecimal("rebackCostPrice", item);
    }
    /**
     * Object:���㵥's ëѼ���ۼ۸�property 
     */
    public java.math.BigDecimal getGrossDuckSalePrice()
    {
        return getBigDecimal("grossDuckSalePrice");
    }
    public void setGrossDuckSalePrice(java.math.BigDecimal item)
    {
        setBigDecimal("grossDuckSalePrice", item);
    }
    /**
     * Object:���㵥's ��̯�ɱ�property 
     */
    public java.math.BigDecimal getCostPerByKG()
    {
        return getBigDecimal("costPerByKG");
    }
    public void setCostPerByKG(java.math.BigDecimal item)
    {
        setBigDecimal("costPerByKG", item);
    }
    /**
     * Object:���㵥's ֻ��ʳ��property 
     */
    public java.math.BigDecimal getUnitEatQty()
    {
        return getBigDecimal("unitEatQty");
    }
    public void setUnitEatQty(java.math.BigDecimal item)
    {
        setBigDecimal("unitEatQty", item);
    }
    /**
     * Object:���㵥's ������property 
     */
    public java.math.BigDecimal getYieldRate()
    {
        return getBigDecimal("yieldRate");
    }
    public void setYieldRate(java.math.BigDecimal item)
    {
        setBigDecimal("yieldRate", item);
    }
    /**
     * Object:���㵥's ������property 
     */
    public java.math.BigDecimal getChickAmt()
    {
        return getBigDecimal("chickAmt");
    }
    public void setChickAmt(java.math.BigDecimal item)
    {
        setBigDecimal("chickAmt", item);
    }
    /**
     * Object:���㵥's ժҪproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:���㵥's ũ��property 
     */
    public String getFarm()
    {
        return getString("farm");
    }
    public void setFarm(String item)
    {
        setString("farm", item);
    }
    /**
     * Object:���㵥's ����״̬property 
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
     * Object:���㵥's Ѽ��ɱ����property 
     */
    public java.math.BigDecimal getChickCostAmt()
    {
        return getBigDecimal("chickCostAmt");
    }
    public void setChickCostAmt(java.math.BigDecimal item)
    {
        setBigDecimal("chickCostAmt", item);
    }
    /**
     * Object:���㵥's ҩƷ�ɱ����property 
     */
    public java.math.BigDecimal getDrugCostAmt()
    {
        return getBigDecimal("drugCostAmt");
    }
    public void setDrugCostAmt(java.math.BigDecimal item)
    {
        setBigDecimal("drugCostAmt", item);
    }
    /**
     * Object:���㵥's ���ϳɱ����property 
     */
    public java.math.BigDecimal getFeedCostAmt()
    {
        return getBigDecimal("feedCostAmt");
    }
    public void setFeedCostAmt(java.math.BigDecimal item)
    {
        setBigDecimal("feedCostAmt", item);
    }
    /**
     * Object:���㵥's ��������property 
     */
    public java.math.BigDecimal getFeedBaseQty()
    {
        return getBigDecimal("feedBaseQty");
    }
    public void setFeedBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("feedBaseQty", item);
    }
    /**
     * Object:���㵥's Ѽ������property 
     */
    public java.math.BigDecimal getChickQty()
    {
        return getBigDecimal("chickQty");
    }
    public void setChickQty(java.math.BigDecimal item)
    {
        setBigDecimal("chickQty", item);
    }
    /**
     * Object:���㵥's ���ͽ����˷�property 
     */
    public java.math.BigDecimal getTotalAmt_1()
    {
        return getBigDecimal("totalAmt_1");
    }
    public void setTotalAmt_1(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmt_1", item);
    }
    /**
     * Object:���㵥's ʵ�ʳ�����property 
     */
    public java.math.BigDecimal getFeedToMeat_1()
    {
        return getBigDecimal("feedToMeat_1");
    }
    public void setFeedToMeat_1(java.math.BigDecimal item)
    {
        setBigDecimal("feedToMeat_1", item);
    }
    /**
     * Object:���㵥's ��׼������property 
     */
    public java.math.BigDecimal getFeedToMeat_2()
    {
        return getBigDecimal("feedToMeat_2");
    }
    public void setFeedToMeat_2(java.math.BigDecimal item)
    {
        setBigDecimal("feedToMeat_2", item);
    }
    /**
     * Object:���㵥's ֻ��property 
     */
    public java.math.BigDecimal getUnitEatQty_1()
    {
        return getBigDecimal("unitEatQty_1");
    }
    public void setUnitEatQty_1(java.math.BigDecimal item)
    {
        setBigDecimal("unitEatQty_1", item);
    }
    /**
     * Object:���㵥's ��������property 
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
     * Object: ���㵥 's �ɳ����� property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarSendBillInfo getSendCars()
    {
        return (com.kingdee.eas.custom.taihe.weight.CarSendBillInfo)get("sendCars");
    }
    public void setSendCars(com.kingdee.eas.custom.taihe.weight.CarSendBillInfo item)
    {
        put("sendCars", item);
    }
    /**
     * Object: ���㵥 's ���κ�ͬ property 
     */
    public com.kingdee.eas.custom.taihe.contract.BatchContractInfo getBatchContract()
    {
        return (com.kingdee.eas.custom.taihe.contract.BatchContractInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.custom.taihe.contract.BatchContractInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: ���㵥 's ������ͬ property 
     */
    public com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo getSeriousContract()
    {
        return (com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo)get("seriousContract");
    }
    public void setSeriousContract(com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo item)
    {
        put("seriousContract", item);
    }
    /**
     * Object: ���㵥 's ��ͬ���� property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractTypeInfo getContractType()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractTypeInfo)get("contractType");
    }
    public void setContractType(com.kingdee.eas.custom.signwasthetable.ContractTypeInfo item)
    {
        put("contractType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B689EA3");
    }
}