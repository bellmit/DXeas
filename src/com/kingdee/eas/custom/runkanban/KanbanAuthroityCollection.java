package com.kingdee.eas.custom.runkanban;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class KanbanAuthroityCollection extends AbstractObjectCollection 
{
    public KanbanAuthroityCollection()
    {
        super(KanbanAuthroityInfo.class);
    }
    public boolean add(KanbanAuthroityInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(KanbanAuthroityCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(KanbanAuthroityInfo item)
    {
        return removeObject(item);
    }
    public KanbanAuthroityInfo get(int index)
    {
        return(KanbanAuthroityInfo)getObject(index);
    }
    public KanbanAuthroityInfo get(Object key)
    {
        return(KanbanAuthroityInfo)getObject(key);
    }
    public void set(int index, KanbanAuthroityInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(KanbanAuthroityInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(KanbanAuthroityInfo item)
    {
        return super.indexOf(item);
    }
}