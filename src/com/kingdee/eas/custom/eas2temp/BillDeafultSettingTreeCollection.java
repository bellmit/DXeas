package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class BillDeafultSettingTreeCollection extends AbstractObjectCollection 
{
    public BillDeafultSettingTreeCollection()
    {
        super(BillDeafultSettingTreeInfo.class);
    }
    public boolean add(BillDeafultSettingTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(BillDeafultSettingTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(BillDeafultSettingTreeInfo item)
    {
        return removeObject(item);
    }
    public BillDeafultSettingTreeInfo get(int index)
    {
        return(BillDeafultSettingTreeInfo)getObject(index);
    }
    public BillDeafultSettingTreeInfo get(Object key)
    {
        return(BillDeafultSettingTreeInfo)getObject(key);
    }
    public void set(int index, BillDeafultSettingTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(BillDeafultSettingTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(BillDeafultSettingTreeInfo item)
    {
        return super.indexOf(item);
    }
}