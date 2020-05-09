/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class EggSourceType extends StringEnum
{
    public static final String INNERCOLLECT_VALUE = "0";//alias=×Ô²ú
    public static final String OUTPUR_VALUE = "1";//alias=Íâ¹º

    public static final EggSourceType innerCollect = new EggSourceType("innerCollect", INNERCOLLECT_VALUE);
    public static final EggSourceType outPur = new EggSourceType("outPur", OUTPUR_VALUE);

    /**
     * construct function
     * @param String eggSourceType
     */
    private EggSourceType(String name, String eggSourceType)
    {
        super(name, eggSourceType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EggSourceType getEnum(String eggSourceType)
    {
        return (EggSourceType)getEnum(EggSourceType.class, eggSourceType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EggSourceType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EggSourceType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EggSourceType.class);
    }
}