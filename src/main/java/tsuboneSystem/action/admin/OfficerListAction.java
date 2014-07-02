package tsuboneSystem.action.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tsuboneSystem.code.LeadersKindCode;
import tsuboneSystem.form.OfficerForm;
import tsuboneSystem.service.TClubService;
import tsuboneSystem.service.TLeadersService;
import tsuboneSystem.service.TMemberClubService;
import tsuboneSystem.service.TMemberService;

public class OfficerListAction {
	
	public String actionName = "OfficerList";
	
	/** ClubFormのフォーム */
	@ActionForm
	@Resource
	protected OfficerForm officerForm;
	
	/** TMemberのサービスクラス */
	@Resource
	protected TMemberService tMemberService;
	
	/** TClubのサービスクラス */
	@Resource
	protected TClubService tClubService;
	
	/** TMemberClubServiceのサービスクラス */
	@Resource
	protected TMemberClubService tMemberClubService;
	
	/** TLeadersServiceのサービスクラス */
	@Resource
	protected TLeadersService tLeadersService;
	
	/** HttpServlet */
	@Resource
	protected HttpServletRequest request;
	
	
    @Execute(validator = false)
    @RemoveSession(name="officerForm")
	public String index() {
    	
    	//局長
    	officerForm.tLeadersChief = tLeadersService.findByKind(LeadersKindCode.CHIEF.getCode());
    	
    	//副局長
    	officerForm.tLeadersSubChief = tLeadersService.findByKind(LeadersKindCode.SUB_CHIEF.getCode());
    	
    	//会計
    	officerForm.tLeadersAccount = tLeadersService.findByKind(LeadersKindCode.ACCOUNT.getCode());
	
    	//以下、各部長の一覧
    	officerForm.officerListItem = tClubService.findAllInTmember();
    	
    	//合宿委員
    	officerForm.tLeadersGassyuku = tLeadersService.findByKind(LeadersKindCode.GASSYUKU.getCode());
    	
    	//web管理者
    	officerForm.tLeadersWebAdmin = tLeadersService.findByKind(LeadersKindCode.WEBADMIN.getCode());
	
        return "OfficerList.jsp";
	}
}
