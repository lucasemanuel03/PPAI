package org.example.Modelos;
import java.time.LocalDate;
import java.util.Date;
public class Resena {
    private String comentario;
    private Boolean esPremium;
    private LocalDate fechaResena;
    private Float puntaje;
    private Vino vino;

    public Resena(String comentario, Boolean esPremium, LocalDate fechaResena, float puntaje, Vino vino) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaResena = fechaResena;
        this.puntaje = puntaje;
        this.vino = vino;
    }
    //Generar la reseña sin el vino, para agregarlo despues
    public Resena(String comentario, Boolean esPremium, LocalDate fechaResena, float puntaje) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaResena = fechaResena;
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getEsPremium() {
        return esPremium;
    }

    public void setEsPremium(Boolean esPremium) {
        this.esPremium = esPremium;
    }

    public Date getFechaResena() {
        return fechaResena;
    }

    public void setFechaResena(Date fechaResena) {
        this.fechaResena = fechaResena;
    }

    public float getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(float puntaje) {
        this.puntaje = puntaje;
    }

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }
}
