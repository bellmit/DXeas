/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class MaterialType extends StringEnum
{
    public static final String SEEDCK_VALUE = "0";//alias=³û¼¦
    public static final String RECCK_VALUE = "1";//alias=Ã«¼¦
    public static final String MARKETPRICE_VALUE = "2";//alias=Ã«¼¦ÊÐ³¡¼Û

    public static final MaterialType seedCK = new MaterialType("seedCK", SEEDCK_VALUE);
    public static final MaterialType recCK = new MaterialType("recCK", RECCK_VALUE);
    public static final MaterialType marketPrice = new MaterialType("marketPrice", MARKETPRICE_VALUE);

    /**
     * construct function
     * @param String materialType
     */
    private MaterialType(String name, String materialType)
    {
        super(name, materialType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static MaterialType getEnum(String materialType)
    {
        return (MaterialType)getEnum(MaterialType.class, materialType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(MaterialType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(MaterialType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(MaterialType.class);
    }
}