package org.allen.demo.service.impl;

import org.allen.demo.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送简单文本邮件
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param to 收件人
     */
    @Override
    public void sendTextMail(String subject, String content, String... to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setSentDate(new Date());
        javaMailSender.send(mailMessage);
    }

    /**
     * 发送包含html标签内容的邮件
     * @param subject 邮件主题
     * @param htmlContent 邮件内容
     * @param to 收件人
     */
    @Override
    public void sendHtmlTextMail(String subject, String htmlContent, String to) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
            helper.setSentDate(new Date());

            FileSystemResource fsr = new FileSystemResource(new File("C:\\Users\\admin\\Pictures\\Camera Roll\\光头强.jpg"));
            helper.addInline("imgSrcContentId", fsr);//此处的contentId需要和html中的对应

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送带附件邮件
     * @param subject 主题
     * @param content 邮件内容
     * @param to 收件人
     * @param filePath 附件路径
     * @param fileName 附件名
     */
    @Override
    public void sendAttachmentMail(String subject, String content, String to, String filePath, String fileName) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            //附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(fileName, file);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送简单文本邮件 并抄送
     * @param subject
     * @param content
     * @param ccList 抄送人
     * @param tos 收件人，多个时用逗号隔开
     */
    @Override
    public void sendTextMail(String subject, String content, List<String> ccList, String... tos) {
        //收件人
        InternetAddress[] addressesTo = new InternetAddress[tos.length];
        if(tos != null && tos.length>0){
            for(int i=0;i<tos.length;i++){
                InternetAddress addressTo = null;
                try {
                    addressTo = new InternetAddress(tos[i]);
                    addressesTo[i] = addressTo;
                } catch (AddressException e) {
                    e.printStackTrace();
                }
            }
        }
        //抄送人
        InternetAddress[] addressesCc = new InternetAddress[ccList.size()];
        if(ccList != null && ccList.size() > 0){
            for(int i=0;i<ccList.size();i++){
                String ccAdd = ccList.get(i);
                InternetAddress address = null;
                try {
                    address = new InternetAddress(ccAdd);
                    addressesCc[i] = address;
                } catch (AddressException e) {
                    e.printStackTrace();
                }
            }
        }

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(from);
                mimeMessage.setSubject(subject);
                mimeMessage.setText(content);
                mimeMessage.setRecipients(Message.RecipientType.TO, addressesTo);
                mimeMessage.setRecipients(Message.RecipientType.CC, addressesCc);
            }
        };
        javaMailSender.send(preparator);
    }

}
