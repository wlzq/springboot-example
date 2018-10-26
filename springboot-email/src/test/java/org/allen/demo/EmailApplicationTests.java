package org.allen.demo;

import org.allen.demo.service.EmailSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailApplicationTests {

    @Autowired
    private EmailSenderService emailSenderService;

    @Test
    public void contextLoads() {
        String to = "receiver email";
        String subject = "email subject";
        //String content = "This is the test message, see when the message has been sent successfully!";
        //emailSenderService.sendTextMail(to, subject, content);

        String content = "<html><body><span style='color:yellow'>This is the test mail containing HTML, see when the message has been sent successfully!<span><img " +
                "src='cid:imgSrcContentId'></body><html>";
        emailSenderService.sendHtmlTextMail(subject, content, to);

//        String content = "This is the test with the attachment of the mail, when you see that the mail with attachment has been sent successfully!";
//        String filePath = "your file path";
//        String fileName = "your file name";
//        emailSenderService.sendAttachmentMail(subject, content, to, filePath, fileName);

//        List<String> ccList = new ArrayList<String>();
//        ccList.add("Cc 'er 1's mailbox");
//        ccList.add("Cc 'er 2's mailbox");
//        ...
//        ccList.add("Cc 'er n's mailbox");
//        emailSenderService.sendTextMail(subject, content, ccList, "Recipient 1's mailbox", "Recipient 2's mailbox",
// ..., "Recipient n's mailbox");

    }

}
