/**
 * output package name
 */
package com.kingdee.eas.farm.food;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class CountBillType extends StringEnum
{
    public static final String FRESHBILL_VALUE = "1";//alias=鲜品计数
    public static final String FREEZEBILL_VALUE = "2";//alias=冻品

    public static final CountBillType freshBill = new CountBillType("freshBill", FRESHBILL_VALUE);
    public static final CountBillType freezeBill = new CountBillType("freezeBill", FREEZEBILL_VALUE);

    /**
     * construct function
     * @param String countBillType
     */
    private CountBillType(String name, String countBillType)
    {
        super(name, countBillType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CountBillType getEnum(String countBillType)
    {
        return (CountBillType)getEnum(CountBillType.class, countBillType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CountBillType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CountBillType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CountBillType.class);
    }
}