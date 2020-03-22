package com.kingdee.eas.custom.foodtrac;

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

public interface ICompanyinfoPicentry extends ICoreBillEntryBase
{
    public boolean exists(IObjectPK pk) throws BOSException, EASBizException;
    public boolean exists(FilterInfo filter) throws BOSException, EASBizException;
    public boolean exists(String oql) throws BOSException, EASBizException;
    public CompanyinfoPicentryInfo getCompanyinfoPicentryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CompanyinfoPicentryInfo getCompanyinfoPicentryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CompanyinfoPicentryInfo getCompanyinfoPicentryInfo(String oql) throws BOSException, EASBizException;
    public IObjectPK addnew(CompanyinfoPicentryInfo model) throws BOSException, EASBizException;
    public void addnew(IObjectPK pk, CompanyinfoPicentryInfo model) throws BOSException, EASBizException;
    public void update(IObjectPK pk, CompanyinfoPicentryInfo model) throws BOSException, EASBizException;
    public void updatePartial(CompanyinfoPicentryInfo model, SelectorItemCollection selector) throws BOSException, EASBizException;
    public void updateBigObject(IObjectPK pk, CompanyinfoPicentryInfo model) throws BOSException;
    public void delete(IObjectPK pk) throws BOSException, EASBizException;
    public IObjectPK[] getPKList() throws BOSException, EASBizException;
    public IObjectPK[] getPKList(String oql) throws BOSException, EASBizException;
    public IObjectPK[] getPKList(FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException;
    public CompanyinfoPicentryCollection getCompanyinfoPicentryCollection() throws BOSException;
    public CompanyinfoPicentryCollection getCompanyinfoPicentryCollection(EntityViewInfo view) throws BOSException;
    public CompanyinfoPicentryCollection getCompanyinfoPicentryCollection(String oql) throws BOSException;
    public IObjectPK[] delete(FilterInfo filter) throws BOSException, EASBizException;
    public IObjectPK[] delete(String oql) throws BOSException, EASBizException;
    public void delete(IObjectPK[] arrayPK) throws BOSException, EASBizException;
}