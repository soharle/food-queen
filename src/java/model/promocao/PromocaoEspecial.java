package model.promocao;
public class PromocaoEspecial implements Promocao {

    public int id;

    public PromocaoEspecial() {
        this.id = 2;
    }

    @Override
    public String getNome() {
        return "Especial";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public float getDesconto() {
        return 20;
    }
}
