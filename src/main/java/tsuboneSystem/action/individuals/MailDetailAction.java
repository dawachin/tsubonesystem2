package tsuboneSystem.action.individuals;

import javax.annotation.Resource;

import tsuboneSystem.dto.LoginIndividualsDto;
import tsuboneSystem.entity.TMail;


public class MailDetailAction extends tsuboneSystem.action.admin.MailDetailAction{
	@Resource
	LoginIndividualsDto loginIndividualsDto;
	
	
	@Override
	protected boolean check(TMail mail) {
		return super.check(mail) 
				&& mail.registMemberId != null 
				&& mail.registMemberId.equals(loginIndividualsDto.memberId);
	}
}
