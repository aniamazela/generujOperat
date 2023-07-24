package pl.generujoperat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.generujoperat.helper.WordHelper;
import pl.generujoperat.model.Company;
import pl.generujoperat.model.GeodeticWork;
import pl.generujoperat.model.TechnicalReport;
import pl.generujoperat.repositories.CompanyRepository;
import pl.generujoperat.repositories.GeodeticWorkRepository;
import pl.generujoperat.repositories.IdentifierRepository;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

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
        private final IdentifierRepository identifierRepo;
        private final GeodeticWorkRepository geodeticWorkRepo;

        public WordController(CompanyRepository companyRepo, IdentifierRepository identifierRepo,
                        GeodeticWorkRepository geodeticWorkRepo) {
                this.companyRepo = companyRepo;
                this.identifierRepo = identifierRepo;
                this.geodeticWorkRepo = geodeticWorkRepo;
        }

        @GetMapping()
        public String home(Model model) {
                model.addAttribute("technicalReport", new TechnicalReport());
                model.addAttribute("geodeticWork", new GeodeticWork());
                model.addAttribute("companies", companyRepo.findAll());
                return "form";
        }

        @PostMapping(value = "/word", produces = "application/vnd.openxmlformats-"
                        + "officedocument.wordprocessingml.document")
        public ResponseEntity<InputStreamResource> word(@ModelAttribute TechnicalReport technicalReport,
                        
                        @RequestParam("myDzialkaEwid") String myDzialkaEwid,
                        GeodeticWork geodeticWork, Model model)
                        throws IOException, InvalidFormatException {

                //Company company=companyRepo.findB
                                geodeticWork.setFinishDate(LocalDate.now());
                geodeticWorkRepo.save(geodeticWork);

                ByteArrayInputStream bis = WordHelper.generateWord(technicalReport.getIdReport(), "companyName",
                                myDzialkaEwid);
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Disposition",
                                "inline; filename=mydoc.docx");
                return ResponseEntity.ok().headers(headers).body(new InputStreamResource(bis));
        }
}
