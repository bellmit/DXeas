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
public class PurchaseMethod extends StringEnum
{
    public static final String SELF_VALUE = "0";//alias=×ÔËÍ
    public static final String SENDCAR_VALUE = "1";//alias=ÅÉ³µ

    public static final PurchaseMethod Self = new PurchaseMethod("Self", SELF_VALUE);
    public static final PurchaseMethod SendCar = new PurchaseMethod("SendCar", SENDCAR_VALUE);

    /**
     * construct function
     * @param String purchaseMethod
     */
    private PurchaseMethod(String name, String purchaseMethod)
    {
        super(name, purchaseMethod);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static PurchaseMethod getEnum(String purchaseMethod)
    {
        return (PurchaseMethod)getEnum(PurchaseMethod.class, purchaseMethod);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(PurchaseMethod.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(PurchaseMethod.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(PurchaseMethod.class);
    }
}