package classProjet;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable{

    private Long id;
    private String nom;
    private String prenom;
    private String photoUrl;
    private User user;
}
