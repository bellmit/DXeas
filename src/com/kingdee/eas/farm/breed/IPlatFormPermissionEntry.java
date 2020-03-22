package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
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

public interface IPlatFormPermissionEntry extends ICoreBillEntryBase
{
    public PlatFormPermissionEntryInfo getPlatFormPermissionEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PlatFormPermissionEntryInfo getPlatFormPermissionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PlatFormPermissionEntryInfo getPlatFormPermissionEntryInfo(String oql) throws BOSException, EASBizException;
    public PlatFormPermissionEntryCollection getPlatFormPermissionEntryCollection() throws BOSException;
    public PlatFormPermissionEntryCollection getPlatFormPermissionEntryCollection(EntityViewInfo view) throws BOSException;
    public PlatFormPermissionEntryCollection getPlatFormPermissionEntryCollection(String oql) throws BOSException;
}