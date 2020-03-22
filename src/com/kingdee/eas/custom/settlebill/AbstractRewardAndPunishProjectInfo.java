package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRewardAndPunishProjectInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractRewardAndPunishProjectInfo()
    {
        this("id");
    }
    protected AbstractRewardAndPunishProjectInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖惩项目 's 科目 property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getAccountView()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("accountView");
    }
    public void setAccountView(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("accountView", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CC5EAE6D");
    }
}