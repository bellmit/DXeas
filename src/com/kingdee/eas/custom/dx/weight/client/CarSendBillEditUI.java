/**
 * output package name
 */
package com.kingdee.eas.custom.dx.weight.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class CarSendBillEditUI extends AbstractCarSendBillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CarSendBillEditUI.class);
    private boolean isLoadField=false;
    /**
     * output class constructor
     */
    public CarSendBillEditUI() throws Exception
    {
        super();
    }
    @Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
	}
	/**
     * output loadFields method
     */
    public void loadFields()
    {
    	isLoadField=true;
        super.loadFields();
        isLoadField=false;
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.prmtdriver.setDisplayFormat("$drivername$");		
        this.prmtdriver.setEditFormat("$drivername$");		
        this.prmtdriver.setCommitFormat("$drivername$");
		this.prmtstaplesupplier.setDisplayFormat("$name$");		
        this.prmtstaplesupplier.setEditFormat("$number$");		
        this.prmtstaplesupplier.setCommitFormat("$number$");	
		this.prmtcar.addDataChangeListener(new DataChangeListener(){	
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				prmtcar_Changeds();
			}		
		});
	    setTableToSumField(kdtEntrysS, new String[] {"Dweight", "Pweight"});//数组中传入要统计的列
    }
    private void prmtcar_Changeds() {
		// TODO Auto-generated method stub
    	CarInfo carinfo;
		try {
			carinfo = CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK( ((CarInfo)prmtcar.getValue()).getId().toString()));
			CarEntryCollection cc = carinfo.getEntry();
			
			CarEntryInfo ceinfo = cc.get(0);	
			if(ceinfo.getDriverID()!=null){
	    		prmtdriver.setValue(ceinfo.getDriverID());
	    	}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

//    /**
//	 * 添加合计行
//	 */
//	private void appendSumRow() {
//		// TODO Auto-generated method stub
//		ArrayList<String> arrayList=new ArrayList<String>();
//		arrayList.add("qty");
//		arrayList.add("wgt");
//		apendFootRow(kdtEntrys,(String []) arrayList.toArray(new String[arrayList.size()]));
//		ArrayList<String> arrayLists=new ArrayList<String>();
//		arrayLists.add("Dweight");
//		arrayLists.add("Pweight");
//		apendFootRow(kdtEntrysS,(String []) arrayLists.toArray(new String[arrayLists.size()]));
//	}
	
	

//	@Override
//	protected void setTableToSumField() {
//	    super.setTableToSumField();
//	    setTableToSumField(kdtEntrysS, new String[] {"Dweight", "Pweight"});//数组中传入要统计的列
//	}

	
	
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.weight.CarSendBillFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.weight.CarSendBillInfo objectValue = new com.kingdee.eas.custom.dx.weight.CarSendBillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        Date date = new Date();
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        c.add(Calendar.DAY_OF_MONTH, 1); 
        date = c.getTime();
        objectValue.setBizDate(date);
    
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }

}