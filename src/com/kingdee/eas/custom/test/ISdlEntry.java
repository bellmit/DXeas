package com.kingdee.eas.custom.test;

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

public interface ISdlEntry extends ICoreBillEntryBase
{
    public SdlEntryInfo getSdlEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SdlEntryInfo getSdlEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SdlEntryInfo getSdlEntryInfo(String oql) throws BOSException, EASBizException;
    public SdlEntryCollection getSdlEntryCollection() throws BOSException;
    public SdlEntryCollection getSdlEntryCollection(EntityViewInfo view) throws BOSException;
    public SdlEntryCollection getSdlEntryCollection(String oql) throws BOSException;
}