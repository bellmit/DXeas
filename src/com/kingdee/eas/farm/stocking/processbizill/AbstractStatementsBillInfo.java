package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementsBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractStatementsBillInfo()
    {
        this("id");
    }
    protected AbstractStatementsBillInfo(String pkField)
    {
        super(pkField);
        put("OtherEntry", new com.kingdee.eas.farm.stocking.processbizill.StatementsBillOtherEntryCollection());
        put("RewardsEntry", new com.kingdee.eas.farm.stocking.processbizill.StatementsBillRewardsEntryCollection());
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryCollection());
        put("HandEntry", new com.kingdee.eas.farm.stocking.processbizill.StatementsBillHandEntryCollection());
        put("EggEntry", new com.kingdee.eas.farm.stocking.processbizill.StatementsBillEggEntryCollection());
        put("BatchDetail", new com.kingdee.eas.farm.stocking.processbizill.StatementsBillBatchDetailCollection());
    }
    /**
     * Object: ���㵥 's ��¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillEntryCollection)get("entrys");
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
     * Object:���㵥's ����״̬property 
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
     * Object: ���㵥 's ������֯ property 
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
     * Object:���㵥's ���ʱ��property 
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
     * Object: ���㵥 's �������� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: ���㵥 's ���α��� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
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
     * Object:���㵥's �����property 
     */
    public java.math.BigDecimal getFCR()
    {
        return getBigDecimal("FCR");
    }
    public void setFCR(java.math.BigDecimal item)
    {
        setBigDecimal("FCR", item);
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
     * Object:���㵥's ������property 
     */
    public java.math.BigDecimal getAllQty()
    {
        return getBigDecimal("allQty");
    }
    public void setAllQty(java.math.BigDecimal item)
    {
        setBigDecimal("allQty", item);
    }
    /**
     * Object:���㵥's ������property 
     */
    public java.math.BigDecimal getBreedDataAmount()
    {
        return getBigDecimal("breedDataAmount");
    }
    public void setBreedDataAmount(java.math.BigDecimal item)
    {
        setBigDecimal("breedDataAmount", item);
    }
    /**
     * Object:���㵥's ���Ͻ��property 
     */
    public java.math.BigDecimal getFodderAmount()
    {
        return getBigDecimal("fodderAmount");
    }
    public void setFodderAmount(java.math.BigDecimal item)
    {
        setBigDecimal("fodderAmount", item);
    }
    /**
     * Object:���㵥's ҩƷ���property 
     */
    public java.math.BigDecimal getDrugAmount()
    {
        return getBigDecimal("drugAmount");
    }
    public void setDrugAmount(java.math.BigDecimal item)
    {
        setBigDecimal("drugAmount", item);
    }
    /**
     * Object:���㵥's ƽ��ֻ��property 
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
     * Object:���㵥's ֻƽ������property 
     */
    public java.math.BigDecimal getAvgFodderQty()
    {
        return getBigDecimal("avgFodderQty");
    }
    public void setAvgFodderQty(java.math.BigDecimal item)
    {
        setBigDecimal("avgFodderQty", item);
    }
    /**
     * Object:���㵥's ֻƽ����ҩproperty 
     */
    public java.math.BigDecimal getAvgDrug()
    {
        return getBigDecimal("avgDrug");
    }
    public void setAvgDrug(java.math.BigDecimal item)
    {
        setBigDecimal("avgDrug", item);
    }
    /**
     * Object:���㵥's �ϸ�Ʒ���property 
     */
    public java.math.BigDecimal getEggAmount()
    {
        return getBigDecimal("eggAmount");
    }
    public void setEggAmount(java.math.BigDecimal item)
    {
        setBigDecimal("eggAmount", item);
    }
    /**
     * Object:���㵥's ��Ʒ���յ���property 
     */
    public java.math.BigDecimal getEggPrice()
    {
        return getBigDecimal("eggPrice");
    }
    public void setEggPrice(java.math.BigDecimal item)
    {
        setBigDecimal("eggPrice", item);
    }
    /**
     * Object:���㵥's �ϸ�Ʒ����property 
     */
    public java.math.BigDecimal getEggQty()
    {
        return getBigDecimal("eggQty");
    }
    public void setEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("eggQty", item);
    }
    /**
     * Object:���㵥's ���ݻ��ս��property 
     */
    public java.math.BigDecimal getBirdsAmount()
    {
        return getBigDecimal("birdsAmount");
    }
    public void setBirdsAmount(java.math.BigDecimal item)
    {
        setBigDecimal("birdsAmount", item);
    }
    /**
     * Object:���㵥's ���ݻ��յ���property 
     */
    public java.math.BigDecimal getBirdsPrice()
    {
        return getBigDecimal("birdsPrice");
    }
    public void setBirdsPrice(java.math.BigDecimal item)
    {
        setBigDecimal("birdsPrice", item);
    }
    /**
     * Object:���㵥's ���ջ�������property 
     */
    public java.math.BigDecimal getBirdsQty()
    {
        return getBigDecimal("birdsQty");
    }
    public void setBirdsQty(java.math.BigDecimal item)
    {
        setBigDecimal("birdsQty", item);
    }
    /**
     * Object:���㵥's ��������property 
     */
    public java.math.BigDecimal getFarmerProfit()
    {
        return getBigDecimal("farmerProfit");
    }
    public void setFarmerProfit(java.math.BigDecimal item)
    {
        setBigDecimal("farmerProfit", item);
    }
    /**
     * Object:���㵥's ��˾����property 
     */
    public java.math.BigDecimal getCompanyProfit()
    {
        return getBigDecimal("companyProfit");
    }
    public void setCompanyProfit(java.math.BigDecimal item)
    {
        setBigDecimal("companyProfit", item);
    }
    /**
     * Object: ���㵥 's ���շ�¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillEggEntryCollection getEggEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillEggEntryCollection)get("EggEntry");
    }
    /**
     * Object: ���㵥 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillOtherEntryCollection getOtherEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillOtherEntryCollection)get("OtherEntry");
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
     * Object:���㵥's �������property 
     */
    public java.math.BigDecimal getSubsidyAmount()
    {
        return getBigDecimal("subsidyAmount");
    }
    public void setSubsidyAmount(java.math.BigDecimal item)
    {
        setBigDecimal("subsidyAmount", item);
    }
    /**
     * Object: ���㵥 's �����֯ property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:���㵥's ��֤��property 
     */
    public java.math.BigDecimal getMarginAmount()
    {
        return getBigDecimal("marginAmount");
    }
    public void setMarginAmount(java.math.BigDecimal item)
    {
        setBigDecimal("marginAmount", item);
    }
    /**
     * Object:���㵥's ��ʼ����property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:���㵥's ��������property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object: ���㵥 's ���ͷ�¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillRewardsEntryCollection getRewardsEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillRewardsEntryCollection)get("RewardsEntry");
    }
    /**
     * Object:���㵥's ����������property 
     */
    public java.math.BigDecimal getAllEatQty()
    {
        return getBigDecimal("allEatQty");
    }
    public void setAllEatQty(java.math.BigDecimal item)
    {
        setBigDecimal("allEatQty", item);
    }
    /**
     * Object:���㵥's ��Ѽ������property 
     */
    public java.math.BigDecimal getLastStock()
    {
        return getBigDecimal("lastStock");
    }
    public void setLastStock(java.math.BigDecimal item)
    {
        setBigDecimal("lastStock", item);
    }
    /**
     * Object:���㵥's �������property 
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
     * Object: ���㵥 's ���κ�ͬ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object:���㵥's ĸ�ݴ���property 
     */
    public java.math.BigDecimal getLastFemaleStock()
    {
        return getBigDecimal("lastFemaleStock");
    }
    public void setLastFemaleStock(java.math.BigDecimal item)
    {
        setBigDecimal("lastFemaleStock", item);
    }
    /**
     * Object:���㵥's ����������property 
     */
    public java.math.BigDecimal getDeadQty()
    {
        return getBigDecimal("deadQty");
    }
    public void setDeadQty(java.math.BigDecimal item)
    {
        setBigDecimal("deadQty", item);
    }
    /**
     * Object:���㵥's ĸѼ������property 
     */
    public java.math.BigDecimal getFemaleDeadQty()
    {
        return getBigDecimal("femaleDeadQty");
    }
    public void setFemaleDeadQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleDeadQty", item);
    }
    /**
     * Object: ���㵥 's �ֹ���¼ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillHandEntryCollection getHandEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillHandEntryCollection)get("HandEntry");
    }
    /**
     * Object:���㵥's �ܾ���property 
     */
    public java.math.BigDecimal getFertilizationRate()
    {
        return getBigDecimal("fertilizationRate");
    }
    public void setFertilizationRate(java.math.BigDecimal item)
    {
        setBigDecimal("fertilizationRate", item);
    }
    /**
     * Object:���㵥's ������property 
     */
    public java.math.BigDecimal getLayingRate()
    {
        return getBigDecimal("layingRate");
    }
    public void setLayingRate(java.math.BigDecimal item)
    {
        setBigDecimal("layingRate", item);
    }
    /**
     * Object:���㵥's ������̭��property 
     */
    public java.math.BigDecimal getCullQty()
    {
        return getBigDecimal("cullQty");
    }
    public void setCullQty(java.math.BigDecimal item)
    {
        setBigDecimal("cullQty", item);
    }
    /**
     * Object:���㵥's ĸ����̭��property 
     */
    public java.math.BigDecimal getFemaleCullQty()
    {
        return getBigDecimal("femaleCullQty");
    }
    public void setFemaleCullQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleCullQty", item);
    }
    /**
     * Object:���㵥's ��������property 
     */
    public java.math.BigDecimal getBirdsWeight()
    {
        return getBigDecimal("birdsWeight");
    }
    public void setBirdsWeight(java.math.BigDecimal item)
    {
        setBigDecimal("birdsWeight", item);
    }
    /**
     * Object:���㵥's ��ĩ������property 
     */
    public java.math.BigDecimal getAllLastStock()
    {
        return getBigDecimal("allLastStock");
    }
    public void setAllLastStock(java.math.BigDecimal item)
    {
        setBigDecimal("allLastStock", item);
    }
    /**
     * Object:���㵥's �ϸ�ƽ������property 
     */
    public java.math.BigDecimal getAvgEggPrice()
    {
        return getBigDecimal("avgEggPrice");
    }
    public void setAvgEggPrice(java.math.BigDecimal item)
    {
        setBigDecimal("avgEggPrice", item);
    }
    /**
     * Object:���㵥's ���յ�Ʒ�ܽ��property 
     */
    public java.math.BigDecimal getAllEggAmount()
    {
        return getBigDecimal("allEggAmount");
    }
    public void setAllEggAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allEggAmount", item);
    }
    /**
     * Object:���㵥's ת�ݽ��property 
     */
    public java.math.BigDecimal getTransBirdAmount()
    {
        return getBigDecimal("transBirdAmount");
    }
    public void setTransBirdAmount(java.math.BigDecimal item)
    {
        setBigDecimal("transBirdAmount", item);
    }
    /**
     * Object:���㵥's ת�Ͻ��property 
     */
    public java.math.BigDecimal getTransFodderAmount()
    {
        return getBigDecimal("transFodderAmount");
    }
    public void setTransFodderAmount(java.math.BigDecimal item)
    {
        setBigDecimal("transFodderAmount", item);
    }
    /**
     * Object:���㵥's ����ԭʼ����property 
     */
    public java.math.BigDecimal getOriginalFarmerProfit()
    {
        return getBigDecimal("originalFarmerProfit");
    }
    public void setOriginalFarmerProfit(java.math.BigDecimal item)
    {
        setBigDecimal("originalFarmerProfit", item);
    }
    /**
     * Object:���㵥's �ֹ���Ŀ���property 
     */
    public java.math.BigDecimal getHandAmount()
    {
        return getBigDecimal("handAmount");
    }
    public void setHandAmount(java.math.BigDecimal item)
    {
        setBigDecimal("handAmount", item);
    }
    /**
     * Object:���㵥's �ܵ�Ʒ����property 
     */
    public java.math.BigDecimal getAllEggQty()
    {
        return getBigDecimal("allEggQty");
    }
    public void setAllEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("allEggQty", item);
    }
    /**
     * Object:���㵥's ��֤����Ϣproperty 
     */
    public java.math.BigDecimal getMarginInterest()
    {
        return getBigDecimal("marginInterest");
    }
    public void setMarginInterest(java.math.BigDecimal item)
    {
        setBigDecimal("marginInterest", item);
    }
    /**
     * Object:���㵥's ������Ϣproperty 
     */
    public java.math.BigDecimal getLoanInterest()
    {
        return getBigDecimal("loanInterest");
    }
    public void setLoanInterest(java.math.BigDecimal item)
    {
        setBigDecimal("loanInterest", item);
    }
    /**
     * Object:���㵥's �����property 
     */
    public java.math.BigDecimal getAlimony()
    {
        return getBigDecimal("alimony");
    }
    public void setAlimony(java.math.BigDecimal item)
    {
        setBigDecimal("alimony", item);
    }
    /**
     * Object:���㵥's ���㷽ʽproperty 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum getSettleType()
    {
        return com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum.getEnum(getInt("settleType"));
    }
    public void setSettleType(com.kingdee.eas.farm.stocking.processbizill.StockingSettlementTypeEnum item)
    {
		if (item != null) {
        setInt("settleType", item.getValue());
		}
    }
    /**
     * Object: ���㵥 's �ڼ� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:���㵥's ����ɱ�property 
     */
    public java.math.BigDecimal getBreedDataCost()
    {
        return getBigDecimal("breedDataCost");
    }
    public void setBreedDataCost(java.math.BigDecimal item)
    {
        setBigDecimal("breedDataCost", item);
    }
    /**
     * Object:���㵥's ���ϳɱ�property 
     */
    public java.math.BigDecimal getFodderCost()
    {
        return getBigDecimal("fodderCost");
    }
    public void setFodderCost(java.math.BigDecimal item)
    {
        setBigDecimal("fodderCost", item);
    }
    /**
     * Object:���㵥's ҩƷ�ɱ�property 
     */
    public java.math.BigDecimal getDrugCost()
    {
        return getBigDecimal("drugCost");
    }
    public void setDrugCost(java.math.BigDecimal item)
    {
        setBigDecimal("drugCost", item);
    }
    /**
     * Object:���㵥's ���ϳɱ�property 
     */
    public java.math.BigDecimal getOtherMaterialCost()
    {
        return getBigDecimal("otherMaterialCost");
    }
    public void setOtherMaterialCost(java.math.BigDecimal item)
    {
        setBigDecimal("otherMaterialCost", item);
    }
    /**
     * Object:���㵥's ����Ӧ�ճ��property 
     */
    public java.math.BigDecimal getArAmountOffset()
    {
        return getBigDecimal("arAmountOffset");
    }
    public void setArAmountOffset(java.math.BigDecimal item)
    {
        setBigDecimal("arAmountOffset", item);
    }
    /**
     * Object:���㵥's �����ʲ��۾�property 
     */
    public java.math.BigDecimal getFaFurCardCost()
    {
        return getBigDecimal("faFurCardCost");
    }
    public void setFaFurCardCost(java.math.BigDecimal item)
    {
        setBigDecimal("faFurCardCost", item);
    }
    /**
     * Object:���㵥's ��������property 
     */
    public java.math.BigDecimal getMarkedQty()
    {
        return getBigDecimal("markedQty");
    }
    public void setMarkedQty(java.math.BigDecimal item)
    {
        setBigDecimal("markedQty", item);
    }
    /**
     * Object:���㵥's ��������property 
     */
    public java.math.BigDecimal getAdjustQty()
    {
        return getBigDecimal("adjustQty");
    }
    public void setAdjustQty(java.math.BigDecimal item)
    {
        setBigDecimal("adjustQty", item);
    }
    /**
     * Object:���㵥's ��������ĸ��property 
     */
    public java.math.BigDecimal getFemaleAdjustQty()
    {
        return getBigDecimal("femaleAdjustQty");
    }
    public void setFemaleAdjustQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleAdjustQty", item);
    }
    /**
     * Object:���㵥's ��������ĸ��property 
     */
    public java.math.BigDecimal getFemaleMarkedQty()
    {
        return getBigDecimal("femaleMarkedQty");
    }
    public void setFemaleMarkedQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleMarkedQty", item);
    }
    /**
     * Object:���㵥's ��ֳ�׶�property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmStageEnum getBreedStage()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.getEnum(getInt("breedStage"));
    }
    public void setBreedStage(com.kingdee.eas.farm.stocking.basedata.FarmStageEnum item)
    {
		if (item != null) {
        setInt("breedStage", item.getValue());
		}
    }
    /**
     * Object:���㵥's ����property 
     */
    public java.math.BigDecimal getFeeCostAmount()
    {
        return getBigDecimal("feeCostAmount");
    }
    public void setFeeCostAmount(java.math.BigDecimal item)
    {
        setBigDecimal("feeCostAmount", item);
    }
    /**
     * Object:���㵥's �����ܳɱ�property 
     */
    public java.math.BigDecimal getAllActualCost()
    {
        return getBigDecimal("allActualCost");
    }
    public void setAllActualCost(java.math.BigDecimal item)
    {
        setBigDecimal("allActualCost", item);
    }
    /**
     * Object: ���㵥 's ������ϸ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementsBillBatchDetailCollection getBatchDetail()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementsBillBatchDetailCollection)get("BatchDetail");
    }
    /**
     * Object:���㵥's ���Ͻ��property 
     */
    public java.math.BigDecimal getOtherMaterialAmount()
    {
        return getBigDecimal("otherMaterialAmount");
    }
    public void setOtherMaterialAmount(java.math.BigDecimal item)
    {
        setBigDecimal("otherMaterialAmount", item);
    }
    /**
     * Object:���㵥's ���ڵ�λ�ɱ�property 
     */
    public java.math.BigDecimal getUnitActualAmount()
    {
        return getBigDecimal("unitActualAmount");
    }
    public void setUnitActualAmount(java.math.BigDecimal item)
    {
        setBigDecimal("unitActualAmount", item);
    }
    /**
     * Object:���㵥's ����Ʒ���property 
     */
    public java.math.BigDecimal getCoProductAmount()
    {
        return getBigDecimal("coProductAmount");
    }
    public void setCoProductAmount(java.math.BigDecimal item)
    {
        setBigDecimal("coProductAmount", item);
    }
    /**
     * Object:���㵥's ռ����Ϣproperty 
     */
    public java.math.BigDecimal getOccupyInterest()
    {
        return getBigDecimal("occupyInterest");
    }
    public void setOccupyInterest(java.math.BigDecimal item)
    {
        setBigDecimal("occupyInterest", item);
    }
    /**
     * Object:���㵥's ������Ϣ��property 
     */
    public java.math.BigDecimal getLoanInterestDiff()
    {
        return getBigDecimal("loanInterestDiff");
    }
    public void setLoanInterestDiff(java.math.BigDecimal item)
    {
        setBigDecimal("loanInterestDiff", item);
    }
    /**
     * Object:���㵥's ���պϸ�����property 
     */
    public java.math.BigDecimal getReceiveQcEggQty()
    {
        return getBigDecimal("receiveQcEggQty");
    }
    public void setReceiveQcEggQty(java.math.BigDecimal item)
    {
        setBigDecimal("receiveQcEggQty", item);
    }
    /**
     * Object:���㵥's �ܾ���property 
     */
    public java.math.BigDecimal getFertilizationRate2()
    {
        return getBigDecimal("fertilizationRate2");
    }
    public void setFertilizationRate2(java.math.BigDecimal item)
    {
        setBigDecimal("fertilizationRate2", item);
    }
    /**
     * Object: ���㵥 's Ƭ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getFarmersTree()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("farmersTree");
    }
    public void setFarmersTree(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("farmersTree", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("18D671B0");
    }
}