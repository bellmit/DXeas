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
public class EduLvlEnum extends IntEnum
{
    public static final int PRIMARY_VALUE = 1;//alias=Сѧ������
    public static final int JUNIOR_VALUE = 2;//alias=����
    public static final int HIGH_VALUE = 3;//alias=����
    public static final int JUNIORCOL_VALUE = 4;//alias=ר��
    public static final int UNDERGRADUATE_VALUE = 5;//alias=����
    public static final int MASTER_VALUE = 6;//alias=˶ʿ
    public static final int DOCTOR_VALUE = 7;//alias=��ʿ

    public static final EduLvlEnum Primary = new EduLvlEnum("Primary", PRIMARY_VALUE);
    public static final EduLvlEnum Junior = new EduLvlEnum("Junior", JUNIOR_VALUE);
    public static final EduLvlEnum high = new EduLvlEnum("high", HIGH_VALUE);
    public static final EduLvlEnum juniorCol = new EduLvlEnum("juniorCol", JUNIORCOL_VALUE);
    public static final EduLvlEnum Undergraduate = new EduLvlEnum("Undergraduate", UNDERGRADUATE_VALUE);
    public static final EduLvlEnum master = new EduLvlEnum("master", MASTER_VALUE);
    public static final EduLvlEnum doctor = new EduLvlEnum("doctor", DOCTOR_VALUE);

    /**
     * construct function
     * @param integer eduLvlEnum
     */
    private EduLvlEnum(String name, int eduLvlEnum)
    {
        super(name, eduLvlEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EduLvlEnum getEnum(String eduLvlEnum)
    {
        return (EduLvlEnum)getEnum(EduLvlEnum.class, eduLvlEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static EduLvlEnum getEnum(int eduLvlEnum)
    {
        return (EduLvlEnum)getEnum(EduLvlEnum.class, eduLvlEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EduLvlEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EduLvlEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EduLvlEnum.class);
    }
}