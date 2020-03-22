/**
 * output package name
 */
package com.kingdee.eas.weighbridge;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class StorageBillType extends StringEnum
{
    public static final String INSTORAGE_VALUE = "1";//alias=入库过磅单
    public static final String OUTSTORAGE_VALUE = "2";//alias=出库过磅单

    public static final StorageBillType Instorage = new StorageBillType("Instorage", INSTORAGE_VALUE);
    public static final StorageBillType OutStorage = new StorageBillType("OutStorage", OUTSTORAGE_VALUE);

    /**
     * construct function
     * @param String storageBillType
     */
    private StorageBillType(String name, String storageBillType)
    {
        super(name, storageBillType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static StorageBillType getEnum(String storageBillType)
    {
        return (StorageBillType)getEnum(StorageBillType.class, storageBillType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(StorageBillType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(StorageBillType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(StorageBillType.class);
    }
}