/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class PurchaseType extends StringEnum
{
    public static final String CONTRACT_VALUE = "1";//alias=合同
    public static final String PROTOCOL_VALUE = "2";//alias=协议

    public static final PurchaseType Contract = new PurchaseType("Contract", CONTRACT_VALUE);
    public static final PurchaseType protocol = new PurchaseType("protocol", PROTOCOL_VALUE);

    /**
     * construct function
     * @param String purchaseType
     */
    private PurchaseType(String name, String purchaseType)
    {
        super(name, purchaseType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PurchaseType getEnum(String purchaseType)
    {
        return (PurchaseType)getEnum(PurchaseType.class, purchaseType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PurchaseType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PurchaseType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PurchaseType.class);
    }
}