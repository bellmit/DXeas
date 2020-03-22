package com.kingdee.eas.farm.carnivorous.recyclebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class LiveBirdWgtBillCollection extends AbstractObjectCollection 
{
    public LiveBirdWgtBillCollection()
    {
        super(LiveBirdWgtBillInfo.class);
    }
    public boolean add(LiveBirdWgtBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(LiveBirdWgtBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(LiveBirdWgtBillInfo item)
    {
        return removeObject(item);
    }
    public LiveBirdWgtBillInfo get(int index)
    {
        return(LiveBirdWgtBillInfo)getObject(index);
    }
    public LiveBirdWgtBillInfo get(Object key)
    {
        return(LiveBirdWgtBillInfo)getObject(key);
    }
    public void set(int index, LiveBirdWgtBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(LiveBirdWgtBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(LiveBirdWgtBillInfo item)
    {
        return super.indexOf(item);
    }
}