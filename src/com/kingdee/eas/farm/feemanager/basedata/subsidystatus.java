/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class subsidystatus extends StringEnum
{
    public static final String ENABLE_VALUE = "1";//alias=∆Ù”√
    public static final String DISABLE_VALUE = "2";//alias=Ω˚”√

    public static final subsidystatus Enable = new subsidystatus("Enable", ENABLE_VALUE);
    public static final subsidystatus Disable = new subsidystatus("Disable", DISABLE_VALUE);

    /**
     * construct function
     * @param String subsidystatus
     */
    private subsidystatus(String name, String subsidystatus)
    {
        super(name, subsidystatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static subsidystatus getEnum(String subsidystatus)
    {
        return (subsidystatus)getEnum(subsidystatus.class, subsidystatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(subsidystatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(subsidystatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(subsidystatus.class);
    }
}