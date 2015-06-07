package ro.rocknrolla.portal_auto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.rocknrolla.portal_auto.controller.bean.DocumentModel;
import ro.rocknrolla.portal_auto.entities.Document;
import ro.rocknrolla.portal_auto.repositories.CarRepository;
import ro.rocknrolla.portal_auto.repositories.DocumentsRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bogdan Stoean on 6/7/15.
 */
@Service
@Transactional
public class DocumentService {


    @Autowired
    private DocumentsRepository documentsRepository;

    @Autowired
    private CarRepository carRepository;


    public List<DocumentModel> getDocumentsListByCar(Long carId) {
        List<Document> all = documentsRepository.findByCarId(carId);
        List<DocumentModel> dn = new ArrayList<>();
        for (Document d : all) {
            dn.add(new DocumentModel(d));
        }
        return dn;
    }

    public DocumentModel getById(Long documentId) {
        return new DocumentModel(documentsRepository.findOne(documentId));
    }

    public DocumentModel create(DocumentModel documentModel) {
        return new DocumentModel(documentsRepository.save(getDocumentEntity(documentModel)));
    }

    private Document getDocumentEntity(DocumentModel documentModel) {
        Document document;

        if (documentModel.getId() != null) {
            document = documentsRepository.findOne(documentModel.getId());
        } else {
            document = new Document();
        }
        document.setName(documentModel.getName());
        document.setActivationDate(documentModel.getActivationDate());
        document.setExpirationDate(documentModel.getExpirationDate());
        document.setCar(carRepository.findOne(documentModel.getCarId()));
        return document;
    }

}
