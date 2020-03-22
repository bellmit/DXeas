package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IAssessmentMeasure extends ICoreBillBase
{
    public AssessmentMeasureCollection getAssessmentMeasureCollection() throws BOSException;
    public AssessmentMeasureCollection getAssessmentMeasureCollection(EntityViewInfo view) throws BOSException;
    public AssessmentMeasureCollection getAssessmentMeasureCollection(String oql) throws BOSException;
    public AssessmentMeasureInfo getAssessmentMeasureInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AssessmentMeasureInfo getAssessmentMeasureInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AssessmentMeasureInfo getAssessmentMeasureInfo(String oql) throws BOSException, EASBizException;
    public void audit(AssessmentMeasureInfo model) throws BOSException;
    public void unaudit(AssessmentMeasureInfo model) throws BOSException;
}