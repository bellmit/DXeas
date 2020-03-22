package com.kingdee.eas.custom.wages.farm;

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

public interface ITAttendFarmRecordEntry extends ICoreBillEntryBase
{
    public TAttendFarmRecordEntryInfo getTAttendFarmRecordEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TAttendFarmRecordEntryInfo getTAttendFarmRecordEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TAttendFarmRecordEntryInfo getTAttendFarmRecordEntryInfo(String oql) throws BOSException, EASBizException;
    public TAttendFarmRecordEntryCollection getTAttendFarmRecordEntryCollection() throws BOSException;
    public TAttendFarmRecordEntryCollection getTAttendFarmRecordEntryCollection(EntityViewInfo view) throws BOSException;
    public TAttendFarmRecordEntryCollection getTAttendFarmRecordEntryCollection(String oql) throws BOSException;
}