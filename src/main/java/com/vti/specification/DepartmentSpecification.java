package com.vti.specification;

import com.vti.entity.Account;
import com.vti.entity.Account_;
import com.vti.entity.Department;
import com.vti.entity.Department_;
import com.vti.form.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

public class DepartmentSpecification {
    public static Specification<Department> buildWhere(DepartmentFilterForm form) {
        return hasUsernameLike(form.getSearch());
    }

    public static Specification<Department> hasUsernameLike(String value) {
        return (root, query, builder) -> {
            if (!StringUtils.hasText(value)) {
                return null;
            }
            Join<Department, Account> join = root.join(Department_.accounts, JoinType.LEFT);
            return builder.like(join.get(Account_.username), "%" + value.trim() + "%");
        };
    }
}
