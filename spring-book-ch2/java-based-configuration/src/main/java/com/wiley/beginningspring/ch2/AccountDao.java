package com.wiley.beginningspring.ch2;

import java.util.List;

/* Declares methods to perform basic persistence operations on a given Account
   and finder methods to find Account instances using some query parameters.
*/
public interface AccountDao {
    void insert(Account account);
    void update(Account account);
    void update(List<Account> accounts);
    void delete(long accountId);
    Account find(long accountId);
    List<Account> find(List<Long> accountIds);
    List<Account> find(String ownerName);
    List<Account> find(boolean locked);
}
