/*Armando Roque Villasana A01138717
Ultima edicion: 18/10/2017
Clase EntregaProveedor
*/

import java.io.*;

public class EntregaProveedor{
  
  //Declaración de atributos
  private int productoEntrega;
  private int folioEntrega;
  private String nombreProveedor;
  private String fechaEntrega;
  private int cantidadProductoEntrega;
  private double valorEntrega;
  
  
  
  //Constructores
  
    //Constructor sin parámetros
  public EntregaProveedor(){
    this.productoEntrega = 0;
    this.folioEntrega = 0;
    this.nombreProveedor = "";
    this.fechaEntrega = "";
    this.cantidadProductoEntrega = 0;
    this.valorEntrega = 0;
  }
  
    //Constructor con parámetros
  public EntregaProveedor(int productoEntrega, int folio, String nombreProveedor, String fecha, int cantidadProductoEntrega, double valorEntrega){
    this.productoEntrega = productoEntrega;
    this.folioEntrega = folio;
    this.nombreProveedor = nombreProveedor;
    this.fechaEntrega = fecha;
    this.cantidadProductoEntrega = cantidadProductoEntrega;
    this.valorEntrega = valorEntrega;
  }
  
  
  
  //Métodos set
  public void setProductoEntrega(int producto){
    this.productoEntrega = producto; 
  }
  
  public void setFolioEntrega(int folio){
    this.folioEntrega = folio;
  }
  
  public void setNombreProveedor(String nombre){
    this.nombreProveedor = nombre;
  }
  
  public void setFechaEntrega(String fecha){
    this.fechaEntrega = fecha;
  }
  
  public void setCantidadProductoEntrega(int cantidad){
    this.cantidadProductoEntrega = cantidad;
  }
  
  public void setValorEntrega(double valor){
    this.valorEntrega = valor;
  }
  
  //Métodos get
  public int getProductoEntrega(){
   return productoEntrega; 
  }
  
  public int getFolioEntrega(){
    return folioEntrega;
  }
  
  public String getNombreProveedor(){
    return nombreProveedor;
  }
  
  public String getFechaEntrega(){
    return fechaEntrega;
  }
  
  public int getCantidadProductoEntrega(){
    return cantidadProductoEntrega;
  }
  
  public double getValorEntrega(){
    return valorEntrega;
  }
  
  //Métodos de la clase
  //Método para cuando se entrega un nuevo producto
  public static void entregaNuevoProducto(String nombreProd, String marcaProd, double precioProd, int cantidadEntregada, String nombreProv,String fechaEntrega) throws IOException{
   
    //Se crean los objetos necesarios para crear un nuevo cliente y guararlo en el archivo de texto
    //Esta será la nueva entrega
    EntregaProveedor estaEntrega = new EntregaProveedor();
    //Este será el producto entregado
    Producto productoEntregado = new Producto();
    //Se crea el objeto para poder accesar a los archivos de texto
    ArchivosBinarios ab = new ArchivosBinarios();
    //Se llena el arreglo con los datos de los productos en inventario
    Producto[] arrProducto = ab.llenarArregloProducto();
    
    //Se establece el código del producto nuevo 
    productoEntregado.setCodigoProducto(arrProducto.length+1);
    //Se guarda del código del producto en el registro de ventas
    estaEntrega.setProductoEntrega(productoEntregado.getCodigoProducto());
    
    //Se establece el nombre del nuevo producto
    productoEntregado.setNombreProducto(nombreProd);
    
    //Marca nuevo producto
    productoEntregado.setMarcaProducto(marcaProd);
    
    //Precio al consumidor nuevo producto
    productoEntregado.setPrecioProducto(precioProd);
    
    //Cantidad entregada
    //Se establece el stock inicial del producto
    productoEntregado.setStockProducto(cantidadEntregada); 
    //Se guarda en el registro de esta entrega
    estaEntrega.setCantidadProductoEntrega(cantidadEntregada);
    
    //Valor de la entrega (se calcula multiplicando la cantidad entregada por el precio del producto)
    estaEntrega.setValorEntrega(estaEntrega.getCantidadProductoEntrega()*productoEntregado.getPrecioProducto());
    
    //Nombre del proveedor
    estaEntrega.setNombreProveedor(nombreProv);

    //Fecha de la entrega
    estaEntrega.setFechaEntrega(fechaEntrega);
    
    //Folio entrega
    EntregaProveedor[] arrEntrega = ab.llenarArregloEntrega();
    //El folio es el numero siguiente del total de entregas registradas 
    estaEntrega.setFolioEntrega(arrEntrega.length+1);
    
    //Guardar la nueva entrega en el archivo de entregas
    PrintWriter out1 = new PrintWriter(new FileOutputStream("Entregas.txt", true));
    out1.println(estaEntrega.getProductoEntrega() + "#" + estaEntrega.getFolioEntrega() + "#" + estaEntrega.getNombreProveedor() + "#" + estaEntrega.getFechaEntrega() + "#" + estaEntrega.getCantidadProductoEntrega() + "#" + estaEntrega.getValorEntrega());
    out1.close();
     
     //Guardar el nuevo producto en el archivo de inventario
     PrintWriter out2 = new PrintWriter(new FileOutputStream("Inventario.txt", true));                                 
     out2.println(productoEntregado.getNombreProducto() + "#" + productoEntregado.getCodigoProducto() + "#" + productoEntregado.getMarcaProducto() + "#" + productoEntregado.getPrecioProducto() + "#" + productoEntregado.getStockProducto());
     out2.close();
    
  }
  
  //Método para cuando se registra una entrega de un producto existente
  public static void entregaProducto(int codProducto, int cantidadEntregada, String nombreProveedor, String fecha) throws IOException{

    //Se crean los objetos necesarios para crear un nuevo cliente y guararlo en el archivo de texto
    //Esta será la nueva entrega
    EntregaProveedor estaEntrega = new EntregaProveedor();
    //Se crea el objeto para poder accesar a los archivos de texto
    ArchivosBinarios ab = new ArchivosBinarios();
    //Se llena el arreglo con los datos de los productos en inventario
    Producto[] arrProducto = ab.llenarArregloProducto();
   
    //Guardado del código en el registro de entregas
    estaEntrega.setProductoEntrega(codProducto);
    
    //Cantidad entregada
    //Se actualiza el stock del producto
    arrProducto[codProducto-1].setStockProducto(arrProducto[codProducto-1].getStockProducto() + cantidadEntregada); 
    //Se guarda en el registro de esta entrega
    estaEntrega.setCantidadProductoEntrega(cantidadEntregada);
    
    //Valor de la entrega
    estaEntrega.setValorEntrega(estaEntrega.getCantidadProductoEntrega()*arrProducto[codProducto-1].getPrecioProducto());
    
    //Nombre del proveedor
    estaEntrega.setNombreProveedor(nombreProveedor);
    
    //Fecha de la entrega
    estaEntrega.setFechaEntrega(fecha);

    //Folio entrega
    EntregaProveedor[] arrEntrega = ab.llenarArregloEntrega();
    //El folio es el numero sigueinte del total de entregas registradas 
    estaEntrega.setFolioEntrega(arrEntrega.length+1);
    //System.out.println("El folio de esta entrega es: " + estaEntrega.getFolioEntrega());
    
    //Se guarda la nueva entrega en el archivo de entregas
    PrintWriter out1 = new PrintWriter(new FileOutputStream("Entregas.txt", true));
    out1.println(estaEntrega.getProductoEntrega() + "#" + estaEntrega.getFolioEntrega() + "#" + estaEntrega.getNombreProveedor() + "#" + estaEntrega.getFechaEntrega() + "#" + estaEntrega.getCantidadProductoEntrega() + "#" + estaEntrega.getValorEntrega());
    out1.close();
    
    //Se guarda el arreglo de productos actualizado en el archivo de productos
    ab.guardarArchProducto(arrProducto);
    
  }
  
}