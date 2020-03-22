package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBabyBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractHatchBabyBillInfo()
    {
        this("id");
    }
    protected AbstractHatchBabyBillInfo(String pkField)
    {
        super(pkField);
        put("SaleEntry", new com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryCollection());
        put("entrys", new com.kingdee.eas.farm.hatch.HatchBabyBillEntryCollection());
    }
    /**
     * Object: 出雏单old 's 分录 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBabyBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.HatchBabyBillEntryCollection)get("entrys");
    }
    /**
     * Object:出雏单old's 是否生成凭证property 
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
     * Object: 出雏单old 's 操作员 property 
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
     * Object:出雏单old's 审核时间property 
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
     * Object:出雏单old's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:出雏单old's 备注property 
     */
    public String getTransDescription()
    {
        return getString("transDescription");
    }
    public void setTransDescription(String item)
    {
        setString("transDescription", item);
    }
    /**
     * Object: 出雏单old 's 转箱单 property 
     */
    public com.kingdee.eas.farm.hatch.TranferBoxBillInfo getTransferBoxBill()
    {
        return (com.kingdee.eas.farm.hatch.TranferBoxBillInfo)get("transferBoxBill");
    }
    public void setTransferBoxBill(com.kingdee.eas.farm.hatch.TranferBoxBillInfo item)
    {
        put("transferBoxBill", item);
    }
    /**
     * Object: 出雏单old 's 鸡苗去向 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getCommercialStoorg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("commercialStoorg");
    }
    public void setCommercialStoorg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("commercialStoorg", item);
    }
    /**
     * Object: 出雏单old 's 免疫分录 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.hatch.HatchBabyBillImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: 出雏单old 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrg");
    }
    public void setStorageOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrg", item);
    }
    /**
     * Object: 出雏单old 's 财务组织 property 
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
     * Object:出雏单old's 转箱量property 
     */
    public int getAllTransQty()
    {
        return getInt("allTransQty");
    }
    public void setAllTransQty(int item)
    {
        setInt("allTransQty", item);
    }
    /**
     * Object:出雏单old's 健雏property 
     */
    public int getHealthQty()
    {
        return getInt("healthQty");
    }
    public void setHealthQty(int item)
    {
        setInt("healthQty", item);
    }
    /**
     * Object:出雏单old's 残死雏property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:出雏单old's 损耗property 
     */
    public int getLossQty()
    {
        return getInt("lossQty");
    }
    public void setLossQty(int item)
    {
        setInt("lossQty", item);
    }
    /**
     * Object:出雏单old's 其他损耗property 
     */
    public int getOtherLossQty()
    {
        return getInt("otherLossQty");
    }
    public void setOtherLossQty(int item)
    {
        setInt("otherLossQty", item);
    }
    /**
     * Object:出雏单old's 毛蛋property 
     */
    public int getUnhatchedEggQty()
    {
        return getInt("unhatchedEggQty");
    }
    public void setUnhatchedEggQty(int item)
    {
        setInt("unhatchedEggQty", item);
    }
    /**
     * Object: 出雏单old 's 鸡苗去向二 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getOtherStoorg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("otherStoorg");
    }
    public void setOtherStoorg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("otherStoorg", item);
    }
    /**
     * Object:出雏单old's 去向二健雏数property 
     */
    public int getOtherHealthQty()
    {
        return getInt("otherHealthQty");
    }
    public void setOtherHealthQty(int item)
    {
        setInt("otherHealthQty", item);
    }
    /**
     * Object:出雏单old's 去向一健雏数property 
     */
    public int getOneHealthQty()
    {
        return getInt("oneHealthQty");
    }
    public void setOneHealthQty(int item)
    {
        setInt("oneHealthQty", item);
    }
    /**
     * Object: 出雏单old 's 外销分录 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryCollection getSaleEntry()
    {
        return (com.kingdee.eas.farm.hatch.HatchBabyBillSaleEntryCollection)get("SaleEntry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("065CC30F");
    }
}