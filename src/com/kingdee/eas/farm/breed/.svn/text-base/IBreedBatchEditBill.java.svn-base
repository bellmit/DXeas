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

public interface IBreedBatchEditBill extends ICoreBillBase
{
    public BreedBatchEditBillCollection getBreedBatchEditBillCollection() throws BOSException;
    public BreedBatchEditBillCollection getBreedBatchEditBillCollection(EntityViewInfo view) throws BOSException;
    public BreedBatchEditBillCollection getBreedBatchEditBillCollection(String oql) throws BOSException;
    public BreedBatchEditBillInfo getBreedBatchEditBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedBatchEditBillInfo getBreedBatchEditBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedBatchEditBillInfo getBreedBatchEditBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BreedBatchEditBillInfo model) throws BOSException;
    public void unAudit(BreedBatchEditBillInfo model) throws BOSException;
}