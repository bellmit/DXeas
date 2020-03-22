package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCheckHeatBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCheckHeatBillInfo()
    {
        this("id");
    }
    protected AbstractCheckHeatBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.CheckHeatBillEntryCollection());
    }
    /**
     * Object: 查情记录单 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.CheckHeatBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.CheckHeatBillEntryCollection)get("entrys");
    }
    /**
     * Object:查情记录单's 是否生成凭证property 
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
     * Object:查情记录单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:查情记录单's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 查情记录单 's 养猪场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 查情记录单 's 母猪种群 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo getPolulation()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo)get("polulation");
    }
    public void setPolulation(com.kingdee.eas.farm.pig.breedingsow.SowPolulationInfo item)
    {
        put("polulation", item);
    }
    /**
     * Object: 查情记录单 's 查情人员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getCheckPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("checkPerson");
    }
    public void setCheckPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("checkPerson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2E0136BE");
    }
}