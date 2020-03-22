package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractConFeedContractInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractConFeedContractInfo()
    {
        this("id");
    }
    protected AbstractConFeedContractInfo(String pkField)
    {
        super(pkField);
        put("PolicyEntry", new com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryCollection());
        put("FeedEntrys", new com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFeedEntryCollection());
    }
    /**
     * Object:连养合同's 是否生成凭证property 
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
     * Object: 连养合同 's 合同类型 property 
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
     * Object:连养合同's 合同开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:连养合同's 合同终止日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:连养合同's 连养批数property 
     */
    public int getSuccessiveQty()
    {
        return getInt("successiveQty");
    }
    public void setSuccessiveQty(int item)
    {
        setInt("successiveQty", item);
    }
    /**
     * Object:连养合同's 单据状态property 
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
     * Object:连养合同's 审核时间property 
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
     * Object:连养合同's 备注property 
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
     * Object: 连养合同 's 公司 property 
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
     * Object: 连养合同 's 养殖户 property 
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
     * Object: 连养合同 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:连养合同's 养殖规模property 
     */
    public String getGm()
    {
        return getString("gm");
    }
    public void setGm(String item)
    {
        setString("gm", item);
    }
    /**
     * Object: 连养合同 's 政策分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryCollection getPolicyEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryCollection)get("PolicyEntry");
    }
    /**
     * Object: 连养合同 's 业务员 property 
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
     * Object:连养合同's 连养年限property 
     */
    public int getYear()
    {
        return getInt("year");
    }
    public void setYear(int item)
    {
        setInt("year", item);
    }
    /**
     * Object: 连养合同 's 养殖户类别 property 
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
     * Object:连养合同's 身份证号码property 
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
     * Object:连养合同's 养殖场地址property 
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
     * Object:连养合同's 初始化结算批次property 
     */
    public int getInitSettledNum()
    {
        return getInt("initSettledNum");
    }
    public void setInitSettledNum(int item)
    {
        setInt("initSettledNum", item);
    }
    /**
     * Object:连养合同's 累计结算批次property 
     */
    public int getCurSettledNum()
    {
        return getInt("curSettledNum");
    }
    public void setCurSettledNum(int item)
    {
        setInt("curSettledNum", item);
    }
    /**
     * Object:连养合同's 初始化补贴金额property 
     */
    public java.math.BigDecimal getInitSubsidies()
    {
        return getBigDecimal("initSubsidies");
    }
    public void setInitSubsidies(java.math.BigDecimal item)
    {
        setBigDecimal("initSubsidies", item);
    }
    /**
     * Object:连养合同's 累计补贴金额property 
     */
    public java.math.BigDecimal getCumulativeSub()
    {
        return getBigDecimal("cumulativeSub");
    }
    public void setCumulativeSub(java.math.BigDecimal item)
    {
        setBigDecimal("cumulativeSub", item);
    }
    /**
     * Object: 连养合同 's 饲养批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFeedEntryCollection getFeedEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFeedEntryCollection)get("FeedEntrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9181E08E");
    }
}