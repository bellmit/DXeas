package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public interface IEggSettlePolicyRangeEntry extends ICoreBillEntryBase
{
    public boolean exists(IObjectPK pk) throws BOSException, EASBizException;
    public boolean exists(FilterInfo filter) throws BOSException, EASBizException;
    public boolean exists(String oql) throws BOSException, EASBizException;
    public EggSettlePolicyRangeEntryInfo getEggSettlePolicyRangeEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggSettlePolicyRangeEntryInfo getEggSettlePolicyRangeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggSettlePolicyRangeEntryInfo getEggSettlePolicyRangeEntryInfo(String oql) throws BOSException, EASBizException;
    public IObjectPK addnew(EggSettlePolicyRangeEntryInfo model) throws BOSException, EASBizException;
    public void addnew(IObjectPK pk, EggSettlePolicyRangeEntryInfo model) throws BOSException, EASBizException;
    public void update(IObjectPK pk, EggSettlePolicyRangeEntryInfo model) throws BOSException, EASBizException;
    public void updatePartial(EggSettlePolicyRangeEntryInfo model, SelectorItemCollection selector) throws BOSException, EASBizException;
    public void updateBigObject(IObjectPK pk, EggSettlePolicyRangeEntryInfo model) throws BOSException;
    public void delete(IObjectPK pk) throws BOSException, EASBizException;
    public IObjectPK[] getPKList() throws BOSException, EASBizException;
    public IObjectPK[] getPKList(String oql) throws BOSException, EASBizException;
    public IObjectPK[] getPKList(FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException;
    public EggSettlePolicyRangeEntryCollection getEggSettlePolicyRangeEntryCollection() throws BOSException;
    public EggSettlePolicyRangeEntryCollection getEggSettlePolicyRangeEntryCollection(EntityViewInfo view) throws BOSException;
    public EggSettlePolicyRangeEntryCollection getEggSettlePolicyRangeEntryCollection(String oql) throws BOSException;
    public IObjectPK[] delete(FilterInfo filter) throws BOSException, EASBizException;
    public IObjectPK[] delete(String oql) throws BOSException, EASBizException;
    public void delete(IObjectPK[] arrayPK) throws BOSException, EASBizException;
}