package validatorTest

import org.scalatest.funsuite.AnyFunSuite
import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator

class company_valiTest extends AnyFunSuite {

  val FirstCompany = new Company("Fnatic", "FNC3@gmail.com", "Mumbai")
  val SecondCompany = new Company("Philips", "philips67@gmail.com", "Noida")
  val ThirdCompany = new Company("IBM", "IBM23gmail.com", "chennai")


  test("Checking if the first company is not present in database and is thus a valid entry") {
    val expectedResult = true
    val result = (new CompanyValidator).companyIsValid(FirstCompany)
    assert(expectedResult == result)
  }

  test("Checking if second company is already exist in the database and it is an invalid entry") {
    val expectedResult = false
    val result = (new CompanyValidator).companyIsValid(SecondCompany)
    assert(expectedResult == result)
  }

  test("Checking if third company is not present in database but having invalid email ID without '@'is thus an invalid entry") {
    val expectedResult = false
    val result = (new CompanyValidator).companyIsValid(ThirdCompany)
    assert(expectedResult == result)
  }

}
