package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IBatchTree extends ITreeBase
{
    public BatchTreeInfo getBatchTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BatchTreeInfo getBatchTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BatchTreeInfo getBatchTreeInfo(String oql) throws BOSException, EASBizException;
    public BatchTreeCollection getBatchTreeCollection() throws BOSException;
    public BatchTreeCollection getBatchTreeCollection(EntityViewInfo view) throws BOSException;
    public BatchTreeCollection getBatchTreeCollection(String oql) throws BOSException;
}