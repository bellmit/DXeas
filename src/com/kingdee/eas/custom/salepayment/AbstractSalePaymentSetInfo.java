package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSalePaymentSetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractSalePaymentSetInfo()
    {
        this("id");
    }
    protected AbstractSalePaymentSetInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 公司基础设置 's 公司 property 
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
     * Object:公司基础设置's 回款明细来源property 
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
     * Object:公司基础设置's 管理费分摊方式property 
     */
    public com.kingdee.eas.custom.salepayment.ManageFeeShareType getManageFeeShareType()
    {
        return com.kingdee.eas.custom.salepayment.ManageFeeShareType.getEnum(getString("manageFeeShareType"));
    }
    public void setManageFeeShareType(com.kingdee.eas.custom.salepayment.ManageFeeShareType item)
    {
		if (item != null) {
        setString("manageFeeShareType", item.getValue());
		}
    }
    /**
     * Object:公司基础设置's 损益计算方式property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C716D017");
    }
}