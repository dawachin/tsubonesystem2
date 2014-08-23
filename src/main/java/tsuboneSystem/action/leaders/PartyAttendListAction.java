package tsuboneSystem.action.leaders;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsuboneSystem.dto.LoginLeadersDto;
import tsuboneSystem.dto.LoginMemberDto;
import tsuboneSystem.dto.PartyDto;
import tsuboneSystem.dto.ExcelDto;
import tsuboneSystem.entity.TMail;
import tsuboneSystem.entity.TMember;
import tsuboneSystem.entity.TParty;
import tsuboneSystem.entity.TPartyAttend;
import tsuboneSystem.form.PartyAttendForm;
import tsuboneSystem.original.manager.MailManager;
import tsuboneSystem.service.TMailSendMemberService;
import tsuboneSystem.service.TMailService;
import tsuboneSystem.service.TMemberService;
import tsuboneSystem.service.TPartyAttendService;
import tsuboneSystem.service.TPartyClubService;
import tsuboneSystem.service.TPartyService;
import tsuboneSystem.fpao.ExcelFpao;

public class PartyAttendListAction {

	/** アクションネーム */
	public String actionName = "PartyAttend";
	
	/** メール送信可否 */
	public String mailMsg = null;
	
	/** 会議の一覧 */
	public List<TParty> partyItem;
	
	/** Memberのアクションフォーム */
	@ActionForm
	@Resource
	protected PartyAttendForm partyAttendForm;
	
	/** Member用のDto */
	@Resource
	public LoginMemberDto loginMemberDto;
	
	/** LoginLeadersのDto */
	@Resource
	public LoginLeadersDto loginLeadersDto;
	
	/** partyDto */
	@Resource
	public PartyDto partyDto;
	
	/** TPartyのサービスクラス */
	@Resource
	protected TPartyService tPartyService;
	
	/** TPartyAttendのサービスクラス */
	@Resource
	protected TPartyAttendService tPartyAttendService;
	
	/** TMemberのサービスクラス */
	@Resource
	protected TMemberService tMemberService;
	
	/** TMailのサービスクラス */
	@Resource
	protected TMailService tMailService;
	
	/** TMailSendMemberServiceのサービスクラス */
	@Resource
	protected TMailSendMemberService tMailSendMemberService;
	
	/** TPartyClubServiceのサービスクラス */
	@Resource
	protected TPartyClubService tPartyClubService;
	
	/** excelファイル出力 */
	@Resource
	protected ExcelFpao excelFpao;
	
	@Resource
    protected HttpServletResponse httpServletResponse;
	
	/** エクセル出力のためのDto */
	@Resource
	protected ExcelDto excelDto;
	
	/** HttpServlet */
	@Resource
	protected HttpServletRequest request;
	
	public boolean deadFlag;
	
	/** 一覧画面表示　*/
	@Execute(validator = false, urlPattern = "{id}")
    @RemoveSession(name = "partyAttendForm")
	public String index() {
    	
    	TParty party = tPartyService.findById(partyAttendForm.id);
    	Beans.copy(party, partyDto).execute();

    	//現在時刻を取得し、期限内か判断する
    	Date dateNow = new Date();
    	deadFlag = partyDto.deadFlag(party, dateNow);
	    	
    	//出欠席を返さないクズ。
    	partyAttendForm.tAttendKuzu = tPartyAttendService.findByPartyId_UNSUBMITTED(partyAttendForm.id);
    	partyAttendForm.tMemberKuzu = new ArrayList<TMember>();
    	for (TPartyAttend tPartyAttendOne : partyAttendForm.tAttendKuzu) {
    		partyAttendForm.tMemberKuzu.add(tPartyAttendOne.tMember);
    	}
    	
    	//出席している人のリスト
    	partyAttendForm.tAttendOn = tPartyAttendService.findByPartyIdAndAttendOn(partyAttendForm.id);
    	partyAttendForm.tMemberOn = new ArrayList<TMember>();
    	for (TPartyAttend tPartyAttendOne : partyAttendForm.tAttendOn) {
    		partyAttendForm.tMemberOn.add(tPartyAttendOne.tMember);
    	}
    	
    	//欠席している人のリスト
    	partyAttendForm.tAttendOff = tPartyAttendService.findByPartyIdAndAttendOff(partyAttendForm.id);
    	partyAttendForm.tMemberOff = new ArrayList<TMember>();
    	for (TPartyAttend tPartyAttendOne : partyAttendForm.tAttendOff) {
    		partyAttendForm.tMemberOff.add(tPartyAttendOne.tMember);
    	}
    	
    	//partyDtoの出欠席リストにもコピーしておく(更新や削除のActionなどで使用する。)
    	partyDto.tMemberOn = partyAttendForm.tMemberOn;
    	partyDto.tMemberOff = partyAttendForm.tMemberOff;
    	partyDto.tMemberKuzu = partyAttendForm.tMemberKuzu;
    	
        return "partyAttendList.jsp";
	}
    
    /**　エクセル出力　*/
    @Execute(validator = false)
    public String createExcel(){
    	
    	ExcelDto dto = new ExcelDto();
    	dto.setMeetingName(partyDto.meetingName);
    	dto.setMemberList(partyDto.tMemberOn);
    	
    	HSSFWorkbook wb = excelFpao.excelTemplate(dto);
    	
    	httpServletResponse.setHeader(
    			"Content-Disposition",
    			"attachment; filename=" + partyDto.meetingName + System.currentTimeMillis() + ".xls");
    	
    	try {
    		OutputStream out = httpServletResponse.getOutputStream();
    		wb.write(out);
    	        out.close();		
    	} catch (IOException e) {} 	
    	
    return null;	
    }
    
    /** メール配信　*/
    @Execute(validator = false)
    public String contentRegist(){
    	
    	// 2重送信防止のためのTokenの生成
        TokenProcessor.getInstance().saveToken(request);
        
    return "partyMailRegist.jsp";	
    }
    
    @Execute(validator = false)
    public String confirm(){
    	
    	//出席する人にメールを送る
    	partyAttendForm.tMemberSendList = partyDto.tMemberOn;
    	
    return "partyMailConfirm.jsp";	
    }
    
    @Execute(validator = false)
    public String complete(){
	
    	// 2重送信防止のためTokenが正常な場合にのみ レコード追加処理を行う
        if (TokenProcessor.getInstance().isTokenValid(request, true)) {
        	
        	//メールの送信者のID
        	partyAttendForm.registMemberId = loginMemberDto.memberId;
        	
        	//TMailにメールの内容を追加する
        	TMail tMail = new TMail();
        	Beans.copy(partyAttendForm, tMail).execute();
        	
        	//メールを送信する
        	MailManager manager = new MailManager();
        	manager.setTitle(partyAttendForm.title);
        	manager.setContent(partyAttendForm.content);
        	manager.setToAddress(partyAttendForm.tMemberSendList.toArray(new TMember[0]));
        	manager.setLogFlg(true, loginMemberDto.memberId, tMailSendMemberService, tMailService);
        	if (manager.sendMail()) {
        		mailMsg = "メールを正常に送信しました。";
        		tMail.errorFlag = false;
        	} else {
        		mailMsg = "メールの送信に失敗しました。";
        		tMail.errorFlag = true;
        	}
        }
        
    return "partyMailComplete.jsp";	
    }   
}
