import model.pedido.Pedido;
import persistence.PedidoDAO;

public class Teste {
    public static void main(String[] args) {
        Pedido p = PedidoDAO.getInstance().get(37);
        
        System.out.println(p.toString());
    }
}
