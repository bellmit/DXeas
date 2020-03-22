/**
 * output package name
 */
package com.kingdee.eas.farm.breed;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class HenhouseType extends StringEnum
{
    public static final String GRANDPARENT_VALUE = "0";//alias=祖代
    public static final String LAYEGG_VALUE = "2";//alias=父母代
    public static final String CC_VALUE = "3";//alias=商品代
    public static final String BROOD_VALUE = "1";//alias=育成

    public static final HenhouseType GrandParent = new HenhouseType("GrandParent", GRANDPARENT_VALUE);
    public static final HenhouseType LayEgg = new HenhouseType("LayEgg", LAYEGG_VALUE);
    public static final HenhouseType CC = new HenhouseType("CC", CC_VALUE);
    public static final HenhouseType Brood = new HenhouseType("Brood", BROOD_VALUE);

    /**
     * construct function
     * @param String henhouseType
     */
    private HenhouseType(String name, String henhouseType)
    {
        super(name, henhouseType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static HenhouseType getEnum(String henhouseType)
    {
        return (HenhouseType)getEnum(HenhouseType.class, henhouseType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(HenhouseType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(HenhouseType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(HenhouseType.class);
    }
}