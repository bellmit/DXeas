package com.kingdee.eas.custom.wages;

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

public interface IAttendanceDockingSetting extends IDataBase
{
    public AttendanceDockingSettingInfo getAttendanceDockingSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AttendanceDockingSettingInfo getAttendanceDockingSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AttendanceDockingSettingInfo getAttendanceDockingSettingInfo(String oql) throws BOSException, EASBizException;
    public AttendanceDockingSettingCollection getAttendanceDockingSettingCollection() throws BOSException;
    public AttendanceDockingSettingCollection getAttendanceDockingSettingCollection(EntityViewInfo view) throws BOSException;
    public AttendanceDockingSettingCollection getAttendanceDockingSettingCollection(String oql) throws BOSException;
}