package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class SzCountPositionSetMaterialEntryCollection extends AbstractObjectCollection 
{
    public SzCountPositionSetMaterialEntryCollection()
    {
        super(SzCountPositionSetMaterialEntryInfo.class);
    }
    public boolean add(SzCountPositionSetMaterialEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(SzCountPositionSetMaterialEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(SzCountPositionSetMaterialEntryInfo item)
    {
        return removeObject(item);
    }
    public SzCountPositionSetMaterialEntryInfo get(int index)
    {
        return(SzCountPositionSetMaterialEntryInfo)getObject(index);
    }
    public SzCountPositionSetMaterialEntryInfo get(Object key)
    {
        return(SzCountPositionSetMaterialEntryInfo)getObject(key);
    }
    public void set(int index, SzCountPositionSetMaterialEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(SzCountPositionSetMaterialEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(SzCountPositionSetMaterialEntryInfo item)
    {
        return super.indexOf(item);
    }
}