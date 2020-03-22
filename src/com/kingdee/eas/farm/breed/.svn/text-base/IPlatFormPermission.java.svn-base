package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IPlatFormPermission extends ICoreBillBase
{
    public PlatFormPermissionCollection getPlatFormPermissionCollection() throws BOSException;
    public PlatFormPermissionCollection getPlatFormPermissionCollection(EntityViewInfo view) throws BOSException;
    public PlatFormPermissionCollection getPlatFormPermissionCollection(String oql) throws BOSException;
    public PlatFormPermissionInfo getPlatFormPermissionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PlatFormPermissionInfo getPlatFormPermissionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PlatFormPermissionInfo getPlatFormPermissionInfo(String oql) throws BOSException, EASBizException;
    public void layEggPlanPer(PlatFormPermissionInfo model) throws BOSException;
    public void hatchPlanPer(PlatFormPermissionInfo model) throws BOSException;
    public void cCBreedPlanPer(PlatFormPermissionInfo model) throws BOSException;
    public void slaughterPlanPer(PlatFormPermissionInfo model) throws BOSException;
}