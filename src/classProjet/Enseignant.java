package classProjet;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enseignant implements Serializable {
	
    private Long id;
    private String nom;
    private String prenom;
    private String matier;
    private int nbrAbs;
    private Date dateNaissance;
    private String photoUrl;
    private User user;
}
