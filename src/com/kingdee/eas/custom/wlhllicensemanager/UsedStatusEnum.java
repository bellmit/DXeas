/**
 * output package name
 */
package com.kingdee.eas.custom.wlhllicensemanager;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.IntEnum;

/**
 * output class name
 */
public class UsedStatusEnum extends IntEnum
{
    public static final int ADDNEW_VALUE = 0;//alias=����
    public static final int UNAPPROVE_VALUE = 1;//alias=δ��׼
    public static final int APPROVED_VALUE = 2;//alias=��׼
    public static final int FREEZED_VALUE = 3;//alias=����
    public static final int ENABLED_VALUE = 4;//alias=����
    public static final int DELETED_VALUE = -1;//alias=��ɾ��

    public static final UsedStatusEnum ADDNEW = new UsedStatusEnum("ADDNEW", ADDNEW_VALUE);
    public static final UsedStatusEnum UNAPPROVE = new UsedStatusEnum("UNAPPROVE", UNAPPROVE_VALUE);
    public static final UsedStatusEnum APPROVED = new UsedStatusEnum("APPROVED", APPROVED_VALUE);
    public static final UsedStatusEnum FREEZED = new UsedStatusEnum("FREEZED", FREEZED_VALUE);
    public static final UsedStatusEnum ENABLED = new UsedStatusEnum("ENABLED", ENABLED_VALUE);
    public static final UsedStatusEnum DELETED = new UsedStatusEnum("DELETED", DELETED_VALUE);

    /**
     * construct function
     * @param integer usedStatusEnum
     */
    private UsedStatusEnum(String name, int usedStatusEnum)
    {
        super(name, usedStatusEnum);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static UsedStatusEnum getEnum(String usedStatusEnum)
    {
        return (UsedStatusEnum)getEnum(UsedStatusEnum.class, usedStatusEnum);
    }

    /**
     * getEnum function
     * @param String arguments
     */
    public static UsedStatusEnum getEnum(int usedStatusEnum)
    {
        return (UsedStatusEnum)getEnum(UsedStatusEnum.class, usedStatusEnum);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(UsedStatusEnum.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(UsedStatusEnum.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(UsedStatusEnum.class);
    }
}