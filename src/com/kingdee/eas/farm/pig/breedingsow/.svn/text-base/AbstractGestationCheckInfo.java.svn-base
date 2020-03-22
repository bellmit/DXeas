package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractGestationCheckInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractGestationCheckInfo()
    {
        this("id");
    }
    protected AbstractGestationCheckInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.GestationCheckEntryCollection());
    }
    /**
     * Object: 母猪妊检记录单 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.GestationCheckEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.GestationCheckEntryCollection)get("entrys");
    }
    /**
     * Object:母猪妊检记录单's 是否生成凭证property 
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
     * Object:母猪妊检记录单's 审核时间property 
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
     * Object:母猪妊检记录单's 状态property 
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
     * Object: 母猪妊检记录单 's 养猪场 property 
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
     * Object: 母猪妊检记录单 's 母猪种群 property 
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
     * Object: 母猪妊检记录单 's 检查人员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("07CBAC73");
    }
}