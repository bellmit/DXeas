/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class BatchChangeTypeEnum extends IntEnum
{
    public static final int SUPPLEMENT_VALUE = 1;//alias=²¹Ãç
    public static final int OTHER_VALUE = 9;//alias=ÆäËû

    public static final BatchChangeTypeEnum supplement = new BatchChangeTypeEnum("supplement", SUPPLEMENT_VALUE);
    public static final BatchChangeTypeEnum other = new BatchChangeTypeEnum("other", OTHER_VALUE);

    /**
     * construct function
     * @param integer batchChangeTypeEnum
     */
    private BatchChangeTypeEnum(String name, int batchChangeTypeEnum)
    {
        super(name, batchChangeTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static BatchChangeTypeEnum getEnum(String batchChangeTypeEnum)
    {
        return (BatchChangeTypeEnum)getEnum(BatchChangeTypeEnum.class, batchChangeTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static BatchChangeTypeEnum getEnum(int batchChangeTypeEnum)
    {
        return (BatchChangeTypeEnum)getEnum(BatchChangeTypeEnum.class, batchChangeTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(BatchChangeTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(BatchChangeTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(BatchChangeTypeEnum.class);
    }
}