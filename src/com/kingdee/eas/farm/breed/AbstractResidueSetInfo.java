package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractResidueSetInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractResidueSetInfo()
    {
        this("id");
    }
    protected AbstractResidueSetInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ����ʱ������ 's ��� property 
     */
    public com.kingdee.eas.farm.breed.ResidueSetTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.breed.ResidueSetTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.breed.ResidueSetTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: ����ʱ������ 's ���� property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:����ʱ������'s ��������property 
     */
    public int getResidueDays()
    {
        return getInt("residueDays");
    }
    public void setResidueDays(int item)
    {
        setInt("residueDays", item);
    }
    /**
     * Object:����ʱ������'s ��עproperty 
     */
    public String getResidueDescription()
    {
        return getString("residueDescription");
    }
    public void setResidueDescription(String item)
    {
        setString("residueDescription", item);
    }
    /**
     * Object:����ʱ������'s ���property 
     */
    public com.kingdee.eas.farm.breed.DrugType getDrugType()
    {
        return com.kingdee.eas.farm.breed.DrugType.getEnum(getString("drugType"));
    }
    public void setDrugType(com.kingdee.eas.farm.breed.DrugType item)
    {
		if (item != null) {
        setString("drugType", item.getValue());
		}
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("453BBBB1");
    }
}