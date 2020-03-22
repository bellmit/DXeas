package com.kingdee.eas.custom.farmpolling;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPollingRecordBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractPollingRecordBillInfo()
    {
        this("id");
    }
    protected AbstractPollingRecordBillInfo(String pkField)
    {
        super(pkField);
        put("InventoryEntry", new com.kingdee.eas.custom.farmpolling.PollingRecordBillInventoryEntryCollection());
    }
    /**
     * Object:巡场记录's 是否生成凭证property 
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
     * Object:巡场记录's 单据状态property 
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
     * Object: 巡场记录 's 财务组织 property 
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
     * Object: 巡场记录 's 养殖户 property 
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
     * Object: 巡场记录 's 养殖场 property 
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
     * Object: 巡场记录 's 放养批次 property 
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
     * Object: 巡场记录 's 管理员 property 
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
     * Object: 巡场记录 's 库存分录 property 
     */
    public com.kingdee.eas.custom.farmpolling.PollingRecordBillInventoryEntryCollection getInventoryEntry()
    {
        return (com.kingdee.eas.custom.farmpolling.PollingRecordBillInventoryEntryCollection)get("InventoryEntry");
    }
    /**
     * Object:巡场记录's 审核时间property 
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
     * Object:巡场记录's 日龄property 
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
     * Object:巡场记录's 棚舍温度property 
     */
    public java.math.BigDecimal getTemp()
    {
        return getBigDecimal("temp");
    }
    public void setTemp(java.math.BigDecimal item)
    {
        setBigDecimal("temp", item);
    }
    /**
     * Object:巡场记录's 棚舍湿度property 
     */
    public java.math.BigDecimal getHumidity()
    {
        return getBigDecimal("humidity");
    }
    public void setHumidity(java.math.BigDecimal item)
    {
        setBigDecimal("humidity", item);
    }
    /**
     * Object:巡场记录's 备注property 
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
     * Object:巡场记录's 外部环境卫生property 
     */
    public com.kingdee.eas.custom.farmpolling.evaluationLvEnum getOutHygiene()
    {
        return com.kingdee.eas.custom.farmpolling.evaluationLvEnum.getEnum(getInt("outHygiene"));
    }
    public void setOutHygiene(com.kingdee.eas.custom.farmpolling.evaluationLvEnum item)
    {
		if (item != null) {
        setInt("outHygiene", item.getValue());
		}
    }
    /**
     * Object:巡场记录's 棚舍环境卫生property 
     */
    public com.kingdee.eas.custom.farmpolling.evaluationLvEnum getInHygiene()
    {
        return com.kingdee.eas.custom.farmpolling.evaluationLvEnum.getEnum(getInt("inHygiene"));
    }
    public void setInHygiene(com.kingdee.eas.custom.farmpolling.evaluationLvEnum item)
    {
		if (item != null) {
        setInt("inHygiene", item.getValue());
		}
    }
    /**
     * Object:巡场记录's 设备情况property 
     */
    public String getDeviceCircumstances()
    {
        return getString("deviceCircumstances");
    }
    public void setDeviceCircumstances(String item)
    {
        setString("deviceCircumstances", item);
    }
    /**
     * Object:巡场记录's 药品情况property 
     */
    public String getDrugCircumstances()
    {
        return getString("drugCircumstances");
    }
    public void setDrugCircumstances(String item)
    {
        setString("drugCircumstances", item);
    }
    /**
     * Object:巡场记录's 签到时间property 
     */
    public java.util.Date getSignInTime()
    {
        return getDate("signInTime");
    }
    public void setSignInTime(java.util.Date item)
    {
        setDate("signInTime", item);
    }
    /**
     * Object:巡场记录's 签到地址property 
     */
    public String getSignInAddress()
    {
        return getString("signInAddress");
    }
    public void setSignInAddress(String item)
    {
        setString("signInAddress", item);
    }
    /**
     * Object:巡场记录's 签到经度property 
     */
    public java.math.BigDecimal getSignInX()
    {
        return getBigDecimal("signInX");
    }
    public void setSignInX(java.math.BigDecimal item)
    {
        setBigDecimal("signInX", item);
    }
    /**
     * Object:巡场记录's 签到维度property 
     */
    public java.math.BigDecimal getSignInY()
    {
        return getBigDecimal("signInY");
    }
    public void setSignInY(java.math.BigDecimal item)
    {
        setBigDecimal("signInY", item);
    }
    /**
     * Object:巡场记录's 签退时间property 
     */
    public java.util.Date getSignOutTime()
    {
        return getDate("signOutTime");
    }
    public void setSignOutTime(java.util.Date item)
    {
        setDate("signOutTime", item);
    }
    /**
     * Object:巡场记录's 签退地址property 
     */
    public String getSignOutAddress()
    {
        return getString("signOutAddress");
    }
    public void setSignOutAddress(String item)
    {
        setString("signOutAddress", item);
    }
    /**
     * Object:巡场记录's 签退经度property 
     */
    public java.math.BigDecimal getSignOutX()
    {
        return getBigDecimal("signOutX");
    }
    public void setSignOutX(java.math.BigDecimal item)
    {
        setBigDecimal("signOutX", item);
    }
    /**
     * Object:巡场记录's 签退维度property 
     */
    public java.math.BigDecimal getSignOutY()
    {
        return getBigDecimal("signOutY");
    }
    public void setSignOutY(java.math.BigDecimal item)
    {
        setBigDecimal("signOutY", item);
    }
    /**
     * Object:巡场记录's 是否确认property 
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
     * Object:巡场记录's 确认时间property 
     */
    public java.util.Date getConfirmTime()
    {
        return getDate("confirmTime");
    }
    public void setConfirmTime(java.util.Date item)
    {
        setDate("confirmTime", item);
    }
    /**
     * Object:巡场记录's 确认意见property 
     */
    public String getConfirmMsg()
    {
        return getString("confirmMsg");
    }
    public void setConfirmMsg(String item)
    {
        setString("confirmMsg", item);
    }
    /**
     * Object:巡场记录's 存栏_公property 
     */
    public int getStockingMaleQty()
    {
        return getInt("stockingMaleQty");
    }
    public void setStockingMaleQty(int item)
    {
        setInt("stockingMaleQty", item);
    }
    /**
     * Object:巡场记录's 存栏_母property 
     */
    public int getStockingFemaleQty()
    {
        return getInt("stockingFemaleQty");
    }
    public void setStockingFemaleQty(int item)
    {
        setInt("stockingFemaleQty", item);
    }
    /**
     * Object:巡场记录's 死淘_公property 
     */
    public int getDeathAndCullMaleQty()
    {
        return getInt("deathAndCullMaleQty");
    }
    public void setDeathAndCullMaleQty(int item)
    {
        setInt("deathAndCullMaleQty", item);
    }
    /**
     * Object:巡场记录's 死淘_母property 
     */
    public int getDeathAndCullFemaleQty()
    {
        return getInt("deathAndCullFemaleQty");
    }
    public void setDeathAndCullFemaleQty(int item)
    {
        setInt("deathAndCullFemaleQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9CFC4C15");
    }
}