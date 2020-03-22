/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class DiscountTypeEnum extends StringEnum
{
    public static final String LIZHE_VALUE = "1";//alias=立折
    public static final String SHIWU_VALUE = "2";//alias=实物
    public static final String YUEZHE_VALUE = "3";//alias=月折
    public static final String NIANZHE_VALUE = "4";//alias=年折
    public static final String FENXIAO_VALUE = "5";//alias=分销

    public static final DiscountTypeEnum LiZhe = new DiscountTypeEnum("LiZhe", LIZHE_VALUE);
    public static final DiscountTypeEnum ShiWu = new DiscountTypeEnum("ShiWu", SHIWU_VALUE);
    public static final DiscountTypeEnum YueZhe = new DiscountTypeEnum("YueZhe", YUEZHE_VALUE);
    public static final DiscountTypeEnum NianZhe = new DiscountTypeEnum("NianZhe", NIANZHE_VALUE);
    public static final DiscountTypeEnum FenXiao = new DiscountTypeEnum("FenXiao", FENXIAO_VALUE);

    /**
     * construct function
     * @param String discountTypeEnum
     */
    private DiscountTypeEnum(String name, String discountTypeEnum)
    {
        super(name, discountTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static DiscountTypeEnum getEnum(String discountTypeEnum)
    {
        return (DiscountTypeEnum)getEnum(DiscountTypeEnum.class, discountTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(DiscountTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(DiscountTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(DiscountTypeEnum.class);
    }
}