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
import tsuboneSystem.entity.TImageUpload;
import tsuboneSystem.names.TSubmitNames._TSubmitNames;
import tsuboneSystem.names.TTopAnnounceNames._TTopAnnounceNames;

/**
 * {@link TImageUpload}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/03/19 0:46:14")
public class TImageUploadNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<Integer> id() {
        return new PropertyName<Integer>("id");
    }

    /**
     * fileNameのプロパティ名を返します。
     * 
     * @return fileNameのプロパティ名
     */
    public static PropertyName<String> fileName() {
        return new PropertyName<String>("fileName");
    }

    /**
     * filePathのプロパティ名を返します。
     * 
     * @return filePathのプロパティ名
     */
    public static PropertyName<String> filePath() {
        return new PropertyName<String>("filePath");
    }

    /**
     * deleteFlagのプロパティ名を返します。
     * 
     * @return deleteFlagのプロパティ名
     */
    public static PropertyName<Boolean> deleteFlag() {
        return new PropertyName<Boolean>("deleteFlag");
    }

    /**
     * ImageFilePurposeのプロパティ名を返します。
     * 
     * @return ImageFilePurposeのプロパティ名
     */
    public static PropertyName<Integer> ImageFilePurpose() {
        return new PropertyName<Integer>("ImageFilePurpose");
    }

    /**
     * tTopAnnounceのプロパティ名を返します。
     * 
     * @return tTopAnnounceのプロパティ名
     */
    public static _TTopAnnounceNames tTopAnnounce() {
        return new _TTopAnnounceNames("tTopAnnounce");
    }

    /**
     * tSubmitのプロパティ名を返します。
     * 
     * @return tSubmitのプロパティ名
     */
    public static _TSubmitNames tSubmit() {
        return new _TSubmitNames("tSubmit");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _TImageUploadNames extends PropertyName<TImageUpload> {

        /**
         * インスタンスを構築します。
         */
        public _TImageUploadNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _TImageUploadNames(final String name) {
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
        public _TImageUploadNames(final PropertyName<?> parent, final String name) {
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
         * fileNameのプロパティ名を返します。
         *
         * @return fileNameのプロパティ名
         */
        public PropertyName<String> fileName() {
            return new PropertyName<String>(this, "fileName");
        }

        /**
         * filePathのプロパティ名を返します。
         *
         * @return filePathのプロパティ名
         */
        public PropertyName<String> filePath() {
            return new PropertyName<String>(this, "filePath");
        }

        /**
         * deleteFlagのプロパティ名を返します。
         *
         * @return deleteFlagのプロパティ名
         */
        public PropertyName<Boolean> deleteFlag() {
            return new PropertyName<Boolean>(this, "deleteFlag");
        }

        /**
         * ImageFilePurposeのプロパティ名を返します。
         *
         * @return ImageFilePurposeのプロパティ名
         */
        public PropertyName<Integer> ImageFilePurpose() {
            return new PropertyName<Integer>(this, "ImageFilePurpose");
        }

        /**
         * tTopAnnounceのプロパティ名を返します。
         * 
         * @return tTopAnnounceのプロパティ名
         */
        public _TTopAnnounceNames tTopAnnounce() {
            return new _TTopAnnounceNames(this, "tTopAnnounce");
        }

        /**
         * tSubmitのプロパティ名を返します。
         * 
         * @return tSubmitのプロパティ名
         */
        public _TSubmitNames tSubmit() {
            return new _TSubmitNames(this, "tSubmit");
        }
    }
}