package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceImplTest {

    private final Company main = new Company(null, 2);

    private final Company book = new Company(main, 3);

    private final Company manager = new Company(main, 4);

    private final Company developer = new Company(manager, 8);

    private final Company design = new Company(manager, 6);

    private final Company laver = new Company(null, 1);

    private final ICompanyService companyService = new CompanyServiceImpl();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenCompanyHasNoParentItIsOnTop() {
        Company result = companyService.getTopLevelParent(main);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsSingleItIsOnTop() {
        Company result = companyService.getTopLevelParent(laver);
        Assertions.assertEquals(laver, result);
    }

    @Test
    void whenCompanyHasOneStepToTheTopThenFindTop() {
        Company result = companyService.getTopLevelParent(book);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyHasTwoStepsToTheTopThenFindTop() {
        Company result = companyService.getTopLevelParent(developer);
        Assertions.assertEquals(main, result);
    }

    @org.junit.jupiter.api.Test
    void getEmployeeCountForCompanyAndChildren() {
    }
}