package com.kingdee.eas.farm.breed;

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

public interface IResidueSetTree extends ITreeBase
{
    public ResidueSetTreeInfo getResidueSetTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ResidueSetTreeInfo getResidueSetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ResidueSetTreeInfo getResidueSetTreeInfo(String oql) throws BOSException, EASBizException;
    public ResidueSetTreeCollection getResidueSetTreeCollection() throws BOSException;
    public ResidueSetTreeCollection getResidueSetTreeCollection(EntityViewInfo view) throws BOSException;
    public ResidueSetTreeCollection getResidueSetTreeCollection(String oql) throws BOSException;
}