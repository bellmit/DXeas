package com.kingdee.eas.farm.carnivorous.basebiz;

import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.dao.IObjectPK;

public class FarmerGuaranteeBillCollection extends AbstractObjectCollection 
{
    public FarmerGuaranteeBillCollection()
    {
        super(FarmerGuaranteeBillInfo.class);
    }
    public boolean add(FarmerGuaranteeBillInfo item)
    {
        return addObject(item);
    }
    public boolean addCollection(FarmerGuaranteeBillCollection item)
    {
        return addObjectCollection(item);
    }
    public boolean remove(FarmerGuaranteeBillInfo item)
    {
        return removeObject(item);
    }
    public FarmerGuaranteeBillInfo get(int index)
    {
        return(FarmerGuaranteeBillInfo)getObject(index);
    }
    public FarmerGuaranteeBillInfo get(Object key)
    {
        return(FarmerGuaranteeBillInfo)getObject(key);
    }
    public void set(int index, FarmerGuaranteeBillInfo item)
    {
        setObject(index, item);
    }
    public boolean contains(FarmerGuaranteeBillInfo item)
    {
        return containsObject(item);
    }
    public boolean contains(Object key)
    {
        return containsKey(key);
    }
    public int indexOf(FarmerGuaranteeBillInfo item)
    {
        return super.indexOf(item);
    }
}