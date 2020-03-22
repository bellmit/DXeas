package com.kingdee.eas.farm.stocking.basedata;

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

public interface IBreedStandard extends IDataBase
{
    public BreedStandardInfo getBreedStandardInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedStandardInfo getBreedStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedStandardInfo getBreedStandardInfo(String oql) throws BOSException, EASBizException;
    public BreedStandardCollection getBreedStandardCollection() throws BOSException;
    public BreedStandardCollection getBreedStandardCollection(EntityViewInfo view) throws BOSException;
    public BreedStandardCollection getBreedStandardCollection(String oql) throws BOSException;
    public void audit(BreedStandardInfo model) throws BOSException, EASBizException;
    public void unAudit(BreedStandardInfo model) throws BOSException, EASBizException;
}