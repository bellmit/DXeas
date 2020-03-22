package com.kingdee.eas.custom.wages.food;

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

public interface IProdasseindex extends IDataBase
{
    public ProdasseindexInfo getProdasseindexInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProdasseindexInfo getProdasseindexInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProdasseindexInfo getProdasseindexInfo(String oql) throws BOSException, EASBizException;
    public ProdasseindexCollection getProdasseindexCollection() throws BOSException;
    public ProdasseindexCollection getProdasseindexCollection(EntityViewInfo view) throws BOSException;
    public ProdasseindexCollection getProdasseindexCollection(String oql) throws BOSException;
}