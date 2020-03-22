/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FeedTypeEnum extends StringEnum
{
    public static final String INCAGE_VALUE = "0";//alias=ÁýÑø
    public static final String ONFLOOR_VALUE = "1";//alias=Æ½Ñø

    public static final FeedTypeEnum InCage = new FeedTypeEnum("InCage", INCAGE_VALUE);
    public static final FeedTypeEnum OnFloor = new FeedTypeEnum("OnFloor", ONFLOOR_VALUE);

    /**
     * construct function
     * @param String feedTypeEnum
     */
    private FeedTypeEnum(String name, String feedTypeEnum)
    {
        super(name, feedTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FeedTypeEnum getEnum(String feedTypeEnum)
    {
        return (FeedTypeEnum)getEnum(FeedTypeEnum.class, feedTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FeedTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FeedTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FeedTypeEnum.class);
    }
}