package com.kingdee.eas.custom.salepayment;

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

public interface IAreaTarget extends IDataBase
{
    public AreaTargetInfo getAreaTargetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AreaTargetInfo getAreaTargetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AreaTargetInfo getAreaTargetInfo(String oql) throws BOSException, EASBizException;
    public AreaTargetCollection getAreaTargetCollection() throws BOSException;
    public AreaTargetCollection getAreaTargetCollection(EntityViewInfo view) throws BOSException;
    public AreaTargetCollection getAreaTargetCollection(String oql) throws BOSException;
    public void audit(AreaTargetInfo model) throws BOSException;
    public void unAudit(AreaTargetInfo model) throws BOSException;
}