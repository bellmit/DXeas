package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class StateOfAcaountImportCollection extends AbstractObjectCollection 
{
    public StateOfAcaountImportCollection()
    {
        super(StateOfAcaountImportInfo.class);
    }
    public boolean add(StateOfAcaountImportInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(StateOfAcaountImportCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(StateOfAcaountImportInfo item)
    {
        return removeObject(item);
    }
    public StateOfAcaountImportInfo get(int index)
    {
        return(StateOfAcaountImportInfo)getObject(index);
    }
    public StateOfAcaountImportInfo get(Object key)
    {
        return(StateOfAcaountImportInfo)getObject(key);
    }
    public void set(int index, StateOfAcaountImportInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(StateOfAcaountImportInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(StateOfAcaountImportInfo item)
    {
        return super.indexOf(item);
    }
}