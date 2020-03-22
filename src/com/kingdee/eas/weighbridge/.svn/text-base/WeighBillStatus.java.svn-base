/**
 * output package name
 */
package com.kingdee.eas.weighbridge;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class WeighBillStatus extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=保存
    public static final String TARE_VALUE = "1";//alias=已过皮重
    public static final String GROSS_VALUE = "2";//alias=已过毛重
    public static final String CANCEL_VALUE = "3";//alias=作废
    public static final String FINISH_VALUE = "4";//alias=过磅完成
    public static final String QCFINISH_VALUE = "5";//alias=质检完成
    public static final String AUDIT_VALUE = "6";//alias=审核

    public static final WeighBillStatus save = new WeighBillStatus("save", SAVE_VALUE);
    public static final WeighBillStatus tare = new WeighBillStatus("tare", TARE_VALUE);
    public static final WeighBillStatus gross = new WeighBillStatus("gross", GROSS_VALUE);
    public static final WeighBillStatus cancel = new WeighBillStatus("cancel", CANCEL_VALUE);
    public static final WeighBillStatus finish = new WeighBillStatus("finish", FINISH_VALUE);
    public static final WeighBillStatus qcFinish = new WeighBillStatus("qcFinish", QCFINISH_VALUE);
    public static final WeighBillStatus audit = new WeighBillStatus("audit", AUDIT_VALUE);

    /**
     * construct function
     * @param String weighBillStatus
     */
    private WeighBillStatus(String name, String weighBillStatus)
    {
        super(name, weighBillStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WeighBillStatus getEnum(String weighBillStatus)
    {
        return (WeighBillStatus)getEnum(WeighBillStatus.class, weighBillStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WeighBillStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WeighBillStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WeighBillStatus.class);
    }
}