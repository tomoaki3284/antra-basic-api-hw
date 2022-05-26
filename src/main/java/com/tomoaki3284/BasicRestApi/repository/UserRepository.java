package com.tomoaki3284.BasicRestApi.repository;

import com.tomoaki3284.BasicRestApi.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Override
	Optional<User> findById(Long uid);
	
	@Override
	List<User> findAll();
	
	@Override
	void deleteById(Long aLong);
	
	@Override
	<S extends User> S save(S entity);
}
