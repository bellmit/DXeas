package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IDiscountSetEntry extends ICoreBase
{
    public void auditForEntries(IObjectPK[] pks) throws BOSException, EASBizException;
    public void unAuditForEntries(IObjectPK[] pks) throws BOSException, EASBizException;
    public DiscountSetEntryInfo getDiscountSetEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DiscountSetEntryInfo getDiscountSetEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DiscountSetEntryInfo getDiscountSetEntryInfo(String oql) throws BOSException, EASBizException;
    public DiscountSetEntryCollection getDiscountSetEntryCollection() throws BOSException;
    public DiscountSetEntryCollection getDiscountSetEntryCollection(EntityViewInfo view) throws BOSException;
    public DiscountSetEntryCollection getDiscountSetEntryCollection(String oql) throws BOSException;
}