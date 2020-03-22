package com.kingdee.eas.farm.farmer;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerResearchBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmerResearchBillInfo()
    {
        this("id");
    }
    protected AbstractFarmerResearchBillInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:养殖户调查表's 是否生成凭证property 
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
     * Object:养殖户调查表's 客户姓名property 
     */
    public String getFarmerName()
    {
        return getString("farmerName");
    }
    public void setFarmerName(String item)
    {
        setString("farmerName", item);
    }
    /**
     * Object:养殖户调查表's 身份证号property 
     */
    public String getIDCardNo()
    {
        return getString("IDCardNo");
    }
    public void setIDCardNo(String item)
    {
        setString("IDCardNo", item);
    }
    /**
     * Object:养殖户调查表's 家庭住址property 
     */
    public String getHomeAddress()
    {
        return getString("homeAddress");
    }
    public void setHomeAddress(String item)
    {
        setString("homeAddress", item);
    }
    /**
     * Object:养殖户调查表's 棚舍地址property 
     */
    public String getFarmAddress()
    {
        return getString("farmAddress");
    }
    public void setFarmAddress(String item)
    {
        setString("farmAddress", item);
    }
    /**
     * Object:养殖户调查表's 养殖经验property 
     */
    public com.kingdee.eas.farm.farmer.BreedExperience getBreedExperience()
    {
        return com.kingdee.eas.farm.farmer.BreedExperience.getEnum(getString("breedExperience"));
    }
    public void setBreedExperience(com.kingdee.eas.farm.farmer.BreedExperience item)
    {
		if (item != null) {
        setString("breedExperience", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 养殖水平property 
     */
    public com.kingdee.eas.farm.farmer.BreedAbility getBreedLevel()
    {
        return com.kingdee.eas.farm.farmer.BreedAbility.getEnum(getString("breedLevel"));
    }
    public void setBreedLevel(com.kingdee.eas.farm.farmer.BreedAbility item)
    {
		if (item != null) {
        setString("breedLevel", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 棚舍类型property 
     */
    public com.kingdee.eas.farm.farmer.HenhouseType getHenhouseType()
    {
        return com.kingdee.eas.farm.farmer.HenhouseType.getEnum(getString("henhouseType"));
    }
    public void setHenhouseType(com.kingdee.eas.farm.farmer.HenhouseType item)
    {
		if (item != null) {
        setString("henhouseType", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 棚舍归属property 
     */
    public com.kingdee.eas.farm.farmer.HenhouseOwner getHenhouseOwn()
    {
        return com.kingdee.eas.farm.farmer.HenhouseOwner.getEnum(getString("henhouseOwn"));
    }
    public void setHenhouseOwn(com.kingdee.eas.farm.farmer.HenhouseOwner item)
    {
		if (item != null) {
        setString("henhouseOwn", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 棚舍是否已抵押property 
     */
    public boolean isHenhousePledged()
    {
        return getBoolean("henhousePledged");
    }
    public void setHenhousePledged(boolean item)
    {
        setBoolean("henhousePledged", item);
    }
    /**
     * Object:养殖户调查表's 养殖方式property 
     */
    public com.kingdee.eas.farm.farmer.BreedMode getBreedMode()
    {
        return com.kingdee.eas.farm.farmer.BreedMode.getEnum(getString("breedMode"));
    }
    public void setBreedMode(com.kingdee.eas.farm.farmer.BreedMode item)
    {
		if (item != null) {
        setString("breedMode", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 保温设施property 
     */
    public com.kingdee.eas.farm.farmer.KeepTempEquip getKeepTempEquip()
    {
        return com.kingdee.eas.farm.farmer.KeepTempEquip.getEnum(getString("keepTempEquip"));
    }
    public void setKeepTempEquip(com.kingdee.eas.farm.farmer.KeepTempEquip item)
    {
		if (item != null) {
        setString("keepTempEquip", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 是否有贷款property 
     */
    public boolean isHasLoan()
    {
        return getBoolean("hasLoan");
    }
    public void setHasLoan(boolean item)
    {
        setBoolean("hasLoan", item);
    }
    /**
     * Object:养殖户调查表's 客户口碑property 
     */
    public com.kingdee.eas.farm.farmer.PublicPraise getCustomerPublicPraice()
    {
        return com.kingdee.eas.farm.farmer.PublicPraise.getEnum(getString("customerPublicPraice"));
    }
    public void setCustomerPublicPraice(com.kingdee.eas.farm.farmer.PublicPraise item)
    {
		if (item != null) {
        setString("customerPublicPraice", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 合同模式property 
     */
    public com.kingdee.eas.farm.farmer.ContractMode getContractMode()
    {
        return com.kingdee.eas.farm.farmer.ContractMode.getEnum(getString("contractMode"));
    }
    public void setContractMode(com.kingdee.eas.farm.farmer.ContractMode item)
    {
		if (item != null) {
        setString("contractMode", item.getValue());
		}
    }
    /**
     * Object: 养殖户调查表 's 垫资客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getPayInAgency()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("payInAgency");
    }
    public void setPayInAgency(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("payInAgency", item);
    }
    /**
     * Object: 养殖户调查表 's 垫资供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getPaInSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("paInSupplier");
    }
    public void setPaInSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("paInSupplier", item);
    }
    /**
     * Object: 养殖户调查表 's 原经销商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getEverAgency()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("everAgency");
    }
    public void setEverAgency(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("everAgency", item);
    }
    /**
     * Object:养殖户调查表's 降温设施property 
     */
    public com.kingdee.eas.farm.farmer.DownTempEquip getDownTempEquip()
    {
        return com.kingdee.eas.farm.farmer.DownTempEquip.getEnum(getString("downTempEquip"));
    }
    public void setDownTempEquip(com.kingdee.eas.farm.farmer.DownTempEquip item)
    {
		if (item != null) {
        setString("downTempEquip", item.getValue());
		}
    }
    /**
     * Object:养殖户调查表's 审核时间property 
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
     * Object:养殖户调查表's 其他说明property 
     */
    public String getOtherDescription()
    {
        return getString("otherDescription");
    }
    public void setOtherDescription(String item)
    {
        setString("otherDescription", item);
    }
    /**
     * Object:养殖户调查表's 综合评分property 
     */
    public String getAllScore()
    {
        return getString("allScore");
    }
    public void setAllScore(String item)
    {
        setString("allScore", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E826F98A");
    }
}