package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProdCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractProdCountInfo()
    {
        this("id");
    }
    protected AbstractProdCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.food.stocount.ProdCountEntryCollection());
    }
    /**
     * Object: 成品计数单 's 分录 property 
     */
    public com.kingdee.eas.farm.food.stocount.ProdCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.stocount.ProdCountEntryCollection)get("entrys");
    }
    /**
     * Object:成品计数单's 是否生成凭证property 
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
     * Object:成品计数单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("status"));
    }
    public void setStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("status", item.getValue());
		}
    }
    /**
     * Object: 成品计数单 's 计数员 property 
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
     * Object: 成品计数单 's 技术岗位 property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetInfo getSemcount()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetInfo)get("semcount");
    }
    public void setSemcount(com.kingdee.eas.farm.food.stocount.CountPositionSetInfo item)
    {
        put("semcount", item);
    }
    /**
     * Object:成品计数单's 班次property 
     */
    public com.kingdee.eas.farm.food.stocount.Classes getClasses()
    {
        return com.kingdee.eas.farm.food.stocount.Classes.getEnum(getString("classes"));
    }
    public void setClasses(com.kingdee.eas.farm.food.stocount.Classes item)
    {
		if (item != null) {
        setString("classes", item.getValue());
		}
    }
    /**
     * Object:成品计数单's 是否生成下游单据property 
     */
    public boolean isIsPackAcceptance()
    {
        return getBoolean("IsPackAcceptance");
    }
    public void setIsPackAcceptance(boolean item)
    {
        setBoolean("IsPackAcceptance", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F470D1DB");
    }
}