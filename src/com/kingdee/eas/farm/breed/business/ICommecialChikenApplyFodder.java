package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface ICommecialChikenApplyFodder extends ICoreBillBase
{
    public CommecialChikenApplyFodderCollection getCommecialChikenApplyFodderCollection() throws BOSException;
    public CommecialChikenApplyFodderCollection getCommecialChikenApplyFodderCollection(EntityViewInfo view) throws BOSException;
    public CommecialChikenApplyFodderCollection getCommecialChikenApplyFodderCollection(String oql) throws BOSException;
    public CommecialChikenApplyFodderInfo getCommecialChikenApplyFodderInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CommecialChikenApplyFodderInfo getCommecialChikenApplyFodderInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CommecialChikenApplyFodderInfo getCommecialChikenApplyFodderInfo(String oql) throws BOSException, EASBizException;
    public void audit(CommecialChikenApplyFodderInfo model) throws BOSException;
    public void unAudit(CommecialChikenApplyFodderInfo model) throws BOSException;
    public List genNextBill(CommecialChikenApplyFodderInfo model) throws BOSException;
}