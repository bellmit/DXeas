/**
 * output package name
 */
package com.kingdee.eas.farm.hatch;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class EggType extends StringEnum
{
    public static final String PARENT_VALUE = "Parent";//alias=¸¸Ä¸´ú
    public static final String GRAND_VALUE = "Grand";//alias=×æ´ú

    public static final EggType Parent = new EggType("Parent", PARENT_VALUE);
    public static final EggType Grand = new EggType("Grand", GRAND_VALUE);

    /**
     * construct function
     * @param String eggType
     */
    private EggType(String name, String eggType)
    {
        super(name, eggType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EggType getEnum(String eggType)
    {
        return (EggType)getEnum(EggType.class, eggType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EggType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EggType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EggType.class);
    }
}