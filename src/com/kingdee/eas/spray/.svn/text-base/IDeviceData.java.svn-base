package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDeviceData extends IDataBase
{
    public DeviceDataInfo getDeviceDataInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DeviceDataInfo getDeviceDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DeviceDataInfo getDeviceDataInfo(String oql) throws BOSException, EASBizException;
    public DeviceDataCollection getDeviceDataCollection() throws BOSException;
    public DeviceDataCollection getDeviceDataCollection(EntityViewInfo view) throws BOSException;
    public DeviceDataCollection getDeviceDataCollection(String oql) throws BOSException;
}