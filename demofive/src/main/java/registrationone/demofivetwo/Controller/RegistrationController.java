package registrationone.demofivetwo.Controller;//case 3 new 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import registrationone.demofivetwo.Entity.Employee;
import registrationone.demofivetwo.Service.EmployeeService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private EmployeeService employeeService;

//    @PostMapping("/register")
//    public ResponseEntity registerEmployee(@RequestBody EmployeeRequest request) {
//        try {
//            Employee employee = employeeService.registerEmployee(request.getEmpNO(), request.getEmpName());
//            return ResponseEntity.ok(employee);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your request.");
//        }
//    }
    @GetMapping("/getEmpDetails")
    public ResponseEntity getEmployeeDetails(@RequestParam("empNo") String empNo) {
        try {
            Employee employeeDetails = employeeService.getEmployeeByEmpNO(empNo);
            return ResponseEntity.ok(employeeDetails);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing your request.");
        }
    }

//    public class EmployeeRequest {
//        private String empNO;
//        private String empName;
//
//        public String getEmpNO() {
//            return empNO;
//        }
//
//        public void setEmpNO(String empNO) {
//            this.empNO = empNO;
//        }
//
//        public String getEmpName() {
//            return empName;
//        }
//
//        public void setEmpName(String empName) {
//            this.empName = empName;
//        }
//    }
//
//}
public static class EmployeeRequest {
    private String empNO;
    private String empName;

    public EmployeeRequest() {
        // Default, no-argument constructor
    }

    public String getEmpNO() {
        return empNO;
    }

    public void setEmpNO(String empNO) {
        this.empNO = empNO;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
}
