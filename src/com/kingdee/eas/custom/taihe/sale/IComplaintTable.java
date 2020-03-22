package com.kingdee.eas.custom.taihe.sale;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IComplaintTable extends ICoreBillBase
{
    public ComplaintTableCollection getComplaintTableCollection() throws BOSException;
    public ComplaintTableCollection getComplaintTableCollection(EntityViewInfo view) throws BOSException;
    public ComplaintTableCollection getComplaintTableCollection(String oql) throws BOSException;
    public ComplaintTableInfo getComplaintTableInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ComplaintTableInfo getComplaintTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ComplaintTableInfo getComplaintTableInfo(String oql) throws BOSException, EASBizException;
}