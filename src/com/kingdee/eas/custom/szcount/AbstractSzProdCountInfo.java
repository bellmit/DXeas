package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSzProdCountInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSzProdCountInfo()
    {
        this("id");
    }
    protected AbstractSzProdCountInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.custom.szcount.SzProdCountEntryCollection());
    }
    /**
     * Object: ̫�ϳ�Ʒ���� 's ��¼ property 
     */
    public com.kingdee.eas.custom.szcount.SzProdCountEntryCollection getEntrys()
    {
        return (com.kingdee.eas.custom.szcount.SzProdCountEntryCollection)get("entrys");
    }
    /**
     * Object:̫�ϳ�Ʒ����'s �Ƿ�����ƾ֤property 
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
     * Object:̫�ϳ�Ʒ����'s ����״̬property 
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
     * Object: ̫�ϳ�Ʒ���� 's ����Ա property 
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
     * Object: ̫�ϳ�Ʒ���� 's ������λ property 
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
     * Object:̫�ϳ�Ʒ����'s ���property 
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
     * Object:̫�ϳ�Ʒ����'s �Ƿ��������ε���property 
     */
    public boolean isIsPackAcceptance()
    {
        return getBoolean("IsPackAcceptance");
    }
    public void setIsPackAcceptance(boolean item)
    {
        setBoolean("IsPackAcceptance", item);
    }
    /**
     * Object: ̫�ϳ�Ʒ���� 's ��װ������ property 
     */
    public com.kingdee.eas.farm.food.stocount.PcakCountInfo getPcakcountid()
    {
        return (com.kingdee.eas.farm.food.stocount.PcakCountInfo)get("pcakcountid");
    }
    public void setPcakcountid(com.kingdee.eas.farm.food.stocount.PcakCountInfo item)
    {
        put("pcakcountid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5367BB06");
    }
}