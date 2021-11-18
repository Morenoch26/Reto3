/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioCloud {
    
    @Autowired
    private InterfaceCloud crud;

    public List<Cloud> getAll(){
        return (List<Cloud>) crud.findAll();
    }

    public Optional<Cloud> getCabin(int id){
        return crud.findById(id);
    }

    public Cloud save(Cloud cabin){
        return crud.save(cabin);
    }
    public void delete(Cloud cabin){
        crud.delete(cabin);
    }
    
}
