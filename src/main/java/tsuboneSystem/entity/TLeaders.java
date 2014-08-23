package tsuboneSystem.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clubのエンティティクラス
 * 
 * @author oowada
 */
@Entity
@Table(name = "T_LEADERS")
public class TLeaders implements Serializable {
	
	private static final long serialVersionUID = 1L;

    /* idプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true, unique = true)
    public Integer id;
    
    /* 役職の種類 */
    @Column(nullable = true, unique = false)
    public Integer  OfficerKind;
      
    /* 部長のMemberID */
    @Column(nullable = true, unique = false)
    public Integer  MemberId;
    
    /* メンバーの秘匿情報の表示可否 */
    @Column(columnDefinition ="boolean default '0'")
    public boolean  secretInformation;
    
    /* メンバー編集権限可否 */
    @Column(columnDefinition ="boolean default '0'")
    public boolean  memberUpdate;
    
    /* 他人の出欠管理可否 */
    @Column(columnDefinition ="boolean default '0'")
    public boolean  attendUpdate;
    
    /* 部情報の編集権限可否 */
    @Column(columnDefinition ="boolean default '0'")
    public boolean  clubUpdate;
       
    
    /** MemberidをTMember(ID)に関連付ける */
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID")
    public TMember tMember;
    
    /** 部長のIDをTClubに関連付ける */
    @OneToOne(mappedBy = "tLeaders")
    public TClub tClub;
    

}