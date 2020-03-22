package com.kingdee.eas.custom.shr;

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

public interface IPrePersonToPersonEntry extends ICoreBillEntryBase
{
    public PrePersonToPersonEntryInfo getPrePersonToPersonEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PrePersonToPersonEntryInfo getPrePersonToPersonEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PrePersonToPersonEntryInfo getPrePersonToPersonEntryInfo(String oql) throws BOSException, EASBizException;
    public PrePersonToPersonEntryCollection getPrePersonToPersonEntryCollection() throws BOSException;
    public PrePersonToPersonEntryCollection getPrePersonToPersonEntryCollection(EntityViewInfo view) throws BOSException;
    public PrePersonToPersonEntryCollection getPrePersonToPersonEntryCollection(String oql) throws BOSException;
}