package bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import bank.service.AccountDTO;
import bank.service.AccountService;

@Controller
public class AccountQuery {
    @Autowired
    AccountService accountService;

    @QueryMapping
    public AccountDTO getAccount(Long accountnumber) {
        AccountDTO accountDto = accountService.findByAccountNumber(accountnumber);
        return accountDto;

    }

}
