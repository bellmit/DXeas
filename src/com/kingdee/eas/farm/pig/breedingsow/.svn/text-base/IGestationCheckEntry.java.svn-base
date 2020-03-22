package com.kingdee.eas.farm.pig.breedingsow;

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

public interface IGestationCheckEntry extends ICoreBillEntryBase
{
    public GestationCheckEntryInfo getGestationCheckEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public GestationCheckEntryInfo getGestationCheckEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public GestationCheckEntryInfo getGestationCheckEntryInfo(String oql) throws BOSException, EASBizException;
    public GestationCheckEntryCollection getGestationCheckEntryCollection() throws BOSException;
    public GestationCheckEntryCollection getGestationCheckEntryCollection(EntityViewInfo view) throws BOSException;
    public GestationCheckEntryCollection getGestationCheckEntryCollection(String oql) throws BOSException;
}