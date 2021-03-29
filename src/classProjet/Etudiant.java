package classProjet;

import java.io.Serializable;
import java.util.Date;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {

    private Long id;
    private String nom;
    private String prenom;
    private int nbrAbs;
    private Double noteS1;
    private Double noteS2;
    private Double noteTotal;
    private String dateNaissance;
    private String photoUrl;
    private Parent parent;
    private Classe classe;
    private User user;
    
}
