package bank.service;

import bank.domain.Account;
import bank.domain.AccountEntry;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter {

    public static AccountDTO getAccountDTO(Account account){
       AccountDTO accountDto = new AccountDTO();
       if (account != null){
           accountDto = new AccountDTO(account.getAccountnumber(),
                   account.getAccountHolder());
           accountDto.setBalance(account.getBalance());
           for (AccountEntry entry : account.getEntryList()){
               AccountEntryDTO entryDto = new AccountEntryDTO(entry.getDate(),
                       entry.getAmount(),
                       entry.getDescription());
               accountDto.addEntry(entryDto);
           }
       }
       return accountDto;
    }

    public static Account getAccount(AccountDTO accountDto){
        Account account = new Account();
        if (account != null){
            account = new Account(accountDto.getAccountnumber(),
                    accountDto.getAccountHolder());
            account.setBalance(accountDto.getBalance());
            for (AccountEntryDTO entryDto : accountDto.getEntryList()){
                AccountEntry entry = new AccountEntry(entryDto.getDate(),
                        entryDto.getAmount(),
                        entryDto.getDescription());
                account.addEntry(entry);
            }
        }
        return account;
    }

    public static List<AccountDTO> getAccountDTOList(List<Account> accounts){
        List<AccountDTO> accountDtoList = new ArrayList<AccountDTO>();
        if (accounts != null){
            for (Account account : accounts){
                accountDtoList.add(getAccountDTO(account));
            }
        }
        return accountDtoList;
    }
}
