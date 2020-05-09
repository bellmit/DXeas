package com.kingdee.eas.outinterface.base;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.bos.framework.*;
import javax.activation.DataHandler;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

public interface IOutAppInterface extends IBizCtrl
{
    public String getData(String jarrayStr) throws BOSException, EASBizException;
    public String uploadData(String jarrayStr) throws BOSException, EASBizException;
    public String getList(String jarrayStr) throws BOSException, EASBizException;
    public String uploadAttachment(String jarrayStr) throws BOSException, EASBizException;
    public String getAttachment(String jarrayStr) throws BOSException, EASBizException;
    public String deleteAttachment(String jarrayStr) throws BOSException, EASBizException;
    public String uploadAttachment(DataHandler handler, String jarrayStr) throws BOSException;
    public String chekPwd(String jarrayStr) throws BOSException, EASBizException;
    public String getAttachmentList(String jsonStr) throws BOSException, EASBizException;
    public String auditData(String jarrayStr) throws BOSException, EASBizException;
    public String unAuditData(String jarrayStr) throws BOSException, EASBizException;
    public String deleteData(String jarrayStr) throws BOSException, EASBizException;
    public String getEnumInfo(String jarrayStr) throws BOSException, EASBizException;
    public String exeFunction(String jsonStr) throws BOSException, EASBizException;
    public String getDataByNum(String jarrayStr) throws BOSException, EASBizException;
    public String updateData(String jsonStr) throws BOSException, EASBizException;
}