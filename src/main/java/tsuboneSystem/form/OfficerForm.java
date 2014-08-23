package tsuboneSystem.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

import tsuboneSystem.entity.TAdmin;
import tsuboneSystem.entity.TClub;
import tsuboneSystem.entity.TLeaders;
import tsuboneSystem.entity.TMember;

@Component(instance = InstanceType.SESSION)
public class OfficerForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Integer id;
	
	/* 役職種 */
	public String OfficerKind;
	
	/* MemberId */
	public String MemberId;
	
	/* メンバーの秘匿情報の表示可否 */
    public boolean  secretInformation;
    
    /* メンバー編集権限可否 */
    public boolean  memberUpdate;
    
    /* 他人の出欠管理可否 */
    public boolean  attendUpdate;
    
    /* 部情報の編集権限可否 */
    public boolean  clubUpdate;
		
	/* Clubのリスト */
	public List<TClub> clubItems;
	
	/* Memberのリスト */
	public List<TMember> memberItems;
	
	/* 表示するためのリスト */
	public List<TClub> officerListItem = new ArrayList<TClub>();
	
	/* TLeaderテーブルの一覧を一回格納するためのリスト　*/
	public List<TLeaders> leaders;
	
	/* 選択されたレコードを格納しておくTLeader　*/
	public TLeaders leadersOld;
	
	/* 選択されたレコードを格納しておくTAdmin　*/
	public TAdmin adminOld;
	
	/* 更新の時に選択されたメンバーを入れておく　*/
	public TMember tMemberNew;
	
	/* 局長の情報を格納する　*/
	public List<TAdmin> tLeadersChief = new ArrayList<TAdmin>();
	
	/* 副局長の情報を格納する　*/
	public List<TAdmin> tLeadersSubChief = new ArrayList<TAdmin>();
	
	/* 会計の情報を格納する　*/
	public List<TLeaders> tLeadersAccount = new ArrayList<TLeaders>();
	
	/* 合宿委員の情報を格納する　*/
	public List<TLeaders> tLeadersGassyuku = new ArrayList<TLeaders>();
	
	/* 合宿委員の情報を格納する　*/
	public List<TAdmin> tLeadersWebAdmin = new ArrayList<TAdmin>();
	
	//リッセットメソッド(※命名注意！！"reset"にすると、このformに関わるすべてのメソッドで呼び出される。)
	public void resetInput() {
		clubUpdate = false;
		attendUpdate = false;
		memberUpdate = false;
		secretInformation = false;
    }

}
