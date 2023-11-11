package bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import bank.service.AccountService;

@Controller
public class AccountMutation {

    @Autowired
    AccountService accountService;

    @MutationMapping
    public void deleteAccount(Long accountnumber) {
        accountService.delete(accountnumber);
    }

    @MutationMapping
    public void deposit(Long accountnumber, Double amount) {
        accountService.deposit(accountnumber, amount);
    }

    @MutationMapping
    public void withdraw(Long accountnumber, Double amount) {
        accountService.withdraw(accountnumber, amount);
    }

}
