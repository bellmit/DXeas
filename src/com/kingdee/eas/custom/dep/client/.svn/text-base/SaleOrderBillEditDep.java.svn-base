package com.kingdee.eas.custom.dep.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.IUIFactory;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.ChannelTypeInfo;
import com.kingdee.eas.basedata.assistant.CityFactory;
import com.kingdee.eas.basedata.assistant.CityInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.ICity;
import com.kingdee.eas.basedata.assistant.IProvince;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PaymentTypeInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.ProvinceFactory;
import com.kingdee.eas.basedata.assistant.ProvinceInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.master.cssp.CustomerCompanyInfoCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerCompanyInfoFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoFactory;
import com.kingdee.eas.basedata.master.material.IMultiMeasureUnit;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitCollection;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.common.DeliveryTypeFactory;
import com.kingdee.eas.basedata.scm.common.DeliveryTypeInfo;
import com.kingdee.eas.basedata.scm.common.IDeliveryType;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.CommonMethod;
import com.kingdee.eas.custom.ResultInfo;
//import com.kingdee.eas.custom.costcontrol.CostCountFacadeFactory;
//import com.kingdee.eas.custom.costcontrol.ICostCountFacade;
//import com.kingdee.eas.custom.other.LoaningCustomerFactory;
//import com.kingdee.eas.custom.other.LoaningCustomerInfo;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.salediscount.DiscountCompanyInfo;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.custom.salediscount.DiscountGridLogEntryInfo;
import com.kingdee.eas.custom.salediscount.IDiscountFacade;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.feemanager.basedata.DriverFactory;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.credit.CreditAnalysisRptFacadeFactory;
import com.kingdee.eas.scm.credit.ICreditAnalysisRptFacade;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sd.sale.client.CustomerCreditBean;
import com.kingdee.eas.scm.sd.sale.client.SaleOrderEditUI;
import com.kingdee.eas.scm.sd.sale.client.SaleOrderEditUIPIEx;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * œ˙ €∂©µ• ±‡º≠ dep
 * @author Administrator
 *
 */
public class SaleOrderBillEditDep {


//	/**************************************–¬’€»√ÃÌº”¬ﬂº≠  wgj 20150804 end***************************************************/
public static void afterLoadFieldsAddDataChangeListener(final UIParam param){
	param.getKDBizPromptBox("prmtOrderCustomer").addDataChangeListener(new DataChangeListener(){

		@Override
		public void dataChanged(DataChangeEvent paramDataChangeEvent) {
			// TODO Auto-generated method stub
			if(param.getKDBizPromptBox("prmtOrderCustomer").getValue()!=null){
				CustomerInfo info = (CustomerInfo) param.getKDBizPromptBox("prmtOrderCustomer").getValue();
				ICity ic;
				IProvince ip;
				try {
					ic = CityFactory.getRemoteInstance();
					CityInfo cityInfo = ic.getCityInfo(new ObjectUuidPK(info.getCity().getId().toString()));
					ip = ProvinceFactory.getRemoteInstance();
					ProvinceInfo provinceInfo = ip.getProvinceInfo(new ObjectUuidPK(info.getProvince().getId().toString()));
					param.getKDBizPromptBox("prmtprovince").setValue(provinceInfo);
					param.getKDBizPromptBox("prmtCity").setValue(cityInfo);
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
	DeliveryTypeInfo type;
	try {
		type = DeliveryTypeFactory.getRemoteInstance().getDeliveryTypeInfo(new ObjectUuidPK("521733ca-0105-1000-e000-00e2c0a8123362E9EE3F"));
		param.getKDBizPromptBox("prmtDeliveryType").setValue(type);
	} catch (EASBizException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (BOSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
