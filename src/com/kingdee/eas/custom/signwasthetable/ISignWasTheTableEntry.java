package com.kingdee.eas.custom.signwasthetable;

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

public interface ISignWasTheTableEntry extends ICoreBillEntryBase
{
    public boolean exists(IObjectPK pk) throws BOSException, EASBizException;
    public boolean exists(FilterInfo filter) throws BOSException, EASBizException;
    public boolean exists(String oql) throws BOSException, EASBizException;
    public SignWasTheTableEntryInfo getSignWasTheTableEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SignWasTheTableEntryInfo getSignWasTheTableEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SignWasTheTableEntryInfo getSignWasTheTableEntryInfo(String oql) throws BOSException, EASBizException;
    public IObjectPK addnew(SignWasTheTableEntryInfo model) throws BOSException, EASBizException;
    public void addnew(IObjectPK pk, SignWasTheTableEntryInfo model) throws BOSException, EASBizException;
    public void update(IObjectPK pk, SignWasTheTableEntryInfo model) throws BOSException, EASBizException;
    public void updatePartial(SignWasTheTableEntryInfo model, SelectorItemCollection selector) throws BOSException, EASBizException;
    public void updateBigObject(IObjectPK pk, SignWasTheTableEntryInfo model) throws BOSException;
    public void delete(IObjectPK pk) throws BOSException, EASBizException;
    public IObjectPK[] getPKList() throws BOSException, EASBizException;
    public IObjectPK[] getPKList(String oql) throws BOSException, EASBizException;
    public IObjectPK[] getPKList(FilterInfo filter, SorterItemCollection sorter) throws BOSException, EASBizException;
    public SignWasTheTableEntryCollection getSignWasTheTableEntryCollection() throws BOSException;
    public SignWasTheTableEntryCollection getSignWasTheTableEntryCollection(EntityViewInfo view) throws BOSException;
    public SignWasTheTableEntryCollection getSignWasTheTableEntryCollection(String oql) throws BOSException;
    public IObjectPK[] delete(FilterInfo filter) throws BOSException, EASBizException;
    public IObjectPK[] delete(String oql) throws BOSException, EASBizException;
    public void delete(IObjectPK[] arrayPK) throws BOSException, EASBizException;
}