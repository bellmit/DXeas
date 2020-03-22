/**
 * output package name
 */
package com.kingdee.eas.weighbridge;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class DataBits extends StringEnum
{
    public static final String FIVE_VALUE = "5";//alias=5
    public static final String SIX_VALUE = "6";//alias=6
    public static final String SEVEN_VALUE = "7";//alias=7
    public static final String EGIHT_VALUE = "8";//alias=8

    public static final DataBits Five = new DataBits("Five", FIVE_VALUE);
    public static final DataBits Six = new DataBits("Six", SIX_VALUE);
    public static final DataBits Seven = new DataBits("Seven", SEVEN_VALUE);
    public static final DataBits egiht = new DataBits("egiht", EGIHT_VALUE);

    /**
     * construct function
     * @param String dataBits
     */
    private DataBits(String name, String dataBits)
    {
        super(name, dataBits);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DataBits getEnum(String dataBits)
    {
        return (DataBits)getEnum(DataBits.class, dataBits);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DataBits.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DataBits.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DataBits.class);
    }
}