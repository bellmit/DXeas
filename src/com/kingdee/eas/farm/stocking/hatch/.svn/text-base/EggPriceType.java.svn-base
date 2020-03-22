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
public class EggPriceType extends IntEnum
{
    public static final int NONEPRICE_VALUE = 0;//alias=无
    public static final int POLICYPRICE_VALUE = 1;//alias=政策价格
    public static final int DAILYPRICE_VALUE = 2;//alias=日价格
    public static final int SECONDPRICE_VALUE = 3;//alias=二次利润价格
    public static final int EGGPOLICY_VALUE = 4;//alias=合同价
    public static final int PURSETTLEPRICE_VALUE = 5;//alias=结算价
    public static final int INSTEADFEE_VALUE = 6;//alias=代孵费
    public static final int INSTEADSEEDPRICE_VALUE = 7;//alias=苗报价-代孵费

    public static final EggPriceType nonePrice = new EggPriceType("nonePrice", NONEPRICE_VALUE);
    public static final EggPriceType policyPrice = new EggPriceType("policyPrice", POLICYPRICE_VALUE);
    public static final EggPriceType dailyPrice = new EggPriceType("dailyPrice", DAILYPRICE_VALUE);
    public static final EggPriceType secondPrice = new EggPriceType("secondPrice", SECONDPRICE_VALUE);
    public static final EggPriceType eggPolicy = new EggPriceType("eggPolicy", EGGPOLICY_VALUE);
    public static final EggPriceType purSettlePrice = new EggPriceType("purSettlePrice", PURSETTLEPRICE_VALUE);
    public static final EggPriceType insteadFee = new EggPriceType("insteadFee", INSTEADFEE_VALUE);
    public static final EggPriceType insteadSeedPrice = new EggPriceType("insteadSeedPrice", INSTEADSEEDPRICE_VALUE);

    /**
     * construct function
     * @param integer eggPriceType
     */
    private EggPriceType(String name, int eggPriceType)
    {
        super(name, eggPriceType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EggPriceType getEnum(String eggPriceType)
    {
        return (EggPriceType)getEnum(EggPriceType.class, eggPriceType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EggPriceType getEnum(int eggPriceType)
    {
        return (EggPriceType)getEnum(EggPriceType.class, eggPriceType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EggPriceType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EggPriceType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EggPriceType.class);
    }
}