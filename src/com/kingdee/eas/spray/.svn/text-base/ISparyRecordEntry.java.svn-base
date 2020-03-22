package com.kingdee.eas.spray;

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

public interface ISparyRecordEntry extends ICoreBillEntryBase
{
    public SparyRecordEntryInfo getSparyRecordEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SparyRecordEntryInfo getSparyRecordEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SparyRecordEntryInfo getSparyRecordEntryInfo(String oql) throws BOSException, EASBizException;
    public SparyRecordEntryCollection getSparyRecordEntryCollection() throws BOSException;
    public SparyRecordEntryCollection getSparyRecordEntryCollection(EntityViewInfo view) throws BOSException;
    public SparyRecordEntryCollection getSparyRecordEntryCollection(String oql) throws BOSException;
}