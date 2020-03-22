package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class TheLifeFeeOfFemaleDuckEntryCollection extends AbstractObjectCollection 
{
    public TheLifeFeeOfFemaleDuckEntryCollection()
    {
        super(TheLifeFeeOfFemaleDuckEntryInfo.class);
    }
    public boolean add(TheLifeFeeOfFemaleDuckEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(TheLifeFeeOfFemaleDuckEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(TheLifeFeeOfFemaleDuckEntryInfo item)
    {
        return removeObject(item);
    }
    public TheLifeFeeOfFemaleDuckEntryInfo get(int index)
    {
        return(TheLifeFeeOfFemaleDuckEntryInfo)getObject(index);
    }
    public TheLifeFeeOfFemaleDuckEntryInfo get(Object key)
    {
        return(TheLifeFeeOfFemaleDuckEntryInfo)getObject(key);
    }
    public void set(int index, TheLifeFeeOfFemaleDuckEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(TheLifeFeeOfFemaleDuckEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(TheLifeFeeOfFemaleDuckEntryInfo item)
    {
        return super.indexOf(item);
    }
}