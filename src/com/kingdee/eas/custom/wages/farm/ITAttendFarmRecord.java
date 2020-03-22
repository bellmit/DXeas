package com.kingdee.eas.custom.wages.farm;

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

public interface ITAttendFarmRecord extends ICoreBillBase
{
    public TAttendFarmRecordCollection getTAttendFarmRecordCollection() throws BOSException;
    public TAttendFarmRecordCollection getTAttendFarmRecordCollection(EntityViewInfo view) throws BOSException;
    public TAttendFarmRecordCollection getTAttendFarmRecordCollection(String oql) throws BOSException;
    public TAttendFarmRecordInfo getTAttendFarmRecordInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TAttendFarmRecordInfo getTAttendFarmRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TAttendFarmRecordInfo getTAttendFarmRecordInfo(String oql) throws BOSException, EASBizException;
    public void audit(TAttendFarmRecordInfo model) throws BOSException;
    public void unaudit(TAttendFarmRecordInfo model) throws BOSException;
}