/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.hatch;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class EggSettlePolicyType extends IntEnum
{
    public static final int CONTRACTPRICE_VALUE = 1;//alias=合同价
    public static final int INSTEAD_VALUE = 2;//alias=代孵费
    public static final int SETTLEPRICE_VALUE = 3;//alias=结算价
    public static final int POLICYPRICE_VALUE = 4;//alias=政策价
    public static final int SEEDINSTEADPRICE_VALUE = 5;//alias=苗报价-代孵费

    public static final EggSettlePolicyType contractPrice = new EggSettlePolicyType("contractPrice", CONTRACTPRICE_VALUE);
    public static final EggSettlePolicyType instead = new EggSettlePolicyType("instead", INSTEAD_VALUE);
    public static final EggSettlePolicyType settlePrice = new EggSettlePolicyType("settlePrice", SETTLEPRICE_VALUE);
    public static final EggSettlePolicyType policyPrice = new EggSettlePolicyType("policyPrice", POLICYPRICE_VALUE);
    public static final EggSettlePolicyType seedInsteadPrice = new EggSettlePolicyType("seedInsteadPrice", SEEDINSTEADPRICE_VALUE);

    /**
     * construct function
     * @param integer eggSettlePolicyType
     */
    private EggSettlePolicyType(String name, int eggSettlePolicyType)
    {
        super(name, eggSettlePolicyType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EggSettlePolicyType getEnum(String eggSettlePolicyType)
    {
        return (EggSettlePolicyType)getEnum(EggSettlePolicyType.class, eggSettlePolicyType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EggSettlePolicyType getEnum(int eggSettlePolicyType)
    {
        return (EggSettlePolicyType)getEnum(EggSettlePolicyType.class, eggSettlePolicyType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EggSettlePolicyType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EggSettlePolicyType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EggSettlePolicyType.class);
    }
}