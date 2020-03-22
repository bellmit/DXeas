/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basebizbill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class BillStatusEnum extends StringEnum
{
    public static final String SAVE_VALUE = "0";//alias=保存
    public static final String ARRCAR_VALUE = "1";//alias=配车
    public static final String CONFIRM_VALUE = "2";//alias=司机确认
    public static final String REBACK_VALUE = "3";//alias=配送完成

    public static final BillStatusEnum Save = new BillStatusEnum("Save", SAVE_VALUE);
    public static final BillStatusEnum ArrCar = new BillStatusEnum("ArrCar", ARRCAR_VALUE);
    public static final BillStatusEnum Confirm = new BillStatusEnum("Confirm", CONFIRM_VALUE);
    public static final BillStatusEnum Reback = new BillStatusEnum("Reback", REBACK_VALUE);

    /**
     * construct function
     * @param String billStatusEnum
     */
    private BillStatusEnum(String name, String billStatusEnum)
    {
        super(name, billStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BillStatusEnum getEnum(String billStatusEnum)
    {
        return (BillStatusEnum)getEnum(BillStatusEnum.class, billStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BillStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BillStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BillStatusEnum.class);
    }
}