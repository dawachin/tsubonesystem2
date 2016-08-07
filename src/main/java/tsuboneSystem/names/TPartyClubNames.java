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
import tsuboneSystem.entity.TPartyClub;
import tsuboneSystem.names.TClubNames._TClubNames;
import tsuboneSystem.names.TPartyNames._TPartyNames;

/**
 * {@link TPartyClub}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/03/19 0:46:14")
public class TPartyClubNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<Integer> id() {
        return new PropertyName<Integer>("id");
    }

    /**
     * PartyIdのプロパティ名を返します。
     * 
     * @return PartyIdのプロパティ名
     */
    public static PropertyName<Integer> PartyId() {
        return new PropertyName<Integer>("PartyId");
    }

    /**
     * ClubIdのプロパティ名を返します。
     * 
     * @return ClubIdのプロパティ名
     */
    public static PropertyName<Integer> ClubId() {
        return new PropertyName<Integer>("ClubId");
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
     * tClubのプロパティ名を返します。
     * 
     * @return tClubのプロパティ名
     */
    public static _TClubNames tClub() {
        return new _TClubNames("tClub");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _TPartyClubNames extends PropertyName<TPartyClub> {

        /**
         * インスタンスを構築します。
         */
        public _TPartyClubNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _TPartyClubNames(final String name) {
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
        public _TPartyClubNames(final PropertyName<?> parent, final String name) {
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
         * PartyIdのプロパティ名を返します。
         *
         * @return PartyIdのプロパティ名
         */
        public PropertyName<Integer> PartyId() {
            return new PropertyName<Integer>(this, "PartyId");
        }

        /**
         * ClubIdのプロパティ名を返します。
         *
         * @return ClubIdのプロパティ名
         */
        public PropertyName<Integer> ClubId() {
            return new PropertyName<Integer>(this, "ClubId");
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
         * tClubのプロパティ名を返します。
         * 
         * @return tClubのプロパティ名
         */
        public _TClubNames tClub() {
            return new _TClubNames(this, "tClub");
        }
    }
}