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
public class QcEggTypeEnum extends IntEnum
{
    public static final int QCEGG_VALUE = 101;//alias=�ϸ��ֵ�
    public static final int SMALLQCEGG_VALUE = 102;//alias=С�ϸ�
    public static final int REDOEGG_VALUE = 103;//alias=��ѡ��

    public static final QcEggTypeEnum qcEgg = new QcEggTypeEnum("qcEgg", QCEGG_VALUE);
    public static final QcEggTypeEnum smallQcEgg = new QcEggTypeEnum("smallQcEgg", SMALLQCEGG_VALUE);
    public static final QcEggTypeEnum redoEgg = new QcEggTypeEnum("redoEgg", REDOEGG_VALUE);

    /**
     * construct function
     * @param integer qcEggTypeEnum
     */
    private QcEggTypeEnum(String name, int qcEggTypeEnum)
    {
        super(name, qcEggTypeEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static QcEggTypeEnum getEnum(String qcEggTypeEnum)
    {
        return (QcEggTypeEnum)getEnum(QcEggTypeEnum.class, qcEggTypeEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static QcEggTypeEnum getEnum(int qcEggTypeEnum)
    {
        return (QcEggTypeEnum)getEnum(QcEggTypeEnum.class, qcEggTypeEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(QcEggTypeEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(QcEggTypeEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(QcEggTypeEnum.class);
    }
}