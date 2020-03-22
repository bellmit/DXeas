package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProductCategoryInfoInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProductCategoryInfoInfo()
    {
        this("id");
    }
    protected AbstractProductCategoryInfoInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.foodtrac.ProductCategoryInfoEntryCollection());
    }
    /**
     * Object: 产品类别信息 's 分录 property 
     */
    public com.kingdee.eas.custom.foodtrac.ProductCategoryInfoEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.foodtrac.ProductCategoryInfoEntryCollection)get("entrys");
    }
    /**
     * Object:产品类别信息's 是否生成凭证property 
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
     * Object:产品类别信息's 类别编码property 
     */
    public String getCategorynumber()
    {
        return getString("categorynumber");
    }
    public void setCategorynumber(String item)
    {
        setString("categorynumber", item);
    }
    /**
     * Object:产品类别信息's 类别名称property 
     */
    public String getCategoryname()
    {
        return getString("categoryname");
    }
    public void setCategoryname(String item)
    {
        setString("categoryname", item);
    }
    /**
     * Object:产品类别信息's 描述property 
     */
    public String getNewdesc()
    {
        return getString("newdesc");
    }
    public void setNewdesc(String item)
    {
        setString("newdesc", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("51A46076");
    }
}