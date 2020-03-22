package com.kingdee.eas.custom.wages.food;

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

public interface ITAttendanceRecords extends ICoreBillBase
{
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection() throws BOSException;
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection(EntityViewInfo view) throws BOSException;
    public TAttendanceRecordsCollection getTAttendanceRecordsCollection(String oql) throws BOSException;
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TAttendanceRecordsInfo getTAttendanceRecordsInfo(String oql) throws BOSException, EASBizException;
    public void audit(TAttendanceRecordsInfo model) throws BOSException;
    public void unaudit(TAttendanceRecordsInfo model) throws BOSException;
}