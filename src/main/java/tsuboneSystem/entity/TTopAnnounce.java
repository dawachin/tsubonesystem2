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
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * TMemberエンティティクラス
 * 
 * @author oowada
 */
@Entity
@Table(name = "T_TOP_ANNOUNCE")
public class TTopAnnounce implements Serializable {
	
	private static final long serialVersionUID = 1L;

    /** idプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = true, unique = true)
    public Integer id;
    
    /** お知らせの作成者 */
    @Column(nullable = false, unique = false)
    public Integer  registMemberId;
    
    /** お知らせの画像ID */
    @Column(nullable = true, unique = false)
    public Integer  imageId;
    
    /** お知らせのタイトル */
    @Column(nullable = true, unique = false)
    public String  announceTitle;
    
    /** お知らせの内容 */
    @Column(nullable = true, unique = false, columnDefinition ="mediumtext")
    public String  announceContent;
    
    /** お知らせ掲載日(開始)　*/
    @Column()
    @Temporal(TemporalType.DATE)
	public Date announceFromDay;
    
    /** お知らせ掲載日(終了)　*/
    @Column()
    @Temporal(TemporalType.DATE)
	public Date announceToDay;
    
    /** 削除フラグ */
    @Column(columnDefinition ="boolean default '0'")
    public Boolean  deleteFlag;
    
    /** TTopAnnounce(registMemberId) = TMember(id) */
    @ManyToOne
    @JoinColumn(name = "REGIST_MEMBER_ID", referencedColumnName = "ID")
    public TMember tMember;
    
    @OneToOne()
    @JoinColumn(name = "IMAGE_ID", referencedColumnName = "ID")
    public TImageUpload tImageUpload;
    
    @OneToMany(mappedBy = "tTopAnnounce")
    public List<TSubmit> tSubmitList;
    
    @Transient
    public boolean submitFlag = false;
}