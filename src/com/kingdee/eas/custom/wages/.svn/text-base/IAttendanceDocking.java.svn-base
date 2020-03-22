package com.kingdee.eas.custom.wages;

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

public interface IAttendanceDocking extends IWlhlBillBase
{
    public AttendanceDockingCollection getAttendanceDockingCollection() throws BOSException;
    public AttendanceDockingCollection getAttendanceDockingCollection(EntityViewInfo view) throws BOSException;
    public AttendanceDockingCollection getAttendanceDockingCollection(String oql) throws BOSException;
    public AttendanceDockingInfo getAttendanceDockingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AttendanceDockingInfo getAttendanceDockingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AttendanceDockingInfo getAttendanceDockingInfo(String oql) throws BOSException, EASBizException;
}