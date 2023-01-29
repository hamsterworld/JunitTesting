package junit.testing.ch7.finalstep;

public class CompanyFactory {
    public static Company createCompany(Object[] companyData) {

        validate(companyData);

        Company company = new Company();
        company.setDomainName((String) companyData[0]);
        company.setNumberOfEmployees(Integer.parseInt((String) companyData[1]));

        return company;
    }

    private static void validate(Object[] companyData){
        if(companyData.length < 2){
            throw new IllegalArgumentException("잘못된 Data 가 들어왔습니다.");
        }
    }
}
