package com.kingdee.eas.weighbridge;

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

public interface ISetting extends IDataBase
{
    public SettingInfo getSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettingInfo getSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettingInfo getSettingInfo(String oql) throws BOSException, EASBizException;
    public SettingCollection getSettingCollection() throws BOSException;
    public SettingCollection getSettingCollection(EntityViewInfo view) throws BOSException;
    public SettingCollection getSettingCollection(String oql) throws BOSException;
}