package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkAgeAwardInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractWorkAgeAwardInfo()
    {
        this("id");
    }
    protected AbstractWorkAgeAwardInfo(String pkField)
    {
        super(pkField);
        put("Calculation", new com.kingdee.eas.custom.wages.WorkAgeAwardCalculationCollection());
        put("Bonus", new com.kingdee.eas.custom.wages.WorkAgeAwardBonuCollection());
    }
    /**
     * Object: 工龄奖 's 公司 property 
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
     * Object: 工龄奖 's 奖金标准 property 
     */
    public com.kingdee.eas.custom.wages.WorkAgeAwardBonuCollection getBonus()
    {
        return (com.kingdee.eas.custom.wages.WorkAgeAwardBonuCollection)get("Bonus");
    }
    /**
     * Object: 工龄奖 's 计算方法 property 
     */
    public com.kingdee.eas.custom.wages.WorkAgeAwardCalculationCollection getCalculation()
    {
        return (com.kingdee.eas.custom.wages.WorkAgeAwardCalculationCollection)get("Calculation");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E64BF2D7");
    }
}