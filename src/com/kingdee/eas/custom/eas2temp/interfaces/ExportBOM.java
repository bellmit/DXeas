package com.kingdee.eas.custom.eas2temp.interfaces;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFacade;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.eas2temp.TargetSystem;
import com.kingdee.eas.custom.eas2temp.comm.EASWUtils;
import com.kingdee.eas.custom.eas2temp.comm.LogBean;
import com.kingdee.eas.custom.eas2temp.comm.TempUtils;
import com.kingdee.eas.mm.basedata.BomCollection;
import com.kingdee.eas.mm.basedata.BomEntryInfo;
import com.kingdee.eas.mm.basedata.BomFactory;
import com.kingdee.eas.mm.basedata.BomInfo;
import com.kingdee.eas.mm.basedata.IBom;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * BOM����
 * 
 * @author chuanyin
 * +
 */
public class ExportBOM implements IExport2Temp {

	
	public String export2TempByID(Context ctx, String companyID, String billID) throws EASBizException {
		Connection conn = null;
		Boolean isSuccess = false;
		String msg = null;
		BomInfo bomInfo = null;
		BomEntryInfo bomEntryInfo;
		try {
			conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.MUYANGSYSTEM_VALUE);// ����п�ϵͳ����
			if (conn == null) {
				throw new Exception("��ȷ���п�ϵͳ����������ȷ");
			}
			
			conn.setAutoCommit(false);
			// ִ�в����Ԥ���뷽��
			PreparedStatement ptm = null;
			try {

				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("material.*"));
				slor.add(new SelectorItemInfo("entrys.*"));
				slor.add(new SelectorItemInfo("entrys.material.*"));
				IBom ips = null;
				if(ctx!=null){
					ips=BomFactory.getLocalInstance(ctx);
				}else{
					ips=BomFactory.getRemoteInstance();
				}
				
				bomInfo = ips.getBomInfo(new ObjectUuidPK(billID), slor);
				String companyNum=bomInfo.getStorageOrgUnit().getNumber();
				
				//conn = EASWUtils.getTempConnection(ctx, companyID, TargetSystem.MUYANGSYSTEM_VALUE);// ���܇�g2����
				if (conn == null) {
					throw new Exception("��ȷ�����Ӳ���������ȷ");
				}
				conn.setAutoCommit(false);
				// ִ�в����Ԥ���뷽��
				
				//int materialID=TempUtils.returnTempMaterialID(ctx, conn, bomInfo.getMaterial(),"��Ʒ");//�������ϱ���
				String userName="";
				if(ctx==null) {
					userName=SysContext.getSysContext().getCurrentUserInfo().getName();
				}else{
					userName=ContextUtil.getCurrentUserInfo(ctx).getName();
				}
				
				//String tempBomID=TempUtils.returnTempBOMID(conn, billID);
				String tempBomID=TempUtils.returnTempBOMID(conn, bomInfo.getNumber());
				//���bom�Ѿ������
				if(tempBomID.equals("")) {
					//�����ͷ
					ptm=conn.prepareStatement(getInsertHeadSql());
					System.out.println("++++++++add+++++++");
				}else {
					//ɾ����¼
					ptm=conn.prepareStatement("delete from t_bomEntry where recipeNum='"+tempBomID+"'");
					ptm.execute();
					conn.commit();
					ptm.close();
					//���±�ͷ
					ptm=conn.prepareStatement(getUpdateHeadSql(tempBomID));
					System.out.println("++++++++update+++++++");
				}
				
				
				
				isSuccess = true;
				// ����һ������
				// �п�ϵͳ�Ĳ���
				// ��������ͷ
				StorageOrgUnitInfo storageOrgUnitInfo=bomInfo.getStorageOrgUnit();
				MaterialInfo minfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(bomInfo.getMaterial().getId().toString()));
				//String barMaterialNum=EASWUtils.getBarMaterialNumber(ctx, bomInfo.getMaterial(),storageOrgUnitInfo);//�������ϱ���
				MeasureUnitInfo measinfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(bomInfo.getUnit().getId().toString())); 
				Date date = new Date();
				java.sql.Date date1=new java.sql.Date(date.getTime()); 
				//ptm = conn.prepareStatement(getInsertHeadSql());
				//ptm.setString(1, bomInfo.getId().toString());// �䷽ʶ����
				ptm.setString(1, bomInfo.getNumber());// �䷽ʶ����
				ptm.setString(2, minfo.getNumber());// ��Ʒ���
				ptm.setString(3, bomInfo.getNumber());// �䷽��
				ptm.setString(4, bomInfo.getName());//�䷽��
				ptm.setString(5, "V1.0");// �䷽�汾
				ptm.setString(6, measinfo.getName());//������λ
				ptm.setBigDecimal(7,bomInfo.getProductQty() );//�䷽����
				ptm.setBigDecimal(8,bomInfo.getProductBaseQty());//�䷽����
				ptm.setDate(9,date1);//����ʱ��
				ptm.setString(10,bomInfo.getCreator().getName());// ������

				
				ptm.execute();
				ptm.close();
				String upsql = "update T_MM_Bom set cfisimbom = 1  where fid = '"+billID+"'";
				DbUtil.execute(ctx,upsql);	
				System.out.println("####################"+bomInfo.getName()+"�ѳɹ�����");
						 
				ArrayList<String> list=new ArrayList<String>();
				//String tempMaterialNum;
				// ���ﵼ���¼
				int entryCount=bomInfo.getEntrys().size();
				BigDecimal RGCLqty = BigDecimal.ZERO;
				for (int j = 0; j < entryCount-1; j++) {
					bomEntryInfo = bomInfo.getEntrys().get(j);
					
					if(EASWUtils.isNotExport(ctx,bomEntryInfo.getId().toString())){
						continue;
					}
					//tempMaterialNum=EASWUtils.getBarMaterialNumber(ctx ,bomEntryInfo.getMaterial(),storageOrgUnitInfo);
					//list.add(tempMaterialNum);
					MaterialInfo minfoe = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(bomEntryInfo.getMaterial().getId().toString()));

					
					MeasureUnitInfo measinfoe = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(bomEntryInfo.getUnit().getId().toString())); 

					ptm = conn.prepareStatement(getInsertEntrySql());// �������
					
					
					//ptm.setString(1, bomInfo.getId().toString());// �䷽ʶ����
					ptm.setString(1, bomInfo.getNumber());// �䷽ʶ����
					ptm.setString(2, minfoe.getNumber());// ԭ�ϱ���
					ptm.setString(3, measinfoe.getName() );//������λ
					BigDecimal rel = new BigDecimal(1000);
					BigDecimal pb = (bomEntryInfo.getConsumeFixQty().multiply(rel)).divide(bomInfo.getProductQty(),4,BigDecimal.ROUND_HALF_UP);
					ptm.setBigDecimal(4, bomEntryInfo.getConsumeFixQty());// ԭ������
					ptm.setBoolean(5, bomEntryInfo.getBoolean("iswt"));// �Ƿ���Ͷ						
					ptm.execute();
					ptm.close();
					}	
				conn.commit();
				// ��eas�в��뵼����¼
				//EASWUtils.insertHasExported(ctx, "BOM", bomInfo.getBOSType().toString(), bomInfo.getId().toString(), bomInfo
						//.getNumber());
			} catch (Exception ee) {
				isSuccess = false;
				msg = ee.getMessage();
				
				try {
					if (conn != null && !conn.isClosed()) {
						conn.rollback();
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				throw new EASBizException(new NumericExceptionSubItem("001", ee.getMessage()));
			} finally {
				LogBean logBean=new LogBean();
				logBean.setOrgUnitID(ContextUtil.getCurrentCtrlUnit(ctx).getId().toString());
				logBean.setBosType(bomInfo.getBOSType().toString());
				logBean.setEasBillID(billID);
				logBean.setDirection(LogBean.Direction_Export);
				logBean.setSuccess(isSuccess);
				logBean.setMsg(msg);
				//EASWUtils.insertLogs(ctx, logBean);// ������־
			}
			if (ptm != null){
				ptm.close();
			}
			
		} catch (Exception e) {
			throw new EASBizException(new NumericExceptionSubItem("001", e.getMessage()));
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	private String getBsmc(Context ctx,String bomentryID ,String colname) throws SQLException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select bsmc.FNumber,bsmc.CFBsmccode from t_mm_bomEntry be");
		sql.append(" inner join CT_CUS_Bsmc bsmc on be.CFBsmcID=bsmc.fid");
		sql.append(" where be.fid='").append(bomentryID);
		sql.append("'");
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql.toString());
		if(rs.next()){
			return rs.getString(colname);
		}} catch (BOSException e) {
			e.printStackTrace();
		}
		return null;
		
	}
 
	

	// �п�ϵͳbom����
	public String getTempHeadTable() {
		return "t_bom";
	}

	// �п�ϵͳ�м���¼����
	public String getTempEntryTable() {
		return "t_bomEntry";
	}

	// �п�ϵͳbomsql
	public String getInsertHeadSql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getTempHeadTable()).append(" ( ");
		sql.append(" recipeNum,productNum,number,name,version,unit,productQty,recipeBase,createTime,creator");// �䷽���,�䷽���ƣ�Ҳ��Ϊ��Ʒ���ƣ�,��Ӧ��Ʒ���, ��ע
		sql.append(" )values(");
		sql.append(" ?,?,?,?,?,?,?,?,?,?");
		sql.append(" )");
		return sql.toString();
	}

	// �п�ϵͳ��¼sql
	public String getInsertEntrySql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" insert into ").append(getTempEntryTable()).append(" (");
		sql.append(" recipeNum,materialnumber,unit,materialQty,outmaterial ");
		sql.append(" )values(");
		sql.append(" ?,?,?,?,? ");
		sql.append(" )");
		return sql.toString();
	}
	
	// ����bomsql
	public String getUpdateHeadSql(String bomID) {
		StringBuffer sql = new StringBuffer();
		sql.append(" update ").append(getTempHeadTable()).append("  ")
		.append(" set recipeNum=?,productNum=?,number=?,name=?,version=?,unit=?,")
		.append(" productQty=?,recipeBase=?,createTime=?,creator=?")
		.append(" ")
		.append(" where recipeNum='").append(bomID).append("'");
		return sql.toString();
	}
	// ���·�¼sql
	private String getUpdateEntrySql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" update  ").append(getTempEntryTable()).append(" set ");
		sql.append(" recipeNum=?,materialnumber=?,unit=?,unit=?,materialQty=?,");
		sql.append(" outmaterial=?");
		return sql.toString();
	}
	
	



	
	public String getBosType() {
		return null;
	}
	
	//δʹ�ô˷���
	public String export2Temp(Context ctx, String companyID, String beginDate, String endDate) throws EASBizException {
		return null;
	}


}
