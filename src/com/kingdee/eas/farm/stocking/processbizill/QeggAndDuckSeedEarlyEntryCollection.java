package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class QeggAndDuckSeedEarlyEntryCollection extends AbstractObjectCollection 
{
    public QeggAndDuckSeedEarlyEntryCollection()
    {
        super(QeggAndDuckSeedEarlyEntryInfo.class);
    }
    public boolean add(QeggAndDuckSeedEarlyEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(QeggAndDuckSeedEarlyEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(QeggAndDuckSeedEarlyEntryInfo item)
    {
        return removeObject(item);
    }
    public QeggAndDuckSeedEarlyEntryInfo get(int index)
    {
        return(QeggAndDuckSeedEarlyEntryInfo)getObject(index);
    }
    public QeggAndDuckSeedEarlyEntryInfo get(Object key)
    {
        return(QeggAndDuckSeedEarlyEntryInfo)getObject(key);
    }
    public void set(int index, QeggAndDuckSeedEarlyEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(QeggAndDuckSeedEarlyEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(QeggAndDuckSeedEarlyEntryInfo item)
    {
        return super.indexOf(item);
    }
}