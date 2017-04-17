package com.previsto.billy.mapping;

import com.previsto.billy.model.Account;
import com.previsto.billy.model.AccountGroup;
import com.previsto.billy.model.City;
import java.util.List;

public abstract class AccountMapping extends BaseMapping<Account> {

    private List<AccountGroup> accountGroups;

    public List<AccountGroup> getAccountGroups() {
        return accountGroups;
    }

    public void setAccountGroups(List<AccountGroup> accountGroups) {
        this.accountGroups = accountGroups;
    }
    
    @Override
    protected void resolveExtraData(Account entity) {
        if (entity.getGroupId() != null && getAccountGroups()!= null) {
            for (AccountGroup group : getAccountGroups()) {
                if (group.getId().equals(entity.getGroupId())) {
                    entity.setGroup(group);
                }
            }
        }
    }
    
}
