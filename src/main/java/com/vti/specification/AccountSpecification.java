package com.vti.specification;

import com.vti.entity.Account;
import com.vti.entity.Account_;
import com.vti.entity.Department_;
import com.vti.form.AccountFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class AccountSpecification {
    public static Specification<Account> buildSpec(AccountFilterForm form) {
        if (form == null) {
            return null;
        }
        return (root, query, builder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%" + form.getSearch().trim() + "%";
                predicates.add(builder.or(
                        builder.like(root.get(Account_.username), pattern),
                        builder.like(root.get(Account_.department).get(Department_.name), pattern)
                ));
            }
            if (form.getMinId() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(Account_.id),
                        form.getMinId()
                ));
            }
            if (form.getMaxId() != null) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(Account_.id),
                        form.getMaxId()
                ));
            }
            if (form.getRole() != null) {
                predicates.add(builder.equal(
                        root.get(Account_.role),
                        form.getRole()
                ));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
