package com.cjssolutions.wipro.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjssolutions.wipro.entity.ClusterEntity;
import com.cjssolutions.wipro.model.ClusterModel;
import com.cjssolutions.wipro.repo.WiproRepository;

@Service 
public class WiproService {
	
	public enum InitialClusters {
		Amazon(850l),
		Michigan(904l),
		Rhino(1208l),
		Tahoe(150l);
		private final Long count;

		private InitialClusters(long count) {
			this.count = count;
		}

		public Long getCount() {
			return count;
		}
		
	}
	
	@Autowired
	private WiproRepository repo;
	
	public Map<String, Long> getAll() {
		return repo.findAll()
			.stream()
			.map(c -> c.toEntity())
			.sorted()
			.collect(Collectors.toMap(
					ClusterEntity::getName,
					ClusterEntity::getServerCount,
					(o1,o2) -> o1,  LinkedHashMap::new));
	}
	
	@Transactional
	public ClusterEntity incrementServer(String name, int incrementValue) {
		return processInrement(repo.findByName(name).orElseThrow(), incrementValue);
	}
	
	private ClusterEntity processInrement(ClusterModel clusterModel, int increment) {
		clusterModel.setServerCount(Long.sum(clusterModel.getServerCount(), increment));
		repo.save(clusterModel);
		return  clusterModel.toEntity();
	}
	
	@PostConstruct
	private void postConstruct() {
		Arrays.stream(InitialClusters.values())
			.filter(c -> repo.findByName(c.name()).isEmpty())
			.forEach(c -> addInitialCluster(c));
	}
	
	private void addInitialCluster(InitialClusters cluster) {
		var cm = ClusterModel.builder()
				.name(cluster.name())
				.serverCount(cluster.count)
				.build();
		repo.save(cm);
	}
	
}
