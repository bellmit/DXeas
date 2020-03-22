package com.kingdee.eas.custom.signwasthetable;

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

public interface IOverPayEntry extends ICoreBillEntryBase
{
    public OverPayEntryInfo getOverPayEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OverPayEntryInfo getOverPayEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OverPayEntryInfo getOverPayEntryInfo(String oql) throws BOSException, EASBizException;
    public OverPayEntryCollection getOverPayEntryCollection() throws BOSException;
    public OverPayEntryCollection getOverPayEntryCollection(EntityViewInfo view) throws BOSException;
    public OverPayEntryCollection getOverPayEntryCollection(String oql) throws BOSException;
}