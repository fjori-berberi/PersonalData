package com.springboot.personaldata.service;

import com.springboot.personaldata.model.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }



    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    public ResponseEntity<String> addNewUser(String name, String surname){
            User user= new User();
            user.setName(name);
            user.setSurname(surname);
            entityManager.persist(user);
            return new ResponseEntity<>("User added!", HttpStatus.OK);
        }

        @SuppressWarnings("unchecked")

    public List<User> findAll() {
         List<User> users = entityManager.createNativeQuery("select * from user", User.class).getResultList();
        return users;
    }

    public ResponseEntity<String> deleteUserById(int id) {
		User user = entityManager.find(User.class, id);
		
			entityManager.remove(user);

            return new ResponseEntity<>("User deleted.", HttpStatus.ACCEPTED);
		}
		
	}
