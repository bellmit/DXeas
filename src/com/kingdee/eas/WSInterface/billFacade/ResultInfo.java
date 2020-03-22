package com.kingdee.eas.WSInterface.billFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultInfo
    implements Serializable
{

    public ResultInfo()
    {
        status = 0;//0 ³É¹¦ 1Ê§°Ü
        billErrors = new ArrayList();
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public List getBillErrors()
    {
        return billErrors;
    }

    public void setBillErrors(List billErrors)
    {
        this.billErrors = billErrors;
    }

    private static final long serialVersionUID = 1L;
    private int status;
    private String msg;
    private List billErrors;
}