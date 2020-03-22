/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class FarmROrPTypeEnum extends IntEnum
{
    public static final int PAYMENT_VALUE = 2;//alias=付款
    public static final int PAYFOROTHER_VALUE = 3;//alias=代付款
    public static final int RECEIVE_VALUE = 1;//alias=收款

    public static final FarmROrPTypeEnum payment = new FarmROrPTypeEnum("payment", PAYMENT_VALUE);
    public static final FarmROrPTypeEnum payForOther = new FarmROrPTypeEnum("payForOther", PAYFOROTHER_VALUE);
    public static final FarmROrPTypeEnum receive = new FarmROrPTypeEnum("receive", RECEIVE_VALUE);

    /**
     * construct function
     * @param integer farmROrPTypeEnum
     */
    private FarmROrPTypeEnum(String name, int farmROrPTypeEnum)
    {
        super(name, farmROrPTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmROrPTypeEnum getEnum(String farmROrPTypeEnum)
    {
        return (FarmROrPTypeEnum)getEnum(FarmROrPTypeEnum.class, farmROrPTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static FarmROrPTypeEnum getEnum(int farmROrPTypeEnum)
    {
        return (FarmROrPTypeEnum)getEnum(FarmROrPTypeEnum.class, farmROrPTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(FarmROrPTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(FarmROrPTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(FarmROrPTypeEnum.class);
    }
}