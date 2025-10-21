import java.util.ArrayList;
import java.util.Scanner;

public class ProductService {
    private final Scanner sc = new Scanner(System.in);
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();

    public Product findProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void createNewProduct(String name, int price, int amount) {
        products.add(new Product(products.size(), name, price, amount));
        System.out.println("Producto creado exitosamente");
    }

    public void getAllProducts(){
        if (products == null || products.isEmpty()) {
            System.out.println("No hay productos disponibles");
            return;
        }

        System.out.println("--------------------------------------");
        for (Product p : products){
            System.out.printf("ID: %s  Nombre: %s  Precio: %s  Stock: %s%n", p.getId(), p.getName(), p.getPrice(), p.getStock());
        }
    }

    public void getSpecificProduct(int id) {
        Product p = findProductById(id);
        if (p == null) {
            System.out.println("ID no válido");
            return;
        }
        System.out.printf("ID: %s Nombre: %s Precio: %s Stock: %s%n", p.getId(), p.getName(), p.getPrice(), p.getStock());
    }

    public void updateProduct(int id) {
        Product p = findProductById(id);
        if (p == null) {
            System.out.println("ID no valido");
            return;
        }

        System.out.println("""
                1) Nombre
                2) Precio
                3) Cantidad
                
                
                0) Salir
                
                ¿Que desea actualizar?
                """);
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                System.out.println("Ingrese nuevo nombre: ");
                String newName = sc.next();
                p.setName(newName);
                break;
            case 2:
                System.out.println("Ingrese nuevo precio: ");
                int newPrice = sc.nextInt();
                p.setPrice(newPrice);
                break;
            case 3:
                System.out.println("Ingrese nueva cantidad: ");
                int newAmount = sc.nextInt();
                p.setStock(newAmount);
                break;
            default:
                System.out.println("Opcion no valida");
        }
        System.out.println("Producto actualizado exitosamente");
    }

    public void deleteProduct(int id) {
        Product p = findProductById(id);
        if (p == null) {
            System.out.println("ID no valido");
            return;
        }
        products.remove(p);
        System.out.println("Producto eliminado exitosamente");
    }

    public void createNewOrder(int productId, int amount) {
        Product p = findProductById(productId);
        if (p == null) {
            System.out.println("ID no valido");
            return;
        } else if (amount > p.getStock()) {
            System.out.println("Cantidad no valida");
            return;
        }

        orders.add(new Order(orders.size(), p, amount));
        p.setStock(p.getStock() - amount);
        System.out.println("Pedido creado exitosamente");
    }

    public void getAllOrders() {
        if (orders == null || orders.isEmpty()) {
            System.out.println("No hay pedidos disponibles");
            return;
        }

        System.out.println("--------------------------------------");
        for (Order or : orders) {
            System.out.printf("ID: %s  Nombre del producto: %s    Cantidad: %s%n", or.getId(), or.getProductName(), or.getAmount());
        }
    }
}
