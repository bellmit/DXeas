package com.kingdee.eas.custom.rye;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRyeReadFilesInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractRyeReadFilesInfo()
    {
        this("id");
    }
    protected AbstractRyeReadFilesInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.rye.RyeReadFilesEntryCollection());
    }
    /**
     * Object: RyeReadFiles 's 分录 property 
     */
    public com.kingdee.eas.custom.rye.RyeReadFilesEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.rye.RyeReadFilesEntryCollection)get("entrys");
    }
    /**
     * Object:RyeReadFiles's 是否生成凭证property 
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
     * Object:RyeReadFiles's 超大文本property 
     */
    public String getBigText()
    {
        return getString("bigText");
    }
    public void setBigText(String item)
    {
        setString("bigText", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DC7B44D8");
    }
}