package com.kingdee.eas.custom.tocloud;

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

public interface IBizTypeTree extends ITreeBase
{
    public BizTypeTreeInfo getBizTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BizTypeTreeInfo getBizTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BizTypeTreeInfo getBizTypeTreeInfo(String oql) throws BOSException, EASBizException;
    public BizTypeTreeCollection getBizTypeTreeCollection() throws BOSException;
    public BizTypeTreeCollection getBizTypeTreeCollection(EntityViewInfo view) throws BOSException;
    public BizTypeTreeCollection getBizTypeTreeCollection(String oql) throws BOSException;
}