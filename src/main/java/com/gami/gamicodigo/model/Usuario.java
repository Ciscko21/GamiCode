
package com.gami.gamicodigo.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable{
    
    private int id;
    private String username;
    private String name;
    private String last_Name;
    private Boolean active;
    private int profile_id;
    private Perfil profile;   
    

}
