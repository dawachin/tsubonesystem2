package tsuboneSystem.form;

import java.io.Serializable;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import tsuboneSystem.entity.TClub;

@Component(instance = InstanceType.SESSION) 
public class TopForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//質問者
	public String name;
	
	//質問者のメールアドレス
	public String email;
	
	//質問(タイトル)
	public String subject;
	
	//質問(内容)
	public String message;
	
	//トップの部紹介一覧
	public List<TClub> clubList;
	
}
