package com.kingdee.eas.custom.bsxbudget;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBSXBudgetOfFeedInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBSXBudgetOfFeedInfo()
    {
        this("id");
    }
    protected AbstractBSXBudgetOfFeedInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��ֳ��Ԥ��'s ���ʱ��property 
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
     * Object: ��ֳ��Ԥ�� 's �ڼ� property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ��������property 
     */
    public java.math.BigDecimal getLairageQty()
    {
        return getBigDecimal("lairageQty");
    }
    public void setLairageQty(java.math.BigDecimal item)
    {
        setBigDecimal("lairageQty", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �ɻ���property 
     */
    public java.math.BigDecimal getSurvivalRate()
    {
        return getBigDecimal("survivalRate");
    }
    public void setSurvivalRate(java.math.BigDecimal item)
    {
        setBigDecimal("survivalRate", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ������property 
     */
    public java.math.BigDecimal getSlaughterQty()
    {
        return getBigDecimal("slaughterQty");
    }
    public void setSlaughterQty(java.math.BigDecimal item)
    {
        setBigDecimal("slaughterQty", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ��ֻ����property 
     */
    public java.math.BigDecimal getAverageWeight()
    {
        return getBigDecimal("averageWeight");
    }
    public void setAverageWeight(java.math.BigDecimal item)
    {
        setBigDecimal("averageWeight", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ��ֻ����property 
     */
    public java.math.BigDecimal getTotalWeight()
    {
        return getBigDecimal("totalWeight");
    }
    public void setTotalWeight(java.math.BigDecimal item)
    {
        setBigDecimal("totalWeight", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����property 
     */
    public java.math.BigDecimal getFeedToMeatRatio()
    {
        return getBigDecimal("feedToMeatRatio");
    }
    public void setFeedToMeatRatio(java.math.BigDecimal item)
    {
        setBigDecimal("feedToMeatRatio", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ֻ������property 
     */
    public java.math.BigDecimal getAveFeedConsumption()
    {
        return getBigDecimal("aveFeedConsumption");
    }
    public void setAveFeedConsumption(java.math.BigDecimal item)
    {
        setBigDecimal("aveFeedConsumption", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ��Ʒ����λ�ɱ�property 
     */
    public java.math.BigDecimal getAverageCost()
    {
        return getBigDecimal("averageCost");
    }
    public void setAverageCost(java.math.BigDecimal item)
    {
        setBigDecimal("averageCost", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ���絥λ�ɱ�property 
     */
    public java.math.BigDecimal getAverageCostOfChicks()
    {
        return getBigDecimal("averageCostOfChicks");
    }
    public void setAverageCostOfChicks(java.math.BigDecimal item)
    {
        setBigDecimal("averageCostOfChicks", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ҩƷ��λ�ɱ�property 
     */
    public java.math.BigDecimal getAverageCostOfmedicine()
    {
        return getBigDecimal("averageCostOfmedicine");
    }
    public void setAverageCostOfmedicine(java.math.BigDecimal item)
    {
        setBigDecimal("averageCostOfmedicine", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ���ϵ�λ�ɱ�property 
     */
    public java.math.BigDecimal getAverageCostOfFeedstuff()
    {
        return getBigDecimal("averageCostOfFeedstuff");
    }
    public void setAverageCostOfFeedstuff(java.math.BigDecimal item)
    {
        setBigDecimal("averageCostOfFeedstuff", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ��Ʒ���ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCostOfCC()
    {
        return getBigDecimal("totalCostOfCC");
    }
    public void setTotalCostOfCC(java.math.BigDecimal item)
    {
        setBigDecimal("totalCostOfCC", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCostOfChicks()
    {
        return getBigDecimal("totalCostOfChicks");
    }
    public void setTotalCostOfChicks(java.math.BigDecimal item)
    {
        setBigDecimal("totalCostOfChicks", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ҩƷ�ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCostOfMedicine()
    {
        return getBigDecimal("totalCostOfMedicine");
    }
    public void setTotalCostOfMedicine(java.math.BigDecimal item)
    {
        setBigDecimal("totalCostOfMedicine", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ��������property 
     */
    public java.math.BigDecimal getFeeOfOthers()
    {
        return getBigDecimal("feeOfOthers");
    }
    public void setFeeOfOthers(java.math.BigDecimal item)
    {
        setBigDecimal("feeOfOthers", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ë���չ��۸�property 
     */
    public java.math.BigDecimal getPriceOfWholeChicken()
    {
        return getBigDecimal("priceOfWholeChicken");
    }
    public void setPriceOfWholeChicken(java.math.BigDecimal item)
    {
        setBigDecimal("priceOfWholeChicken", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ��ë������property 
     */
    public java.math.BigDecimal getRevenueOfChickens()
    {
        return getBigDecimal("revenueOfChickens");
    }
    public void setRevenueOfChickens(java.math.BigDecimal item)
    {
        setBigDecimal("revenueOfChickens", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ����������property 
     */
    public java.math.BigDecimal getRevenueOfOthers()
    {
        return getBigDecimal("revenueOfOthers");
    }
    public void setRevenueOfOthers(java.math.BigDecimal item)
    {
        setBigDecimal("revenueOfOthers", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ����Ҫ�ɱ�property 
     */
    public java.math.BigDecimal getMainCost()
    {
        return getBigDecimal("mainCost");
    }
    public void setMainCost(java.math.BigDecimal item)
    {
        setBigDecimal("mainCost", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ�������ɱ�property 
     */
    public java.math.BigDecimal getCostOfOthers()
    {
        return getBigDecimal("costOfOthers");
    }
    public void setCostOfOthers(java.math.BigDecimal item)
    {
        setBigDecimal("costOfOthers", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �������property 
     */
    public java.math.BigDecimal getFeeOfManage()
    {
        return getBigDecimal("feeOfManage");
    }
    public void setFeeOfManage(java.math.BigDecimal item)
    {
        setBigDecimal("feeOfManage", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �������property 
     */
    public java.math.BigDecimal getFeeOfFinance()
    {
        return getBigDecimal("feeOfFinance");
    }
    public void setFeeOfFinance(java.math.BigDecimal item)
    {
        setBigDecimal("feeOfFinance", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ������������property 
     */
    public java.math.BigDecimal getForageConsumption()
    {
        return getBigDecimal("forageConsumption");
    }
    public void setForageConsumption(java.math.BigDecimal item)
    {
        setBigDecimal("forageConsumption", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s һ���Ϻ��ñ���property 
     */
    public java.math.BigDecimal getRatioOfNo1()
    {
        return getBigDecimal("ratioOfNo1");
    }
    public void setRatioOfNo1(java.math.BigDecimal item)
    {
        setBigDecimal("ratioOfNo1", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s һ���Ϻ�������property 
     */
    public java.math.BigDecimal getTotalQtyOfNo1()
    {
        return getBigDecimal("totalQtyOfNo1");
    }
    public void setTotalQtyOfNo1(java.math.BigDecimal item)
    {
        setBigDecimal("totalQtyOfNo1", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����Ϻ��ñ���property 
     */
    public java.math.BigDecimal getRatioOfNo2()
    {
        return getBigDecimal("ratioOfNo2");
    }
    public void setRatioOfNo2(java.math.BigDecimal item)
    {
        setBigDecimal("ratioOfNo2", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����Ϻ��ñ���property 
     */
    public java.math.BigDecimal getRatioOfNo3()
    {
        return getBigDecimal("ratioOfNo3");
    }
    public void setRatioOfNo3(java.math.BigDecimal item)
    {
        setBigDecimal("ratioOfNo3", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����Ϻ�������property 
     */
    public java.math.BigDecimal getTotalQtyOfNo2()
    {
        return getBigDecimal("totalQtyOfNo2");
    }
    public void setTotalQtyOfNo2(java.math.BigDecimal item)
    {
        setBigDecimal("totalQtyOfNo2", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����Ϻ�������property 
     */
    public java.math.BigDecimal getTotalQtyOfNo3()
    {
        return getBigDecimal("totalQtyOfNo3");
    }
    public void setTotalQtyOfNo3(java.math.BigDecimal item)
    {
        setBigDecimal("totalQtyOfNo3", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �ĺ��Ϻ��ñ���property 
     */
    public java.math.BigDecimal getRatioOfNo4()
    {
        return getBigDecimal("ratioOfNo4");
    }
    public void setRatioOfNo4(java.math.BigDecimal item)
    {
        setBigDecimal("ratioOfNo4", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �ĺ��Ϻ�������property 
     */
    public java.math.BigDecimal getTotalQtyOfNo4()
    {
        return getBigDecimal("totalQtyOfNo4");
    }
    public void setTotalQtyOfNo4(java.math.BigDecimal item)
    {
        setBigDecimal("totalQtyOfNo4", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ƽ����׼�ɱ�property 
     */
    public java.math.BigDecimal getStandardCostOfAverage()
    {
        return getBigDecimal("standardCostOfAverage");
    }
    public void setStandardCostOfAverage(java.math.BigDecimal item)
    {
        setBigDecimal("standardCostOfAverage", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s һ���ϵ�λ��׼�ɱ�property 
     */
    public java.math.BigDecimal getStandardCostOfNo1()
    {
        return getBigDecimal("standardCostOfNo1");
    }
    public void setStandardCostOfNo1(java.math.BigDecimal item)
    {
        setBigDecimal("standardCostOfNo1", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s һ�����ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCostOfNo1()
    {
        return getBigDecimal("totalCostOfNo1");
    }
    public void setTotalCostOfNo1(java.math.BigDecimal item)
    {
        setBigDecimal("totalCostOfNo1", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCost()
    {
        return getBigDecimal("totalCost");
    }
    public void setTotalCost(java.math.BigDecimal item)
    {
        setBigDecimal("totalCost", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����ϵ�λ��׼�ɱ�property 
     */
    public java.math.BigDecimal getStandardCostOfNo2()
    {
        return getBigDecimal("standardCostOfNo2");
    }
    public void setStandardCostOfNo2(java.math.BigDecimal item)
    {
        setBigDecimal("standardCostOfNo2", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �������ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCostOfNo2()
    {
        return getBigDecimal("totalCostOfNo2");
    }
    public void setTotalCostOfNo2(java.math.BigDecimal item)
    {
        setBigDecimal("totalCostOfNo2", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �����ϵ�λ��׼�ɱ�property 
     */
    public java.math.BigDecimal getStandardCostOfNo3()
    {
        return getBigDecimal("standardCostOfNo3");
    }
    public void setStandardCostOfNo3(java.math.BigDecimal item)
    {
        setBigDecimal("standardCostOfNo3", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �������ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCostOfNo3()
    {
        return getBigDecimal("totalCostOfNo3");
    }
    public void setTotalCostOfNo3(java.math.BigDecimal item)
    {
        setBigDecimal("totalCostOfNo3", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ��������property 
     */
    public java.math.BigDecimal getPredictedTotalRevenue()
    {
        return getBigDecimal("predictedTotalRevenue");
    }
    public void setPredictedTotalRevenue(java.math.BigDecimal item)
    {
        setBigDecimal("predictedTotalRevenue", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ���ܳɱ�property 
     */
    public java.math.BigDecimal getPredictedTotalCost()
    {
        return getBigDecimal("predictedTotalCost");
    }
    public void setPredictedTotalCost(java.math.BigDecimal item)
    {
        setBigDecimal("predictedTotalCost", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ����ֳ������property 
     */
    public java.math.BigDecimal getPredictedProfit()
    {
        return getBigDecimal("predictedProfit");
    }
    public void setPredictedProfit(java.math.BigDecimal item)
    {
        setBigDecimal("predictedProfit", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s ����״̬property 
     */
    public com.kingdee.eas.custom.bsxbudget.billStatus getBillStatus()
    {
        return com.kingdee.eas.custom.bsxbudget.billStatus.getEnum(getString("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.custom.bsxbudget.billStatus item)
    {
		if (item != null) {
        setString("billStatus", item.getValue());
		}
    }
    /**
     * Object:��ֳ��Ԥ��'s ��ι����property 
     */
    public int getFeedPeriod()
    {
        return getInt("feedPeriod");
    }
    public void setFeedPeriod(int item)
    {
        setInt("feedPeriod", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �ĺ��ϵ�λ��׼�ɱ�property 
     */
    public java.math.BigDecimal getStandardCostOfNo4()
    {
        return getBigDecimal("standardCostOfNo4");
    }
    public void setStandardCostOfNo4(java.math.BigDecimal item)
    {
        setBigDecimal("standardCostOfNo4", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s �ĺ����ܳɱ�property 
     */
    public java.math.BigDecimal getTotalCostOfNo4()
    {
        return getBigDecimal("totalCostOfNo4");
    }
    public void setTotalCostOfNo4(java.math.BigDecimal item)
    {
        setBigDecimal("totalCostOfNo4", item);
    }
    /**
     * Object:��ֳ��Ԥ��'s Ԥ���ܷ���property 
     */
    public java.math.BigDecimal getPredictTotalFee()
    {
        return getBigDecimal("predictTotalFee");
    }
    public void setPredictTotalFee(java.math.BigDecimal item)
    {
        setBigDecimal("predictTotalFee", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("92F4601A");
    }
}