/**
 * output package name
 */
package com.kingdee.eas.bdm.bdapply;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class MaterialProcuctCategory extends StringEnum
{
    public static final String MAINPRODUCT_VALUE = "1";//alias=主产产品
    public static final String MINORPRODUCT_VALUE = "2";//alias=副产产品
    public static final String BYPRODUCT_VALUE = "3";//alias=副产品

    public static final MaterialProcuctCategory MainProduct = new MaterialProcuctCategory("MainProduct", MAINPRODUCT_VALUE);
    public static final MaterialProcuctCategory MinorProduct = new MaterialProcuctCategory("MinorProduct", MINORPRODUCT_VALUE);
    public static final MaterialProcuctCategory ByProduct = new MaterialProcuctCategory("ByProduct", BYPRODUCT_VALUE);

    /**
     * construct function
     * @param String materialProcuctCategory
     */
    private MaterialProcuctCategory(String name, String materialProcuctCategory)
    {
        super(name, materialProcuctCategory);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static MaterialProcuctCategory getEnum(String materialProcuctCategory)
    {
        return (MaterialProcuctCategory)getEnum(MaterialProcuctCategory.class, materialProcuctCategory);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(MaterialProcuctCategory.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(MaterialProcuctCategory.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(MaterialProcuctCategory.class);
    }
}