/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class PaymentType extends StringEnum
{
    public static final String CASH_VALUE = "0";//alias=ож╫П
    public static final String TRANSFERACCOUNT_VALUE = "1";//alias=в╙ук

    public static final PaymentType Cash = new PaymentType("Cash", CASH_VALUE);
    public static final PaymentType TransferAccount = new PaymentType("TransferAccount", TRANSFERACCOUNT_VALUE);

    /**
     * construct function
     * @param String paymentType
     */
    private PaymentType(String name, String paymentType)
    {
        super(name, paymentType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PaymentType getEnum(String paymentType)
    {
        return (PaymentType)getEnum(PaymentType.class, paymentType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PaymentType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PaymentType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PaymentType.class);
    }
}