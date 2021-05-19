package com.cjssolutions.wipro.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjssolutions.wipro.model.ClusterModel;

public interface WiproRepository extends JpaRepository<ClusterModel, Long> {
	
	public Optional<ClusterModel> findByName(String name);

}
