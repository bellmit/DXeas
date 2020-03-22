package com.kingdee.eas.farm.food.stocount;

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

public interface IPcakCountEntry extends ICoreBillEntryBase
{
    public PcakCountEntryInfo getPcakCountEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PcakCountEntryInfo getPcakCountEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PcakCountEntryInfo getPcakCountEntryInfo(String oql) throws BOSException, EASBizException;
    public PcakCountEntryCollection getPcakCountEntryCollection() throws BOSException;
    public PcakCountEntryCollection getPcakCountEntryCollection(EntityViewInfo view) throws BOSException;
    public PcakCountEntryCollection getPcakCountEntryCollection(String oql) throws BOSException;
}