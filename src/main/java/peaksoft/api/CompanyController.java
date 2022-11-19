package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

@Controller
public class CompanyController {

    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/allCompany")
    public String getAllCompany(Model model) {
        model.addAttribute("companies",companyService.getAllCompanies());
        return "/company/firstPage";
    }
    @GetMapping("/{CompanyId}")
    public String getComById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("company",companyService.getCompanyById(id));
        return "/company/innerPage";
    }
    @GetMapping("/new")
    public String newCompany(Model model){
        model.addAttribute("company",new Company());
        return "/company/newCompany";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/allCompany";
    }
    @PostMapping("/delete/{id}")
    public String deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return "redirect:/allCompany";
    }
    @GetMapping("/update")
    public String edit(@RequestParam("id") Long id, Company company,Model model) {
        model.addAttribute("company",companyService.getCompanyById(id));
        return "/company/update";
    }

    @PostMapping("/update")
     public String  updateCompany(@ModelAttribute("company")Company company) {
           companyService.updateCompany(company);
           return "redirect:/allCompany";
    }
}
