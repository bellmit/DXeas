package com.kingdee.eas.custom.taihe.vehicledetection;

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

public interface IVdChannelSetting extends IDataBase
{
    public VdChannelSettingInfo getVdChannelSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public VdChannelSettingInfo getVdChannelSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public VdChannelSettingInfo getVdChannelSettingInfo(String oql) throws BOSException, EASBizException;
    public VdChannelSettingCollection getVdChannelSettingCollection() throws BOSException;
    public VdChannelSettingCollection getVdChannelSettingCollection(EntityViewInfo view) throws BOSException;
    public VdChannelSettingCollection getVdChannelSettingCollection(String oql) throws BOSException;
}