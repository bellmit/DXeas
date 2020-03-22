package com.kingdee.eas.farm.carnivorous.recyclebiz;

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

public interface ICKCostAllocateBill extends ICoreBillBase
{
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection() throws BOSException;
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(EntityViewInfo view) throws BOSException;
    public CKCostAllocateBillCollection getCKCostAllocateBillCollection(String oql) throws BOSException;
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKCostAllocateBillInfo getCKCostAllocateBillInfo(String oql) throws BOSException, EASBizException;
    public void execAllocate(CKCostAllocateBillInfo model) throws BOSException;
    public void audit(CKCostAllocateBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CKCostAllocateBillInfo model) throws BOSException, EASBizException;
    public void costAmt(CKCostAllocateBillInfo model) throws BOSException, EASBizException;
}