package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IBatchBreedApplyBill extends ICoreBillBase
{
    public BatchBreedApplyBillCollection getBatchBreedApplyBillCollection() throws BOSException;
    public BatchBreedApplyBillCollection getBatchBreedApplyBillCollection(EntityViewInfo view) throws BOSException;
    public BatchBreedApplyBillCollection getBatchBreedApplyBillCollection(String oql) throws BOSException;
    public BatchBreedApplyBillInfo getBatchBreedApplyBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchBreedApplyBillInfo getBatchBreedApplyBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchBreedApplyBillInfo getBatchBreedApplyBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BatchBreedApplyBillInfo model) throws BOSException;
    public void unAudit(BatchBreedApplyBillInfo model) throws BOSException;
}