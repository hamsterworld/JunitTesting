package junit.testing.ch7.twostep;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private static Stream<Arguments> InlineData(){
        return Stream.of(
                Arguments.of("mycorp.com","email@mycorp.com",true),
                Arguments.of("mycorp.com","email@gmail.com",false)
        );
    }

    @Test
    public void Changing_email_from_non_corporate_to_corporate(){

        Company company = new Company();
        company.setDomainName("mycorp.com");
        company.setNumberOfEmployees(1);
        User user = new User();
        user.setUserId(1);
        user.setEmail("user@gmail.com");
        user.setUserType(User.UserType.Customer);

        user.ChangeEmail("new@mycorp.com",company);

        assertEquals(2,company.getNumberOfEmployees());
        assertEquals("new@mycorp.com",user.getEmail());
        assertEquals(User.UserType.Employee,user.getUserType());
    }


    @ParameterizedTest
    @MethodSource("InlineData")
    public void Differentiates_a_corporate_email_from_non_corporate(String domain,String email,boolean expectedResult){
        Company company = new Company();
        company.setDomainName(domain);
        company.setNumberOfEmployees(0);

        boolean b = company.IsEmailCorporate(email);

        Assertions.assertEquals(expectedResult,b);
    }


}
