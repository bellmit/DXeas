package com.kingdee.eas.bdm.bdapply;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class MaterialInfoReqMaterialStdEntryCollection extends AbstractObjectCollection 
{
    public MaterialInfoReqMaterialStdEntryCollection()
    {
        super(MaterialInfoReqMaterialStdEntryInfo.class);
    }
    public boolean add(MaterialInfoReqMaterialStdEntryInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(MaterialInfoReqMaterialStdEntryCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(MaterialInfoReqMaterialStdEntryInfo item)
    {
        return removeObject(item);
    }
    public MaterialInfoReqMaterialStdEntryInfo get(int index)
    {
        return(MaterialInfoReqMaterialStdEntryInfo)getObject(index);
    }
    public MaterialInfoReqMaterialStdEntryInfo get(Object key)
    {
        return(MaterialInfoReqMaterialStdEntryInfo)getObject(key);
    }
    public void set(int index, MaterialInfoReqMaterialStdEntryInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(MaterialInfoReqMaterialStdEntryInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(MaterialInfoReqMaterialStdEntryInfo item)
    {
        return super.indexOf(item);
    }
}