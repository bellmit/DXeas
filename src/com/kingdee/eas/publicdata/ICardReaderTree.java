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

public interface ICardReaderTree extends ITreeBase
{
    public CardReaderTreeInfo getCardReaderTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CardReaderTreeInfo getCardReaderTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CardReaderTreeInfo getCardReaderTreeInfo(String oql) throws BOSException, EASBizException;
    public CardReaderTreeCollection getCardReaderTreeCollection() throws BOSException;
    public CardReaderTreeCollection getCardReaderTreeCollection(EntityViewInfo view) throws BOSException;
    public CardReaderTreeCollection getCardReaderTreeCollection(String oql) throws BOSException;
}