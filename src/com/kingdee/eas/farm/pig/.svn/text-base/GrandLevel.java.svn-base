/**
 * output package name
 */
package com.kingdee.eas.farm.pig;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class GrandLevel extends StringEnum
{
    public static final String PARENTAL_VALUE = "1";//alias=¸¸Ä¸´ø
    public static final String GRAND_VALUE = "2";//alias=×æ´ú
    public static final String GREATGRAND_VALUE = "3";//alias=Ôø×æ´ú

    public static final GrandLevel Parental = new GrandLevel("Parental", PARENTAL_VALUE);
    public static final GrandLevel Grand = new GrandLevel("Grand", GRAND_VALUE);
    public static final GrandLevel GreatGrand = new GrandLevel("GreatGrand", GREATGRAND_VALUE);

    /**
     * construct function
     * @param String grandLevel
     */
    private GrandLevel(String name, String grandLevel)
    {
        super(name, grandLevel);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static GrandLevel getEnum(String grandLevel)
    {
        return (GrandLevel)getEnum(GrandLevel.class, grandLevel);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(GrandLevel.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(GrandLevel.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(GrandLevel.class);
    }
}