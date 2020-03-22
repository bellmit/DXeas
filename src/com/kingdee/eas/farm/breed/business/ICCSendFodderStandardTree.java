package com.kingdee.eas.farm.breed.business;

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

public interface ICCSendFodderStandardTree extends ITreeBase
{
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCSendFodderStandardTreeInfo getCCSendFodderStandardTreeInfo(String oql) throws BOSException, EASBizException;
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection() throws BOSException;
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection(EntityViewInfo view) throws BOSException;
    public CCSendFodderStandardTreeCollection getCCSendFodderStandardTreeCollection(String oql) throws BOSException;
}