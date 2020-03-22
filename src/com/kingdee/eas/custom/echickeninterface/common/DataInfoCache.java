package com.kingdee.eas.custom.echickeninterface.common;

import com.kingdee.bos.framework.cache.CustomCacheService;

public class DataInfoCache
{

    public DataInfoCache()
    {
        mst_custCache = null;
    }

    public static DataInfoCache getInstance()
    {
        if(dataInfoCache == null)
            synchronized(com.kingdee.eas.custom.echickeninterface.common.DataInfoCache.class)
            {
                if(dataInfoCache == null)
                {
                    dataInfoCache = new DataInfoCache();
                    dataInfoCache.initMap();
                }
            }
        return dataInfoCache;
    }

    private void initMap()
    {
        mst_custCache = new CustomCacheService("SCM.WebService");
    }

    public void put(String key, Object data)
    {
        mst_custCache.put(key, data);
    }

    public Object get(String key)
    {
        return mst_custCache.get(key);
    }

    public boolean containsKey(String key)
    {
        return mst_custCache.contains(key);
    }

    private CustomCacheService mst_custCache;
    private static DataInfoCache dataInfoCache = null;

}
