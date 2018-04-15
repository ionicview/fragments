package spider;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {
    /** LOGGER */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    static void send(String addTo, String subject, String msg) {

        String myEmailAddr = "******@163.com";

        if (StringUtils.isEmpty(addTo)) {
            addTo = myEmailAddr;
        }

        Email email = new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication(myEmailAddr, "******");
        email.setSSLOnConnect(true);
        email.setSmtpPort(465);

        try {

            email.setFrom(myEmailAddr);
            email.addTo(addTo);
            email.setSubject(subject);
            email.setMsg(msg);

            email.send();
            LOGGER.info("send email " + addTo + " success.");

        } catch (EmailException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
