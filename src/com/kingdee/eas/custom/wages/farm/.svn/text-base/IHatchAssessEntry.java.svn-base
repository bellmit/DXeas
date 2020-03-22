package com.kingdee.eas.custom.wages.farm;

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

public interface IHatchAssessEntry extends ICoreBillEntryBase
{
    public HatchAssessEntryInfo getHatchAssessEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchAssessEntryInfo getHatchAssessEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchAssessEntryInfo getHatchAssessEntryInfo(String oql) throws BOSException, EASBizException;
    public HatchAssessEntryCollection getHatchAssessEntryCollection() throws BOSException;
    public HatchAssessEntryCollection getHatchAssessEntryCollection(EntityViewInfo view) throws BOSException;
    public HatchAssessEntryCollection getHatchAssessEntryCollection(String oql) throws BOSException;
}