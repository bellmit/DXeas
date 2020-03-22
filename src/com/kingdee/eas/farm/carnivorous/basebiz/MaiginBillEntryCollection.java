package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaiginBillEntryCollection extends AbstractObjectCollection 
{
    public MaiginBillEntryCollection()
    {
        super(MaiginBillEntryInfo.class);
    }
    public boolean add(MaiginBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaiginBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaiginBillEntryInfo item)
    {
        return removeObject(item);
    }
    public MaiginBillEntryInfo get(int index)
    {
        return(MaiginBillEntryInfo)getObject(index);
    }
    public MaiginBillEntryInfo get(Object key)
    {
        return(MaiginBillEntryInfo)getObject(key);
    }
    public void set(int index, MaiginBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaiginBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaiginBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}