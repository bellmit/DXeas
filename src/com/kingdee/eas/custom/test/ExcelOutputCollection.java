package com.kingdee.eas.custom.test;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ExcelOutputCollection extends AbstractObjectCollection 
{
    public ExcelOutputCollection()
    {
        super(ExcelOutputInfo.class);
    }
    public boolean add(ExcelOutputInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ExcelOutputCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ExcelOutputInfo item)
    {
        return removeObject(item);
    }
    public ExcelOutputInfo get(int index)
    {
        return(ExcelOutputInfo)getObject(index);
    }
    public ExcelOutputInfo get(Object key)
    {
        return(ExcelOutputInfo)getObject(key);
    }
    public void set(int index, ExcelOutputInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ExcelOutputInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ExcelOutputInfo item)
    {
        return super.indexOf(item);
    }
}