package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.rocknrolla.portal_auto.controller.bean.DocumentModel;
import ro.rocknrolla.portal_auto.entities.Document;
import ro.rocknrolla.portal_auto.repositories.DocumentsRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    @Autowired
    private DocumentsRepository documentsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<DocumentModel> getDocumentsList() {
        List<Document> all = documentsRepository.findAll();
        List<DocumentModel> dn = new ArrayList<>();
        for (Document d : all) {
            dn.add(new DocumentModel(d));
        }
        return dn;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<DocumentModel> create(@RequestBody @Valid DocumentModel documentModel) {
        Document save = documentsRepository.save(documentModel.getDocumentEntity());
        return new ResponseEntity<>(new DocumentModel(save), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{documentId}", method = RequestMethod.GET)
    public DocumentModel getCarById(@PathVariable("documentId") Long documentId) {
        return new DocumentModel(documentsRepository.getOne(documentId));
    }
}
