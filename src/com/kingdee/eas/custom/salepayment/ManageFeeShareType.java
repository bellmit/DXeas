/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ManageFeeShareType extends StringEnum
{
    public static final String MANUAL_VALUE = "1";//alias=按人工比例
    public static final String SALEQTY_VALUE = "2";//alias=按销量比例

    public static final ManageFeeShareType Manual = new ManageFeeShareType("Manual", MANUAL_VALUE);
    public static final ManageFeeShareType SaleQty = new ManageFeeShareType("SaleQty", SALEQTY_VALUE);

    /**
     * construct function
     * @param String manageFeeShareType
     */
    private ManageFeeShareType(String name, String manageFeeShareType)
    {
        super(name, manageFeeShareType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ManageFeeShareType getEnum(String manageFeeShareType)
    {
        return (ManageFeeShareType)getEnum(ManageFeeShareType.class, manageFeeShareType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ManageFeeShareType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ManageFeeShareType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ManageFeeShareType.class);
    }
}