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
public class WeighBaseStatus extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=保存
    public static final String TARE_VALUE = "1";//alias=已过皮重
    public static final String GROSS_VALUE = "2";//alias=已过毛重
    public static final String CANCEL_VALUE = "3";//alias=作废
    public static final String FINISH_VALUE = "4";//alias=过磅完成
    public static final String QCFINISH_VALUE = "5";//alias=质检完成
    public static final String AUDIT_VALUE = "6";//alias=审核

    public static final WeighBaseStatus save = new WeighBaseStatus("save", SAVE_VALUE);
    public static final WeighBaseStatus tare = new WeighBaseStatus("tare", TARE_VALUE);
    public static final WeighBaseStatus gross = new WeighBaseStatus("gross", GROSS_VALUE);
    public static final WeighBaseStatus cancel = new WeighBaseStatus("cancel", CANCEL_VALUE);
    public static final WeighBaseStatus finish = new WeighBaseStatus("finish", FINISH_VALUE);
    public static final WeighBaseStatus qcFinish = new WeighBaseStatus("qcFinish", QCFINISH_VALUE);
    public static final WeighBaseStatus audit = new WeighBaseStatus("audit", AUDIT_VALUE);

    /**
     * construct function
     * @param String weighBaseStatus
     */
    private WeighBaseStatus(String name, String weighBaseStatus)
    {
        super(name, weighBaseStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static WeighBaseStatus getEnum(String weighBaseStatus)
    {
        return (WeighBaseStatus)getEnum(WeighBaseStatus.class, weighBaseStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(WeighBaseStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(WeighBaseStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(WeighBaseStatus.class);
    }
}