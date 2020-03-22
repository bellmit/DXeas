package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SystemSettingMarginTypeEntryCollection extends AbstractObjectCollection 
{
    public SystemSettingMarginTypeEntryCollection()
    {
        super(SystemSettingMarginTypeEntryInfo.class);
    }
    public boolean add(SystemSettingMarginTypeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SystemSettingMarginTypeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SystemSettingMarginTypeEntryInfo item)
    {
        return removeObject(item);
    }
    public SystemSettingMarginTypeEntryInfo get(int index)
    {
        return(SystemSettingMarginTypeEntryInfo)getObject(index);
    }
    public SystemSettingMarginTypeEntryInfo get(Object key)
    {
        return(SystemSettingMarginTypeEntryInfo)getObject(key);
    }
    public void set(int index, SystemSettingMarginTypeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SystemSettingMarginTypeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SystemSettingMarginTypeEntryInfo item)
    {
        return super.indexOf(item);
    }
}