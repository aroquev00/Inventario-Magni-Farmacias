import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ArchivosBinarios{
  
  //Los siguientes métodos se encargarán de leer los datos de los archivos de texto y almacenarlos en arreglos para su manejo.
  
  //Constructor vacío para crear objetos en las otras clases
  public ArchivosBinarios(){
    
  }
  
  //Método para llenar un arreglo con los datos del inventario con la información de los .txt
  public static Producto[] llenarArregloProducto() throws IOException{
    
    //Se crea el stream con el archivo y se cierra, sólo para crear uno en caso de que no exista.
    PrintWriter out = new PrintWriter(new FileOutputStream("Inventario.txt", true)); 
    out.close();
    
    //Se crean dos scanner al archivo de texto; uno leerá cuantas lineas tiene el archivo, y leerá su contenido.
    Scanner file = new Scanner(new File ("Inventario.txt"));
    Scanner file2 = new Scanner(new File ("Inventario.txt"));
    
    //Se define el tamaño del arreglo
    int lineas = 0;
    if (file2.hasNext()){
      do{
      file2.nextLine();
      lineas++;
      } while (file2.hasNext());
    } 
    
    Producto[] arr = new Producto[lineas]; //Tamaño del numero de lineas que haya y es de la clase Producto

    //Se llena el arreglo
    if (file.hasNext()){ //Mientras existan líneas a leer en archivo se va a llenar el arreglo
      for (int x=0; x<lineas; x++){
      arr[x] = new Producto(); //Se crea producto por casilla en arreglo
      String line = file.nextLine(); //Se lee línea del archivo
      String delimitador = "#"; //Se establece el delimitador entre la información para cada atributo
      String[] arregloTemporal = new String[5]; //Se crea arreglo temporal para guardar el resultado de .split
      arregloTemporal = line.split(delimitador); //Se parte la linea leida
      arr[x].setNombreProducto(arregloTemporal[0]); //Guarda el nombre del producto
      arr[x].setCodigoProducto(Integer.parseInt(arregloTemporal[1])); //Guarda el código del producto
      arr[x].setMarcaProducto(arregloTemporal[2]); //Guarda la marca del producto
      arr[x].setPrecioProducto(Double.parseDouble(arregloTemporal[3])); //Guarda el precio unitario del producto
      arr[x].setStockProducto(Integer.parseInt(arregloTemporal[4])); //Guarda el stock del producto
      }
    }
    
    //Se regresa el arreglo de producto lleno
    return arr;
  }
  
  //Éste metodo leerá del archivo de texto que almacena los datos de los clientes, y los almacenará en un arreglo de Cliente, que será regresado para que pueda ser trabajado
  public static Cliente[] llenarArregloCliente() throws IOException{
    
    //Se crea el stream con el archivo y se cierra, sólo para crear uno en caso de que no exista.
    PrintWriter out = new PrintWriter(new FileOutputStream("Clientes.txt", true)); 
    out.close();
    
    //Se crean dos scanner al archivo de texto; uno leerá cuantas lineas tiene el archivo, y leerá su contenido.
    Scanner file = new Scanner(new File ("Clientes.txt"));
    Scanner file2 = new Scanner(new File ("Clientes.txt"));
    
    //Se define el tamaño del arreglo
    int lineas = 0;
    if (file2.hasNext()){
      do{
      file2.nextLine();
      lineas++;
      } while (file2.hasNext());
    } 
    
    Cliente[] arr = new Cliente[lineas]; //Tamaño del numero de lineas que haya y es de la clase Producto

    if (file.hasNext()){ //Mientras existan líneas a leer en archivo se va a llenar el arreglo
      for (int x=0; x<lineas; x++){
      arr[x] = new Cliente(); //Se crea pendiente por casilla en arreglo
      String line = file.nextLine(); //Se lee línea del archivo
      String delimitador = "#"; //Se establece el delimitador entre la información para cada atributo
      String[] arregloTemporal = new String[7]; //Se crea arreglo temporal para guardar el resultado de .split
      arregloTemporal = line.split(delimitador); //Se parte la linea leida
      arr[x].setCodigoCliente(Integer.parseInt(arregloTemporal[0])); //Guarda el codigo del cliente
      arr[x].setNombreCliente(arregloTemporal[1]); //Guarda el nombre del cliente
      arr[x].setApellidoCliente(arregloTemporal[2]); //Guarda el apellido del cliente
      arr[x].setTelefonoCliente(arregloTemporal[3]); //Guarda el telefono del cliente
      arr[x].setEmailCliente(arregloTemporal[4]); //Guarda el email del cliente
      arr[x].setNumeroComprasCliente(Integer.parseInt(arregloTemporal[5])); //Guarda el numero de compras del cliente
      arr[x].setValorComprasCliente(Double.parseDouble(arregloTemporal[6])); //Guarda el valor de las compras del cliente
      }
    }
    
    //Se regresa el arreglo lleno
    return arr;
  }
  
  //Éste metodo leerá del archivo de texto que almacena los datos de las ventas, y los almacenará en un arreglo de Venta, que será regresado para que pueda ser trabajado
  public static Venta[] llenarArregloVenta() throws IOException{
    
    //Se crea el stream con el archivo y se cierra, sólo para crear uno en caso de que no exista.
    PrintWriter out = new PrintWriter(new FileOutputStream("Ventas.txt", true)); 
    out.close();
    
    //Se crean dos scanner al archivo de texto; uno leerá cuantas lineas tiene el archivo, y leerá su contenido.
    Scanner file = new Scanner(new File ("Ventas.txt"));
    Scanner file2 = new Scanner(new File ("Ventas.txt"));
    
    //Se define el tamaño del arreglo
    int lineas = 0;
    if (file2.hasNext()){
      do{
      file2.nextLine();
      lineas++;
      } while (file2.hasNext());
    } 
    
    Venta[] arr = new Venta[lineas]; //Tamaño del numero de lineas que haya y es de la clase Producto

    if (file.hasNext()){ //Mientras existan líneas a leer en archivo se va a llenar el arreglo
      for (int x=0; x<lineas; x++){
      arr[x] = new Venta(); //Se crea pendiente por casilla en arreglo
      String line = file.nextLine(); //Se lee línea del archivo
      String delimitador = "#"; //Se establece el delimitador entre la información para cada atributo
      String[] arregloTemporal = new String[6]; //Se crea arreglo temporal para guardar el resultado de .split
      arregloTemporal = line.split(delimitador); //Se parte la linea leida
      arr[x].setClienteVenta(Integer.parseInt(arregloTemporal[0])); //Guarda el codigo del cliente al que se vendio
      arr[x].setProductoVenta(Integer.parseInt(arregloTemporal[1])); //Guarda el codigo del producto vendido
      arr[x].setFolioVenta(Integer.parseInt(arregloTemporal[2])); //Guarda el folio de la venta
      arr[x].setFechaVenta(arregloTemporal[3]); //Guarda la fecha de la venta
      arr[x].setCantidadProductoVenta(Integer.parseInt(arregloTemporal[4])); //Guarda la cantidad de producto vendido
      arr[x].setValorVenta(Double.parseDouble(arregloTemporal[5])); //Guarda el valor de la venta
      }
    }
    
    //Se regresa el arreglo lleno
    return arr;
  }
  
  
  
  //Éste metodo leerá del archivo de texto que almacena los datos de las entregas, y los almacenará en un arreglo de EntregaProveedor, que será regresado para que pueda ser trabajado
  public static EntregaProveedor[] llenarArregloEntrega() throws IOException{ // Inicio 2
    
    //Se crea el stream con el archivo y se cierra, sólo para crear uno en caso de que no exista.
    PrintWriter out = new PrintWriter(new FileOutputStream("Entregas.txt", true)); 
    out.close();
    
    //Se crean dos scanner al archivo de texto; uno leerá cuantas lineas tiene el archivo, y leerá su contenido.
    Scanner file = new Scanner(new File ("Entregas.txt"));
    Scanner file2 = new Scanner(new File ("Entregas.txt"));
    
    //Se define el tamaño del arreglo
    int lineas = 0;
    if (file2.hasNext()){
      do{
      file2.nextLine();
      lineas++;
      } while (file2.hasNext());
    } 
    
    EntregaProveedor[] arr = new EntregaProveedor[lineas]; //Tamaño del numero de lineas que haya y es de la clase Producto

    if (file.hasNext()){ //Mientras existan líneas a leer en archivo se va a llenar el arreglo
      for (int x=0; x<lineas; x++){
      arr[x] = new EntregaProveedor(); //Se crea pendiente por casilla en arreglo
      String line = file.nextLine(); //Se lee línea del archivo
      String delimitador = "#"; //Se establece el delimitador entre la información para cada atributo
      String[] arregloTemporal = new String[6]; //Se crea arreglo temporal para guardar el resultado de .split
      arregloTemporal = line.split(delimitador); //Se parte la linea leida
      arr[x].setProductoEntrega(Integer.parseInt(arregloTemporal[0])); //Se guarda el codigo del producto entregado
      arr[x].setFolioEntrega(Integer.parseInt(arregloTemporal[1])); //Guarda el folio de la entrega
      arr[x].setNombreProveedor(arregloTemporal[2]); //Guarda el nombre del proveedor
      arr[x].setFechaEntrega(arregloTemporal[3]); //Guarda la fecha de la entrega
      arr[x].setCantidadProductoEntrega(Integer.parseInt(arregloTemporal[4])); //Guarda la cantidad de producto entregado
      arr[x].setValorEntrega(Double.parseDouble(arregloTemporal[5])); //Guarda el valor de la entrega
      }
    }
    
    //Se regresa el arreglo lleno
    return arr;
  } // Fin 2

  //Los siguientes métodos se encargarán de almacenar los datos de los arreglos de cada tipo en los archivos de texto para su almacenamiento permanente.
  //Éste metodo guardará en el archivo de texto la información en el arreglo de Producto
  public static void guardarArchProducto(Producto[] arr) throws IOException{ // Inicio 2
     
      //Se crea el stream con el archivo
     PrintWriter out = new PrintWriter(new FileOutputStream("Inventario.txt"));   
     
     //Se guardan todos los datos de los objetos en el arreglo, separados por el caracter #
     for (int x=0; x<arr.length; x++){                               
     out.println(arr[x].getNombreProducto() + "#" + arr[x].getCodigoProducto() + "#" + arr[x].getMarcaProducto() + "#" + arr[x].getPrecioProducto() + "#" + arr[x].getStockProducto());
     }
     
     //Se cierra el stream
     out.close();
  } // Fin 2
  
  
   //Éste metodo guardará en el archivo de texto la información en el arreglo de Cliente
   public static void guardarArchCliente(Cliente[] arr) throws IOException{ // Inicio 2
     
       //Se crea el stream con el archivo
     PrintWriter out = new PrintWriter(new FileOutputStream("Clientes.txt"));   
     
     //Se guardan todos los datos de los objetos en el arreglo, separados por el caracter #
     for (int x=0; x<arr.length; x++){                               
     out.println(arr[x].getCodigoCliente() + "#" + arr[x].getNombreCliente() + "#" + arr[x].getApellidoCliente() + "#" + arr[x].getTelefonoCliente() + "#" + arr[x].getEmailCliente() + "#" + arr[x].getNumeroComprasCliente() + "#" + arr[x].getValorComprasCliente());
     }
     
     //Se cierra el stream
     out.close();
   }
  
   
  //Éste metodo guardará en el archivo de texto la información en el arreglo de Venta
  public static void guardarArchVenta(Venta[] arr) throws IOException{ // Inicio 2
    
      //Se crea el stream con el archivo
    PrintWriter out = new PrintWriter(new FileOutputStream("Ventas.txt"));   
     
    //Se guardan todos los datos de los objetos en el arreglo, separados por el caracter #
     for (int x=0; x<arr.length; x++){                               
     out.println(arr[x].getClienteVenta() + "#" + arr[x].getProductoVenta() + "#" + arr[x].getFolioVenta() + "#" + arr[x].getFechaVenta() + "#" + arr[x].getCantidadProductoVenta() + "#" + arr[x].getValorVenta());
     }
     
     //Se cierra el stream
     out.close();
  } // Fin 2 
  
  
  //Éste metodo guardará en el archivo de texto la información en el arreglo de EntregaProveedor
  public static void guardarArchEntrega(EntregaProveedor[] arr) throws IOException{ // Inicio 2
    
    //Se crea el stream con el archivo
    PrintWriter out = new PrintWriter(new FileOutputStream("Entregas.txt")); 
    
    //Se guardan todos los datos de los objetos en el arreglo, separados por el caracter #
    for (int x=0; x<arr.length; x++){                               
     out.println(arr[x].getProductoEntrega() + "#" + arr[x].getFolioEntrega() + "#" + arr[x].getNombreProveedor() + "#" + arr[x].getFechaEntrega() + "#" + arr[x].getCantidadProductoEntrega() + "#" + arr[x].getValorEntrega());
    }
    
    //Se cierra el stream
    out.close();
  } // Fin 2
  
  
  //Este método se encarga de enviar a la interfaz los datos que serán desplegados
  public static String[] mostrarDashboard() throws IOException{
   
    //Se crean los objetos necesarios para crear un nuevo cliente y guararlo en el archivo de texto
    //Se crea el objeto para poder accesar a los archivos de texto
    ArchivosBinarios ab = new ArchivosBinarios();
    //Se llena el arreglo de Productos
    Producto[] arrProducto = ab.llenarArregloProducto();
    //Se llena el arreglo de Clientes
    Cliente[] arrCliente = ab.llenarArregloCliente();
    //Se llena el arreglo de Ventas
    Venta[] arrVenta = ab.llenarArregloVenta();
    
    //Este arreglo es el que se regresará a la ventana con los datos necesarios
    String[] arrString = new String[5];
    
    //Para obtener el total de productos en el inventario y el valor total del inventario actual
    int totalInventario = 0;
    double totalValorProductos = 0;
    
    //Se recorre el arreglo de productos y se calcula el stock y el valor del mismo
    for (int x=0; x < arrProducto.length; x++){
      totalInventario += arrProducto[x].getStockProducto();
      totalValorProductos += (arrProducto[x].getStockProducto())*(arrProducto[x].getPrecioProducto());
    }
    
    //Se guardan en el arreglo de Strings que se regresará
    arrString[0]=(totalInventario + "");
    arrString[1]=("$" + totalValorProductos + "");
    
    //Para el total de clientes registrados
    arrString[2]=(arrCliente.length + "");
    
    //Para el promedio de total comprado por cliente registrado
    //Nota: No se toman en cuenta las compras de los clientes sin registrar
    double valorPromedioCliente;
    double sumaCliente = 0;
    //Se recorre el arreglo de clientes para obtener la información
    for (int x=0; x < arrCliente.length; x++){
      sumaCliente += arrCliente[x].getValorComprasCliente();
    }
    DecimalFormat df = new DecimalFormat("#.##");
    valorPromedioCliente = (sumaCliente/(arrCliente.length));
    //Se guarda en el arreglo de Strings que se regresará
    arrString[3]=("$" + df.format(valorPromedioCliente) + "");
    
    //Para total de ventas
    double totalVentas = 0;
    //Se recorre el arreglo de ventas para obtener la información
    for (int x=0; x < arrVenta.length; x++){
      totalVentas += arrVenta[x].getValorVenta();
    }
    //Se guarda en el arreglo de Strings que se regresará
    arrString[4]=("$" + totalVentas + "");
    
    //Se regresa el arreglo de Strings lleno
    return arrString;
  }
 
  
  
}