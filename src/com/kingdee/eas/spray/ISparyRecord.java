package com.kingdee.eas.spray;

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

public interface ISparyRecord extends ICoreBillBase
{
    public SparyRecordCollection getSparyRecordCollection() throws BOSException;
    public SparyRecordCollection getSparyRecordCollection(EntityViewInfo view) throws BOSException;
    public SparyRecordCollection getSparyRecordCollection(String oql) throws BOSException;
    public SparyRecordInfo getSparyRecordInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SparyRecordInfo getSparyRecordInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SparyRecordInfo getSparyRecordInfo(String oql) throws BOSException, EASBizException;
}