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
    public static final int NONEPRICE_VALUE = 0;//alias=��
    public static final int POLICYPRICE_VALUE = 1;//alias=���߼۸�
    public static final int DAILYPRICE_VALUE = 2;//alias=�ռ۸�
    public static final int SECONDPRICE_VALUE = 3;//alias=��������۸�
    public static final int EGGPOLICY_VALUE = 4;//alias=��ͬ��
    public static final int PURSETTLEPRICE_VALUE = 5;//alias=�����
    public static final int INSTEADFEE_VALUE = 6;//alias=������
    public static final int INSTEADSEEDPRICE_VALUE = 7;//alias=�籨��-������

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