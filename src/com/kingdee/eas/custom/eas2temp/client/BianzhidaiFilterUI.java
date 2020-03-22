/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.client;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.StorageF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.report.util.RptParams;

/**
 * output class name
 */
public class BianzhidaiFilterUI extends AbstractBianzhidaiFilterUI
{
    private static final Logger logger = CoreUIObject.getLogger(BianzhidaiFilterUI.class);
    
    /**
     * output class constructor
     */
    public BianzhidaiFilterUI() throws Exception
    {
        super();
        this.setUITitle("编织袋报表过滤条件");
        
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
	    Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH)+1;
        String date1=year+"-"+month+"-"+"1";
        SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd");
        this.kDDatePicker1.setValue(spf.parse(date1));
		  StorageF7 sf7 = new StorageF7();
			sf7.setIsCUFilter(true);
			this.prmtstorageUnitOrg.setSelector(sf7);
			this.prmtstorageUnitOrg.setValue(SysContext.getSysContext()
					.getCurrentStorageUnit());
	}

	@Override
	public RptParams getCustomCondition() {
		// TODO Auto-generated method stub
		RptParams pp=new RptParams();
		String cuID=null;
		String cuNumber=null;
		String dateFrom=null;
		String dateTo=null;
		boolean onlyShowSum=false;
		if(this.prmtstorageUnitOrg.getValue()!=null){
			cuID=((StorageOrgUnitInfo)this.prmtstorageUnitOrg.getValue()).getId().toString();
			cuNumber=((StorageOrgUnitInfo)this.prmtstorageUnitOrg.getValue()).getNumber();
		}
		if(this.kDDatePicker1.getText()!=null){
			dateFrom=this.kDDatePicker1.getText();
		}
		if(this.kDDatePicker2.getText()!=null){
			dateTo=this.kDDatePicker2.getText();
		}
		if(this.kDCheckBox1.isSelected()){
			onlyShowSum=true;
		}
			
		pp.setString("cuID",cuID);
		pp.setString("cuNumber", cuNumber);
		pp.setString("dateFrom", dateFrom);
		pp.setString("dateTo", dateTo);
		pp.setBoolean("onlyShowSum", onlyShowSum);
		return pp;
	}

	@Override
	public void onInit(RptParams arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCustomCondition(RptParams arg0) {
		// TODO Auto-generated method stub
		
	}

}