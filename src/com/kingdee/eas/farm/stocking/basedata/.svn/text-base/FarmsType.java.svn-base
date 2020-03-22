/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class FarmsType extends StringEnum
{
    public static final String LY_VALUE = "0";//alias=笼养
    public static final String PY_VALUE = "1";//alias=平养
    public static final String NETFEED_VALUE = "2";//alias=网养
    public static final String LYANDNETFEED_VALUE = "3";//alias=笼养+网养

    public static final FarmsType ly = new FarmsType("ly", LY_VALUE);
    public static final FarmsType py = new FarmsType("py", PY_VALUE);
    public static final FarmsType netFeed = new FarmsType("netFeed", NETFEED_VALUE);
    public static final FarmsType lyAndNetFeed = new FarmsType("lyAndNetFeed", LYANDNETFEED_VALUE);

    /**
     * construct function
     * @param String farmsType
     */
    private FarmsType(String name, String farmsType)
    {
        super(name, farmsType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmsType getEnum(String farmsType)
    {
        return (FarmsType)getEnum(FarmsType.class, farmsType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FarmsType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FarmsType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FarmsType.class);
    }
}