/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.weight.client;

import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.taihe.contract.BatchContractFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.contract.IBatchContract;
import com.kingdee.eas.custom.taihe.weight.CarSendBillFactory;
import com.kingdee.eas.custom.taihe.weight.CarSendBillInfo;
import com.kingdee.eas.custom.taihe.weight.ICarSendBill;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class CarcassEditUI extends AbstractCarcassEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(CarcassEditUI.class);
    
    /**
     * output class constructor
     */
    public CarcassEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        prmtsendCarNum.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtsendCarNum.getValue()!=null){
					String carsendID = ((CarSendBillInfo) prmtsendCarNum.getValue()).getId().toString();
					ICarSendBill ics;
					try {
						ics = CarSendBillFactory.getRemoteInstance();
						CarSendBillInfo info = ics.getCarSendBillInfo(new ObjectUuidPK(carsendID));
						if(info.getBatchContract()!=null){
							String batchContract = info.getBatchContract().getId().toString();
							IBatchContract ibc = BatchContractFactory.getRemoteInstance();
							BatchContractInfo bcInfo = ibc.getBatchContractInfo(new ObjectUuidPK(batchContract));
							txtmaterialNum.setText(bcInfo.getNumber());
						}
						
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}else{
					txtmaterialNum.setText(null);
				}
			}
        	
        });
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.weight.CarcassFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		contCreateTime.setVisible(true);
		CompanyF7 cf7=new CompanyF7();
		this.prmtcompany.setSelector(cf7);
		
		String Org = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		EntityViewInfo evInfo=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("company.id",Org,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("billStatus",4,CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("id","select distinct CFCarSendBillID from CT_SET_SettleBill",CompareType.NOTINNER));
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH,-1 );
		filterInfo.getFilterItems().add(new FilterItemInfo("bizDate",cal.getTime(),CompareType.GREATER_EQUALS));
		evInfo.setFilter(filterInfo);
		this.prmtsendCarNum.setEntityViewInfo(evInfo);
	}
	/**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.weight.CarcassInfo objectValue = new com.kingdee.eas.custom.taihe.weight.CarcassInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new java.util.Date());
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
        return objectValue;
    }
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
		String sendCarBillID="123";
		if(prmtsendCarNum.getValue()!=null) {
			sendCarBillID=((IPropertyContainer) prmtsendCarNum.getValue()).getString("id");
		}
		
		StringBuffer sql=new StringBuffer();
		sql.append(" select 1 from CT_WEI_Carcass")
		.append(" where CFSendCarNumID='").append(sendCarBillID).append("'");
		if(editData.getId()!=null) {
			sql.append(" and fid!='").append(editData.getString("id")).append("'")
			;
		}
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		if(rs.size()>0) {
			if(MsgBox.showConfirm2("该派车单已经填写胴体磅接收单，是否继续保存或提交？")!=MsgBox.YES){
				SysUtil.abort();
			}
		}
	}

}