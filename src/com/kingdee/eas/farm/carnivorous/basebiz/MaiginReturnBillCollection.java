package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaiginReturnBillCollection extends AbstractObjectCollection 
{
    public MaiginReturnBillCollection()
    {
        super(MaiginReturnBillInfo.class);
    }
    public boolean add(MaiginReturnBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaiginReturnBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaiginReturnBillInfo item)
    {
        return removeObject(item);
    }
    public MaiginReturnBillInfo get(int index)
    {
        return(MaiginReturnBillInfo)getObject(index);
    }
    public MaiginReturnBillInfo get(Object key)
    {
        return(MaiginReturnBillInfo)getObject(key);
    }
    public void set(int index, MaiginReturnBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaiginReturnBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaiginReturnBillInfo item)
    {
        return super.indexOf(item);
    }
}