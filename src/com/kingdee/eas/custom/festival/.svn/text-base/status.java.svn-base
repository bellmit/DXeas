/**
 * output package name
 */
package com.kingdee.eas.custom.festival;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class status extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=±£¥Ê
    public static final String CANCELCANCEL_VALUE = "1";//alias=∆Ù”√

    public static final status save = new status("save", SAVE_VALUE);
    public static final status cancelcancel = new status("cancelcancel", CANCELCANCEL_VALUE);

    /**
     * construct function
     * @param String status
     */
    private status(String name, String status)
    {
        super(name, status);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static status getEnum(String status)
    {
        return (status)getEnum(status.class, status);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(status.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(status.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(status.class);
    }
}