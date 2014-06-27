package tsuboneSystem.form;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

import tsuboneSystem.entity.TClub;
import tsuboneSystem.entity.TMember;
import tsuboneSystem.entity.TPartyClub;

@Component(instance = InstanceType.SESSION) 
public class PartyForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** id　*/
	public Integer id;
	
	/** 会議の登録者Id　*/
	public Integer creatorId;
	
	/** 会議名　*/
	@Required(msg=@Msg(key="errors.meetingName", resource=true))
	public String meetingName;
	
	/** 会議の必須判定　*/
	public boolean meetingNecessaryFlag;
	
	/** 出席対象者　*/
	public String[] attendClub = new String[0];
	
	/** 会議日時　*/
	//オリジナルチェックの方でチェックしているのでチェックしない
//	@Maxlength(maxlength=10)
//	@DateType(datePatternStrict="yyyy/MM/dd",msg=@Msg(key="errors.date", resource=true))
	public String meetingDay;
	
	/** 会議時間　*/
	//オリジナルチェックの方でチェックしているのでチェックしない
//	@DateType(datePattern = "HH:mm",msg=@Msg(key="errors.time", resource=true))
	public String meetingTime;
	
	/** 会議場所　*/
	public String meetingRoom;
	
	/** 会議内容　*/
	@Required(msg=@Msg(key="errors.meetingMemo", resource=true))
	public String meetingMemo;
	
	/** 会議出欠席締め切り日　*/
	//オリジナルチェックの方でチェックしているのでチェックしない
//	@DateType(datePatternStrict="yyyy/MM/dd",msg=@Msg(key="errors.date", resource=true))
	public String meetingDeadlineDay;
	
	
	/** 審議結果 */
    public String  meetingResult;
	
	/** 削除フラグ */
    public String  deleteFlag;
    
    /** 期限切れフラグ */
    public boolean deadFlag;
    
    /** OB出席フラグ */
    public boolean ObAttendFlag;
	
	//以下の項目はメール配信関係
		
		/* メールの送信可否　*/
		public boolean mailSendFlag;
	
		/* 全体へのメール送信　*/
		public String mailSendAllFlag;
		
		/* OBへのメール送信　*/
		public String mailSendOBFlag;
	
		/* 選択した部 */
		public String[] clubListCheck = new String[0];
		
		/* メールのタイトル　*/
		public String title;
		
		/* メールの内容　*/
		public String content;
		
		/* メールの送信相手　*/
		public Set<Integer> MemberSendSet = new HashSet<Integer>();
		
		/* メールの送信相手　*/
		public Set<TMember> MemberSendSet2 = new HashSet<TMember>();
		
		/* メールの送信相手一覧 */
		public List<TMember> tMemberSendList;
		
		/* メールの送信者　*/
		public Integer registMemberId;
		
	//メール配信項目ここまで	

	/** 部のリスト **/
	public List<TClub> clubList;
	
	/** 出席対象部のリスト **/
	public List<TPartyClub> tPartyClubList;
	
	/** 部のマップ **/
	public Map<String, String> clubMapSS;
	
	/** 部のマップ **/
	public Map<Integer, String> clubMapIS;
	
	/** 出席対象が部で選択されている場合　**/
	public Set<Integer> MemberSet = new HashSet<Integer>();
	
	//リッセットメソッド(※命名注意！！"reset"にすると、このformに関わるすべてのメソッドで呼び出される。)
	public void resetInput() {
		meetingName = null;
		meetingDay = null;
		meetingTime = null;
		meetingDeadlineDay = null;
		meetingRoom = null;
		meetingMemo = null;
		clubListCheck = new String[0];
		attendClub = null;
		mailSendFlag = false;
		mailSendAllFlag = null;
		mailSendOBFlag = null;
		ObAttendFlag = false;
		meetingDeadlineDay = null;
		meetingNecessaryFlag = false;
	}
	
	//オリジナルチェック
    public ActionMessages validateBase(){
    	
        ActionMessages errors = new ActionMessages();
        
        //メール配信関係
        if (mailSendFlag) {
        	if (mailSendAllFlag == null && clubListCheck.length == 0 ) {
        		errors.add("sendTo",new ActionMessage("メールを送る場合は、送り相手を選択してください。",false));
        	}
        	if (title.isEmpty()) {
        		errors.add("title",new ActionMessage("メールを送る場合は、メールの題名を入力してください。",false));
        	}
        	if (content.isEmpty()) {
        		errors.add("content",new ActionMessage("メールを送る場合は、メールの内容を入力してください。",false));
        	}
        	
        }
        
        //開催日が空の時の処理
		if (meetingDay.isEmpty()) {
			if (!meetingTime.isEmpty()) {
				errors.add("meetingDay",new ActionMessage("開始時間を入力するときは開催日も入力してください。",false));
			}
			if (!meetingDeadlineDay.isEmpty()) {
				errors.add("meetingDay",new ActionMessage("締め切りが決まっている場合には、開催日は必須です",false));
			}
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		// 会議日は過去にはできない
		if (!meetingDay.isEmpty()) {
			try {
				Date mDay = sdf.parse(meetingDay);
				if (mDay.before(new Date())) {
					errors.add("meetingDay", new ActionMessage("過去に会議を予定したければタイムマシンを作ってからにしてください", false));
				}
			} catch (ParseException e) {
				errors.add("meetingDay", new ActionMessage("開催日はyyyy/mm/ddで入力する必要があります。(例:2014/05/11)", false));
			}
		}
		
		// 締め切り日を過去にはできない
		if (!meetingDeadlineDay.isEmpty()) {
			try {
				Date dDay = sdf.parse(meetingDeadlineDay);
				if (dDay.before(new Date())) {
					errors.add("meetingDeadlineDay", new ActionMessage("過去に会議を予定したければタイムマシンを作ってからにしてください", false));
				}
			} catch (ParseException e) {
				errors.add("meetingDeadlineDay", new ActionMessage("締切日はyyyy/mm/ddで入力する必要があります。(例:2014/05/12)", false));
			}
		}
		
		if (!meetingDeadlineDay.isEmpty() && !meetingDay.isEmpty() 
				&& errors.size("meetingDay") == 0 && errors.size("meetingDeadlineDay") == 0) {
		    Date mDay = null;
		    Date dDay = null;
		    
		    // 日付を作成します。
		    try {
		        dDay = sdf.parse(meetingDeadlineDay);
		        mDay = sdf.parse(meetingDay);
		    } catch (ParseException e) {
		    	//上でチェックしているので起こりえない
		    }
			
		    //開催日と締め切り日の差を取り割る
		    if (dDay.before(mDay)) {
		    	errors.add("meetingDay",new ActionMessage("締め切りの方が開催日より後になるとか意味がわかりません",false));
			    errors.add("meetingDeadlineDay",new ActionMessage("締め切りの方が開催日より後になるとか意味がわかりません",false));
			}
		}
		
		//型チェック
		if (!meetingTime.isEmpty()) {
			try {
				new SimpleDateFormat("HH:mm").parse(meetingTime);
			} catch (ParseException e) {
				errors.add("meetingTime",new ActionMessage("開催時間はhh:mmで入力する必要があります。(例：09:21)",false));
			}
		}
		
        return errors;
    }
	
}
