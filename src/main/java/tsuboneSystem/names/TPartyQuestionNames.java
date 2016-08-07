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

package tsuboneSystem.names;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;
import tsuboneSystem.entity.TPartyQuestion;
import tsuboneSystem.names.TMemberNames._TMemberNames;
import tsuboneSystem.names.TPartyAnswerNames._TPartyAnswerNames;
import tsuboneSystem.names.TPartyNames._TPartyNames;

/**
 * {@link TPartyQuestion}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/03/19 0:46:14")
public class TPartyQuestionNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<Integer> id() {
        return new PropertyName<Integer>("id");
    }

    /**
     * partyIdのプロパティ名を返します。
     * 
     * @return partyIdのプロパティ名
     */
    public static PropertyName<Integer> partyId() {
        return new PropertyName<Integer>("partyId");
    }

    /**
     * memberIdのプロパティ名を返します。
     * 
     * @return memberIdのプロパティ名
     */
    public static PropertyName<Integer> memberId() {
        return new PropertyName<Integer>("memberId");
    }

    /**
     * questionのプロパティ名を返します。
     * 
     * @return questionのプロパティ名
     */
    public static PropertyName<String> question() {
        return new PropertyName<String>("question");
    }

    /**
     * questionSendのプロパティ名を返します。
     * 
     * @return questionSendのプロパティ名
     */
    public static PropertyName<Boolean> questionSend() {
        return new PropertyName<Boolean>("questionSend");
    }

    /**
     * tPartyのプロパティ名を返します。
     * 
     * @return tPartyのプロパティ名
     */
    public static _TPartyNames tParty() {
        return new _TPartyNames("tParty");
    }

    /**
     * tMemberのプロパティ名を返します。
     * 
     * @return tMemberのプロパティ名
     */
    public static _TMemberNames tMember() {
        return new _TMemberNames("tMember");
    }

    /**
     * tPartyAnswerListのプロパティ名を返します。
     * 
     * @return tPartyAnswerListのプロパティ名
     */
    public static _TPartyAnswerNames tPartyAnswerList() {
        return new _TPartyAnswerNames("tPartyAnswerList");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _TPartyQuestionNames extends PropertyName<TPartyQuestion> {

        /**
         * インスタンスを構築します。
         */
        public _TPartyQuestionNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _TPartyQuestionNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _TPartyQuestionNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * idのプロパティ名を返します。
         *
         * @return idのプロパティ名
         */
        public PropertyName<Integer> id() {
            return new PropertyName<Integer>(this, "id");
        }

        /**
         * partyIdのプロパティ名を返します。
         *
         * @return partyIdのプロパティ名
         */
        public PropertyName<Integer> partyId() {
            return new PropertyName<Integer>(this, "partyId");
        }

        /**
         * memberIdのプロパティ名を返します。
         *
         * @return memberIdのプロパティ名
         */
        public PropertyName<Integer> memberId() {
            return new PropertyName<Integer>(this, "memberId");
        }

        /**
         * questionのプロパティ名を返します。
         *
         * @return questionのプロパティ名
         */
        public PropertyName<String> question() {
            return new PropertyName<String>(this, "question");
        }

        /**
         * questionSendのプロパティ名を返します。
         *
         * @return questionSendのプロパティ名
         */
        public PropertyName<Boolean> questionSend() {
            return new PropertyName<Boolean>(this, "questionSend");
        }

        /**
         * tPartyのプロパティ名を返します。
         * 
         * @return tPartyのプロパティ名
         */
        public _TPartyNames tParty() {
            return new _TPartyNames(this, "tParty");
        }

        /**
         * tMemberのプロパティ名を返します。
         * 
         * @return tMemberのプロパティ名
         */
        public _TMemberNames tMember() {
            return new _TMemberNames(this, "tMember");
        }

        /**
         * tPartyAnswerListのプロパティ名を返します。
         * 
         * @return tPartyAnswerListのプロパティ名
         */
        public _TPartyAnswerNames tPartyAnswerList() {
            return new _TPartyAnswerNames(this, "tPartyAnswerList");
        }
    }
}