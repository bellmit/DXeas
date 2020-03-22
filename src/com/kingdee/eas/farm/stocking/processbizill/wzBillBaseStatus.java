/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class wzBillBaseStatus extends StringEnum
{
    public static final String SAVE_VALUE = "1";//alias=保存
    public static final String SUBMIT_VALUE = "2";//alias=提交
    public static final String AUDIT_VALUE = "3";//alias=审核
    public static final String UNAUDIT_VALUE = "4";//alias=反审核
    public static final String STATUSCANCEL_VALUE = "5";//alias=禁用
    public static final String STATUSCANCELCANCEL_VALUE = "6";//alias=启用
    public static final String ADD_VALUE = "7";//alias=新增

    public static final wzBillBaseStatus save = new wzBillBaseStatus("save", SAVE_VALUE);
    public static final wzBillBaseStatus submit = new wzBillBaseStatus("submit", SUBMIT_VALUE);
    public static final wzBillBaseStatus audit = new wzBillBaseStatus("audit", AUDIT_VALUE);
    public static final wzBillBaseStatus unAudit = new wzBillBaseStatus("unAudit", UNAUDIT_VALUE);
    public static final wzBillBaseStatus statusCancel = new wzBillBaseStatus("statusCancel", STATUSCANCEL_VALUE);
    public static final wzBillBaseStatus statusCancelCancel = new wzBillBaseStatus("statusCancelCancel", STATUSCANCELCANCEL_VALUE);
    public static final wzBillBaseStatus add = new wzBillBaseStatus("add", ADD_VALUE);

    /**
     * construct function
     * @param String wzBillBaseStatus
     */
    private wzBillBaseStatus(String name, String wzBillBaseStatus)
    {
        super(name, wzBillBaseStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static wzBillBaseStatus getEnum(String wzBillBaseStatus)
    {
        return (wzBillBaseStatus)getEnum(wzBillBaseStatus.class, wzBillBaseStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(wzBillBaseStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(wzBillBaseStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(wzBillBaseStatus.class);
    }
}