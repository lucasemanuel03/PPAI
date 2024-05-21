package org.example.Clases;
import java.util.Date;
public class Resena {
    private String comentario;
    private Boolean esPremium;
    private Date fechaResena;
    private float puntaje;
    private Vino vino;

    public Resena(String comentario, Boolean esPremium, Date fechaResena, float puntaje, Vino vino) {
        this.comentario = comentario;
        this.esPremium = esPremium;
        this.fechaResena = fechaResena;
        this.puntaje = puntaje;
        this.vino = vino;
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
