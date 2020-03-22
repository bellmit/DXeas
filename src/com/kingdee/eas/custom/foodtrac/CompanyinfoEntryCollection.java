package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CompanyinfoEntryCollection extends AbstractObjectCollection 
{
    public CompanyinfoEntryCollection()
    {
        super(CompanyinfoEntryInfo.class);
    }
    public boolean add(CompanyinfoEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CompanyinfoEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CompanyinfoEntryInfo item)
    {
        return removeObject(item);
    }
    public CompanyinfoEntryInfo get(int index)
    {
        return(CompanyinfoEntryInfo)getObject(index);
    }
    public CompanyinfoEntryInfo get(Object key)
    {
        return(CompanyinfoEntryInfo)getObject(key);
    }
    public void set(int index, CompanyinfoEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CompanyinfoEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CompanyinfoEntryInfo item)
    {
        return super.indexOf(item);
    }
}