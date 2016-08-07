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
import tsuboneSystem.entity.TEnqueteAnswer;
import tsuboneSystem.names.TEnqueteSelectNames._TEnqueteSelectNames;
import tsuboneSystem.names.TMemberNames._TMemberNames;

/**
 * {@link TEnqueteAnswer}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/03/19 0:46:14")
public class TEnqueteAnswerNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<Integer> id() {
        return new PropertyName<Integer>("id");
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
     * enqueteSelectedIdのプロパティ名を返します。
     * 
     * @return enqueteSelectedIdのプロパティ名
     */
    public static PropertyName<Integer> enqueteSelectedId() {
        return new PropertyName<Integer>("enqueteSelectedId");
    }

    /**
     * tEnqueteSelectのプロパティ名を返します。
     * 
     * @return tEnqueteSelectのプロパティ名
     */
    public static _TEnqueteSelectNames tEnqueteSelect() {
        return new _TEnqueteSelectNames("tEnqueteSelect");
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
     * @author S2JDBC-Gen
     */
    public static class _TEnqueteAnswerNames extends PropertyName<TEnqueteAnswer> {

        /**
         * インスタンスを構築します。
         */
        public _TEnqueteAnswerNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _TEnqueteAnswerNames(final String name) {
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
        public _TEnqueteAnswerNames(final PropertyName<?> parent, final String name) {
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
         * memberIdのプロパティ名を返します。
         *
         * @return memberIdのプロパティ名
         */
        public PropertyName<Integer> memberId() {
            return new PropertyName<Integer>(this, "memberId");
        }

        /**
         * enqueteSelectedIdのプロパティ名を返します。
         *
         * @return enqueteSelectedIdのプロパティ名
         */
        public PropertyName<Integer> enqueteSelectedId() {
            return new PropertyName<Integer>(this, "enqueteSelectedId");
        }

        /**
         * tEnqueteSelectのプロパティ名を返します。
         * 
         * @return tEnqueteSelectのプロパティ名
         */
        public _TEnqueteSelectNames tEnqueteSelect() {
            return new _TEnqueteSelectNames(this, "tEnqueteSelect");
        }

        /**
         * tMemberのプロパティ名を返します。
         * 
         * @return tMemberのプロパティ名
         */
        public _TMemberNames tMember() {
            return new _TMemberNames(this, "tMember");
        }
    }
}