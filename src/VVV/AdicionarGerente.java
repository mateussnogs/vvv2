package VVV;

import controllers.FuncionarioCtrl;
import daos.DOA;

public class AdicionarGerente {
    public static void main(String[] args) {
        FuncionarioCtrl.cadastrarFuncionario("Vítor Augusto", "Rua XXX", "+5521999999999", FuncionarioCtrl.GERENTE, "1234", "vasvas", "99999999999");
        System.exit(0);
    }
}
