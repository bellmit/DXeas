package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class InsuranceRegistEntryCollection extends AbstractObjectCollection 
{
    public InsuranceRegistEntryCollection()
    {
        super(InsuranceRegistEntryInfo.class);
    }
    public boolean add(InsuranceRegistEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(InsuranceRegistEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(InsuranceRegistEntryInfo item)
    {
        return removeObject(item);
    }
    public InsuranceRegistEntryInfo get(int index)
    {
        return(InsuranceRegistEntryInfo)getObject(index);
    }
    public InsuranceRegistEntryInfo get(Object key)
    {
        return(InsuranceRegistEntryInfo)getObject(key);
    }
    public void set(int index, InsuranceRegistEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(InsuranceRegistEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(InsuranceRegistEntryInfo item)
    {
        return super.indexOf(item);
    }
}