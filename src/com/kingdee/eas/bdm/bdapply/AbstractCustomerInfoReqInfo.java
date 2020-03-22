package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerInfoReqInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCustomerInfoReqInfo()
    {
        this("id");
    }
    protected AbstractCustomerInfoReqInfo(String pkField)
    {
        super(pkField);
        put("CustomerGroupEntry", new com.kingdee.eas.bdm.bdapply.CustomerInfoReqCustomerGroupEntryCollection());
        put("SettleCustomerEntry", new com.kingdee.eas.bdm.bdapply.CustomerInfoReqSettleCustomerEntryCollection());
    }
    /**
     * Object:客户资料申请单's 是否生成凭证property 
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
     * Object:客户资料申请单's 简称property 
     */
    public String getSimpleName()
    {
        return getString("simpleName");
    }
    public void setSimpleName(String item)
    {
        setString("simpleName", item);
    }
    /**
     * Object:客户资料申请单's 外文名称property 
     */
    public String getForeignname()
    {
        return getString("foreignname");
    }
    public void setForeignname(String item)
    {
        setString("foreignname", item);
    }
    /**
     * Object:客户资料申请单's 助记码property 
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
     * Object: 客户资料申请单 's 上级客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getParent()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:客户资料申请单's 客户性质property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerKindEnum getCustomerKind()
    {
        return com.kingdee.eas.basedata.master.cssp.CustomerKindEnum.getEnum(getString("customerKind"));
    }
    public void setCustomerKind(com.kingdee.eas.basedata.master.cssp.CustomerKindEnum item)
    {
		if (item != null) {
        setString("customerKind", item.getValue());
		}
    }
    /**
     * Object:客户资料申请单's 工商注册号property 
     */
    public String getBizRegisterNo()
    {
        return getString("bizRegisterNo");
    }
    public void setBizRegisterNo(String item)
    {
        setString("bizRegisterNo", item);
    }
    /**
     * Object:客户资料申请单's 营业执照property 
     */
    public String getBusiLicence()
    {
        return getString("busiLicence");
    }
    public void setBusiLicence(String item)
    {
        setString("busiLicence", item);
    }
    /**
     * Object:客户资料申请单's 生产/经营许可证property 
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
     * Object:客户资料申请单's GSP认证property 
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
     * Object:客户资料申请单's 税务登记号property 
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
     * Object:客户资料申请单's 法人代表property 
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
     * Object: 客户资料申请单 's 行业 property 
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
     * Object:客户资料申请单's 条形码property 
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
     * Object: 客户资料申请单 's 国家 property 
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
     * Object: 客户资料申请单 's 城市 property 
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
     * Object: 客户资料申请单 's 区县 property 
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
     * Object:客户资料申请单's 地址property 
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
     * Object:客户资料申请单's 信用管理property 
     */
    public boolean isIsCredited()
    {
        return getBoolean("isCredited");
    }
    public void setIsCredited(boolean item)
    {
        setBoolean("isCredited", item);
    }
    /**
     * Object: 客户资料申请单 's 税种 property 
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
     * Object:客户资料申请单's 税率property 
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
     * Object:客户资料申请单's 开票类型property 
     */
    public com.kingdee.eas.basedata.master.cssp.PayInvoiceTypeEnum getInvoicetype()
    {
        return com.kingdee.eas.basedata.master.cssp.PayInvoiceTypeEnum.getEnum(getString("invoicetype"));
    }
    public void setInvoicetype(com.kingdee.eas.basedata.master.cssp.PayInvoiceTypeEnum item)
    {
		if (item != null) {
        setString("invoicetype", item.getValue());
		}
    }
    /**
     * Object:客户资料申请单's 客户状态property 
     */
    public com.kingdee.eas.basedata.master.cssp.UsedStatusEnum getStatus()
    {
        return com.kingdee.eas.basedata.master.cssp.UsedStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.basedata.master.cssp.UsedStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object:客户资料申请单's 修改版本property 
     */
    public int getVersion()
    {
        return getInt("version");
    }
    public void setVersion(int item)
    {
        setInt("version", item);
    }
    /**
     * Object:客户资料申请单's 名称property 
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
     * Object:客户资料申请单's 汇总property 
     */
    public boolean isIsselect()
    {
        return getBoolean("Isselect");
    }
    public void setIsselect(boolean item)
    {
        setBoolean("Isselect", item);
    }
    /**
     * Object:客户资料申请单's 单据颜色property 
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
     * Object:客户资料申请单's 单据状态property 
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
     * Object:客户资料申请单's 驳回原因property 
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
     * Object: 客户资料申请单 's 客户分类 property 
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
     * Object: 客户资料申请单 's 销售员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSalePerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("SalePerson");
    }
    public void setSalePerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("SalePerson", item);
    }
    /**
     * Object: 客户资料申请单 's 申请公司 property 
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
     * Object: 客户资料申请单 's 收款条件 property 
     */
    public com.kingdee.eas.basedata.assistant.PayConditionInfo getPayCondition()
    {
        return (com.kingdee.eas.basedata.assistant.PayConditionInfo)get("payCondition");
    }
    public void setPayCondition(com.kingdee.eas.basedata.assistant.PayConditionInfo item)
    {
        put("payCondition", item);
    }
    /**
     * Object: 客户资料申请单 's 结算币种 property 
     */
    public com.kingdee.eas.basedata.assistant.CurrencyInfo getSettlementCurrency()
    {
        return (com.kingdee.eas.basedata.assistant.CurrencyInfo)get("settlementCurrency");
    }
    public void setSettlementCurrency(com.kingdee.eas.basedata.assistant.CurrencyInfo item)
    {
        put("settlementCurrency", item);
    }
    /**
     * Object:客户资料申请单's 联系人property 
     */
    public String getContractPerson()
    {
        return getString("contractPerson");
    }
    public void setContractPerson(String item)
    {
        setString("contractPerson", item);
    }
    /**
     * Object:客户资料申请单's 联系人职务property 
     */
    public String getContractPersonPost()
    {
        return getString("contractPersonPost");
    }
    public void setContractPersonPost(String item)
    {
        setString("contractPersonPost", item);
    }
    /**
     * Object:客户资料申请单's 办公电话property 
     */
    public String getPhone()
    {
        return getString("phone");
    }
    public void setPhone(String item)
    {
        setString("phone", item);
    }
    /**
     * Object:客户资料申请单's 手机property 
     */
    public String getMobile()
    {
        return getString("mobile");
    }
    public void setMobile(String item)
    {
        setString("mobile", item);
    }
    /**
     * Object:客户资料申请单's 传真property 
     */
    public String getFax()
    {
        return getString("fax");
    }
    public void setFax(String item)
    {
        setString("fax", item);
    }
    /**
     * Object:客户资料申请单's Emailproperty 
     */
    public String getEmail()
    {
        return getString("email");
    }
    public void setEmail(String item)
    {
        setString("email", item);
    }
    /**
     * Object:客户资料申请单's 开户银行property 
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
     * Object:客户资料申请单's 银行账号property 
     */
    public String getBankAccount()
    {
        return getString("bankAccount");
    }
    public void setBankAccount(String item)
    {
        setString("bankAccount", item);
    }
    /**
     * Object:客户资料申请单's 银行地址property 
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
     * Object:客户资料申请单's 账户名称property 
     */
    public String getAccountName()
    {
        return getString("accountName");
    }
    public void setAccountName(String item)
    {
        setString("accountName", item);
    }
    /**
     * Object:客户资料申请单's 账户币别property 
     */
    public String getAccountCurrency()
    {
        return getString("accountCurrency");
    }
    public void setAccountCurrency(String item)
    {
        setString("accountCurrency", item);
    }
    /**
     * Object:客户资料申请单's 开户地区property 
     */
    public String getAccountArea()
    {
        return getString("accountArea");
    }
    public void setAccountArea(String item)
    {
        setString("accountArea", item);
    }
    /**
     * Object: 客户资料申请单 's 销售组 property 
     */
    public com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo getSaleGroup()
    {
        return (com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo)get("saleGroup");
    }
    public void setSaleGroup(com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo item)
    {
        put("saleGroup", item);
    }
    /**
     * Object: 客户资料申请单 's 销售组织 property 
     */
    public com.kingdee.eas.basedata.org.SaleOrgUnitInfo getSaleOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.SaleOrgUnitInfo)get("saleOrgUnit");
    }
    public void setSaleOrgUnit(com.kingdee.eas.basedata.org.SaleOrgUnitInfo item)
    {
        put("saleOrgUnit", item);
    }
    /**
     * Object:客户资料申请单's 送货地址property 
     */
    public String getLinkManAddress()
    {
        return getString("linkManAddress");
    }
    public void setLinkManAddress(String item)
    {
        setString("linkManAddress", item);
    }
    /**
     * Object:客户资料申请单's 联系地址property 
     */
    public String getSalerAddress()
    {
        return getString("salerAddress");
    }
    public void setSalerAddress(String item)
    {
        setString("salerAddress", item);
    }
    /**
     * Object:客户资料申请单's 邮编property 
     */
    public String getPostcode()
    {
        return getString("postcode");
    }
    public void setPostcode(String item)
    {
        setString("postcode", item);
    }
    /**
     * Object: 客户资料申请单 's 省份 property 
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
     * Object: 客户资料申请单 's 客户分类分录 property 
     */
    public com.kingdee.eas.bdm.bdapply.CustomerInfoReqCustomerGroupEntryCollection getCustomerGroupEntry()
    {
        return (com.kingdee.eas.bdm.bdapply.CustomerInfoReqCustomerGroupEntryCollection)get("CustomerGroupEntry");
    }
    /**
     * Object:客户资料申请单's 月销量property 
     */
    public java.math.BigDecimal getMonthSaleQty()
    {
        return getBigDecimal("monthSaleQty");
    }
    public void setMonthSaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("monthSaleQty", item);
    }
    /**
     * Object:客户资料申请单's 主营品牌property 
     */
    public String getPinPai()
    {
        return getString("pinPai");
    }
    public void setPinPai(String item)
    {
        setString("pinPai", item);
    }
    /**
     * Object:客户资料申请单's 主营品项property 
     */
    public String getPinXiang()
    {
        return getString("pinXiang");
    }
    public void setPinXiang(String item)
    {
        setString("pinXiang", item);
    }
    /**
     * Object:客户资料申请单's 客户类型property 
     */
    public com.kingdee.eas.bdm.bdapply.CustomerType getCustomerType()
    {
        return com.kingdee.eas.bdm.bdapply.CustomerType.getEnum(getString("customerType"));
    }
    public void setCustomerType(com.kingdee.eas.bdm.bdapply.CustomerType item)
    {
		if (item != null) {
        setString("customerType", item.getValue());
		}
    }
    /**
     * Object: 客户资料申请单 's 结账客户分录 property 
     */
    public com.kingdee.eas.bdm.bdapply.CustomerInfoReqSettleCustomerEntryCollection getSettleCustomerEntry()
    {
        return (com.kingdee.eas.bdm.bdapply.CustomerInfoReqSettleCustomerEntryCollection)get("SettleCustomerEntry");
    }
    /**
     * Object: 客户资料申请单 's 付款方式 property 
     */
    public com.kingdee.eas.basedata.assistant.PaymentTypeInfo getPayType()
    {
        return (com.kingdee.eas.basedata.assistant.PaymentTypeInfo)get("payType");
    }
    public void setPayType(com.kingdee.eas.basedata.assistant.PaymentTypeInfo item)
    {
        put("payType", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8CE1C1FB");
    }
}