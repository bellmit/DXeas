package com.kingdee.eas.farm.stocking.assistfunction;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class EggReceiveBillColorSettingCollection extends AbstractObjectCollection 
{
    public EggReceiveBillColorSettingCollection()
    {
        super(EggReceiveBillColorSettingInfo.class);
    }
    public boolean add(EggReceiveBillColorSettingInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(EggReceiveBillColorSettingCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(EggReceiveBillColorSettingInfo item)
    {
        return removeObject(item);
    }
    public EggReceiveBillColorSettingInfo get(int index)
    {
        return(EggReceiveBillColorSettingInfo)getObject(index);
    }
    public EggReceiveBillColorSettingInfo get(Object key)
    {
        return(EggReceiveBillColorSettingInfo)getObject(key);
    }
    public void set(int index, EggReceiveBillColorSettingInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(EggReceiveBillColorSettingInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(EggReceiveBillColorSettingInfo item)
    {
        return super.indexOf(item);
    }
}