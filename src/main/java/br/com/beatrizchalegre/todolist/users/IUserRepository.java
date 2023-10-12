package br.com.beatrizchalegre.todolist.users;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

// Crud gerado automaticamente pelo JPA

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
    
}
