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
public class BasicStatus extends StringEnum
{
    public static final String OPEN_VALUE = "0";//alias=∆Ù”√
    public static final String CLOSE_VALUE = "1";//alias=Ω˚”√

    public static final BasicStatus open = new BasicStatus("open", OPEN_VALUE);
    public static final BasicStatus close = new BasicStatus("close", CLOSE_VALUE);

    /**
     * construct function
     * @param String basicStatus
     */
    private BasicStatus(String name, String basicStatus)
    {
        super(name, basicStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BasicStatus getEnum(String basicStatus)
    {
        return (BasicStatus)getEnum(BasicStatus.class, basicStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BasicStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BasicStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BasicStatus.class);
    }
}