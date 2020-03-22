package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFodderReceiveBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFodderReceiveBillInfo()
    {
        this("id");
    }
    protected AbstractFodderReceiveBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillEntryCollection());
    }
    /**
     * Object: 饲料领用单 's 分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.FodderReceiveBillEntryCollection)get("entrys");
    }
    /**
     * Object:饲料领用单's 是否生成凭证property 
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
     * Object:饲料领用单's 单据状态property 
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
     * Object: 饲料领用单 's 财务组织 property 
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
     * Object:饲料领用单's 审核时间property 
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
     * Object: 饲料领用单 's 库存组织 property 
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
     * Object:饲料领用单's 初始化单据property 
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
     * Object:饲料领用单's 领用类型property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.FodderBillType getBillType()
    {
        return com.kingdee.eas.farm.stocking.processbizill.FodderBillType.getEnum(getString("billType"));
    }
    public void setBillType(com.kingdee.eas.farm.stocking.processbizill.FodderBillType item)
    {
		if (item != null) {
        setString("billType", item.getValue());
		}
    }
    /**
     * Object: 饲料领用单 's 退料公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getReturnCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("returnCompany");
    }
    public void setReturnCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("returnCompany", item);
    }
    /**
     * Object:饲料领用单's 凭证号property 
     */
    public String getVoucherNum()
    {
        return getString("voucherNum");
    }
    public void setVoucherNum(String item)
    {
        setString("voucherNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F330056F");
    }
}