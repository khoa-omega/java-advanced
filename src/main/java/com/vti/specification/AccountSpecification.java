package com.vti.specification;

import com.vti.entity.Account;
import com.vti.entity.Account_;
import com.vti.entity.Department_;
import com.vti.form.AccountFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class AccountSpecification {
    public static Specification<Account> buildWhere(AccountFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasUsernameLike(form.getSearch())
                .or(hasDepartmentNameLike(form.getSearch()))
                .and(hasIdGreaterThanOrEqualTo(form.getMinId()))
                .and(hasIdLessThanOrEqualTo(form.getMaxId()));
    }

    public static Specification<Account> hasDepartmentNameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(Account_.department).get(Department_.name), "%" + value.trim() + "%");
        };
    }

    public static Specification<Account> hasUsernameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            return builder.like(root.get(Account_.username), "%" + value.trim() + "%");
        };
    }

    public static Specification<Account> hasIdGreaterThanOrEqualTo(Integer minId) {
        return (root, query, builder) -> {
            if (minId == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(Account_.id), minId);
        };
    }

    public static Specification<Account> hasIdLessThanOrEqualTo(Integer maxId) {
        return (root, query, builder) -> {
            if (maxId == null) {
                return null;
            }
            return builder.lessThanOrEqualTo(root.get(Account_.id), maxId);
        };
    }
}
