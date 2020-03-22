/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class billStatus extends StringEnum
{
    public static final String ADD_VALUE = "1";//alias=新增
    public static final String SAVE_VALUE = "2";//alias=保存
    public static final String SUBMIT_VALUE = "3";//alias=提交
    public static final String AUDIT_VALUE = "4";//alias=审核
    public static final String CLOSE_VALUE = "7";//alias=关闭

    public static final billStatus add = new billStatus("add", ADD_VALUE);
    public static final billStatus save = new billStatus("save", SAVE_VALUE);
    public static final billStatus submit = new billStatus("submit", SUBMIT_VALUE);
    public static final billStatus audit = new billStatus("audit", AUDIT_VALUE);
    public static final billStatus close = new billStatus("close", CLOSE_VALUE);

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