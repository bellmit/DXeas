package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
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

public interface IPackingConversion extends IWlhlDataBase
{
    public PackingConversionInfo getPackingConversionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PackingConversionInfo getPackingConversionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PackingConversionInfo getPackingConversionInfo(String oql) throws BOSException, EASBizException;
    public PackingConversionCollection getPackingConversionCollection() throws BOSException;
    public PackingConversionCollection getPackingConversionCollection(EntityViewInfo view) throws BOSException;
    public PackingConversionCollection getPackingConversionCollection(String oql) throws BOSException;
}