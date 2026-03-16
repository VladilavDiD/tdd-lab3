package org.example;

import java.util.List;

public class CompanyServiceImpl implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company child) {
        if (child == null) {
            return null;
        }
        if (child.getParent() == null){
            return child;
        }
        return getTopLevelParent(child.getParent());
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company == null) {
            return 0;
        }

        // Починаємо з кількості співробітників самої компанії
        long totalCount = company.getEmployeeCount();

        // Якщо списку немає, повертаємо те, що є
        if (companies == null || companies.isEmpty()) {
            return totalCount;
        }

        // Проходимо по всіх компаніях у списку і шукаємо тих, для кого поточна є батьком
        for (Company c : companies) {
            if (c.getParent() == company) {
                // Якщо знайшли "дитину", рекурсивно додаємо її співробітників та співробітників ЇЇ дітей
                totalCount += getEmployeeCountForCompanyAndChildren(c, companies);
            }
        }

        return totalCount;
    }
}
