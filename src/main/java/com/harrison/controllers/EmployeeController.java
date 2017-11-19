package com.harrison.controllers;

import java.io.ByteArrayInputStream;

import com.aspose.words.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aspose.cells.Workbook;
import com.harrison.reflections.domain.EmployeeRead;
import com.harrison.reflections.domain.EmployeeWrite;
import com.harrison.reflections.repository.EmployeeReadRepository;
import com.harrison.reflections.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private EmployeeReadRepository employeeReadRepository;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeRead> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeReadRepository.findByEmployeeId(id), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmployeeWrite> createEmployee(@RequestBody EmployeeWrite employee) {
        return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/cells", method = RequestMethod.POST)
    public ResponseEntity<Void> cells(@RequestBody byte[] document) throws Exception {
        Workbook wb = new Workbook(new ByteArrayInputStream(document));
        wb.save("/tmp/out_excel.pdf");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResponseEntity<SaveOutputParameters> doStuff(@RequestBody  byte[] document) throws Exception {
        Document doc = new Document(new ByteArrayInputStream(document));
//        Document doc = new Document("/tmp/input.docx");
        SaveOutputParameters parameters = doc.save("/tmp/out.pdf");
        toc();
        return new ResponseEntity<>(parameters, HttpStatus.OK);
    }
    
    public void toc() throws Exception {
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
         
        // Insert a table of contents at the beginning of the document.
        builder.insertTableOfContents("\\o \"1-3\" \\h \\z \\u");
         
        // The newly inserted table of contents will be initially empty.
        // It needs to be populated by updating the fields in the document.
        doc.updateFields();
        String dataDir = "/tmp/";
        doc.save(dataDir + "AsposeTableOfContents.doc");
         
        // ==================================
        // Table Of Contents with Headings
        // ==================================
         
        Document doc1 = new Document();
         
        // Create a document builder to insert content with into document.
        builder = new DocumentBuilder(doc1);

        Style harrisonStyle = doc1.getStyles().add(StyleType.PARAGRAPH, "Harrison Style");
        harrisonStyle.getFont().setName("Verdana");
        harrisonStyle.getFont().setSize(14);

        // Insert a table of contents at the beginning of the document.
        builder.insertTableOfContents("\\o \"1-3\" \\h \\z \\u");
         
        // Start the actual document content on the second page.
        builder.insertBreak(BreakType.PAGE_BREAK);
         
        // Build a document with complex structure by applying different heading styles thus creating TOC entries.
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
         
        builder.writeln("Heading 1");
         
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_2);

        builder.writeln("Heading 1.1");
        builder.writeln("Heading 1.2");
         
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
         
        builder.writeln("Heading 2");
        builder.writeln("Heading 3");
         
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_2);
         
        builder.writeln("Heading 3.1");
         
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_3);
         
        builder.writeln("Heading 3.1.1");

            builder.getParagraphFormat().setStyle(harrisonStyle);
            builder.writeln("subsection text with a cool style");

        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_3);
        builder.writeln("Heading 3.1.2");
        builder.writeln("Heading 3.1.3");
         
        builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_2);
         
        builder.writeln("Heading 3.2");
        builder.writeln("Heading 3.3");
         
        // Call the method below to update the TOC.
        doc1.updateFields();
        doc1.save(dataDir + "AsposeTOCHeadings.doc");
    }
    
}
