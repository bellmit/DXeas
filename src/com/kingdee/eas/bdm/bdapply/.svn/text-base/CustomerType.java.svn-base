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
public class CustomerType extends StringEnum
{
    public static final String COMM_VALUE = "1";//alias=普通
    public static final String INVOICE_VALUE = "2";//alias=开票客户

    public static final CustomerType Comm = new CustomerType("Comm", COMM_VALUE);
    public static final CustomerType Invoice = new CustomerType("Invoice", INVOICE_VALUE);

    /**
     * construct function
     * @param String customerType
     */
    private CustomerType(String name, String customerType)
    {
        super(name, customerType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static CustomerType getEnum(String customerType)
    {
        return (CustomerType)getEnum(CustomerType.class, customerType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(CustomerType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(CustomerType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(CustomerType.class);
    }
}