package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface IFodderReceptionEntry extends ICoreBillEntryBase
{
    public FodderReceptionEntryInfo getFodderReceptionEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FodderReceptionEntryInfo getFodderReceptionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FodderReceptionEntryInfo getFodderReceptionEntryInfo(String oql) throws BOSException, EASBizException;
    public FodderReceptionEntryCollection getFodderReceptionEntryCollection() throws BOSException;
    public FodderReceptionEntryCollection getFodderReceptionEntryCollection(EntityViewInfo view) throws BOSException;
    public FodderReceptionEntryCollection getFodderReceptionEntryCollection(String oql) throws BOSException;
}