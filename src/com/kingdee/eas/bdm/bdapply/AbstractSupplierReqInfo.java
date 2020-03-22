package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSupplierReqInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSupplierReqInfo()
    {
        this("id");
    }
    protected AbstractSupplierReqInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��Ӧ���������뵥's �Ƿ�����ƾ֤property 
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
     * Object:��Ӧ���������뵥's ���property 
     */
    public String getSimplename()
    {
        return getString("simplename");
    }
    public void setSimplename(String item)
    {
        setString("simplename", item);
    }
    /**
     * Object:��Ӧ���������뵥's ��������property 
     */
    public String getForeignName()
    {
        return getString("foreignName");
    }
    public void setForeignName(String item)
    {
        setString("foreignName", item);
    }
    /**
     * Object:��Ӧ���������뵥's ������property 
     */
    public String getMnemonicCode()
    {
        return getString("mnemonicCode");
    }
    public void setMnemonicCode(String item)
    {
        setString("mnemonicCode", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's �ϼ���Ӧ�� property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getParent()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��Ӧ���������뵥's ͳһ������ô���property 
     */
    public String getTaxRegisterNo()
    {
        return getString("taxRegisterNo");
    }
    public void setTaxRegisterNo(String item)
    {
        setString("taxRegisterNo", item);
    }
    /**
     * Object:��Ӧ���������뵥's ����/��Ӫ���֤property 
     */
    public String getBusiExequatur()
    {
        return getString("busiExequatur");
    }
    public void setBusiExequatur(String item)
    {
        setString("busiExequatur", item);
    }
    /**
     * Object:��Ӧ���������뵥's GSP��֤property 
     */
    public String getGSPAuthentication()
    {
        return getString("GSPAuthentication");
    }
    public void setGSPAuthentication(String item)
    {
        setString("GSPAuthentication", item);
    }
    /**
     * Object:��Ӧ���������뵥's ���˴���property 
     */
    public String getArtificialPerson()
    {
        return getString("artificialPerson");
    }
    public void setArtificialPerson(String item)
    {
        setString("artificialPerson", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's ��ҵ property 
     */
    public com.kingdee.eas.basedata.assistant.IndustryInfo getIndustry()
    {
        return (com.kingdee.eas.basedata.assistant.IndustryInfo)get("industry");
    }
    public void setIndustry(com.kingdee.eas.basedata.assistant.IndustryInfo item)
    {
        put("industry", item);
    }
    /**
     * Object:��Ӧ���������뵥's ������property 
     */
    public String getBarcode()
    {
        return getString("barcode");
    }
    public void setBarcode(String item)
    {
        setString("barcode", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's ���� property 
     */
    public com.kingdee.eas.basedata.assistant.CountryInfo getCountry()
    {
        return (com.kingdee.eas.basedata.assistant.CountryInfo)get("country");
    }
    public void setCountry(com.kingdee.eas.basedata.assistant.CountryInfo item)
    {
        put("country", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's ���� property 
     */
    public com.kingdee.eas.basedata.assistant.CityInfo getCity()
    {
        return (com.kingdee.eas.basedata.assistant.CityInfo)get("city");
    }
    public void setCity(com.kingdee.eas.basedata.assistant.CityInfo item)
    {
        put("city", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's ���� property 
     */
    public com.kingdee.eas.basedata.assistant.RegionInfo getRegion()
    {
        return (com.kingdee.eas.basedata.assistant.RegionInfo)get("region");
    }
    public void setRegion(com.kingdee.eas.basedata.assistant.RegionInfo item)
    {
        put("region", item);
    }
    /**
     * Object:��Ӧ���������뵥's ��ַproperty 
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
     * Object:��Ӧ���������뵥's ��Ӧ��״̬property 
     */
    public com.kingdee.eas.basedata.master.cssp.UsedStatusEnum getUserstated()
    {
        return com.kingdee.eas.basedata.master.cssp.UsedStatusEnum.getEnum(getInt("userstated"));
    }
    public void setUserstated(com.kingdee.eas.basedata.master.cssp.UsedStatusEnum item)
    {
		if (item != null) {
        setInt("userstated", item.getValue());
		}
    }
    /**
     * Object:��Ӧ���������뵥's �޸İ汾property 
     */
    public String getVesion()
    {
        return getString("vesion");
    }
    public void setVesion(String item)
    {
        setString("vesion", item);
    }
    /**
     * Object:��Ӧ���������뵥's ����property 
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
     * Object: ��Ӧ���������뵥 's ˰�� property 
     */
    public com.kingdee.eas.basedata.assistant.TaxDataInfo getTaxData()
    {
        return (com.kingdee.eas.basedata.assistant.TaxDataInfo)get("taxData");
    }
    public void setTaxData(com.kingdee.eas.basedata.assistant.TaxDataInfo item)
    {
        put("taxData", item);
    }
    /**
     * Object:��Ӧ���������뵥's ˰��property 
     */
    public java.math.BigDecimal getTaxRate()
    {
        return getBigDecimal("taxRate");
    }
    public void setTaxRate(java.math.BigDecimal item)
    {
        setBigDecimal("taxRate", item);
    }
    /**
     * Object:��Ӧ���������뵥's BIMUDF0026property 
     */
    public int getBIMUDF0026()
    {
        return getInt("BIMUDF0026");
    }
    public void setBIMUDF0026(int item)
    {
        setInt("BIMUDF0026", item);
    }
    /**
     * Object:��Ӧ���������뵥's ������ɫproperty 
     */
    public int getColordisplay()
    {
        return getInt("colordisplay");
    }
    public void setColordisplay(int item)
    {
        setInt("colordisplay", item);
    }
    /**
     * Object:��Ӧ���������뵥's ����״̬property 
     */
    public com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus getBillStatus()
    {
        return com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:��Ӧ���������뵥's ����ԭ��property 
     */
    public String getErrorMsg()
    {
        return getString("errorMsg");
    }
    public void setErrorMsg(String item)
    {
        setString("errorMsg", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's ��Ӧ�̷��� property 
     */
    public com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo getCSSGroup()
    {
        return (com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo)get("CSSGroup");
    }
    public void setCSSGroup(com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo item)
    {
        put("CSSGroup", item);
    }
    /**
     * Object:��Ӧ���������뵥's ������property 
     */
    public String getBank()
    {
        return getString("bank");
    }
    public void setBank(String item)
    {
        setString("bank", item);
    }
    /**
     * Object:��Ӧ���������뵥's �����˺�property 
     */
    public String getAccountNum()
    {
        return getString("accountNum");
    }
    public void setAccountNum(String item)
    {
        setString("accountNum", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's ʡ�� property 
     */
    public com.kingdee.eas.basedata.assistant.ProvinceInfo getProvince()
    {
        return (com.kingdee.eas.basedata.assistant.ProvinceInfo)get("province");
    }
    public void setProvince(com.kingdee.eas.basedata.assistant.ProvinceInfo item)
    {
        put("province", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's ��˾ property 
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
     * Object: ��Ӧ���������뵥 's �ɹ���֯ property 
     */
    public com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo getPurInOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo)get("purInOrgUnit");
    }
    public void setPurInOrgUnit(com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo item)
    {
        put("purInOrgUnit", item);
    }
    /**
     * Object: ��Ӧ���������뵥 's �������� property 
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
     * Object:��Ӧ���������뵥's ��ϵ��property 
     */
    public String getLinkMan()
    {
        return getString("linkMan");
    }
    public void setLinkMan(String item)
    {
        setString("linkMan", item);
    }
    /**
     * Object:��Ӧ���������뵥's ��ϵ��ʽproperty 
     */
    public String getLinkCell()
    {
        return getString("linkCell");
    }
    public void setLinkCell(String item)
    {
        setString("linkCell", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("034B4A5B");
    }
}