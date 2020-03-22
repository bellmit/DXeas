package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class CoproductBillEntryCollection extends AbstractObjectCollection 
{
    public CoproductBillEntryCollection()
    {
        super(CoproductBillEntryInfo.class);
    }
    public boolean add(CoproductBillEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(CoproductBillEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(CoproductBillEntryInfo item)
    {
        return removeObject(item);
    }
    public CoproductBillEntryInfo get(int index)
    {
        return(CoproductBillEntryInfo)getObject(index);
    }
    public CoproductBillEntryInfo get(Object key)
    {
        return(CoproductBillEntryInfo)getObject(key);
    }
    public void set(int index, CoproductBillEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(CoproductBillEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(CoproductBillEntryInfo item)
    {
        return super.indexOf(item);
    }
}