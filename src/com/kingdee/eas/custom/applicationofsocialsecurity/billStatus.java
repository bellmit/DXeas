/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class billStatus extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=保存
    public static final String SUBMIT_VALUE = "1";//alias=提交
    public static final String AUDIT_VALUE = "2";//alias=审核
    public static final String CANCELCANCEL_VALUE = "3";//alias=启用
    public static final String CANCEL_VALUE = "4";//alias=禁用

    public static final billStatus save = new billStatus("save", SAVE_VALUE);
    public static final billStatus submit = new billStatus("submit", SUBMIT_VALUE);
    public static final billStatus audit = new billStatus("audit", AUDIT_VALUE);
    public static final billStatus cancelcancel = new billStatus("cancelcancel", CANCELCANCEL_VALUE);
    public static final billStatus cancel = new billStatus("cancel", CANCEL_VALUE);

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