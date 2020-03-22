package com.kingdee.eas.publicdata;

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

public interface IDatabaseSetting extends IDataBase
{
    public DatabaseSettingInfo getDatabaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DatabaseSettingInfo getDatabaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DatabaseSettingInfo getDatabaseSettingInfo(String oql) throws BOSException, EASBizException;
    public DatabaseSettingCollection getDatabaseSettingCollection() throws BOSException;
    public DatabaseSettingCollection getDatabaseSettingCollection(EntityViewInfo view) throws BOSException;
    public DatabaseSettingCollection getDatabaseSettingCollection(String oql) throws BOSException;
}