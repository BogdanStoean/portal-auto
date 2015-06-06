package ro.rocknrolla.portal_auto.controller.webservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webservice")
public class DataFetch {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataFetch.class);

    @RequestMapping(value = "/carInformation/{data}", method = RequestMethod.GET)
    public ResponseEntity getPrincipal(@PathVariable String data) {

        return ResponseEntity.ok("");
    }
}
