package com.kingdee.eas.farm.carnivorous.basebiz;

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

public interface IFarmerQualicationApplEntry extends ICoreBillEntryBase
{
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerQualicationApplEntryInfo getFarmerQualicationApplEntryInfo(String oql) throws BOSException, EASBizException;
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection() throws BOSException;
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection(EntityViewInfo view) throws BOSException;
    public FarmerQualicationApplEntryCollection getFarmerQualicationApplEntryCollection(String oql) throws BOSException;
}