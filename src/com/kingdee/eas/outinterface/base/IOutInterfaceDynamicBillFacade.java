package com.kingdee.eas.outinterface.base;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.outinterface.base.utils.IDynamicDeal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.util.*;

public interface IOutInterfaceDynamicBillFacade extends IBizCtrl
{
    public JSONObject getDataByID(String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException;
    public JSONObject uploadDataByBosType(String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException;
    public JSONObject getBillList(String jsonStr) throws BOSException, EASBizException;
    public JSONObject getEumInfo(String jsonStr) throws BOSException, EASBizException;
    public JSONObject exeFunciton(String jsonStr) throws BOSException, EASBizException;
    public JSONObject uploadData(String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException;
    public JSONObject deleteData(String jsonStr) throws BOSException, EASBizException;
    public JSONObject uploadAttachment(String jsonStr) throws BOSException, EASBizException;
    public JSONObject getAttachmentList(String jsonStr) throws BOSException, EASBizException;
    public JSONObject getAttachmentData(String jsonStr) throws BOSException, EASBizException;
    public JSONObject deleteAttachment(String jsonStr) throws BOSException, EASBizException;
    public JSONObject getRptData(String jsonStr) throws BOSException, EASBizException;
    public JSONObject getDataByNumber(String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException;
    public JSONObject updateData(String jsonStr) throws BOSException, EASBizException;
}