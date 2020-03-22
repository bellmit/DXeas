package com.kingdee.eas.farm.pig.breedingsow;

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

public interface ISow extends IDataBase
{
    public SowInfo getSowInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SowInfo getSowInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SowInfo getSowInfo(String oql) throws BOSException, EASBizException;
    public SowCollection getSowCollection() throws BOSException;
    public SowCollection getSowCollection(EntityViewInfo view) throws BOSException;
    public SowCollection getSowCollection(String oql) throws BOSException;
}