/**
 * output package name
 */
package com.kingdee.eas.custom.signwasthetable;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class ContactsType extends StringEnum
{
    public static final String SUPPLIER_VALUE = "1";//alias=供应商
    public static final String CUSTOMER_VALUE = "2";//alias=客户

    public static final ContactsType supplier = new ContactsType("supplier", SUPPLIER_VALUE);
    public static final ContactsType customer = new ContactsType("customer", CUSTOMER_VALUE);

    /**
     * construct function
     * @param String contactsType
     */
    private ContactsType(String name, String contactsType)
    {
        super(name, contactsType);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static ContactsType getEnum(String contactsType)
    {
        return (ContactsType)getEnum(ContactsType.class, contactsType);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(ContactsType.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(ContactsType.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(ContactsType.class);
    }
}