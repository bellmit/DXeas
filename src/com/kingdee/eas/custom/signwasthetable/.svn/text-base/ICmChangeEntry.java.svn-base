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

public interface ICmChangeEntry extends ICoreBillEntryBase
{
    public CmChangeEntryInfo getCmChangeEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CmChangeEntryInfo getCmChangeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CmChangeEntryInfo getCmChangeEntryInfo(String oql) throws BOSException, EASBizException;
    public CmChangeEntryCollection getCmChangeEntryCollection() throws BOSException;
    public CmChangeEntryCollection getCmChangeEntryCollection(EntityViewInfo view) throws BOSException;
    public CmChangeEntryCollection getCmChangeEntryCollection(String oql) throws BOSException;
}