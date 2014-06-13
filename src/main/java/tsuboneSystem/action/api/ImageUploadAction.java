package tsuboneSystem.action.api;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ServletContextUtil;
import org.seasar.struts.util.UploadUtil;

import tsuboneSystem.form.ImageUploadForm;

public class ImageUploadAction {
	
	
	/** ImageUploadActionのアクションフォーム */
	@ActionForm
	@Resource
	protected ImageUploadForm imageUploadForm;
	
	@Resource
    HttpServletRequest req;

    @Execute(validator = false)
	public String index() {
    	
    	//ServletContext オブジェクトの作成
    	ServletContext app = ServletContextUtil.getServletContext();
    	
    	//ファイルの格納先フォルダの絶対パスを取得
        String path = app.getRealPath("/images/upload/" + imageUploadForm.file.getFileName());
        
        //ファイル書き込み（ファイルパスが空の場合は何もしません）
        UploadUtil.write(path, imageUploadForm.file);
    	
        return null;
	}

}