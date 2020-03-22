package com.kingdee.eas.custom.taihe.workshopmanager;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLoadingBillInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractLoadingBillInfo()
    {
        this("id");
    }
    protected AbstractLoadingBillInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillEntryCollection());
    }
    /**
     * Object:装货单's 是否生成凭证property 
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
     * Object: 装货单 's 财务组织 property 
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
     * Object: 装货单 's 库存组织 property 
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
     * Object:装货单's 原单idproperty 
     */
    public String getSrcBillID()
    {
        return getString("srcBillID");
    }
    public void setSrcBillID(String item)
    {
        setString("srcBillID", item);
    }
    /**
     * Object:装货单's 源单名称property 
     */
    public String getSrcBillName()
    {
        return getString("srcBillName");
    }
    public void setSrcBillName(String item)
    {
        setString("srcBillName", item);
    }
    /**
     * Object:装货单's 源单编码property 
     */
    public String getSrcBillNum()
    {
        return getString("srcBillNum");
    }
    public void setSrcBillNum(String item)
    {
        setString("srcBillNum", item);
    }
    /**
     * Object: 装货单 's 表体 property 
     */
    public com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.workshopmanager.LoadingBillEntryCollection)get("Entry");
    }
    /**
     * Object: 装货单 's 客户 property 
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
     * Object: 装货单 's 销售订单 property 
     */
    public com.kingdee.eas.scm.sd.sale.SaleOrderInfo getSaleOrder()
    {
        return (com.kingdee.eas.scm.sd.sale.SaleOrderInfo)get("saleOrder");
    }
    public void setSaleOrder(com.kingdee.eas.scm.sd.sale.SaleOrderInfo item)
    {
        put("saleOrder", item);
    }
    /**
     * Object:装货单's 是否生成出库单property 
     */
    public boolean isIsCreateIssueBill()
    {
        return getBoolean("isCreateIssueBill");
    }
    public void setIsCreateIssueBill(boolean item)
    {
        setBoolean("isCreateIssueBill", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BEDBE401");
    }
}