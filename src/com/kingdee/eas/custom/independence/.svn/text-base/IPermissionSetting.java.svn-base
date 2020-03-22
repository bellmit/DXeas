package com.kingdee.eas.custom.independence;

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

public interface IPermissionSetting extends IDataBase
{
    public PermissionSettingInfo getPermissionSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PermissionSettingInfo getPermissionSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PermissionSettingInfo getPermissionSettingInfo(String oql) throws BOSException, EASBizException;
    public PermissionSettingCollection getPermissionSettingCollection() throws BOSException;
    public PermissionSettingCollection getPermissionSettingCollection(EntityViewInfo view) throws BOSException;
    public PermissionSettingCollection getPermissionSettingCollection(String oql) throws BOSException;
    public void purOrderUpdateTax(PermissionSettingInfo model) throws BOSException;
    public void purOrderCheck(PermissionSettingInfo model) throws BOSException;
    public void purOrderUnCheck(PermissionSettingInfo model) throws BOSException;
}