package uy.edu.ude.app.dto;

/**
 * Created by juan on 07/07/17.
 */

public class Usuario {
  private String id;
  private String nombre;
  private int edad;
  private String correo;

  public Usuario(String id, String nombre, int edad, String correo) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
    this.correo = correo;
  }

  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public int getEdad() {
    return edad;
  }

  public String getCorreo() {
    return correo;
  }
}