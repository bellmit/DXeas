package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPreBillOfContractInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractPreBillOfContractInfo()
    {
        this("id");
    }
    protected AbstractPreBillOfContractInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:合同预报单's 是否生成凭证property 
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
     * Object:合同预报单's 是否连养property 
     */
    public boolean isIsSuccessive()
    {
        return getBoolean("isSuccessive");
    }
    public void setIsSuccessive(boolean item)
    {
        setBoolean("isSuccessive", item);
    }
    /**
     * Object:合同预报单's 联系方式property 
     */
    public String getPartyBCell()
    {
        return getString("partyBCell");
    }
    public void setPartyBCell(String item)
    {
        setString("partyBCell", item);
    }
    /**
     * Object:合同预报单's 预计签订日期property 
     */
    public java.util.Date getEstiSignDate()
    {
        return getDate("estiSignDate");
    }
    public void setEstiSignDate(java.util.Date item)
    {
        setDate("estiSignDate", item);
    }
    /**
     * Object:合同预报单's 原料员property 
     */
    public String getMaterialClerk()
    {
        return getString("materialClerk");
    }
    public void setMaterialClerk(String item)
    {
        setString("materialClerk", item);
    }
    /**
     * Object:合同预报单's 预计上苗数量property 
     */
    public java.math.BigDecimal getEstiInQty()
    {
        return getBigDecimal("estiInQty");
    }
    public void setEstiInQty(java.math.BigDecimal item)
    {
        setBigDecimal("estiInQty", item);
    }
    /**
     * Object:合同预报单's 预计上苗日期property 
     */
    public java.util.Date getEstiInDate()
    {
        return getDate("estiInDate");
    }
    public void setEstiInDate(java.util.Date item)
    {
        setDate("estiInDate", item);
    }
    /**
     * Object:合同预报单's 连养批次数property 
     */
    public int getSuccessiveBatchQty()
    {
        return getInt("SuccessiveBatchQty");
    }
    public void setSuccessiveBatchQty(int item)
    {
        setInt("SuccessiveBatchQty", item);
    }
    /**
     * Object:合同预报单's 保底价格property 
     */
    public java.math.BigDecimal getSafePrice()
    {
        return getBigDecimal("safePrice");
    }
    public void setSafePrice(java.math.BigDecimal item)
    {
        setBigDecimal("safePrice", item);
    }
    /**
     * Object:合同预报单's 单只保证金property 
     */
    public java.math.BigDecimal getPromisePrice()
    {
        return getBigDecimal("promisePrice");
    }
    public void setPromisePrice(java.math.BigDecimal item)
    {
        setBigDecimal("promisePrice", item);
    }
    /**
     * Object:合同预报单's 是否签订正式合同property 
     */
    public boolean isIsSignContract()
    {
        return getBoolean("isSignContract");
    }
    public void setIsSignContract(boolean item)
    {
        setBoolean("isSignContract", item);
    }
    /**
     * Object: 合同预报单 's 合同类别 property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractTypeInfo getContractType()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractTypeInfo)get("contractType");
    }
    public void setContractType(com.kingdee.eas.custom.signwasthetable.ContractTypeInfo item)
    {
        put("contractType", item);
    }
    /**
     * Object: 合同预报单 's 养殖场 property 
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
     * Object: 合同预报单 's 公司 property 
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
     * Object:合同预报单's 备注property 
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
     * Object: 合同预报单 's 保证金政策 property 
     */
    public com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo getBailPolicy()
    {
        return (com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo)get("bailPolicy");
    }
    public void setBailPolicy(com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo item)
    {
        put("bailPolicy", item);
    }
    /**
     * Object:合同预报单's 场长联系方式property 
     */
    public int getHeardcell()
    {
        return getInt("heardcell");
    }
    public void setHeardcell(int item)
    {
        setInt("heardcell", item);
    }
    /**
     * Object: 合同预报单 's 供应商 property 
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
     * Object: 合同预报单 's 原料员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPurchasePeron()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("purchasePeron");
    }
    public void setPurchasePeron(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("purchasePeron", item);
    }
    /**
     * Object: 合同预报单 's 结算政策 property 
     */
    public com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object:合同预报单's 政策价格property 
     */
    public java.math.BigDecimal getPolicyPrice()
    {
        return getBigDecimal("policyPrice");
    }
    public void setPolicyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("policyPrice", item);
    }
    /**
     * Object:合同预报单's 合同价格property 
     */
    public java.math.BigDecimal getContractPrice()
    {
        return getBigDecimal("contractPrice");
    }
    public void setContractPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractPrice", item);
    }
    /**
     * Object:合同预报单's 建厂时间property 
     */
    public java.util.Date getBuildDate()
    {
        return getDate("buildDate");
    }
    public void setBuildDate(java.util.Date item)
    {
        setDate("buildDate", item);
    }
    /**
     * Object:合同预报单's 标准里程数property 
     */
    public java.math.BigDecimal getMilesStd()
    {
        return getBigDecimal("milesStd");
    }
    public void setMilesStd(java.math.BigDecimal item)
    {
        setBigDecimal("milesStd", item);
    }
    /**
     * Object:合同预报单's 每舍规格(万只)property 
     */
    public String getEveyHomeNum()
    {
        return getString("eveyHomeNum");
    }
    public void setEveyHomeNum(String item)
    {
        setString("eveyHomeNum", item);
    }
    /**
     * Object:合同预报单's 舍数property 
     */
    public java.math.BigDecimal getHomeNum()
    {
        return getBigDecimal("homeNum");
    }
    public void setHomeNum(java.math.BigDecimal item)
    {
        setBigDecimal("homeNum", item);
    }
    /**
     * Object:合同预报单's 养殖方式property 
     */
    public com.kingdee.eas.custom.taihe.contract.FeedType getFeedingType()
    {
        return com.kingdee.eas.custom.taihe.contract.FeedType.getEnum(getString("feedingType"));
    }
    public void setFeedingType(com.kingdee.eas.custom.taihe.contract.FeedType item)
    {
		if (item != null) {
        setString("feedingType", item.getValue());
		}
    }
    /**
     * Object:合同预报单's 是否禁养区property 
     */
    public boolean isProhibitArea()
    {
        return getBoolean("prohibitArea");
    }
    public void setProhibitArea(boolean item)
    {
        setBoolean("prohibitArea", item);
    }
    /**
     * Object: 合同预报单 's 连养合同 property 
     */
    public com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo getSuccessiveContract()
    {
        return (com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo)get("successiveContract");
    }
    public void setSuccessiveContract(com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo item)
    {
        put("successiveContract", item);
    }
    /**
     * Object:合同预报单's 养殖厂场长property 
     */
    public String getHeard()
    {
        return getString("heard");
    }
    public void setHeard(String item)
    {
        setString("heard", item);
    }
    /**
     * Object:合同预报单's 养殖场规模(万只)property 
     */
    public java.math.BigDecimal getFarmScale()
    {
        return getBigDecimal("farmScale");
    }
    public void setFarmScale(java.math.BigDecimal item)
    {
        setBigDecimal("farmScale", item);
    }
    /**
     * Object:合同预报单's 是否新供应商property 
     */
    public boolean isIsSupplier()
    {
        return getBoolean("isSupplier");
    }
    public void setIsSupplier(boolean item)
    {
        setBoolean("isSupplier", item);
    }
    /**
     * Object:合同预报单's 是否新养殖场property 
     */
    public boolean isIsFarm()
    {
        return getBoolean("isFarm");
    }
    public void setIsFarm(boolean item)
    {
        setBoolean("isFarm", item);
    }
    /**
     * Object:合同预报单's 新供应商名称property 
     */
    public String getNewSupplier()
    {
        return getString("newSupplier");
    }
    public void setNewSupplier(String item)
    {
        setString("newSupplier", item);
    }
    /**
     * Object:合同预报单's 新养殖场名称property 
     */
    public String getNewFarm()
    {
        return getString("newFarm");
    }
    public void setNewFarm(String item)
    {
        setString("newFarm", item);
    }
    /**
     * Object:合同预报单's 场长联系方式property 
     */
    public String getHeardcell1()
    {
        return getString("heardcell1");
    }
    public void setHeardcell1(String item)
    {
        setString("heardcell1", item);
    }
    /**
     * Object:合同预报单's 养殖场地址property 
     */
    public String getFarmside()
    {
        return getString("farmside");
    }
    public void setFarmside(String item)
    {
        setString("farmside", item);
    }
    /**
     * Object:合同预报单's 优质鸡加价property 
     */
    public String getYzjincrease()
    {
        return getString("yzjincrease");
    }
    public void setYzjincrease(String item)
    {
        setString("yzjincrease", item);
    }
    /**
     * Object:合同预报单's 鸡苗来源property 
     */
    public String getChickenSource()
    {
        return getString("chickenSource");
    }
    public void setChickenSource(String item)
    {
        setString("chickenSource", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D4B2F957");
    }
}