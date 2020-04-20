package kg.tune.AppStudent.controller;

import kg.tune.AppStudent.entity.Account;
import kg.tune.AppStudent.service.AccountService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping
    public Account create(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/modify/{id}")
    public Account update(@PathVariable("id") Long id, @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/byStudent/{id}")
    public List<Account> getAllByStudent(@PathVariable Long id) {
        return accountService.getAccountsByStudent(id);
    }
}
