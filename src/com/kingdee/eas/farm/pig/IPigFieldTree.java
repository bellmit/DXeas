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

public interface IPigFieldTree extends ITreeBase
{
    public PigFieldTreeInfo getPigFieldTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PigFieldTreeInfo getPigFieldTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PigFieldTreeInfo getPigFieldTreeInfo(String oql) throws BOSException, EASBizException;
    public PigFieldTreeCollection getPigFieldTreeCollection() throws BOSException;
    public PigFieldTreeCollection getPigFieldTreeCollection(EntityViewInfo view) throws BOSException;
    public PigFieldTreeCollection getPigFieldTreeCollection(String oql) throws BOSException;
}