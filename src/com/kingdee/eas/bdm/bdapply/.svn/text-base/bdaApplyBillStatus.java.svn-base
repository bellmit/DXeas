/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class bdaApplyBillStatus extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=保存
    public static final String SUBMIT_VALUE = "1";//alias=提交
    public static final String AUDIT_VALUE = "4";//alias=审核通过
    public static final String UNAUDIT_VALUE = "5";//alias=审核不通过

    public static final bdaApplyBillStatus Save = new bdaApplyBillStatus("Save", SAVE_VALUE);
    public static final bdaApplyBillStatus Submit = new bdaApplyBillStatus("Submit", SUBMIT_VALUE);
    public static final bdaApplyBillStatus Audit = new bdaApplyBillStatus("Audit", AUDIT_VALUE);
    public static final bdaApplyBillStatus unAudit = new bdaApplyBillStatus("unAudit", UNAUDIT_VALUE);

    /**
     * construct function
     * @param String bdaApplyBillStatus
     */
    private bdaApplyBillStatus(String name, String bdaApplyBillStatus)
    {
        super(name, bdaApplyBillStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static bdaApplyBillStatus getEnum(String bdaApplyBillStatus)
    {
        return (bdaApplyBillStatus)getEnum(bdaApplyBillStatus.class, bdaApplyBillStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(bdaApplyBillStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(bdaApplyBillStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(bdaApplyBillStatus.class);
    }
}