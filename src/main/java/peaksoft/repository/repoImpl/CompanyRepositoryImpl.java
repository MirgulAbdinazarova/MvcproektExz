package peaksoft.repository.repoImpl;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import peaksoft.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyRepositoryImpl  implements CompanyRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCompany(Company company) {
        entityManager.merge(company);

    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    @Transactional
    public List<Company> getAllCompanies() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }
}