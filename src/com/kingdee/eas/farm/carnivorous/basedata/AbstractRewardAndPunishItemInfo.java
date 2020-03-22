package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRewardAndPunishItemInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractRewardAndPunishItemInfo()
    {
        this("id");
    }
    protected AbstractRewardAndPunishItemInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ������Ŀ 's ������֯ property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object:������Ŀ's ����״̬property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:������Ŀ's �۷�����property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.PunishType getPunishType()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.PunishType.getEnum(getString("punishType"));
    }
    public void setPunishType(com.kingdee.eas.farm.carnivorous.basedata.PunishType item)
    {
		if (item != null) {
        setString("punishType", item.getValue());
		}
    }
    /**
     * Object:������Ŀ's ���÷�Χproperty 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RandPScope getScope()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.RandPScope.getEnum(getString("scope"));
    }
    public void setScope(com.kingdee.eas.farm.carnivorous.basedata.RandPScope item)
    {
		if (item != null) {
        setString("scope", item.getValue());
		}
    }
    /**
     * Object: ������Ŀ 's ��Ӧ��Ŀ property 
     */
    public com.kingdee.eas.basedata.master.account.AccountViewInfo getSubject()
    {
        return (com.kingdee.eas.basedata.master.account.AccountViewInfo)get("subject");
    }
    public void setSubject(com.kingdee.eas.basedata.master.account.AccountViewInfo item)
    {
        put("subject", item);
    }
    /**
     * Object:������Ŀ's ����ϵ��property 
     */
    public java.math.BigDecimal getCoe()
    {
        return getBigDecimal("coe");
    }
    public void setCoe(java.math.BigDecimal item)
    {
        setBigDecimal("coe", item);
    }
    /**
     * Object:������Ŀ's ë����������property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.recType getRectype()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.recType.getEnum(getString("rectype"));
    }
    public void setRectype(com.kingdee.eas.farm.carnivorous.basedata.recType item)
    {
		if (item != null) {
        setString("rectype", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B2AB0AEE");
    }
}