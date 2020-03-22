package com.kingdee.eas.custom.erp2tax;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaterialTaxCodeEntryCollection extends AbstractObjectCollection 
{
    public MaterialTaxCodeEntryCollection()
    {
        super(MaterialTaxCodeEntryInfo.class);
    }
    public boolean add(MaterialTaxCodeEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaterialTaxCodeEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaterialTaxCodeEntryInfo item)
    {
        return removeObject(item);
    }
    public MaterialTaxCodeEntryInfo get(int index)
    {
        return(MaterialTaxCodeEntryInfo)getObject(index);
    }
    public MaterialTaxCodeEntryInfo get(Object key)
    {
        return(MaterialTaxCodeEntryInfo)getObject(key);
    }
    public void set(int index, MaterialTaxCodeEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaterialTaxCodeEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaterialTaxCodeEntryInfo item)
    {
        return super.indexOf(item);
    }
}