/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FeedType extends StringEnum
{
    public static final String INCAGE_VALUE = "0";//alias=笼养
    public static final String ONFLOOR_VALUE = "1";//alias=地养
    public static final String INWEB_VALUE = "2";//alias=网养

    public static final FeedType InCage = new FeedType("InCage", INCAGE_VALUE);
    public static final FeedType onFloor = new FeedType("onFloor", ONFLOOR_VALUE);
    public static final FeedType inWeb = new FeedType("inWeb", INWEB_VALUE);

    /**
     * construct function
     * @param String feedType
     */
    private FeedType(String name, String feedType)
    {
        super(name, feedType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FeedType getEnum(String feedType)
    {
        return (FeedType)getEnum(FeedType.class, feedType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FeedType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FeedType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FeedType.class);
    }
}