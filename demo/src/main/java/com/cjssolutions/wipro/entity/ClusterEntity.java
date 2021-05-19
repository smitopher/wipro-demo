package com.cjssolutions.wipro.entity;

import com.cjssolutions.wipro.model.ClusterModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClusterEntity implements Comparable<ClusterEntity>{
	
	private String name;
	
	private Long serverCount;
	
	public ClusterModel toModel() {
		return ClusterModel.builder()
				.name(name)
				.serverCount(serverCount)
				.build();
	}

	@Override
	public int compareTo(ClusterEntity o) {
		return name.toLowerCase().compareTo(o.getName().toLowerCase());
	}

}
