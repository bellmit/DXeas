/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class OtherPaymentTypeEnum extends IntEnum
{
    public static final int CASH_VALUE = 1;//alias=现金
    public static final int TRANSFER_VALUE = 2;//alias=银行转账

    public static final OtherPaymentTypeEnum cash = new OtherPaymentTypeEnum("cash", CASH_VALUE);
    public static final OtherPaymentTypeEnum transfer = new OtherPaymentTypeEnum("transfer", TRANSFER_VALUE);

    /**
     * construct function
     * @param integer otherPaymentTypeEnum
     */
    private OtherPaymentTypeEnum(String name, int otherPaymentTypeEnum)
    {
        super(name, otherPaymentTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static OtherPaymentTypeEnum getEnum(String otherPaymentTypeEnum)
    {
        return (OtherPaymentTypeEnum)getEnum(OtherPaymentTypeEnum.class, otherPaymentTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static OtherPaymentTypeEnum getEnum(int otherPaymentTypeEnum)
    {
        return (OtherPaymentTypeEnum)getEnum(OtherPaymentTypeEnum.class, otherPaymentTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(OtherPaymentTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(OtherPaymentTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(OtherPaymentTypeEnum.class);
    }
}