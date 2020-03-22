/**
 * output package name
 */
package com.kingdee.eas.custom.eas2wincos;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class EAS2WinCosOPTypeEnum extends IntEnum
{
    public static final int PURINWAREHOUSE_VALUE = 1;//alias=导出采购入库单
    public static final int SALEISSUE_VALUE = 2;//alias=导出销售出库单
    public static final int MANUFACTUREORDER_VALUE = 3;//alias=导出生产订单
    public static final int MATERIALREQ_VALUE = 4;//alias=导入领料出库单
    public static final int PRODUCTIN_VALUE = 5;//alias=导入生产入库单

    public static final EAS2WinCosOPTypeEnum purInwarehouse = new EAS2WinCosOPTypeEnum("purInwarehouse", PURINWAREHOUSE_VALUE);
    public static final EAS2WinCosOPTypeEnum saleIssue = new EAS2WinCosOPTypeEnum("saleIssue", SALEISSUE_VALUE);
    public static final EAS2WinCosOPTypeEnum manufactureOrder = new EAS2WinCosOPTypeEnum("manufactureOrder", MANUFACTUREORDER_VALUE);
    public static final EAS2WinCosOPTypeEnum materialReq = new EAS2WinCosOPTypeEnum("materialReq", MATERIALREQ_VALUE);
    public static final EAS2WinCosOPTypeEnum productIn = new EAS2WinCosOPTypeEnum("productIn", PRODUCTIN_VALUE);

    /**
     * construct function
     * @param integer eAS2WinCosOPTypeEnum
     */
    private EAS2WinCosOPTypeEnum(String name, int eAS2WinCosOPTypeEnum)
    {
        super(name, eAS2WinCosOPTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2WinCosOPTypeEnum getEnum(String eAS2WinCosOPTypeEnum)
    {
        return (EAS2WinCosOPTypeEnum)getEnum(EAS2WinCosOPTypeEnum.class, eAS2WinCosOPTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EAS2WinCosOPTypeEnum getEnum(int eAS2WinCosOPTypeEnum)
    {
        return (EAS2WinCosOPTypeEnum)getEnum(EAS2WinCosOPTypeEnum.class, eAS2WinCosOPTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EAS2WinCosOPTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EAS2WinCosOPTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EAS2WinCosOPTypeEnum.class);
    }
}