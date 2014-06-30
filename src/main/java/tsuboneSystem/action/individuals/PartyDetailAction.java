package tsuboneSystem.action.individuals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.beans.util.Beans;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tsuboneSystem.dto.LoginIndividualsDto;
import tsuboneSystem.dto.PartyDto;
import tsuboneSystem.entity.TMail;
import tsuboneSystem.entity.TMailSendMember;
import tsuboneSystem.entity.TMember;
import tsuboneSystem.entity.TParty;
import tsuboneSystem.entity.TPartyClub;
import tsuboneSystem.entity.TPartyQuestion;
import tsuboneSystem.form.PartyForm;
import tsuboneSystem.original.manager.MailManager;
import tsuboneSystem.service.TClubService;
import tsuboneSystem.service.TMailSendMemberService;
import tsuboneSystem.service.TMailService;
import tsuboneSystem.service.TPartyQuestionService;
import tsuboneSystem.service.TPartyService;

public class PartyDetailAction {
	
	public String actionName = "PartyDetail";
	
	/** TPartyのサービスクラス */
	@Resource
	protected TPartyService tPartyService;
	
	/** TClubServiceのサービスクラス */
	@Resource
	protected TClubService tClubService;
	
	/** TPartyQuestionServiceのサービスクラス */
	@Resource
	protected TPartyQuestionService  tPartyQuestionService;
	
	/** TMailのサービスクラス */
	@Resource
	protected TMailService tMailService;
	
	/** TMailSendMemberServiceのサービスクラス */
	@Resource
	protected TMailSendMemberService tMailSendMemberService;
	
	/** PartyDtoのサービスクラス */
	@Resource
	protected PartyDto partyDto;
	
	/** LoginIndividualsDtoのDto */
	@Resource
	protected LoginIndividualsDto loginIndividualsDto;
	
	/** Memberのアクションフォーム */
	@ActionForm
	@Resource
	protected PartyForm partyForm;
	
	/** HttpServlet */
	@Resource
	protected HttpServletRequest request;
	
	/** 送信エラーフラグ */
	public boolean errorFlag;
	
    @Execute(validator = false, urlPattern = "{id}", reset = "resetInput")
	public String index() {
    	
    	/** 2重送信防止のためのTokenの生成　**/
        TokenProcessor.getInstance().saveToken(request);
    	
    	TParty party = tPartyService.findById(partyForm.id);
    	Beans.copy(party, partyForm).execute();
    	Beans.copy(party, partyDto).execute();
    	
    	int i = 0;
        partyForm.attendClub = new String[party.tPartyClubList.size()];
        partyDto.attendClub = new String[party.tPartyClubList.size()];
        for (TPartyClub tPartyClubOne : party.tPartyClubList) {
        	partyForm.attendClub[i] = tPartyClubOne.ClubId.toString();
        	partyDto.attendClub[i] = tPartyClubOne.ClubId.toString();
        	i++;
        }
    	
    	//現在時刻を取得し、期限内か判断する
    	Date dateNow = new Date();
    	partyForm.deadFlag = partyDto.deadFlag(party, dateNow);
    	
    	//マップを作る。形はkey(数値)とvalu(名称)の２個セットの形
        partyForm.clubMapIS = tClubService.getClubMapIS();
        partyForm.clubMapSS = tClubService.getClubMapSS();
    	
        return "partyDetail.jsp";
	}
    
  //質問確認画面
    @Execute(validator = true, input = "partyDetail.jsp")
    public String questionConfirm(){
    	
    	return "partyQuestionConfirm.jsp";
    }
    
    //質問完了画面
    @Execute(validator = false)
    public String questionComplete(){
    	
    	/** 2重送信防止のためTokenが正常な場合にのみ レコード追加処理を行う	　**/
        if (TokenProcessor.getInstance().isTokenValid(request, true)) {
        	
        	//質問内容を登録する
        	TPartyQuestion tPartyQuestion = new TPartyQuestion();
        	tPartyQuestion.partyId = partyForm.id;
        	tPartyQuestion.memberId = loginIndividualsDto.memberId;
        	tPartyQuestion.question = partyForm.question;
        	tPartyQuestion.questionSend = partyForm.questionSend;
        	tPartyQuestionService.insert(tPartyQuestion);
        	
        	//会議の登録者にメールを送る
        	if(partyForm.questionSend){
        		
        		//送信対象
        		List<TMember> tSendMember = new ArrayList<TMember>();
        		tSendMember.add(partyForm.tMember);
        		    		
        		//タイトルを作る
    	    	StringBuilder sb = new StringBuilder();
    	    	sb.append("[");
    	    	sb.append(partyForm.meetingName);
    	    	sb.append("]");
    	    	sb.append("に対して質問を受け付けました");
    	    	String title = new String(sb);
    	    	
    	    	//内容を作る
    	    	StringBuilder sbc = new StringBuilder();
    	    	sbc.append("会議名:　");
    	    	sbc.append(partyForm.meetingName);
    	    	sbc.append("\n");
    	    	sbc.append("質問者:　");
    	    	sbc.append(loginIndividualsDto.tMemberLogin.hname);
    	    	sbc.append("\n");
    	    	sbc.append("\n");
    	    	sbc.append("質問内容:　");
    	    	sbc.append("\n");
    	    	sbc.append(partyForm.question);
    	    	String content = new String(sbc);
    	    	
    	    	//メールを送信する
            	MailManager manager = new MailManager();
            	manager.setTitle(title);
            	manager.setContent(content);
            	manager.setToAddress(tSendMember.toArray(new TMember[0]));
            	if (manager.sendMail()){
            		errorFlag = false;
            	}else{
            		errorFlag = true;
            	}
            	
            	//以下メールの送信履歴を残す
            	TMail tMail = new TMail();
            	tMail.title = title;
            	tMail.content = content;
            	tMail.errorFlag = errorFlag;
            	tMail.registMemberId = loginIndividualsDto.memberId;
            	tMailService.insert(tMail);
            	
            	for (TMember tMemberOne : tSendMember) {
            		TMailSendMember tMailSendMember = new TMailSendMember();
            		tMailSendMember.mailId = tMail.id;
            		tMailSendMember.memberId = tMemberOne.id;
            		tMailSendMemberService.insert(tMailSendMember);
            	}	
        	}
        }
    	return "partyQuestionComplete.jsp";
    }
}
