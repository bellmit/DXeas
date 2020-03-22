package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAchievementEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAchievementEntryInfo()
    {
        this("id");
    }
    protected AbstractAchievementEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.food.AchievementInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.food.AchievementInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.food.AchievementInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 员工 property 
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
     * Object: 分录 's 岗位 property 
     */
    public com.kingdee.eas.custom.wages.food.BasicPostFoodInfo getPost()
    {
        return (com.kingdee.eas.custom.wages.food.BasicPostFoodInfo)get("post");
    }
    public void setPost(com.kingdee.eas.custom.wages.food.BasicPostFoodInfo item)
    {
        put("post", item);
    }
    /**
     * Object:分录's 考核满额property 
     */
    public java.math.BigDecimal getKhme()
    {
        return getBigDecimal("khme");
    }
    public void setKhme(java.math.BigDecimal item)
    {
        setBigDecimal("khme", item);
    }
    /**
     * Object:分录's 绩效金额property 
     */
    public java.math.BigDecimal getAchieceamount()
    {
        return getBigDecimal("achieceamount");
    }
    public void setAchieceamount(java.math.BigDecimal item)
    {
        setBigDecimal("achieceamount", item);
    }
    /**
     * Object:分录's 绩效得分property 
     */
    public java.math.BigDecimal getAchievescore()
    {
        return getBigDecimal("achievescore");
    }
    public void setAchievescore(java.math.BigDecimal item)
    {
        setBigDecimal("achievescore", item);
    }
    /**
     * Object:分录's 绩效工资property 
     */
    public java.math.BigDecimal getAchievewages()
    {
        return getBigDecimal("achievewages");
    }
    public void setAchievewages(java.math.BigDecimal item)
    {
        setBigDecimal("achievewages", item);
    }
    /**
     * Object:分录's 其他奖罚金额property 
     */
    public java.math.BigDecimal getOtheramount()
    {
        return getBigDecimal("otheramount");
    }
    public void setOtheramount(java.math.BigDecimal item)
    {
        setBigDecimal("otheramount", item);
    }
    /**
     * Object:分录's 金额小计property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:分录's 绩效百分比property 
     */
    public String getAchievetage()
    {
        return getString("achievetage");
    }
    public void setAchievetage(String item)
    {
        setString("achievetage", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("09F43F85");
    }
}