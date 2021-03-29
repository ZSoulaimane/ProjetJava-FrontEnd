package classProjet;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parent implements Serializable {

    private Long id;
    private String nomMere;
    private String nomPere;
    private int numTel;
    private User user;
}
