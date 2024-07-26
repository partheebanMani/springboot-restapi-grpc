package com.partheeban.component.mapstruct;

import com.partheeban.component.model.Employee;
import com.partheeban.grpc.GrpcEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    GrpcEmployee employeePojoToGrpcEmployee(Employee employee);

    List<GrpcEmployee> employeePojoListToGrpcEmployeeList(List<Employee> employee);

    Employee grpcEmployeeToEmployee(GrpcEmployee grpcEmployee);

}
