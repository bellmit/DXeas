package com.kingdee.eas.custom.taihe.sewagedetection;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICheckRecord extends IWlhlBillBase
{
    public CheckRecordCollection getCheckRecordCollection() throws BOSException;
    public CheckRecordCollection getCheckRecordCollection(EntityViewInfo view) throws BOSException;
    public CheckRecordCollection getCheckRecordCollection(String oql) throws BOSException;
    public CheckRecordInfo getCheckRecordInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CheckRecordInfo getCheckRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CheckRecordInfo getCheckRecordInfo(String oql) throws BOSException, EASBizException;
    public void getCheckRecord(CheckRecordInfo model) throws BOSException;
    public void modileSee(CheckRecordInfo model) throws BOSException;
}