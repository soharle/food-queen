package model;
public class PromocaoFactory {

    public static Promocao create(String nome) {
        String nomeClasse = "model.Promocao" + nome;

        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            return null;
        }
        if (!(objeto instanceof Promocao)) {
            return null;
        }
        Promocao promocaoObject = (Promocao) objeto;
        return promocaoObject;
    }
}
