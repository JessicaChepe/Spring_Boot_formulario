package com.example.formulario_3525;

import lombok.Data;


@Data //libreria permite generar los metodos get y set  
public class Persona {

    //clase lleva atributos
    //la base de datos con codigo
    public String nombre;
    public String apellido;
    public String celular;
    public String correo;
    
}
