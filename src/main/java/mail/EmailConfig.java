/*
 * Copyright (c) 2022.
 * Automation Framework Selenium - Anh Tester
 */

package mail;

import static Constants.FrameworkConstants.REPORT_TITLE;

/**
 * Data for Sending email after execution
 */
public class EmailConfig {


    //Enable Override Report and Send mail in config file => src/test/resources/config/config.properties
    //OVERRIDE_REPORTS=yes
    //send_email_to_users=yes

    public static final String SERVER = "smtp.gmail.com";
    public static final String PORT = "587";

    public static final String FROM = "zubairul.amin@cartlow.com";
    public static final String PASSWORD = "Kamalhogea100@";

    public static final String[] TO = {"zubairulamin8@gmail.com"};
    public static final String SUBJECT = REPORT_TITLE;
}