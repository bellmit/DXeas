/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BillStatus extends StringEnum
{
    public static final String SAVE_VALUE = "1";//alias=±£¥Ê
    public static final String SUBMIT_VALUE = "2";//alias=Ã·Ωª
    public static final String AUDIT_VALUE = "3";//alias=…Û∫À

    public static final BillStatus save = new BillStatus("save", SAVE_VALUE);
    public static final BillStatus submit = new BillStatus("submit", SUBMIT_VALUE);
    public static final BillStatus audit = new BillStatus("audit", AUDIT_VALUE);

    /**
     * construct function
     * @param String billStatus
     */
    private BillStatus(String name, String billStatus)
    {
        super(name, billStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BillStatus getEnum(String billStatus)
    {
        return (BillStatus)getEnum(BillStatus.class, billStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BillStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BillStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BillStatus.class);
    }
}