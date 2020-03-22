package com.kingdee.eas.farm.feemanager.basebizbill;

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

public interface IMileModifyRecord extends ICoreBillBase
{
    public MileModifyRecordCollection getMileModifyRecordCollection() throws BOSException;
    public MileModifyRecordCollection getMileModifyRecordCollection(EntityViewInfo view) throws BOSException;
    public MileModifyRecordCollection getMileModifyRecordCollection(String oql) throws BOSException;
    public MileModifyRecordInfo getMileModifyRecordInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MileModifyRecordInfo getMileModifyRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MileModifyRecordInfo getMileModifyRecordInfo(String oql) throws BOSException, EASBizException;
}