package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCTransFodderBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCTransFodderBillInfo()
    {
        this("id");
    }
    protected AbstractCTransFodderBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillEntryCollection());
    }
    /**
     * Object: 调料单 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.CTransFodderBillEntryCollection)get("entrys");
    }
    /**
     * Object:调料单's 是否生成凭证property 
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
     * Object:调料单's 单据状态property 
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
     * Object: 调料单 's 财务组织 property 
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
     * Object:调料单's 审核时间property 
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
     * Object: 调料单 's 库存组织 property 
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
     * Object: 调料单 's 调出养殖户 property 
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
     * Object: 调料单 's 调出养殖场 property 
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
     * Object: 调料单 's 调出批次 property 
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
     * Object: 调料单 's 调入养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getTargetFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("targetFarmer");
    }
    public void setTargetFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("targetFarmer", item);
    }
    /**
     * Object: 调料单 's 调入养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getTargetFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("targetFarm");
    }
    public void setTargetFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("targetFarm", item);
    }
    /**
     * Object: 调料单 's 调入批次合同 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getTargetBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("targetBatchContract");
    }
    public void setTargetBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("targetBatchContract", item);
    }
    /**
     * Object: 调料单 's 调入批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getTargetBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("targetBatch");
    }
    public void setTargetBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("targetBatch", item);
    }
    /**
     * Object: 调料单 's 车辆 property 
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
     * Object: 调料单 's 调出批次合同 property 
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
     * Object: 调料单 's 司机 property 
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
     * Object: 调料单 's 调出养殖品种 property 
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
     * Object: 调料单 's 调入养殖品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getTargetBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("targetBreedData");
    }
    public void setTargetBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("targetBreedData", item);
    }
    /**
     * Object:调料单's 调出上苗日期property 
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
     * Object:调料单's 调入上苗日期property 
     */
    public java.util.Date getTargetIndate()
    {
        return getDate("targetIndate");
    }
    public void setTargetIndate(java.util.Date item)
    {
        setDate("targetIndate", item);
    }
    /**
     * Object:调料单's 调出上苗数量property 
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
     * Object:调料单's 调入上苗数量property 
     */
    public java.math.BigDecimal getTargetBatchQty()
    {
        return getBigDecimal("targetBatchQty");
    }
    public void setTargetBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("targetBatchQty", item);
    }
    /**
     * Object: 调料单 's 调出户业务员 property 
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
     * Object: 调料单 's 调入户业务员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getTargetPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("targetPerson");
    }
    public void setTargetPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("targetPerson", item);
    }
    /**
     * Object: 调料单 's 调入成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getInCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("inCostCenter");
    }
    public void setInCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("inCostCenter", item);
    }
    /**
     * Object: 调料单 's 调出成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getOutCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("outCostCenter");
    }
    public void setOutCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("outCostCenter", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("77754AE6");
    }
}