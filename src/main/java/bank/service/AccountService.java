package bank.service;

import bank.data.AccountRepository;
import bank.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;


    public void add(AccountDTO accountDto){
        accountRepository.save(AccountAdapter.getAccount(accountDto));
    }

    public void update(AccountDTO accountDto){
        accountRepository.save(AccountAdapter.getAccount(accountDto));
    }

    public AccountDTO findByAccountNumber(long accountNumber){
        Optional<Account> accOptional = accountRepository.findById(accountNumber);
        if (accOptional.isPresent()){
            return AccountAdapter.getAccountDTO(accOptional.get());
        }
        else{
            return null;
        }
    }

    public void delete(long accountNumber){
        Account account = accountRepository.findById(accountNumber).get();
        accountRepository.delete(account);
    }

    public Collection<AccountDTO> findAll(){
        List<Account> accounts = accountRepository.findAll();
        return AccountAdapter.getAccountDTOList(accounts);
    }

    public void deposit(long accountNumber, double amount){
        Account account = accountRepository.findById(accountNumber).get();
        account.deposit(amount);
        accountRepository.save(account);
    }

    public void withdraw(long accountNumber, double amount){
        Account account = accountRepository.findById(accountNumber).get();
        account.withdraw(amount);
        accountRepository.save(account);
    }
}
