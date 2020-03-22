/**
 * output package name
 */
package com.kingdee.eas.farm.food.stocount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class CountSet extends StringEnum
{
    public static final String SEMI_VALUE = "0";//alias=半成品计数
    public static final String PRODUCT_VALUE = "1";//alias=成品计数
    public static final String PACK_VALUE = "2";//alias=包装计数

    public static final CountSet semi = new CountSet("semi", SEMI_VALUE);
    public static final CountSet product = new CountSet("product", PRODUCT_VALUE);
    public static final CountSet pack = new CountSet("pack", PACK_VALUE);

    /**
     * construct function
     * @param String countSet
     */
    private CountSet(String name, String countSet)
    {
        super(name, countSet);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CountSet getEnum(String countSet)
    {
        return (CountSet)getEnum(CountSet.class, countSet);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CountSet.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CountSet.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CountSet.class);
    }
}