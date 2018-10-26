package org.allen.demo.service;

import java.util.List;

public interface EmailSenderService {


    void sendTextMail(String subject, String content, String... to);

    void sendHtmlTextMail(String subject, String htmlContent, String to);

    void sendAttachmentMail(String subject, String content, String to, String filePath, String fileName);

    void sendTextMail(String subject, String content, List<String> ccList, String... tos);

}
