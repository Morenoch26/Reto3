/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosCloud {
     @Autowired
    private RepositorioCloud metodosCrud;

    public List<Cloud> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Cloud> getCabin(int cloudId) {
        return metodosCrud.getCabin(cloudId);
    }

    public Cloud save(Cloud cloud){
        if(cloud.getId()==null){
            return metodosCrud.save(cloud);
        }else{
            Optional<Cloud> e=metodosCrud.getCabin(cloud.getId());
            if(e.isEmpty()){
                return metodosCrud.save(cloud);
            }else{
                return cloud;
            }
        }
    }

    public Cloud update(Cloud cloud){
        if(cloud.getId()!=null){
            Optional<Cloud> e=metodosCrud.getCabin(cloud.getId());
            if(!e.isEmpty()){
                if(cloud.getName()!=null){
                    e.get().setName(cloud.getName());
                }
                if(cloud.getBrand()!=null){
                    e.get().setBrand(cloud.getBrand());
                }
                if(cloud.getModel()!=null){
                    e.get().setModel(cloud.getModel());
                }
             
                if(cloud.getCategory()!=null){
                    e.get().setCategory(cloud.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cloud;
            }
        }else{
            return cloud;
        }
    }


    public boolean deleteCloud(int cloudId) {
        Boolean aBoolean = getCabin(cloudId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
