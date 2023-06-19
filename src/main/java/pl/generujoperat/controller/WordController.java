package pl.generujoperat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.generujoperat.helper.WordHelper;
import pl.generujoperat.model.Company;
import pl.generujoperat.model.TechnicalReport;
import pl.generujoperat.repositories.CompanyRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/api")
public class WordController {
        private final CompanyRepository companyRepo;

        public WordController(CompanyRepository companyRepo) {
                this.companyRepo = companyRepo;
            }
            
        @GetMapping()
        public String home(Model model) {
                model.addAttribute("technicalReport", new TechnicalReport());
                model.addAttribute("companies", companyRepo.findAll());
                return "form";
        }

        @PostMapping(value = "/word", produces = "application/vnd.openxmlformats-"
                        + "officedocument.wordprocessingml.document" )
        public ResponseEntity<InputStreamResource> word(@ModelAttribute TechnicalReport technicalReport,  
        @RequestParam("companyName") String companyName)
                        throws IOException, InvalidFormatException {

                ByteArrayInputStream bis = WordHelper.generateWord(technicalReport.getIdReport(), companyName);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition",
                                "inline; filename=mydoc.docx");
                return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        }
}
