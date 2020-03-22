package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBHatchBabyBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBHatchBabyBillInfo()
    {
        this("id");
    }
    protected AbstractBHatchBabyBillInfo(String pkField)
    {
        super(pkField);
        put("SaleEntry", new com.kingdee.eas.farm.hatch.BHatchBabyBillSaleEntryCollection());
        put("SourceEntrys", new com.kingdee.eas.farm.hatch.BHatchBabyBillSourceEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.hatch.BHatchBabyBillImmuneEntryCollection());
        put("MatUserEntry", new com.kingdee.eas.farm.hatch.BHatchBabyBillMatUserEntryCollection());
        put("entrys", new com.kingdee.eas.farm.hatch.BHatchBabyBillEntryCollection());
        put("GoEntrys", new com.kingdee.eas.farm.hatch.BHatchBabyBillGoEntryCollection());
    }
    /**
     * Object: 出雏单 's 出雏明细 property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillEntryCollection)get("entrys");
    }
    /**
     * Object:出雏单's 是否生成凭证property 
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
     * Object:出雏单's 审核时间property 
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
     * Object:出雏单's 状态property 
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
     * Object:出雏单's 备注property 
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
     * Object: 出雏单 's 免疫分录 property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: 出雏单 's 库存组织 property 
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
     * Object: 出雏单 's 财务组织 property 
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
     * Object:出雏单's 正品property 
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
     * Object:出雏单's 死雏property 
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
     * Object:出雏单's 损耗property 
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
     * Object:出雏单's 毛蛋property 
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
     * Object: 出雏单 's 外销分录 property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillSaleEntryCollection getSaleEntry()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillSaleEntryCollection)get("SaleEntry");
    }
    /**
     * Object: 出雏单 's 挑苗人员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSelectBabyPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("selectBabyPerson");
    }
    public void setSelectBabyPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("selectBabyPerson", item);
    }
    /**
     * Object: 出雏单 's 免疫人员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getImmunePerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("immunePerson");
    }
    public void setImmunePerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("immunePerson", item);
    }
    /**
     * Object: 出雏单 's 孵化场 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getHatchFactory()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("hatchFactory");
    }
    public void setHatchFactory(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("hatchFactory", item);
    }
    /**
     * Object: 出雏单 's 入孵区域 property 
     */
    public com.kingdee.eas.farm.hatch.HatchAreaInfo getHatchArea()
    {
        return (com.kingdee.eas.farm.hatch.HatchAreaInfo)get("hatchArea");
    }
    public void setHatchArea(com.kingdee.eas.farm.hatch.HatchAreaInfo item)
    {
        put("hatchArea", item);
    }
    /**
     * Object: 出雏单 's 出雏汇总 property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillSourceEntryCollection getSourceEntrys()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillSourceEntryCollection)get("SourceEntrys");
    }
    /**
     * Object: 出雏单 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAdminOrg()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("adminOrg");
    }
    public void setAdminOrg(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("adminOrg", item);
    }
    /**
     * Object:出雏单's 无品property 
     */
    public int getHealthQtyB()
    {
        return getInt("healthQtyB");
    }
    public void setHealthQtyB(int item)
    {
        setInt("healthQtyB", item);
    }
    /**
     * Object:出雏单's 小苗property 
     */
    public int getNoHealthQty()
    {
        return getInt("noHealthQty");
    }
    public void setNoHealthQty(int item)
    {
        setInt("noHealthQty", item);
    }
    /**
     * Object:出雏单's 一级property 
     */
    public int getHealthQtyA1()
    {
        return getInt("healthQtyA1");
    }
    public void setHealthQtyA1(int item)
    {
        setInt("healthQtyA1", item);
    }
    /**
     * Object:出雏单's 二级property 
     */
    public int getHealthQtyA2()
    {
        return getInt("healthQtyA2");
    }
    public void setHealthQtyA2(int item)
    {
        setInt("healthQtyA2", item);
    }
    /**
     * Object:出雏单's 三级property 
     */
    public int getHealthQtyA3()
    {
        return getInt("healthQtyA3");
    }
    public void setHealthQtyA3(int item)
    {
        setInt("healthQtyA3", item);
    }
    /**
     * Object:出雏单's 种蛋类型property 
     */
    public com.kingdee.eas.farm.hatch.EggType getEggType()
    {
        return com.kingdee.eas.farm.hatch.EggType.getEnum(getString("eggType"));
    }
    public void setEggType(com.kingdee.eas.farm.hatch.EggType item)
    {
		if (item != null) {
        setString("eggType", item.getValue());
		}
    }
    /**
     * Object:出雏单's 上孵日期property 
     */
    public java.util.Date getHatchDate()
    {
        return getDate("hatchDate");
    }
    public void setHatchDate(java.util.Date item)
    {
        setDate("hatchDate", item);
    }
    /**
     * Object:出雏单's 是否完全出栏property 
     */
    public boolean isIsAllOut()
    {
        return getBoolean("isAllOut");
    }
    public void setIsAllOut(boolean item)
    {
        setBoolean("isAllOut", item);
    }
    /**
     * Object:出雏单's 照蛋日期property 
     */
    public java.util.Date getCandlingDate()
    {
        return getDate("candlingDate");
    }
    public void setCandlingDate(java.util.Date item)
    {
        setDate("candlingDate", item);
    }
    /**
     * Object:出雏单's 落盘日期property 
     */
    public java.util.Date getTrayingDate()
    {
        return getDate("trayingDate");
    }
    public void setTrayingDate(java.util.Date item)
    {
        setDate("trayingDate", item);
    }
    /**
     * Object:出雏单's 品系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGenderTy()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("genderTy"));
    }
    public void setGenderTy(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("genderTy", item.getValue());
		}
    }
    /**
     * Object: 出雏单 's 物料领用 property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillMatUserEntryCollection getMatUserEntry()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillMatUserEntryCollection)get("MatUserEntry");
    }
    /**
     * Object: 出雏单 's 去向登记 property 
     */
    public com.kingdee.eas.farm.hatch.BHatchBabyBillGoEntryCollection getGoEntrys()
    {
        return (com.kingdee.eas.farm.hatch.BHatchBabyBillGoEntryCollection)get("GoEntrys");
    }
    /**
     * Object:出雏单's 是否生产入property 
     */
    public boolean isIsManuIn()
    {
        return getBoolean("isManuIn");
    }
    public void setIsManuIn(boolean item)
    {
        setBoolean("isManuIn", item);
    }
    /**
     * Object:出雏单's 是否副产品其它入property 
     */
    public boolean isIsOtherIn()
    {
        return getBoolean("isOtherIn");
    }
    public void setIsOtherIn(boolean item)
    {
        setBoolean("isOtherIn", item);
    }
    /**
     * Object:出雏单's 是否赠雏其它入property 
     */
    public boolean isIsGiftOtherIn()
    {
        return getBoolean("isGiftOtherIn");
    }
    public void setIsGiftOtherIn(boolean item)
    {
        setBoolean("isGiftOtherIn", item);
    }
    /**
     * Object:出雏单's 是否领料出property 
     */
    public boolean isIsMaterOut()
    {
        return getBoolean("isMaterOut");
    }
    public void setIsMaterOut(boolean item)
    {
        setBoolean("isMaterOut", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CF8246A9");
    }
}