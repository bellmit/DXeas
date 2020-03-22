package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TheLifeFeeOfFemaleDuckCollection extends AbstractObjectCollection 
{
    public TheLifeFeeOfFemaleDuckCollection()
    {
        super(TheLifeFeeOfFemaleDuckInfo.class);
    }
    public boolean add(TheLifeFeeOfFemaleDuckInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TheLifeFeeOfFemaleDuckCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TheLifeFeeOfFemaleDuckInfo item)
    {
        return removeObject(item);
    }
    public TheLifeFeeOfFemaleDuckInfo get(int index)
    {
        return(TheLifeFeeOfFemaleDuckInfo)getObject(index);
    }
    public TheLifeFeeOfFemaleDuckInfo get(Object key)
    {
        return(TheLifeFeeOfFemaleDuckInfo)getObject(key);
    }
    public void set(int index, TheLifeFeeOfFemaleDuckInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TheLifeFeeOfFemaleDuckInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TheLifeFeeOfFemaleDuckInfo item)
    {
        return super.indexOf(item);
    }
}