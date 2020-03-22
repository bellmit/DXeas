package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTranferBoxBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractTranferBoxBillInfo()
    {
        this("id");
    }
    protected AbstractTranferBoxBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.hatch.TranferBoxBillEntryCollection());
    }
    /**
     * Object: 转箱单 's 分录 property 
     */
    public com.kingdee.eas.farm.hatch.TranferBoxBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.TranferBoxBillEntryCollection)get("entrys");
    }
    /**
     * Object:转箱单's 是否生成凭证property 
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
     * Object: 转箱单 's 操作员 property 
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
     * Object:转箱单's 审核时间property 
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
     * Object:转箱单's 状态property 
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
     * Object: 转箱单 's 上孵单 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBillInfo getHatchBill()
    {
        return (com.kingdee.eas.farm.hatch.HatchBillInfo)get("hatchBill");
    }
    public void setHatchBill(com.kingdee.eas.farm.hatch.HatchBillInfo item)
    {
        put("hatchBill", item);
    }
    /**
     * Object:转箱单's 上孵数量property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object:转箱单's 受精蛋property 
     */
    public int getFertilizerQty()
    {
        return getInt("fertilizerQty");
    }
    public void setFertilizerQty(int item)
    {
        setInt("fertilizerQty", item);
    }
    /**
     * Object:转箱单's 无精蛋property 
     */
    public int getUnFertilizerQty()
    {
        return getInt("unFertilizerQty");
    }
    public void setUnFertilizerQty(int item)
    {
        setInt("unFertilizerQty", item);
    }
    /**
     * Object:转箱单's 臭损property 
     */
    public int getSmellyLossQty()
    {
        return getInt("smellyLossQty");
    }
    public void setSmellyLossQty(int item)
    {
        setInt("smellyLossQty", item);
    }
    /**
     * Object:转箱单's 死胚property 
     */
    public int getAddleQty()
    {
        return getInt("addleQty");
    }
    public void setAddleQty(int item)
    {
        setInt("addleQty", item);
    }
    /**
     * Object:转箱单's 转箱时间property 
     */
    public java.sql.Time getTransTime()
    {
        return getTime("transTime");
    }
    public void setTransTime(java.sql.Time item)
    {
        setTime("transTime", item);
    }
    /**
     * Object:转箱单's 备注property 
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
     * Object:转箱单's 孵化箱property 
     */
    public String getIncubator()
    {
        return getString("incubator");
    }
    public void setIncubator(String item)
    {
        setString("incubator", item);
    }
    /**
     * Object:转箱单's 转箱数property 
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
     * Object: 转箱单 's 库存组织 property 
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
     * Object: 转箱单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9DC48058");
    }
}