/*Armando Roque Villasana A01138717
Ultima edicion: 18/10/2017
Clase Producto
*/

public class Producto{
  
  private String nombreProducto;
  private String marcaProducto;
  private int codigoProducto;
  private double precioProducto;
  private int stockProducto;
  
  //Constructores
    //Constructor sin parámetros
  public Producto(){
    this.nombreProducto = "";
    this.marcaProducto = "";
    this.codigoProducto = 0;
    this.precioProducto = 0;
    this.stockProducto = 0;
  }
  
    //Constructor con parámetos
  public Producto(String nombre, String marca, int codigo, double precio, int stock){
    this.nombreProducto = nombre;
    this.marcaProducto = marca;
    this.codigoProducto = codigo;
    this.precioProducto = precio;
    this.stockProducto = stock;
  }

  //Métodos set
  public void setNombreProducto(String nombre){
   this.nombreProducto = nombre; 
  }
  
  public void setMarcaProducto(String marca){
   this.marcaProducto = marca; 
  }
  
  public void setCodigoProducto(int codigo){
   this.codigoProducto = codigo; 
  }
  
  public void setPrecioProducto(double precio){
   this.precioProducto = precio; 
  }
  
  public void setStockProducto(int stock){
   this.stockProducto = stock; 
  }
  
  //Métodos get
  public String getNombreProducto(){
   return nombreProducto; 
  }
  
  public String getMarcaProducto(){
   return marcaProducto; 
  }
  
  public int getCodigoProducto(){
   return codigoProducto; 
  }
  
  public double getPrecioProducto(){
   return precioProducto; 
  }
  
  public int getStockProducto(){
   return stockProducto; 
  }  
  
}