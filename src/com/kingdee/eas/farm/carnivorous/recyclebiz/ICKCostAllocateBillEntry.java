package com.kingdee.eas.farm.carnivorous.recyclebiz;

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

public interface ICKCostAllocateBillEntry extends ICoreBillEntryBase
{
    public CKCostAllocateBillEntryInfo getCKCostAllocateBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CKCostAllocateBillEntryInfo getCKCostAllocateBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CKCostAllocateBillEntryInfo getCKCostAllocateBillEntryInfo(String oql) throws BOSException, EASBizException;
    public CKCostAllocateBillEntryCollection getCKCostAllocateBillEntryCollection() throws BOSException;
    public CKCostAllocateBillEntryCollection getCKCostAllocateBillEntryCollection(EntityViewInfo view) throws BOSException;
    public CKCostAllocateBillEntryCollection getCKCostAllocateBillEntryCollection(String oql) throws BOSException;
}