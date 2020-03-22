/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class ProductStatus extends IntEnum
{
    public static final int EXPORTED_VALUE = 1;//alias=导出到中控
    public static final int RECEIVE_VALUE = 2;//alias=中控已读取
    public static final int BEGIN_VALUE = 3;//alias=开始生产
    public static final int FINISH_VALUE = 4;//alias=完成生产

    public static final ProductStatus exported = new ProductStatus("exported", EXPORTED_VALUE);
    public static final ProductStatus receive = new ProductStatus("receive", RECEIVE_VALUE);
    public static final ProductStatus begin = new ProductStatus("begin", BEGIN_VALUE);
    public static final ProductStatus finish = new ProductStatus("finish", FINISH_VALUE);

    /**
     * construct function
     * @param integer productStatus
     */
    private ProductStatus(String name, int productStatus)
    {
        super(name, productStatus);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ProductStatus getEnum(String productStatus)
    {
        return (ProductStatus)getEnum(ProductStatus.class, productStatus);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static ProductStatus getEnum(int productStatus)
    {
        return (ProductStatus)getEnum(ProductStatus.class, productStatus);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ProductStatus.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ProductStatus.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ProductStatus.class);
    }
}