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
     * Object:��ֳ�������'s �Ƿ�����ƾ֤property 
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
     * Object:��ֳ�������'s �ͻ�����property 
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
     * Object:��ֳ�������'s ���֤��property 
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
     * Object:��ֳ�������'s ��ͥסַproperty 
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
     * Object:��ֳ�������'s �����ַproperty 
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
     * Object:��ֳ�������'s ��ֳ����property 
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
     * Object:��ֳ�������'s ��ֳˮƽproperty 
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
     * Object:��ֳ�������'s ��������property 
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
     * Object:��ֳ�������'s �������property 
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
     * Object:��ֳ�������'s �����Ƿ��ѵ�Ѻproperty 
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
     * Object:��ֳ�������'s ��ֳ��ʽproperty 
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
     * Object:��ֳ�������'s ������ʩproperty 
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
     * Object:��ֳ�������'s �Ƿ��д���property 
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
     * Object:��ֳ�������'s �ͻ��ڱ�property 
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
     * Object:��ֳ�������'s ��ͬģʽproperty 
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
     * Object: ��ֳ������� 's ���ʿͻ� property 
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
     * Object: ��ֳ������� 's ���ʹ�Ӧ�� property 
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
     * Object: ��ֳ������� 's ԭ������ property 
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
     * Object:��ֳ�������'s ������ʩproperty 
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
     * Object:��ֳ�������'s ���ʱ��property 
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
     * Object:��ֳ�������'s ����˵��property 
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
     * Object:��ֳ�������'s �ۺ�����property 
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