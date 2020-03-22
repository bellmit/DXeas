package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SocialwelfareEntryCollection extends AbstractObjectCollection 
{
    public SocialwelfareEntryCollection()
    {
        super(SocialwelfareEntryInfo.class);
    }
    public boolean add(SocialwelfareEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SocialwelfareEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SocialwelfareEntryInfo item)
    {
        return removeObject(item);
    }
    public SocialwelfareEntryInfo get(int index)
    {
        return(SocialwelfareEntryInfo)getObject(index);
    }
    public SocialwelfareEntryInfo get(Object key)
    {
        return(SocialwelfareEntryInfo)getObject(key);
    }
    public void set(int index, SocialwelfareEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SocialwelfareEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SocialwelfareEntryInfo item)
    {
        return super.indexOf(item);
    }
}