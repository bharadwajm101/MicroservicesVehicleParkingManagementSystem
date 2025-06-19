package com.parking.user_service.repository;
import com.parking.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
    // This interface will automatically provide CRUD operations for User entity
    // Additional custom query methods can be defined here if needed
    User findByEmail(String email); // Example of a custom query method to find a user by email

}
