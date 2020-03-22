package com.kingdee.eas.message;

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

public interface IBaseSetting extends IDataBase
{
    public BaseSettingInfo getBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BaseSettingInfo getBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BaseSettingInfo getBaseSettingInfo(String oql) throws BOSException, EASBizException;
    public BaseSettingCollection getBaseSettingCollection() throws BOSException;
    public BaseSettingCollection getBaseSettingCollection(EntityViewInfo view) throws BOSException;
    public BaseSettingCollection getBaseSettingCollection(String oql) throws BOSException;
}