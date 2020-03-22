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
public class HatchBillTypeEnum extends IntEnum
{
    public static final int HATCHBILL_VALUE = 0;//alias=上孵单
    public static final int CANDLINGBILL_VALUE = 1;//alias=照蛋记录单
    public static final int TRAYINGBILL_VALUE = 2;//alias=落盘记录单
    public static final int OUTBIRDSBILL_VALUE = 3;//alias=出雏单

    public static final HatchBillTypeEnum hatchBill = new HatchBillTypeEnum("hatchBill", HATCHBILL_VALUE);
    public static final HatchBillTypeEnum candlingBill = new HatchBillTypeEnum("candlingBill", CANDLINGBILL_VALUE);
    public static final HatchBillTypeEnum trayingBill = new HatchBillTypeEnum("trayingBill", TRAYINGBILL_VALUE);
    public static final HatchBillTypeEnum outBirdsBill = new HatchBillTypeEnum("outBirdsBill", OUTBIRDSBILL_VALUE);

    /**
     * construct function
     * @param integer hatchBillTypeEnum
     */
    private HatchBillTypeEnum(String name, int hatchBillTypeEnum)
    {
        super(name, hatchBillTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static HatchBillTypeEnum getEnum(String hatchBillTypeEnum)
    {
        return (HatchBillTypeEnum)getEnum(HatchBillTypeEnum.class, hatchBillTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static HatchBillTypeEnum getEnum(int hatchBillTypeEnum)
    {
        return (HatchBillTypeEnum)getEnum(HatchBillTypeEnum.class, hatchBillTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(HatchBillTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(HatchBillTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(HatchBillTypeEnum.class);
    }
}