package com.vtyc.sendmail.service;

import com.vtyc.sendmail.dao.first.CzOpHistDao;
import com.vtyc.sendmail.dao.first.CzPtMstrDao;
import com.vtyc.sendmail.dao.first.CzWcMstrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class FirstService {

    @Autowired
    private CzOpHistDao czOpHistDao;
    @Autowired
    private CzWcMstrDao czWcMstrDao;
    @Autowired
    private CzPtMstrDao czPtMstrDao;

    public boolean JudgeToday (){
        Date date = czOpHistDao.getCredat();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
//        if(sdf.format(date).equals(sdf.format(calendar.getTime()))){
        if(sdf.format(date).equals(sdf.format(currentDate))){
            return true;
        }else{
            return false;
        }
    }
    public boolean getWcMstrTotal(){
        Integer total = czWcMstrDao.getTotal();
        if(null==total){
            return false;
        }else{
            return true;
        }
    }

    public boolean getPtMstrTotal(){
        Integer total = czPtMstrDao.getTotal();
        if(null==total){
            return false;
        }else{
            return true;
        }
    }
}
