package com.kingdee.eas.custom.wages;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class PostSubsidyEntryCollection extends AbstractObjectCollection 
{
    public PostSubsidyEntryCollection()
    {
        super(PostSubsidyEntryInfo.class);
    }
    public boolean add(PostSubsidyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(PostSubsidyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(PostSubsidyEntryInfo item)
    {
        return removeObject(item);
    }
    public PostSubsidyEntryInfo get(int index)
    {
        return(PostSubsidyEntryInfo)getObject(index);
    }
    public PostSubsidyEntryInfo get(Object key)
    {
        return(PostSubsidyEntryInfo)getObject(key);
    }
    public void set(int index, PostSubsidyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(PostSubsidyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(PostSubsidyEntryInfo item)
    {
        return super.indexOf(item);
    }
}