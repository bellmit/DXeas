package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDrugReceptionBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDrugReceptionBillInfo()
    {
        this("id");
    }
    protected AbstractDrugReceptionBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillEntryCollection());
    }
    /**
     * Object: 药品处方单 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.DrugReceptionBillEntryCollection)get("entrys");
    }
    /**
     * Object:药品处方单's 是否生成凭证property 
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
     * Object:药品处方单's 单据状态property 
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
     * Object: 药品处方单 's 财务组织 property 
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
     * Object:药品处方单's 审核时间property 
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
     * Object: 药品处方单 's 养户名称 property 
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
     * Object: 药品处方单 's 库存组织 property 
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
     * Object: 药品处方单 's 批次 property 
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
     * Object: 药品处方单 's 养殖场 property 
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
     * Object: 药品处方单 's 批次合同 property 
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
     * Object:药品处方单's 初始化单据property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object:药品处方单's 当前阶段property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmStageEnum getNowBreedState()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.getEnum(getInt("nowBreedState"));
    }
    public void setNowBreedState(com.kingdee.eas.farm.stocking.basedata.FarmStageEnum item)
    {
		if (item != null) {
        setInt("nowBreedState", item.getValue());
		}
    }
    /**
     * Object:药品处方单's 是否生成领料出库property 
     */
    public boolean isIsHasMaterial()
    {
        return getBoolean("isHasMaterial");
    }
    public void setIsHasMaterial(boolean item)
    {
        setBoolean("isHasMaterial", item);
    }
    /**
     * Object:药品处方单's 是否生成调拨出库property 
     */
    public boolean isIsHasTrans()
    {
        return getBoolean("isHasTrans");
    }
    public void setIsHasTrans(boolean item)
    {
        setBoolean("isHasTrans", item);
    }
    /**
     * Object:药品处方单's 凭证号property 
     */
    public String getVoucherNum()
    {
        return getString("voucherNum");
    }
    public void setVoucherNum(String item)
    {
        setString("voucherNum", item);
    }
    /**
     * Object:药品处方单's 是否确认property 
     */
    public boolean isHasConfirm()
    {
        return getBoolean("hasConfirm");
    }
    public void setHasConfirm(boolean item)
    {
        setBoolean("hasConfirm", item);
    }
    /**
     * Object:药品处方单's 确认时间property 
     */
    public java.util.Date getConfirmTime()
    {
        return getDate("confirmTime");
    }
    public void setConfirmTime(java.util.Date item)
    {
        setDate("confirmTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F16676F1");
    }
}