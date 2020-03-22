package com.kingdee.eas.farm.feedfactory;

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

public interface IPurFrightEntry extends ICoreBillEntryBase
{
    public PurFrightEntryInfo getPurFrightEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PurFrightEntryInfo getPurFrightEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PurFrightEntryInfo getPurFrightEntryInfo(String oql) throws BOSException, EASBizException;
    public PurFrightEntryCollection getPurFrightEntryCollection() throws BOSException;
    public PurFrightEntryCollection getPurFrightEntryCollection(EntityViewInfo view) throws BOSException;
    public PurFrightEntryCollection getPurFrightEntryCollection(String oql) throws BOSException;
}