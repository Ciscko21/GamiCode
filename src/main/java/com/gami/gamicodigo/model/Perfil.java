
package com.gami.gamicodigo.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perfil implements Serializable {

    private int id;
    private int totalPoints;
    private int examComplete;
    private int nivel;

}
