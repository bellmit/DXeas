package com.kingdee.eas.farm.carnivorous.basebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerQualicationApplInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmerQualicationApplInfo()
    {
        this("id");
    }
    protected AbstractFarmerQualicationApplInfo(String pkField)
    {
        super(pkField);
        put("FarmEntry", new com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFarmEntryCollection());
        put("entrys", new com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplEntryCollection());
    }
    /**
     * Object: �����ʸ����� 's ������¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplEntryCollection)get("entrys");
    }
    /**
     * Object:�����ʸ�����'s �Ƿ�����ƾ֤property 
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
     * Object:�����ʸ�����'s ����״̬property 
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
     * Object: �����ʸ����� 's ������֯ property 
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
     * Object:�����ʸ�����'s ����property 
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
     * Object:�����ʸ�����'s �Ա�property 
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
     * Object:�����ʸ�����'s ���֤����property 
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
     * Object:�����ʸ�����'s �ֻ�����property 
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
     * Object:�����ʸ�����'s �̶��绰property 
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
     * Object:�����ʸ�����'s ��ַproperty 
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
     * Object:�����ʸ�����'s �����˺�property 
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
     * Object:�����ʸ�����'s ���ʱ��property 
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
     * Object: �����ʸ����� 's ��ֳ����Ϣ property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFarmEntryCollection getFarmEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.FarmerQualicationApplFarmEntryCollection)get("FarmEntry");
    }
    /**
     * Object:�����ʸ�����'s ��ֳ����(��)property 
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
     * Object:�����ʸ�����'s ��ֳˮƽproperty 
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
     * Object:�����ʸ�����'s �ۺ�����property 
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
     * Object: �����ʸ����� 's ������ property 
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
     * Object:�����ʸ�����'s �Ƿ�ģ��property 
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
     * Object:�����ʸ�����'s �����ڱ�property 
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
     * Object:�����ʸ�����'s �ۺϽ���property 
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
     * Object:�����ʸ�����'s ����property 
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
     * Object:�����ʸ�����'s ����property 
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
     * Object:�����ʸ�����'s �Ļ��̶�property 
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
     * Object:�����ʸ�����'s ��ͥ�˿���property 
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
     * Object:�����ʸ�����'s ���п���������property 
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
     * Object: �����ʸ����� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: �����ʸ����� 's ��ֳ�����(�ѷ���) property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo getFarmerGroup()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo)get("farmerGroup");
    }
    public void setFarmerGroup(com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo item)
    {
        put("farmerGroup", item);
    }
    /**
     * Object: �����ʸ����� 's ���� property 
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
     * Object:�����ʸ�����'s ��ֳ��ʵ��property 
     */
    public String getFarmActualName()
    {
        return getString("farmActualName");
    }
    public void setFarmActualName(String item)
    {
        setString("farmActualName", item);
    }
    /**
     * Object: �����ʸ����� 's ��ֳ����� property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo getFarmerGrop()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo)get("farmerGrop");
    }
    public void setFarmerGrop(com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo item)
    {
        put("farmerGrop", item);
    }
    /**
     * Object: �����ʸ����� 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getTechnologyPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("technologyPerson");
    }
    public void setTechnologyPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("technologyPerson", item);
    }
    /**
     * Object:�����ʸ�����'s ������ַproperty 
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
     * Object:�����ʸ�����'s ��������ֳ��property 
     */
    public boolean isOnlyFarm()
    {
        return getBoolean("onlyFarm");
    }
    public void setOnlyFarm(boolean item)
    {
        setBoolean("onlyFarm", item);
    }
    /**
     * Object: �����ʸ����� 's ������� property 
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
     * Object: �����ʸ����� 's ������ property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo getGuaranty()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo)get("guaranty");
    }
    public void setGuaranty(com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo item)
    {
        put("guaranty", item);
    }
    /**
     * Object:�����ʸ�����'s ������ֳ��property 
     */
    public boolean isAddFarm()
    {
        return getBoolean("addFarm");
    }
    public void setAddFarm(boolean item)
    {
        setBoolean("addFarm", item);
    }
    /**
     * Object: �����ʸ����� 's ��Ӧϵͳ�ͻ� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getSystemCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("systemCustomer");
    }
    public void setSystemCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("systemCustomer", item);
    }
    /**
     * Object: �����ʸ����� 's ��Ӧϵͳ��Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSystemSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("systemSupplier");
    }
    public void setSystemSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("systemSupplier", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A2D3105D");
    }
}