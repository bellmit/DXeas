/**
 * output package name
 */
package com.kingdee.eas.custom.mobileRPT.client;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class RPTNameEnum extends StringEnum
{
    public static final String RECHICKEN_VALUE = "reChicken";//alias=毛鸡回收日报表
    public static final String PRODUCTDAILY_VALUE = "ProductDaily";//alias=生产日报单
    public static final String SRPT_VALUE = "SaleRpt";//alias=销售报表（新）
    public static final String MRPT_VALUE = "MaterialRpt";//alias=原料
    public static final String HRRPT_VALUE = "HRRpt";//alias=人力资源报表
    public static final String SPC_VALUE = "SalePriceCompare";//alias=销售价格差异表

    public static final RPTNameEnum RECHICKEN = new RPTNameEnum("RECHICKEN", RECHICKEN_VALUE);
    public static final RPTNameEnum PRODUCTDAILY = new RPTNameEnum("PRODUCTDAILY", PRODUCTDAILY_VALUE);
    public static final RPTNameEnum SRPT = new RPTNameEnum("SRPT", SRPT_VALUE);
    public static final RPTNameEnum MRPT = new RPTNameEnum("MRPT", MRPT_VALUE);
    public static final RPTNameEnum HRRPT = new RPTNameEnum("HRRPT", HRRPT_VALUE);
    public static final RPTNameEnum SPC = new RPTNameEnum("SPC", SPC_VALUE);

    /**
     * construct function
     * @param String rPTNameEnum
     */
    private RPTNameEnum(String name, String rPTNameEnum)
    {
        super(name, rPTNameEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static RPTNameEnum getEnum(String rPTNameEnum)
    {
        return (RPTNameEnum)getEnum(RPTNameEnum.class, rPTNameEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(RPTNameEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(RPTNameEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(RPTNameEnum.class);
    }
}