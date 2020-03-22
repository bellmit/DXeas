/**
 * output package name
 */
package com.kingdee.eas.custom.settlebill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class billStatus extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=±£¥Ê
    public static final String SUBMIT_VALUE = "1";//alias=Ã·Ωª
    public static final String AUDIT_VALUE = "2";//alias=…Û∫À

    public static final billStatus SAVE = new billStatus("SAVE", SAVE_VALUE);
    public static final billStatus SUBMIT = new billStatus("SUBMIT", SUBMIT_VALUE);
    public static final billStatus AUDIT = new billStatus("AUDIT", AUDIT_VALUE);

    /**
     * construct function
     * @param String billStatus
     */
    private billStatus(String name, String billStatus)
    {
        super(name, billStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static billStatus getEnum(String billStatus)
    {
        return (billStatus)getEnum(billStatus.class, billStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(billStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(billStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(billStatus.class);
    }
}