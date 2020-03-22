package com.kingdee.eas.bdm.bdapply;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCustomerInfoReqCustomerGroupEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCustomerInfoReqCustomerGroupEntryInfo()
    {
        this("id");
    }
    protected AbstractCustomerInfoReqCustomerGroupEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 客户分类分录 's null property 
     */
    public com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo getParent1()
    {
        return (com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object: 客户分类分录 's 客户分类标准 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo getCustomerGroupstd()
    {
        return (com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo)get("customerGroupstd");
    }
    public void setCustomerGroupstd(com.kingdee.eas.basedata.master.cssp.CSSPGroupStandardInfo item)
    {
        put("customerGroupstd", item);
    }
    /**
     * Object: 客户分类分录 's 客户分类 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo getCustomerGroup()
    {
        return (com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo)get("customerGroup");
    }
    public void setCustomerGroup(com.kingdee.eas.basedata.master.cssp.CSSPGroupInfo item)
    {
        put("customerGroup", item);
    }
    /**
     * Object:客户分类分录's 分类标准名称property 
     */
    public String getStdName()
    {
        return getString("stdName");
    }
    public void setStdName(String item)
    {
        setString("stdName", item);
    }
    /**
     * Object:客户分类分录's 分类名称property 
     */
    public String getGroupName()
    {
        return getString("groupName");
    }
    public void setGroupName(String item)
    {
        setString("groupName", item);
    }
    /**
     * Object:客户分类分录's 分类全名property 
     */
    public String getGroupFullName()
    {
        return getString("groupFullName");
    }
    public void setGroupFullName(String item)
    {
        setString("groupFullName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("81D90D0C");
    }
}