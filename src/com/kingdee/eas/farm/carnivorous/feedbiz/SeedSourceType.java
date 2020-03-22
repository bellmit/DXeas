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
public class SeedSourceType extends StringEnum
{
    public static final String INNERCOLLECT_VALUE = "0";//alias=ÄÚ²É
    public static final String OUTPUR_VALUE = "1";//alias=Íâ¹º

    public static final SeedSourceType innerCollect = new SeedSourceType("innerCollect", INNERCOLLECT_VALUE);
    public static final SeedSourceType outPur = new SeedSourceType("outPur", OUTPUR_VALUE);

    /**
     * construct function
     * @param String seedSourceType
     */
    private SeedSourceType(String name, String seedSourceType)
    {
        super(name, seedSourceType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SeedSourceType getEnum(String seedSourceType)
    {
        return (SeedSourceType)getEnum(SeedSourceType.class, seedSourceType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SeedSourceType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SeedSourceType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SeedSourceType.class);
    }
}