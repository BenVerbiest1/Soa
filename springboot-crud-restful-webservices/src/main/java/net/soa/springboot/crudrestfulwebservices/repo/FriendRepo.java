package net.soa.springboot.crudrestfulwebservices.repo;

import net.soa.springboot.crudrestfulwebservices.model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepo extends JpaRepository<Friend, Long> {
}
