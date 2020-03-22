package com.kingdee.eas.custom.dep.client;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.CityFactory;
import com.kingdee.eas.basedata.assistant.CityInfo;
import com.kingdee.eas.basedata.assistant.ICity;
import com.kingdee.eas.basedata.assistant.IProvince;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerCompanyInfoCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerCompanyInfoFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerDeliveryAddress;
import com.kingdee.eas.basedata.master.cssp.CustomerDeliveryAddressFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoFactory;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitCollection;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.client.PrmtSelectorFactory;
import com.kingdee.util.IPropertyContainer;

public class SaleIssueBillEditDep {

	/**
	 * 加载完事件---实际上为afterLoadfields方法
	 * @param param
	 * @param e
	 * @throws Exception
	 */
	public  void AfterOnLoad(final UIParam param) throws Exception {
		param.getKDBizPromptBox("prmtSaleCustomer").setCommitFormat("$name$");
		//车辆选择
		param.getKDBizPromptBox("prmtcar").addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(param.getKDBizPromptBox("prmtcar").getValue()!=null){
					CarInfo carInfo=(CarInfo) param.getKDBizPromptBox("prmtcar").getValue();
					param.getKDTextField("txtcarNumber").setStringValue(carInfo.getNumber());
					param.getKDTextField("txtdriver").setStringValue(carInfo.getString("carOwner"));
				}else{
					param.getKDTextField("txtcarNumber").setStringValue(null);
					param.getKDTextField("txtdriver").setStringValue(null);
				}
			}

		});
		//车辆选择
		if(SysContext.getSysContext().getCurrentFIUnit()!=null){
			String saleOrgUnitID = UIRuleUtil.getProperty((IObjectValue) SysContext.getSysContext().getCurrentFIUnit(),"id").toString();
			HashSet<String> set=new HashSet<String>();
			EntityViewInfo evis=new EntityViewInfo();
			FilterInfo filters=new FilterInfo();
			filters.getFilterItems().add(new FilterItemInfo("companyOrgUnit",saleOrgUnitID,CompareType.EQUALS));
			evis.setFilter(filters);
			CustomerCompanyInfoCollection coll = CustomerCompanyInfoFactory.getRemoteInstance().getCustomerCompanyInfoCollection(evis);
			for(int i=0;i<coll.size();i++){
				set.add((UIRuleUtil.getProperty(coll.get(i).getCustomer(),"id").toString()));
			}
			EntityViewInfo evi=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			evi.setFilter(filter);
			param.getKDBizPromptBox("prmtSaleCustomer").setEntityViewInfo(evi);
		}
	}
	public static void afterLoadFieldsAddDataChangeListener(final UIParam param){
		param.getKDBizPromptBox("prmtCustomer").addDataChangeListener(new DataChangeListener(){

			@Override
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(param.getKDBizPromptBox("prmtCustomer").getValue()!=null){
					CustomerInfo info = (CustomerInfo) param.getKDBizPromptBox("prmtCustomer").getValue();
					ICity ic;
					IProvince ip;
					try {
						ic = CityFactory.getRemoteInstance();
						CityInfo cityInfo = ic.getCityInfo(new ObjectUuidPK(info.getCity().getId().toString()));
						ip = ProvinceFactory.getRemoteInstance();
						ProvinceInfo provinceInfo = ip.getProvinceInfo(new ObjectUuidPK(info.getProvince().getId().toString()));
						param.getKDBizPromptBox("prmtCity").setValue(cityInfo);
						param.getKDBizPromptBox("prmtprovince").setValue(provinceInfo);
						param.getKDTextField("txtAddress").setText(info.getAddress());
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		param.getKDBizPromptBox("prmtprovince").addDataChangeListener(new DataChangeListener(){

			@Override
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(param.getKDBizPromptBox("prmtprovince").getValue()!=null){
					String provinceNum=((IPropertyContainer)param.getKDBizPromptBox("prmtprovince").getValue()).getString("number");
					EntityViewInfo ev2=new EntityViewInfo();
					FilterInfo filter2=new FilterInfo();
					filter2.getFilterItems().add(new FilterItemInfo("province.number",provinceNum,CompareType.EQUALS));
					ev2.setFilter(filter2);
					param.getKDBizPromptBox("prmtCity").setEntityViewInfo(ev2);
				}
			}
			
		});
	}
	
}
