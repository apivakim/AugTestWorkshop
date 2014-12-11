package com.aug.services.may;

import com.aug.daos.may.MayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MayService {

    @Autowired
    private MayDao mayDao;
}
