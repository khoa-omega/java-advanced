package com.vti.entity;

import com.vti.entity.Student.Gender;
import com.vti.repository.StudentRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class StudentCodeGenerator implements IdentifierGenerator {
    private final StudentRepository repository = new StudentRepository();

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Student student = (Student) object;
        Gender gender = student.getGender();
        long count = repository.countByGender(gender);
        return String.format("%c-%d", gender.getCode(), count + 1);
    }
}
