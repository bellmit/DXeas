package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBillDeafultSettingTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBillDeafultSettingTreeInfo()
    {
        this("id");
    }
    protected AbstractBillDeafultSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �����м��Ĭ��������� 's ���ڵ� property 
     */
    public com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.eas2temp.BillDeafultSettingTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("34CFA232");
    }
}