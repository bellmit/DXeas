/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BunkerEnum extends StringEnum
{
    public static final String NO_VALUE = "0";//alias=无料仓
    public static final String HAS_VALUE = "1";//alias=已建料仓
    public static final String CAN_VALUE = "2";//alias=可建料仓

    public static final BunkerEnum no = new BunkerEnum("no", NO_VALUE);
    public static final BunkerEnum has = new BunkerEnum("has", HAS_VALUE);
    public static final BunkerEnum can = new BunkerEnum("can", CAN_VALUE);

    /**
     * construct function
     * @param String bunkerEnum
     */
    private BunkerEnum(String name, String bunkerEnum)
    {
        super(name, bunkerEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BunkerEnum getEnum(String bunkerEnum)
    {
        return (BunkerEnum)getEnum(BunkerEnum.class, bunkerEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BunkerEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BunkerEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BunkerEnum.class);
    }
}