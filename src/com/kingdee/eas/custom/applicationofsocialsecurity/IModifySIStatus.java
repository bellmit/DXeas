package com.kingdee.eas.custom.applicationofsocialsecurity;

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

public interface IModifySIStatus extends ICoreBillBase
{
    public ModifySIStatusCollection getModifySIStatusCollection() throws BOSException;
    public ModifySIStatusCollection getModifySIStatusCollection(EntityViewInfo view) throws BOSException;
    public ModifySIStatusCollection getModifySIStatusCollection(String oql) throws BOSException;
    public ModifySIStatusInfo getModifySIStatusInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ModifySIStatusInfo getModifySIStatusInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ModifySIStatusInfo getModifySIStatusInfo(String oql) throws BOSException, EASBizException;
    public void undoAll(ModifySIStatusInfo model) throws BOSException;
    public void undoSelected(ModifySIStatusInfo model) throws BOSException;
}