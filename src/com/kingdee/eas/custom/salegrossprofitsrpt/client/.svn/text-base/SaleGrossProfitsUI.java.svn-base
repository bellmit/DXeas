/**
 * output package name
 */
package com.kingdee.eas.custom.salegrossprofitsrpt.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.util.IUIActionPostman;
import com.kingdee.bos.ctrl.kdf.headfootdesigner.HeadFootModel;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.ctrl.kdf.util.style.Styles;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.commonquery.IQuerySolutionFacade;
import com.kingdee.eas.base.commonquery.QueryPanelInfo;
import com.kingdee.eas.base.commonquery.QuerySolutionFacadeFactory;
import com.kingdee.eas.base.commonquery.QuerySolutionInfo;
import com.kingdee.eas.base.commonquery.client.CustomerParams;
import com.kingdee.eas.base.commonquery.client.CustomerQueryPanel;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salegrossprofitsrpt.SaleGrossProfitsFactory;
import com.kingdee.eas.custom.salegrossprofitsrpt.SaleReportClassificationEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.RequestContext;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptParamsUtil;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.scm.common.client.SCMBillFilterUI;
import com.kingdee.eas.scm.common.util.PrecisionUtil;
import com.kingdee.eas.scm.sd.sale.SaleInvoiceInfo;
import com.kingdee.eas.scm.sd.sale.report.client.SaleGrossProfitsConditionUI;
import com.kingdee.eas.scm.sd.sale.util.SaleUtil;
import com.kingdee.eas.util.client.EASResource;


public class SaleGrossProfitsUI extends AbstractSaleGrossProfitsUI
{
	private static final Logger logger = CoreUIObject.getLogger(SaleGrossProfitsUI.class);

	private static final int defaultCurrencyPercision = 4;
	private boolean isCreateTempTable = false;

	private int levelCount = 1;

	private List totalColLst = null;

	private SaleGrossProfitsConditionUI conditionUI = null;

	private boolean isShowStat = false;

	public SaleGrossProfitsUI() throws Exception {
		this.tblMain.checkParsed();
		this.tblMain.getDataRequestManager().addDataRequestListener(this);
		this.tblMain.getDataRequestManager().setDataRequestMode(1);
		enableExportExcel(this.tblMain);
		this.tblMain.getStyleAttributes().setLocked(true);
	}

	protected boolean enableTablePreferences() {
		return true;
	}

	protected KDTable getTableForPrintSetting() {
		return this.tblMain;
	}

	protected RptParams getParamsForInit() {
		return null;
	}

	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
		return null;
	}

	protected CustomerQueryPanel getCustomerQueryPanel() throws Exception {
		if (this.conditionUI == null) {
			this.conditionUI = new SaleGrossProfitsConditionUI();
		}
		return this.conditionUI;
	}

	public void beforePrint() {
		logUIOperation("LOG_SALEGROSSPROFITS");
	}

	private void logUIOperation(String key) {
		String operName = EASResource.getString(
				"com.kingdee.eas.scm.sd.sale.report.SDReportResource", key);
		IObjectPK pk = LogUtil.beginLog(null, operName, new SaleInvoiceInfo()
				.getBOSType(), null, operName);
		LogUtil.afterLog(null, pk);
	}

	protected void query() {
		this.isCreateTempTable = false;
		this.tblMain.removeColumns();
		this.tblMain.removeRows();
		initUserConfig();
	}

	public Object getTablePreferenceSchemaKey() {
		Object object = null;
		if ((this.queryDialog != null)
				&& (this.queryDialog.getCurrentSolutionInfo() != null)) {
			object = this.queryDialog.getCurrentSolutionInfo().getId();
		}
		return object;
	}

	public void getData(KDTDataRequestEvent e) {
		this.tblMain.getDataRequestManager().removeDataRequestListener(this);
		try {
			int from = e.getFirstRow();
			int len = e.getLastRow() - from + 1;
			RptParams pp = new RptParams();
			if (!(this.isCreateTempTable)) {
				pp.setString("tempTable", getTempTable());
				pp.putAll(this.params.toMap());
				RptParams rpt = SaleGrossProfitsFactory.getRemoteInstance()
						.createTempTable(pp);
				setTempTable(rpt.getString("tempTable"));

				logger.info(EASResource.getString(
						"com.kingdee.eas.scm.sd.sale.SALEAutoGenerateResource",
						"65_SaleGrossProfitsUI")
						+ rpt.getString("tempTable"));
				this.levelCount = rpt.getInt("levelCount");
				RptTableHeader header = createHead();
				this.totalColLst = null;
				this.tblMain.removeHeadRows();

				KDTableUtil.setHeader(header, this.tblMain);

				if (!(this.params.getBoolean("ckBxShowMShortName"))) {
					int freezeCol = this.tblMain
							.getColumnIndex("fmaterialShortName");
					if (freezeCol != -1) {
						this.tblMain.getColumn(freezeCol).getStyleAttributes()
								.setHided(true);
						this.tblMain.getColumn(freezeCol).setWidth(-1);
					}
				}

				if (this.params.getBoolean("AuxiliaryProperties")) {
					int freezeCol = this.tblMain
							.getColumnIndex("FassistPropertyName");
					if (freezeCol != -1)
						this.tblMain.getColumn(freezeCol).getStyleAttributes()
								.setHided(false);
				} else {
					int freezeCol = this.tblMain
							.getColumnIndex("FassistPropertyName");
					if (freezeCol != -1) {
						this.tblMain.getColumn(freezeCol).getStyleAttributes()
								.setHided(true);
					}
				}
				this.tblMain.setRowCount(rpt.getInt("rowCount"));

				setFiledPression(rpt);
			} else {
				pp.putAll(this.params.toMap());
			}

			pp.setString("tempTable", getTempTable());
			pp.setInt("levelCount", this.levelCount);
			RptParams rpt = SaleGrossProfitsFactory.getRemoteInstance().query(
					pp, from, len);
			RptRowSet rs = (RptRowSet) rpt.getObject("rowset");

			KDTableUtil.insertRows(rs, from, this.tblMain);

			String curPrecision = PrecisionUtil.getFormatString(4);

			this.tblMain.getStyleAttributes().setLocked(true);

			this.tblMain.getColumn("FSaleIncome").getStyleAttributes()
					.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);
			this.tblMain.getColumn("FSaleIncome").getStyleAttributes()
					.setNumberFormat(curPrecision);

			this.tblMain.getColumn("FSaleCost").getStyleAttributes()
					.setNumberFormat(curPrecision);
			this.tblMain.getColumn("FSaleCost").getStyleAttributes()
					.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);

			this.tblMain.getColumn("FSaleProfit").getStyleAttributes()
					.setNumberFormat(curPrecision);
			this.tblMain.getColumn("FSaleProfit").getStyleAttributes()
					.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);

			this.tblMain.getColumn("FSaleProfitRate").getStyleAttributes()
					.setNumberFormat("%r-{#,##0.00%*}f");
			this.tblMain.getColumn("FSaleProfitRate").getStyleAttributes()
					.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);

			this.tblMain.getColumn("FQtyPrecision").getStyleAttributes()
					.setHided(true);
			this.tblMain.getColumn("FSaleQty").getStyleAttributes()
					.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);
			this.tblMain.getColumn("FOutQty").getStyleAttributes()
					.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);
			this.tblMain.getColumn("FAvgSalePrice").getStyleAttributes()
			.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);

			if (this.isShowStat) {
				this.tblMain.getColumn("FstatSaleProfit").getStyleAttributes()
						.setNumberFormat(curPrecision);
				this.tblMain.getColumn("FstatSaleProfit").getStyleAttributes()
						.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);

				this.tblMain.getColumn("FUnitSaleProfit").getStyleAttributes()
						.setNumberFormat(curPrecision);
				this.tblMain.getColumn("FUnitSaleProfit").getStyleAttributes()
						.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);

				this.tblMain.getColumn("FstatSaleQty").getStyleAttributes()
						.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);
				this.tblMain.getColumn("FstatOutQty").getStyleAttributes()
						.setHorizontalAlign(Styles.HorizontalAlignment.RIGHT);
			}
			setQtyPrecision(this.tblMain, e.getFirstRow(), e.getLastRow());
		} catch (Exception ex) {
			handleException(ex);
		}
		if (!(this.isCreateTempTable)) {
			initUserConfig();
			this.isCreateTempTable = true;

			if (!(this.params.getBoolean("ckBxShowMShortName"))) {
				int freezeCol = this.tblMain
						.getColumnIndex("fmaterialShortName");
				if (freezeCol != -1) {
					this.tblMain.getColumn(freezeCol).getStyleAttributes()
							.setHided(true);
					this.tblMain.getColumn(freezeCol).setWidth(-1);
				}
			}
		}
		this.tblMain.getDataRequestManager().addDataRequestListener(this);
	}

	private void setFiledPression(RptParams rpt) {
		boolean SaleQtyFlag = rpt.getBoolean("SaleQty");
		boolean OutQtyFlag = rpt.getBoolean("OutQty");
		boolean SaleIncomeFlag = rpt.getBoolean("SaleIncome");
		boolean SaleCostFlag = rpt.getBoolean("SaleCost");
		boolean SaleProfitFlag = rpt.getBoolean("SaleProfit");
		boolean SaleProfitRateFlag = rpt.getBoolean("SaleProfitRate");
		int FSaleQty = this.tblMain.getColumnIndex("FSaleQty");
		int FStatSaleQty = this.tblMain.getColumnIndex("FstatSaleQty");
		int FOutQty = this.tblMain.getColumnIndex("FOutQty");
		int FStatOutQty = this.tblMain.getColumnIndex("FstatOutQty");
		int FSaleIncome = this.tblMain.getColumnIndex("FSaleIncome");
		int FSaleCost = this.tblMain.getColumnIndex("FSaleCost");
		int FSaleProfit = this.tblMain.getColumnIndex("FSaleProfit");
		int FSaleProfitRate = this.tblMain.getColumnIndex("FSaleProfitRate");
		int FstatSaleProfitRate = this.tblMain
				.getColumnIndex("FstatSaleProfit");
		int FstatUnitSaleProfitRate = this.tblMain
				.getColumnIndex("FUnitSaleProfit");

		int colWith = 128;
		if (!(SaleQtyFlag)) {
			if (FSaleQty != -1) {
				this.tblMain.getColumn(FSaleQty).setWidth(-1);
				this.tblMain.getColumn(FSaleQty).getStyleAttributes().setHided(
						true);
			}
			if (FStatSaleQty != -1) {
				this.tblMain.getColumn(FStatSaleQty).setWidth(-1);
				this.tblMain.getColumn(FStatSaleQty).getStyleAttributes()
						.setHided(true);
			}
		} else {
			this.tblMain.getColumn(FSaleQty).setWidth(colWith);
			this.tblMain.getColumn(FSaleQty).getStyleAttributes().setHided(
					false);
			if (FStatSaleQty != -1) {
				this.tblMain.getColumn(FStatSaleQty).setWidth(colWith);
				this.tblMain.getColumn(FStatSaleQty).getStyleAttributes()
						.setHided(false);
			}
		}
		if (!(OutQtyFlag)) {
			if (FOutQty != -1) {
				this.tblMain.getColumn(FOutQty).setWidth(-1);
				this.tblMain.getColumn(FOutQty).getStyleAttributes().setHided(
						true);
			}
			if (FStatOutQty != -1) {
				this.tblMain.getColumn(FStatOutQty).setWidth(-1);
				this.tblMain.getColumn(FStatOutQty).getStyleAttributes()
						.setHided(true);
			}
		} else {
			this.tblMain.getColumn(FOutQty).setWidth(colWith);
			this.tblMain.getColumn(FOutQty).getStyleAttributes()
					.setHided(false);
			if (FStatOutQty != -1) {
				this.tblMain.getColumn(FStatOutQty).setWidth(colWith);
				this.tblMain.getColumn(FStatOutQty).getStyleAttributes()
						.setHided(false);
			}
		}
		if (!(SaleIncomeFlag)) {
			if (FSaleIncome != -1) {
				this.tblMain.getColumn(FSaleIncome).setWidth(-1);
				this.tblMain.getColumn(FSaleIncome).getStyleAttributes()
						.setHided(true);
			}
		} else {
			this.tblMain.getColumn(FSaleIncome).setWidth(100);
			this.tblMain.getColumn(FSaleIncome).getStyleAttributes().setHided(
					false);
		}
		if (!(SaleCostFlag)) {
			if (FSaleCost != -1) {
				this.tblMain.getColumn(FSaleCost).setWidth(-1);
				this.tblMain.getColumn(FSaleCost).getStyleAttributes()
						.setHided(true);
			}
		} else {
			this.tblMain.getColumn(FSaleCost).setWidth(100);
			this.tblMain.getColumn(FSaleCost).getStyleAttributes().setHided(
					false);
		}
		if (!(SaleProfitFlag)) {
			if (FSaleProfit != -1) {
				this.tblMain.getColumn(FSaleProfit).setWidth(-1);
				this.tblMain.getColumn(FSaleProfit).getStyleAttributes()
						.setHided(true);
			}
		} else {
			this.tblMain.getColumn(FSaleProfit).setWidth(100);
			this.tblMain.getColumn(FSaleProfit).getStyleAttributes().setHided(
					false);
		}
		if (!(SaleProfitRateFlag)) {
			if (FSaleProfitRate != -1) {
				this.tblMain.getColumn(FSaleProfitRate).setWidth(-1);
				this.tblMain.getColumn(FSaleProfitRate).getStyleAttributes()
						.setHided(true);
			}
			if (FstatSaleProfitRate != -1) {
				this.tblMain.getColumn(FstatSaleProfitRate).setWidth(-1);
				this.tblMain.getColumn(FstatSaleProfitRate)
						.getStyleAttributes().setHided(true);
			}
			if (FstatUnitSaleProfitRate != -1) {
				this.tblMain.getColumn(FstatUnitSaleProfitRate).setWidth(-1);
				this.tblMain.getColumn(FstatUnitSaleProfitRate)
						.getStyleAttributes().setHided(true);
			}
		} else {
			this.tblMain.getColumn(FSaleProfitRate).setWidth(100);
			this.tblMain.getColumn(FSaleProfitRate).getStyleAttributes()
					.setHided(false);
			if (FstatSaleProfitRate != -1) {
				this.tblMain.getColumn(FstatSaleProfitRate).setWidth(colWith);
				this.tblMain.getColumn(FstatSaleProfitRate)
						.getStyleAttributes().setHided(false);
			}
			if (FstatUnitSaleProfitRate != -1) {
				this.tblMain.getColumn(FstatUnitSaleProfitRate).setWidth(
						colWith);
				this.tblMain.getColumn(FstatUnitSaleProfitRate)
						.getStyleAttributes().setHided(false);
			}
		}
	}

	protected boolean showQueryDialog(boolean useDefaultSolution) {
		CustomerParams cp = null;
		try {
			initQueryDialog();

			this.userPanel.getUIContext().clear();
			this.userPanel.getUIContext().putAll(getUIContext());
			if (useDefaultSolution) {
				IQuerySolutionFacade iQuery = QuerySolutionFacadeFactory
						.getRemoteInstance();
				String queryName = MetaDataLoaderFactory
						.getRemoteMetaDataLoader().getQuery(
								getQueryMetaDataPK()).getFullName();
				if (iQuery.hasDefaultSolution(getMetaDataPK().getFullName(),
						queryName)) {
					QuerySolutionInfo solution = iQuery.getDefaultSolution(
							getMetaDataPK().getFullName(), queryName);
					QueryPanelInfo qpi = solution.getQueryPanelInfo().get(0);
					if (qpi != null) {
						try {
							cp = CustomerParams.getCustomerParams2(qpi
									.getCustomerParams());
						} catch (Exception e) {
							handleException(e);

							logger.error(e);
						}
					}
				}
			}

			boolean ok = false;
			if ((cp == null) || (!(useDefaultSolution))) {
				this.conditionUI.onShow();
				if (this.queryDialog.show()) {
					SCMBillFilterUI rbqp = (SCMBillFilterUI) this.queryDialog
							.getUserPanel(0);
					this.params = rbqp.getCustomCondition();
					ok = true;
				}
			}
			if (cp != null) {
				SCMBillFilterUI rbqp = (SCMBillFilterUI) getCustomerQueryPanel();
				rbqp.setCustomerParams(cp);
				rbqp.loadData(null);
				this.params = rbqp.getCustomCondition();
			}

			if ((this.params != null) && (((ok) || (useDefaultSolution)))) {
				queryWithWrap();
				return true;
			}
		} catch (Exception e) {
			logger.error("@showQueryDialog", e);
			handleException(e);
		}
		return false;
	}

	private void initQueryDialog() throws Exception {
		if (this.userPanel == null) {
			this.userPanel = getCustomerQueryPanel();
			this.userPanel.loadFields();

			Dimension dd = this.userPanel.getSize();
			this.queryDialog.setWidth(dd.width);
			this.queryDialog.setHeight(580);
			this.queryDialog.addUserPanel(this.userPanel);
			this.queryDialog.setOwner((Component) getUIContext().get("Owner"));

			this.queryDialog.setTitle(this.userPanel.getUITitle());
			this.queryDialog.setQueryObjectPK(getQueryMetaDataPK());

			this.queryDialog.setShowFilter(false);
			this.queryDialog.setShowSorter(false);
			this.queryDialog.setParentUIClassName(super.getClass().getName());

			Method m = this.userPanel.getClass().getMethod("onInit",
					new Class[] { RptParams.class });

			m.invoke(this.userPanel, new Object[] { getUIContextInitParams() });
			this.userPanel.initLayout();
			if (this.params != null)
				this.userPanel
						.setCustomerParams(RptParamsUtil.setToCustomerParams(
								new CustomerParams(), this.params));
		}
	}

	private void setQtyPrecision(KDTable table, int fromRow, int toRow) {
		String subLabel = EASResource.getString(
				"com.kingdee.eas.scm.sd.sale.report.SDReportResource",
				"SUB_STRING");

		toRow = Math.min(table.getRowCount(), toRow + 1);
		int precision = Integer.valueOf(
				this.params.getObject("spnPrecision").toString()).intValue();

		int qtyprecision = Integer.valueOf(
				this.params.getObject("qtyPrecision").toString()).intValue();
		int amountPrecision1 = Integer.valueOf(
				this.params.getObject("amountPrecision1").toString())
				.intValue();
		int amountPrecision2 = Integer.valueOf(
				this.params.getObject("amountPrecision2").toString())
				.intValue();
		SaleReportClassificationEnum classficationType = SaleReportClassificationEnum
				.getEnum(new Integer(this.params.getString("classification"))
						.intValue());
		for (int row = fromRow; row < toRow; ++row) {
			if ((classficationType
					.equals(SaleReportClassificationEnum.customer))
					|| (classficationType
							.equals(SaleReportClassificationEnum.materialGroup))
					|| (classficationType
							.equals(SaleReportClassificationEnum.customerGroup))
					|| (classficationType
							.equals(SaleReportClassificationEnum.customerPlusMaterGroup))
					|| (classficationType
							.equals(SaleReportClassificationEnum.materGroupPlusCustomer))
					|| (classficationType
							.equals(SaleReportClassificationEnum.saleorder))
					|| (classficationType
							.equals(SaleReportClassificationEnum.salecontract))) {
				if (precision != 0) {
					String qtyPrecisionString = PrecisionUtil
							.getFormatString(precision);

					table.getCell(row, "FSaleQty").getStyleAttributes()
							.setNumberFormat(qtyPrecisionString);
					table.getCell(row, "FOutQty").getStyleAttributes()
							.setNumberFormat(qtyPrecisionString);

					if (this.isShowStat) {
						table.getCell(row, "FstatSaleQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);
						table.getCell(row, "FstatOutQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);
					}
				} else {
					Object qtyPre = table.getCell(row, "FQtyPrecision")
							.getValue();
					if (qtyPre != null) {
						int qtyPrecision = Integer.parseInt(qtyPre.toString());
						String qtyPrecisionString = PrecisionUtil
								.getFormatString(qtyPrecision);
						table.getCell(row, "FSaleQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);
						table.getCell(row, "FOutQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);

						if (this.isShowStat) {
							table.getCell(row, "FstatSaleQty")
									.getStyleAttributes().setNumberFormat(
											qtyPrecisionString);
							table.getCell(row, "FstatOutQty")
									.getStyleAttributes().setNumberFormat(
											qtyPrecisionString);
						}
					}
				}

				if (amountPrecision1 != 0) {
					String amountPrecisionString = PrecisionUtil
							.getFormatString(amountPrecision1);
					table.getCell(row, "FSaleIncome").getStyleAttributes()
							.setNumberFormat(amountPrecisionString);
					table.getCell(row, "FSaleCost").getStyleAttributes()
							.setNumberFormat(amountPrecisionString);
					table.getCell(row, "FSaleProfit").getStyleAttributes()
							.setNumberFormat(amountPrecisionString);

					if (this.isShowStat) {
						table.getCell(row, "FUnitSaleProfit")
								.getStyleAttributes().setNumberFormat(
										amountPrecisionString);
						table.getCell(row, "FstatSaleProfit")
								.getStyleAttributes().setNumberFormat(
										amountPrecisionString);
					}
				}
			} else {
				if (qtyprecision != 0) {
					String qtyPrecisionString = PrecisionUtil
							.getFormatString(qtyprecision);
					table.getCell(row, "FSaleQty").getStyleAttributes()
							.setNumberFormat(qtyPrecisionString);
					table.getCell(row, "FOutQty").getStyleAttributes()
							.setNumberFormat(qtyPrecisionString);

					if (this.isShowStat) {
						table.getCell(row, "FstatSaleQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);
						table.getCell(row, "FstatOutQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);
					}
				} else {
					Object qtyPre = table.getCell(row, "FQtyPrecision")
							.getValue();
					if (qtyPre != null) {
						int qtyPrecision = Integer.parseInt(qtyPre.toString());
						String qtyPrecisionString = PrecisionUtil
								.getFormatString(qtyPrecision);
						table.getCell(row, "FSaleQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);
						table.getCell(row, "FOutQty").getStyleAttributes()
								.setNumberFormat(qtyPrecisionString);

						if (this.isShowStat) {
							table.getCell(row, "FstatSaleQty")
									.getStyleAttributes().setNumberFormat(
											qtyPrecisionString);
							table.getCell(row, "FstatOutQty")
									.getStyleAttributes().setNumberFormat(
											qtyPrecisionString);
						}
					}
				}

				if (amountPrecision2 != 0) {
					String amountPrecisionString = PrecisionUtil
							.getFormatString(amountPrecision2);
					table.getCell(row, "FSaleIncome").getStyleAttributes()
							.setNumberFormat(amountPrecisionString);
					table.getCell(row, "FSaleCost").getStyleAttributes()
							.setNumberFormat(amountPrecisionString);
					table.getCell(row, "FSaleProfit").getStyleAttributes()
							.setNumberFormat(amountPrecisionString);

					if (this.isShowStat) {
						table.getCell(row, "FUnitSaleProfit")
								.getStyleAttributes().setNumberFormat(
										amountPrecisionString);
						table.getCell(row, "FstatSaleProfit")
								.getStyleAttributes().setNumberFormat(
										amountPrecisionString);
					}

				}

			}

			Iterator iterator = getTotalColName().iterator();
			while (iterator.hasNext()) {
				String colName = (String) iterator.next();
				Object value = table.getCell(row, colName).getValue();
				if ((value != null)
						&& (value.toString().trim().equals(subLabel))) {
					IRow tRow = table.getRow(row);
					Color necessaryColor = new Color(252, 251, 223);
					tRow.getStyleAttributes().setBackground(necessaryColor);
				}
			}
		}
	}

	private RptTableHeader createHead() {
		String materialNum = SaleUtil.getReportUIResource("materialNumber");
		String materialName = SaleUtil.getReportUIResource("materialName");
		String shortName = SaleUtil.getReportUIResource("MaterialShortName");
		String model = SaleUtil.getReportUIResource("materialModel");
		String baseUnit = SaleUtil.getReportUIResource("baseUnit");
		String saleQty = SaleUtil.getReportUIResource("saleQty");
		String outQty = SaleUtil.getReportUIResource("storageQty");
		String saleQtyUnit = SaleUtil.getReportUIResource("saleQtyUnit");
		String outQtyUnit = SaleUtil.getReportUIResource("storageQtyUnit");
		String statUnit = SaleUtil.getReportUIResource("statUnit");
		String statSaleQty = SaleUtil.getReportUIResource("statSaleQty");
		String statOutQty = SaleUtil.getReportUIResource("statStorageQty");
		String saleIncome = SaleUtil.getReportUIResource("saleIncome");
		String saleCost = SaleUtil.getReportUIResource("saleCost");
		String saleProfit = SaleUtil.getReportUIResource("saleProfit");
		String statSaleProfit = SaleUtil.getReportUIResource("statSaleProfit");
		String unitProfit = SaleUtil.getReportUIResource("unitSaleProfit");
		String materialClassification = SaleUtil
				.getReportUIResource("materialClassfication");
		String customerNum = SaleUtil.getReportUIResource("customerNumber");
		String customerName = SaleUtil.getReportUIResource("customerName");
		String customerClassfication = SaleUtil
				.getReportUIResource("customerClassfication");
		String saleProfitRate = SaleUtil.getReportUIResource("saleProfitRate");
		String saleOrderNo = SaleUtil.getReportUIResource("saleOrderNo");
		String saleContractNo = SaleUtil.getReportUIResource("saleContractNo");
		String deptName = SaleUtil.getReportUIResource("adminunitName");
		String salePersonNum = SaleUtil.getReportUIResource("salePersonNumber");
		String salePersonName = SaleUtil.getReportUIResource("salePersonName");

		String assistProperty = SaleUtil.getReportUIResource("assistProperty");
		String avgSalePrice = "平均售价";

		SaleReportClassificationEnum classficationType = SaleReportClassificationEnum
				.getEnum(new Integer(this.params.getString("classification"))
						.intValue());

		StringBuffer colsMGBuff = new StringBuffer();

		StringBuffer labelMGBuff = new StringBuffer();
		for (int i = 0; i < this.levelCount; ++i) {
			labelMGBuff.append(String.valueOf(i + 1) + materialClassification);
			labelMGBuff.append(",");
			colsMGBuff.append("FGroup" + String.valueOf(i + 1));
			colsMGBuff.append(",");
		}

		StringBuffer colsCGBuff = new StringBuffer();

		StringBuffer labelCGBuff = new StringBuffer();
		for (int i = 0; i < this.levelCount; ++i) {
			labelCGBuff.append(String.valueOf(i + 1) + customerClassfication);
			labelCGBuff.append(",");
			colsCGBuff.append("FGroup" + String.valueOf(i + 1));
			colsCGBuff.append(",");
		}

		RptTableHeader header = new RptTableHeader();

		this.isShowStat = false;
		StringBuffer cols = new StringBuffer();
		StringBuffer labels = new StringBuffer();

		if (classficationType.equals(SaleReportClassificationEnum.material)) {
			this.isShowStat = true;
			if (this.params.getBoolean("AuxiliaryProperties")) {
				cols
						.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
				labels.append(materialNum).append(",").append(materialName)
						.append(",").append(shortName).append(",")
						.append(model).append(",").append(assistProperty)
						.append(",").append("FQtyPrecision").append(",")
						.append(baseUnit).append(",");
			} else {
				cols
						.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
				labels.append(materialNum).append(",").append(materialName)
						.append(",").append(shortName).append(",")
						.append(model).append(",").append("FQtyPrecision")
						.append(",").append(baseUnit).append(",");
			}

		} else if (classficationType
				.equals(SaleReportClassificationEnum.customer)) {
			cols.append("fcustomerNumber,fcustomerName,FQtyPrecision,");
			labels.append(customerNum).append(",").append(customerName).append(
					",FQtyPrecision,");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialGroup)) {
			cols.append(colsMGBuff).append("FQtyPrecision,");
			labels.append(labelMGBuff).append("FQtyPrecision,");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerGroup)) {
			cols.append(colsCGBuff).append("FQtyPrecision,");
			labels.append(labelCGBuff).append("FQtyPrecision,");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustGroup)) {
			this.isShowStat = true;
			if (this.params.getBoolean("AuxiliaryProperties")) {
				cols
						.append(
								"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,")
						.append(colsCGBuff);
				labels.append(materialNum).append(",").append(materialName)
						.append(",").append(shortName).append(",")
						.append(model).append(",").append(assistProperty)
						.append(",").append("FQtyPrecision").append(",")
						.append(baseUnit).append(",").append(labelCGBuff);
			} else {
				cols
						.append(
								"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,")
						.append(colsCGBuff);
				labels.append(materialNum).append(",").append(materialName)
						.append(",").append(shortName).append(",")
						.append(model).append(",").append("FQtyPrecision")
						.append(",").append(baseUnit).append(",").append(
								labelCGBuff);
			}

		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustomer)) {
			this.isShowStat = true;
			if (this.params.getBoolean("AuxiliaryProperties")) {
				cols
						.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,fcustomerNumber,fcustomerName,");
				labels.append(materialNum).append(",").append(materialName)
						.append(",").append(shortName).append(",")
						.append(model).append(",").append(assistProperty)
						.append(",").append("FQtyPrecision").append(",")
						.append(baseUnit).append(",").append(customerNum)
						.append(",").append(customerName).append(",");
			} else {
				cols
						.append("fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,fcustomerNumber,fcustomerName,");
				labels.append(materialNum).append(",").append(materialName)
						.append(",").append(shortName).append(",")
						.append(model).append(",").append("FQtyPrecision")
						.append(",").append(baseUnit).append(",").append(
								customerNum).append(",").append(customerName)
						.append(",");
			}

		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusmaterial)) {
			this.isShowStat = true;
			if (this.params.getBoolean("AuxiliaryProperties")) {
				cols
						.append("fcustomerNumber,fcustomerName,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
				labels.append(customerNum).append(",").append(customerName)
						.append(",").append(materialNum).append(",").append(
								materialName).append(",").append(shortName)
						.append(",").append(model).append(",").append(
								assistProperty).append(",").append(
								"FQtyPrecision").append(",").append(baseUnit)
						.append(",");
			} else {
				cols
						.append("fcustomerNumber,fcustomerName,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
				labels.append(customerNum).append(",").append(customerName)
						.append(",").append(materialNum).append(",").append(
								materialName).append(",").append(shortName)
						.append(",").append(model).append(",").append(
								"FQtyPrecision").append(",").append(baseUnit)
						.append(",");
			}

		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterGroup)) {
			cols.append("fcustomerNumber,fcustomerName,FQtyPrecision,").append(
					colsMGBuff);
			labels.append(customerNum).append(",").append(customerName).append(
					",FQtyPrecision,").append(labelMGBuff);
		} else if (classficationType
				.equals(SaleReportClassificationEnum.custGroupPlusMaterial)) {
			this.isShowStat = true;
			if (this.params.getBoolean("AuxiliaryProperties")) {
				cols
						.append(colsCGBuff)
						.append(
								"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");

				labels.append(labelCGBuff).append(materialNum).append(",")
						.append(materialName).append(",").append(shortName)
						.append(",").append(model).append(",").append(
								assistProperty).append(",").append(
								"FQtyPrecision").append(",").append(baseUnit)
						.append(",");
			} else {
				cols
						.append(colsCGBuff)
						.append(
								"fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");

				labels.append(labelCGBuff).append(materialNum).append(",")
						.append(materialName).append(",").append(shortName)
						.append(",").append(model).append(",").append(
								"FQtyPrecision").append(",").append(baseUnit)
						.append(",");
			}

		} else if (classficationType
				.equals(SaleReportClassificationEnum.materGroupPlusCustomer)) {
			cols.append(colsMGBuff).append(
					"fcustomerNumber,fcustomerName,FQtyPrecision,");
			labels.append(labelMGBuff).append(customerNum).append(",").append(
					customerName).append(",FQtyPrecision,");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.saleorder)) {
			cols.append("fsoNumber,FQtyPrecision,");
			labels.append(saleOrderNo).append(",FQtyPrecision,");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.salecontract)) {
			cols.append("fscNumber,FQtyPrecision,");
			labels.append(saleContractNo).append(",FQtyPrecision,");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.departmentplusmaterial)) {
			this.isShowStat = true;
			if (this.params.getBoolean("AuxiliaryProperties")) {
				cols
						.append("fadminunitName,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
				labels.append(deptName).append(",").append(materialNum).append(
						",").append(materialName).append(",").append(shortName)
						.append(",").append(model).append(",").append(
								assistProperty).append(",").append(
								"FQtyPrecision").append(",").append(baseUnit)
						.append(",");
			} else {
				cols
						.append("fadminunitName,fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
				labels.append(deptName).append(",").append(materialNum).append(
						",").append(materialName).append(",").append(shortName)
						.append(",").append(model).append(",").append(
								"FQtyPrecision").append(",").append(baseUnit)
						.append(",");
			}

		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterPerson)) {
			this.isShowStat = true;
			if (this.params.getBoolean("AuxiliaryProperties")) {
				cols.append("fSalePersonNumber,fsalePersonName");
				cols.append(",fcustomerNumber,fcustomerName");
				cols
						.append(",fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FassistPropertyName,FQtyPrecision,baseUnitName,");
				labels.append(salePersonNum).append(",");
				labels.append(salePersonName).append(",");
				labels.append(customerNum).append(",");
				labels.append(customerName).append(",");
				labels.append(materialNum).append(",");
				labels.append(materialName).append(",");
				labels.append(shortName).append(",");
				labels.append(model).append(",");
				labels.append(assistProperty).append(",");
				labels.append("FQtyPrecision").append(",");
				labels.append(baseUnit).append(",");
			} else {
				cols.append("fSalePersonNumber,fsalePersonName");
				cols.append(",fcustomerNumber,fcustomerName");
				cols
						.append(",fmaterialNum,fmaterialName,fmaterialShortName,Fmodel,FQtyPrecision,baseUnitName,");
				labels.append(salePersonNum).append(",");
				labels.append(salePersonName).append(",");
				labels.append(customerNum).append(",");
				labels.append(customerName).append(",");
				labels.append(materialNum).append(",");
				labels.append(materialName).append(",");
				labels.append(shortName).append(",");
				labels.append(model).append(",");
				labels.append("FQtyPrecision").append(",");
				labels.append(baseUnit).append(",");
			}

		}

		if (this.isShowStat) {
			cols
					.append("FSaleQty,FOutQty,statUnitName,FstatSaleQty,FstatOutQty,FAvgSalePrice,FSaleIncome,FSaleCost,FSaleProfit,FSaleProfitRate,FUnitSaleProfit,FstatSaleProfit");
			labels.append(saleQtyUnit).append(",").append(outQtyUnit).append(
					",").append(statUnit).append(",").append(statSaleQty)
					.append(",").append(statOutQty).append(",").append(avgSalePrice).append(",").append(
							saleIncome).append(",").append(saleCost)
					.append(",").append(saleProfit).append(",").append(
							saleProfitRate).append(",").append(unitProfit)
					.append(",").append(statSaleProfit);
		} else {
			cols
					.append("FSaleQty,FOutQty,FAvgSalePrice,FSaleIncome,FSaleCost,FSaleProfit,FSaleProfitRate");
			labels.append(saleQty).append(",").append(outQty).append(",").append(avgSalePrice).append(",")
					.append(saleIncome).append(",").append(saleCost)
					.append(",").append(saleProfit).append(",").append(
							saleProfitRate);
		}

		setHeaderColumns(header, cols.toString().split(","));
		header.setLabels(new Object[][] { labels.toString().split(",") });

		return header;
	}

	private List getTotalColName() {
		if (this.totalColLst != null) {
			return this.totalColLst;
		}

		this.totalColLst = new ArrayList();

		SaleReportClassificationEnum classficationType = SaleReportClassificationEnum
				.getEnum(new Integer(this.params.getString("classification"))
						.intValue());

		if (classficationType.equals(SaleReportClassificationEnum.material)) {
			this.totalColLst.add("fmaterialNum");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customer)) {
			this.totalColLst.add("fcustomerNumber");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialGroup)) {
			for (int i = this.levelCount; i >= 1; --i) {
				this.totalColLst.add("FGroup" + String.valueOf(i));
			}
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerGroup)) {
			for (int i = this.levelCount; i >= 1; --i)
				this.totalColLst.add("FGroup" + String.valueOf(i));
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustGroup)) {
			for (int i = 1; i <= this.levelCount; ++i) {
				this.totalColLst.add("FGroup" + String.valueOf(i));
			}
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materialPlusCustomer)) {
			this.totalColLst.add("fcustomerNumber");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusmaterial)) {
			this.totalColLst.add("fmaterialNum");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterGroup)) {
			for (int i = 1; i <= this.levelCount; ++i) {
				this.totalColLst.add("FGroup" + String.valueOf(i));
			}
		} else if (classficationType
				.equals(SaleReportClassificationEnum.custGroupPlusMaterial)) {
			this.totalColLst.add("fmaterialNum");
			for (int i = this.levelCount; i >= 1; --i) {
				this.totalColLst.add("FGroup" + String.valueOf(i));
			}
		} else if (classficationType
				.equals(SaleReportClassificationEnum.materGroupPlusCustomer)) {
			this.totalColLst.add("fcustomerNumber");
			for (int i = this.levelCount; i >= 1; --i)
				this.totalColLst.add("FGroup" + String.valueOf(i));
		} else if (classficationType
				.equals(SaleReportClassificationEnum.saleorder)) {
			this.totalColLst.add("fsoNumber");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.salecontract)) {
			this.totalColLst.add("fscNumber");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.departmentplusmaterial)) {
			this.totalColLst.add("fmaterialNum");
		} else if (classficationType
				.equals(SaleReportClassificationEnum.customerPlusMaterPerson)) {
			this.totalColLst.add("fcustomerNumber");
			this.totalColLst.add("fmaterialNum");
		}

		return this.totalColLst;
	}

	private void setHeaderColumns(RptTableHeader header, String[] columns) {
		RptTableColumn col = null;
		int i = 0;
		for (int c = columns.length; i < c; ++i) {
			col = new RptTableColumn(columns[i]);
			if ((columns[i].equals("FSaleQty"))
					|| (columns[i].equals("FOutQty"))
					|| (columns[i].equals("FstatSaleQty"))
					|| (columns[i].equals("FstatOutQty"))
					|| (columns[i].equals("FUnitSaleProfit"))
					|| (columns[i].equals("FstatSaleProfit"))) {
				col.setWidth(128);
			} else
				col.setWidth(-1);

			header.addColumn(col);
		}
	}

	protected ICommRptBase getRemoteInstance() throws BOSException {
		return SaleGrossProfitsFactory.getRemoteInstance();
	}

	protected void preparePrintPageHeader(HeadFootModel header) {
	}

	protected Map preparePrintVariantMap() {
		return null;
	}

	protected String getUIFullName() {
		return "com.kingdee.eas.scm.sd.sale.report.client.SaleGrossProfitsUI";
	}

	public boolean isAsynchronism() {
		return true;
	}

	protected SystemEnum getSystemEnumForOA() {
		return SystemEnum.PURCHASINGMANAGEMENT;
	}

	public boolean isPrepareInit() {
		return true;
	}

	public IUIActionPostman prepareInit() {
		IUIActionPostman clientHanlder = super.prepareInit();
		if (clientHanlder != null) {
			RequestContext request = new RequestContext();
			CompanyOrgUnitInfo company = (CompanyOrgUnitInfo) SysContext
					.getSysContext().getCurrentOrgUnit(OrgType.Company);
			request.put("company", company);
			String currentCtrlUnitId = SysContext.getSysContext()
					.getCurrentCtrlUnit().getId().toString();
			String cuNumber = SysContext.getSysContext().getCurrentCtrlUnit()
					.getLongNumber();
			request.put("CurrentCtrlUnit", currentCtrlUnitId);
			request.put("cuNumber", cuNumber);

			clientHanlder.setRequestContext(request);
		}
		return clientHanlder;
	}

}