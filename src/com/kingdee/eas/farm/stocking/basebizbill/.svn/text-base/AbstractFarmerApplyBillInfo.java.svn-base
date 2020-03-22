package com.kingdee.eas.farm.stocking.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerApplyBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmerApplyBillInfo()
    {
        this("id");
    }
    protected AbstractFarmerApplyBillInfo(String pkField)
    {
        super(pkField);
        put("FarmEntry", new com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFarmEntryCollection());
        put("entrys", new com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillEntryCollection());
    }
    /**
     * Object: 养户资格申请 's 评定分录 property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillEntryCollection)get("entrys");
    }
    /**
     * Object:养户资格申请's 是否生成凭证property 
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
     * Object:养户资格申请's 单据状态property 
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
     * Object: 养户资格申请 's 财务组织 property 
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
     * Object:养户资格申请's 姓名property 
     */
    public String getName()
    {
        return getString("name");
    }
    public void setName(String item)
    {
        setString("name", item);
    }
    /**
     * Object:养户资格申请's 性别property 
     */
    public com.kingdee.eas.basedata.person.Genders getSex()
    {
        return com.kingdee.eas.basedata.person.Genders.getEnum(getInt("sex"));
    }
    public void setSex(com.kingdee.eas.basedata.person.Genders item)
    {
		if (item != null) {
        setInt("sex", item.getValue());
		}
    }
    /**
     * Object:养户资格申请's 身份证号码property 
     */
    public String getIdentity()
    {
        return getString("identity");
    }
    public void setIdentity(String item)
    {
        setString("identity", item);
    }
    /**
     * Object:养户资格申请's 手机号码property 
     */
    public String getMobileTel()
    {
        return getString("mobileTel");
    }
    public void setMobileTel(String item)
    {
        setString("mobileTel", item);
    }
    /**
     * Object:养户资格申请's 固定电话property 
     */
    public String getTel()
    {
        return getString("tel");
    }
    public void setTel(String item)
    {
        setString("tel", item);
    }
    /**
     * Object:养户资格申请's 地址property 
     */
    public String getAddress()
    {
        return getString("address");
    }
    public void setAddress(String item)
    {
        setString("address", item);
    }
    /**
     * Object:养户资格申请's 银行账号property 
     */
    public String getBankNo()
    {
        return getString("bankNo");
    }
    public void setBankNo(String item)
    {
        setString("bankNo", item);
    }
    /**
     * Object:养户资格申请's 银行名称property 
     */
    public String getBankName()
    {
        return getString("bankName");
    }
    public void setBankName(String item)
    {
        setString("bankName", item);
    }
    /**
     * Object:养户资格申请's 审核时间property 
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
     * Object: 养户资格申请 's 养殖场信息 property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFarmEntryCollection getFarmEntry()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFarmEntryCollection)get("FarmEntry");
    }
    /**
     * Object:养户资格申请's 养殖经验(年)property 
     */
    public java.math.BigDecimal getExperience()
    {
        return getBigDecimal("experience");
    }
    public void setExperience(java.math.BigDecimal item)
    {
        setBigDecimal("experience", item);
    }
    /**
     * Object:养户资格申请's 养殖水平property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum getBreedLvl()
    {
        return com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum.getEnum(getInt("breedLvl"));
    }
    public void setBreedLvl(com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum item)
    {
		if (item != null) {
        setInt("breedLvl", item.getValue());
		}
    }
    /**
     * Object:养户资格申请's 综合评分property 
     */
    public java.math.BigDecimal getScore()
    {
        return getBigDecimal("score");
    }
    public void setScore(java.math.BigDecimal item)
    {
        setBigDecimal("score", item);
    }
    /**
     * Object: 养户资格申请 's 评分人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSsessmentPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("ssessmentPerson");
    }
    public void setSsessmentPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("ssessmentPerson", item);
    }
    /**
     * Object:养户资格申请's 是否模板property 
     */
    public boolean isIsTemplate()
    {
        return getBoolean("isTemplate");
    }
    public void setIsTemplate(boolean item)
    {
        setBoolean("isTemplate", item);
    }
    /**
     * Object:养户资格申请's 养户口碑property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum getWoM()
    {
        return com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum.getEnum(getInt("WoM"));
    }
    public void setWoM(com.kingdee.eas.farm.stocking.basedata.BreedLvlEnum item)
    {
		if (item != null) {
        setInt("WoM", item.getValue());
		}
    }
    /**
     * Object:养户资格申请's 综合结论property 
     */
    public com.kingdee.eas.farm.stocking.basedata.CheckResultEnum getCheckResult()
    {
        return com.kingdee.eas.farm.stocking.basedata.CheckResultEnum.getEnum(getInt("checkResult"));
    }
    public void setCheckResult(com.kingdee.eas.farm.stocking.basedata.CheckResultEnum item)
    {
		if (item != null) {
        setInt("checkResult", item.getValue());
		}
    }
    /**
     * Object: 养户资格申请 's 养殖户 property 
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
     * Object: 养户资格申请 's 养户分类 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo getFarmerGroup()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo)get("farmerGroup");
    }
    public void setFarmerGroup(com.kingdee.eas.farm.stocking.basedata.FarmersTreeInfo item)
    {
        put("farmerGroup", item);
    }
    /**
     * Object:养户资格申请's 年龄property 
     */
    public int getAge()
    {
        return getInt("age");
    }
    public void setAge(int item)
    {
        setInt("age", item);
    }
    /**
     * Object:养户资格申请's 民族property 
     */
    public String getNation()
    {
        return getString("nation");
    }
    public void setNation(String item)
    {
        setString("nation", item);
    }
    /**
     * Object:养户资格申请's 文化程度property 
     */
    public com.kingdee.eas.farm.stocking.basedata.EduLvlEnum getEduLvl()
    {
        return com.kingdee.eas.farm.stocking.basedata.EduLvlEnum.getEnum(getInt("eduLvl"));
    }
    public void setEduLvl(com.kingdee.eas.farm.stocking.basedata.EduLvlEnum item)
    {
		if (item != null) {
        setInt("eduLvl", item.getValue());
		}
    }
    /**
     * Object:养户资格申请's 家庭人口数property 
     */
    public int getFamilyPeronCount()
    {
        return getInt("familyPeronCount");
    }
    public void setFamilyPeronCount(int item)
    {
        setInt("familyPeronCount", item);
    }
    /**
     * Object:养户资格申请's 银行开户人姓名property 
     */
    public String getBankAccountNo()
    {
        return getString("bankAccountNo");
    }
    public void setBankAccountNo(String item)
    {
        setString("bankAccountNo", item);
    }
    /**
     * Object: 养户资格申请 's 银行 property 
     */
    public com.kingdee.eas.fm.be.BEBankInfo getBEBank()
    {
        return (com.kingdee.eas.fm.be.BEBankInfo)get("BEBank");
    }
    public void setBEBank(com.kingdee.eas.fm.be.BEBankInfo item)
    {
        put("BEBank", item);
    }
    /**
     * Object:养户资格申请's 养户实名property 
     */
    public String getActualName()
    {
        return getString("actualName");
    }
    public void setActualName(String item)
    {
        setString("actualName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E7125F71");
    }
}