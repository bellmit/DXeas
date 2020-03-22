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
public class scrapType extends StringEnum
{
    public static final String EAT_VALUE = "0";//alias=Ê³ÓÃ
    public static final String GIFT_VALUE = "1";//alias=ËÍÀñ/ËÍ¼ì
    public static final String REPORTEDLOSS_VALUE = "2";//alias=±¨Ëð

    public static final scrapType eat = new scrapType("eat", EAT_VALUE);
    public static final scrapType gift = new scrapType("gift", GIFT_VALUE);
    public static final scrapType reportedLoss = new scrapType("reportedLoss", REPORTEDLOSS_VALUE);

    /**
     * construct function
     * @param String scrapType
     */
    private scrapType(String name, String scrapType)
    {
        super(name, scrapType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static scrapType getEnum(String scrapType)
    {
        return (scrapType)getEnum(scrapType.class, scrapType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(scrapType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(scrapType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(scrapType.class);
    }
}