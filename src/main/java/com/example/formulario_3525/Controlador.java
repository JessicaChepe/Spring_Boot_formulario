package com.example.formulario_3525;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author JESSICA
 */
@Controller
public class Controlador {
    
    ArrayList<Persona> lista = new ArrayList();
    
    @GetMapping("/") //http:localhost/
    public String Contacto(){
        
        return "contacto";
    
    }
    
    //@ResponseBody //funciona para que el return retorne los datos ingresados como respuesta
    @PostMapping("/registrar") //http:localhost/registrar - aqui lo que se hace es registrar los datos de la persona
    public String Registrar(@RequestParam("nom") String name,
                            @RequestParam("ape") String ape,
                            @RequestParam("cel") String cel,
                            @RequestParam("email") String email,
                            Model model)
    {  //requestparam es para obetner el dato nombre y la variable son n,ape,cel eso puede variar
        
        Persona p = new Persona(); //instancia
        p.setNombre(name);
        p.setApellido(ape);
        p.setCelular(cel);
        p.setCorreo(email);
        
        lista.add(p);
        
        //muestra
        //enviar data hacia la vista
        model.addAttribute("personas",lista);
        //return name+" "+ape+" "+cel+" "+email+" ";
        return "datos";
    }
    
    //mostrar la lista, mandar los datos como estan sin agregar
    @GetMapping("/lista")
    public String Listado(Model model){
        model.addAttribute("personas", lista);
        return "datos";
    }
}
