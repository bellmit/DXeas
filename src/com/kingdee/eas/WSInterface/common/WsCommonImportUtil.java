package com.kingdee.eas.WSInterface.common;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.data.ColumnInfo;
import com.kingdee.bos.metadata.entity.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.util.PropertyContainer;
import com.kingdee.util.enums.*;
import java.util.*;
import org.apache.log4j.Logger;

public class WsCommonImportUtil {
	public static void buildBillHead(Context ctx, CoreBaseInfo baseinfo, Map map, String mustValidate[], String notBuild[], HashMap headMap, String cuId)
    throws Exception
{
    if(map != null)
        buildBill(ctx, map, notBuild, headMap, mustValidate, baseinfo, cuId);
}

public static void buildBill(Context ctx, Map map, String notBuild[], HashMap entiesPro, String mustValidate[], PropertyContainer info, String cuId)
    throws Exception
{
    for(Iterator strit = map.entrySet().iterator(); strit.hasNext();)
    {
        java.util.Map.Entry et = (java.util.Map.Entry)strit.next();
        String key = et.getKey().toString();
        Object value = et.getValue();
        if(value instanceof EntityObjectInfo)
            WsCommonUtil.setLinkProperties(ctx, info, mustValidate, key, value, notBuild, entiesPro, cuId);
        else
        if(value.toString().equals("Date"))
            WsCommonUtil.setDateProperties(info, key, entiesPro);
        else
        if(value.toString().equals("Time") || value.toString().equals("TimeStamp"))
            WsCommonUtil.seTimeStampProperties(info, key, entiesPro);
        else
        if(value.toString().equals("Integer"))
            WsCommonUtil.setIntProperties(info, key, entiesPro);
        else
        if(value.toString().equals("BigDecimal"))
            WsCommonUtil.setDeciamlProperties(info, key, entiesPro);
        else
        if(value.toString().equals("Boolean"))
            WsCommonUtil.setBooleanProperties(info, notBuild, key, entiesPro);
        else
        if(value.toString().equals("String"))
            WsCommonUtil.setStrProperties(info, notBuild, key, entiesPro);
    }

}

public static Map getBillHeadProperties(EntityObjectInfo eo)
{
    Map headMapcol = new HashMap();
    if(eo != null)
    {
        PropertyCollection pc = eo.getPropertiesRuntime();
        LinkPropertyInfo link = null;
        EntityObjectInfo childEntity = null;
        OwnPropertyInfo own = null;
        com.kingdee.bos.metadata.data.DataTableInfo table = eo.getTable();
        for(int i = 0; i < pc.size(); i++)
        {
            link = null;
            own = null;
            if(pc.get(i) instanceof LinkPropertyInfo)
            {
                link = (LinkPropertyInfo)pc.get(i);
                if(link.getMappingField() != null && !"".equals(link.getMappingField().getName()))
                {
                    childEntity = link.getRelationship().getSupplierObject();
                    if(eo.getType().toString().equals(childEntity.getType().toString()))
                        childEntity = link.getRelationship().getClientObject();
                    headMapcol.put(link.getName(), childEntity);
                }
            } else
            if(pc.get(i) instanceof OwnPropertyInfo)
            {
                own = (OwnPropertyInfo)pc.get(i);
                String ownName = own.getName();
                String dataType = own.getDataType().getName();
                if(own.getDataType().getName().equals("Enum"))
                {
                    Object em[] = EnumUtils.getEnumList(own.getMetaDataRef()).toArray();
                    if(em[0] instanceof StringEnum)
                        dataType = "String";
                    else
                    if(em[0] instanceof IntEnum)
                        dataType = "Integer";
                }
                headMapcol.put(ownName, dataType);
            }
        }

    }
    return headMapcol;
}

private static Map getEntriesEntityInfo(EntityObjectInfo headEo)
{
    Map entriesMap = new HashMap();
    if(headEo != null)
    {
        PropertyCollection pc = headEo.getPropertiesRuntime();
        LinkPropertyInfo link = null;
        EntityObjectInfo childEntity = null;
        for(int i = 0; i < pc.size(); i++)
        {
            link = null;
            childEntity = null;
            if(pc.get(i) instanceof LinkPropertyInfo)
            {
                link = (LinkPropertyInfo)pc.get(i);
                if(link.getMappingField() == null || "".equals(link.getMappingField().getName()))
                    entriesMap.put(link.getName(), link.getRelationship().getSupplierObject());
            }
        }

    }
    return entriesMap;
}

public static Map getBillEntiesProperties(Context ctx, String entiesName, EntityObjectInfo eo)
{
    Map entriesMap = getEntriesEntityInfo(eo);
    if(entriesMap != null)
    {
        EntityObjectInfo entry = (EntityObjectInfo)entriesMap.get(entiesName);
        if(entry != null)
            return getBillHeadProperties(entry);
    }
    return null;
}

static final Logger logger = Logger.getLogger("com.kingdee.eas.custom.WSInterface.common.WSCommonImportUtil");
}
