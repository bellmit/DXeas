package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BillDeafultSettingCollection extends AbstractObjectCollection 
{
    public BillDeafultSettingCollection()
    {
        super(BillDeafultSettingInfo.class);
    }
    public boolean add(BillDeafultSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BillDeafultSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BillDeafultSettingInfo item)
    {
        return removeObject(item);
    }
    public BillDeafultSettingInfo get(int index)
    {
        return(BillDeafultSettingInfo)getObject(index);
    }
    public BillDeafultSettingInfo get(Object key)
    {
        return(BillDeafultSettingInfo)getObject(key);
    }
    public void set(int index, BillDeafultSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BillDeafultSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BillDeafultSettingInfo item)
    {
        return super.indexOf(item);
    }
}