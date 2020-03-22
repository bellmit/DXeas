package com.kingdee.eas.custom.wages;

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

public interface IQualityawardticketEntry extends ICoreBillEntryBase
{
    public QualityawardticketEntryInfo getQualityawardticketEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QualityawardticketEntryInfo getQualityawardticketEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QualityawardticketEntryInfo getQualityawardticketEntryInfo(String oql) throws BOSException, EASBizException;
    public QualityawardticketEntryCollection getQualityawardticketEntryCollection() throws BOSException;
    public QualityawardticketEntryCollection getQualityawardticketEntryCollection(EntityViewInfo view) throws BOSException;
    public QualityawardticketEntryCollection getQualityawardticketEntryCollection(String oql) throws BOSException;
}