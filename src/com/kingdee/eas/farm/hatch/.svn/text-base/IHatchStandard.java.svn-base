package com.kingdee.eas.farm.hatch;

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

public interface IHatchStandard extends IDataBase
{
    public HatchStandardInfo getHatchStandardInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchStandardInfo getHatchStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchStandardInfo getHatchStandardInfo(String oql) throws BOSException, EASBizException;
    public HatchStandardCollection getHatchStandardCollection() throws BOSException;
    public HatchStandardCollection getHatchStandardCollection(EntityViewInfo view) throws BOSException;
    public HatchStandardCollection getHatchStandardCollection(String oql) throws BOSException;
    public void audit(HatchStandardInfo model) throws BOSException, EASBizException;
    public void unAudit(HatchStandardInfo model) throws BOSException, EASBizException;
}