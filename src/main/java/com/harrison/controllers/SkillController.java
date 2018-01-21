package com.harrison.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.harrison.reflections.domain.Name;
import com.harrison.suggestedskills.domain.SuggestedSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.harrison.reflections.domain.Skill;
import com.harrison.reflections.repository.SkillRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "/api/skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    @Qualifier("reflectionsPlatformTransactionManager")
    private PlatformTransactionManager transactionManager;

    @PersistenceContext(name = "reflections", unitName = "reflections")
    private EntityManager reflectionsEntityManager;

    @PersistenceContext(name = "suggestedSkills", unitName = "suggestedSkills")
    private EntityManager suggestedSkillsEntityManager;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Skill>> getSkills() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        List<Skill> skills = transactionTemplate.execute(new TransactionCallback<List<Skill>>() {
            @Override
            public List<Skill> doInTransaction(TransactionStatus status) {
                return skillRepository.findAllOrderByYearsOfExperience();
            }
        });
        System.out.println(reflectionsEntityManager.find(Name.class, 1L));
        System.out.println(suggestedSkillsEntityManager.find(SuggestedSkill.class, "AI"));
        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    @RequestMapping(value = "/convert")
    public ResponseEntity<byte[]> convert() throws IOException {

        Path path = Paths.get("/Users/harrisonhocker/Documents/testing.docx");
        byte[] data = Files.readAllBytes(path);
//        Files.getF

        RestTemplate rt = new RestTemplate();

        MultipartFile multipartFile;

        MultiValueMap<String, Object> map = new LinkedMultiValueMap();

        map.add("file", new ByteArrayResource(data) {
            @Override
            public String getFilename() {
                return "testing.docx";
            }
        });
//        map.add("file", new FileSystemResource("/Users/harrisonhocker/Documents/testing.docx")); //THIS WORKS!!!
        map.add("inputformat", "docx");
        map.add("outputformat", "pdf");
        map.add("input", "upload");
        map.add("wait", true);
        map.add("download", true);
//        map.add("Content-Disposition", "form-data");
//        map.add("name", "testing.docx");
//        map.add("filename", "testing.docx");

        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer Bearer ZST2_kk2o72t-xsf6GA8i99g3vSdaoSZElVcfJ_d-BRUpn5gyjA7MYJiWOWvSaZ8_nLd7g2vaCRa6uuTbM49nw");
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        headers.setContentDispositionFormData("file","testing.docx");

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<byte[]> response = rt.exchange("https://api.cloudconvert.com/convert?apikey=ZST2_kk2o72t-xsf6GA8i99g3vSdaoSZElVcfJ_d-BRUpn5gyjA7MYJiWOWvSaZ8_nLd7g2vaCRa6uuTbM49nw", HttpMethod.POST, entity, byte[].class);

        return response;

    }    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Skill> getSkill(@PathVariable("name") String name) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        Skill skill = transactionTemplate.execute(new TransactionCallback<Skill>() {
            @Override
            public Skill doInTransaction(TransactionStatus status) {
                return skillRepository.findByName(name);
            }
        });
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

}
