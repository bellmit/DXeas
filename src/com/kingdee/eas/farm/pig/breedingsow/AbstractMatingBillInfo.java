package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMatingBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractMatingBillInfo()
    {
        this("id");
    }
    protected AbstractMatingBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.pig.breedingsow.MatingBillEntryCollection());
    }
    /**
     * Object: 配种记录单 's 分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingsow.MatingBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingsow.MatingBillEntryCollection)get("entrys");
    }
    /**
     * Object:配种记录单's 是否生成凭证property 
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
     * Object:配种记录单's 审核时间property 
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
     * Object:配种记录单's 状态property 
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
     * Object: 配种记录单 's 养猪场 property 
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
     * Object: 配种记录单 's 母猪种群 property 
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
     * Object:配种记录单's 配种类型property 
     */
    public com.kingdee.eas.farm.pig.HybridizationType getHybridizationType()
    {
        return com.kingdee.eas.farm.pig.HybridizationType.getEnum(getString("hybridizationType"));
    }
    public void setHybridizationType(com.kingdee.eas.farm.pig.HybridizationType item)
    {
		if (item != null) {
        setString("hybridizationType", item.getValue());
		}
    }
    /**
     * Object: 配种记录单 's 操作员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getOperator()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("operator");
    }
    public void setOperator(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("operator", item);
    }
    /**
     * Object: 配种记录单 's 猪精批次 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllInfo getSpermBatch()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllInfo)get("spermBatch");
    }
    public void setSpermBatch(com.kingdee.eas.farm.pig.breedingboar.CollectSpermBIllInfo item)
    {
        put("spermBatch", item);
    }
    /**
     * Object: 配种记录单 's 种公猪 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarInfo getBoar()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarInfo)get("boar");
    }
    public void setBoar(com.kingdee.eas.farm.pig.breedingboar.BoarInfo item)
    {
        put("boar", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C17BBE8A");
    }
}