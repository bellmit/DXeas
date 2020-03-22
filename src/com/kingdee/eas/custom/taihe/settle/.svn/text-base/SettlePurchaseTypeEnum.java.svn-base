/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class SettlePurchaseTypeEnum extends IntEnum
{
    public static final int CONTRACT_VALUE = 1;//alias=合同收购
    public static final int AGREEMENT_VALUE = 2;//alias=协议收购

    public static final SettlePurchaseTypeEnum Contract = new SettlePurchaseTypeEnum("Contract", CONTRACT_VALUE);
    public static final SettlePurchaseTypeEnum Agreement = new SettlePurchaseTypeEnum("Agreement", AGREEMENT_VALUE);

    /**
     * construct function
     * @param integer settlePurchaseTypeEnum
     */
    private SettlePurchaseTypeEnum(String name, int settlePurchaseTypeEnum)
    {
        super(name, settlePurchaseTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static SettlePurchaseTypeEnum getEnum(String settlePurchaseTypeEnum)
    {
        return (SettlePurchaseTypeEnum)getEnum(SettlePurchaseTypeEnum.class, settlePurchaseTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static SettlePurchaseTypeEnum getEnum(int settlePurchaseTypeEnum)
    {
        return (SettlePurchaseTypeEnum)getEnum(SettlePurchaseTypeEnum.class, settlePurchaseTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(SettlePurchaseTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(SettlePurchaseTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(SettlePurchaseTypeEnum.class);
    }
}