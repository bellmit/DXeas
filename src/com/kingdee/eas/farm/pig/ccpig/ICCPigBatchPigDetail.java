package com.kingdee.eas.farm.pig.ccpig;

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

public interface ICCPigBatchPigDetail extends ICoreBillEntryBase
{
    public boolean exists(IObjectPK pk) throws BOSException, EASBizException;
    public boolean exists(FilterInfo filter) throws BOSException, EASBizException;
    public boolean exists(String oql) throws BOSException, EASBizException;
    public CCPigBatchPigDetailInfo getCCPigBatchPigDetailInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCPigBatchPigDetailInfo getCCPigBatchPigDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCPigBatchPigDetailInfo getCCPigBatchPigDetailInfo(String oql) throws BOSException, EASBizException;
    public IObjectPK addnew(CCPigBatchPigDetailInfo model) throws BOSException, EASBizException;
    public void addnew(IObjectPK pk, CCPigBatchPigDetailInfo model) throws BOSException, EASBizException;
    public void update(IObjectPK pk, CCPigBatchPigDetailInfo model) throws BOSException, EASBizException;
    public void updatePartial(CCPigBatchPigDetailInfo model, SelectorItemCollection selector) throws BOSException, EASBizException;
    public void updateBigObject(IObjectPK pk, CCPigBatchPigDetailInfo model) throws BOSException;
    public void delete(IObjectPK pk) throws BOSException, EASBizException;
    public IObjectPK[] getPKList() throws BOSException, EASBizException;
    public IObjectPK[] getPKList(String oql) throws BOSException, EASBizException;
    public IObjectPK[] getPKList(FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException;
    public CCPigBatchPigDetailCollection getCCPigBatchPigDetailCollection() throws BOSException;
    public CCPigBatchPigDetailCollection getCCPigBatchPigDetailCollection(EntityViewInfo view) throws BOSException;
    public CCPigBatchPigDetailCollection getCCPigBatchPigDetailCollection(String oql) throws BOSException;
    public IObjectPK[] delete(FilterInfo filter) throws BOSException, EASBizException;
    public IObjectPK[] delete(String oql) throws BOSException, EASBizException;
    public void delete(IObjectPK[] arrayPK) throws BOSException, EASBizException;
}