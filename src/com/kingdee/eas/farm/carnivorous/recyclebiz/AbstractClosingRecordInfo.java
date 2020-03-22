package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractClosingRecordInfo extends AbstractObjectValue implements Serializable 
{
    public AbstractClosingRecordInfo()
    {
        this("id");
    }
    protected AbstractClosingRecordInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:��Ʒ�����˼�¼'s nullproperty 
     */
    public com.kingdee.bos.util.BOSUuid getId()
    {
        return getBOSUuid("id");
    }
    public void setId(com.kingdee.bos.util.BOSUuid item)
    {
        setBOSUuid("id", item);
    }
    /**
     * Object:��Ʒ�����˼�¼'s ��˾property 
     */
    public String getCompany()
    {
        return getString("company");
    }
    public void setCompany(String item)
    {
        setString("company", item);
    }
    /**
     * Object:��Ʒ�����˼�¼'s �ڼ�property 
     */
    public String getPeriod()
    {
        return getString("period");
    }
    public void setPeriod(String item)
    {
        setString("period", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C9486FE9");
    }
}