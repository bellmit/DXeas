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

public interface IMaintenTeamEntry extends ICoreBillEntryBase
{
    public MaintenTeamEntryInfo getMaintenTeamEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaintenTeamEntryInfo getMaintenTeamEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaintenTeamEntryInfo getMaintenTeamEntryInfo(String oql) throws BOSException, EASBizException;
    public MaintenTeamEntryCollection getMaintenTeamEntryCollection() throws BOSException;
    public MaintenTeamEntryCollection getMaintenTeamEntryCollection(EntityViewInfo view) throws BOSException;
    public MaintenTeamEntryCollection getMaintenTeamEntryCollection(String oql) throws BOSException;
}