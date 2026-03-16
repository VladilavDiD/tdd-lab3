package org.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyServiceImplTest {

    private final Company main = new Company(null, 2);

    private final Company book = new Company(main, 3);

    private final Company manager = new Company(main, 4);

    private final Company developer = new Company(manager, 8);

    private final Company design = new Company(manager, 6);

    private final Company laver = new Company(null, 1);

    private final List<Company> list = List.of(main, book, manager, developer, design);

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

    @Test
    void whenCompanyIsNullThenNull() {
        Company result = companyService.getTopLevelParent(null);
        Assertions.assertNull(result);
    }

    @Test
    void whenCompanyHasNoChildrenThenReturnOwnCount() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(developer, list);
        Assertions.assertEquals(8, result);
    }

    @Test
    void whenCompanyHasDirectChildrenThenReturnTotalCount() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(manager, list);
        Assertions.assertEquals(18, result);
    }

    @Test
    void whenCompanyHasDeepChildrenThenReturnTotalCount() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(main, list);
        Assertions.assertEquals(23, result);
    }

    @Test
    void whenCompanyIsNullForCountThenReturnZero() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(null, list);
        Assertions.assertEquals(0, result);
    }

    @Test
    void whenCompaniesListIsEmptyThenReturnOwnCount() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(main, List.of());
        Assertions.assertEquals(2, result);
    }

    @Test
    void whenCompaniesListIsNullThenReturnOwnCount() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(main, null);
        Assertions.assertEquals(2, result);
    }

    @Test
    void whenCompanyNotInListThenReturnOwnCount() {
        long result = companyService.getEmployeeCountForCompanyAndChildren(laver, list);
        Assertions.assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void getEmployeeCountForCompanyAndChildren() {
    }
}