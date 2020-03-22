package com.kingdee.eas.farm.breed;

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

public interface IResidueSet extends IDataBase
{
    public ResidueSetInfo getResidueSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ResidueSetInfo getResidueSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ResidueSetInfo getResidueSetInfo(String oql) throws BOSException, EASBizException;
    public ResidueSetCollection getResidueSetCollection() throws BOSException;
    public ResidueSetCollection getResidueSetCollection(EntityViewInfo view) throws BOSException;
    public ResidueSetCollection getResidueSetCollection(String oql) throws BOSException;
}