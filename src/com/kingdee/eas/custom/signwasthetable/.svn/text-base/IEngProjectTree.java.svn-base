package com.kingdee.eas.custom.signwasthetable;

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

public interface IEngProjectTree extends ITreeBase
{
    public EngProjectTreeInfo getEngProjectTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EngProjectTreeInfo getEngProjectTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EngProjectTreeInfo getEngProjectTreeInfo(String oql) throws BOSException, EASBizException;
    public EngProjectTreeCollection getEngProjectTreeCollection() throws BOSException;
    public EngProjectTreeCollection getEngProjectTreeCollection(EntityViewInfo view) throws BOSException;
    public EngProjectTreeCollection getEngProjectTreeCollection(String oql) throws BOSException;
}