package com.kingdee.eas.custom.salepayment;

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

public interface ISalerStimulateSetTree extends ITreeBase
{
    public SalerStimulateSetTreeInfo getSalerStimulateSetTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SalerStimulateSetTreeInfo getSalerStimulateSetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SalerStimulateSetTreeInfo getSalerStimulateSetTreeInfo(String oql) throws BOSException, EASBizException;
    public SalerStimulateSetTreeCollection getSalerStimulateSetTreeCollection() throws BOSException;
    public SalerStimulateSetTreeCollection getSalerStimulateSetTreeCollection(EntityViewInfo view) throws BOSException;
    public SalerStimulateSetTreeCollection getSalerStimulateSetTreeCollection(String oql) throws BOSException;
}