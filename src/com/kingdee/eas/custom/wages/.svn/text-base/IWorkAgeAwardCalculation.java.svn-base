package com.kingdee.eas.custom.wages;

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

public interface IWorkAgeAwardCalculation extends ICoreBillEntryBase
{
    public boolean exists(IObjectPK pk) throws BOSException, EASBizException;
    public boolean exists(FilterInfo filter) throws BOSException, EASBizException;
    public boolean exists(String oql) throws BOSException, EASBizException;
    public WorkAgeAwardCalculationInfo getWorkAgeAwardCalculationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WorkAgeAwardCalculationInfo getWorkAgeAwardCalculationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WorkAgeAwardCalculationInfo getWorkAgeAwardCalculationInfo(String oql) throws BOSException, EASBizException;
    public IObjectPK addnew(WorkAgeAwardCalculationInfo model) throws BOSException, EASBizException;
    public void addnew(IObjectPK pk, WorkAgeAwardCalculationInfo model) throws BOSException, EASBizException;
    public void update(IObjectPK pk, WorkAgeAwardCalculationInfo model) throws BOSException, EASBizException;
    public void updatePartial(WorkAgeAwardCalculationInfo model, SelectorItemCollection selector) throws BOSException, EASBizException;
    public void updateBigObject(IObjectPK pk, WorkAgeAwardCalculationInfo model) throws BOSException;
    public void delete(IObjectPK pk) throws BOSException, EASBizException;
    public IObjectPK[] getPKList() throws BOSException, EASBizException;
    public IObjectPK[] getPKList(String oql) throws BOSException, EASBizException;
    public IObjectPK[] getPKList(FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException;
    public WorkAgeAwardCalculationCollection getWorkAgeAwardCalculationCollection() throws BOSException;
    public WorkAgeAwardCalculationCollection getWorkAgeAwardCalculationCollection(EntityViewInfo view) throws BOSException;
    public WorkAgeAwardCalculationCollection getWorkAgeAwardCalculationCollection(String oql) throws BOSException;
    public IObjectPK[] delete(FilterInfo filter) throws BOSException, EASBizException;
    public IObjectPK[] delete(String oql) throws BOSException, EASBizException;
    public void delete(IObjectPK[] arrayPK) throws BOSException, EASBizException;
}