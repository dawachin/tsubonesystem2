/*
 * Copyright (C) 2014-2016  Kagucho <kagucho.net@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.

 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package tsuboneSystem.entity;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.unit.S2TestCase;

import static tsuboneSystem.names.TPartySendMailNames.*;

/**
 * {@link TPartySendMail}のテストクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2014/06/22 15:56:40")
public class TPartySendMailTest extends S2TestCase {

    private JdbcManager jdbcManager;

    /**
     * 事前処理をします。
     * 
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        include("s2jdbc.dicon");
    }

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    public void testFindById() throws Exception {
        jdbcManager.from(TPartySendMail.class).id(1).getSingleResult();
    }

    /**
     * tPartyとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_tParty() throws Exception {
        jdbcManager.from(TPartySendMail.class).leftOuterJoin(tParty()).id(1).getSingleResult();
    }


	/**
     * tMailとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_tMail() throws Exception {
        jdbcManager.from(TPartySendMail.class).leftOuterJoin(tMail()).id(1).getSingleResult();
    }

}