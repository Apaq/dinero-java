package com.previsto.billy.mapping;

import com.previsto.billy.model.Account;

public class SingularAccountMapping extends AccountMapping implements SingularMapping<Account> {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account contact) {
        this.account = contact;
    }

    @Override
    public Account getEntity() {
        resolveExtraData(account);
        return account;
    }

}
