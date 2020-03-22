package com.kingdee.eas.farm.stocking.processbizill;

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

public interface ITtfiled extends ICoreBillBase
{
    public TtfiledCollection getTtfiledCollection() throws BOSException;
    public TtfiledCollection getTtfiledCollection(EntityViewInfo view) throws BOSException;
    public TtfiledCollection getTtfiledCollection(String oql) throws BOSException;
    public TtfiledInfo getTtfiledInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TtfiledInfo getTtfiledInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TtfiledInfo getTtfiledInfo(String oql) throws BOSException, EASBizException;
}