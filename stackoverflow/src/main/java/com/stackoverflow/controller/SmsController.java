package com.stackoverflow.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RequestMapping("/sms")
@RestController
public class SmsController {
    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {

        Twilio.init("ACdd577a7771a7b19800f3e0eeaa70d6c1", "e2e4d95f266bedc27fdc966b4d203855");

        Message.creator(new PhoneNumber("+40747546369"),
                new PhoneNumber("+13614597334"), "Hello from Twilio 📞, You have been banned from stackoverflow! sucker").create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }

}
