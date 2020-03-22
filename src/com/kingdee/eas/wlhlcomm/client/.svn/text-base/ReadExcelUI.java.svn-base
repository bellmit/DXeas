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
     * 初始化界面 控件
     */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
        // 邦定导入EXCEL插件
		ExcelBPBox = new FileChooserPromptBox(this,FileChooserPromptBox.CHOOSERTYPE_OPEN);
        ExcelBPBox.setHistoryRecordEnabled(true);
        lcImportExcel.setBoundEditor(ExcelBPBox);
	}
	
	/**
	 * 导入操作，校验文件格式，如果确实为 excel，则关闭界面，返回到之前界面 文件流
	 * 否则，提示文件格式问题
	 */
	@Override
	protected void btnImport_actionPerformed(ActionEvent arg0) throws Exception {
		if(ExcelBPBox.getValue()!=null){
    	    File excelFile = new File(ExcelBPBox.getText());
    	    String fileFullName = ExcelBPBox.getText();
    	    String fileName = excelFile.getName().toLowerCase();
    	    // 扩展名校验
    	    if(excelFile != null && excelFile.isFile() && (fileName.endsWith(ExcelReadUtil.XLS) || fileName.endsWith(ExcelReadUtil.XLSX))){
				if(excelFile.exists()){
					Map containValue = ExcelReadUtil.readExcel(fileFullName);
					this.getUIContext().put(ExcelReadUtil.FileFullName, fileFullName);
					this.getUIContext().put(ExcelReadUtil.ExcelValues, containValue);
					// 关闭界面
					this.uiWindow.close();
					
				}
        	}else{
        	    MsgBox.showInfo("请选择符合要求的EXCEL文件。");
                    SysUtil.abort();
        	}
	   
	    
        }else{
            MsgBox.showInfo("请先选择源数据EXCEL文件。");
            SysUtil.abort();
        }
		
	}


}