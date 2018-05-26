package springtemplate.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springtemplate.dao.domain.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface UserRepository extends JpaRepository<User, Long> {

}
