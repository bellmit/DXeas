package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractBreedDataInfo()
    {
        this("id");
    }
    protected AbstractBreedDataInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.farm.stocking.basedata.BreedDataEntryCollection());
        put("StageEntry", new com.kingdee.eas.farm.stocking.basedata.BreedDataStageEntryCollection());
        put("SeedEntry", new com.kingdee.eas.farm.stocking.basedata.BreedDataSeedEntryCollection());
    }
    /**
     * Object: 品种资料 's 组别 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataTreeInfo getTreeid()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.farm.stocking.basedata.BreedDataTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object: 品种资料 's 种苗物料 property 
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
     * Object: 品种资料 's 蛋品分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataEntryCollection getEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataEntryCollection)get("Entry");
    }
    /**
     * Object:品种资料's 基本状态property 
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
     * Object: 品种资料 's 育成期物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getBridMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("bridMaterial");
    }
    public void setBridMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("bridMaterial", item);
    }
    /**
     * Object:品种资料's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: 品种资料 's 母苗物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getFemaleMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("femaleMaterial");
    }
    public void setFemaleMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("femaleMaterial", item);
    }
    /**
     * Object: 品种资料 's 阶段定义 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataStageEntryCollection getStageEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataStageEntryCollection)get("StageEntry");
    }
    /**
     * Object: 品种资料 's 淘汰物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getWeedoutMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("weedoutMaterial");
    }
    public void setWeedoutMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("weedoutMaterial", item);
    }
    /**
     * Object: 品种资料 's 种苗分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataSeedEntryCollection getSeedEntry()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataSeedEntryCollection)get("SeedEntry");
    }
    /**
     * Object:品种资料's 代系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenerateType getGenerateType()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenerateType.getEnum(getString("generateType"));
    }
    public void setGenerateType(com.kingdee.eas.farm.stocking.hatch.GenerateType item)
    {
		if (item != null) {
        setString("generateType", item.getValue());
		}
    }
    /**
     * Object:品种资料's 父母系property 
     */
    public com.kingdee.eas.farm.stocking.hatch.GenderType getGenderType()
    {
        return com.kingdee.eas.farm.stocking.hatch.GenderType.getEnum(getString("genderType"));
    }
    public void setGenderType(com.kingdee.eas.farm.stocking.hatch.GenderType item)
    {
		if (item != null) {
        setString("genderType", item.getValue());
		}
    }
    /**
     * Object: 品种资料 's 育雏期物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getBroodMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("broodMaterial");
    }
    public void setBroodMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("broodMaterial", item);
    }
    /**
     * Object: 品种资料 's 预产期物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getPreEggMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("preEggMaterial");
    }
    public void setPreEggMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("preEggMaterial", item);
    }
    /**
     * Object: 品种资料 's 产蛋期物料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getEggMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("eggMaterial");
    }
    public void setEggMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("eggMaterial", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A7A7130D");
    }
}