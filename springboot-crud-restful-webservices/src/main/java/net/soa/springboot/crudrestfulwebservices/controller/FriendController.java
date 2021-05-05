package net.soa.springboot.crudrestfulwebservices.controller;

import net.soa.springboot.crudrestfulwebservices.exception.ResourceNotFoundException;
import net.soa.springboot.crudrestfulwebservices.model.Friend;
import net.soa.springboot.crudrestfulwebservices.repo.FriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FriendController {
    @Autowired
    private FriendRepo friendRepo;

    // Create Get all employees API
    @GetMapping("/friends")
    public List<Friend> getAllEmployees() {
        return friendRepo.findAll();
    }

    // Create employee
    @PostMapping("/friends")
    public Friend createEmployee(@RequestBody Friend friend) {
        return friendRepo.save(friend);
    }

    // Get employee by id
    @GetMapping("friends/{id}")
    public ResponseEntity<Friend> getEmployeeById(@PathVariable(name = "id") long frId) throws ResourceNotFoundException {
        Friend friend = friendRepo.findById(frId).orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id: " + frId));
        return ResponseEntity.ok().body(friend);
    }

    // Update employee
    @PutMapping("/friends/{id}")
    public ResponseEntity<Friend> updateEmployee(@PathVariable(name = "id") long frId, @Valid @RequestBody Friend friendDetails) throws ResourceNotFoundException {
        Friend friend = friendRepo.findById(frId).orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id: " + frId));
        friend.setFirstname(friendDetails.getFirstname());
        friend.setLastname(friendDetails.getLastname());
        friend.setMeetingSpot(friendDetails.getMeetingSpot());
        friendRepo.save(friend);
        return ResponseEntity.ok().body(friend);
    }

    // Delete employee by id
    @DeleteMapping("/friends/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") long frId) throws ResourceNotFoundException {
        friendRepo.findById(frId).orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id: " + frId));
        friendRepo.deleteById(frId);
        return ResponseEntity.ok().build();
    }

}
