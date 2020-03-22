package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFarmerInfo()
    {
        this("id");
    }
    protected AbstractFarmerInfo(String pkField)
    {
        super(pkField);
        put("FarmEntry", new com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryCollection());
    }
    /**
     * Object: 养殖户 's 组别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:养殖户's 地址property 
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
     * Object:养殖户's 身份证号码property 
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
     * Object:养殖户's 固定电话property 
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
     * Object:养殖户's 手机号码property 
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
     * Object: 养殖户 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:养殖户's 审核时间property 
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
     * Object:养殖户's 性别property 
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
     * Object:养殖户's 养户状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 养殖户 's 系统客户 property 
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
     * Object: 养殖户 's 养殖场分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryCollection getFarmEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryCollection)get("FarmEntry");
    }
    /**
     * Object:养殖户's 银行账号property 
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
     * Object: 养殖户 's 系统供应商 property 
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
     * Object: 养殖户 's 系统成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object: 养殖户 's 财务组织 property 
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
     * Object:养殖户's 年龄property 
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
     * Object:养殖户's 民族property 
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
     * Object:养殖户's 文化程度property 
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
     * Object:养殖户's 家庭人口数property 
     */
    public int getFamilyPersonCount()
    {
        return getInt("familyPersonCount");
    }
    public void setFamilyPersonCount(int item)
    {
        setInt("familyPersonCount", item);
    }
    /**
     * Object: 养殖户 's 部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getDept()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("dept");
    }
    public void setDept(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("dept", item);
    }
    /**
     * Object: 养殖户 's 银行 property 
     */
    public com.kingdee.eas.fm.be.BEBankInfo getBEBank()
    {
        return (com.kingdee.eas.fm.be.BEBankInfo)get("bEBank");
    }
    public void setBEBank(com.kingdee.eas.fm.be.BEBankInfo item)
    {
        put("bEBank", item);
    }
    /**
     * Object:养殖户's 养殖户实名property 
     */
    public String getFarmerActualName()
    {
        return getString("farmerActualName");
    }
    public void setFarmerActualName(String item)
    {
        setString("farmerActualName", item);
    }
    /**
     * Object: 养殖户 's 对应核算项目 property 
     */
    public com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo getGeneralAsstActType()
    {
        return (com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo)get("generalAsstActType");
    }
    public void setGeneralAsstActType(com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo item)
    {
        put("generalAsstActType", item);
    }
    /**
     * Object:养殖户's 保证金总额property 
     */
    public java.math.BigDecimal getTotalMargin()
    {
        return getBigDecimal("totalMargin");
    }
    public void setTotalMargin(java.math.BigDecimal item)
    {
        setBigDecimal("totalMargin", item);
    }
    /**
     * Object:养殖户's 可用保证金property 
     */
    public java.math.BigDecimal getEnableMargin()
    {
        return getBigDecimal("enableMargin");
    }
    public void setEnableMargin(java.math.BigDecimal item)
    {
        setBigDecimal("enableMargin", item);
    }
    /**
     * Object:养殖户's 占用保证金property 
     */
    public java.math.BigDecimal getOccupyMargin()
    {
        return getBigDecimal("occupyMargin");
    }
    public void setOccupyMargin(java.math.BigDecimal item)
    {
        setBigDecimal("occupyMargin", item);
    }
    /**
     * Object: 养殖户 's 业务员 property 
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
     * Object: 养殖户 's 养殖户类别 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo getFarmerType()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo)get("farmerType");
    }
    public void setFarmerType(com.kingdee.eas.farm.carnivorous.basedata.FarmerTypeInfo item)
    {
        put("farmerType", item);
    }
    /**
     * Object:养殖户's 开户地址property 
     */
    public String getBankAddress()
    {
        return getString("bankAddress");
    }
    public void setBankAddress(String item)
    {
        setString("bankAddress", item);
    }
    /**
     * Object:养殖户's 借款总额property 
     */
    public java.math.BigDecimal getBorrowAmount()
    {
        return getBigDecimal("borrowAmount");
    }
    public void setBorrowAmount(java.math.BigDecimal item)
    {
        setBigDecimal("borrowAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FA0A7F85");
    }
}