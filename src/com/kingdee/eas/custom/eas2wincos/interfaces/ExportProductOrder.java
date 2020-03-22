package com.kingdee.eas.custom.eas2wincos.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.eas2wincos.comm.EASWUtils;
import com.kingdee.eas.custom.eas2wincos.comm.WinCosUtils;
import com.kingdee.eas.mm.basedata.BomEntryFactory;
import com.kingdee.eas.mm.mo.IManufactureOrder;
import com.kingdee.eas.mm.mo.ManufactureOrderCollection;
import com.kingdee.eas.mm.mo.ManufactureOrderFactory;
import com.kingdee.eas.mm.mo.ManufactureOrderInfo;
import com.kingdee.eas.mm.mo.ManufactureOrderStockInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.util.NumericExceptionSubItem;

public class ExportProductOrder implements IExport2WinCos {

	@Override
	public String export2WinCos(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		Connection conn = null;
		try {
			companyID=EASWUtils.getCompanyIDByNumber(ctx, companyID);
			conn= EASWUtils.getWinCosConnection(ctx,companyID);//�õ�����
			if(conn==null) {
				throw new Exception("��ȷ�����Ӳ���������ȷ!");
			}
			conn.setAutoCommit(false);
			
			IManufactureOrder ips = ManufactureOrderFactory.getLocalInstance(ctx);
			EntityViewInfo ev = new EntityViewInfo();
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id", companyID, CompareType.EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("baseStatus", BillBaseStatusEnum.AUDITED_VALUE, CompareType.EQUALS));
			if(StringUtils.isBlank(beginDate)&&StringUtils.isBlank(endDate)) {//�����ʼ���ںͽ������ڶ�Ϊ��  ����Ϊ�������˵��ã�Ĭ��Ϊ��ǰҵ������
				filter.getFilterItems().add(new FilterItemInfo("auditTime", new java.util.Date(), CompareType.EQUALS));
			}else {
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				filter.getFilterItems().add(new FilterItemInfo("auditTime", format.parse(beginDate+" 00:00:00"), CompareType.GREATER_EQUALS));
				filter.getFilterItems().add(new FilterItemInfo("auditTime", format.parse(endDate+" 23:59:59"), CompareType.LESS_EQUALS));
			}
			ev.setFilter(filter);
			SorterItemCollection sorter = new SorterItemCollection();
			sorter.add(new SorterItemInfo("bizDate"));
			ev.setSorter(sorter);
			ManufactureOrderCollection coll = ips.getManufactureOrderCollection(ev);
			if (coll == null || coll.size() <= 0) {
				return null;
			}
			//ִ�в����Ԥ���뷽��
			PreparedStatement ptm=null;
			int billHeadID=0;
			Boolean isSuccess=false;
			String msg=null;
			String billID=null;
			ManufactureOrderInfo orderInfo;
			ManufactureOrderStockInfo orderEntryInfo;
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add(new SelectorItemInfo("*"));
			slor.add(new SelectorItemInfo("material.*"));
			slor.add(new SelectorItemInfo("entry.*"));
			slor.add(new SelectorItemInfo("entry.material.*"));
			for (int index = 0; index < coll.size(); index++) {
				try{
					orderInfo = ips.getManufactureOrderInfo(new ObjectUuidPK(coll.get(index).getString("id")),slor);
					billID=orderInfo.getString("id");
					isSuccess=true;
					msg=null;
					if (WinCosUtils.checkHasExported(conn, getWinCosHeadTable(), orderInfo.getId().toString(),null)>0) {
						continue;
					}
					
					ptm = conn.prepareStatement(getInsertHeadSql());//�����ͷ
					
					ptm.setString(1, orderInfo.getNumber());
					ptm.setString(2,"");//���κ�
					ptm.setInt(3, 0);//��������
					ptm.setString(4, orderInfo.getMaterial().getNumber());//���� ����
					ptm.setString(5, orderInfo.getMaterial().getName());
					ptm.setString(6, orderInfo.getDescription());
					ptm.setBigDecimal(7, orderInfo.getQty());//�ֿ�
					ptm.setBigDecimal(8, orderInfo.getBaseQty());
					ptm.setBigDecimal(9, BigDecimal.ZERO);
					ptm.setBigDecimal(10, BigDecimal.ZERO);//������
					ptm.setString(11,orderInfo.getId().toString());
					ptm.setDate(12, new java.sql.Date(new java.util.Date().getTime()));
					ptm.execute();
					billHeadID=WinCosUtils.checkHasExported(conn, getWinCosHeadTable(), orderInfo.getId().toString(),null);//��ѯ����ͷid
					ptm = conn.prepareStatement(getInsertEntrySql());//�������
					// �Ѿ����벻�����µ���
					for(int j=0;j<orderInfo.getStocks().size();j++) {
						orderEntryInfo=orderInfo.getStocks().get(j);
						ptm.setInt(1, billHeadID);//����ͷid
						ptm.setString(2, orderEntryInfo.getMaterial().getNumber());//
						ptm.setString(3, orderEntryInfo.getMaterial().getName());//
						ptm.setString(4, orderEntryInfo.getRemark());//
						ptm.setInt(5, orderEntryInfo.getOperationNo());//
						ptm.setBoolean(6,false);//�Ƿ�����
						ptm.setBigDecimal(7, getFromBom(ctx, orderEntryInfo.getBomEntryID()));//���İٷֱ�
						ptm.setBigDecimal(8, orderEntryInfo.getQty());//��������
						ptm.setString(9,orderInfo.getId().toString()); 
						ptm.setString(10, orderEntryInfo.getId().toString());
						ptm.setDate(11, new java.sql.Date(new java.util.Date().getTime()));
						ptm.execute();
						//��eas�в��뵼����¼
						//insertHasExported(ctx, purInfo.getBOSType().toString(), purInfo.getId().toString(), purEntryInfo.getId().toString());
					}
					conn.commit();
				}catch(Exception ee) {
					isSuccess=false;
					msg=ee.getMessage();
					try {
						if(conn!=null&&!conn.isClosed()) {
							conn.rollback();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				finally{ 
					EASWUtils.insertLogs(ctx, getBosType(), billID, 0, EASWUtils.Direction_Export, isSuccess, msg);//������־
				}
			}
			if(ptm!=null)
				ptm.close();
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		}
		finally{
			try {
				if(conn!=null&&!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public String export2WinCosByID(Context ctx, String companyNum, String billID) throws EASBizException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * ����BOM��¼�õ����İٷֱ�
	 * @param bomEntryID
	 * @return
	 */
	private BigDecimal getFromBom(Context ctx,String bomEntryID) {
		BigDecimal result=BigDecimal.ZERO;
		try {
			if(StringUtils.isBlank(bomEntryID)) {
				return result;
			}
			result=BomEntryFactory.getLocalInstance(ctx).getBomEntryInfo(new ObjectUuidPK(bomEntryID)).getConsumeFixQty();
		}catch(Exception e){}
		return result;
	}
	
	
	@Override
	public String getInsertEntrySql() {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(getWinCosEntryTable()).append(" (");
		sql.append(" Order,ProductIdent,ProductName,Description,Position,");
		sql.append(" IsCarrier,Percentage,WeightTarget,CreationDate,AppString02,");
		sql.append(" AppString03");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?");
		sql.append(" )");
		return sql.toString();
	}

	@Override
	public String getInsertHeadSql() {
		StringBuffer sql=new StringBuffer();
		sql.append(" insert into ").append(getWinCosHeadTable()).append(" ( ");
		sql.append(" Ident,BatchIdent,ProductType,ProductIdent,ProductName,");
		sql.append(" Description,WeightTarget,BlendPackSize,InnERPackSize,ProductBestBeforeLifetime,");
		sql.append(" MixingTime,PreMixingTime,MaxBatchWeight,CanBeUsedForRemix,ButtsAdditionAllowed,");
		sql.append(" ApplyPlantProductionOverage,SubstitutionsAllowed,AppString02,CreationDate");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,");
		sql.append(" ?,?,?,?,?,");
		sql.append(" 0,0,0,0,0,");
		sql.append(" 0,0,0,?,?");
		sql.append(" )");
		return sql.toString();
	}

	@Override
	public String getWinCosEntryTable() {
		// TODO Auto-generated method stub
		return "ERPOrderIngredient";
	}

	@Override
	public String getWinCosHeadTable() {
		// TODO Auto-generated method stub
		return "ERPProcessOrderHead";
	}

	@Override
	public String getBosType() {
		return "1D0D80DD";
	}

}
