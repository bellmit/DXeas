package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInputSeedPlanInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractInputSeedPlanInfo()
    {
        this("id");
    }
    protected AbstractInputSeedPlanInfo(String pkField)
    {
        super(pkField);
        put("Entrys", new com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanEntryCollection());
    }
    /**
     * Object: �����ƻ��� 's ������֯ property 
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
     * Object: �����ƻ��� 's Ʒ�� property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:�����ƻ���'s ����״̬property 
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
     * Object: �����ƻ��� 's ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.InputSeedPlanEntryCollection)get("Entrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8899A4C2");
    }
}