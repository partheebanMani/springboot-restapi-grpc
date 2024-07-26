package com.partheeban.component.grpc;

import com.partheeban.component.model.Employee;
import com.partheeban.component.service.EmployeeService;
import com.partheeban.grpc.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.partheeban.component.mapstruct.EmployeeMapper.EMPLOYEE_MAPPER;

@GrpcService
public class EmployeeGrpcService extends EmployeeServiceGrpc.EmployeeServiceImplBase {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void getEmployees(EmployeeRequest request, StreamObserver<EmployeesResponse> responseObserver) {

        try {
            List<Employee> employees = employeeService.getEmployee();
            System.out.println("employees " + employees.toString());
            List<GrpcEmployee> grpcEmployees = EMPLOYEE_MAPPER.employeePojoListToGrpcEmployeeList(employees);

            System.out.println(grpcEmployees.toString());
            EmployeesResponse employeesResponse = EmployeesResponse.newBuilder()
                    .addAllEmployee(grpcEmployees)
                    .build();

            responseObserver.onNext(employeesResponse);
            responseObserver.onCompleted();
        }catch (Exception e){
            System.out.println(e.getMessage());
            responseObserver.onError(e);
        }
    }

    @Override
    public void getEmployeeById(GetEmployeeByIdRequest request, StreamObserver<EmployeeResponse> responseObserver) {

        Long id = request.getId();
        Optional<Employee> employee = employeeService.getEmployee(id);

        if(employee.isEmpty()){
            responseObserver.onError(Status.NOT_FOUND.withDescription("Employee not found with id "+ id).asException());
            return;
        }

        EmployeeResponse employeeResponse = EmployeeResponse
                .newBuilder()
                .setEmployee(EMPLOYEE_MAPPER.employeePojoToGrpcEmployee(employee.get()))
                .build();
        responseObserver.onNext(employeeResponse);
        responseObserver.onCompleted();
    }


    @Override
    public void createEmployee(CreateEmployeeRequest request, StreamObserver<EmployeeResponse> responseObserver) {
        GrpcEmployee grpcEmployee = request.getGrpcEmployee();
        Employee employee = EMPLOYEE_MAPPER.grpcEmployeeToEmployee(grpcEmployee);
        Employee responseEmployee = employeeService.saveEmployee(employee);
        GrpcEmployee savedEmployee = EMPLOYEE_MAPPER.employeePojoToGrpcEmployee(responseEmployee);

        EmployeeResponse employeeResponse = EmployeeResponse.newBuilder()
                .setEmployee(savedEmployee)
                .build();

        responseObserver.onNext(employeeResponse);
        responseObserver.onCompleted();

    }

    @Override
    public void deleteEmployee(GetEmployeeByIdRequest request, StreamObserver<DeleteEmployeeResponse> responseObserver) {
        long id = request.getId();
        employeeService.deleteEmployee(id);
        DeleteEmployeeResponse deletedEmployeeDetailsFromDatabase = DeleteEmployeeResponse.newBuilder()
                .setResponse("Deleted employee details from Database")
                .build();
        responseObserver.onNext(deletedEmployeeDetailsFromDatabase);
        responseObserver.onCompleted();
    }
}
