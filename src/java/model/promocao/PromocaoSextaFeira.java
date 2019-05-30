package model.promocao;
public class PromocaoSextaFeira implements Promocao {

    public int id;

    public PromocaoSextaFeira() {
        this.id = 1;
    }

    @Override
    public String getNome() {
        return "SextaFeira";
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public float getDesconto() {
        return 10;
    }

}
