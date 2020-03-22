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
     * Object:������ͬ's �Ƿ�����ƾ֤property 
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
     * Object: ������ͬ 's ��ͬ���� property 
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
     * Object:������ͬ's ��ͬ��ʼ����property 
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
     * Object:������ͬ's ��ͬ��ֹ����property 
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
     * Object:������ͬ's ��������property 
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
     * Object:������ͬ's ����״̬property 
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
     * Object:������ͬ's ���ʱ��property 
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
     * Object:������ͬ's ��עproperty 
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
     * Object: ������ͬ 's ��˾ property 
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
     * Object: ������ͬ 's ��ֳ�� property 
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
     * Object: ������ͬ 's ��ֳ�� property 
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
     * Object:������ͬ's ��ֳ��ģproperty 
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
     * Object: ������ͬ 's ���߷�¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryCollection getPolicyEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractPolicyEntryCollection)get("PolicyEntry");
    }
    /**
     * Object: ������ͬ 's ҵ��Ա property 
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
     * Object:������ͬ's ��������property 
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
     * Object: ������ͬ 's ��ֳ����� property 
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
     * Object:������ͬ's ���֤����property 
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
     * Object:������ͬ's ��ֳ����ַproperty 
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
     * Object:������ͬ's ��ʼ����������property 
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
     * Object:������ͬ's �ۼƽ�������property 
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
     * Object:������ͬ's ��ʼ���������property 
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
     * Object:������ͬ's �ۼƲ������property 
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
     * Object: ������ͬ 's �������� property 
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