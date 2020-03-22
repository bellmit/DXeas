package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CKDressingPercentCollection extends AbstractObjectCollection 
{
    public CKDressingPercentCollection()
    {
        super(CKDressingPercentInfo.class);
    }
    public boolean add(CKDressingPercentInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CKDressingPercentCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CKDressingPercentInfo item)
    {
        return removeObject(item);
    }
    public CKDressingPercentInfo get(int index)
    {
        return(CKDressingPercentInfo)getObject(index);
    }
    public CKDressingPercentInfo get(Object key)
    {
        return(CKDressingPercentInfo)getObject(key);
    }
    public void set(int index, CKDressingPercentInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CKDressingPercentInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CKDressingPercentInfo item)
    {
        return super.indexOf(item);
    }
}