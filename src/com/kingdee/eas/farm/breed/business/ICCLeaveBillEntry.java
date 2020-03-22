package com.kingdee.eas.farm.breed.business;

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

public interface ICCLeaveBillEntry extends ICoreBillEntryBase
{
    public CCLeaveBillEntryInfo getCCLeaveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCLeaveBillEntryInfo getCCLeaveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCLeaveBillEntryInfo getCCLeaveBillEntryInfo(String oql) throws BOSException, EASBizException;
    public CCLeaveBillEntryCollection getCCLeaveBillEntryCollection() throws BOSException;
    public CCLeaveBillEntryCollection getCCLeaveBillEntryCollection(EntityViewInfo view) throws BOSException;
    public CCLeaveBillEntryCollection getCCLeaveBillEntryCollection(String oql) throws BOSException;
}