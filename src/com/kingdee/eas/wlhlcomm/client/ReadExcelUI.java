/**
 * output package name
 */
package com.kingdee.eas.wlhlcomm.client;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.tools.datatask.client.FileChooserPromptBox;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;

/**
 * output class name
 */
public class ReadExcelUI extends AbstractReadExcelUI
{
    private static final Logger logger = CoreUIObject.getLogger(ReadExcelUI.class);
    
    private FileChooserPromptBox ExcelBPBox;
    /**
     * output class constructor
     */
    public ReadExcelUI() throws Exception
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
     * ��ʼ������ �ؼ�
     */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
        // �����EXCEL���
		ExcelBPBox = new FileChooserPromptBox(this,FileChooserPromptBox.CHOOSERTYPE_OPEN);
        ExcelBPBox.setHistoryRecordEnabled(true);
        lcImportExcel.setBoundEditor(ExcelBPBox);
	}
	
	/**
	 * ���������У���ļ���ʽ�����ȷʵΪ excel����رս��棬���ص�֮ǰ���� �ļ���
	 * ������ʾ�ļ���ʽ����
	 */
	@Override
	protected void btnImport_actionPerformed(ActionEvent arg0) throws Exception {
		if(ExcelBPBox.getValue()!=null){
    	    File excelFile = new File(ExcelBPBox.getText());
    	    String fileFullName = ExcelBPBox.getText();
    	    String fileName = excelFile.getName().toLowerCase();
    	    // ��չ��У��
    	    if(excelFile != null && excelFile.isFile() && (fileName.endsWith(ExcelReadUtil.XLS) || fileName.endsWith(ExcelReadUtil.XLSX))){
				if(excelFile.exists()){
					Map containValue = ExcelReadUtil.readExcel(fileFullName);
					this.getUIContext().put(ExcelReadUtil.FileFullName, fileFullName);
					this.getUIContext().put(ExcelReadUtil.ExcelValues, containValue);
					// �رս���
					this.uiWindow.close();
					
				}
        	}else{
        	    MsgBox.showInfo("��ѡ�����Ҫ���EXCEL�ļ���");
                    SysUtil.abort();
        	}
	   
	    
        }else{
            MsgBox.showInfo("����ѡ��Դ����EXCEL�ļ���");
            SysUtil.abort();
        }
		
	}


}