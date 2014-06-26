package tsuboneSystem.task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.chronos.core.annotation.task.Task;
import org.seasar.chronos.core.annotation.trigger.CronTrigger;

import tsuboneSystem.entity.TMember;
import tsuboneSystem.original.util.MailUtil;
import tsuboneSystem.service.TMemberService;

@Task
@CronTrigger(expression = "00 44 23 * * ?")
public class NondeliveryMailTask extends AbstractTask {
	
	@Resource
	TMemberService tMemberService;
	
	@Override
	String getTascName() {
		return "不到達メールを検索しフラグを立てる";
	}
	
	@Override
	void process() throws Exception {
		//メールが送れていない人を取得
		HashSet<String> sendErrorset  = MailUtil.getFaledSendAddressList();
		List<TMember> member = new ArrayList<TMember>();
		for(String one : sendErrorset){
			member.add(tMemberService.findByEmail(one));
		}
		
		//不到達フラグを書き換えてアップデートを行う
		for (TMember tMember : member) {
			tMember.sendErrorFlag = true;
			tMemberService.update(tMember);
		}
	}

}
