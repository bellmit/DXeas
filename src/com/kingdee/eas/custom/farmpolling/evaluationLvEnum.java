/**
 * output package name
 */
package com.kingdee.eas.custom.farmpolling;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class evaluationLvEnum extends IntEnum
{
    public static final int GOOD_VALUE = 1;//alias=Á¼ºÃ
    public static final int GENERAL_VALUE = 2;//alias=Ò»°ã
    public static final int WORSE_VALUE = 3;//alias=½Ï²î

    public static final evaluationLvEnum good = new evaluationLvEnum("good", GOOD_VALUE);
    public static final evaluationLvEnum general = new evaluationLvEnum("general", GENERAL_VALUE);
    public static final evaluationLvEnum worse = new evaluationLvEnum("worse", WORSE_VALUE);

    /**
     * construct function
     * @param integer evaluationLvEnum
     */
    private evaluationLvEnum(String name, int evaluationLvEnum)
    {
        super(name, evaluationLvEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static evaluationLvEnum getEnum(String evaluationLvEnum)
    {
        return (evaluationLvEnum)getEnum(evaluationLvEnum.class, evaluationLvEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static evaluationLvEnum getEnum(int evaluationLvEnum)
    {
        return (evaluationLvEnum)getEnum(evaluationLvEnum.class, evaluationLvEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(evaluationLvEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(evaluationLvEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(evaluationLvEnum.class);
    }
}