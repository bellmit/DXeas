package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmPollingBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmPollingBillInfo()
    {
        this("id");
    }
    protected AbstractFarmPollingBillInfo(String pkField)
    {
        super(pkField);
        put("InventoryEntry", new com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInventoryEntryCollection());
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
    public com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInventoryEntryCollection getInventoryEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInventoryEntryCollection)get("InventoryEntry");
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
     * Object:巡场记录's 存栏property 
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
     * Object:巡场记录's 死淘property 
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
     * Object: 巡场记录 's 批次 property 
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
     * Object: 巡场记录 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmers()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmers");
    }
    public void setFarmers(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmers", item);
    }
    /**
     * Object: 巡场记录 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarms()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farms");
    }
    public void setFarms(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farms", item);
    }
    /**
     * Object:巡场记录's 签名数据property 
     */
    public byte[] getSignData()
    {
        return (byte[])get("signData");
    }
    public void setSignData(byte[] item)
    {
        put("signData", item);
    }
    /**
     * Object: 巡场记录 's 批次合同 property 
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
     * Object:巡场记录's 总死淘数property 
     */
    public java.math.BigDecimal getAllDeathQty()
    {
        return getBigDecimal("allDeathQty");
    }
    public void setAllDeathQty(java.math.BigDecimal item)
    {
        setBigDecimal("allDeathQty", item);
    }
    /**
     * Object:巡场记录's 当日死淘率property 
     */
    public java.math.BigDecimal getTodayDeatchRate()
    {
        return getBigDecimal("todayDeatchRate");
    }
    public void setTodayDeatchRate(java.math.BigDecimal item)
    {
        setBigDecimal("todayDeatchRate", item);
    }
    /**
     * Object:巡场记录's 八日龄死淘数property 
     */
    public java.math.BigDecimal getEightDayDeathQty()
    {
        return getBigDecimal("eightDayDeathQty");
    }
    public void setEightDayDeathQty(java.math.BigDecimal item)
    {
        setBigDecimal("eightDayDeathQty", item);
    }
    /**
     * Object:巡场记录's 八日龄死淘率property 
     */
    public java.math.BigDecimal getEightDayDeathRate()
    {
        return getBigDecimal("eightDayDeathRate");
    }
    public void setEightDayDeathRate(java.math.BigDecimal item)
    {
        setBigDecimal("eightDayDeathRate", item);
    }
    /**
     * Object:巡场记录's 累计死淘率property 
     */
    public java.math.BigDecimal getTotalDeathRate()
    {
        return getBigDecimal("totalDeathRate");
    }
    public void setTotalDeathRate(java.math.BigDecimal item)
    {
        setBigDecimal("totalDeathRate", item);
    }
    /**
     * Object:巡场记录's 日喂料量(kg)property 
     */
    public java.math.BigDecimal getDayFeed()
    {
        return getBigDecimal("dayFeed");
    }
    public void setDayFeed(java.math.BigDecimal item)
    {
        setBigDecimal("dayFeed", item);
    }
    /**
     * Object:巡场记录's 只鸡日吃料量property 
     */
    public java.math.BigDecimal getOneChickendayFeed()
    {
        return getBigDecimal("oneChickendayFeed");
    }
    public void setOneChickendayFeed(java.math.BigDecimal item)
    {
        setBigDecimal("oneChickendayFeed", item);
    }
    /**
     * Object:巡场记录's 实际剩料(kg)property 
     */
    public java.math.BigDecimal getActualRestFeed()
    {
        return getBigDecimal("actualRestFeed");
    }
    public void setActualRestFeed(java.math.BigDecimal item)
    {
        setBigDecimal("actualRestFeed", item);
    }
    /**
     * Object:巡场记录's 剩料情况可用天数property 
     */
    public java.math.BigDecimal getRestFeedDays()
    {
        return getBigDecimal("restFeedDays");
    }
    public void setRestFeedDays(java.math.BigDecimal item)
    {
        setBigDecimal("restFeedDays", item);
    }
    /**
     * Object:巡场记录's 标准总耗料property 
     */
    public java.math.BigDecimal getStandAllFeed()
    {
        return getBigDecimal("standAllFeed");
    }
    public void setStandAllFeed(java.math.BigDecimal item)
    {
        setBigDecimal("standAllFeed", item);
    }
    /**
     * Object:巡场记录's 实际总耗料property 
     */
    public java.math.BigDecimal getActualAllFeed()
    {
        return getBigDecimal("actualAllFeed");
    }
    public void setActualAllFeed(java.math.BigDecimal item)
    {
        setBigDecimal("actualAllFeed", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("862C8570");
    }
}