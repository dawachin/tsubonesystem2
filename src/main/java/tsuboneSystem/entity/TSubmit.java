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
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * TSubmitエンティティクラス
 * 
 * @author oowada
 */
@Entity
public class TSubmit implements Serializable {
	
	private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true, unique = true)
    public Integer id;
    
    /** 登録者 */
    @Column(nullable = true)
    public Integer registId;
    
    /** お知らせID */
    @Column()
    public Integer topAnnounceId;
    
    /** 提出物の目的タグ */
    @Column()
    public Integer submitTagKindId;
    
    /** 作品名 */
    @Column(nullable = true)
    public String submitName;
    
    /** 作品の説明 */
    @Column(columnDefinition ="mediumtext")
    public String submitDetail;
    
    /** 作品のキャプション画像ID */
    @Column()
    public Integer submitCaptionImageId;
    
    /** 提出物の名前 */
    @Column()
    public String submitProductFileName;
    
    /** 提出物の保存先 */
    @Column()
    public String submitProductFilePath;
    
    /** SoundCloudの作品URL(DTM部用) */
    @Column(columnDefinition ="mediumtext")
    public String soundCloudUrl;
    
    /** 提出物の種別(大まかな拡張子の種類:"画像系""ソフト系") */
    @Column()
    public Integer submitProductFileType;
    
    /** 削除フラグ */
    @Column(columnDefinition ="boolean default '0'")
    public Boolean  deleteFlag;
    
    @ManyToOne
    @JoinColumn(name = "TOP_ANNOUNCE_ID", referencedColumnName = "ID")
    public TTopAnnounce tTopAnnounce;
    
    @ManyToOne
    @JoinColumn(name = "SUBMIT_TAG_KIND_ID", referencedColumnName = "ID")
    public TSubmitTagKind tSubmitTagKind;
    
    @ManyToOne
    @JoinColumn(name = "REGIST_ID", referencedColumnName = "ID")
    public TMember tMember;
    
    @OneToOne()
    @JoinColumn(name = "SUBMIT_CAPTION_IMAGE_ID", referencedColumnName = "ID")
    public TImageUpload tImageUpload;
}