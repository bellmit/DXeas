package com.kingdee.eas.custom.applicationofsocialsecurity;

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

public interface IModifySIStatusEntry extends ICoreBillEntryBase
{
    public ModifySIStatusEntryInfo getModifySIStatusEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ModifySIStatusEntryInfo getModifySIStatusEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ModifySIStatusEntryInfo getModifySIStatusEntryInfo(String oql) throws BOSException, EASBizException;
    public ModifySIStatusEntryCollection getModifySIStatusEntryCollection() throws BOSException;
    public ModifySIStatusEntryCollection getModifySIStatusEntryCollection(EntityViewInfo view) throws BOSException;
    public ModifySIStatusEntryCollection getModifySIStatusEntryCollection(String oql) throws BOSException;
}