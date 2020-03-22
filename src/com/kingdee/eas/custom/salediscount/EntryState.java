/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount;

import java.util.Map;
import java.util.List;
import java.util.Iterator;
import com.kingdee.util.enums.StringEnum;

/**
 * output class name
 */
public class EntryState extends StringEnum
{
    public static final String UNLOCKED_VALUE = "1";//alias=∆Ù”√
    public static final String LOCKED_VALUE = "2";//alias=Ω˚”√

    public static final EntryState UnLocked = new EntryState("UnLocked", UNLOCKED_VALUE);
    public static final EntryState Locked = new EntryState("Locked", LOCKED_VALUE);

    /**
     * construct function
     * @param String entryState
     */
    private EntryState(String name, String entryState)
    {
        super(name, entryState);
    }
    
    /**
     * getEnum function
     * @param String arguments
     */
    public static EntryState getEnum(String entryState)
    {
        return (EntryState)getEnum(EntryState.class, entryState);
    }

    /**
     * getEnumMap function
     */
    public static Map getEnumMap()
    {
        return getEnumMap(EntryState.class);
    }

    /**
     * getEnumList function
     */
    public static List getEnumList()
    {
         return getEnumList(EntryState.class);
    }
    
    /**
     * getIterator function
     */
    public static Iterator iterator()
    {
         return iterator(EntryState.class);
    }
}