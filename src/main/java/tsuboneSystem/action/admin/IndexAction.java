/*
 * Copyright 2004-2008 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package tsuboneSystem.action.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import tsuboneSystem.code.PartyAttendCode;
import tsuboneSystem.dto.LoginAdminDto;
import tsuboneSystem.entity.TClub;
import tsuboneSystem.entity.TMemberClub;
import tsuboneSystem.entity.TParty;
import tsuboneSystem.entity.TPartyAttend;
import tsuboneSystem.entity.TPartyClub;
import tsuboneSystem.form.MyPageForm;
import tsuboneSystem.service.TClubService;
import tsuboneSystem.service.TLeadersService;
import tsuboneSystem.service.TMemberClubService;
import tsuboneSystem.service.TMemberService;
import tsuboneSystem.service.TPartyAttendService;
import tsuboneSystem.service.TPartyClubService;
import tsuboneSystem.service.TPartyService;

public class IndexAction {
	
	public String actionName = "Welcome!!";
	
	public String actionNameSub = null;
	
	/** Indexのアクションフォーム */
	@ActionForm
	@Resource
	protected MyPageForm myPageForm;
	
	/** TMemberのサービスクラス */
	@Resource
	protected TMemberService tMemberService;
	
	/** TClubのサービスクラス */
	@Resource
	protected TClubService tClubService;
	
	/** TPartyServiceのサービスクラス */
	@Resource
	protected TPartyService tPartyService;
	
	/** TPartyAttendServiceのサービスクラス */
	@Resource
	protected TPartyAttendService tPartyAttendService;
	
	/** TPartyClubServiceのサービスクラス */
	@Resource
	protected TPartyClubService tPartyClubService;
	
	/** TMemberClubServiceのサービスクラス */
	@Resource
	protected TMemberClubService tMemberClubService;
	
	/** TLeadersServiceのサービスクラス */
	@Resource
	protected TLeadersService tLeadersService;
	
	/** LoginAdminDto */
	@Resource
	protected LoginAdminDto loginAdminDto;
	
    @Execute(validator = false)
	public String index() {
    	
    	//ログインしているメンバー情報
    	myPageForm.tMember = loginAdminDto.tMemberLogin;
    	actionNameSub = myPageForm.tMember.hname;
    	
    	//ログインしているメンバーの所属部一覧
    	myPageForm.tMemberClubList = tMemberClubService.findByMemberId(loginAdminDto.tMemberLogin.id.toString());
    	myPageForm.tClubList = new ArrayList<TClub>();
    	for (TMemberClub tMemberClubOne : myPageForm.tMemberClubList) {
    		myPageForm.tClubList.add(tMemberClubOne.tClub);
    	}
    	
    	//現在時刻の取得と、その時点で出欠受付中かつ、まだ出欠を出していないの会議一覧
    	myPageForm.tPartyNoAttendList = new ArrayList<TParty>();
    	Date dateNow = new Date();
    	
    	//TODO 締切日がないものはどうするか？
    	myPageForm.tPartyNoAttendList = tPartyService.findNotAttendPartyByMemberId(new Date(), loginAdminDto.memberId);
    	
    	//実行日に開催されている会議一覧
    	myPageForm.tPartyToDayList = tPartyService.findBy_MeetingDay_EQ_Now(dateNow);
    	
        return "index.jsp";
	}
}
