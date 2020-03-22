package com.kingdee.eas.WSInterface.common;

import com.kingdee.bos.framework.cache.CustomCacheService;

public class DataInfoCache
{

    public DataInfoCache()
    {
        ws_custCache = null;
    }

    public static DataInfoCache getInstance()
    {
        if(dataInfoCache == null)
            synchronized(com.kingdee.eas.WSInterface.common.DataInfoCache.class)
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
        ws_custCache = new CustomCacheService("SCM.WebService");
    }

    public void put(String key, Object data)
    {
        ws_custCache.put(key, data);
    }

    public Object get(String key)
    {
        return ws_custCache.get(key);
    }

    public boolean containsKey(String key)
    {
        return ws_custCache.contains(key);
    }

    private CustomCacheService ws_custCache;
    private static DataInfoCache dataInfoCache = null;

}
