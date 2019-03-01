package com.project.demo.services;

import com.project.demo.models.detail;
import com.project.demo.models.product;
import com.project.demo.models.product_file;
import com.project.demo.repositories.ProdoctRepository;
import com.project.demo.repositories.ProductFileReposity;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
@Service
public class ProductServiceJpaImpl implements ProductService {
    @Autowired
    private ProdoctRepository productRepo;
    @Autowired
    private UploadPathService uploadPathService;
    @Autowired
    private ProductFileReposity productFileReposity;
    /*@Override
    public List<product> findAll() {
        return this.productRepo.findAll();
    }*/


    @Override
    public product findById(Integer id) {
        return this.productRepo.findById(id).get();
    }

    @Override
    public product insert_product(product products) {
        product pro=productRepo.save(products);

        if(pro !=null && pro.getFiles() !=null && pro.getFiles().size()>0)
        {
            for (MultipartFile file : pro.getFiles())
            {
                if(file!=null && StringUtils.hasText(file.getOriginalFilename())) {
                    String fileName=file.getOriginalFilename();
                    String modifiledFileName= FilenameUtils.getBaseName(fileName)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(fileName);
                    File storeFile=uploadPathService.getFilePath(modifiledFileName,"fileupload");
                    if(storeFile!=null)
                    {
                        try{
                            FileUtils.writeByteArrayToFile(storeFile,file.getBytes());
                        }
                        catch (Exception ex)
                        {
                            ex.printStackTrace();

                        }
                    }
                    product_file files=new product_file();
                    files.setFileExtension(FilenameUtils.getExtension(fileName));
                    files.setFileName(fileName);
                    files.setModifiledFileName(modifiledFileName);
                    files.setProducts(pro);
                    productFileReposity.save(files);
                }


            }
        }
        return pro;
    }

   /* @Override
    public product insert_product(product products) {
        return this.productRepo.save(products);
    }*/

    @Override
    public product update_product(product products) {
        product pro=productRepo.save(products);
        if(pro !=null && pro.getFiles() !=null && pro.getFiles().size()>0)
        {
            for (MultipartFile file : pro.getFiles())
            {
                if(file!=null && StringUtils.hasText(file.getOriginalFilename())) {
                    String fileName=file.getOriginalFilename();
                    String modifiledFileName= FilenameUtils.getBaseName(fileName)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(fileName);
                    File storeFile=uploadPathService.getFilePath(modifiledFileName,"fileupload");
                    if(storeFile!=null)
                    {
                        try{
                            FileUtils.writeByteArrayToFile(storeFile,file.getBytes());
                        }
                        catch (Exception ex)
                        {
                            ex.printStackTrace();

                        }
                    }
                    product_file files=new product_file();
                    files.setFileExtension(FilenameUtils.getExtension(fileName));
                    files.setFileName(fileName);
                    files.setModifiledFileName(modifiledFileName);
                    files.setProducts(pro);
                    productFileReposity.save(files);
                }


            }
        }

        if(products !=null && products.getRemoveImages()!=null &&  products.getRemoveImages().size()>0)
        {
            productFileReposity.deleteFilesByProductIdAndImageName(products.getId(),products.getRemoveImages());

           /*for (String file :products.getRemoveImages())
           {
               String paths=this.getClass().getResource("/static/images").getFile();
               String result=file.substring(0,file.length()-4);
               File f=new File(paths+"/"+result);
               if(f.exists())
               {
                   f.delete();
               }
           }*/
        }

        return pro;
    }

    @Override
    public void deleteById(Integer id) {
         this.productRepo.deleteById(id);
    }

    @Override
    public Page<product> findAllPageable(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public List<product_file> findFilesByProductId(Integer id) {
        return productFileReposity.findFilesByProductId(id);
    }

    @Override
    public List<product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public List<detail> findAllDetailByIdProduct(Integer id) {
        return productRepo.findAllDetailByIdProduct(id);
    }

    @Override
    public List<product> findProductByName(String Name) {
        return productRepo.findProductByName(Name);
    }

}
