package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCReceivingBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCCReceivingBillInfo()
    {
        this("id");
    }
    protected AbstractCCReceivingBillInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.food.CCReceivingBillEntryCollection());
    }
    /**
     * Object: 商品鸡接收单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("StorageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("StorageOrgUnit", item);
    }
    /**
     * Object:商品鸡接收单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("BillStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("BillStatus", item.getValue());
		}
    }
    /**
     * Object:商品鸡接收单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("AuditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("AuditTime", item);
    }
    /**
     * Object: 商品鸡接收单 's 单据体 property 
     */
    public com.kingdee.eas.farm.food.CCReceivingBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.CCReceivingBillEntryCollection)get("Entrys");
    }
    /**
     * Object: 商品鸡接收单 's 来源库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getFromStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("fromStorageOrgUnit");
    }
    public void setFromStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("fromStorageOrgUnit", item);
    }
    /**
     * Object: 商品鸡接收单 's 来源财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFromCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("fromCompanyOrgUnit");
    }
    public void setFromCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("fromCompanyOrgUnit", item);
    }
    /**
     * Object: 商品鸡接收单 's 采购组织 property 
     */
    public com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo getPurchaseOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo)get("purchaseOrgUnit");
    }
    public void setPurchaseOrgUnit(com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo item)
    {
        put("purchaseOrgUnit", item);
    }
    /**
     * Object: 商品鸡接收单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    /**
     * Object: 商品鸡接收单 's 来源销售组织 property 
     */
    public com.kingdee.eas.basedata.org.SaleOrgUnitInfo getFromSaleOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.SaleOrgUnitInfo)get("fromSaleOrgUnit");
    }
    public void setFromSaleOrgUnit(com.kingdee.eas.basedata.org.SaleOrgUnitInfo item)
    {
        put("fromSaleOrgUnit", item);
    }
    /**
     * Object: 商品鸡接收单 's 供应商 property 
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
     * Object: 商品鸡接收单 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4C3F10BD");
    }
}