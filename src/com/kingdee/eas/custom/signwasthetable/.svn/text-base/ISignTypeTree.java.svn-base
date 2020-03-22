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

public interface ISignTypeTree extends ITreeBase
{
    public SignTypeTreeInfo getSignTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SignTypeTreeInfo getSignTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SignTypeTreeInfo getSignTypeTreeInfo(String oql) throws BOSException, EASBizException;
    public SignTypeTreeCollection getSignTypeTreeCollection() throws BOSException;
    public SignTypeTreeCollection getSignTypeTreeCollection(EntityViewInfo view) throws BOSException;
    public SignTypeTreeCollection getSignTypeTreeCollection(String oql) throws BOSException;
}