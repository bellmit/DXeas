/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class UsedStatus extends StringEnum
{
    public static final String TRUEVALUE_VALUE = "1";//alias=启用
    public static final String FALSEVALUE_VALUE = "2";//alias=禁用
    public static final String SAVEVALUE_VALUE = "3";//alias=保存
    public static final String AUDITVALUE_VALUE = "4";//alias=审核
    public static final String SUBMIT_VALUE = "5";//alias=提交

    public static final UsedStatus trueValue = new UsedStatus("trueValue", TRUEVALUE_VALUE);
    public static final UsedStatus falseValue = new UsedStatus("falseValue", FALSEVALUE_VALUE);
    public static final UsedStatus saveValue = new UsedStatus("saveValue", SAVEVALUE_VALUE);
    public static final UsedStatus auditValue = new UsedStatus("auditValue", AUDITVALUE_VALUE);
    public static final UsedStatus submit = new UsedStatus("submit", SUBMIT_VALUE);

    /**
     * construct function
     * @param String usedStatus
     */
    private UsedStatus(String name, String usedStatus)
    {
        super(name, usedStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static UsedStatus getEnum(String usedStatus)
    {
        return (UsedStatus)getEnum(UsedStatus.class, usedStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(UsedStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(UsedStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(UsedStatus.class);
    }
}