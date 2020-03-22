package com.kingdee.eas.farm.stocking.basedata;

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

public interface IBaseSysSetting extends IDataBase
{
    public BaseSysSettingInfo getBaseSysSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BaseSysSettingInfo getBaseSysSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BaseSysSettingInfo getBaseSysSettingInfo(String oql) throws BOSException, EASBizException;
    public BaseSysSettingCollection getBaseSysSettingCollection() throws BOSException;
    public BaseSysSettingCollection getBaseSysSettingCollection(EntityViewInfo view) throws BOSException;
    public BaseSysSettingCollection getBaseSysSettingCollection(String oql) throws BOSException;
}