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
public class billStatus extends StringEnum
{
    public static final String SAVE_VALUE = "1";//alias=保存
    public static final String SUBMIT_VALUE = "2";//alias=提交
    public static final String AUDIT_VALUE = "3";//alias=审核
    public static final String REJECTED_VALUE = "4";//alias=驳回
    public static final String UNAUDIT_VALUE = "5";//alias=反审核

    public static final billStatus save = new billStatus("save", SAVE_VALUE);
    public static final billStatus submit = new billStatus("submit", SUBMIT_VALUE);
    public static final billStatus Audit = new billStatus("Audit", AUDIT_VALUE);
    public static final billStatus Rejected = new billStatus("Rejected", REJECTED_VALUE);
    public static final billStatus unAudit = new billStatus("unAudit", UNAUDIT_VALUE);

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