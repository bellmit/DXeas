package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDeviceDataTree extends ITreeBase
{
    public DeviceDataTreeInfo getDeviceDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DeviceDataTreeInfo getDeviceDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DeviceDataTreeInfo getDeviceDataTreeInfo(String oql) throws BOSException, EASBizException;
    public DeviceDataTreeCollection getDeviceDataTreeCollection() throws BOSException;
    public DeviceDataTreeCollection getDeviceDataTreeCollection(EntityViewInfo view) throws BOSException;
    public DeviceDataTreeCollection getDeviceDataTreeCollection(String oql) throws BOSException;
}