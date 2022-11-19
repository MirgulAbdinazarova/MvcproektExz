package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;

import java.util.List;

public interface CompanyRepository {

    void saveCompany(Company company);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    void updateCompany(Company company);

    void deleteCompanyById(Long id);
}
