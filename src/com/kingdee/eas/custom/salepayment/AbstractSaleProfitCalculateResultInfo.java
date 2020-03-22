package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleProfitCalculateResultInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSaleProfitCalculateResultInfo()
    {
        this("id");
    }
    protected AbstractSaleProfitCalculateResultInfo(String pkField)
    {
        super(pkField);
        put("FeeEntry", new com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFeeEntryCollection());
        put("MonthEntry", new com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultMonthEntryCollection());
    }
    /**
     * Object:�������������'s �Ƿ�����ƾ֤property 
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
     * Object: ������������� 's ��˾ property 
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
     * Object:�������������'s ��property 
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
     * Object:�������������'s ���ʱ��property 
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
     * Object:�������������'s ��ë��property 
     */
    public java.math.BigDecimal getAllGrossProfit()
    {
        return getBigDecimal("allGrossProfit");
    }
    public void setAllGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("allGrossProfit", item);
    }
    /**
     * Object:�������������'s ״̬property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:�������������'s ָ������property 
     */
    public com.kingdee.eas.custom.salepayment.IndexType getIndexType()
    {
        return com.kingdee.eas.custom.salepayment.IndexType.getEnum(getString("indexType"));
    }
    public void setIndexType(com.kingdee.eas.custom.salepayment.IndexType item)
    {
		if (item != null) {
        setString("indexType", item.getValue());
		}
    }
    /**
     * Object: ������������� 's ����������� property 
     */
    public com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo getSaleStimulateInfo()
    {
        return (com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo)get("saleStimulateInfo");
    }
    public void setSaleStimulateInfo(com.kingdee.eas.custom.salepayment.SalerStimulateSetInfo item)
    {
        put("saleStimulateInfo", item);
    }
    /**
     * Object:�������������'s ����property 
     */
    public com.kingdee.eas.custom.salepayment.Quarter getQuarter()
    {
        return com.kingdee.eas.custom.salepayment.Quarter.getEnum(getString("quarter"));
    }
    public void setQuarter(com.kingdee.eas.custom.salepayment.Quarter item)
    {
		if (item != null) {
        setString("quarter", item.getValue());
		}
    }
    /**
     * Object: ������������� 's ��˾ָ�� property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyTargetInfo getCompanyTarget()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyTargetInfo)get("companyTarget");
    }
    public void setCompanyTarget(com.kingdee.eas.custom.salepayment.CompanyTargetInfo item)
    {
        put("companyTarget", item);
    }
    /**
     * Object: ������������� 's ����ָ�� property 
     */
    public com.kingdee.eas.custom.salepayment.AreaTargetInfo getAreaTarget()
    {
        return (com.kingdee.eas.custom.salepayment.AreaTargetInfo)get("areaTarget");
    }
    public void setAreaTarget(com.kingdee.eas.custom.salepayment.AreaTargetInfo item)
    {
        put("areaTarget", item);
    }
    /**
     * Object:�������������'s �ؿ���ϸ��Դproperty 
     */
    public com.kingdee.eas.custom.salepayment.RecDataSource getRecDataSource()
    {
        return com.kingdee.eas.custom.salepayment.RecDataSource.getEnum(getString("recDataSource"));
    }
    public void setRecDataSource(com.kingdee.eas.custom.salepayment.RecDataSource item)
    {
		if (item != null) {
        setString("recDataSource", item.getValue());
		}
    }
    /**
     * Object:�������������'s ����ѷ�̯��ʽproperty 
     */
    public com.kingdee.eas.custom.salepayment.ManageFeeShareType getManagerFeeShareType()
    {
        return com.kingdee.eas.custom.salepayment.ManageFeeShareType.getEnum(getString("managerFeeShareType"));
    }
    public void setManagerFeeShareType(com.kingdee.eas.custom.salepayment.ManageFeeShareType item)
    {
		if (item != null) {
        setString("managerFeeShareType", item.getValue());
		}
    }
    /**
     * Object:�������������'s ������㷽ʽproperty 
     */
    public com.kingdee.eas.custom.salepayment.ProfitExeType getProfitExeType()
    {
        return com.kingdee.eas.custom.salepayment.ProfitExeType.getEnum(getString("profitExeType"));
    }
    public void setProfitExeType(com.kingdee.eas.custom.salepayment.ProfitExeType item)
    {
		if (item != null) {
        setString("profitExeType", item.getValue());
		}
    }
    /**
     * Object:�������������'s ����˰���۶�property 
     */
    public java.math.BigDecimal getNoTaxSaleAmount()
    {
        return getBigDecimal("noTaxSaleAmount");
    }
    public void setNoTaxSaleAmount(java.math.BigDecimal item)
    {
        setBigDecimal("noTaxSaleAmount", item);
    }
    /**
     * Object:�������������'s ��׼�ɱ��ϼ�property 
     */
    public java.math.BigDecimal getAllStandardCost()
    {
        return getBigDecimal("allStandardCost");
    }
    public void setAllStandardCost(java.math.BigDecimal item)
    {
        setBigDecimal("allStandardCost", item);
    }
    /**
     * Object: ������������� 's ��������ϸ property 
     */
    public com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultMonthEntryCollection getMonthEntry()
    {
        return (com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultMonthEntryCollection)get("MonthEntry");
    }
    /**
     * Object: ������������� 's ���÷�¼ property 
     */
    public com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFeeEntryCollection getFeeEntry()
    {
        return (com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultFeeEntryCollection)get("FeeEntry");
    }
    /**
     * Object: ������������� 's ����Ա property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getSaler()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("saler");
    }
    public void setSaler(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("saler", item);
    }
    /**
     * Object:�������������'s �ܻؿ���property 
     */
    public java.math.BigDecimal getAllRecAmount()
    {
        return getBigDecimal("allRecAmount");
    }
    public void setAllRecAmount(java.math.BigDecimal item)
    {
        setBigDecimal("allRecAmount", item);
    }
    /**
     * Object:�������������'s ���˷���property 
     */
    public java.math.BigDecimal getAllPersonalFee()
    {
        return getBigDecimal("allPersonalFee");
    }
    public void setAllPersonalFee(java.math.BigDecimal item)
    {
        setBigDecimal("allPersonalFee", item);
    }
    /**
     * Object:�������������'s ��̯����property 
     */
    public java.math.BigDecimal getAllSharedFee()
    {
        return getBigDecimal("allSharedFee");
    }
    public void setAllSharedFee(java.math.BigDecimal item)
    {
        setBigDecimal("allSharedFee", item);
    }
    /**
     * Object:�������������'s �����ܼ�property 
     */
    public java.math.BigDecimal getAllFee()
    {
        return getBigDecimal("allFee");
    }
    public void setAllFee(java.math.BigDecimal item)
    {
        setBigDecimal("allFee", item);
    }
    /**
     * Object:�������������'s ��˾�����۶�property 
     */
    public java.math.BigDecimal getCompanySaleAmount()
    {
        return getBigDecimal("companySaleAmount");
    }
    public void setCompanySaleAmount(java.math.BigDecimal item)
    {
        setBigDecimal("companySaleAmount", item);
    }
    /**
     * Object:�������������'s ����Ӧ�տ���property 
     */
    public java.math.BigDecimal getArKhAmount()
    {
        return getBigDecimal("arKhAmount");
    }
    public void setArKhAmount(java.math.BigDecimal item)
    {
        setBigDecimal("arKhAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9194B9C4");
    }
}