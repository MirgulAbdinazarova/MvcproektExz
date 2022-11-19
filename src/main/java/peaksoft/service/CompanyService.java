package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {
    void saveCompany(Company company);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    void updateCompany(Company company);

    void deleteCompanyById(Long id);
}
