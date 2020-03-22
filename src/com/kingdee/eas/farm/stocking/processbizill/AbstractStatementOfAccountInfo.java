package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStatementOfAccountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractStatementOfAccountInfo()
    {
        this("id");
    }
    protected AbstractStatementOfAccountInfo(String pkField)
    {
        super(pkField);
        put("Feedsnew", new com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedsnewCollection());
        put("Feeds", new com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedCollection());
    }
    /**
     * Object:���˵�'s �Ƿ�����ƾ֤property 
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
     * Object:���˵�'s ҩƷproperty 
     */
    public java.math.BigDecimal getDrugac()
    {
        return getBigDecimal("drugac");
    }
    public void setDrugac(java.math.BigDecimal item)
    {
        setBigDecimal("drugac", item);
    }
    /**
     * Object:���˵�'s ����property 
     */
    public java.math.BigDecimal getAccessoryac()
    {
        return getBigDecimal("accessoryac");
    }
    public void setAccessoryac(java.math.BigDecimal item)
    {
        setBigDecimal("accessoryac", item);
    }
    /**
     * Object:���˵�'s �����property 
     */
    public java.math.BigDecimal getCostOfLivingac()
    {
        return getBigDecimal("costOfLivingac");
    }
    public void setCostOfLivingac(java.math.BigDecimal item)
    {
        setBigDecimal("costOfLivingac", item);
    }
    /**
     * Object:���˵�'s ռ����Ϣproperty 
     */
    public java.math.BigDecimal getFundInterestac()
    {
        return getBigDecimal("fundInterestac");
    }
    public void setFundInterestac(java.math.BigDecimal item)
    {
        setBigDecimal("fundInterestac", item);
    }
    /**
     * Object:���˵�'s ����(תѼ��������)property 
     */
    public java.math.BigDecimal getOthersac()
    {
        return getBigDecimal("othersac");
    }
    public void setOthersac(java.math.BigDecimal item)
    {
        setBigDecimal("othersac", item);
    }
    /**
     * Object:���˵�'s ������Ϣproperty 
     */
    public java.math.BigDecimal getLoanInterestac()
    {
        return getBigDecimal("loanInterestac");
    }
    public void setLoanInterestac(java.math.BigDecimal item)
    {
        setBigDecimal("loanInterestac", item);
    }
    /**
     * Object:���˵�'s �ֵ���property 
     */
    public java.math.BigDecimal getHatchEggac()
    {
        return getBigDecimal("hatchEggac");
    }
    public void setHatchEggac(java.math.BigDecimal item)
    {
        setBigDecimal("hatchEggac", item);
    }
    /**
     * Object:���˵�'s ��̭Ѽ��property 
     */
    public java.math.BigDecimal getEliminateac()
    {
        return getBigDecimal("eliminateac");
    }
    public void setEliminateac(java.math.BigDecimal item)
    {
        setBigDecimal("eliminateac", item);
    }
    /**
     * Object:���˵�'s �ܾ��ʽ���property 
     */
    public java.math.BigDecimal getFertilizationac()
    {
        return getBigDecimal("fertilizationac");
    }
    public void setFertilizationac(java.math.BigDecimal item)
    {
        setBigDecimal("fertilizationac", item);
    }
    /**
     * Object:���˵�'s Ѻ����Ϣproperty 
     */
    public java.math.BigDecimal getDepositInterestac()
    {
        return getBigDecimal("depositInterestac");
    }
    public void setDepositInterestac(java.math.BigDecimal item)
    {
        setBigDecimal("depositInterestac", item);
    }
    /**
     * Object:���˵�'s Ѻ��property 
     */
    public java.math.BigDecimal getDepositac()
    {
        return getBigDecimal("depositac");
    }
    public void setDepositac(java.math.BigDecimal item)
    {
        setBigDecimal("depositac", item);
    }
    /**
     * Object:���˵�'s ���Ͻ��property 
     */
    public java.math.BigDecimal getFeedsall()
    {
        return getBigDecimal("feedsall");
    }
    public void setFeedsall(java.math.BigDecimal item)
    {
        setBigDecimal("feedsall", item);
    }
    /**
     * Object: ���˵� 's ���� property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedCollection getFeeds()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedCollection)get("Feeds");
    }
    /**
     * Object: ���˵� 's ������ϸ property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedsnewCollection getFeedsnew()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFeedsnewCollection)get("Feedsnew");
    }
    /**
     * Object: ���˵� 's ��˾ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFIUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FIUnit");
    }
    public void setFIUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FIUnit", item);
    }
    /**
     * Object: ���˵� 's ����ڼ� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriods()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("periods");
    }
    public void setPeriods(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("periods", item);
    }
    /**
     * Object: ���˵� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:���˵�'s �ڳ����property 
     */
    public java.math.BigDecimal getBeginningBalance()
    {
        return getBigDecimal("beginningBalance");
    }
    public void setBeginningBalance(java.math.BigDecimal item)
    {
        setBigDecimal("beginningBalance", item);
    }
    /**
     * Object:���˵�'s ��ĩ���property 
     */
    public java.math.BigDecimal getClosingBalance()
    {
        return getBigDecimal("closingBalance");
    }
    public void setClosingBalance(java.math.BigDecimal item)
    {
        setBigDecimal("closingBalance", item);
    }
    /**
     * Object:���˵�'s ��Ӧ�����property 
     */
    public java.math.BigDecimal getTotalAPAmount()
    {
        return getBigDecimal("totalAPAmount");
    }
    public void setTotalAPAmount(java.math.BigDecimal item)
    {
        setBigDecimal("totalAPAmount", item);
    }
    /**
     * Object:���˵�'s ��Ӧ�ս��property 
     */
    public java.math.BigDecimal getTotalARAmount()
    {
        return getBigDecimal("totalARAmount");
    }
    public void setTotalARAmount(java.math.BigDecimal item)
    {
        setBigDecimal("totalARAmount", item);
    }
    /**
     * Object:���˵�'s ������property 
     */
    public java.math.BigDecimal getEggPayAmt()
    {
        return getBigDecimal("eggPayAmt");
    }
    public void setEggPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("eggPayAmt", item);
    }
    /**
     * Object:���˵�'s ȷ��ʱ��property 
     */
    public java.util.Date getConfirmTime()
    {
        return getDate("confirmTime");
    }
    public void setConfirmTime(java.util.Date item)
    {
        setDate("confirmTime", item);
    }
    /**
     * Object:���˵�'s �Ƿ�ȷ��property 
     */
    public boolean isHasConfirm()
    {
        return getBoolean("hasConfirm");
    }
    public void setHasConfirm(boolean item)
    {
        setBoolean("hasConfirm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6E5153CC");
    }
}