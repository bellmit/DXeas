package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractSettleBillInfo()
    {
        this("id");
    }
    protected AbstractSettleBillInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.custom.taihe.settle.SettleBillAssEntryCollection());
        put("entrys", new com.kingdee.eas.custom.taihe.settle.SettleBillEntryCollection());
        put("OtherEntrys", new com.kingdee.eas.custom.taihe.settle.SettleBillOtherEntryCollection());
    }
    /**
     * Object: ���㵥 's ������ϸ property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleBillEntryCollection)get("entrys");
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
     * Object: ���㵥 's ������ϸ property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleBillAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleBillAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object: ���㵥 's ���� property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleBillOtherEntryCollection getOtherEntrys()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleBillOtherEntryCollection)get("OtherEntrys");
    }
    /**
     * Object: ���㵥 's ��˾ property 
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
     * Object:���㵥's �չ���ʽproperty 
     */
    public com.kingdee.eas.custom.taihe.weight.PurchaseMethod getPurchaseMthod()
    {
        return com.kingdee.eas.custom.taihe.weight.PurchaseMethod.getEnum(getString("purchaseMthod"));
    }
    public void setPurchaseMthod(com.kingdee.eas.custom.taihe.weight.PurchaseMethod item)
    {
		if (item != null) {
        setString("purchaseMthod", item.getValue());
		}
    }
    /**
     * Object:���㵥's �չ�����property 
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
     * Object: ���㵥 's �ɳ��� property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarSendBillInfo getCarSendBill()
    {
        return (com.kingdee.eas.custom.taihe.weight.CarSendBillInfo)get("carSendBill");
    }
    public void setCarSendBill(com.kingdee.eas.custom.taihe.weight.CarSendBillInfo item)
    {
        put("carSendBill", item);
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
    public com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo getSuccessiveContract()
    {
        return (com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo)get("successiveContract");
    }
    public void setSuccessiveContract(com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo item)
    {
        put("successiveContract", item);
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
    /**
     * Object:���㵥's �չ�����property 
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
     * Object: ���㵥 's ԭ��Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOriginMtrialPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("originMtrialPerson");
    }
    public void setOriginMtrialPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("originMtrialPerson", item);
    }
    /**
     * Object: ���㵥 's �ҷ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getPartyB()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("partyB");
    }
    public void setPartyB(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("partyB", item);
    }
    /**
     * Object:���㵥's �ҷ����֤����property 
     */
    public String getIDCardNo()
    {
        return getString("iDCardNo");
    }
    public void setIDCardNo(String item)
    {
        setString("iDCardNo", item);
    }
    /**
     * Object:���㵥's �ҷ��տ�����property 
     */
    public String getAccountBank()
    {
        return getString("accountBank");
    }
    public void setAccountBank(String item)
    {
        setString("accountBank", item);
    }
    /**
     * Object:���㵥's �ҷ������˺�property 
     */
    public String getBankAccount()
    {
        return getString("bankAccount");
    }
    public void setBankAccount(String item)
    {
        setString("bankAccount", item);
    }
    /**
     * Object: ���㵥 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:���㵥's ����property 
     */
    public String getFarmMnger()
    {
        return getString("farmMnger");
    }
    public void setFarmMnger(String item)
    {
        setString("farmMnger", item);
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
     * Object:���㵥's ����property 
     */
    public String getDayAge()
    {
        return getString("dayAge");
    }
    public void setDayAge(String item)
    {
        setString("dayAge", item);
    }
    /**
     * Object:���㵥's ��׼���property 
     */
    public java.math.BigDecimal getStdMiles()
    {
        return getBigDecimal("stdMiles");
    }
    public void setStdMiles(java.math.BigDecimal item)
    {
        setBigDecimal("stdMiles", item);
    }
    /**
     * Object:���㵥's ʵ�����property 
     */
    public java.math.BigDecimal getActualMiles()
    {
        return getBigDecimal("actualMiles");
    }
    public void setActualMiles(java.math.BigDecimal item)
    {
        setBigDecimal("actualMiles", item);
    }
    /**
     * Object:���㵥's ��׼�˷ѵ���property 
     */
    public java.math.BigDecimal getStdFrePrice()
    {
        return getBigDecimal("stdFrePrice");
    }
    public void setStdFrePrice(java.math.BigDecimal item)
    {
        setBigDecimal("stdFrePrice", item);
    }
    /**
     * Object:���㵥's �����˷�property 
     */
    public java.math.BigDecimal getSuppFreAmt()
    {
        return getBigDecimal("suppFreAmt");
    }
    public void setSuppFreAmt(java.math.BigDecimal item)
    {
        setBigDecimal("suppFreAmt", item);
    }
    /**
     * Object:���㵥's �����˷�property 
     */
    public java.math.BigDecimal getActulSettleFreAmt()
    {
        return getBigDecimal("actulSettleFreAmt");
    }
    public void setActulSettleFreAmt(java.math.BigDecimal item)
    {
        setBigDecimal("actulSettleFreAmt", item);
    }
    /**
     * Object:���㵥's �����˷ѵ���property 
     */
    public java.math.BigDecimal getSelfFrePrice()
    {
        return getBigDecimal("selfFrePrice");
    }
    public void setSelfFrePrice(java.math.BigDecimal item)
    {
        setBigDecimal("selfFrePrice", item);
    }
    /**
     * Object:���㵥's ��׼����property 
     */
    public java.math.BigDecimal getYieldStd()
    {
        return getBigDecimal("yieldStd");
    }
    public void setYieldStd(java.math.BigDecimal item)
    {
        setBigDecimal("yieldStd", item);
    }
    /**
     * Object:���㵥's �����������property 
     */
    public java.math.BigDecimal getCarcassSettleWgt()
    {
        return getBigDecimal("carcassSettleWgt");
    }
    public void setCarcassSettleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("carcassSettleWgt", item);
    }
    /**
     * Object:���㵥's ��׼������property 
     */
    public java.math.BigDecimal getStdYeildRate()
    {
        return getBigDecimal("stdYeildRate");
    }
    public void setStdYeildRate(java.math.BigDecimal item)
    {
        setBigDecimal("stdYeildRate", item);
    }
    /**
     * Object:���㵥's ʵ�ʳ�����property 
     */
    public java.math.BigDecimal getActualYieldRate()
    {
        return getBigDecimal("actualYieldRate");
    }
    public void setActualYieldRate(java.math.BigDecimal item)
    {
        setBigDecimal("actualYieldRate", item);
    }
    /**
     * Object:���㵥's ë������������property 
     */
    public java.math.BigDecimal getTotalSettleWgt()
    {
        return getBigDecimal("totalSettleWgt");
    }
    public void setTotalSettleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("totalSettleWgt", item);
    }
    /**
     * Object:���㵥's ���׼۸�property 
     */
    public java.math.BigDecimal getSafePrice()
    {
        return getBigDecimal("safePrice");
    }
    public void setSafePrice(java.math.BigDecimal item)
    {
        setBigDecimal("safePrice", item);
    }
    /**
     * Object:���㵥's �г��۸�property 
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
     * Object:���㵥's �չ��۸�property 
     */
    public java.math.BigDecimal getPurchasePrice()
    {
        return getBigDecimal("purchasePrice");
    }
    public void setPurchasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("purchasePrice", item);
    }
    /**
     * Object:���㵥's �����ܽ��property 
     */
    public java.math.BigDecimal getTotalSettleAmt()
    {
        return getBigDecimal("totalSettleAmt");
    }
    public void setTotalSettleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("totalSettleAmt", item);
    }
    /**
     * Object:���㵥's ֻ��property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:���㵥's ����property 
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
     * Object:���㵥's �չ�������property 
     */
    public java.math.BigDecimal getPurchaseSettleAmt()
    {
        return getBigDecimal("purchaseSettleAmt");
    }
    public void setPurchaseSettleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("purchaseSettleAmt", item);
    }
    /**
     * Object: ���㵥 's ���ͱ�׼ property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo getCarriageFormat()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo)get("CarriageFormat");
    }
    public void setCarriageFormat(com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo item)
    {
        put("CarriageFormat", item);
    }
    /**
     * Object:���㵥's �������property 
     */
    public java.math.BigDecimal getChickenSzQty()
    {
        return getBigDecimal("chickenSzQty");
    }
    public void setChickenSzQty(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSzQty", item);
    }
    /**
     * Object:���㵥's ����ӿ۳����property 
     */
    public java.math.BigDecimal getChickenSzAmt()
    {
        return getBigDecimal("chickenSzAmt");
    }
    public void setChickenSzAmt(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSzAmt", item);
    }
    /**
     * Object: ���㵥 's ���˷� property 
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
     * Object:���㵥's ʵ���˷�property 
     */
    public java.math.BigDecimal getActualFreAmt()
    {
        return getBigDecimal("actualFreAmt");
    }
    public void setActualFreAmt(java.math.BigDecimal item)
    {
        setBigDecimal("actualFreAmt", item);
    }
    /**
     * Object:���㵥's �����˷�property 
     */
    public java.math.BigDecimal getSelfFreAmt()
    {
        return getBigDecimal("selfFreAmt");
    }
    public void setSelfFreAmt(java.math.BigDecimal item)
    {
        setBigDecimal("selfFreAmt", item);
    }
    /**
     * Object:���㵥's �������ϼ�property 
     */
    public java.math.BigDecimal getOtherAmount()
    {
        return getBigDecimal("otherAmount");
    }
    public void setOtherAmount(java.math.BigDecimal item)
    {
        setBigDecimal("otherAmount", item);
    }
    /**
     * Object:���㵥's ���ͽ��property 
     */
    public java.math.BigDecimal getAwardsAmount()
    {
        return getBigDecimal("awardsAmount");
    }
    public void setAwardsAmount(java.math.BigDecimal item)
    {
        setBigDecimal("awardsAmount", item);
    }
    /**
     * Object:���㵥's ��ë��property 
     */
    public java.math.BigDecimal getPlusSettleWgt()
    {
        return getBigDecimal("plusSettleWgt");
    }
    public void setPlusSettleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("plusSettleWgt", item);
    }
    /**
     * Object:���㵥's �Ӽ�property 
     */
    public java.math.BigDecimal getPlusPrice()
    {
        return getBigDecimal("plusPrice");
    }
    public void setPlusPrice(java.math.BigDecimal item)
    {
        setBigDecimal("plusPrice", item);
    }
    /**
     * Object:���㵥's ���ϵ��property 
     */
    public java.math.BigDecimal getChickenSzCoeff()
    {
        return getBigDecimal("chickenSzCoeff");
    }
    public void setChickenSzCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSzCoeff", item);
    }
    /**
     * Object: ���㵥 's �������� property 
     */
    public com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object: ���㵥 's �������� property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo getAwardsPolicy()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo)get("awardsPolicy");
    }
    public void setAwardsPolicy(com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo item)
    {
        put("awardsPolicy", item);
    }
    /**
     * Object:���㵥's �����۸�property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object:���㵥's ��ֵ�۸�property 
     */
    public java.math.BigDecimal getHedingPrice()
    {
        return getBigDecimal("hedingPrice");
    }
    public void setHedingPrice(java.math.BigDecimal item)
    {
        setBigDecimal("hedingPrice", item);
    }
    /**
     * Object:���㵥's �̶�ϵ��property 
     */
    public java.math.BigDecimal getFixedCoeff()
    {
        return getBigDecimal("fixedCoeff");
    }
    public void setFixedCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("fixedCoeff", item);
    }
    /**
     * Object:���㵥's ����ϵ��property 
     */
    public java.math.BigDecimal getShareCoeff()
    {
        return getBigDecimal("shareCoeff");
    }
    public void setShareCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("shareCoeff", item);
    }
    /**
     * Object:���㵥's ƽ��ֻ��property 
     */
    public java.math.BigDecimal getAvgWgt()
    {
        return getBigDecimal("avgWgt");
    }
    public void setAvgWgt(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgt", item);
    }
    /**
     * Object:���㵥's �Ƿ��չ����property 
     */
    public boolean isBuyComplete()
    {
        return getBoolean("buyComplete");
    }
    public void setBuyComplete(boolean item)
    {
        setBoolean("buyComplete", item);
    }
    /**
     * Object:���㵥's �ۿ��׼property 
     */
    public java.math.BigDecimal getChargeStd()
    {
        return getBigDecimal("chargeStd");
    }
    public void setChargeStd(java.math.BigDecimal item)
    {
        setBigDecimal("chargeStd", item);
    }
    /**
     * Object:���㵥's �Ƿ���ǰproperty 
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
     * Object:���㵥's ��������property 
     */
    public java.math.BigDecimal getInQty()
    {
        return getBigDecimal("inQty");
    }
    public void setInQty(java.math.BigDecimal item)
    {
        setBigDecimal("inQty", item);
    }
    /**
     * Object:���㵥's �Ƿ�ϸ�property 
     */
    public boolean isIsQualified()
    {
        return getBoolean("isQualified");
    }
    public void setIsQualified(boolean item)
    {
        setBoolean("isQualified", item);
    }
    /**
     * Object:���㵥's ���ƽ������property 
     */
    public java.math.BigDecimal getCSzAverageQty()
    {
        return getBigDecimal("CSzAverageQty");
    }
    public void setCSzAverageQty(java.math.BigDecimal item)
    {
        setBigDecimal("CSzAverageQty", item);
    }
    /**
     * Object:���㵥's ���յ�ַproperty 
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
     * Object:���㵥's ��Ӧ�̵�ַproperty 
     */
    public String getSupplierAddress()
    {
        return getString("supplierAddress");
    }
    public void setSupplierAddress(String item)
    {
        setString("supplierAddress", item);
    }
    /**
     * Object:���㵥's �Ƿ����property 
     */
    public boolean isIsdiff()
    {
        return getBoolean("isdiff");
    }
    public void setIsdiff(boolean item)
    {
        setBoolean("isdiff", item);
    }
    /**
     * Object:���㵥's ���챸עproperty 
     */
    public String getDifftxt()
    {
        return getString("difftxt");
    }
    public void setDifftxt(String item)
    {
        setString("difftxt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FDFAF775");
    }
}