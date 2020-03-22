/**
 * output package name
 */
package com.kingdee.eas.custom.szcount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class ProductType extends IntEnum
{
    public static final int FRESH_VALUE = 0;//alias=œ ∆∑
    public static final int FREEZE_VALUE = 1;//alias=∂≥∆∑

    public static final ProductType fresh = new ProductType("fresh", FRESH_VALUE);
    public static final ProductType freeze = new ProductType("freeze", FREEZE_VALUE);

    /**
     * construct function
     * @param integer productType
     */
    private ProductType(String name, int productType)
    {
        super(name, productType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ProductType getEnum(String productType)
    {
        return (ProductType)getEnum(ProductType.class, productType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static ProductType getEnum(int productType)
    {
        return (ProductType)getEnum(ProductType.class, productType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ProductType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ProductType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ProductType.class);
    }
}