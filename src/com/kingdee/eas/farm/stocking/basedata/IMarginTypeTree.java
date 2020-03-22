package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IMarginTypeTree extends ITreeBase
{
    public MarginTypeTreeInfo getMarginTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarginTypeTreeInfo getMarginTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarginTypeTreeInfo getMarginTypeTreeInfo(String oql) throws BOSException, EASBizException;
    public MarginTypeTreeCollection getMarginTypeTreeCollection() throws BOSException;
    public MarginTypeTreeCollection getMarginTypeTreeCollection(EntityViewInfo view) throws BOSException;
    public MarginTypeTreeCollection getMarginTypeTreeCollection(String oql) throws BOSException;
}