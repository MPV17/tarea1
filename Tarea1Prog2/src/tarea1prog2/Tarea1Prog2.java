
package tarea1prog2;

import java.util.ArrayList;
import java.util.Date;

class Efectivo extends Pago{
    public Efectivo(float m,Date f){
        super(m,f);
    }
    public float calcDevolucion(float precio,float monto){
        if(monto > precio){
            return monto - precio;
        }
        else return 0;
    }
    public String toString(){
        return "Los datos del pago son\nTipo : Efectivo" + super.toString();
    }
}
class Transferencia extends Pago{
    private String Banco;
    private String numCuenta;
    public Transferencia(float m, Date f,String b,String nc){
        super(m,f);
        Banco = b;
        numCuenta = nc;
    }
    public String toString(){
        return "Los datos del pago son\nTipo : Transferencia" + super.toString() + "\nBanco : " + Banco + "\nNumero de Cuenta : " + numCuenta;
    }
}
class Tarjeta extends Pago{
    private String Tipo;
    private String numTransaccion;
    public Tarjeta(float m, Date f,String t,String nt){
        super(m,f);
        Tipo = t;
        numTransaccion = nt;
    }
    public String toString(){
        return "Los datos del pago son\nTipo : Tarjeta" + super.toString() + "\nTipo : " + Tipo + "\nNumero de Transaccion : " + numTransaccion;
    }
}
class Pago{
    private float monto;
    private Date fecha;
    public Pago(float m,Date f){
        monto = m;
        fecha = f;
    }
    public String toString(){
        return "\nMonto : " + monto + "CLP\nFecha : " + fecha; 
    }
    public float getMonto(){
        return monto;
    }
}

class Boleta extends DocTributario{
    public Boleta(String n,String r,Date f){
        super(n,r,f);
    }
    public String toString(){
        return "Los datos de la Boleta son:\nNumero: " + super.getNumero() + "\nRut: " + super.getRut() + "\nFecha: " + super.getFecha();
    }
}
class Factura extends DocTributario{
    public Factura(String n,String r,Date f){
        super(n,r,f);
    }
    public String toString(){
        return "Los datos de la Factura son:\nNumero: " + super.getNumero() + "\nRut: " + super.getRut() + "\nFecha: " + super.getFecha();
    }
}
class DocTributario{
    private String numero;
    private String rut;
    private Date fecha;
    public DocTributario(String n,String r, Date f){
        numero = n;
        rut= r;
        fecha = f;
    }
    public String toString(){
        return "Los datos del Documento Tributario son:\nNumero: " + numero + "\nRut: " + rut + "\nFecha: " + fecha;
    }
    public String getNumero(){
        return numero;
    }
    public String getRut(){
        return rut;
    }
    public Date getFecha(){
        return fecha;
    }
}
class Direccion{
    private String direccion;
    public Direccion(String d){
        direccion = d;
    }
    public String getDireccion(){
        return direccion;
    }
    public String toString(){
        return direccion;
    }
}
class Cliente{
    private String nombre;
    private String rut;
    public Cliente(String n,String r){
        nombre = n;
        rut = r;
    }
    public String getnombre(){
        return nombre;
    }
    public String getrut(){
        return rut;
    }
    public String toString(){
        return "Los datos del cliente son: \nNombre: " + nombre + " \nRut: " + rut;
    }
}
class Articulo{
    private float peso;
    private String nombre;
    private String descripcion;
    private float precio;
    public Articulo(float pe,String n, String d,float pr){
        peso = pe;
        nombre = n;
        descripcion = d;
        precio = pr;
    }
    public float getpeso(){
        return peso;
    }
    public float getprecio(){
        return precio;
    }
    public String toString(){
        return "\nNombre: " + nombre + "\nDescripcion: " + descripcion + "\nPrecio: " + precio + " CLP\nPeso: " + peso + " kg";
    }
}
class DetalleOrden{
    private int cantidad;
    public DetalleOrden(int c){
        cantidad = c;
    }
    public int getCantidad(){
        return cantidad;
    }
    public float calcPrecio(){
        
    }
    public float calcPrecioSinIVA(){
        
    }
    public float calcIVA(){
        
    }
    public float calcPeso(){
        
    }
    public String toString(){
        return "Los datos del detalle de orden son\nCantidad : " + cantidad;
    }
    
    
}
class OrdenCompra{
    private Date fecha;
    private String estado;
    private ArrayList<DetalleOrden> DetalleOrdenAR;
    public OrdenCompra(Date f, String e){
        fecha = f;
        estado = e;
        DetalleOrdenAR = new ArrayList();
    }
    public void add(DetalleOrden DO){
       DetalleOrdenAR.add(DO); 
    }
    public DetalleOrden getDetalleOrden(int i){
        return DetalleOrdenAR.get(i);
    }
    public int sizeDetalleOrdenAR(){
        return DetalleOrdenAR.size();
    }
    public float calcPrecio(){
        
    }
    public float calcPrecioSinIVA(){
        
    }
    public float calcIVA(){
        
    }
    public float calcPeso(){
        
    }
    public String toString(){
        return "Los datos de la Orden de Compra son\nEstado : " + estado + "\nFecha : " + fecha;
    }
}
        
public class Tarea1Prog2 {
    public static void main(String[] args) {
        
    }
    
}
