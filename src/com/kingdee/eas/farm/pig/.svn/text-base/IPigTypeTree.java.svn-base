package com.kingdee.eas.farm.pig;

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

public interface IPigTypeTree extends ITreeBase
{
    public PigTypeTreeInfo getPigTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigTypeTreeInfo getPigTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigTypeTreeInfo getPigTypeTreeInfo(String oql) throws BOSException, EASBizException;
    public PigTypeTreeCollection getPigTypeTreeCollection() throws BOSException;
    public PigTypeTreeCollection getPigTypeTreeCollection(EntityViewInfo view) throws BOSException;
    public PigTypeTreeCollection getPigTypeTreeCollection(String oql) throws BOSException;
}