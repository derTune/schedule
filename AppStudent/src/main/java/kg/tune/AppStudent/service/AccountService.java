package kg.tune.AppStudent.service;

import kg.tune.AppStudent.entity.Account;

import java.util.List;

public interface AccountService {
    Account addAccount(Account account);
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account updateAccount(Long id, Account account);
    String deleteAccountById(Long id);
    List<Account> getAccountsByStudent(Long id);
}
