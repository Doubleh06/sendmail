package com.vtyc.sendmail.service;

import com.vtyc.sendmail.dao.second.CqOpHistDao;
import com.vtyc.sendmail.dao.second.CqPtMstrDao;
import com.vtyc.sendmail.dao.second.CqWcMstrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SecondService {
    @Autowired
    private CqOpHistDao cqOpHistDao;
    @Autowired
    private CqWcMstrDao cqWcMstrDao;
    @Autowired
    private CqPtMstrDao cqPtMstrDao;

    public boolean JudgeToday (){
        Date date = cqOpHistDao.getopDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date currentDate = new Date();
        if(sdf.format(date).equals(sdf.format(currentDate))){
            return true;
        }else{
            return false;
        }
    }
    public boolean getWcMstrTotal(){
        Integer total = cqWcMstrDao.getTotal();
        if(null==total){
            return false;
        }else{
            return true;
        }
    }

    public boolean getPtMstrTotal(){
        Integer total = cqPtMstrDao.getTotal();
        if(null==total){
            return false;
        }else{
            return true;
        }
    }
}
