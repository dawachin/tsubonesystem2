package tsuboneSystem.service;

import static org.seasar.extension.jdbc.operation.Operations.*;
import static tsuboneSystem.names.TEnqueteNames.*;

import java.util.List;

import javax.annotation.Generated;

import tsuboneSystem.entity.TEnquete;

/**
 * {@link TEnquete}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2014/09/02 19:13:10")
public class TEnqueteService extends AbstractService<TEnquete> {

	/**
	 * 識別子でエンティティを検索します。
	 *
	 * @param id
	 *            識別子
	 * @return エンティティ
	 */
	public TEnquete findById(Integer id) {
		return select().id(id).getSingleResult();
	}

	/**
	 * ID指定した一件だけ取得。テーブルをJoinしている
	 *
	 * @param id
	 *            識別子
	 * @return エンティティ
	 */
	public TEnquete findByIdJoinTable(Integer id) {
		return select()
				.innerJoin(tMember())
				.innerJoin(tEnqueteSelect())
				.leftOuterJoin(tEnqueteSelect().tEnqueteAnswerList())
				.id(id).getSingleResult();
	}

	public List<TEnquete> findAllJoinTable() {
		return select().innerJoin(tMember()).getResultList();
	}

	/**
	 * 識別子の昇順ですべてのエンティティを検索します。
	 *
	 * @return エンティティのリスト
	 */
	public List<TEnquete> findAllOrderById() {
		return select().orderBy(asc(id())).getResultList();
	}
}