package com.kingdee.eas.custom.taihe.sale;

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

public interface IComplaintTableEntry extends ICoreBillEntryBase
{
    public ComplaintTableEntryInfo getComplaintTableEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ComplaintTableEntryInfo getComplaintTableEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ComplaintTableEntryInfo getComplaintTableEntryInfo(String oql) throws BOSException, EASBizException;
    public ComplaintTableEntryCollection getComplaintTableEntryCollection() throws BOSException;
    public ComplaintTableEntryCollection getComplaintTableEntryCollection(EntityViewInfo view) throws BOSException;
    public ComplaintTableEntryCollection getComplaintTableEntryCollection(String oql) throws BOSException;
}