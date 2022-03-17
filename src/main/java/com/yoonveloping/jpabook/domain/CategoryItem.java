package com.yoonveloping.jpabook.domain;

import com.yoonveloping.jpabook.domain.item.Item;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CategoryItem {

	@Id @GeneratedValue
	@Column(name = "category_item_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
}
