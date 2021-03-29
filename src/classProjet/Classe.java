package classProjet;

import java.io.Serializable;
import java.util.Set;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe implements Serializable {
	
    private Long id;
    private String emploiUrl;
    private String salle;
    private Set<Etudiant> etudiants;
    private Set<Enseignant> enseignants;

}
