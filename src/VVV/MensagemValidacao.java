package VVV;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import javax.validation.ConstraintViolation;

public enum MensagemValidacao{
    Nome(),
    Endereco(),
    Telefone(),
    Usuario(
            "Tamanho", "O tamanho do nome de usuário deve ser entre 6 à 32 caracteres.",
            "Unico", "Esse usuario já está cadastrado."
    ),
    Cpf(
            "Tamanho", "CPF Inválido.",
            "Unico", "Já existe um úsuario cadastrado com esse CPF."
    ),
    Senha(
            "Tamanho", "Senha deve ter no mínimo 6 caracteres."
    ),
    Profissao(),
    Idade(
            "Invalido", "Idade inválida"
    )
    ;
        
    private static HashMap<String, String> mensagens;
    
    private static String getMessagem(String campo, String chave){
        chave = chave.toUpperCase();
        String result = MensagemValidacao.mensagens.get(campo + '_' + chave);
        
        if(result != null){
            return result;
        }
        
        campo = campo.substring(0, 1).toUpperCase() + campo.substring(1);
        
        //Default
        switch(chave){
            case "VAZIO":
                return  String.format("%s não pode estar vazio.", campo);
                
            case "TAMANHO":
                return String.format("%s não tem tamanho válido.", campo);
        }
        
        throw new RuntimeException(String.format("Mensagem de validação inexistente para Field: %s e Key: %s", campo, chave));
    } 
    
    public static void assertValidacao(Set violacoes) throws ErroValidacao{
        if(violacoes.size() > 0){
            ConstraintViolation violacao = (ConstraintViolation) violacoes.iterator().next();
            
            throw new ErroValidacao(MensagemValidacao.getMessagem(violacao.getPropertyPath().iterator().next().getName(), violacao.getMessage()));
        }
    }
    
    MensagemValidacao(String... mensagens){
        System.out.println(Arrays.toString(mensagens));
        if(mensagens.length > 0){
            populate(mensagens);
        }
    }
    
    private void populate(String[] mensagens){
        assert mensagens.length % 2 == 0;
        
        if(MensagemValidacao.mensagens == null){
            MensagemValidacao.mensagens = new HashMap<>();
        }
        
        for(int counter = 0; counter < mensagens.length; counter += 2){
            String key = this.toString().toLowerCase() + '_' + mensagens[counter].toUpperCase();
            MensagemValidacao.mensagens.put(key, mensagens[counter + 1]);
        }
    }
    
    public final String getMessagem(String chave){
        return MensagemValidacao.getMessagem(this.toString().toLowerCase(), chave);
    }
    
    public void throwErroValidacao(String chave) throws ErroValidacao{
        throw new ErroValidacao(this.getMessagem(chave));
    }
}
