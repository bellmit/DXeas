package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICCSendFodderStandard extends IDataBase
{
    public CCSendFodderStandardInfo getCCSendFodderStandardInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCSendFodderStandardInfo getCCSendFodderStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCSendFodderStandardInfo getCCSendFodderStandardInfo(String oql) throws BOSException, EASBizException;
    public CCSendFodderStandardCollection getCCSendFodderStandardCollection() throws BOSException;
    public CCSendFodderStandardCollection getCCSendFodderStandardCollection(EntityViewInfo view) throws BOSException;
    public CCSendFodderStandardCollection getCCSendFodderStandardCollection(String oql) throws BOSException;
}