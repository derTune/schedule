package kg.company.blogProject.services;

import kg.company.blogProject.entities.User;
import kg.company.blogProject.enums.Role;

import java.util.Date;
import java.util.List;

public interface UserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    String deleteUserById(Long id);
    List<User> getUserByNickname(String nickname);
    List<User> getUserByFirstName(String firstName);
    List<User> getUserByLastName(String lastName);
    List<User> getUserByFirstNameAndLastName(String firstName, String lastName);
    List<User> getUserByRegistrationDate(Date registrationDate);
    List<User> getUserByRegistrationDateBetween(Date initRegistrationDate, Date finalRegistrationDate);
    List<User> getUserByRegistrationDateGreaterThan(Date initRegistrationDate);
    List<User> getUserByRole(Role role);
}
