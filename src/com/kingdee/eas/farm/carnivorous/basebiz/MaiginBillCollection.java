package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaiginBillCollection extends AbstractObjectCollection 
{
    public MaiginBillCollection()
    {
        super(MaiginBillInfo.class);
    }
    public boolean add(MaiginBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaiginBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaiginBillInfo item)
    {
        return removeObject(item);
    }
    public MaiginBillInfo get(int index)
    {
        return(MaiginBillInfo)getObject(index);
    }
    public MaiginBillInfo get(Object key)
    {
        return(MaiginBillInfo)getObject(key);
    }
    public void set(int index, MaiginBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaiginBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaiginBillInfo item)
    {
        return super.indexOf(item);
    }
}