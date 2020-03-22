package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class DataBaseSettingTreeCollection extends AbstractObjectCollection 
{
    public DataBaseSettingTreeCollection()
    {
        super(DataBaseSettingTreeInfo.class);
    }
    public boolean add(DataBaseSettingTreeInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(DataBaseSettingTreeCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(DataBaseSettingTreeInfo item)
    {
        return removeObject(item);
    }
    public DataBaseSettingTreeInfo get(int index)
    {
        return(DataBaseSettingTreeInfo)getObject(index);
    }
    public DataBaseSettingTreeInfo get(Object key)
    {
        return(DataBaseSettingTreeInfo)getObject(key);
    }
    public void set(int index, DataBaseSettingTreeInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(DataBaseSettingTreeInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(DataBaseSettingTreeInfo item)
    {
        return super.indexOf(item);
    }
}