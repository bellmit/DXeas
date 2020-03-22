package com.kingdee.eas.custom.szcount;

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

public interface ISzCountPositionSetTree extends ITreeBase
{
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SzCountPositionSetTreeInfo getSzCountPositionSetTreeInfo(String oql) throws BOSException, EASBizException;
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection() throws BOSException;
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection(EntityViewInfo view) throws BOSException;
    public SzCountPositionSetTreeCollection getSzCountPositionSetTreeCollection(String oql) throws BOSException;
}