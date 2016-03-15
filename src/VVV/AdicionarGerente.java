package VVV;

import controllers.FuncionarioCtrl;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdicionarGerente {
    public static void main(String[] args) {
        try {
            FuncionarioCtrl.cadastrarFuncionario("Vítor Augusto", "Rua XXX", "+5521999999999", FuncionarioCtrl.GERENTE, "1234", "vasvas", "99999999999");
        } catch (ErroValidacao ex) {
            Logger.getLogger(AdicionarGerente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
}
