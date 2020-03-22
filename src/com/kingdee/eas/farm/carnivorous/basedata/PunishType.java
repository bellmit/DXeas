/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class PunishType extends StringEnum
{
    public static final String FORAMOUNT_VALUE = "0";//alias=¿Û½ð¶î
    public static final String FORWEIGHT_VALUE = "1";//alias=¿ÛÖØ

    public static final PunishType forAmount = new PunishType("forAmount", FORAMOUNT_VALUE);
    public static final PunishType forWeight = new PunishType("forWeight", FORWEIGHT_VALUE);

    /**
     * construct function
     * @param String punishType
     */
    private PunishType(String name, String punishType)
    {
        super(name, punishType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PunishType getEnum(String punishType)
    {
        return (PunishType)getEnum(PunishType.class, punishType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PunishType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PunishType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PunishType.class);
    }
}