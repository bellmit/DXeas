package com.kingdee.eas.custom.wages;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IExtractFrom extends IDataBase
{
    public ExtractFromInfo getExtractFromInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ExtractFromInfo getExtractFromInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ExtractFromInfo getExtractFromInfo(String oql) throws BOSException, EASBizException;
    public ExtractFromCollection getExtractFromCollection() throws BOSException;
    public ExtractFromCollection getExtractFromCollection(EntityViewInfo view) throws BOSException;
    public ExtractFromCollection getExtractFromCollection(String oql) throws BOSException;
}