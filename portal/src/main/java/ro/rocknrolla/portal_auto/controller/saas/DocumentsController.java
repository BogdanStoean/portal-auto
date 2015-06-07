package ro.rocknrolla.portal_auto.controller.saas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.rocknrolla.portal_auto.controller.bean.DocumentModel;
import ro.rocknrolla.portal_auto.entities.Document;
import ro.rocknrolla.portal_auto.service.DocumentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping(method = RequestMethod.GET, value = "/car/{carId}")
    public List<DocumentModel> getDocumentsList(@PathVariable("carId") Long carId) {
        return documentService.getDocumentsListByCar(carId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<DocumentModel> create(@RequestBody @Valid DocumentModel documentModel) {
        return new ResponseEntity<>(documentService.create(documentModel), documentModel.getId() != null ? HttpStatus.OK : HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{documentId}", method = RequestMethod.GET)
    public DocumentModel getDocumentById(@PathVariable("documentId") Long documentId) {
        return documentService.getById(documentId);
    }


}
