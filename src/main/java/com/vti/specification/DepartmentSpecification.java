package com.vti.specification;

import com.vti.entity.Account;
import com.vti.entity.Account_;
import com.vti.entity.Department;
import com.vti.entity.Department_;
import com.vti.form.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import java.time.LocalDate;

public class DepartmentSpecification {
    public static Specification<Department> buildWhere(DepartmentFilterForm form) {
        return hasUsernameLike(form.getSearch())
                .and(hasCreatedDateEqual(form.getCreatedDate()))
                .and(hasCreatedDateGreaterThanOrEqualTo(form.getMinCreatedDate()))
                .and(hasCreatedDateLessThanOrEqualTo(form.getMaxCreatedDate()))
                .and(hasCreatedYearGreaterThanOrEqualTo(form.getMinYear()));
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

    public static Specification<Department> hasCreatedDateEqual(LocalDate createdDate) {
        return (root, query, builder) -> {
            if (createdDate == null) {
                return null;
            }
            return builder.equal(root.get(Department_.createdDate).as(LocalDate.class), createdDate);
        };
    }

    public static Specification<Department> hasCreatedDateGreaterThanOrEqualTo(LocalDate minCreatedDate) {
        return (root, query, builder) -> {
            if (minCreatedDate == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(root.get(Department_.createdDate).as(LocalDate.class), minCreatedDate);
        };
    }

    public static Specification<Department> hasCreatedDateLessThanOrEqualTo(LocalDate maxCreatedDate) {
        return (root, query, builder) -> {
            if (maxCreatedDate == null) {
                return null;
            }
            return builder.lessThanOrEqualTo(root.get(Department_.createdDate).as(LocalDate.class), maxCreatedDate);
        };
    }

    public static Specification<Department> hasCreatedYearGreaterThanOrEqualTo(Integer minYear) {
        return (root, query, builder) -> {
            if (minYear == null) {
                return null;
            }
            return builder.greaterThanOrEqualTo(
                    builder.function("YEAR", Integer.class, root.get(Department_.createdDate)),
                    minYear
            );
        };
    }
}
