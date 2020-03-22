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

public interface ISowPolulationEntry extends ICoreBillEntryBase
{
    public SowPolulationEntryInfo getSowPolulationEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SowPolulationEntryInfo getSowPolulationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SowPolulationEntryInfo getSowPolulationEntryInfo(String oql) throws BOSException, EASBizException;
    public SowPolulationEntryCollection getSowPolulationEntryCollection() throws BOSException;
    public SowPolulationEntryCollection getSowPolulationEntryCollection(EntityViewInfo view) throws BOSException;
    public SowPolulationEntryCollection getSowPolulationEntryCollection(String oql) throws BOSException;
}