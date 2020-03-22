/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.ctrl.kdf.data.datasource.BOSQueryDataSource;
import com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.IIDList;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class StatementOfAccountListUI extends AbstractStatementOfAccountListUI
{
	private static final Logger logger = CoreUIObject.getLogger(StatementOfAccountListUI.class);

	/**
	 * output class constructor
	 */
	public StatementOfAccountListUI() throws Exception
	{
		super();
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
		return com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.StatementOfAccountInfo();

		return objectValue;
	}



	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//super.actionPrintPreview_actionPerformed(e);
		ArrayList<String> list = this.getSelectedIdValues();
		String id;
		for(int i = 0;i < list.size();i++){
			id = list.get(i);
			DataProvider data = new DataProvider(id);
			KDNoteHelper appHlp = new KDNoteHelper();
			appHlp.printPreview("/bim/farm/stocking/processbizill/StatementOfAccount", data, javax.swing.SwingUtilities.getWindowAncestor(this));
		}
	}

	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {checkSelected();
	ArrayList<String> list = this.getSelectedIdValues();
	String id;
	for(int i = 0;i < list.size();i++){
		id = list.get(i);
		DataProvider data = new DataProvider(id);
		KDNoteHelper appHlp = new KDNoteHelper();
		appHlp.print("/bim/farm/stocking/processbizill/StatementOfAccount", data, javax.swing.SwingUtilities.getWindowAncestor(this));
	}
	}

	public class DataProvider implements BOSQueryDelegate {

		private String billId;

		public DataProvider(String billId) {
			this.billId = billId;
		}

		public IRowSet execute(BOSQueryDataSource ds) {
			IRowSet rs = null;
			try {
				IQueryExecutor iqec = null;
				FilterInfo filterInfo = new FilterInfo();
				EntityViewInfo viewInfo = new EntityViewInfo();
				if (ds.getID().equals("StatementOfAccountQuery.bos-query")) {
					iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK("com.kingdee.eas.farm.stocking.processbizill.app",
					"StatementOfAccount.bos-query"));
					
					IMetaDataLoader loader = MetaDataLoaderFactory.getRemoteMetaDataLoader();
					EntityObjectInfo eo = loader.getEntity(BOSObjectType.create((new StatementOfAccountInfo()).getBOSType().toString()));
					String queryInfo = eo.getExtendedProperty("defaultF7Query");
					IMetaDataPK pk=new MetaDataPK(queryInfo);
					IQueryExecutor exec = QueryExecutorFactory.getRemoteInstance(pk);
					
					
					filterInfo.getFilterItems().add(new FilterItemInfo("id", this.billId, CompareType.EQUALS));
					viewInfo.setFilter(filterInfo);
					exec.setObjectView(viewInfo);
					exec.option().isAutoTranslateBoolean = true;
					exec.option().isAutoTranslateEnum = true;
					rs = exec.executeQuery();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			int rowcount = rs.size();
			logger.info("rs.size====" + rowcount);
			return rs;
		}
	}

}