/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class voucherStatus extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=保存
    public static final String SUBMIT_VALUE = "1";//alias=提交
    public static final String AUDIT_VALUE = "2";//alias=审核
    public static final String CANCELCANCEL_VALUE = "3";//alias=启用

    public static final voucherStatus save = new voucherStatus("save", SAVE_VALUE);
    public static final voucherStatus submit = new voucherStatus("submit", SUBMIT_VALUE);
    public static final voucherStatus audit = new voucherStatus("audit", AUDIT_VALUE);
    public static final voucherStatus cancelcancel = new voucherStatus("cancelcancel", CANCELCANCEL_VALUE);

    /**
     * construct function
     * @param String voucherStatus
     */
    private voucherStatus(String name, String voucherStatus)
    {
        super(name, voucherStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static voucherStatus getEnum(String voucherStatus)
    {
        return (voucherStatus)getEnum(voucherStatus.class, voucherStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(voucherStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(voucherStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(voucherStatus.class);
    }
}