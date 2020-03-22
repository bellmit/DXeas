/**
 * output package name
 */
package com.kingdee.eas.custom.wages;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class byThePieceUnit extends StringEnum
{
    public static final String KILOGRAM_VALUE = "0";//alias=¹«½ï
    public static final String ROOT_VALUE = "1";//alias=¸ù
    public static final String BAG_VALUE = "2";//alias=´ü
    public static final String TON_VALUE = "3";//alias=¶Ö

    public static final byThePieceUnit kilogram = new byThePieceUnit("kilogram", KILOGRAM_VALUE);
    public static final byThePieceUnit root = new byThePieceUnit("root", ROOT_VALUE);
    public static final byThePieceUnit bag = new byThePieceUnit("bag", BAG_VALUE);
    public static final byThePieceUnit ton = new byThePieceUnit("ton", TON_VALUE);

    /**
     * construct function
     * @param String byThePieceUnit
     */
    private byThePieceUnit(String name, String byThePieceUnit)
    {
        super(name, byThePieceUnit);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static byThePieceUnit getEnum(String byThePieceUnit)
    {
        return (byThePieceUnit)getEnum(byThePieceUnit.class, byThePieceUnit);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(byThePieceUnit.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(byThePieceUnit.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(byThePieceUnit.class);
    }
}