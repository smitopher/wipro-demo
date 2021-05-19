package com.cjssolutions.wipro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.cjssolutions.wipro.entity.ClusterEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = @Index(name = "ix_name", columnList = "name", unique = true))
public class ClusterModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Long serverCount;
	
	public ClusterEntity toEntity() {
		return ClusterEntity.builder()
			.name(name)
			.serverCount(serverCount)
			.build();
	}

}
