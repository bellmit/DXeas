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

public interface IMaintenTeam extends ICoreBillBase
{
    public MaintenTeamCollection getMaintenTeamCollection() throws BOSException;
    public MaintenTeamCollection getMaintenTeamCollection(EntityViewInfo view) throws BOSException;
    public MaintenTeamCollection getMaintenTeamCollection(String oql) throws BOSException;
    public MaintenTeamInfo getMaintenTeamInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaintenTeamInfo getMaintenTeamInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaintenTeamInfo getMaintenTeamInfo(String oql) throws BOSException, EASBizException;
    public void audit(MaintenTeamInfo model) throws BOSException;
    public void unaudit(MaintenTeamInfo model) throws BOSException;
}