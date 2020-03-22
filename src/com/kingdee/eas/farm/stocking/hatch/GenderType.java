/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class GenderType extends StringEnum
{
    public static final String AB_VALUE = "1";//alias=AB
    public static final String CD_VALUE = "2";//alias=CD

    public static final GenderType AB = new GenderType("AB", AB_VALUE);
    public static final GenderType CD = new GenderType("CD", CD_VALUE);

    /**
     * construct function
     * @param String genderType
     */
    private GenderType(String name, String genderType)
    {
        super(name, genderType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static GenderType getEnum(String genderType)
    {
        return (GenderType)getEnum(GenderType.class, genderType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(GenderType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(GenderType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(GenderType.class);
    }
}