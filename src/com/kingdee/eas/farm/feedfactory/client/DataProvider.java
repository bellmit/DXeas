package com.kingdee.eas.farm.feedfactory.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.data.datasource.BOSQueryDataSource;
import com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.jdbc.rowset.IRowSet;


public class DataProvider implements BOSQueryDelegate {

	private static final Logger logger = CoreUIObject
			.getLogger(DataProvider.class);
	private String billId;

	public DataProvider(String billId) {
		this.billId = billId;
	}

	public IRowSet execute(BOSQueryDataSource ds) {
		//
		IRowSet rs = null;
		//
		try {
			IQueryExecutor iqec = null;
			FilterInfo filterInfo = new FilterInfo();
			EntityViewInfo viewInfo = new EntityViewInfo();
			if (ds.getID().equals("FeedFactoryTruckPlanQuery.bos-query")) {
				iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK(
						"com.kingdee.eas.farm.feedfactory.app",
						"FeedFactoryTruckPlanQuery"));
				filterInfo.getFilterItems().add(
						new FilterItemInfo("id", this.billId,
								CompareType.EQUALS));
				viewInfo.setFilter(filterInfo);
				iqec.setObjectView(viewInfo);
				iqec.option().isAutoTranslateBoolean = true;
				iqec.option().isAutoTranslateEnum = true;
				//
				rs = iqec.executeQuery();
			}else if (ds.getID().equals("FFTruckPlanTruckPrintQuery.bos-query")) {
				iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK(
						"com.kingdee.eas.farm.feedfactory.app",
						"FFTruckPlanTruckPrintQuery"));
				filterInfo.getFilterItems().add(
						new FilterItemInfo("id", this.billId,
								CompareType.EQUALS));
				viewInfo.setFilter(filterInfo);
				iqec.setObjectView(viewInfo);
				iqec.option().isAutoTranslateBoolean = true;
				iqec.option().isAutoTranslateEnum = true;
				//
				rs = iqec.executeQuery();
			}else if (ds.getID().equals("FeedFactoryTruckPlanQuery")) {
				iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK(
						"com.kingdee.eas.farm.feedfactory.app",
						"FeedFactoryTruckPlanQuery"));
				filterInfo.getFilterItems().add(
						new FilterItemInfo("id", this.billId,
								CompareType.EQUALS));
				viewInfo.setFilter(filterInfo);
				iqec.setObjectView(viewInfo);
				iqec.option().isAutoTranslateBoolean = true;
				iqec.option().isAutoTranslateEnum = true;
				//
				rs = iqec.executeQuery();
			}else if (ds.getID().equals("FFTruckPlanTruckPrintQuery")) {
				iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK(
						"com.kingdee.eas.farm.feedfactory.app",
						"FFTruckPlanTruckPrintQuery"));
				filterInfo.getFilterItems().add(
						new FilterItemInfo("id", this.billId,
								CompareType.EQUALS));
				viewInfo.setFilter(filterInfo);
				iqec.setObjectView(viewInfo);
				iqec.option().isAutoTranslateBoolean = true;
				iqec.option().isAutoTranslateEnum = true;
				//
				rs = iqec.executeQuery();
			}else if (ds.getID().equals("FFTruckPlanTruckEntryQuery")) {
				iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK(
						"com.kingdee.eas.farm.feedfactory.app",
						"FFTruckPlanTruckEntryQuery"));
				filterInfo.getFilterItems().add(
						new FilterItemInfo("parent.id", this.billId,
								CompareType.EQUALS));
				viewInfo.setFilter(filterInfo);
				iqec.setObjectView(viewInfo);
				iqec.option().isAutoTranslateBoolean = true;
				iqec.option().isAutoTranslateEnum = true;
				//
				rs = iqec.executeQuery();
			} else {
				logger.info("==============∆‰À˚÷¥––£¨ds.getID()====" + ds.getID());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		int rowcount = rs.size();
		logger.info("rs.size====" + rowcount);
		return rs;
	}

}
