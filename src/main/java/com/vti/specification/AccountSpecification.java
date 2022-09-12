package com.vti.specification;

import com.vti.entity.Account;
import com.vti.entity.Account_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class AccountSpecification {
    public static Specification<Account> hasUsernameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(Account_.username), "%" + value.trim() + "%");
        };
    }
}
