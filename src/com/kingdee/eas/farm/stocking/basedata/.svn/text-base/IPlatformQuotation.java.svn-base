package com.kingdee.eas.farm.stocking.basedata;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IPlatformQuotation extends IDataBase
{
    public PlatformQuotationInfo getPlatformQuotationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PlatformQuotationInfo getPlatformQuotationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PlatformQuotationInfo getPlatformQuotationInfo(String oql) throws BOSException, EASBizException;
    public PlatformQuotationCollection getPlatformQuotationCollection() throws BOSException;
    public PlatformQuotationCollection getPlatformQuotationCollection(EntityViewInfo view) throws BOSException;
    public PlatformQuotationCollection getPlatformQuotationCollection(String oql) throws BOSException;
    public void audit(PlatformQuotationInfo model) throws BOSException, EASBizException;
    public void unAudit(PlatformQuotationInfo model) throws BOSException, EASBizException;
}