package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service

public class UploadPathSerivceImpl implements UploadPathService {

    @Override
    public File getFilePath(String modifiledFileName, String path) {
       /* boolean exists =new File(context.getRealPath("/"+path+"/")).exists();
        if(!exists)
        {
            new File(context.getRealPath("/"+path+"/")).mkdir();
        }
        String modifliedFilePath=context.getRealPath("/"+path+"/"+File.separator+modifiledFileName);
        File file=new File(modifliedFilePath);
        return file;*/
        String paths=this.getClass().getResource("/static/images").getFile();

        File file=new File(paths+"/"+modifiledFileName);
        return file;
    }
}
