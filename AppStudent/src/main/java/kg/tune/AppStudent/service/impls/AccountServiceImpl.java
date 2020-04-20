package kg.tune.AppStudent.service.impls;

import kg.tune.AppStudent.entity.Account;
import kg.tune.AppStudent.repository.AccountRepo;
import kg.tune.AppStudent.service.AccountService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepo accountRepo;

    @Override
    public Account addAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        Optional<Account> account = accountRepo.findById(id);
        return account.get();
    }

    @Override
    public Account updateAccount(Long id, Account account) {
        if(accountRepo.findById(id).isPresent()) {
            Account existingAccount = accountRepo.findById(id).get();
            existingAccount.setBankDetails(account.getBankDetails());
            existingAccount.setCurrency(account.getCurrency());
            existingAccount.setStudent(account.getStudent());
            Account updatedAccount = accountRepo.save(existingAccount);
            return updatedAccount;
        }
        else return null;
    }

    @Override
    public String deleteAccountById(Long id) {
        String result = "deleted " + accountRepo.findById(id);
        accountRepo.deleteById(id);
        return result;
    }

    @Override
    public List<Account> getAccountsByStudent(Long id) {
        return accountRepo.findByStudent_Id(id);
    }
}
