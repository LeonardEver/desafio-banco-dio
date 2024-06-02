import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Banco {

    public String nome;
    public List<Conta> contas;

}
