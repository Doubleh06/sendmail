package com.vtyc.sendmail.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtyc.sendmail.service.FirstService;
import com.vtyc.sendmail.service.SecondService;
import com.vtyc.sendmail.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class SendMailController {
    @Autowired
    private FirstService firstService;
    @Autowired
    private SecondService secondService;
    @Autowired
    private Environment environment;


    @Scheduled(cron = "0 0 7 * * ?")
//    @Scheduled(cron="0/30 * *  * * ? ")
    public void sendEmail() throws JsonProcessingException {
        String receiveMan = environment.getProperty("mail.receiveMan");
        if(!firstService.JudgeToday()){
            boolean isSend = MailUtil.sendEmail("Prolink报错", receiveMan.split("\\|"), null, "常州库op_hist数据未更新", null);
        }
        if (!firstService.getWcMstrTotal()){
            boolean isSend = MailUtil.sendEmail("Prolink报错", receiveMan.split("\\|"), null, "常州库wc_mstr数据未更新", null);
        }
        if (!firstService.getPtMstrTotal()){
            boolean isSend = MailUtil.sendEmail("Prolink报错", receiveMan.split("\\|"), null, "常州库pt_mstr数据未更新", null);
        }
        if(!secondService.JudgeToday()){
            boolean isSend = MailUtil.sendEmail("Prolink报错", receiveMan.split("\\|"), null, "重庆库op_hist数据未更新", null);
        }
        if (!secondService.getWcMstrTotal()){
            boolean isSend = MailUtil.sendEmail("Prolink报错", receiveMan.split("\\|"), null, "重庆库wc_mstr数据未更新", null);
        }
        if (!secondService.getPtMstrTotal()){
            boolean isSend = MailUtil.sendEmail("Prolink报错", receiveMan.split("\\|"), null, "重庆库pt_mstr数据未更新", null);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date())+"执行一次...");

//        boolean isSend = MailUtil.sendEmail("Prolink报错",receiveMan.split("\\|"), null, "恭喜您，您的邮箱正在被攻击", null);
//        System.out.println(isSend);

//        System.out.println( "发送邮件:" + isSend);
    }

}
