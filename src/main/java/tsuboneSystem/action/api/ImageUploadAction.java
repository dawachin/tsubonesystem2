package tsuboneSystem.action.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.UploadUtil;

import tsuboneSystem.code.FilePathCode;
import tsuboneSystem.code.ImageFilePurposeCode;
import tsuboneSystem.entity.TImageUpload;
import tsuboneSystem.form.ImageUploadForm;
import tsuboneSystem.service.TImageUploadService;

public class ImageUploadAction {
	
	/** ImageUploadActionのアクションフォーム */
	@ActionForm
	@Resource
	protected ImageUploadForm imageUploadForm;
	
	/** TImageUploadServiceのサービスクラス */
	@Resource
	protected TImageUploadService tImageUploadService;
	
	@Resource
    HttpServletRequest req;

    @Execute(validator = false)
	public String index() {
    	
    	//ランダム文字を生成
    	String rm = RandomStringUtils.randomAlphabetic(10);
    	
    	//ファイルの格納先フォルダの絶対パスを取得(DBにこのパスを保存しておく)
    	String path = FilePathCode.HONBAN_IMAGE.getName() + rm + imageUploadForm.file.getFileName();
    	
    	//ファイル書き込み（ファイルパスが空の場合は何もしません）
        UploadUtil.write(path, imageUploadForm.file);
        
        //ファイル名とファイルパスをDBに追加
    	TImageUpload imageUpload = new TImageUpload();
    	imageUpload.fileName = rm + imageUploadForm.file.getFileName();
    	imageUpload.filePath = path;
    	imageUpload.ImageFilePurpose = Integer.valueOf(ImageFilePurposeCode.TOP_BACK.getCode());
    	tImageUploadService.insert(imageUpload);
    	
        return null;
	}

}
