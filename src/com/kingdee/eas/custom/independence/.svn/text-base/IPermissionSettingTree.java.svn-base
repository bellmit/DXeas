package com.kingdee.eas.custom.independence;

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

public interface IPermissionSettingTree extends ITreeBase
{
    public PermissionSettingTreeInfo getPermissionSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PermissionSettingTreeInfo getPermissionSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PermissionSettingTreeInfo getPermissionSettingTreeInfo(String oql) throws BOSException, EASBizException;
    public PermissionSettingTreeCollection getPermissionSettingTreeCollection() throws BOSException;
    public PermissionSettingTreeCollection getPermissionSettingTreeCollection(EntityViewInfo view) throws BOSException;
    public PermissionSettingTreeCollection getPermissionSettingTreeCollection(String oql) throws BOSException;
}