package validatorTest

import org.scalatest.funsuite.AnyFunSuite
import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
class employe_valiTest extends AnyFunSuite{

  val FirstEmployeeSteve = Employee("Steve", "Rogers", 32,50000, "Software Consultant", "Knoldus", "Steve32@gmail.com" )
  val SecondEmployeeTony = Employee("Tony", "Stark", 26,30000, "Software Trainee", "Philips", "Stark43@gmail.com" )
  val ThirdEmployeeStephen = Employee("Stephen", "Curry", 43,65000, "Sr. Software Engineer", "CTS", "curry467@gmail.com" )
  val FourthEmployeeBen = Employee("Ben", "Tenison", 22,25000, "Software Consultant", "Knoldus", "Benteni?@gmail.com" )


  test("Checking if Employee- employeeOneDavid working in Knoldus(company present in Database) is a valid Employee"){
    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(FirstEmployeeSteve)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeTwoLeo working in Philips(company present in Database) is a valid Employee"){

    val expectResult = true
    val result = (new EmployeeValidator).employeeIsValid(SecondEmployeeTony)
    assert(expectResult == result)
  }


  test("Checking if Employee- employeeThreeSimon working in company TCS(company not present in Database) is thus an invalid Employee"){

    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(ThirdEmployeeStephen)
    assert(expectResult == result)
  }

  test("Checking if Employee- employeeFourSam working in Knoldus(company present in Database) having invalid Email ID is thus an invalid Employee"){
    val expectResult = false
    val result = (new EmployeeValidator).employeeIsValid(FourthEmployeeBen)
    assert(expectResult == result)
  }

}
