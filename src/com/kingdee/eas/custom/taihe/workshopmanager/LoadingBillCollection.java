package com.kingdee.eas.custom.taihe.workshopmanager;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LoadingBillCollection extends AbstractObjectCollection 
{
    public LoadingBillCollection()
    {
        super(LoadingBillInfo.class);
    }
    public boolean add(LoadingBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LoadingBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LoadingBillInfo item)
    {
        return removeObject(item);
    }
    public LoadingBillInfo get(int index)
    {
        return(LoadingBillInfo)getObject(index);
    }
    public LoadingBillInfo get(Object key)
    {
        return(LoadingBillInfo)getObject(key);
    }
    public void set(int index, LoadingBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LoadingBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LoadingBillInfo item)
    {
        return super.indexOf(item);
    }
}