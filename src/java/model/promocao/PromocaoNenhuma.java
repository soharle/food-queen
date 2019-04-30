package model.promocao;
public class PromocaoNenhuma implements Promocao {

    public int id;

    public PromocaoNenhuma() {
        this.id = 4;
    }

    @Override
    public String getNome() {
        return "Nenhuma";
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public float getDesconto() {
        return 0;
    }

}
