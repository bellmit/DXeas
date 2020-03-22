package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IStatementsBillEggSettleDetail extends ICoreBillEntryBase
{
    public boolean exists(IObjectPK pk) throws BOSException, EASBizException;
    public boolean exists(FilterInfo filter) throws BOSException, EASBizException;
    public boolean exists(String oql) throws BOSException, EASBizException;
    public StatementsBillEggSettleDetailInfo getStatementsBillEggSettleDetailInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StatementsBillEggSettleDetailInfo getStatementsBillEggSettleDetailInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StatementsBillEggSettleDetailInfo getStatementsBillEggSettleDetailInfo(String oql) throws BOSException, EASBizException;
    public IObjectPK addnew(StatementsBillEggSettleDetailInfo model) throws BOSException, EASBizException;
    public void addnew(IObjectPK pk, StatementsBillEggSettleDetailInfo model) throws BOSException, EASBizException;
    public void update(IObjectPK pk, StatementsBillEggSettleDetailInfo model) throws BOSException, EASBizException;
    public void updatePartial(StatementsBillEggSettleDetailInfo model, SelectorItemCollection selector) throws BOSException, EASBizException;
    public void updateBigObject(IObjectPK pk, StatementsBillEggSettleDetailInfo model) throws BOSException;
    public void delete(IObjectPK pk) throws BOSException, EASBizException;
    public IObjectPK[] getPKList() throws BOSException, EASBizException;
    public IObjectPK[] getPKList(String oql) throws BOSException, EASBizException;
    public IObjectPK[] getPKList(FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException;
    public StatementsBillEggSettleDetailCollection getStatementsBillEggSettleDetailCollection() throws BOSException;
    public StatementsBillEggSettleDetailCollection getStatementsBillEggSettleDetailCollection(EntityViewInfo view) throws BOSException;
    public StatementsBillEggSettleDetailCollection getStatementsBillEggSettleDetailCollection(String oql) throws BOSException;
    public IObjectPK[] delete(FilterInfo filter) throws BOSException, EASBizException;
    public IObjectPK[] delete(String oql) throws BOSException, EASBizException;
    public void delete(IObjectPK[] arrayPK) throws BOSException, EASBizException;
}