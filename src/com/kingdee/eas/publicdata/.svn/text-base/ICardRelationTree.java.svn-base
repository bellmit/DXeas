package com.kingdee.eas.publicdata;

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

public interface ICardRelationTree extends ITreeBase
{
    public CardRelationTreeInfo getCardRelationTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CardRelationTreeInfo getCardRelationTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CardRelationTreeInfo getCardRelationTreeInfo(String oql) throws BOSException, EASBizException;
    public CardRelationTreeCollection getCardRelationTreeCollection() throws BOSException;
    public CardRelationTreeCollection getCardRelationTreeCollection(EntityViewInfo view) throws BOSException;
    public CardRelationTreeCollection getCardRelationTreeCollection(String oql) throws BOSException;
}