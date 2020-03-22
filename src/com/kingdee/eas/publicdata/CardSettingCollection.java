package com.kingdee.eas.publicdata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CardSettingCollection extends AbstractObjectCollection 
{
    public CardSettingCollection()
    {
        super(CardSettingInfo.class);
    }
    public boolean add(CardSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CardSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CardSettingInfo item)
    {
        return removeObject(item);
    }
    public CardSettingInfo get(int index)
    {
        return(CardSettingInfo)getObject(index);
    }
    public CardSettingInfo get(Object key)
    {
        return(CardSettingInfo)getObject(key);
    }
    public void set(int index, CardSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CardSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CardSettingInfo item)
    {
        return super.indexOf(item);
    }
}