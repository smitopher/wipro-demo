package com.cjssolutions.wipro.rest;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjssolutions.wipro.entity.ClusterEntity;
import com.cjssolutions.wipro.service.WiproService;

@RestController
public class DemoControler {
	
	@Autowired
	WiproService service;
	
	@PostMapping("/cluster/{name}/server")
	@Secured(value = {"ROLE_ADMIN"})
	public ResponseEntity<ClusterEntity> addServer(@PathVariable String name) {
		try {
			return ResponseEntity.accepted().body(service.incrementServer(name, 1));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/cluster/{name}/server")
	@Secured(value = {"ROLE_ADMIN"})
	public ResponseEntity<ClusterEntity> removeServer(@PathVariable String name) {
		try {
			return ResponseEntity.accepted().body(service.incrementServer(name, -1));
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/clusters")
	public ResponseEntity<Map<String, Long>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("/resource")
	public Map<String, String> getSomething() {
		return Map.of(
				"id", UUID.randomUUID().toString(),
				"content", "Hello World");
	}

}
