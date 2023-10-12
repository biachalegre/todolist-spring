package br.com.beatrizchalegre.todolist.users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

 /**-----------------------------------------------------------------------------------------------------------------------
  **                                                    ANNOTATIONS
  @Data -> Cria os getters and setters dos atributos
  
  @Entity(name = "name") -> Cria a tabela e você pode especificar um alias
  
  @Id -> informa que aquele atributo é a chave primária
 
  @GeneratedValue -> o Spring Data JPA gera o ID automaticamente
  
  @Column -> nome da coluna
  *-----------------------------------------------------------------------------------------------------------------------**/

@Data
@Entity(name = "tb_users")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "nm_person")
    private String name;

    @Column(name = "ds_username", unique = true)
    private String username;

    @Column(name = "ds_password")
    private String password;

    @CreationTimestamp
    @Column(name = "dt_insert")
    private LocalDateTime createdAt;
}
