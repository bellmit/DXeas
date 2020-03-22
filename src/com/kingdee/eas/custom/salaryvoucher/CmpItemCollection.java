package com.kingdee.eas.custom.salaryvoucher;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CmpItemCollection extends AbstractObjectCollection 
{
    public CmpItemCollection()
    {
        super(CmpItemInfo.class);
    }
    public boolean add(CmpItemInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CmpItemCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CmpItemInfo item)
    {
        return removeObject(item);
    }
    public CmpItemInfo get(int index)
    {
        return(CmpItemInfo)getObject(index);
    }
    public CmpItemInfo get(Object key)
    {
        return(CmpItemInfo)getObject(key);
    }
    public void set(int index, CmpItemInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CmpItemInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CmpItemInfo item)
    {
        return super.indexOf(item);
    }
}