/**
 * output package name
 */
package com.kingdee.eas.farm.hatch;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class EggSourceType extends IntEnum
{
    public static final int INTERNALFARM_VALUE = 1;//alias=������ֳ��
    public static final int SUBCONTRACT_VALUE = 2;//alias=��������
    public static final int INTERNALPURCHASE_VALUE = 4;//alias=�����ڲɹ�
    public static final int PURCHASE_VALUE = 3;//alias=�ⲿ�ɹ�
    public static final int PURCHASEINSTEAD_VALUE = 5;//alias=��Ӧ�̴���

    public static final EggSourceType InternalFarm = new EggSourceType("InternalFarm", INTERNALFARM_VALUE);
    public static final EggSourceType SubContract = new EggSourceType("SubContract", SUBCONTRACT_VALUE);
    public static final EggSourceType InternalPurchase = new EggSourceType("InternalPurchase", INTERNALPURCHASE_VALUE);
    public static final EggSourceType Purchase = new EggSourceType("Purchase", PURCHASE_VALUE);
    public static final EggSourceType PurchaseInstead = new EggSourceType("PurchaseInstead", PURCHASEINSTEAD_VALUE);

    /**
     * construct function
     * @param integer eggSourceType
     */
    private EggSourceType(String name, int eggSourceType)
    {
        super(name, eggSourceType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EggSourceType getEnum(String eggSourceType)
    {
        return (EggSourceType)getEnum(EggSourceType.class, eggSourceType);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EggSourceType getEnum(int eggSourceType)
    {
        return (EggSourceType)getEnum(EggSourceType.class, eggSourceType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EggSourceType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EggSourceType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EggSourceType.class);
    }
}