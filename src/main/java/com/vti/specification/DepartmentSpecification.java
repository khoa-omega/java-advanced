package com.vti.specification;

import com.vti.entity.Account_;
import com.vti.entity.Department;
import com.vti.entity.Department_;
import com.vti.form.DepartmentFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class DepartmentSpecification {
    public static Specification<Department> buildSpec(DepartmentFilterForm form) {
        if (form == null) {
            return null;
        }
        return (root, query, builder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(form.getSearch())) {
                String pattern = "%" + form.getSearch().trim() + "%";
                predicates.add(builder.or(
                        builder.like(root.get(Department_.name), pattern),
                        builder.like(root.join(Department_.accounts).get(Account_.username), pattern)
                ));
            }
            if (form.getType() != null) {
                predicates.add(builder.equal(
                        root.get(Department_.type),
                        form.getType()
                ));
            }
            if (form.getCreatedAt() != null) {
                predicates.add(builder.equal(
                        root.get(Department_.createdAt),
                        form.getCreatedAt()
                ));
            }
            if (form.getMinCreatedYear() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        builder.function("YEAR", Integer.class, root.get(Department_.createdAt)),
                        form.getMinCreatedYear()
                ));
            }
            if (form.getMinCreatedAt() != null) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(Department_.createdAt),
                        form.getMinCreatedAt()
                ));
            }
            if (form.getMaxCreatedAt() != null) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(Department_.createdAt),
                        form.getMaxCreatedAt()
                ));
            }
            if (form.getMinTotalAccounts() != null) {
                query.groupBy(root.get("id")).having(
                        builder.greaterThanOrEqualTo(
                                builder.count(root.join("accounts", JoinType.LEFT)),
                                form.getMinTotalAccounts()
                        )
                );
            }
            if (form.getMaxTotalAccounts() != null) {
                query.groupBy(root.get("id")).having(
                        builder.lessThanOrEqualTo(
                                builder.count(root.join("accounts", JoinType.LEFT)),
                                form.getMaxTotalAccounts()
                        )
                );
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
