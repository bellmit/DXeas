package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggReceiveBillEntryPickDetailCollection extends AbstractObjectCollection 
{
    public EggReceiveBillEntryPickDetailCollection()
    {
        super(EggReceiveBillEntryPickDetailInfo.class);
    }
    public boolean add(EggReceiveBillEntryPickDetailInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggReceiveBillEntryPickDetailCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggReceiveBillEntryPickDetailInfo item)
    {
        return removeObject(item);
    }
    public EggReceiveBillEntryPickDetailInfo get(int index)
    {
        return(EggReceiveBillEntryPickDetailInfo)getObject(index);
    }
    public EggReceiveBillEntryPickDetailInfo get(Object key)
    {
        return(EggReceiveBillEntryPickDetailInfo)getObject(key);
    }
    public void set(int index, EggReceiveBillEntryPickDetailInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggReceiveBillEntryPickDetailInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggReceiveBillEntryPickDetailInfo item)
    {
        return super.indexOf(item);
    }
}