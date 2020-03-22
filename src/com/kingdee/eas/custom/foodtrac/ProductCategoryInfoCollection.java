package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class ProductCategoryInfoCollection extends AbstractObjectCollection 
{
    public ProductCategoryInfoCollection()
    {
        super(ProductCategoryInfoInfo.class);
    }
    public boolean add(ProductCategoryInfoInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(ProductCategoryInfoCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(ProductCategoryInfoInfo item)
    {
        return removeObject(item);
    }
    public ProductCategoryInfoInfo get(int index)
    {
        return(ProductCategoryInfoInfo)getObject(index);
    }
    public ProductCategoryInfoInfo get(Object key)
    {
        return(ProductCategoryInfoInfo)getObject(key);
    }
    public void set(int index, ProductCategoryInfoInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(ProductCategoryInfoInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(ProductCategoryInfoInfo item)
    {
        return super.indexOf(item);
    }
}