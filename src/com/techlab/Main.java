package com.techlab;

import com.techlab.Service.ProductService;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ProductService c = new ProductService();

        label:
        while (true) {
            System.out.println("""
                    --------------------------------------
                    1) Agregar producto
                    2) Listar productos
                    3) Buscar/Actualizar producto
                    4) Eliminar producto
                    5) Crear un pedido
                    6) Listar pedidos
                    
                    
                    0) Salir
                    
                    Elija una opción:\s""");

            int input = sc.nextInt();

            switch (input) {
                case 0:
                    break label;
                case 1:
                    System.out.println("Nombre del producto: ");
                    String name = sc.next();
                    System.out.println("Precio: ");
                    int price = sc.nextInt();
                    System.out.println("Cantidad: ");
                    int stock = sc.nextInt();

                    c.createNewProduct(name, price, stock);

                    System.out.printf("%n%n%nPresione enter para continuar%n");
                    System.in.read();
                    break;
                case 2:
                    c.getAllProducts();

                    System.out.printf("%n%n%nPresione enter para continuar%n");
                    System.in.read();
                    break;
                case 3:
                    System.out.println("Ingrese ID del producto a buscar: ");
                    int id = sc.nextInt();

                    c.updateProduct(id);

                    System.out.printf("%n%n%nPresione enter para continuar%n");
                    System.in.read();
                    break;
                case 4:
                    System.out.println("Ingrese ID del producto a eliminar: ");
                    int id2 = sc.nextInt();

                    c.deleteProduct(id2);

                    System.out.printf("%n%n%nPresione enter para continuar%n");
                    System.in.read();
                    break;
                case 5:
                    System.out.println("Ingrese ID del producto para el pedido: ");
                    int productId = sc.nextInt();
                    System.out.println("Ingrese cantidad a pedir: ");
                    int amount = sc.nextInt();

                    c.createNewOrder(productId, amount);

                    System.out.printf("%n%n%nPresione enter para continuar%n");
                    System.in.read();
                    break;
                case 6:
                    c.getAllOrders();

                    System.out.printf("%n%n%nPresione enter para continuar%n");
                    System.in.read();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
        System.out.println("Gracias por usar nuestro sistema");
    }
}