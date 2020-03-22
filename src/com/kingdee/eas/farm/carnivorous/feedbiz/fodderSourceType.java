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
public class fodderSourceType extends StringEnum
{
    public static final String INNERCOLLECT_VALUE = "0";//alias=ÄÚ²É
    public static final String OUTPUR_VALUE = "1";//alias=Íâ¹º

    public static final fodderSourceType innerCollect = new fodderSourceType("innerCollect", INNERCOLLECT_VALUE);
    public static final fodderSourceType outPur = new fodderSourceType("outPur", OUTPUR_VALUE);

    /**
     * construct function
     * @param String fodderSourceType
     */
    private fodderSourceType(String name, String fodderSourceType)
    {
        super(name, fodderSourceType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static fodderSourceType getEnum(String fodderSourceType)
    {
        return (fodderSourceType)getEnum(fodderSourceType.class, fodderSourceType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(fodderSourceType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(fodderSourceType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(fodderSourceType.class);
    }
}