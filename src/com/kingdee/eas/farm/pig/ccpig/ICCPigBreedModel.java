package com.kingdee.eas.farm.pig.ccpig;

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

public interface ICCPigBreedModel extends IDataBase
{
    public CCPigBreedModelInfo getCCPigBreedModelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCPigBreedModelInfo getCCPigBreedModelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCPigBreedModelInfo getCCPigBreedModelInfo(String oql) throws BOSException, EASBizException;
    public CCPigBreedModelCollection getCCPigBreedModelCollection() throws BOSException;
    public CCPigBreedModelCollection getCCPigBreedModelCollection(EntityViewInfo view) throws BOSException;
    public CCPigBreedModelCollection getCCPigBreedModelCollection(String oql) throws BOSException;
}