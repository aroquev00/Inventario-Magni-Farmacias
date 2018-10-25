/*Armando Roque Villasana A01138717
Ultima edicion: 6/9/2017
Clase Venta
*/

import java.io.*;

public class Venta implements Comparable<Venta>{
  
  private int clienteVenta;
  private int productoVenta;
  private int folioVenta;
  private String fechaVenta;
  private int cantidadProductoVenta;
  private double valorVenta;
  
  //Constructores
  //Constructor vacío
  public Venta(){
    this.clienteVenta = 0;
    this.productoVenta = 0;
    this.folioVenta = 0;
    this.fechaVenta = "";
    this.cantidadProductoVenta = 0;
    this.valorVenta = 0;
  }
  
    //Constructor con parámetros
  public Venta(int clienteVenta, int productoVenta, int folio, String fechaVenta, int cantidadProductoVenta, double valorVenta){
    this.clienteVenta = clienteVenta;
    this.productoVenta = productoVenta;
    this.folioVenta = folio;
    this.fechaVenta = fechaVenta;
    this.cantidadProductoVenta = cantidadProductoVenta;
    this.valorVenta = valorVenta;
  }

  //Métodos set
  public void setClienteVenta(int cliente){
   this.clienteVenta = cliente; 
  }
  
  public void setProductoVenta(int producto){
   this.productoVenta = producto; 
  }
  
  public void setFolioVenta(int folio){
    this.folioVenta = folio;
  }
  
  public void setFechaVenta(String fecha){
    this.fechaVenta = fecha;
  }
  
  public void setCantidadProductoVenta(int cantidad){
    this.cantidadProductoVenta = cantidad;
  }
  
  public void setValorVenta(double valor){
    this.valorVenta = valor;
  }
  
  //Métodos get
  public int getClienteVenta(){
   return clienteVenta; 
  }
  
  public int getProductoVenta(){
   return productoVenta; 
  }
  
  public int getFolioVenta(){
    return folioVenta;
  }
  
  public String getFechaVenta(){
    return fechaVenta;
  }
  
  public int getCantidadProductoVenta(){
    return cantidadProductoVenta;
  }
  
  public double getValorVenta(){
    return valorVenta;
  }
  
  //Metodos de la clase
  //Metodo para registrar una venta sin cliente registrado
  public static void ventaSinCliente(int codProducto, int cantidadVendida, String fecha) throws IOException{
    
    //Se crean los objetos necesarios para crear un nuevo cliente y guararlo en el archivo de texto
    //Esta será la nueva venta
    Venta estaVenta = new Venta();
    //Se crea el objeto para poder accesar a los archivos de texto
    ArchivosBinarios ab = new ArchivosBinarios();
    //Se llena el arreglo con los datos de los productos en inventario
    Producto[] arrProducto = ab.llenarArregloProducto();
    
    //Folio venta
    Venta[] arrVenta = ab.llenarArregloVenta();
    //El folio es el numero siguiente del total de ventas registradas 
    estaVenta.setFolioVenta(arrVenta.length+1);
    
    //Se registra el código del producto que se vende
    //Guardado del código en el registro de ventas
    estaVenta.setProductoVenta(arrProducto[codProducto-1].getCodigoProducto());

    //Código de cliente
    //Como no hay cliente, se pone -1
    estaVenta.setClienteVenta(-1);
    
    //Cantidad vendida
    //Se actualiza el stock del producto vendido
    arrProducto[codProducto-1].setStockProducto(arrProducto[codProducto-1].getStockProducto() - cantidadVendida); 
    //Se guarda en el registro de esta venta
    estaVenta.setCantidadProductoVenta(cantidadVendida);
    
     //Valor de la venta (se calcula multiplicando la cantidad vendida por el precio del producto)
    double valorEstaVenta = estaVenta.getCantidadProductoVenta()*arrProducto[codProducto-1].getPrecioProducto();
    estaVenta.setValorVenta(valorEstaVenta);
    
    //Fecha Venta
    estaVenta.setFechaVenta(fecha);
   
    //Guardar la nueva venta en el archivo de ventas
    PrintWriter out1 = new PrintWriter(new FileOutputStream("Ventas.txt", true));
    out1.println(estaVenta.getClienteVenta() + "#" + estaVenta.getProductoVenta() + "#" + estaVenta.getFolioVenta() + "#" + estaVenta.getFechaVenta() + "#" + estaVenta.getCantidadProductoVenta() + "#" + estaVenta.getValorVenta());
    out1.close();
    
    //Guardar arreglo de Venta
    ab.guardarArchProducto(arrProducto);
  }
  
  //Método para registrar una venta con un cliente registrado
  public static void ventaCliente(int codCliente, int codProducto, int cantidadVendida, String fecha) throws IOException{
   
    //Se crean los objetos necesarios para crear un nuevo cliente y guararlo en el archivo de texto
    //Esta será la nueva venta
    Venta estaVenta = new Venta();
    //Se crea el objeto para poder accesar a los archivos de texto
    ArchivosBinarios ab = new ArchivosBinarios();
    //Se llena el arreglo con los datos de los productos en inventario
    Producto[] arrProducto = ab.llenarArregloProducto();
    //Se llena el arreglo con los datos de los clientes registrados
    Cliente[] arrCliente = ab.llenarArregloCliente();
    
    //Folio venta
    Venta[] arrVenta = ab.llenarArregloVenta();
    estaVenta.setFolioVenta(arrVenta.length+1);
    
    //Guardado del código en el registro de ventas
    estaVenta.setProductoVenta(arrProducto[codProducto-1].getCodigoProducto());
    
    //Leer códgio cliente al que se vende
    //Guardado del código en el registro de ventas
    estaVenta.setClienteVenta(arrCliente[codCliente-1].getCodigoCliente());
    //Se agrega una venta al cliente
    arrCliente[codCliente-1].setNumeroComprasCliente(arrCliente[codCliente-1].getNumeroComprasCliente() + 1);
    
    //Cantidad vendida
    arrProducto[codProducto-1].setStockProducto(arrProducto[codProducto-1].getStockProducto() - cantidadVendida); 
    //Se guarda en el registro de esta venta
    estaVenta.setCantidadProductoVenta(cantidadVendida);
    
    //Valor de la venta (Se calcula multiplicando el precio del producto por la cantidad vendida)
    double valorEstaVenta = estaVenta.getCantidadProductoVenta()*arrProducto[codProducto-1].getPrecioProducto();
    estaVenta.setValorVenta(valorEstaVenta);
    //Se guarda en el registro de clientes
    arrCliente[codCliente-1].setValorComprasCliente(arrCliente[codCliente-1].getValorComprasCliente() + valorEstaVenta);
    
    //Fecha Venta
    estaVenta.setFechaVenta(fecha);
   
    //Guardar la nueva venta en el archivo de ventas
    PrintWriter out1 = new PrintWriter(new FileOutputStream("Ventas.txt", true));
    out1.println(estaVenta.getClienteVenta() + "#" + estaVenta.getProductoVenta() + "#" + estaVenta.getFolioVenta() + "#" + estaVenta.getFechaVenta() + "#" + estaVenta.getCantidadProductoVenta() + "#" + estaVenta.getValorVenta());
    out1.close();
    
    //Guardar arreglo de Clientes con nueva info
    ab.guardarArchCliente(arrCliente);
    
    //Guardar arreglo de Venta
    ab.guardarArchProducto(arrProducto);
    
  }
  
    //Esto es un comparador para poder ordenar los objetos según la cantidad vendida
    @Override
    public int compareTo(Venta o) {
        return this.cantidadProductoVenta - o.cantidadProductoVenta;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}