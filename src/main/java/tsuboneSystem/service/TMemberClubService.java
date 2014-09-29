package tsuboneSystem.service;

import java.util.List;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import tsuboneSystem.entity.TMemberClub;
import static org.seasar.extension.jdbc.operation.Operations.*;
import static tsuboneSystem.names.TMemberClubNames.*;

/**
 * {@link TMemberClub}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2014/04/07 18:14:16")
public class TMemberClubService extends AbstractService<TMemberClub> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public TMemberClub findById(Integer id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<TMemberClub> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
    
    /**
     * MemberIdですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<TMemberClub> findByMemberId(String memberId) {
    	SimpleWhere where = new SimpleWhere();
    	where.eq(MemberId(),memberId);
        return select().innerJoin(tClub(),new SimpleWhere().eq(tClub().deleteFlag(), Boolean.valueOf(false))).where(where).orderBy(asc(id())).getResultList();
    }
    
    /**
     * ClubIdですべてのエンティティを検索します。
     * @param containsOb OBを含めるならTRUE
     * @return エンティティのリスト
     */
    public List<TMemberClub> findByClubId(String clubId, boolean containsOb) {
    	SimpleWhere where = new SimpleWhere();
    	where.eq(ClubId(),clubId);
        return select()
        		.where(where)
        		.innerJoin(tMember(), getWhereMember(containsOb))
        		.getResultList();
    }

	private SimpleWhere getWhereMember(boolean containsOb) {
		SimpleWhere where = new SimpleWhere().eq(tMember().deleteFlag(), Boolean.valueOf(false));
		//OBを含めないなら検索条件に含める
		if (!containsOb) {
			where.eq(tMember().sendStopFlag(), Boolean.valueOf(false));
		}
		return where; 
	}
    
    /**
     * ClubIdですべてのエンティティを検索し、紐づくメンバーの内、OBでなく、削除されていないメンバーをinnerjoin。
     * 
     * @return エンティティのリスト
     */
    public List<TMemberClub> findByClubIdInMember(String clubId) {
    	SimpleWhere where = new SimpleWhere();
    	where.eq(ClubId(),clubId);
        return select()
        		.where(where)
        		.innerJoin(
        				tMember(),
        				new SimpleWhere()
	        				.eq(tMember().deleteFlag(), Boolean.valueOf(false))
	        				.eq(tMember().obFlag(), Boolean.valueOf(false)))
        		.getResultList();
    }
    
    /**
     * officerIdでエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public List<TMemberClub> findByIdFortMember(Integer Id) {
    	SimpleWhere where = new SimpleWhere();
    	where.eq(ClubId(), Id);
        return select().where(where)
        		.innerJoin(
        				tMember(),
        				new SimpleWhere()
        				.eq(tMember().deleteFlag(), Boolean.valueOf(false))
        				.eq(tMember().obFlag(), Boolean.valueOf(false)))
        		.getResultList();
    }
}