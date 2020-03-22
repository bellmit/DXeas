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
public class GoType extends StringEnum
{
    public static final String INNER_VALUE = "1";//alias=内部调拨
    public static final String OUT_VALUE = "2";//alias=外部销售

    public static final GoType INNER = new GoType("INNER", INNER_VALUE);
    public static final GoType OUT = new GoType("OUT", OUT_VALUE);

    /**
     * construct function
     * @param String goType
     */
    private GoType(String name, String goType)
    {
        super(name, goType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static GoType getEnum(String goType)
    {
        return (GoType)getEnum(GoType.class, goType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(GoType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(GoType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(GoType.class);
    }
}