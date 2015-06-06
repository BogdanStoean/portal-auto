package ro.rocknrolla.portal_auto.controller.saas;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;


@Controller
@RequestMapping("/push")
public class PushController {

    private final String apiKey = "AIzaSyA_eisUGjuLr6KBJxLWyNifVjCiQqOGozw"; // todo: get from proprieties

    @RequestMapping(method = RequestMethod.GET, value = "/send")
    public void pushTest() {

        String registrationId = "test"; //todo: get registerId from db

        Sender sender = new Sender(apiKey);

        Message message = new Message.Builder()
                .addData("message", "this is the message")
                .build();
        try {
            Result result = sender.send(message, registrationId, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
